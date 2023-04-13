package com.kms.commonKeywords

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class DirectoryPage {
	
	@Keyword
	public void verifyInfoEmployeeInDirectory(TestObject, String eInfo) {
		List<WebElement> infoEmployee = WebUiCommonHelper.findWebElements(TestObject, GlobalVariable.longTime)
		for(int i=0; i < infoEmployee.size(); i++) {
			String info = infoEmployee.get(i).getText()
			if(!info.equals("")) {
			println(info)
			WebUI.verifyMatch(info, eInfo, false, FailureHandling.CONTINUE_ON_FAILURE)
			}
			else {
				println('No employee meets condition')
			}
		}
	}
}
