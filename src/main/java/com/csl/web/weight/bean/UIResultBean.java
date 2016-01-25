package com.csl.web.weight.bean;

public class UIResultBean {
    private String resultType;
    private String resultOperator = "none";
    private Object data;
    private String message;

    private UIResultBean() {
    };

    public static UIResultBean getWarnResult(String message) {
	UIResultBean bean = new UIResultBean();
	bean.setMessage(message);
	bean.setResultType(Constant.RESULT_TYPE_WARN);
	return bean;
    }

    public static UIResultBean getInfoResult(String message) {
	UIResultBean bean = new UIResultBean();
	bean.setMessage(message);
	bean.setResultType(Constant.RESULT_TYPE_INFO);
	return bean;
    }

    public static UIResultBean getErrorResult(String message) {
	UIResultBean bean = new UIResultBean();
	bean.setMessage(message);
	bean.setResultType(Constant.RESULT_TYPE_ERROR);
	return bean;
    }

    public static UIResultBean getDataResult(Object data) {
	UIResultBean bean = new UIResultBean();
	bean.setData(data);
	bean.setResultType(Constant.RESULT_TYPE_SUCCESS);
	return bean;
    }

    public String getResultType() {
	return this.resultType;
    }

    public void setResultType(String resultType) {
	this.resultType = resultType;
    }

    public Object getData() {
	return this.data;
    }

    public void setData(Object data) {
	this.data = data;
    }

    public String getMessage() {
	return this.message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public String getResultOperator() {
	return this.resultOperator;
    }

    public void setResultOperator(String resultOperator) {
	this.resultOperator = resultOperator;
    }

}
