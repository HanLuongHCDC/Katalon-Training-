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

WebUI.openBrowser(GlobalVariable.Url)

WebUI.waitForPageLoad(GlobalVariable.TimeOut)

WebUI.maximizeWindow()

WebUI.verifyElementVisible(findTestObject('Object Repository/Web 09/Horizontal Slider'))

WebUI.click(findTestObject('Object Repository/Web 09/Horizontal Slider'))

WebUI.waitForPageLoad(GlobalVariable.TimeOut)

//Verify Header Title
WebUI.verifyElementVisible(findTestObject('Object Repository/Web 09/Header Title'))

WebUI.verifyElementText(findTestObject('Object Repository/Web 09/Header Title'), 'Horizontal Slider')

//Set value for slider = 1

WebUI.dragAndDropByOffset(findTestObject('Object Repository/Web 09/Slider bar'), 0, 0)

WebUI.dragAndDropByOffset(findTestObject('Object Repository/Web 09/Slider bar'), -30, 0)

WebUI.verifyElementText(findTestObject('Object Repository/Web 09/Range Value'), '1')

//Set value for slider = 2.5

WebUI.dragAndDropByOffset(findTestObject('Object Repository/Web 09/Slider bar'), 0, 0)

WebUI.verifyElementText(findTestObject('Object Repository/Web 09/Range Value'), '2.5')

//Set value for slider = 4.5

WebUI.dragAndDropByOffset(findTestObject('Object Repository/Web 09/Slider bar'), 50, 0)

WebUI.verifyElementText(findTestObject('Object Repository/Web 09/Range Value'), '4.5')

WebUI.closeBrowser()