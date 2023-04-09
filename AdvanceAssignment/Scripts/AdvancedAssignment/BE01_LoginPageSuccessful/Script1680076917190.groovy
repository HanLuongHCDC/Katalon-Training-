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
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver

'Step 1:'
'Go to https://phptravels.net/api/admin'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.LoginPage'(GlobalVariable.urlAdmin)


'Step 2 and Step 3:'
'''Input to "Email" and "Password" textboxes then click on "LOGIN" button'''
CustomKeywords.'com.kms.VerifyPage.VerifyPage.InputEmailPasswordAndLogin'(GlobalVariable.email, GlobalVariable.password)
'ER:'
'''Header title "Dashboard" is displayed'''
WebUI.delay(GlobalVariable.timeOut) //Delay for Dashboard title displayes instead of Administrator Login
WebUI.getWindowTitle()
WebUI.verifyMatch(WebUI.getWindowTitle(), title, false, FailureHandling.CONTINUE_ON_FAILURE)

'6 buttons on Dashboard'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.GetElementSize'(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/btnDashboard'), btnDashboard)

'''Verify each icon matches with background color'''
for (int i=0; i<btnDashboard;i++) {
	WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textDashboard', [('icon') : icon[i]]), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textDashboard',[('icon') : icon[i]] ), titleDashboard[i], FailureHandling.CONTINUE_ON_FAILURE)
	CustomKeywords.'com.kms.VerifyPage.VerifyPage.BackgroundColorButton'(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/iconBackgroundColor',[('color') : aColor[i]]), eColor[i])
}
'''"Revenue Breakdown 2023" session is displayed'''
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textRevenueSession'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textRevenueSession'), revenueSession, FailureHandling.CONTINUE_ON_FAILURE)

'''"Searches" session is displayed'''
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textSearchSession'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textSearchSession'), searchSession, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()