package com.kms.VerifyPage

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.Color

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import java.awt.Robot
import java.awt.event.KeyEvent

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
	public void ParseFormat(TestObject) {
		String dateTime = WebUI.getText(findTestObject(TestObject))
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss");
		Date parseDateTime = dateTimeFormat.parse(dateTime);
		SimpleDateFormat formatDateTime = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z' (Indochina Time)'");
		System.out.println(formatDateTime.format(parseDateTime));
		WebUI.verifyMatch(dateTime, formatDateTime.format(parseDateTime), false,FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	public void DatePicker(String erMonthYear, String erDate, int index) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement aMonthYear = driver.findElement(By.xpath("//div[contains(@class,'datepicker')][${index}]//div[contains(@class,'datepicker-days')]//table//th[contains(@class,'switch')]"))
		while(!(aMonthYear.getText()).equals(erMonthYear)){
			driver.findElement(By.xpath("//div[contains(@class,'datepicker')][${index}]//div[contains(@class, 'days')]//table//tr[1]/th[contains(@class, 'next')]")).click();
		}
		System.out.println(aMonthYear.getText());
		List<WebElement> date = driver.findElements(By.xpath("//div[contains(@class,'datepicker')][${index}]//div[contains(@class, 'days')]//table//tbody//td"));
		for(WebElement e:date){
			if ((e.getText()).equals(erDate)) {
				e.click()
				break;
			}
		}
	}

	@Keyword
	public void SelectOptions(String eOption, String id) {
		String aOption = WebUI.getAttribute(findTestObject('Object Repository/AdvancedAssignment/FE_SameRepository/numberOfOption', [('id') : id]), "value")
		while(!aOption.equals(eOption)) {
			if(eOption>aOption) {
				WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE_SameRepository/btnPlusTravellers', [('id') : id]))
			}
			else {
				WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE_SameRepository/btnMinusTravellers', [('id') : id]))
			}
			aOption = WebUI.getAttribute(findTestObject('Object Repository/AdvancedAssignment/FE_SameRepository/numberOfOption', [('id') : id]), "value")
		}
	}

	@Keyword
	public void VerifyLocation() {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> location = driver.findElements(By.xpath("//p[./i[contains(@class, 'map-marker')]]"))
		for(int i=0; i < location.size();i++ ) {
			String country = location.get(i).findElement(By.xpath("//p[./i[contains(@class, 'map-marker')]]")).getText()
			System.out.println(country)
			if(country.equals("Dubai")) {
				continue
			}
			else {
				KeywordUtil.markFailed("Location is not correct")
			}
		}
	}

	@Keyword
	public void SortWebTable(Boolean ascending , String column) {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> list = driver.findElements(By.xpath(column))
		List<String> originalList = new ArrayList<String>()
		List<String> tempList = new ArrayList<String>()
		for (int i=0; i< list.size(); i++) {
			originalList.add(list.get(i).getText())
			tempList.add(list.get(i).getText())
		}
		if(ascending) {
			Collections.sort(tempList)//ascending
			System.out.println(originalList)
			System.out.println(tempList)
		}
		else {
			Collections.sort(tempList, Collections.reverseOrder())//descending
		}
		if(tempList.equals(originalList)) {
			KeywordUtil.markPassed("Sort function is working");
		}
		else {
			KeywordUtil.markFailed("Sort function is not working");
		}
	}

	@Keyword
	public void ThumbnailImage(TestObject1, TestObject2) {
		String srcImage = WebUI.getAttribute(findTestObject(TestObject1), "src", FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.navigateToUrl(srcImage, FailureHandling.STOP_ON_FAILURE)
		if(WebUI.getText(findTestObject(TestObject2)).equals("Not Found")) {
			KeywordUtil.markFailed("No image is uploaded")
		}
		else {
			KeywordUtil.markPassed("The image is uploaded")
		}
	}
	
	@Keyword
	public void PrintPopUp(action) {
		Robot robot = new Robot();
		robot.keyPress(action);
		robot.keyRelease(action);
	}
}













