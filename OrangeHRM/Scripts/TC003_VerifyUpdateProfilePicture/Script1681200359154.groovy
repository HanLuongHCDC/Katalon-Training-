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
import com.kms.katalon.core.configuration.RunConfiguration
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

'Precondition'
def path = System.getProperty('user.home') + "/Downloads/tree.png"
String filePath = path.replace("/", "\\")
String ePopUpText = "Success\nSuccessfully Updated\n×"
'Navigate to https://opensource-demo.orangehrmlive.com/'
WebUI.openBrowser(GlobalVariable.url)


'Step 1:'
'Login to the system successfully'
CustomKeywords.'com.kms.commonKeywords.commonKeywords.logInPage'()
'ER:'
'The Dashboard page is loaded successfully - User control is displayed'
WebUI.verifyElementText(findTestObject('Object Repository/CommonTestObject/titlePage'), selectedPage, FailureHandling.CONTINUE_ON_FAILURE)


'Step 2:'
'Click to My Info menu'
WebUI.click(findTestObject('Object Repository/CommonTestObject/clkItem', [('item') : clkItem]), FailureHandling.STOP_ON_FAILURE)
'ER:'
'The PIM page is loaded successfully - Check page title displayed'
WebUI.verifyElementText(findTestObject('Object Repository/CommonTestObject/titlePage'), titlePage, FailureHandling.CONTINUE_ON_FAILURE)


'Step 3:'
'Click to the user picture'
WebUI.click(findTestObject('Object Repository/TC003_VerifyUpdateProfilePicture/imgProfile'), FailureHandling.STOP_ON_FAILURE)
'The change profile picture is displayed'
WebUI.verifyElementVisible(findTestObject('Object Repository/TC003_VerifyUpdateProfilePicture/changeProfile'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/TC003_VerifyUpdateProfilePicture/changeProfile'), changeProfileTitle, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementVisible(findTestObject('Object Repository/TC003_VerifyUpdateProfilePicture/avatarUploadPicture'), FailureHandling.CONTINUE_ON_FAILURE)


'Step 4:'
'Update a new profile picture and click save'
WebUI.uploadFile(findTestObject('Object Repository/TC003_VerifyUpdateProfilePicture/uploadFile'), filePath, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC003_VerifyUpdateProfilePicture/btnSubmit'), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'The new picture is changed successfully - A Popup is displayed'
WebUI.verifyElementVisible(findTestObject('Object Repository/TC003_VerifyUpdateProfilePicture/popUp'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/TC003_VerifyUpdateProfilePicture/popUp'), ePopUpText, FailureHandling.CONTINUE_ON_FAILURE)
'The change profile picture is still displayed'
WebUI.waitForElementNotPresent(findTestObject('Object Repository/TC003_VerifyUpdateProfilePicture/loadingSpinner'), GlobalVariable.longTime, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementVisible(findTestObject('Object Repository/TC003_VerifyUpdateProfilePicture/avatarUploadPicture'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementText(findTestObject('Object Repository/TC003_VerifyUpdateProfilePicture/changeProfile'), changeProfileTitle, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()