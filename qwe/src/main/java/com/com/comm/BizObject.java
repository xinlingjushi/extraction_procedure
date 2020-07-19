package com.com.comm;

/**
 * 
 * @author jinyihao
 * param       success	true-调用成功false-调用失败
               code	int	编码20401 等
			   message	string	提示信息
			   data	json	实际的返回参数，
 */
public class BizObject {

	private boolean success = true;
	private int code = 200;
	private String message = "OK";
	private Object data;

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
