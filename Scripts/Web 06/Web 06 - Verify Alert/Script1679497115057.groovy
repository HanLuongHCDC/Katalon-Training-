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

WebUI.openBrowser('https://the-internet.herokuapp.com/')

WebUI.waitForPageLoad(5)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Web 06/JS Alert'))

WebUI.delay(3)

//1. 'JavaScript Alerts' header title is displayed

WebUI.verifyElementPresent(findTestObject('Object Repository/Web 06/Header Title'), 3)

WebUI.verifyElementVisible(findTestObject('Object Repository/Web 06/Header Title'))

WebUI.getText(findTestObject('Object Repository/Web 06/Header Title')).equals('JavaScript Alerts')

//2. 'I am a JS Alert' message is displayed

WebUI.click(findTestObject('Object Repository/Web 06/Click for JS Alert'))

WebUI.verifyAlertPresent(3)

WebUI.waitForAlert(3)

WebUI.getAlertText().equals('I am a JS Alert')

//3. Result message: You successfuly clicked an alert

WebUI.acceptAlert()

WebUI.getText(findTestObject('Object Repository/Web 06/Result')).equals('You successfuly clicked an alert')

//4.Click to JS Confirm and cancel alert --> Result message: You clicked: Cancel

WebUI.click(findTestObject('Object Repository/Web 06/JS Confirm'))

WebUI.verifyAlertPresent(3)

WebUI.waitForAlert(3)

WebUI.dismissAlert()

WebUI.getText(findTestObject('Object Repository/Web 06/Result')).equals('You clicked: Cancel')

//5. Click to JS Prompt and set text --> Result message: You entered: Hello

WebUI.click(findTestObject('Object Repository/Web 06/JS Prompt'))

WebUI.verifyAlertPresent(3)

WebUI.waitForAlert(3)

WebUI.setAlertText('Hello')

text = WebUI.getAlertText()

WebUI.acceptAlert()

WebUI.getText(findTestObject('Object Repository/Web 06/Result')).equals('You entered: ' + text)