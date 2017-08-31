package com.entity;

import java.util.List;

public class ResultInfo {
     private String message;
     // 0:失败，1：成功
     private int resultCode;
     private List<?> result;
     
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<?> getResult() {
		return result;
	}
	public void setResult(List<?> result) {
		this.result = result;
	}
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
     
     
}
