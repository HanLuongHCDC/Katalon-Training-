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
import com.kms.katalon.core.webui.common.WebUiCommonHelper

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

	@Keyword
	public void VerifyTitleTable(List<String> titleTable) {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> element = driver.findElements(By.xpath("//div[contains(@class,'table-header-cell')]"))
		println("The number of title are: " + element.size())
		for (int i=0; i<element.size(); i++) {
			String title = element.get(i).getText()
			if(title.equals("")) {
				KeywordUtil.markPassed("This is a checkbox")
			}
			else if(title.equals(titleTable[i])) {
				KeywordUtil.markPassed("The tilte " + title + " is matched")
			}
			else {
				KeywordUtil.markFailed("The title " + title + " is mismatched")
			}
		}
	}

	@Keyword
	public void GetInfoCellFromTable(TestObject, String eFile) {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> infoCell = WebUiCommonHelper.findWebElements(TestObject, GlobalVariable.longTime)
		List<String> listFileName = new ArrayList<String>()
		for (int i=0; i < infoCell.size(); i++) {
			String cell = infoCell.get(i).getText()
			listFileName.add(cell)
		}
		if(listFileName.contains(eFile)) {
			KeywordUtil.markPassed("The image" + eFile + " is uploaded successfully")
		}
		else {
			KeywordUtil.markFailed("The image" + eFile + " is uploaded failed")
		}
	}
	
	@Keyword
	public void DeleteFileExistBeforeDownload(String existFileName) {
		def existFilePath = System.getProperty('user.home') + "/Downloads/" + existFileName
		String filePath = existFilePath.replace("/", "\\")
		File existFileBeforeDownload = new File(filePath)
		if(existFileBeforeDownload.exists()) {
			existFileBeforeDownload.delete()
			println("File existed. Deleted. Ready to download")
		}
		else {
			println("File is not existed. Ready to download")
		}
	}
	
	@Keyword
	public void VerifyFileDownloadSuccessfully(String downloadedFile) {
		def path = System.getProperty('user.home') + "/Downloads/"
		String filePath = path.replace("/", "\\")
		File downloadFolder = new File(filePath)
		List downloadFile = Arrays.asList(downloadFolder.list());
		if (downloadFile.contains(downloadedFile)) {
			KeywordUtil.markPassed("Download file successfully")
		}
		else {
			KeywordUtil.markFailed("Download file failed")
		}
	}
	
	@Keyword
	public void VerifyRowDeleted(TestObject, String eFile) {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> infoCell = WebUiCommonHelper.findWebElements(TestObject, GlobalVariable.longTime)
		for (int i=0; i < infoCell.size(); i++) {
			String cell = infoCell.get(i).getText()
			println(cell)
		if(cell.equals(eFile)) {
			KeywordUtil.markFailed("The image" + eFile + " hasn't deleted")
		}
		else {
			KeywordUtil.markPassed("The image" + eFile + " is deleted")
			}
		}
	}
}
