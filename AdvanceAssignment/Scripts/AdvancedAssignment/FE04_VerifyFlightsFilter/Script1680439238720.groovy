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
CustomKeywords.'com.kms.VerifyPage.VerifyPage.LoginPage'(GlobalVariable.urlFlights)


'Step 2:'
'''Filter search for "Flying From"'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE04_VerifyFlightsFilter/ddFrom'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/FE04_VerifyFlightsFilter/ddFrom'), fromCode)

'''Filter search for "To Destination"'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE04_VerifyFlightsFilter/ddTo'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/FE04_VerifyFlightsFilter/ddTo'), toCode)

'Filter search for Departure Date'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE04_VerifyFlightsFilter/departureDate'), FailureHandling.CONTINUE_ON_FAILURE)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.DatePicker'(monthYear, date)
String selectedDate = WebUI.getAttribute(findTestObject('Object Repository/AdvancedAssignment/FE04_VerifyFlightsFilter/departureDate'), "value")

'''Filter search for "Passengers"'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE04_VerifyFlightsFilter/passengers'), FailureHandling.CONTINUE_ON_FAILURE)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.SelectOptions'(numberOfAdults, idAdults)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.SelectOptions'(numberOfChild, idChilds)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.SelectOptions'(numberOfInfants, idInfants)

'Click on Search button'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE04_VerifyFlightsFilter/searchFlights'), FailureHandling.CONTINUE_ON_FAILURE)

'ER:'
'Verify flight title'
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/FE04_VerifyFlightsFilter/titleArrowRight'))
String flightsTitle = fromCode + " " + toCode
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/FE04_VerifyFlightsFilter/titleFilghts'), flightsTitle, FailureHandling.CONTINUE_ON_FAILURE)

'Verify departure date'
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/AdvancedAssignment/FE04_VerifyFlightsFilter/titleDates')), WebUI.concatenate(["Dates ", "( ", selectedDate, " )"] as String[]), false)

'Verify passengers'
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/AdvancedAssignment/FE04_VerifyFlightsFilter/titleTravellers')), WebUI.concatenate(["Adults ", numberOfAdults, " Childs ",numberOfChild," Infants ", numberOfInfants] as String[]), false)