package com.itwill.hello;

public class Hello {
	private String msg;
	
	public Hello() {
	}

	public Hello(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Hello [msg=" + msg + "]";
	}
	
}
