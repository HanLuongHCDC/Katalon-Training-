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
WebUI.maximizeWindow(FailureHandling.CONTINUE_ON_FAILURE)


'Step 1:'
'Get username text from Login form to enter into Username textbox'
String userName = WebUI.getText(findTestObject('Object Repository/TC001_VerifyLoginFunction/textUserLoginForm'), FailureHandling.CONTINUE_ON_FAILURE).split(": ")[1]
'ER:'
'User can enter the username successfully'
WebUI.setText(findTestObject('Object Repository/CommonTestObject/txtUserName'), userName, FailureHandling.CONTINUE_ON_FAILURE)


'Step 2:'
'Get password text from Login form to enter into Password textbox'
String password = WebUI.getText(findTestObject('Object Repository/TC001_VerifyLoginFunction/textPasswordLoginForm'), FailureHandling.CONTINUE_ON_FAILURE).split(": ")[1]
'ER:'
'User can enter the password successfully'
WebUI.setText(findTestObject('Object Repository/CommonTestObject/txtUserName'), password, FailureHandling.CONTINUE_ON_FAILURE)


'Step 3:'
'Click Login button'
WebUI.click(findTestObject('Object Repository/CommonTestObject/btnLogin'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.waitForPageLoad(GlobalVariable.timeOut, FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'The Dashboard page is loaded successfully - Check user control is displayed'
WebUI.verifyElementText(findTestObject('Object Repository/CommonTestObject/titlePage'), selectedPage, FailureHandling.CONTINUE_ON_FAILURE)
'Note:'
'Check page title'
WebUI.getWindowTitle(FailureHandling.CONTINUE_ON_FAILURE).equals(pageTitle)


'Step 4:'
'Select Logout in the User name control'
WebUI.click(findTestObject('Object Repository/TC001_VerifyLoginFunction/userNameControl'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC001_VerifyLoginFunction/logout'), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'The user is logged out: Login form is displayed'
WebUI.verifyElementVisible(findTestObject('Object Repository/TC001_VerifyLoginFunction/loginForm'), FailureHandling.CONTINUE_ON_FAILURE)
'Check user control is disappearred'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/CommonTestObject/titlePage'), GlobalVariable.timeOut, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()