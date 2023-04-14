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
String newUsername = '@Admin@@Demo'
String newPassword = '123456@Admin'
String titleAddUserPage = 'Add User'
String titleAdminPage = 'System Users'
String ePopUpSaved = "Success\nSuccessfully Saved\n×"
String txtDeleteSelected = 'Delete Selected'
'Navigate to https://opensource-demo.orangehrmlive.com/'
WebUI.openBrowser(GlobalVariable.url)
'Login to the system successfully'
CustomKeywords.'com.kms.commonKeywords.commonKeywords.logInPage'(GlobalVariable.username, GlobalVariable.password)
'Navigate to Admin page'
WebUI.click(findTestObject('Object Repository/CommonTestObject/clkItem', [('item') : clkItem]), FailureHandling.STOP_ON_FAILURE)


'Step 1:'
'Click Add button'
WebUI.click(findTestObject('Object Repository/CommonTestObject/CreateNewAdmin/btnAddAdminUser'), FailureHandling.STOP_ON_FAILURE)
'ER:'
'Add User page displays'
WebUI.verifyElementText(findTestObject('Object Repository/TC009_VerifyAdminDataDeleted/titleAddUserPage'), titleAddUserPage, FailureHandling.CONTINUE_ON_FAILURE)


'Step 2:'
'Create a user as User Role = ESS, Status = Disabled, Password = 123456@Admin and Click to Save button'
CustomKeywords.'com.kms.commonKeywords.AdminPage.addNewAdmin'('ESS', 'o', 'Disabled', newUsername, newPassword)
'ER:'
'''Save successfully - A Pop up is displayed with "Success Successfully Saved"'''
WebUI.verifyElementVisible(findTestObject('Object Repository/CommonTestObject/popUp'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/CommonTestObject/popUp'), ePopUpSaved, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.waitForElementNotPresent(findTestObject('Object Repository/CommonTestObject/loadingSpinner'), GlobalVariable.longTime, FailureHandling.CONTINUE_ON_FAILURE)
'Return to Admin page - Title System Users of Admin Page is displayed'
WebUI.verifyElementText(findTestObject('Object Repository/TC009_VerifyAdminDataDeleted/titleAdminPage'), titleAdminPage, FailureHandling.CONTINUE_ON_FAILURE)


'Step 3:'
'Pre-condition: Verify the total of records before deleting'
def recordBeforeDeleting = Integer.parseInt(WebUI.getText(findTestObject('Object Repository/TC007_VerifyAdminDataRecords/recordFound'), FailureHandling.CONTINUE_ON_FAILURE).split("\\) ")[0].replace("(", ""))
'Select the new user checkbox'
WebUI.click(findTestObject('Object Repository/TC009_VerifyAdminDataDeleted/cellCheckBox',[('username') : newUsername]), FailureHandling.STOP_ON_FAILURE)
'ER:'
'The Delete Selected button displays'
WebUI.verifyElementText(findTestObject('Object Repository/TC009_VerifyAdminDataDeleted/btnDeleteSelected'), txtDeleteSelected, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementVisible(findTestObject('Object Repository/TC009_VerifyAdminDataDeleted/btnDeleteSelected'), FailureHandling.CONTINUE_ON_FAILURE)


'Step 4:'
'Click to Delete Selected button and click Yes, Delete in the alert box'
WebUI.click(findTestObject('Object Repository/TC009_VerifyAdminDataDeleted/btnDeleteSelected'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC009_VerifyAdminDataDeleted/btnYesDelete'), FailureHandling.STOP_ON_FAILURE)
'The record is deleted completely - The number of total records reduce'
def recordAfterDeleting = Integer.parseInt(WebUI.getText(findTestObject('Object Repository/TC007_VerifyAdminDataRecords/recordFound'), FailureHandling.CONTINUE_ON_FAILURE).split("\\) ")[0].replace("(", ""))
WebUI.verifyEqual(recordBeforeDeleting - 1, recordAfterDeleting, FailureHandling.CONTINUE_ON_FAILURE)
'Cannot search the user'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/TC009_VerifyAdminDataDeleted/cellCheckBox',[('username') : newUsername]), GlobalVariable.longTime, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()