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
String clkItem = 'Admin'
String titleEditPage = 'Edit User'
String titleAdminPage = 'System Users'
String ePopUpUpdated = "Success\nSuccessfully Updated\n×"
String statusEdited = 'Disabled'
'Navigate to https://opensource-demo.orangehrmlive.com/'
WebUI.openBrowser(GlobalVariable.url)
'Create a new admin'
CustomKeywords.'com.kms.commonKeywords.commonKeywords.createNewAdminAccount'(0,0,GlobalVariable.userNameNewAdmin, GlobalVariable.passwordNewAdmin)
'Login to the system successfully'
CustomKeywords.'com.kms.commonKeywords.commonKeywords.logInPage'(GlobalVariable.userNameNewAdmin, GlobalVariable.passwordNewAdmin)
'Navigate to Admin page'
WebUI.click(findTestObject('Object Repository/CommonTestObject/clkItem', [('item') : clkItem]), FailureHandling.STOP_ON_FAILURE)


'Step 1:'
'Click Edit button of Joe.Root username (or any enabled configuration user)'
String usernameEdited = WebUI.getText(findTestObject('Object Repository/TC008_VerifyAdminDataUpdated/usernameEdited'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC008_VerifyAdminDataUpdated/btnEdit'), FailureHandling.STOP_ON_FAILURE)
'ER:'
'Edit User form displayed - Sub page title, Save control displayed'
WebUI.verifyElementText(findTestObject('Object Repository/TC008_VerifyAdminDataUpdated/titleEditForm'), titleEditPage, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementVisible(findTestObject('Object Repository/CommonTestObject/btnSave'), FailureHandling.CONTINUE_ON_FAILURE)


'Step 2:'
'Change the status to be disabled and click Save button'
WebUI.click(findTestObject('Object Repository/TC008_VerifyAdminDataUpdated/ddStatus'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC008_VerifyAdminDataUpdated/selectStatus',[('status') : statusEdited]), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/CommonTestObject/btnSave'), FailureHandling.STOP_ON_FAILURE)
'ER:'
'Update successfully'
'''A Pop up is displayed with "Success Successfully Updated"'''
WebUI.verifyElementVisible(findTestObject('Object Repository/CommonTestObject/popUp'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/CommonTestObject/popUp'), ePopUpUpdated, FailureHandling.CONTINUE_ON_FAILURE)
'Page return to Admin'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/CommonTestObject/loadingSpinner'), GlobalVariable.longTime, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/TC008_VerifyAdminDataUpdated/titleAdminPage'), titleAdminPage, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementVisible(findTestObject('Object Repository/TC008_VerifyAdminDataUpdated/recordFound'), FailureHandling.CONTINUE_ON_FAILURE)


'Step 3:'
'Check the status of the user - The status is updated correctly'
WebUI.verifyElementText(findTestObject('Object Repository/TC008_VerifyAdminDataUpdated/statusEdited', [('username') : usernameEdited]), statusEdited, FailureHandling.CONTINUE_ON_FAILURE)