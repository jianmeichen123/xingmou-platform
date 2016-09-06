package com.gi.xm.platform.biz.common;

/**
 * Created by vincent on 16-9-5.
 */
public enum MessageStatus {
    OK(10000, "成功"),
    SYS_ERROR(10001, "系统繁忙,请稍后重试"),
    SAME_DATA_EXISTS(10002, "%s"),
    DATA_NOT_EXISTS(10003, "%s"),



    // common message
    FIELD_NOT_ALLOWED_EMPTY(10010, "%s不能为空"),
    FIELD_VALUE_MUST_LARGE_THAN(10011, "%s必须大于%2$.2f"),
    FIELD_VALUE_MUST_LESS_THAN(10012, "%s必须小于%2$.2f"),
    FIELD_NOT_EMAIL(10013, "%s格式错误"),
    FIELD_NOT_MOBILE(10014, "%s格式错误"),
    FIELD_NOT_ID_NUM(10015, "%s格式错误"),
    FIELD_NOT_DATE(10016, "%s格式错误"),
    FIELD_LENGTH_MUST_LESS(10017, "%s必须小于%d"),
    FIELD_LENGTH_MUST_MORE(10018, "%s必须大于%d"),
    FIELD_LENGTH_MUST_BETWEEN(10019, "%s长度必须大于%d和小于%d"),
    FILED_NOT_IN_ENUM_VALUES(10020, "不支持的%s"),

    ACTIVITI_ERROR(10100, "activiti工作流引擎错误"),
    ACTIVITI_ILLEGALARGUMENT_ERROR(10101, "参数错误"),

    // api invoke error
    PROCESSDEFINITIONZIP_ZIP_ERROR(20101,"流程定义打包文件错误"),
    PROCESSDEFINITIONZIP_BPMN_ERROR(20102,"流程定义BPMN文件错误"),
    PROCESSDEFINITIONZIP_BPMN_PARSER(20103,"流程定义BPMN文件解析失败"),

    PROCDEF_HAS_RU_PROCINST(201104,"该流程定义有正在运行的流程实例，不能删除"),
    PROCDEF_HAS_HIS_PROCINST(201104,"该流程定义有历史流程实例，不能删除"),

    TASK_ASSIGNEE_ERROR(20201,"该用户没有处理该任务的权限"),
    TASK_DOTASKPARAM_ERROR(20202,"必须确定【处理人和处理角色】其中一个"),
    TASK_NOT_EXISTS(20203,"该任务不存在"),
    TASK_ASSIGNEE_IS_EXISTS(20204,"该任务已被认领或被指定"),
    TASK_ROLE_ERROR(20205,"该用户角色没有处理该任务的权限"),
    TASK_COMPLETED(20206,"该任务已完成"),
    TASK_MUST_HAS_ADD_COMMENT(20207,"非通过任务必须添加批注"),
    TASK_IS_SUSPENDED(20208,"该任务的流程实例已被冻结"),
    TASK_NOT_CLAIM(20209,"该任务没有被认领");

    private int status;
    private String message;

    MessageStatus(
            int status, String message) {
        this.setStatus(status);
        this.setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}