
local redis = require("resty.redis")
local cjson = require("cjson")
local redis_cache_pool = {}
local nil_data = {}
--连接redis
function redis_cache_pool:get_connect()

    if ngx.ctx[redis_cache_pool] then
        return true,"nginx redis connect success",ngx.ctx[redis_cache_pool]
    end

    local red = redis:new()

    red:set_timeout(1000) -- 1 sec

    local ok, err = red:connect(conf.redis_cache()['host'],conf.redis_cache()['port'])
    if not ok then
        return false,"failed to connect redis"
    end
    --设置redis密码
    local count, err = red:get_reused_times()
    if 0 == count then
        ok, err = red:auth(conf.redis_cache()['pass'])
        if not ok then
            return false,"redis failed to auth"
        end
    elseif err then
        return false,"redis failed to get reused times"
    end
    --选择redis数据库
    ok, err = red:select(1)
    if not ok then
        return false,"redis connect failed "
    end
    --建立redis连接池
    ngx.ctx[redis_cache_pool] = red
    return true,'redis connect success',ngx.ctx[redis_cache_pool]
end

--关闭连接池
function redis_cache_pool:close()
    if ngx.ctx[redis_cache_pool] then
        ngx.ctx[redis_cache_pool]:set_keepalive(60000, 300)
        ngx.ctx[redis_cache_pool] = nil
    end
end

---获取key的值
function redis_cache_pool:get_key(str)
    local res,err,client = self:get_connect()
    if not res then
        return false,err,nil_data
    end
    local val ,err = client:get(str)

    if  val ~= ngx.null and val ~= nil then
        --ngx.say(val)
        local data = cjson.decode(val)
        return true,"get key success",data
    end
    --self:close()
    return false,"get key false",nil_data
end
return redis_cache_pool
