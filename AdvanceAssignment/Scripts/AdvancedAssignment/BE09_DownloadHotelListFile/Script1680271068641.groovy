import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.Robot;
import java.awt.event.KeyEvent

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
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


