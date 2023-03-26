import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.Url)

WebUI.waitForPageLoad(GlobalVariable.TimeOut)

//WebUI.maximizeWindow()

WebUI.verifyElementVisible(findTestObject('Object Repository/Web 10/Menu'))

WebUI.click(findTestObject('Object Repository/Web 10/Menu'))

WebUI.waitForPageLoad(GlobalVariable.TimeOut)

//Verify Header Title

WebUI.verifyElementVisible(findTestObject('Object Repository/Web 10/Header Title'))

WebUI.verifyElementText(findTestObject('Object Repository/Web 10/Header Title'), 'JQueryUI - Menu')

//Select Enabled

WebUI.mouseOver(findTestObject('Object Repository/Web 10/Enable'))

WebUI.click(findTestObject('Object Repository/Web 10/JQuery'))

WebUI.waitForPageLoad(GlobalVariable.TimeOut)

WebUI.verifyElementVisible(findTestObject('Object Repository/Web 10/Header Title'))

WebUI.verifyElementText(findTestObject('Object Repository/Web 10/Header Title'), 'JQuery UI')

//Click Menu link

WebUI.click(findTestObject('Object Repository/Web 10/Menu'))

WebUI.waitForPageLoad(GlobalVariable.TimeOut)

WebUI.verifyElementText(findTestObject('Object Repository/Web 10/Header Title'), 'JQueryUI - Menu')

//Downloads CSV

WebUI.mouseOver(findTestObject('Object Repository/Web 10/Enable'))

WebUI.mouseOver(findTestObject('Object Repository/Web 10/Downloads'))

//WebUI.click(findTestObject('Object Repository/Web 10/CSV')) -- cannot click CSV because it's margined by page footer

WebDriver driver = DriverFactory.getWebDriver()

WebElement csv = driver.findElement(By.xpath("//a[text()='CSV']"))

JavascriptExecutor executor = (JavascriptExecutor)driver

executor.executeScript("arguments[0].click()", csv)

WebUI.delay(5)

CustomKeywords.'com.helper.downloadfile.DownloadFile.VerifyFileDownloaded'()




