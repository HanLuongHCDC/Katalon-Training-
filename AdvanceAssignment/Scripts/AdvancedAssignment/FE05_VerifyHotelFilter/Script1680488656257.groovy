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

'Step 1:'
'Navigate to page https://phptravels.net/hotels'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.LoginPage'(GlobalVariable.urlUserHotel)


'Step 2:'
'''Filter search for City Name: "Dubai"'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE05_VerifyHotelFilter/ddCityName'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/FE05_VerifyHotelFilter/searchCityName'), cityName, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.waitForElementNotPresent(findTestObject('Object Repository/AdvancedAssignment/FE05_VerifyHotelFilter/searchResult'), GlobalVariable.timeOut, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/FE05_VerifyHotelFilter/searchCityName'), Keys.chord(Keys.ENTER), FailureHandling.CONTINUE_ON_FAILURE)

'Filter search for Checkin'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE05_VerifyHotelFilter/dateCheckin'), FailureHandling.CONTINUE_ON_FAILURE)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.DatePicker'(monthYearCheckin, dateCheckin, 1)
String checkin = WebUI.getAttribute(findTestObject('Object Repository/AdvancedAssignment/FE05_VerifyHotelFilter/dateCheckin'), "value")

'Filter search for Checkout'
//WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE05_VerifyHotelFilter/dateCheckout'), FailureHandling.CONTINUE_ON_FAILURE)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.DatePicker'(monthYearCheckout, dateCheckout, 2)
String checkout = WebUI.getAttribute(findTestObject('Object Repository/AdvancedAssignment/FE05_VerifyHotelFilter/dateCheckout'), "value")

'Filter search for Travellers: 1 Rooms, 1 Adults, 1 Childs 8 Age'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE05_VerifyHotelFilter/ddTravellers'), FailureHandling.CONTINUE_ON_FAILURE)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.SelectOptions'(rooms, idRooms)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.SelectOptions'(adults, idAdults)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.SelectOptions'(childs, idChilds)
if(childs.equals("0")) {
	KeywordUtil.markPassed(null)
}
else {
	WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE05_VerifyHotelFilter/ddChildAge'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE05_VerifyHotelFilter/selectAge', [('age') : age]), FailureHandling.CONTINUE_ON_FAILURE)
}

'Filter search for Nationality: United States'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE05_VerifyHotelFilter/ddNationality'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE05_VerifyHotelFilter/optionNationality', [('nationality') : nationality]), FailureHandling.CONTINUE_ON_FAILURE)

'Click on Search button'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE05_VerifyHotelFilter/btnSearch'), FailureHandling.STOP_ON_FAILURE)

'ER:'
'Verify title is SEARCH HOTELS IN DUBAI'
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/FE05_VerifyHotelFilter/titleHotelList'),  titleHotelList, FailureHandling.CONTINUE_ON_FAILURE)

'Verify date: 1 Nights (Current day - Tomorrow)'
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/FE05_VerifyHotelFilter/titleDate'), WebUI.concatenate([nights, ' Nights ( ',checkin,' - ',checkout, ' )'] as String[]), FailureHandling.CONTINUE_ON_FAILURE)

'Verify Travellers: 1 Adults 1 Childs 1 Rooms'
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/FE05_VerifyHotelFilter/titleTravellers'), WebUI.concatenate([adults, ' Adults ', childs, ' Childs ', rooms, ' Rooms'] as String[]),FailureHandling.CONTINUE_ON_FAILURE)

'Verify location is matched'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.VerifyLocation'()