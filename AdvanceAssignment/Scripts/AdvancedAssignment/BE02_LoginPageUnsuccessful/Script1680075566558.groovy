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

'Step 1:'
'Go to https://phptravels.net/api/admin'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.LoginPage'(GlobalVariable.urlAdmin)


'Step 2:'
'Click on "LOGIN" button with blank "Email" and "Password"'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE_SameRepository/btnLogin'))
'ER:'
'"The Email field is required./nThe Password field is required." message is displayed'
WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.urlAdmin, false, FailureHandling.CONTINUE_ON_FAILURE) //Verify Login unsuccessful
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/BE02_LoginPageUnsuccessful/msgLoginUnsuccessfulP1'), msgBlankEmailPasswordP1, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/BE02_LoginPageUnsuccessful/msgLoginUnsuccessfulP2'), msgBlankEmailPasswordP2, FailureHandling.CONTINUE_ON_FAILURE)


'Step 3:'
'Click on "LOGIN" button with invalid format email and password'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.InputEmailPasswordAndLogin'(setInvalidEmail, setInvalidPassword)
'ER:'
'"The Email field must contain a valid email address" message is displayed'
WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.urlAdmin, false, FailureHandling.CONTINUE_ON_FAILURE) //Verify Login unsuccessful
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/BE02_LoginPageUnsuccessful/msgLoginUnsuccessful'), msgIncorrectFormatEmail, FailureHandling.CONTINUE_ON_FAILURE)


'Step 4:'
'Click on "LOGIN" button with  incorrect email or password'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.InputEmailPasswordAndLogin'(setIncorrectEmail, setIncorrectPassword)
'ER:'
'"Invalid Login Credentials" message is displayed'
WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.urlAdmin, false, FailureHandling.CONTINUE_ON_FAILURE) //Verify Login unsuccessful
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/BE02_LoginPageUnsuccessful/msgLoginUnsuccessful'), msgIncorrectEmail, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()

