package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.*;
import com.gi.ctdn.pojo.*;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
		try {
			String code=personComExpr.getCode();
			String type=personComExpr.getType();
			if(StringUtils.isEmpty(code)||StringUtils.isEmpty(type)){
                return errorRet;
            }
			List<PersonComExpr> personComExprs = biz.queryPersonComExpr(code, type);
			MessageInfo<List<PersonComExpr>> messageInfo = new MessageInfo<>();
			messageInfo.setData(personComExprs);
			return messageInfo;
		} catch (Exception e) {
			return errorRet;
		}
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
