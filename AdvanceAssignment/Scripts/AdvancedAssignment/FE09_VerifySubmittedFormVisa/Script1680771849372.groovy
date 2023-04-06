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
'Navigate to page https://phptravels.net/visa'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.LoginPage'(GlobalVariable.urlVisa)


'Step 2:'
'Select valid General Informations: From Country'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE09_VerifySubmittedFormVisa/ddFromCountry'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE09_VerifySubmittedFormVisa/optionFromCountry', (['fromCountry' : fromCountry])), FailureHandling.CONTINUE_ON_FAILURE)
'Select valid General Informations: To Country'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE09_VerifySubmittedFormVisa/ddToCountry'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE09_VerifySubmittedFormVisa/optionToCountry', (['toCountry' : toCountry])), FailureHandling.CONTINUE_ON_FAILURE)
'Select valid General Informations: Date'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE09_VerifySubmittedFormVisa/selectDate'), FailureHandling.CONTINUE_ON_FAILURE)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.DatePicker'(monthYear, date, 1)
String selectedDate = WebUI.getAttribute(findTestObject('Object Repository/AdvancedAssignment/FE09_VerifySubmittedFormVisa/selectDate'), "value")
'Click on submit button'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE09_VerifySubmittedFormVisa/btnSearch'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.waitForPageLoad(GlobalVariable.timeOut)


'Step 3:'
'Input valid Applicant #1 informations'
'Input First Name'
WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/FE09_VerifySubmittedFormVisa/txtInformation', (['info' : array[0]])), firstName, FailureHandling.CONTINUE_ON_FAILURE)
'Input Last Name'
WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/FE09_VerifySubmittedFormVisa/txtInformation', (['info' : array[1]])), lastName, FailureHandling.CONTINUE_ON_FAILURE)
'Input Email'
WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/FE09_VerifySubmittedFormVisa/txtInformation', (['info' : array[2]])), email, FailureHandling.CONTINUE_ON_FAILURE)
'Input Phone'
WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/FE09_VerifySubmittedFormVisa/txtInformation', (['info' : array[3]])), phone, FailureHandling.CONTINUE_ON_FAILURE)
'Input Date'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE09_VerifySubmittedFormVisa/txtInformation', (['info' : array[4]])), FailureHandling.CONTINUE_ON_FAILURE)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.DatePicker'(monthYearToSubmitForm, dateToSubmitForm, 1)
'Input Notes'
WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/FE09_VerifySubmittedFormVisa/txtNotes'), note, FailureHandling.CONTINUE_ON_FAILURE)


'Step 3:'
'Click on Submit button'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE09_VerifySubmittedFormVisa/btnCookies'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE09_VerifySubmittedFormVisa/btnSearch'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.waitForPageLoad(GlobalVariable.timeOut)
'ER:'
'Submit visa success page is displayed with header text'
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/FE09_VerifySubmittedFormVisa/titleSubmit'), titleSubmit, FailureHandling.CONTINUE_ON_FAILURE)

