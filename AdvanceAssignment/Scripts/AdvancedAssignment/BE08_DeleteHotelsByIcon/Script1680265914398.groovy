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
'Navigate and login as Admin to page'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.LoginPage'(GlobalVariable.urlHotels)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.InputEmailPasswordAndLogin'(GlobalVariable.email, GlobalVariable.password)


'Step 2:'
'Create a new hotel like BE-04'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/CreateNewHotel/btnAdd'), FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.CreateNewHotel'(name, des, location)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/CreateNewHotel/btnSubmitWithAddData'), FailureHandling.STOP_ON_FAILURE)


'Step 3:'
'''Click on "Remove" icon on created hotel row'''
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/BE08_DeleteHotelsByIcon/btnRemove'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE08_DeleteHotelsByIcon/btnRemove'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE08_DeleteHotelsByIcon/btnRemove'), FailureHandling.STOP_ON_FAILURE)// issue when click once time the alert is disappear immediately, need to click again, the alert is appear again
'ER:'
'''Verify a alert popup with text "Do you really want remove this entry?" is displayed'''
WebUI.verifyAlertPresent(GlobalVariable.timeOut, FailureHandling.CONTINUE_ON_FAILURE)
String alert = WebUI.getAlertText()
WebUI.verifyMatch(alert, alertText, false, FailureHandling.CONTINUE_ON_FAILURE)


'Step 4:'
'''Click on "OK" in alert'''
WebUI.acceptAlert()
'ER:'
'''Delete Successful. Verify the Hotel is deleted on list.'''
WebUI.refresh()// issue after deleting data, the page is error, so need to refresh it
WebUI.verifyElementNotVisible(findTestObject('Object Repository/AdvancedAssignment/BE08_DeleteHotelsByIcon/deletedData'), FailureHandling.CONTINUE_ON_FAILURE)// mark fail when the element is not found

WebUI.closeBrowser()