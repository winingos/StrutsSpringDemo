package org.crazyit.app.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class MyAction extends ActionSupport {
	private String target;
	private String tip;
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String excute() throws Exception {
		
		setTip("¹§Ï²ÄãµÇÂ¼³É¹¦");
		return "SUCCESS";
	}
}
