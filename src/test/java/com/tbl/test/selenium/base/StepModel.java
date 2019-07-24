package com.tbl.test.selenium.base;

public class StepModel {
	// 步骤
	String step;
	// 元素（地址）
	String element;
	// 前置条件
	String precondition;
	// 元素类型
	String type;
	// 动作
	String action;
	// 参数值
	String value;
	// 期望结果
	String expectation;
	// 对象（类型），driver 或 web element
	String object;
	
    

	public String getStep() {
		return step;
	}



	public void setStep(String step) {
		this.step = step;
	}



	public String getElement() {
		return element;
	}



	public void setElement(String element) {
		this.element = element;
	}



	public String getPrecondition() {
		return precondition;
	}



	public void setPrecondition(String precondition) {
		this.precondition = precondition;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getAction() {
		return action;
	}



	public void setAction(String action) {
		this.action = action;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	public String getExpectation() {
		return expectation;
	}



	public void setExpectation(String expectation) {
		this.expectation = expectation;
	}



	public String getObject() {
		return object;
	}



	public void setObject(String object) {
		this.object = object;
	}



	@Override
	public String toString() {
		return "StepModel [step=" + step + ", element=" + element + ", type=" + type + ", value=" + value + ", expectation="
				 + expectation + ", object=" + object + ", action=" + action + "]" + "\n";
	}
	
}
