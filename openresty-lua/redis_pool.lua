local redis = require("resty.redis")
local cjson = require("cjson")
local redis_pool = {}
--连接redis
function redis_pool:get_connect()
    if ngx.ctx[redis_pool] then
        return true,"redis连接成功",ngx.ctx[redis_pool]
    end
    local red = redis:new()
    red:set_timeout(1000) -- 1 sec
    local ok, err = red:connect(conf.redis()['host'],conf.redis()['port'])
    if not ok then
	    return false,"failed to connect redis"
    end
    --设置redis密码
    local count, err = red:get_reused_times()
    if 0 == count then
        ok, err = red:auth(conf.redis()['pass'])
        if not ok then
            return false,"redis failed to auth"
        end
    elseif err then
        return false,"redis failed to get reused times"
    end
    --选择redis数据库
    ok, err = red:select(conf.redis()['db'])
    if not ok then
        return false,"redis connect failed "
    end
    --建立redis连接池
    ngx.ctx[redis_pool] = red
    return true,'redis连接成功',ngx.ctx[redis_pool]
end

--关闭连接池
function redis_pool:close()
    if ngx.ctx[redis_pool] then
        ngx.ctx[redis_pool]:set_keepalive(60000, 300)
        ngx.ctx[redis_pool] = nil
    end
end

---获取key的值
function redis_pool:get_key(str)
    local res,err,client = self:get_connect()
    if not res then
        return false,err
    end
    local val ,err = client:get(str)

    if  val ~= ngx.null and val ~= nil then
        --ngx.say(val)
        local j = cjson.decode(val)
        local email = j.email
        if email == ngx.null then
            return false,"用户不存在",val
        end
        client:expire(key,604800)
        local ikey = string.format("%s:%s:%s","xm","count",email)
        local v,e = client:incr(ikey)
        return true,"获取key成功",val
    end
    --self:close()
    return false,"获取key成功",val
end
return redis_pool
