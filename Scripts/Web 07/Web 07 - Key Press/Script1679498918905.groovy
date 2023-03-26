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

WebUI.click(findTestObject('Object Repository/Web 07/Key Press'))

//1. 'Key Presses' header title is displayed
WebUI.verifyElementPresent(findTestObject('Object Repository/Web 07/Header Title'), 3)

WebUI.verifyElementVisible(findTestObject('Object Repository/Web 07/Header Title'))

WebUI.getText(findTestObject('Object Repository/Web 07/Header Title')).equals('Key Presses')

//2. Presses 'TAB' key --> Message: You entered: TAB
WebUI.sendKeys(findTestObject('Object Repository/Web 07/Input text'), Keys.chord(Keys.TAB))

WebUI.verifyElementText(findTestObject('Object Repository/Web 07/Result'), 'You entered: TAB')

//2. Presses 'ENTER' key --> Message: You entered: ENTER

WebUI.sendKeys(null, Keys.chord(Keys.ENTER))

WebUI.verifyElementText(findTestObject('Object Repository/Web 07/Result'), 'You entered: ENTER')

//3. Presses 'G' key --> Message: You entered: ENTER
WebUI.sendKeys(findTestObject('Object Repository/Web 07/Input text'), Keys.chord(Keys.SHIFT, 'g'))

WebUI.verifyElementText(findTestObject('Object Repository/Web 07/Result'), 'You entered: G')

