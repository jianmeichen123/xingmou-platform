package com.gi.xm.platform.pojo.auth;//package com.gi.xm.platform.auth;

public class AuthResult
{
	private boolean success;
	private String errorCode;
	private String message;
	public boolean isSuccess()
	{
		return success;
	}
	public void setSuccess(boolean success)
	{
		this.success = success;
	}
	public String getErrorCode()
	{
		return errorCode;
	}
	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}


}
