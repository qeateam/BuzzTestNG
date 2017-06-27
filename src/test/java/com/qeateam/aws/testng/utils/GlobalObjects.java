package com.qeateam.aws.testng.utils;

import com.qeateam.aws.testng.utils.Global;
import com.qeateam.aws.testng.utils.InvokeBrowser;

public interface GlobalObjects {
	
	Global objGlobal= new Global(); 
	//ExtentReport objEReporter= new ExtentReport();
	StaxParser objParser= new StaxParser();
	ReadConfigProps objReadConfigProps = new ReadConfigProps();
	InvokeBrowser objInvokeBrowser = new InvokeBrowser();
	JsonDataReader obJsonDataReader = new JsonDataReader();
}
