import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.support.Color

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.Url)

WebUI.waitForPageLoad(GlobalVariable.TimeOut)

WebUI.maximizeWindow()

WebUI.verifyElementVisible(findTestObject('Object Repository/Web 08/Challenging DOM'))

WebUI.click(findTestObject('Object Repository/Web 08/Challenging DOM'))

WebUI.waitForPageLoad(GlobalVariable.TimeOut)

//Verify Header Title

WebUI.verifyElementVisible(findTestObject('Object Repository/Web 08/Header title'))

WebUI.verifyElementText(findTestObject('Object Repository/Web 08/Header title'), 'Challenging DOM')

//Verify font-size

WebUI.verifyElementVisible(findTestObject('Object Repository/Web 08/Button 3'))

size = WebUI.getCSSValue(findTestObject('Object Repository/Web 08/Button 3'), 'font-size').equals('16px')

//Verify background-color

WebUI.verifyElementVisible(findTestObject('Object Repository/Web 08/Button 2'))

background = WebUI.getCSSValue(findTestObject('Object Repository/Web 08/Button 2'), 'background-color')

backgroundRgb = Color.fromString(background).asRgb()

WebUI.verifyMatch(backgroundRgb, 'rgb(198, 15, 19)', false)

//Verify border-color

WebUI.verifyElementVisible(findTestObject('Object Repository/Web 08/Button 1'))

border = WebUI.getCSSValue(findTestObject('Object Repository/Web 08/Button 1'), 'border-color')

borderRgb = Color.fromString(border).asRgb()

WebUI.verifyMatch(borderRgb, 'rgb(34, 132, 161)', false)

WebUI.closeBrowser()