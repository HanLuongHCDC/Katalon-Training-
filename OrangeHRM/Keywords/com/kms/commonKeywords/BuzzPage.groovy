package com.kms.commonKeywords

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class BuzzPage {

	@Keyword
	public String getDate() {
		Date date = new Date();
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String formatDateTime = dateTimeFormat.format(date);
		System.out.println(formatDateTime);
		return formatDateTime
	}

	@Keyword
	public void getBuzzPost(testObject, String userPost) {
		List<WebElement> listPost = WebUiCommonHelper.findWebElements(testObject, GlobalVariable.longTime)
		List<String> infoPost = new ArrayList<String>()
		for(int i = 0; i > listPost.size(); i++) {
			WebUI.verifyElementText(findTestObject('Object Repository/TC010_VerifyDashboardChart/postUser'), date, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	@Keyword
	public String getFullName() {
		//Click on My Info in toggle menu
		WebUI.click(findTestObject('Object Repository/CommonTestObject/clkItem', [('item') : 'My Info']), FailureHandling.STOP_ON_FAILURE)
		String firstName = WebUI.getAttribute(findTestObject('Object Repository/TC010_VerifyDashboardChart/fullName',[('fullName') : 'firstName']),'value', FailureHandling.CONTINUE_ON_FAILURE)
		String middleName = WebUI.getAttribute(findTestObject('Object Repository/TC010_VerifyDashboardChart/fullName',[('fullName') : 'middleName']),'value', FailureHandling.CONTINUE_ON_FAILURE)
		String lastName = WebUI.getAttribute(findTestObject('Object Repository/TC010_VerifyDashboardChart/fullName',[('fullName') : 'lastName']),'value', FailureHandling.CONTINUE_ON_FAILURE)
		String fullNameEmployee = firstName + " " + middleName + " " + lastName
		println(fullNameEmployee)
		return fullNameEmployee
	}
}
