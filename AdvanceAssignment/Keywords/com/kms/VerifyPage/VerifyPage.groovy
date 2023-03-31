package com.kms.VerifyPage

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.Color

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class VerifyPage {

	@Keyword
	public void NavigateToLoginPage() {
		WebUI.openBrowser(GlobalVariable.urlAdmin)
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		WebUI.maximizeWindow()
	}

	@Keyword
	public void NavigateToHotelsPage() {
		WebUI.openBrowser(GlobalVariable.urlHotels)
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		WebUI.maximizeWindow()
	}

	@Keyword
	public void NavigateToPage(String url) {
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		String currentUrl = WebUI.getUrl(FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(currentUrl, url, false, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	public void InputEmailPasswordAndLogin(String email, String password) {
		WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/txtEmail'), email)
		WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/txtPassword'), password)
		WebUI.click(findTestObject('Object Repository/AdvancedAssignment/btnLogin'))
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
	}

	@Keyword
	public void BackgroundColorButton(TestObject, color) {
		WebUI.verifyElementVisible(findTestObject(TestObject), FailureHandling.CONTINUE_ON_FAILURE)
		String backgroundColor = WebUI.getCSSValue(findTestObject(TestObject), 'background-color')
		WebUI.verifyMatch(Color.fromString(backgroundColor).asRgb(), color, false, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	public void GetElementSize(TestObject, size) {
		List<WebElement> elementSize = WebUiCommonHelper.findWebElements(TestObject, 30)
		WebUI.verifyEqual(elementSize.size(), size, FailureHandling.CONTINUE_ON_FAILURE)
		System.out.println("The number of this element are: " + elementSize.size())
	}

	@Keyword
	public void CreateNewHotel(String name, String des, String location) {
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/CreateNewHotel/txtHotelName'), name, FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/CreateNewHotel/txtHotelDes'), des, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/AdvancedAssignment/CreateNewHotel/ddLocation'), FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/CreateNewHotel/txtLocation'), location, FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/CreateNewHotel/txtLocation'), Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	public void ClearOldInformation() {
		WebUI.clearText(findTestObject('Object Repository/AdvancedAssignment/CreateNewHotel/txtHotelName'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.clearText(findTestObject('Object Repository/AdvancedAssignment/CreateNewHotel/txtHotelDes'), FailureHandling.CONTINUE_ON_FAILURE)
	}
}
