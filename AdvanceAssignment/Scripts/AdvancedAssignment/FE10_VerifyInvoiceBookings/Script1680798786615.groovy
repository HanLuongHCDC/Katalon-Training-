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
'Navigate and login to page https://phptravels.net/account/bookings'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.LoginPage'(GlobalVariable.urlUserLogin)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.LoginUser'(GlobalVariable.userEmail, GlobalVariable.userPassword)
WebUI.navigateToUrl(GlobalVariable.urlBookings, FailureHandling.STOP_ON_FAILURE)


'Step 2:'
'Get random Booking information: Type'
WebUI.getText(findTestObject('Object Repository/AdvancedAssignment/FE10_VerifyInvoiceBookings/infoBookings', (['tag': info[0]])), FailureHandling.CONTINUE_ON_FAILURE)
'Get random Booking information: Dates'
WebUI.getText(findTestObject('Object Repository/AdvancedAssignment/FE10_VerifyInvoiceBookings/infoBookings', (['tag': info[1]])), FailureHandling.CONTINUE_ON_FAILURE)
'Get random Booking information: Price'
String bookingTotalPrice = WebUI.getText(findTestObject('Object Repository/AdvancedAssignment/FE10_VerifyInvoiceBookings/infoBookings', (['tag': info[2]])), FailureHandling.CONTINUE_ON_FAILURE)
'Get random Booking information: Status'
WebUI.getText(findTestObject('Object Repository/AdvancedAssignment/FE10_VerifyInvoiceBookings/infoBookings', (['tag': info[3]])), FailureHandling.CONTINUE_ON_FAILURE)
'Get random Booking information: Action'
WebUI.getText(findTestObject('Object Repository/AdvancedAssignment/FE10_VerifyInvoiceBookings/infoBookings', (['tag': info[4]])), FailureHandling.CONTINUE_ON_FAILURE)

'Step 3:'
'''Clicking "View Voucher" button (at index 1)'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE10_VerifyInvoiceBookings/btnViewVoucher'), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'Invoice page is displayed: Hotel Invoice - PHPTRAVELS'
WebUI.switchToWindowIndex(1, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(WebUI.getWindowTitle(), titleInvoice, false, FailureHandling.CONTINUE_ON_FAILURE)
' Verify Invoice information details: Total Price match with Invote Price at step 2'
String invoiceTotalPrice = WebUI.getText(findTestObject('Object Repository/AdvancedAssignment/FE10_VerifyInvoiceBookings/invoiceTotalPrice'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(invoiceTotalPrice.split("USD ")[1], bookingTotalPrice.split("USD ")[1], false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()