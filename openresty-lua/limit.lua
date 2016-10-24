--
-- Created by IntelliJ IDEA.
-- User: vincent
-- Date: 16-10-24
-- Time: 下午2:38
-- To change this template use File | Settings | File Templates.
--
reds = require("redis_pool") --引用redis连接池

local _L ={}
function _L:limit()

    local myIP = ngx.req.get_headers()["X-Real-IP"]
    if myIP == nil then
        myIP = ngx.req.get_headers()["x_forwarded_for"]
    end
    if myIP == nil then
        myIP = ngx.var.remote_addr
    end
    reds:incr(myIP)
    local res,err,value = reds:get_key(key)
    ngx.say(value)
end

return _L
