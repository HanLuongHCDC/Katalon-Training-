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
import com.kms.katalon.keyword.datetime.DateTimeUtility

'Step 1:'
'Navigate to page https://phptravels.net/'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.LoginPage'(GlobalVariable.urlUser)


'Step 2:'
'Select MY ACCOUNT and Login'
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/FE01_LoginSuccessful/btnAccount'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE01_LoginSuccessful/btnAccount'))
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/FE01_LoginSuccessful/btnCustomerLogin'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE01_LoginSuccessful/btnCustomerLogin'))
'ER:'
'''Login Page is displayed Window title = "Login - PHPTRAVELS"'''
WebUI.waitForPageLoad(GlobalVariable.timeOut)
WebUI.verifyMatch(WebUI.getWindowTitle(), titleLoginPage, false,  FailureHandling.CONTINUE_ON_FAILURE)

'''Login Page is displayed URL = "https://phptravels.net/login"'''
CustomKeywords.'com.kms.VerifyPage.VerifyPage.VerifyCurrentUrl'(urlUserLogin)


'Step 3:'
'Enter Email, Password and click on Login'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.LoginUser'(GlobalVariable.userEmail, GlobalVariable.userPassword)
'ER:'
'Main page is displayed User Name label'
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/AdvancedAssignment/FE01_LoginSuccessful/textUserName')), userName, false, FailureHandling.CONTINUE_ON_FAILURE)

'Main page is displayed as correct format'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.ParseFormat'('Object Repository/AdvancedAssignment/FE01_LoginSuccessful/dateTime')

'Let menu bar label:  Dashboard; My Bookings; Add Funds; My Profile; Logout'
'Let menu bar icon: Dashboard; My Bookings; Add Funds; My Profile; Logout'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.GetElementSize'(findTestObject('Object Repository/AdvancedAssignment/FE01_LoginSuccessful/leftMenuList'), leftMenuList)
for (def i : (0..4)) {
	textMenu = WebUI.getText(findTestObject('AdvancedAssignment/FE01_LoginSuccessful/menuBar', [('bar') : array[i]]))
	WebUI.verifyElementVisible(findTestObject('AdvancedAssignment/FE01_LoginSuccessful/iconBar', [('bar') : array[i]]), FailureHandling.CONTINUE_ON_FAILURE)//menu bar icon
	println(textMenu)
	i+=1
	WebUI.verifyMatch(textMenu, findTestData('LeftMenuBar').getValue(1, i), false)//menu bar label
	
}