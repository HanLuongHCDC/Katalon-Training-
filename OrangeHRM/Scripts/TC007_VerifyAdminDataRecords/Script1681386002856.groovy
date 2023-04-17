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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement
import com.kms.commonKeywords.commonKeywords
import com.kms.commonKeywords.AdminPage
import com.kms.commonKeywords.DirectoryPage

'Pre-condition'
String clkItem = 'Admin'
'Navigate to https://opensource-demo.orangehrmlive.com/'
WebUI.openBrowser(GlobalVariable.url)
'Create a new admin'
commonKeywords.createNewAdminAccount(0, 0, GlobalVariable.userNameNewAdmin, GlobalVariable.passwordNewAdmin)
'Login to the system successfully'
commonKeywords.logInPage(GlobalVariable.userNameNewAdmin, GlobalVariable.passwordNewAdmin)
'Navigate to Admin page'
WebUI.click(findTestObject('Object Repository/CommonTestObject/clkItem', [('item') : clkItem]), FailureHandling.STOP_ON_FAILURE)
'Prepare data: the total records must be larger than 51 records'
def recordData = 51
AdminPage.createTotalRecordAdminUser(recordData)


'Step 1:'
'Select Ascending sort for Username column'
WebUI.click(findTestObject('Object Repository/TC007_VerifyAdminDataRecords/iconSortUserName'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC007_VerifyAdminDataRecords/sortItemUserName',[('sort') : 'Ascending']), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'The username column is sorted by Asc'
WebUI.waitForElementNotPresent(findTestObject('Object Repository/CommonTestObject/loadingSpinner'), GlobalVariable.longTime, FailureHandling.CONTINUE_ON_FAILURE)
DirectoryPage.verifySortAscFunction(findTestObject('Object Repository/TC007_VerifyAdminDataRecords/cellUserName'), true, false)

'Step 2:'
'Select Descending sort for Username column'
WebUI.click(findTestObject('Object Repository/TC007_VerifyAdminDataRecords/iconSortUserName'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC007_VerifyAdminDataRecords/sortItemUserName',[('sort') : 'Decending']), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'The username column is sorted by Dec'
WebUI.waitForElementNotPresent(findTestObject('Object Repository/CommonTestObject/loadingSpinner'), GlobalVariable.longTime, FailureHandling.CONTINUE_ON_FAILURE)
DirectoryPage.verifySortAscFunction(findTestObject('Object Repository/TC007_VerifyAdminDataRecords/cellUserName'), false, false)


'Step 3:'
'Select Ascending sort for Employee Name column'
WebUI.click(findTestObject('Object Repository/TC007_VerifyAdminDataRecords/iconSortEmployeeName'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC007_VerifyAdminDataRecords/sortItemEmployeeName',[('sort') : 'Ascending']), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'The Employee Name column is sorted by Asc'
WebUI.waitForElementNotPresent(findTestObject('Object Repository/CommonTestObject/loadingSpinner'), GlobalVariable.longTime, FailureHandling.CONTINUE_ON_FAILURE)
DirectoryPage.verifySortAscFunction(findTestObject('Object Repository/TC007_VerifyAdminDataRecords/cellEmployeeName'), true, false)
'The sort of Username column is removed'
DirectoryPage.verifySortAscFunction(findTestObject('Object Repository/TC007_VerifyAdminDataRecords/cellUserName'), false, true)


'Step 4:'
'Count the total records'
List<WebElement> listRow = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/TC007_VerifyAdminDataRecords/cellUserName'), GlobalVariable.longTime)
'ER:'
'The total records is displayed correctly - Remember the total records label and compare with total record is displayed by page'
WebUI.verifyEqual(listRow.size(), recordData, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()