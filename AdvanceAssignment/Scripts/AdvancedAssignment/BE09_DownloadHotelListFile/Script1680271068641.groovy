import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.Robot;
import java.awt.event.KeyEvent

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
'Step 1:'
'Navigate and login as Admin to page'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.LoginPage'(GlobalVariable.urlHotels)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.InputEmailPasswordAndLogin'(GlobalVariable.email, GlobalVariable.password)


'Step 2:'
'''Click on "EXPORT INTO CSV" button'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE09_DownloadHotelListFile/exportCSV'), FailureHandling.STOP_ON_FAILURE)
WebUI.delay(GlobalVariable.timeOut)// Wait for file is downloaded
'ER:'
'Verify file csv is downloaded successfully'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.VerifyFileDownloaded'(downloadedFile)


'Step 3:'
'Click on "PRINT" button'
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE09_DownloadHotelListFile/exportPrint'), FailureHandling.STOP_ON_FAILURE)
WebUI.delay(GlobalVariable.longTime)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.PrintPopUp'(KeyEvent.VK_ENTER)//Enter to Print button
WebUI.delay(GlobalVariable.shortTime)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.PrintPopUp'(KeyEvent.VK_P)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.PrintPopUp'(KeyEvent.VK_R)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.PrintPopUp'(KeyEvent.VK_I)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.PrintPopUp'(KeyEvent.VK_N)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.PrintPopUp'(KeyEvent.VK_T)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.PrintPopUp'(KeyEvent.VK_ENTER)//Enter to save file name
'ER:'
'Verify file pdf is downloaded successfully'
WebUI.delay(GlobalVariable.timeOut)// Wait for file is downloaded
CustomKeywords.'com.kms.VerifyPage.VerifyPage.VerifyFileDownloaded'(printFile)

WebUI.closeBrowser()


