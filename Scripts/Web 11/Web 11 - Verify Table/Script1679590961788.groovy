import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.Url)

WebUI.waitForPageLoad(GlobalVariable.TimeOut)

WebUI.maximizeWindow()

WebUI.verifyElementVisible(findTestObject('Object Repository/Web 11/Sortable Data Table'))

WebUI.click(findTestObject('Object Repository/Web 11/Sortable Data Table'))

WebUI.waitForPageLoad(GlobalVariable.TimeOut)

// Verify Header Title is displayed
WebUI.verifyElementVisible(findTestObject('Object Repository/Web 11/Header Title'))

WebUI.verifyElementText(findTestObject('Object Repository/Web 11/Header Title'), 'Data Tables')

//Verify header at column 3 Table 1 = Email
WebUI.verifyElementVisible(findTestObject('Object Repository/Web 11/Column 3 Table 1'))

WebUI.verifyElementText(findTestObject('Object Repository/Web 11/Column 3 Table 1'), 'Email')

//Verify Row 3 Column 2 = Jason
WebUI.verifyElementVisible(findTestObject('Object Repository/Web 11/Column 2 Row 3'))

WebUI.verifyElementText(findTestObject('Object Repository/Web 11/Column 2 Row 3'), 'Jason')

//Verify Row 2 Column 4 = $51.00
WebUI.verifyElementVisible(findTestObject('Object Repository/Web 11/Column 4 Row 2'))

WebUI.verifyElementText(findTestObject('Object Repository/Web 11/Column 4 Row 2'), '$51.00')

// Verify column sort
WebUI.verifyElementVisible(findTestObject('Object Repository/Web 11/Email Table 2'))

WebUI.click(findTestObject('Object Repository/Web 11/Email Table 2'))

CustomKeywords.'com.helper.webtable.GridHelper.SortFunction'()

WebUI.closeBrowser()

