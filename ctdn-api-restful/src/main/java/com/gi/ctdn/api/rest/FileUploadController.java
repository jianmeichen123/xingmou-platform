package com.gi.ctdn.api.rest;

import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zcy on 17-11-15.
 */
@Controller
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Value("${rootPath}")
    private  String rootPath;

    @RequestMapping(value="/upload")
    @ResponseBody
    public MessageInfo<String> upload(@RequestParam(value="file") MultipartFile file, HttpServletRequest request) {
            MessageInfo<String> messageInfo = new MessageInfo<String>();
            String fileName = null;
            try {
                //上传文件
               // Date d = new Date();
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                String dateNowStr = sdf.format(d);

                fileName = file.getOriginalFilename();
                String dir =rootPath + "/" ;
                File uploadDir = new File(dir);
                if(!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                File target = new File(dir+fileName);
                FileOutputStream fops = new FileOutputStream(target);
                // 将上传的文件信息保存到相应的文件目录里
                fops.write(file.getBytes());
                fops.close();

                messageInfo.setStatus(MessageStatus.OK_CODE);
                messageInfo.setMessage(MessageStatus.OK_MESSAGE);
                logger.info(String.format("上传文件[%s]成功", fileName));
            } catch (Exception e) {
                messageInfo.setStatus(MessageStatus.ERROR_CODE);
                messageInfo.setMessage(MessageStatus.ERROR_MESSAGE);
                logger.error(String.format("上传文件[%s]失败", fileName), e);
            }
            messageInfo.setData(fileName);
            return messageInfo;
    }
}
