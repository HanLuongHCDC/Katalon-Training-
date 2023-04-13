package com.kms.commonKeywords

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable

public class AdminPage {
	@Keyword
	public List<String> GetInfoCellFromTable(TestObject, String eFile) {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> infoCell = WebUiCommonHelper.findWebElements(TestObject, GlobalVariable.longTime)
		List<String> listFileName = new ArrayList<String>()
		for (int i=0; i < infoCell.size(); i++) {
			String cell = infoCell.get(i).getText()
			listFileName.add(cell)
		}
		println(listFileName)
		return listFileName
	}
}
