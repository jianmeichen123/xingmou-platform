

package com.gi.ctdn.service;

import com.gi.ctdn.api.IndustryService;
import com.gi.ctdn.biz.IndustryBiz;
import com.gi.ctdn.dao.IndustryDAO;
import com.gi.ctdn.pojo.Industry;
import com.gi.xm.platform.view.common.MessageInfo;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@MotanService
public class IndustryServiceImpl implements IndustryService {


    @Autowired
	IndustryBiz industryBiz;

    @Override
    public String getAllIndustry(){
		return industryBiz.getAllIndustry().toString();
	}

}