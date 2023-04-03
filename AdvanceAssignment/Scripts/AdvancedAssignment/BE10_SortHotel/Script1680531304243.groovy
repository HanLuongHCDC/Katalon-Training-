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
'Navigate and login as Admin to Hotel page'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.LoginPage'(GlobalVariable.urlHotels)
CustomKeywords.'com.kms.VerifyPage.VerifyPage.InputEmailPasswordAndLogin'(GlobalVariable.email, GlobalVariable.password)


'Step 2:'
'''Click on "Name" column'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE10_SortHotel/columnName'), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'The Hotel name sort by alphabetical from Z-A'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.SortWebTable'(false, columnName)


'Step 3:'
'''Click on "Name" column'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE10_SortHotel/columnName'), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'The Hotel name sort by alphabetical from A-Z'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.SortWebTable'(true, columnName)


'Step 4:'
'''Click on "Owner By" column'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE10_SortHotel/columnOwnerBy'), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'The Hotel name sort by alphabetical from Z-A'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.SortWebTable'(true, columnOwnerBy)


'Step 5:'
'''Click on "Owner By" column'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE10_SortHotel/columnOwnerBy'), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'The Hotel name sort by alphabetical from A-Z'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.SortWebTable'(false, columnOwnerBy)