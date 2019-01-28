package com.controller.htpdf;
//¿ØÖÆÆ÷Àà
public class BaseController {
	public BaseResult resultSuccess(String message){
		BaseResult baseResult=new BaseResult();
		baseResult.setCode(1);
		baseResult.setMessage(message);
		return baseResult;
	} 
	public BaseResult resultError(String message){
		BaseResult baseResult=new BaseResult();
		baseResult.setCode(0);
		baseResult.setMessage(message);
		return baseResult;
	}
}
