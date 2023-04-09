import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
'Step 1:'
'Navigate to page https://phptravels.net/hotels'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.LoginPage'(GlobalVariable.urlUserHotel)


'Step 2:'
'Get details of a random Featured Hotel: Name'
String name = WebUI.getText(findTestObject('Object Repository/AdvancedAssignment/FE11_VerifyHotelDetails/nameHotel', (['hotelName' : hotelName])), FailureHandling.CONTINUE_ON_FAILURE)
'Get details of a random Featured Hotel: Location'
String location = WebUI.getText(findTestObject('Object Repository/AdvancedAssignment/FE11_VerifyHotelDetails/locationHotel', (['hotelName' : hotelName])), FailureHandling.CONTINUE_ON_FAILURE)
'Get details of a random Featured Hotel: Stars'
List<WebElement> totalStar = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/AdvancedAssignment/FE11_VerifyHotelDetails/starHotel', (['hotelName' : hotelName])), GlobalVariable.timeOut)
'Get details of a random Featured Hotel: Price'
String price = WebUI.getText(findTestObject('Object Repository/AdvancedAssignment/FE11_VerifyHotelDetails/priceHotel', (['hotelName' : hotelName])), FailureHandling.CONTINUE_ON_FAILURE)
'Get details of a random Featured Hotel: Discount'
String discount = WebUI.getText(findTestObject('Object Repository/AdvancedAssignment/FE11_VerifyHotelDetails/discountHotel', (['hotelName' : hotelName])), FailureHandling.CONTINUE_ON_FAILURE)


'Step 3:'
'''Clicking "Details" button'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE11_VerifyHotelDetails/detailHotel'), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'''Verify Hotel details page is displayed with "Hotel Details" default'''
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/FE11_VerifyHotelDetails/tabDefault'), tabDefault, FailureHandling.CONTINUE_ON_FAILURE)


'Step 4:'
'Verify Invoice Information details: Stars'
List<WebElement> starOfHotelDetail = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/AdvancedAssignment/FE11_VerifyHotelDetails/starOfHotelDetail', (['hotelName' : hotelName])), GlobalVariable.timeOut)
WebUI.verifyEqual(totalStar.size(), starOfHotelDetail.size(), FailureHandling.CONTINUE_ON_FAILURE)