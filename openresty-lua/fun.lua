local _M = {}

--返回json信息公用方法
function _M:resJson(status,mes)
	local arr_return = {}
	arr_return['status'] = status
	arr_return['msg'] = mes
	return cjson.encode(arr_return)
end



--字符串按指定字符拆分公用方法
function _M:lua_string_split(str, split_char)    
    local sub_str_tab = {}; 
    while (true) do        
        local pos = string.find(str, split_char);  
        if (not pos) then            
            local size_t = table.getn(sub_str_tab)
            table.insert(sub_str_tab,size_t+1,str);
            break;  
            end
    
        local sub_str = string.sub(str, 1, pos - 1);              
        local size_t = table.getn(sub_str_tab)
        table.insert(sub_str_tab,size_t+1,sub_str);
        local t = string.len(str);
        str = string.sub(str, pos + 1, t);   
    end    
    return sub_str_tab;
end


-- 检测 cookie合法
function _M:check_cookie_arg()
    local t = {}
    local status = true
    if ngx.var.http_cookie then

        local _uid_ = ngx.var.cookie__uid_
        local s_   = ngx.var.cookie_s_
        if _uid_ == nil or string.len(_uid_) == 0 or  s_== nil or string.len(s_) ==0 then
            status = false
        else
            t['_uid_'] = _uid_
            t['s_'] = s_
        end
    else
        status =false
    end
    t['status'] = status

    return t
end


return _M
