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
'Navigate to page https://phptravels.net/tours'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.LoginPage'(GlobalVariable.urlTour)


'Step 2:'
'Filter search Destination: Dubai'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE02_VerifyTourFilter/ddDestination'), FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/FE02_VerifyTourFilter/searchDestination'), destination, FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementNotPresent(findTestObject('Object Repository/AdvancedAssignment/FE02_VerifyTourFilter/searchResult'), GlobalVariable.timeOut, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/FE02_VerifyTourFilter/searchDestination'), Keys.chord(Keys.ENTER), FailureHandling.CONTINUE_ON_FAILURE)

'Filter search Date: Current Date'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE02_VerifyTourFilter/inputDate'),FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.DatePicker'(monthYear, date)
String selectedDate = WebUI.getAttribute(findTestObject('Object Repository/AdvancedAssignment/FE02_VerifyTourFilter/inputDate'), "value")//get date time to verify for the below step

'Filter search Travellers'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE02_VerifyTourFilter/ddTravellers'), FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.SelectTravellers'(numberOfAdults, numberOfChild)

'Click on Search button'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE02_VerifyTourFilter/btnSearch'))

'ER'
' Title is: SEARCH TOURS IN DUBAI'
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/FE02_VerifyTourFilter/titleTourList'), title, FailureHandling.CONTINUE_ON_FAILURE)

'Date: Current date'
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/AdvancedAssignment/FE02_VerifyTourFilter/titleDate')), WebUI.concatenate(["Date ", "( ", selectedDate, " )"] as String[]), false)

'Travellers: 1 Adult, 1 Child'
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/AdvancedAssignment/FE02_VerifyTourFilter/titleTravellers')), WebUI.concatenate([numberOfAdults, " Adults ", numberOfChild, " Childs"] as String[]), false)