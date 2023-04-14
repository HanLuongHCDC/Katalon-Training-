package com.kms.commonKeywords

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
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

	@Keyword
	public void verifySortAscFunction(TestObject, Boolean ascending, Boolean isRemovedSort) {
		List<WebElement> sortInfo = WebUiCommonHelper.findWebElements(TestObject, GlobalVariable.longTime)
		List<String> originalCell = new ArrayList<String>()
		List<String> tempCell = new ArrayList<String>()
		for(int i=0; i < sortInfo.size(); i++) {
			String cell = sortInfo.get(i).getText()
			originalCell.add(cell.toLowerCase())
			tempCell.add(cell.toLowerCase())
		}
		if(ascending) {
			Collections.sort(tempCell)
		}
		else {
			Collections.sort(tempCell, Collections.reverseOrder())
		}
		println(originalCell)
		println(tempCell)
		if(originalCell.equals(tempCell)) {
			KeywordUtil.markPassed("Ascending sort is working")
		}
		else {
			if(isRemovedSort) {
				KeywordUtil.markPassed("Sort function is removed")
			}
			else {
				KeywordUtil.markFailed("Ascending sort is not working")
			}
		}
	}
}
