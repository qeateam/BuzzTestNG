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
	
	//#########################START: This section contains tests for Home page validations#######################
	
	//Test Description - This validates existance and text for Hoome Navigation Link
	//Date - 29 Jun 17
	//Created By - Sumanta Roy
	@Test
	public void validateHomeNavigationLink(){
		try{
			//Launch App
			objGlobal.launchApp();
			//Click on Home 
			objGlobal.genericClick("homeLink", "petclinicHome");
			//Verify Home Welcome message
			objGlobal.genericVerifyCopyText("text1", "petclinicHome", "welcomeMsgObj");
		}catch(Exception e){
			objGlobal.mainLogger.error(e);
		}
	}
	
	//#########################END: This section contains tests for Home page validations#######################
	
	
	/*@Test
	public void addUserToSampleApp(){
		try{
			//Launch App
			objGlobal.launchApp();
			//Click on a Add User
			objGlobal.genericClick("addUserBtn", "sampleAppHome");
			//Enter FirstName
			objGlobal.genericEnterText("Test1", "UserName", "emailInputBox", "netFlixLogin");
		}catch (Exception e){
			e.printStackTrace();
		}
	}*/
	
}