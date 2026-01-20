package test;

import model.Login;
import model.LoginLogic;

public class LoginLogicTest {
	public static void main(String[] args) {
		testExcuteOK();
		testExcuteNG();
	}
	public static void testExcuteOK() {
		Login login=new Login("minato","1234");
		LoginLogic bo = new LoginLogic();
		boolean result=bo.execute(login);
		if(result) {
			System.out.println("成功しました");
		}else {
			System.out.println("失敗しました");
		}
	}
	public static void testExcuteNG() {
		Login login=new Login("minato","12345");
		LoginLogic bo = new LoginLogic();
		Boolean result=bo.execute(login);
		if(!result) {
			System.out.println("testExcuteNG:成功しました");
			
		}else
			System.out.println("testExcuteNG:失敗しました")	;
	}

}
