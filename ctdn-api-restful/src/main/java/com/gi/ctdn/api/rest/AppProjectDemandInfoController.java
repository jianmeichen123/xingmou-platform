package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.AppProjectDemandBiz;
import com.gi.ctdn.pojo.AppProjectDemand;
import com.gi.ctdn.view.common.MessageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("appProjectDemandInfo")
public class AppProjectDemandInfoController {

    @Autowired
	private AppProjectDemandBiz appProjectDemandBiz;

	private static final Logger logger = LoggerFactory.getLogger(AppProjectDemandInfoController.class);

    @ApiOperation(value = "添加项目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projName", value = "项目名称", required = true, dataType = "String"),
    })

    @RequestMapping(value="insert",method = RequestMethod.POST)
    @ResponseBody
    public MessageInfo<Integer> createAppProjectDemandInfo(@RequestBody  AppProjectDemand appProjectDemand){
		MessageInfo<Integer> messageInfo =  appProjectDemandBiz.createAppProjectDemand(appProjectDemand);
        return messageInfo;
    }

}
