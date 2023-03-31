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
CustomKeywords.'com.kms.VerifyPage.VerifyPage.NavigateToLoginPage'()


'Step 2 and Step 3:'
'''Input to "Email" and "Password" textboxes then click on "LOGIN" button'''
CustomKeywords.'com.kms.VerifyPage.VerifyPage.InputEmailPasswordAndLogin'(GlobalVariable.email, GlobalVariable.password)
'ER:'
'''Header title "Dashboard" is displayed'''
WebUI.delay(5) //Delay for Dashboard title displayes instead of Administrator Login
WebUI.getWindowTitle()
WebUI.verifyMatch(WebUI.getWindowTitle(), title, false, FailureHandling.CONTINUE_ON_FAILURE)

'6 buttons on Dashboard'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.GetElementSize'(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/btnDashboard'), btnDashboard)

''' "Confirmed Bookings" icon has background color rgb(38, 166, 154)'''
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textConfirmedBookings'), FailureHandling.CONTINUE_ON_FAILURE )
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textConfirmedBookings'), confirmed, FailureHandling.CONTINUE_ON_FAILURE )
CustomKeywords.'com.kms.VerifyPage.VerifyPage.BackgroundColorButton'('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/iconConfirmedBookings', green)

''' "Pending Bookings" icon has background color rgb(255, 179, 0)'''
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textPendingBookings'), FailureHandling.CONTINUE_ON_FAILURE )
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textPendingBookings'), pending, FailureHandling.CONTINUE_ON_FAILURE )
CustomKeywords.'com.kms.VerifyPage.VerifyPage.BackgroundColorButton'('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/iconPendingBookings', yellow)

''' "Cancelled Bookings" icon has background color rgb(211, 47, 47)'''
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textCancelledBookings'), FailureHandling.CONTINUE_ON_FAILURE )
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textCancelledBookings'), cancelled, FailureHandling.CONTINUE_ON_FAILURE )
CustomKeywords.'com.kms.VerifyPage.VerifyPage.BackgroundColorButton'('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/iconCancelledBookings', red)

''' "Paid Bookings" icon has background color rgb(0, 49, 188)'''
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textPaidBookings'), FailureHandling.CONTINUE_ON_FAILURE )
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textPaidBookings'), paid, FailureHandling.CONTINUE_ON_FAILURE )
CustomKeywords.'com.kms.VerifyPage.VerifyPage.BackgroundColorButton'('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/iconPaidBookings', darkBlue)

''' "Unpaid Bookings" icon has background color rgb(156, 39, 176)'''
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textUnpaidBookings'), FailureHandling.CONTINUE_ON_FAILURE )
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textUnpaidBookings'), unpaid, FailureHandling.CONTINUE_ON_FAILURE )
CustomKeywords.'com.kms.VerifyPage.VerifyPage.BackgroundColorButton'('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/iconUnpaidBookings', purple)

''' "Refunded Bookings" icon has background color rgb(0, 119, 255)'''
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textRefundedBookings'), FailureHandling.CONTINUE_ON_FAILURE )
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textRefundedBookings'), refunded, FailureHandling.CONTINUE_ON_FAILURE )
CustomKeywords.'com.kms.VerifyPage.VerifyPage.BackgroundColorButton'('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/iconRefundedBookings', lightBlue)

'''"Revenue Breakdown 2023" session is displayed'''
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textRevenueSession'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textRevenueSession'), revenueSession, FailureHandling.CONTINUE_ON_FAILURE)

'''"Searches" session is displayed'''
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textSearchSession'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/BE01_LoginPageSuccessful/textSearchSession'), searchSession, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()