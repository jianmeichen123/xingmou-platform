package com.gi.ctdn.api.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gi.xm.platform.utils.AuthRequest;
import com.gi.xm.platform.utils.PWDUtils;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import springfox.documentation.spring.web.json.Json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zcy on 17-12-21.
 */
@Configuration
public class PublicSeaRequest {
    private static final Logger logger = LoggerFactory.getLogger(AuthRequest.class);

    @Value("${publicseaUrl}")
    private String publicseaUrl;

    private RestTemplate template = new RestTemplate();


    public JSONObject getDictByType (String type){
        String url =  publicseaUrl + "comminterface/getDictByType";
        Map<String,Object> qMap = new HashedMap();
        qMap.put("dictCode",type);
        JSONArray valueJson = null;
        List<Map<String,Object>> list = null;
        String result = QHtmlClient.get().post(url,null,qMap);
        JSONObject resultJson = JSONObject.parseObject(result);
        if(resultJson != null && resultJson.containsKey("connectSuccess")) {
            Integer connectSuccess = resultJson.getInteger("connectSuccess");
            logger.error("服务器返回正常,获取数据失败");
        }
        return resultJson;
    }


    public String saveProject(JSONObject jsonObject){
        String url = publicseaUrl+"brain/saveProject";
        Map<String,Object> qMap = new HashedMap();
        JSONArray valueJson = null;
        String result = QHtmlClient.get().post(url,null,jsonObject);
        return result;
    }

    public String getProject(JSONObject jsonObject){
        String url = publicseaUrl+"brain/getProject";
        Map<String,Object> qMap = new HashedMap();
        JSONArray valueJson = null;
        String result = QHtmlClient.get().post(url,null,jsonObject);
        return result;
    }
}
