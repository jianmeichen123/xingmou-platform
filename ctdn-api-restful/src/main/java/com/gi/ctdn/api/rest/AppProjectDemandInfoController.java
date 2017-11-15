package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.AppProjectDemandBiz;
import com.gi.ctdn.pojo.AppProjectDemand;
import com.gi.ctdn.view.common.MessageInfo;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("appProjectDemandInfo/index", modelMap);
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Integer> createAppProjectDemandInfo(AppProjectDemand appProjectDemand){
		MessageInfo<Integer> messageInfo =  appProjectDemandBiz.createAppProjectDemand(appProjectDemand);
        return messageInfo;
    }

	@RequestMapping(value="/upload", method=RequestMethod.POST)
	@ResponseBody
	public MessageInfo<Integer> upload(
			@RequestParam(value="projPb") MultipartFile file,
			HttpServletRequest request) {
		String fileName = null;
		try {
			//上传文件
			fileName = file.getOriginalFilename();
			String dir = "/home/zcy/tmp/";
			File uploadDir = new File(dir);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs();
			}
			File target = new File(dir);
			file.transferTo(target);
		} catch (Exception e) {
			logger.error(String.format("用户[%s]上传文件[%s]失败", "", fileName), e);
		}
		return null;
	}
}
