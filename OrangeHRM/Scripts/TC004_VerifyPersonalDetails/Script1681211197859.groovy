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

'Precondition'
def path = System.getProperty('user.home') + pathAttachment[0]
def newPath = System.getProperty('user.home') + pathAttachment[1]
String filePath = path.replace("/", "\\")
String newFilePath = newPath.replace("/", "\\")
String ePopUpText = "Success\nSuccessfully Saved\n×"
'Navigate to https://opensource-demo.orangehrmlive.com/'
WebUI.openBrowser(GlobalVariable.url)
'Login to the system successfully'
//CustomKeywords.'com.kms.commonKeywords.commonKeywords.logInPage'()
'Click to My Info menu'
WebUI.click(findTestObject('Object Repository/CommonTestObject/clkItem', [('item') : clkItem]), FailureHandling.STOP_ON_FAILURE)


//'Step 1:'
//'Click to Personal Details'
//WebUI.click(findTestObject('Object Repository/TC004_VerifyPersonalDetails/subListPersonalDetails'), FailureHandling.CONTINUE_ON_FAILURE)
//'ER:'
//'The Personal Details is displayed  - Check the sub page title loaded'
//WebUI.verifyElementVisible(findTestObject('Object Repository/TC004_VerifyPersonalDetails/subPageTitle'), FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.verifyElementText(findTestObject('Object Repository/TC004_VerifyPersonalDetails/subPageTitle'), subPageTitle, FailureHandling.CONTINUE_ON_FAILURE)
//
//
//'Step 2:'
//'Change the First name value and Click First Save button'
//WebUI.sendKeys(findTestObject('Object Repository/TC004_VerifyPersonalDetails/txtFirstName'), Keys.chord(Keys.CONTROL,"a"), FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.sendKeys(findTestObject('Object Repository/TC004_VerifyPersonalDetails/txtFirstName'), Keys.chord(Keys.BACK_SPACE), FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.setText(findTestObject('Object Repository/TC004_VerifyPersonalDetails/txtFirstName'), eFirstName, FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.click(findTestObject('Object Repository/TC004_VerifyPersonalDetails/btnFirstSave'), FailureHandling.STOP_ON_FAILURE)
//'ER:'
//'The First name value can be change to the new value'
//String aFirstName = WebUI.getAttribute(findTestObject('Object Repository/TC004_VerifyPersonalDetails/txtFirstName'), "value", FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.verifyMatch(aFirstName, eFirstName, false, FailureHandling.CONTINUE_ON_FAILURE)
//
//
//'Step 3:'
//'Change the Blood Type to another type (ex: AB+) and click the Second Save'
//WebUI.click(findTestObject('Object Repository/TC004_VerifyPersonalDetails/ddBloodType'), FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.click(findTestObject('Object Repository/TC004_VerifyPersonalDetails/selectBloodType'), FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.click(findTestObject('Object Repository/TC004_VerifyPersonalDetails/btnSecondSave'), FailureHandling.CONTINUE_ON_FAILURE)
//'ER:'
//''' A Pop up is displayed with: "Success Successful Saved"'''
//WebUI.verifyElementVisible(findTestObject('Object Repository/TC004_VerifyPersonalDetails/popUp'), FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.verifyElementText(findTestObject('Object Repository/TC004_VerifyPersonalDetails/popUp'), ePopUpText, FailureHandling.CONTINUE_ON_FAILURE)
//'The current value of the Blood type is changed'
//WebUI.verifyElementText(findTestObject('Object Repository/TC004_VerifyPersonalDetails/ddBloodType'), eBloodType, FailureHandling.CONTINUE_ON_FAILURE)
//
//
//'Step 4:'
//'Attach a file in the Attachments session'
//WebUI.click(findTestObject('Object Repository/TC004_VerifyPersonalDetails/btnAddAttachment'), FailureHandling.STOP_ON_FAILURE)
//WebUI.uploadFile(findTestObject('Object Repository/TC004_VerifyPersonalDetails/uploadFile'), filePath, FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.waitForElementVisible(findTestObject('Object Repository/TC004_VerifyPersonalDetails/txtSelectFile',[('fileNameUploaded') : attachmentName]), GlobalVariable.longTime, FailureHandling.CONTINUE_ON_FAILURE) //wait for attachment uploaded succesfully
//WebUI.click(findTestObject('Object Repository/TC004_VerifyPersonalDetails/btnThirdSave'), FailureHandling.STOP_ON_FAILURE)
//'ER:'
//'''The attached file is loaded successfully - A Pop up is displayed with "Success Successfully Saved"'''
//WebUI.verifyElementVisible(findTestObject('Object Repository/TC004_VerifyPersonalDetails/popUp'), FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.verifyElementText(findTestObject('Object Repository/TC004_VerifyPersonalDetails/popUp'), ePopUpText, FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.verifyElementNotPresent(findTestObject('Object Repository/TC004_VerifyPersonalDetails/loadingSpinner'), GlobalVariable.longTime, FailureHandling.CONTINUE_ON_FAILURE)//wait for loading spinner disappeared and then the table is displayed
//'Verify a attachment table is displayed with column name: File Name Description Size Type Date Added Added By Actions'
//CustomKeywords.'com.kms.commonKeywords.commonKeywords.VerifyTitleTable'(titleTable)
//CustomKeywords.'com.kms.commonKeywords.commonKeywords.GetInfoCellFromTable'(findTestObject('Object Repository/TC004_VerifyPersonalDetails/cellFileName'), attachmentName)
//
//
//'Step 5:'
//'Re-attached another file'
//WebUI.click(findTestObject('Object Repository/TC004_VerifyPersonalDetails/btnAddAttachment'), FailureHandling.STOP_ON_FAILURE)
//WebUI.uploadFile(findTestObject('Object Repository/TC004_VerifyPersonalDetails/uploadFile'), newFilePath, FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.waitForElementVisible(findTestObject('Object Repository/TC004_VerifyPersonalDetails/txtSelectFile',[('fileNameUploaded') : reAttachmentName]), GlobalVariable.longTime, FailureHandling.CONTINUE_ON_FAILURE) //wait for attachment uploaded succesfully
//WebUI.click(findTestObject('Object Repository/TC004_VerifyPersonalDetails/btnThirdSave'), FailureHandling.STOP_ON_FAILURE)
//'''The attached file is loaded successfully - A Pop up is displayed with "Success Successfully Saved"'''
//WebUI.verifyElementVisible(findTestObject('Object Repository/TC004_VerifyPersonalDetails/popUp'), FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.verifyElementText(findTestObject('Object Repository/TC004_VerifyPersonalDetails/popUp'), ePopUpText, FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.verifyElementNotPresent(findTestObject('Object Repository/TC004_VerifyPersonalDetails/loadingSpinner'), GlobalVariable.longTime, FailureHandling.CONTINUE_ON_FAILURE)//wait for loading spinner disappeared and then the table is displayed
//'The new attachement file is insert into the table'
//CustomKeywords.'com.kms.commonKeywords.commonKeywords.GetInfoCellFromTable'(findTestObject('Object Repository/TC004_VerifyPersonalDetails/cellFileName'), reAttachmentName)


'Step 6:'
'Click to downloaded the latest attached file'
String latestFileName = WebUI.getText(findTestObject('Object Repository/TC004_VerifyPersonalDetails/cellAttachmentInfo',[('rowIndex') : 'last()', ('cellIndex'):'2']), FailureHandling.CONTINUE_ON_FAILURE)
//Check file exists in download folder. If has, delete it
CustomKeywords.'com.kms.commonKeywords.commonKeywords.DeleteFileExistBeforeDownload'(latestFileName)
WebUI.click(findTestObject('Object Repository/TC004_VerifyPersonalDetails/btnDownloadLatestAttachment'), FailureHandling.STOP_ON_FAILURE)
WebUI.delay(GlobalVariable.shortTime)
'ER:'
'The file is downloaded successfully - The title of the file exists in the local computer'
CustomKeywords.'com.kms.commonKeywords.commonKeywords.VerifyFileDownloadSuccessfully'(latestFileName)


'Step 7:'
'Click to Edit button of the first attached file'
String firstFileName = WebUI.getText(findTestObject('Object Repository/TC004_VerifyPersonalDetails/cellAttachmentInfo'), FailureHandling.CONTINUE_ON_FAILURE)//get text to verify ER
WebUI.click(findTestObject('Object Repository/TC004_VerifyPersonalDetails/btnEdit'), FailureHandling.STOP_ON_FAILURE)
'ER:'
'The editable form is loaded - The editted file name is correct'
WebUI.verifyElementText(findTestObject('Object Repository/TC004_VerifyPersonalDetails/editableFormTitle'), titleEditForm, FailureHandling.CONTINUE_ON_FAILURE)//Check title edit form is match
WebUI.verifyElementText(findTestObject('Object Repository/TC004_VerifyPersonalDetails/editCurrentFile'), firstFileName, FailureHandling.CONTINUE_ON_FAILURE)
'The editable form is loaded - The Save and Cancel button are displayed'
WebUI.verifyElementVisible(findTestObject('Object Repository/TC004_VerifyPersonalDetails/btnEditFormSave'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementVisible(findTestObject('Object Repository/TC004_VerifyPersonalDetails/btnEditFormCancel'), FailureHandling.CONTINUE_ON_FAILURE)


'Step 8:'
'Update the Comment to a new value (ex: ABC) and click Save button'
WebUI.setText(findTestObject('Object Repository/TC004_VerifyPersonalDetails/txtComment'), txtComment, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/TC004_VerifyPersonalDetails/btnEditFormSave'), FailureHandling.CONTINUE_ON_FAILURE)