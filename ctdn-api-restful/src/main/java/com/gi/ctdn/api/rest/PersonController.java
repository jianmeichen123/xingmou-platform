package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.*;
import com.gi.ctdn.pojo.*;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.Pagination;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("person")
public class PersonController {

	@Autowired
	private PersonBiz biz;

	private static MessageInfo errorRet = new MessageInfo(MessageStatus.MISS_PARAMETER_CODE,MessageStatus.MISS_PARAMETER_MESSAGE);

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
	/**
	 * 根据code查询创业者
	 */
	@ApiOperation("根据code查创业者")
	@ApiImplicitParam(paramType = "query", dataType = "String", name = "code", value = "创业者code", required = true)
	@RequestMapping(value = "queryStartUpBaseInfo/{code}",method = RequestMethod.GET)
	@ResponseBody
	public MessageInfo<StartUp> queryStartUpBaseInfo(@PathVariable String code){
		if(code== null || StringUtils.isEmpty(code)){
			return errorRet;
		}
		return biz.queryStartUpBaseInfo(code);
	}

	/**
	 * 查询投资人
	 * @param code
	 * @return
	 */
	@ApiOperation("根据code查投资人")
	@ApiImplicitParam(paramType = "query", dataType = "String", name = "code", value = "创业者code", required = true)
	@RequestMapping(value = "queryInvestorBaseInfo/{code}",method = RequestMethod.GET)
	@ResponseBody
	public MessageInfo<Investor> queryInvestorBaseInfo(@PathVariable String code){
		if(code== null || StringUtils.isEmpty(code)){
			return errorRet;
		}
		return biz.queryInvestorBaseInfo(code);
	}


	@ApiOperation("根据code查投资策略")
	@RequestMapping(value = "queryInvestPolicyInfo",method = RequestMethod.POST)
	@ResponseBody
	public MessageInfo<InvestPolicy> queryInvestPolicyInfo(@RequestBody InvestPolicy investPolicy){
		String code= null;
		try {
			code = investPolicy.getCode();
			if(code== null || StringUtils.isEmpty(code)){
                return errorRet;
            }
			MessageInfo<InvestPolicy> messageInfo = new MessageInfo<InvestPolicy>();
			messageInfo.setData(biz.queryInvestPolicyInfo(code));
			return messageInfo;
		} catch (Exception e) {
			return errorRet;
		}
	}

	/**
	 * 根据code,type查询创业者经历
	 */
	@ApiOperation("查询创业者经历")
	@RequestMapping(value = "queryPersonComExpr",method = RequestMethod.POST)
	@ResponseBody
	public MessageInfo<List<PersonComExpr>> queryPersonComExpr(@RequestBody PersonComExpr personComExpr){
		MessageInfo<List<PersonComExpr>> messageInfo = new MessageInfo<>();
		List<PersonComExpr> personComExprs=null;
		try {
			String code=personComExpr.getCode();
			String type=personComExpr.getType();
			if(StringUtils.isEmpty(code)){
				return errorRet;
			}

			PageHelper.startPage(personComExpr.getPageNo()+1, personComExpr.getPageSize());

			personComExprs = biz.queryPersonComExpr(code,type);


			if(personComExpr.getPersonType().equals("I")) {
				PageInfo<PersonComExpr> pageInfo = new PageInfo<PersonComExpr>(personComExprs);
				Pagination page = new Pagination();
				if (personComExprs != null && !personComExprs.isEmpty()) {
					page.setTotal(pageInfo.getTotal());
					page.setRecords(personComExprs);
					messageInfo = new MessageInfo(MessageStatus.OK_CODE, MessageStatus.OK_MESSAGE, page);
					return messageInfo;
				}
			}else{
				messageInfo.setData(personComExprs);
			}
		} catch (Exception e) {
			LOGGER.error("queryPersonComExpr","查询queryPersonComExpr失败", e);
			messageInfo = new MessageInfo(MessageStatus.ERROR_CODE,e.getMessage());
		}
			return messageInfo;
	}

	/**
	 * 根据code,type查询创业者工作经历
	 */
	@ApiOperation("查询创业者工作经历")
	@RequestMapping(value = "queryPersonWorkExpr",method = RequestMethod.POST)
	@ResponseBody
	public MessageInfo<List<PersonWorkExpr>> queryPersonWorkExpr(@RequestBody PersonWorkExpr personWorkExpr){
		try {
			String code=personWorkExpr.getCode();
			String type=personWorkExpr.getType();
			if(StringUtils.isEmpty(code)|| StringUtils.isEmpty(type)){
                return errorRet;
            }
			MessageInfo<List<PersonWorkExpr>> messageInfo =
					new MessageInfo<List<PersonWorkExpr>>();
			messageInfo.setData(biz.queryPersonWorkExpr(code,type));
			return messageInfo;
		} catch (Exception e) {
			return errorRet;
		}
	}

	/**
	 * 根据code,type查询创业者教育经历
	 */
	@ApiOperation("查询创业者教育经历")
	@RequestMapping(value = "queryPersonEduExpr",method = RequestMethod.POST)
	@ResponseBody
	public MessageInfo<List<PersonEduExpr>> queryPersonEduExpr(@RequestBody PersonEduExpr personEduExpr){
		try {
			String code=personEduExpr.getCode();
			String type=personEduExpr.getType();
			if(StringUtils.isEmpty(code)||StringUtils.isEmpty(type)){
                return errorRet;
            }
			MessageInfo<List<PersonEduExpr>> messageInfo =
					new MessageInfo<List<PersonEduExpr>>();
			messageInfo.setData(biz.queryPersonEduExpr(code,type));
			return messageInfo;
		} catch (Exception e) {
			return errorRet;
		}
	}
}
