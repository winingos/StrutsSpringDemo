package org.crazyit.app.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class LoginAction extends ActionSupport {
	//�����װ���������username��password����
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
		//���崦���û������execute����
		public String execute() throws Exception
		{
			ActionInvocation invocation = ActionContext.getContext().getActionInvocation();
			invocation.addPreResultListener(new PreResultListener() {
				public void beforeResult(ActionInvocation arg0, String arg1) {
					System.out.println("���ص��߼���ͼ����Ϊ��"+arg1);
					//�ٷ���Result֮ǰ��һ����������ݡ�
					arg0.getInvocationContext().put("extra", new java.util.Date()+"��"+arg1+"�߼���ͼ��ת��");
					//Ҳ�ɼ�����־�ȡ�����
				}
			});
			//��usernameΪcrazyit.org��passwordΪleegangʱ����¼�ɹ�
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
