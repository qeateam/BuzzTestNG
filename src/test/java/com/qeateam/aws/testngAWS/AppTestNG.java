package com.qeateam.aws.testngAWS;


import org.testng.annotations.Test;
import 
com.qeateam.aws.testng.utils.GlobalObjects;
public class AppTestNG implements GlobalObjects {

	@Test
	public void validateLogin() {
		System.out.println("This is TestNG-Maven Example");
		try {
			//Launch App
			objGlobal.launchApp();
			//Verify copytext
			objGlobal.genericVerifyCopyText("text1", "netFlixHome", "watchMsg");
			//Click on a Sign In
			objGlobal.genericClick("signInBtn", "netFlixHome");
			//Enter User
			objGlobal.genericEnterText("Test1", "UserName", "emailInputBox", "netFlixLogin");
			//Enter Password
			objGlobal.genericEnterText("Test1", "Password", "emailPsdBox", "netFlixLogin");
			//Click on Login
			objGlobal.genericClick("LoginInBtn", "netFlixLogin");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}