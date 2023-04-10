import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

'Precondition'
'Navigate to https://opensource-demo.orangehrmlive.com/'
WebUI.openBrowser(GlobalVariable.url)


'Step 1:'
'Login to the system successfully'
CustomKeywords.'com.kms.commonKeywords.commonKeywords.logInPage'()
'ER:'
'The Dashboard page is loaded successfully - User control is displayed'
WebUI.verifyElementText(findTestObject('Object Repository/CommonTestObject/titlePage'), selectedPage, FailureHandling.CONTINUE_ON_FAILURE)


'Step 2:'
'Click to the toogle menu button to collapse the menu'
WebUI.click(findTestObject('Object Repository/TC002_VerifyMainMenu/btnToggleMenu'), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'The menu will be collapsed completely - Check the un-toggle button (<) is dissappeared'
WebUI.verifyElementPresent(findTestObject('Object Repository/TC002_VerifyMainMenu/collapseMenu'), GlobalVariable.timeOut, FailureHandling.CONTINUE_ON_FAILURE)//class includes "toggled"
WebUI.verifyElementNotPresent(findTestObject('Object Repository/TC002_VerifyMainMenu/btnLeftToggle'), GlobalVariable.timeOut, FailureHandling.CONTINUE_ON_FAILURE)


'Step 3:'
'Click to the un-toggle menu button to open the menu'
WebUI.click(findTestObject('Object Repository/TC002_VerifyMainMenu/btnToggleMenu'), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'The menu will be displayed completely - Check the un-toggle button (>) is dissappeared'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/TC002_VerifyMainMenu/collapseMenu'), GlobalVariable.timeOut, FailureHandling.CONTINUE_ON_FAILURE)//class does not include "toggled"
WebUI.verifyElementNotPresent(findTestObject('Object Repository/TC002_VerifyMainMenu/btnRightToggle'), GlobalVariable.timeOut, FailureHandling.CONTINUE_ON_FAILURE)


'Step 4:'
'''Type to Search textbox "My Info"'''
WebUI.sendKeys(findTestObject('Object Repository/TC002_VerifyMainMenu/txtSearch'), txtSearch, FailureHandling.CONTINUE_ON_FAILURE)