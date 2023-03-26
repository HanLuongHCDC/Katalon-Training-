import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.Select

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.Url)

WebUI.waitForPageLoad(GlobalVariable.TimeOut)

WebUI.maximizeWindow()

WebUI.verifyElementVisible(findTestObject('Object Repository/Web 03/Drop Down'))

WebUI.click(findTestObject('Object Repository/Web 03/Drop Down'))

WebUI.waitForPageLoad(GlobalVariable.TimeOut)

//Verify header title

WebUI.verifyElementVisible(findTestObject('Object Repository/Web 03/Header Title'))

WebUI.verifyElementText(findTestObject('Object Repository/Web 03/Header Title'), 'Dropdown List')

//Select item by Label and verify current item = option 2

WebUI.selectOptionByLabel(findTestObject('Object Repository/Web 03/Select Drop'), 'Option 2', false)

WebUI.getText(findTestObject('Object Repository/Web 03/Selected'))

WebUI.verifyElementText(findTestObject('Object Repository/Web 03/Selected'), 'Option 2')

//Select item by Index 1 and verify current item = option 1

WebUI.selectOptionByIndex(findTestObject('Object Repository/Web 03/Select Drop'), 1)

WebUI.getText(findTestObject('Object Repository/Web 03/Selected'))

WebUI.verifyElementText(findTestObject('Object Repository/Web 03/Selected'), 'Option 1')

//Select item by value 2 and verify current item = option 2

WebUI.selectOptionByValue(findTestObject('Object Repository/Web 03/Select Drop'), '2',false)

WebUI.getText(findTestObject('Object Repository/Web 03/Selected'))

WebUI.verifyElementText(findTestObject('Object Repository/Web 03/Selected'), 'Option 2')
