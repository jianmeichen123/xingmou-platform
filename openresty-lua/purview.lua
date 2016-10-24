--调用json公共组件
cjson = require("cjson")
fun = require("fun") -- 引用公用方法文件
conf = require("ini") --引用配置文件
reds = require("redis_pool") --引用redis连接池
--mysqld = require("ttq.mysql_pool") --引用mysql连接池
--参数校验
check_arg = fun:check_cookie_arg() --调用参数校验方法
if check_arg['status']  then
    --参数校验通过，获取返回的参数，并将参数拼接
    key = string.format("%s:%s:%s","xm",check_arg['s_'],check_arg['_uid_'])
else
    --ngx.say(fun:resJson(-1,check_arg['msg']))
    ngx.exit(ngx.HTTP_UNAUTHORIZED)
    return;
end

--1.首先通过redis查找
local res,err,value = reds:get_key(key)
if not res then
    --ngx.say(fun:resJson(-1,"系统繁忙,请稍后"))
    ngx.exit(ngx.HTTP_FORBIDDEN)
    return
else
    if value == nil or value == "null" or value == ngx.null then
        --ngx.say(fun:resJson(-1,"无权限"))
        ngx.exit(ngx.HTTP_UNAUTHORIZED)
        return
    end
end

--3.redis找到了信息鉴权成功
--ngx.say(fun:resJson(0,"该项目鉴权成功,可以访问!"))
