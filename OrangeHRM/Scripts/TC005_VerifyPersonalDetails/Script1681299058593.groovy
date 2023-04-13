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
import com.kms.katalon.core.util.KeywordUtil

'Pre-condition'
'Navigate to https://opensource-demo.orangehrmlive.com/'
String dateFrom = '2023-04-13'
String dateToTommorow = '2023-04-14'
String dateToPrevious = '2023-04-12'
String vacancySelected = optionVacancy[2]
String managerSelected = optionHiringManager[1]
String statusSelected = optionStatus[5]
String ePopUpText = "Success\nSuccessfully Saved\n×"
String ePopUpUpdated = "Success\nSuccessfully Updated\n×"
WebUI.openBrowser(GlobalVariable.url)
'Create a new admin'
CustomKeywords.'com.kms.commonKeywords.commonKeywords.createNewAdminAccount'()
'Login to the system successfully'
CustomKeywords.'com.kms.commonKeywords.commonKeywords.logInPage'(GlobalVariable.userNameNewAdmin, GlobalVariable.passwordNewAdmin)
'Navigate to Recruitment page'
WebUI.click(findTestObject('Object Repository/CommonTestObject/clkItem', [('item') : clkItem]), FailureHandling.STOP_ON_FAILURE)


'Step 1:'
'Select a candidate filter'
'Vacancy: Sales Representative'
WebUI.click(findTestObject('Object Repository/TC005_VerifyPersonalDetails/ddInfoCandidates',[('ddHeader') : headerCandidates[0]]), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC005_VerifyPersonalDetails/selectInfoCandidates',[('headerCandidates') : headerCandidates[0], ('ddItem') : vacancySelected]), FailureHandling.CONTINUE_ON_FAILURE)
'Hiring manager: Linda Anderson'
WebUI.click(findTestObject('Object Repository/TC005_VerifyPersonalDetails/ddInfoCandidates',[('ddHeader') : headerCandidates[1]]), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC005_VerifyPersonalDetails/selectInfoCandidates',[('headerCandidates') : headerCandidates[1], ('ddItem') : managerSelected]), FailureHandling.CONTINUE_ON_FAILURE)
'Status: Interview Failed'
WebUI.click(findTestObject('Object Repository/TC005_VerifyPersonalDetails/ddInfoCandidates',[('ddHeader') : headerCandidates[2]]), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC005_VerifyPersonalDetails/selectInfoCandidates',[('headerCandidates') : headerCandidates[2], ('ddItem') : statusSelected]), FailureHandling.CONTINUE_ON_FAILURE)
'Click on Search button'
WebUI.click(findTestObject('Object Repository/TC005_VerifyPersonalDetails/btnSearch'), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'The filter values are displayed correctly - Current selected values are changed'
WebUI.verifyElementText(findTestObject('Object Repository/TC005_VerifyPersonalDetails/txtInfoSelected', [('ddHeader') : headerCandidates[0]]), vacancySelected, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/TC005_VerifyPersonalDetails/txtInfoSelected', [('ddHeader') : headerCandidates[1]]), managerSelected, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/TC005_VerifyPersonalDetails/txtInfoSelected', [('ddHeader') : headerCandidates[2]]), statusSelected, FailureHandling.CONTINUE_ON_FAILURE)
CustomKeywords.'com.kms.commonKeywords.RecuitmentPage.GetInfoCellFromTable'(findTestObject('Object Repository/TC005_VerifyPersonalDetails/cellInfoFilter'), vacancySelected, fullNameManager, statusSelected)


'Step 2:'
'Click Reset button'
WebUI.click(findTestObject('Object Repository/TC005_VerifyPersonalDetails/btnReset'), FailureHandling.STOP_ON_FAILURE)
'''The filter values are reset - Current selected values are changed to "-- Select --"'''
WebUI.verifyElementText(findTestObject('Object Repository/TC005_VerifyPersonalDetails/txtInfoSelected', [('ddHeader') : headerCandidates[0]]), txtResetInfo, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/TC005_VerifyPersonalDetails/txtInfoSelected', [('ddHeader') : headerCandidates[1]]), txtResetInfo, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/TC005_VerifyPersonalDetails/txtInfoSelected', [('ddHeader') : headerCandidates[2]]), txtResetInfo, FailureHandling.CONTINUE_ON_FAILURE)


'Step 3:'
'Select Date of Application From with a current day value'
WebUI.setText(findTestObject('Object Repository/TC005_VerifyPersonalDetails/inputDateFrom'), dateFrom, FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'The date time value is today'
String fromDisplay = WebUI.getAttribute(findTestObject('Object Repository/TC005_VerifyPersonalDetails/inputDateFrom'), 'value', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(fromDisplay, dateFrom, false, FailureHandling.CONTINUE_ON_FAILURE)


'Step 4:'
'Select Date of Application To with a next day value'
WebUI.setText(findTestObject('Object Repository/TC005_VerifyPersonalDetails/inputDateTo'), dateToTommorow, FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'The date time value is tomorow'
String toDisplay = WebUI.getAttribute(findTestObject('Object Repository/TC005_VerifyPersonalDetails/inputDateTo'), 'value', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(toDisplay, dateToTommorow, false, FailureHandling.CONTINUE_ON_FAILURE)


'Step 5:'
'Clear date in Step 4'
WebUI.sendKeys(findTestObject('Object Repository/TC005_VerifyPersonalDetails/inputDateTo'), Keys.chord(Keys.CONTROL,'a'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.sendKeys(findTestObject('Object Repository/TC005_VerifyPersonalDetails/inputDateTo'), Keys.chord(Keys.BACK_SPACE), FailureHandling.CONTINUE_ON_FAILURE)
'Select Date of Application To with a previous day value'
WebUI.setText(findTestObject('Object Repository/TC005_VerifyPersonalDetails/inputDateTo'), dateToPrevious, FailureHandling.CONTINUE_ON_FAILURE)
'Click on Search button'
WebUI.click(findTestObject('Object Repository/CommonTestObject/btnSearch'), FailureHandling.STOP_ON_FAILURE)
'ER:'
'''An error is displayed "To date should be after from date"'''
WebUI.verifyElementText(findTestObject('Object Repository/TC005_VerifyPersonalDetails/msgErrorDateTo'), msgError, FailureHandling.CONTINUE_ON_FAILURE)


'Step 6:'
'Create a candidate and save the data'
CustomKeywords.'com.kms.commonKeywords.commonKeywords.createNewCandidates'()
'ER:'
''' A Pop up is displayed with: "Success Successful Saved"'''
WebUI.verifyElementVisible(findTestObject('Object Repository/CommonTestObject/popUp'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/CommonTestObject/popUp'), ePopUpText, FailureHandling.CONTINUE_ON_FAILURE)
'''The 2 buttons " Reject and Shortlist " are displayed'''
WebUI.verifyElementVisible(findTestObject('Object Repository/TC005_VerifyPersonalDetails/btnReject'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementVisible(findTestObject('Object Repository/TC005_VerifyPersonalDetails/btnShortlist'), FailureHandling.CONTINUE_ON_FAILURE)


'Step 7:'
'Click to ShortList button, not change anything and click Save button'
WebUI.click(findTestObject('Object Repository/TC005_VerifyPersonalDetails/btnShortlist'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/CommonTestObject/btnSave'), FailureHandling.STOP_ON_FAILURE)
'ER:'
''' A Pop up is displayed with: "Success Successful Updated"'''
WebUI.verifyElementVisible(findTestObject('Object Repository/CommonTestObject/popUp'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/CommonTestObject/popUp'), ePopUpUpdated, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.waitForElementNotPresent(findTestObject('Object Repository/CommonTestObject/loadingSpinner'), GlobalVariable.longTime, FailureHandling.CONTINUE_ON_FAILURE)
'''The 2 buttons " Reject and Schedule Interview" are displayed'''
WebUI.verifyElementVisible(findTestObject('Object Repository/TC005_VerifyPersonalDetails/btnReject'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementVisible(findTestObject('Object Repository/TC005_VerifyPersonalDetails/btnScheduleInterview'), FailureHandling.CONTINUE_ON_FAILURE)