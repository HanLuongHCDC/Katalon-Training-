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
'Click on Upload(0) gallery and upload 1 photo'
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/BE07_UploadGallery/clkUpload'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE07_UploadGallery/clkUpload'), FailureHandling.STOP_ON_FAILURE)
WebUI.uploadFileWithDragAndDrop(findTestObject('Object Repository/AdvancedAssignment/BE07_UploadGallery/clkDropFile'), file, FailureHandling.STOP_ON_FAILURE)
WebUI.delay(3)// Wait for uploaded file successful

'Step 4:'
'Back to Hotel Management Page'
WebUI.back(FailureHandling.STOP_ON_FAILURE)
'ER:'
'Verify image is uploaded for this hotel'
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/BE07_UploadGallery/clkUpload'), upload, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyImagePresent(findTestObject('Object Repository/AdvancedAssignment/BE07_UploadGallery/img'))

WebUI.closeBrowser()