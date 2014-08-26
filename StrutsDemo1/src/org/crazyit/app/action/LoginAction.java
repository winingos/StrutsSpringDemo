package org.crazyit.app.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class LoginAction extends ActionSupport {
	//定义封装请求参数的username和password属性
		private String username;
		private String password;
		
		public String getUsername()
		{
			return username;
		}
		public void setUsername(String username)
		{
			this.username = username;
		}
		
		public String getPassword()
		{
			return password;
		}
		public void setPassword(String password)
		{
			this.password = password;
		}
		//定义处理用户请求的execute方法
		public String execute() throws Exception
		{
			ActionInvocation invocation = ActionContext.getContext().getActionInvocation();
			invocation.addPreResultListener(new PreResultListener() {
				public void beforeResult(ActionInvocation arg0, String arg1) {
					System.out.println("返回的逻辑视图名字为："+arg1);
					//再返回Result之前加一个额外的数据。
					arg0.getInvocationContext().put("extra", new java.util.Date()+"由"+arg1+"逻辑视图名转入");
					//也可加入日志等。。。
				}
			});
			//当username为crazyit.org，password为leegang时即登录成功
			if (getUsername().equals("crazyit.org")
				&& getPassword().equals("leegang") )
			{
				ActionContext.getContext().getSession()
					.put("user" , getUsername());
			return SUCCESS;
			}
			else
			{
				return ERROR;
			}
		}
}
