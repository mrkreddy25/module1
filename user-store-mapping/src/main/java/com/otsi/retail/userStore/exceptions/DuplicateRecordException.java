package com.otsi.retail.userStore.exceptions;

//we try  to save any duplicate record it will throw the exception 

public class DuplicateRecordException extends Exception {

	private static final long serialVersionUID = 1L;

	private String msg;

	public DuplicateRecordException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
