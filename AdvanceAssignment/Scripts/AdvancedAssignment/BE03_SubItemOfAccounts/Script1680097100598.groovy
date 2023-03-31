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
import internal.GlobalVariable

import static org.junit.Assert.assertFalse

import org.openqa.selenium.Keys as Keys

'Step 1:'
'Navigate and login as Admin to page'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.NavigateToLoginPage'()
CustomKeywords.'com.kms.VerifyPage.VerifyPage.InputEmailPasswordAndLogin'(GlobalVariable.email, GlobalVariable.password)


'Step 2:'
'''Click on "Accounts" of Menu bar on the left side of the screen'''
WebUI.verifyElementVisible(findTestObject('Object Repository/AdvancedAssignment/BE03_SubItemOfAccounts/moduleAccounts'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE03_SubItemOfAccounts/moduleAccounts'), FailureHandling.STOP_ON_FAILURE)
'ER:'
'''The sub list of "Accounts" includes 5 items'''
CustomKeywords.'com.kms.VerifyPage.VerifyPage.GetElementSize'(findTestObject('Object Repository/AdvancedAssignment/BE03_SubItemOfAccounts/accountsSublist'), accountsSublist)


'Step 3:'
'''Click on "Admins" option of "Accounts"'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE03_SubItemOfAccounts/accountsAdmins'))
'ER:'
'Navigate to Admins page successful'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.NavigateToPage'(urlAdmins)


'Step 4:'
'''Click on "Suppliers" option of "Accounts"'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE03_SubItemOfAccounts/moduleAccounts'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE03_SubItemOfAccounts/accountsSuppliers'))
'ER:'
'Navigate to Suppliers page successful'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.NavigateToPage'(urlSuppliers)


'Step 5:'
'''Click on "Agents" option of "Accounts"'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE03_SubItemOfAccounts/moduleAccounts'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE03_SubItemOfAccounts/accountsAgents'))
'ER:'
'Navigate to Agents page successful'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.NavigateToPage'(urlAgents)


'Step 6:'
'''Click on "Customers" option of "Accounts"'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE03_SubItemOfAccounts/moduleAccounts'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE03_SubItemOfAccounts/accountsCustomers'))
'ER:'
'Navigate to Customers page successful'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.NavigateToPage'(urlCustomers)


'Step 7:'
'''Click on "Guest Customers" option of "Accounts"'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE03_SubItemOfAccounts/moduleAccounts'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/BE03_SubItemOfAccounts/accountsGuest'))
'ER:'
'Navigate to Guest Customers page successful'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.NavigateToPage'(urlGuest)

WebUI.closeBrowser()