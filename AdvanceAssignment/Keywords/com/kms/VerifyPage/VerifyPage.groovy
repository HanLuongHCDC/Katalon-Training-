package com.kms.VerifyPage

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.Color

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class VerifyPage {
	
	@Keyword
	public void LoginPage(String url) {
		WebUI.openBrowser(url)
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		WebUI.maximizeWindow()
	}

	@Keyword
	public void VerifyCurrentUrl(String url) {
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		String currentUrl = WebUI.getUrl(FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(currentUrl, url, false, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	public void InputEmailPasswordAndLogin(String email, String password) {
		WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/BE_SameRepository/txtEmail'), email)
		WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/BE_SameRepository/txtPassword'), password)
		WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE_SameRepository/btnLogin'))
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
	}
	
	@Keyword
	public void LoginUser(String email, String password) {
		WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/FE_SameRepository/txtEmail'), email)
		WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/FE_SameRepository/txtPassword'), password)
		WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE_SameRepository/btnLogin'))
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

	@Keyword
	public void VerifyFileDownloaded(String downloadedFile) {
		File downloadFolder = new File("C:\\Users\\hanluong\\Downloads");
		List downloadFile = Arrays.asList(downloadFolder.list());

		if (downloadFile.contains(downloadedFile)) {
			KeywordUtil.markPassed("Download file successfully")
		}
		else {
			KeywordUtil.markFailed("Download file failed")
		}
	}
	
	@Keyword
	public void GetFormatDateTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z' (Indochina Time)'");
		GlobalVariable.format = dateFormat.format(date)
        System.out.println(GlobalVariable.format)
	}
	
	@Keyword
	public void ParseFormat(TestObject) {
        String date = WebUI.getText(findTestObject(TestObject))
		System.out.println(date)
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z' (Indochina Time)'");
		def i = dateFormat.getDateTimeInstance()
		System.out.println(i)
		String formatDateTime = dateFormat.parse(date)
        System.out.println(formatDateTime)
		def convert = dateFormat.format(formatDateTime)
		System.out.println(convert)
		WebUI.verifyMatch(date, convert, false)
	}
}