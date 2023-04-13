package com.kms.commonKeywords

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable



public class RecuitmentPage {

	@Keyword
	public void GetInfoCellFromTable(TestObject, String vacancy, String manager, String status) {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> infoCell = WebUiCommonHelper.findWebElements(TestObject, GlobalVariable.longTime)
		List<String> candidates = new ArrayList<String>()
		for (int i=0; i < infoCell.size(); i++) {
			String cell = infoCell.get(i).getText()
			candidates.add(cell)
		}
		println(candidates)
		if(candidates.contains(vacancy)&&candidates.contains(manager)&&candidates.contains(status)) {
			KeywordUtil.markPassed("Filter is working correctly")
		}
		else {
			KeywordUtil.markFailed("Filter is failed")
		}
	}
}
