package com.kms.commonKeywords

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class commonKeywords {
	
	@Keyword
	public void logInPage() {
		WebUI.maximizeWindow()
		WebUI.setText(findTestObject('Object Repository/CommonTestObject/txtUserName'), GlobalVariable.username, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.setText(findTestObject('Object Repository/CommonTestObject/txtPassword'), GlobalVariable.password, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/CommonTestObject/btnLogin'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForPageLoad(GlobalVariable.longTime, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	@Keyword
	String VerifyFilterSearchMenu(String text) {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> numberOfItemMenu = driver.findElements(By.xpath("//ul[contains(@class,'main-menu')]/li"))
		println("The number of item's menu: " + numberOfItemMenu.size())
		for (int i=0; i < numberOfItemMenu.size(); i++) {
			String itemMenu= numberOfItemMenu.get(i).getText()
			println("The item menu is: " + itemMenu)
			if(itemMenu.toUpperCase().contains(text.toUpperCase())) {
				KeywordUtil.markPassed("Filter with letter is working")
			}
			else {
				KeywordUtil.markFailed("Filter with letter is not working")
			}
		}
	}
}
