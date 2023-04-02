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
CustomKeywords.'com.kms.VerifyPage.VerifyPage.CreateNewHotel'(oldName, oldDes, location)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/CreateNewHotel/btnSubmitWithAddData'), FailureHandling.STOP_ON_FAILURE)


'Step 3:'
'Click on Hotel Name and change information'
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/BE05_ModifyHotelInformationByHotelName/oldData'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE05_ModifyHotelInformationByHotelName/oldHotelName'), FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.ClearOldInformation'()
CustomKeywords.'com.kms.VerifyPage.VerifyPage.CreateNewHotel'(newName, newDes, newLocation)


'Step 4:'
'''Click on "SUBMIT" button'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/CreateNewHotel/btnSubmitWithUpdateData'), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/BE05_ModifyHotelInformationByHotelName/newData'), FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()