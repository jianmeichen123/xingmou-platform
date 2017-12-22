package com.gi.ctdn.api.rest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gi.ctdn.api.util.PublicSeaRequest;
import com.gi.ctdn.pojo.AppProjectDemand;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.Pagination;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.spring.web.json.Json;

import java.util.Map;

/**
 * Created by zcy on 17-12-21.
 */
@Controller
@RequestMapping("/publicsea")
public class PublicSeaController {

    private static final Logger logger = LoggerFactory.getLogger(PublicSeaController.class);

    @Autowired
    private PublicSeaRequest publicSeaRequest;

    @ApiOperation(value = "请求地区,行业,轮次接口")
    @RequestMapping(value="comQuery",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject comQuery(){
        JSONObject result = new JSONObject();
        JSONObject area =  publicSeaRequest.getDictByType("area");
        JSONObject round =  publicSeaRequest.getDictByType("round");
        JSONObject industry =  publicSeaRequest.getDictByType("industry");
        Integer areaStatus = area.getInteger("connectSuccess");
        if(areaStatus != null && areaStatus==1) {
            JSONArray areaArray = area.getJSONObject("result").getJSONArray("value");
            result.put("area",areaArray);
        }else{
            logger.error("请求地区接口失败:服务器返回状态码非200");
        }

        Integer roundStatus = round.getInteger("connectSuccess");
        if(roundStatus != null && roundStatus==1) {
            JSONArray roundArray = round.getJSONObject("result").getJSONArray("value");
            result.put("round",roundArray);
        }else{
            logger.error("请求轮次接口失败:服务器返回状态码非200");
        }

        Integer industryStatus = industry.getInteger("connectSuccess");
        if(industryStatus != null && industryStatus==1) {
            JSONArray industryArray = industry.getJSONObject("result").getJSONArray("value");
            result.put("industry",industryArray);
        }else{
            logger.error("请求行业接口失败:服务器返回状态码非200");
        }
        return result;
    }

    @ApiOperation("插入公海项目")
    @RequestMapping(value="insertProject",method = RequestMethod.POST)
    @ResponseBody
    public MessageInfo insertProject(@RequestBody  JSONObject json){
        MessageInfo messageInfo = new MessageInfo();
        if(!json.containsKey("userId") || json.get("userId").equals("")){
           return new MessageInfo(MessageStatus.NO_LOGIN,MessageStatus.NO_LOGIN_MESSAGE);
        }
        boolean flag = checkJson(json);
        if(!flag){
            return  new MessageInfo(MessageStatus.MISS_PARAMETER_CODE,MessageStatus.MISS_PARAMETER_MESSAGE);
        }
        if(json.containsKey("projectShareRatio") && StringUtils.isEmpty(json.get("projectShareRatio"))){
            json.remove("projectShareRatio");
        }
        if(json.containsKey("projectContribution") && StringUtils.isEmpty(json.get("projectContribution"))){
            json.remove("projectContribution");
        }
        json.put("projectSource","brain");
        json.put("bucketName","ctdn");
        json.put("isClaim",0);
        String result =  publicSeaRequest.saveProject(json);
        JSONObject resultJson = JSONObject.parseObject(result);
        if(resultJson != null && resultJson.containsKey("connectSuccess")) {
            if(resultJson.getJSONObject("result").getInteger("success") ==0){
                messageInfo = new MessageInfo(MessageStatus.ERROR_CODE,MessageStatus.ERROR_MESSAGE);
                logger.error("服务器返回正常,获取数据失败");
            }
        }
        return messageInfo;
    }

    @ApiOperation("查询公海项目")
    @RequestMapping("queryPubSeaById")
    @ResponseBody
    public MessageInfo queryPubSeaById(@RequestBody  JSONObject jsonObject){
        MessageInfo messageInfo = new MessageInfo();
        if(!jsonObject.containsKey("projectId") || jsonObject.get("projectId") .equals("")){
            return  new MessageInfo(MessageStatus.MISS_PARAMETER_CODE,MessageStatus.MISS_PARAMETER_MESSAGE);
        }
        String result = publicSeaRequest.getProject(jsonObject);
        JSONObject resultJson = JSONObject.parseObject(result);
        if(resultJson != null && resultJson.containsKey("connectSuccess")) {
            Integer connectSuccess = resultJson.getInteger("connectSuccess");
            if(resultJson.getJSONObject("result").getInteger("success") ==0){
                messageInfo = new MessageInfo(MessageStatus.ERROR_CODE,MessageStatus.ERROR_MESSAGE);
                logger.error("服务器返回正常,获取数据失败");
            }else{
                JSONObject  resultObj = resultJson.getJSONObject("result");
                JSONArray array = resultObj.getJSONObject("value").getJSONArray("beanList");
                messageInfo.setData(array);
            }
        }
        return  messageInfo;
    }

    @ApiOperation("查询公海项目列表")
    @RequestMapping("queryPubSeaList")
    @ResponseBody
    public MessageInfo queryPubSeaList(@RequestBody  JSONObject jsonObject){
        MessageInfo messageInfo = new MessageInfo();
        if(!jsonObject.containsKey("userId") || jsonObject.get("userId") .equals("")){
            return new MessageInfo(MessageStatus.NO_LOGIN,MessageStatus.NO_LOGIN_MESSAGE);
        }
        if(!jsonObject.containsKey("isClaim") || jsonObject.get("isClaim") .equals("") ||
                !jsonObject.containsKey("pageNo") || jsonObject.get("pageNo").equals("")||
                !jsonObject.containsKey("pageSize") || jsonObject.get("pageSize").equals("")){
            return new MessageInfo(MessageStatus.MISS_PARAMETER_CODE,MessageStatus.MISS_PARAMETER_MESSAGE);
        }
        String result = publicSeaRequest.getProject(jsonObject);
        JSONObject resultJson = JSONObject.parseObject(result);
        if(resultJson != null && resultJson.containsKey("connectSuccess")) {
            Integer connectSuccess = resultJson.getInteger("connectSuccess");
            if(resultJson.getJSONObject("result").getInteger("success") ==0){
                logger.error("服务器返回正常,获取数据失败");
                return  new MessageInfo(MessageStatus.ERROR_CODE,MessageStatus.ERROR_MESSAGE);
            }else{
                JSONObject  resultObj = resultJson.getJSONObject("value");
                Long total = resultObj.getLong("resultCount");
                String array = resultObj.getString("beanList");
                Pagination page = new Pagination();
                page.setTotal(total);
                page.setRecords(JSON.parseArray(array,Object.class));
                messageInfo.setPage(page);
            }
        }
        return  messageInfo;
    }

    @ApiOperation("编辑公海项目")
    @RequestMapping(value="editProject",method = RequestMethod.POST)
    @ResponseBody
    public MessageInfo editProject(@RequestBody  JSONObject json){
        MessageInfo messageInfo = new MessageInfo();
        boolean flag = checkJson(json);
        if(!json.containsKey("projectId") || StringUtils.isEmpty(json.get("projectId"))){
            flag = false;
        }
        if(!flag){
            return  new MessageInfo(MessageStatus.MISS_PARAMETER_CODE,MessageStatus.MISS_PARAMETER_MESSAGE);
        }
        if(json.containsKey("projectShareRatio") && StringUtils.isEmpty(json.get("projectShareRatio"))){
            json.remove("projectShareRatio");
        }
        if(json.containsKey("projectContribution") && StringUtils.isEmpty(json.get("projectContribution"))){
            json.remove("projectContribution");
        }
        json.put("projectSource","brain");
        json.put("bucketName","ctdn");
        String result =  publicSeaRequest.saveProject(json);
        JSONObject resultJson = JSONObject.parseObject(result);
        if(resultJson != null && resultJson.containsKey("connectSuccess")) {
            Integer connectSuccess = resultJson.getInteger("connectSuccess");
            if(resultJson.getJSONObject("result").getInteger("success") ==0){
                messageInfo = new MessageInfo(MessageStatus.ERROR_CODE,MessageStatus.ERROR_MESSAGE);
                logger.error("服务器返回正常,获取数据失败");
            }
        }
        return messageInfo;
    }


    private boolean checkJson(JSONObject json){
        boolean flag =true;
        if(!json.containsKey("projectName") || StringUtils.isEmpty(json.get("projectName"))){
            flag = false;
        }
        if(!json.containsKey("area1Name") || StringUtils.isEmpty(json.get("area1Name"))){
            flag = false;
        }
        if(!json.containsKey("area2Name") || StringUtils.isEmpty(json.get("area2Name"))){
            flag = false;
        }
        if(!json.containsKey("projectDescription") || StringUtils.isEmpty(json.get("projectDescription"))){
            flag = false;
        }
        if(!json.containsKey("linkName") ||  StringUtils.isEmpty(json.get("linkName"))){
            flag = false;
        }
        if(!json.containsKey("linkPhone1") || StringUtils.isEmpty(json.get("linkPhone1"))){
            flag = false;
        }
        if(!json.containsKey("fileName") || StringUtils.isEmpty(json.get("fileName"))){
            flag = false;
        }
        if(!json.containsKey("fileKey") ||  StringUtils.isEmpty(json.get("fileKey"))){
            flag = false;
        }
        if(!json.containsKey("fileSize") || StringUtils.isEmpty(json.get("fileSize"))){
            flag = false;
        }
        if(!json.containsKey("fileUrl") || StringUtils.isEmpty(json.get("fileUrl"))){
            flag = false;
        }
        return flag;
    }
}
