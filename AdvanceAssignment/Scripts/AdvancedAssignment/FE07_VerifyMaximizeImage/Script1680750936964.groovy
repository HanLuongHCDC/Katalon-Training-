import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

'Step 1:'
'Navigate to page https://phptravels.net/hotels'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.LoginPage'(GlobalVariable.urlUserHotel)


'Step 2:'
'''Scroll down to "Featured Hotels" list. Random click on one "Details >"'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE07_VerifyMaximizeImage/detailHotel', (['hotelName': hotelName])))
'ER:'
'Verify title of the selected hotel match with the title of the page'
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/FE07_VerifyMaximizeImage/titlePage', (['hotelName': hotelName])), titlePage, FailureHandling.CONTINUE_ON_FAILURE)


'Step 3:'
'Mouse over on the biggest image'
WebUI.mouseOver(findTestObject('Object Repository/AdvancedAssignment/FE07_VerifyMaximizeImage/biggestImg'), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'The image is not clickable'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/AdvancedAssignment/FE07_VerifyMaximizeImage/sliderImg'), GlobalVariable.timeOut, FailureHandling.CONTINUE_ON_FAILURE)


'Step 4:'
'Mouse over on an another small image and click the image'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE07_VerifyMaximizeImage/smallImg'), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'The image slider is displayed'
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/FE07_VerifyMaximizeImage/sliderImg'), FailureHandling.CONTINUE_ON_FAILURE)


'Step 5:'
'Clicking Full Screen icon'
widthBeforeFullScreen = WebUI.getCSSValue(findTestObject('Object Repository/AdvancedAssignment/FE07_VerifyMaximizeImage/sliderImg'), "width", FailureHandling.CONTINUE_ON_FAILURE)
heightBeforeFullScreen = WebUI.getCSSValue(findTestObject('Object Repository/AdvancedAssignment/FE07_VerifyMaximizeImage/sliderImg'), "height", FailureHandling.CONTINUE_ON_FAILURE)
WebUI.mouseOver(findTestObject('Object Repository/AdvancedAssignment/FE07_VerifyMaximizeImage/sliderImg'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE07_VerifyMaximizeImage/iconFullScreen'), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'Image displays as full screen'
widthAfterFullScreen = WebUI.getCSSValue(findTestObject('Object Repository/AdvancedAssignment/FE07_VerifyMaximizeImage/sliderImg'), "width", FailureHandling.CONTINUE_ON_FAILURE)
heightAfterFullScreen = WebUI.getCSSValue(findTestObject('Object Repository/AdvancedAssignment/FE07_VerifyMaximizeImage/sliderImg'), "height", FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyGreaterThan(widthAfterFullScreen.split("p")[0], widthBeforeFullScreen.split("p")[0], FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyGreaterThan(heightAfterFullScreen.split("p")[0], heightBeforeFullScreen.split("p")[0], FailureHandling.CONTINUE_ON_FAILURE)
print(widthAfterFullScreen.split("p")[0])


'Step 6:'
'Clicking on FullScreen icon again'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE07_VerifyMaximizeImage/iconFullScreen'), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'Image displays as normal size'
WebUI.verifyEqual(WebUI.getCSSValue(findTestObject('Object Repository/AdvancedAssignment/FE07_VerifyMaximizeImage/sliderImg'), "width").split("p")[0], widthBeforeFullScreen.split("p")[0], FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyEqual(WebUI.getCSSValue(findTestObject('Object Repository/AdvancedAssignment/FE07_VerifyMaximizeImage/sliderImg'), "height").split("p")[0], heightBeforeFullScreen.split("p")[0], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()





