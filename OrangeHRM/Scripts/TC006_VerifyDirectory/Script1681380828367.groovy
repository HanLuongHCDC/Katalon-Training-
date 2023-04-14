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

'Pre-condition'
String clkItem = 'Directory'
'Navigate to https://opensource-demo.orangehrmlive.com/'
WebUI.openBrowser(GlobalVariable.url)
'Create a new admin'
CustomKeywords.'com.kms.commonKeywords.commonKeywords.createNewAdminAccount'(0,0,GlobalVariable.userNameNewAdmin, GlobalVariable.passwordNewAdmin)
'Login to the system successfully'
CustomKeywords.'com.kms.commonKeywords.commonKeywords.logInPage'(GlobalVariable.userNameNewAdmin, GlobalVariable.passwordNewAdmin)
'Navigate to Directory page'
WebUI.click(findTestObject('Object Repository/CommonTestObject/clkItem', [('item') : clkItem]), FailureHandling.STOP_ON_FAILURE)


'Step 1:'
'Search by Employee Name: Peter Mac Anderson (or any existing employee name)'
WebUI.setText(findTestObject('Object Repository/TC006_VerifyDirectory/txtEmployeeName'), 'p', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC006_VerifyDirectory/selectEmployeeName'), FailureHandling.STOP_ON_FAILURE)
String employeeName = WebUI.getAttribute(findTestObject('Object Repository/TC006_VerifyDirectory/txtEmployeeName'), 'value', FailureHandling.CONTINUE_ON_FAILURE)//get emloyee name to verify ER
'Click on Search button'
WebUI.click(findTestObject('Object Repository/CommonTestObject/btnSearch'), FailureHandling.STOP_ON_FAILURE)
'ER:'
'The employee name is displayed'
CustomKeywords.'com.kms.commonKeywords.DirectoryPage.verifyInfoEmployeeInDirectory'(findTestObject('Object Repository/TC006_VerifyDirectory/listEmployeeName'), employeeName)


'Step 2:'
'Remove the employee name and search by Job Title: Account Assistant (or any job title has more 1 person)'
WebUI.sendKeys(findTestObject('Object Repository/TC006_VerifyDirectory/txtEmployeeName'), Keys.chord(Keys.CONTROL,'a'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.sendKeys(findTestObject('Object Repository/TC006_VerifyDirectory/txtEmployeeName'), Keys.chord(Keys.BACK_SPACE), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC006_VerifyDirectory/ddJobTitle'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC006_VerifyDirectory/selectJobTitle'), FailureHandling.STOP_ON_FAILURE)
String jobTitle = WebUI.getText(findTestObject('Object Repository/TC006_VerifyDirectory/ddJobTitle'), FailureHandling.CONTINUE_ON_FAILURE)
'Click on Search button'
WebUI.click(findTestObject('Object Repository/CommonTestObject/btnSearch'), FailureHandling.STOP_ON_FAILURE)
'ER:'
'The employees display with a correct job title - Check the job title displays for each employee'
CustomKeywords.'com.kms.commonKeywords.DirectoryPage.verifyInfoEmployeeInDirectory'(findTestObject('Object Repository/TC006_VerifyDirectory/listJobTitle'), jobTitle)


'Step 3:'
'Remove the job title'
WebUI.click(findTestObject('Object Repository/TC006_VerifyDirectory/ddJobTitle'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC006_VerifyDirectory/removeJobTitle'), FailureHandling.STOP_ON_FAILURE)
'Search by Location: New York Sales Office (or any location has more 1 person)'
WebUI.click(findTestObject('Object Repository/TC006_VerifyDirectory/ddLocation'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC006_VerifyDirectory/selectLocation'), FailureHandling.STOP_ON_FAILURE)
String location = WebUI.getText(findTestObject('Object Repository/TC006_VerifyDirectory/ddLocation'), FailureHandling.CONTINUE_ON_FAILURE)
'Click on Search button'
WebUI.click(findTestObject('Object Repository/CommonTestObject/btnSearch'), FailureHandling.STOP_ON_FAILURE)
'ER:'
'The employees display with a correct location - Check the location displays for each employee'
CustomKeywords.'com.kms.commonKeywords.DirectoryPage.verifyInfoEmployeeInDirectory'(findTestObject('Object Repository/TC006_VerifyDirectory/listLocation'), location)


'Step 4:'
'Search by Job title and Location'
WebUI.click(findTestObject('Object Repository/TC006_VerifyDirectory/ddJobTitle'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC006_VerifyDirectory/selectJobTitle'), FailureHandling.STOP_ON_FAILURE)
'Click on Search button'
WebUI.click(findTestObject('Object Repository/CommonTestObject/btnSearch'), FailureHandling.STOP_ON_FAILURE)
'ER:'
'The employees display with a correct location and job title - Check the location and job title displays for each employee'
CustomKeywords.'com.kms.commonKeywords.DirectoryPage.verifyInfoEmployeeInDirectory'(findTestObject('Object Repository/TC006_VerifyDirectory/listJobTitle'), jobTitle)
CustomKeywords.'com.kms.commonKeywords.DirectoryPage.verifyInfoEmployeeInDirectory'(findTestObject('Object Repository/TC006_VerifyDirectory/listLocation'), location)