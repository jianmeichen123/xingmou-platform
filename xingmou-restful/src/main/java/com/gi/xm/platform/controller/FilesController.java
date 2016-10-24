package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.FilesInfo;
import com.gi.xm.platform.view.FilesQueryInfo;
import com.gi.xm.platform.facede.FilesFacede;

@Controller
@RequestMapping("files")
public class FilesController {

	@Reference(check = false)
	private FilesFacede filesFacede;


	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<FilesInfo>>  queryFiles (FilesQueryInfo filesQueryInfo) {
		MessageInfo<QueryResultInfo<FilesInfo>> resultMessageInfo = filesFacede.queryFiles(filesQueryInfo);
		return resultMessageInfo;
	}
/*

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createFiles(FilesInfo filesInfo){
        MessageInfo<Long> messageInfo =  filesFacede.createFiles(filesInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateFiles(FilesInfo filesInfo){
		MessageInfo<Integer> messageInfo =  filesFacede.updateFiles(filesInfo);
		return messageInfo;
	}
*/

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<FilesInfo> getFiles( Long id ){
		MessageInfo<FilesInfo> messageInfo =  filesFacede.getFiles(id);
		return messageInfo;
	}
/*

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<FilesInfo>> getAllFiles(){
		MessageInfo<List<FilesInfo>>  messageInfo = filesFacede.getAllFiles();
		return messageInfo;
	}
*/

}
