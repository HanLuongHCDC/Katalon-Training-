import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.ConcurrentHashMap.KeySetView

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Step 1:'
'Navigate and login as Admin to Hotels page'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.LoginPage'(GlobalVariable.urlHotels)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.InputEmailPasswordAndLogin'(GlobalVariable.email, GlobalVariable.password)

'Step 2:'
'''Click on "ADD" button'''
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/BE04_CreateNewHotelSuccessful/btnAdd'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE04_CreateNewHotelSuccessful/btnAdd'), FailureHandling.STOP_ON_FAILURE)
WebUI.waitForPageLoad(GlobalVariable.timeOut)


'Step 3:'
'Input all Hotel Information on General Tab'
WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/BE04_CreateNewHotelSuccessful/txtHotelName'), oldName, FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/BE04_CreateNewHotelSuccessful/txtHotelDes'), oldDes, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE04_CreateNewHotelSuccessful/ddLocation'), FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/BE04_CreateNewHotelSuccessful/txtLocation'), location, FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(findTestObject('Object Repository/AdvancedAssignment/BE04_CreateNewHotelSuccessful/txtLocation'), Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)


'Step 4'
'''Click on "SUBMIT" button'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE04_CreateNewHotelSuccessful/btnSubmit'), FailureHandling.STOP_ON_FAILURE)
'ER:'
'The created hotel displays on Hotel Management with correct information'
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/BE04_CreateNewHotelSuccessful/tableAddedData'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()














