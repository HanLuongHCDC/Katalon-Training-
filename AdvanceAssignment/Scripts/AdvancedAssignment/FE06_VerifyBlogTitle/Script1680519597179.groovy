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
'Navigate to page https://phptravels.net/blog'
CustomKeywords.'com.kms.VerifyPage.VerifyPage.LoginPage'(GlobalVariable.urlBlog)
'ER'
'''Heading title is "PHPTRAVELS BLOG"'''
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/FE06_VerifyBlogTitle/headerBlog'), titleBlog, FailureHandling.CONTINUE_ON_FAILURE)


'Step 2:'
'''Clicking on title of "Peace Train A Long Time Coming item"'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE06_VerifyBlogTitle/btnCookies'), FailureHandling.CONTINUE_ON_FAILURE)//Element of cookies stacks on element of title
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE06_VerifyBlogTitle/titlePost'), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'''Heading title is "Peace Train A Long Time Coming"'''
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/FE06_VerifyBlogTitle/headerItems'), headerPost, FailureHandling.CONTINUE_ON_FAILURE)


'Step 3:'
'Click on browser Back button'
WebUI.back(FailureHandling.STOP_ON_FAILURE)
'ER:'
'''Heading title is "PHPTRAVELS BLOG"'''
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/FE06_VerifyBlogTitle/headerBlog'), titleBlog, FailureHandling.CONTINUE_ON_FAILURE)


'Step 4:'
'''Clicking on share icon of "Peace Train A Long Time Coming item"'''
WebUI.click(findTestObject('Object Repository/AdvancedAssignment/FE06_VerifyBlogTitle/iconPost'), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
''' Heading title is "Peace Train A Long Time Coming"'''
WebUI.verifyElementText(findTestObject('Object Repository/AdvancedAssignment/FE06_VerifyBlogTitle/headerItems'), headerPost, FailureHandling.CONTINUE_ON_FAILURE)