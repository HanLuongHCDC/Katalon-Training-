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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement
import com.kms.commonKeywords.DashboardPage
import com.kms.commonKeywords.BuzzPage
import com.kms.commonKeywords.commonKeywords

'Pre-condition'
String clkItem = 'Dashboard'
String titleBuzzPage = 'Buzz'
String headerBuzzNewsfeed = 'Buzz Newsfeed'
String post = 'Hello everyone'
String username = '@@Admin@'
String password = '123Admin@@'
String location = 'New York Sales Office'
'Navigate to https://opensource-demo.orangehrmlive.com/'
WebUI.openBrowser(GlobalVariable.url)
'Add new admin user'
commonKeywords.createNewAdminAccount(0, 0, username, password)
'Login to the system successfully'
commonKeywords.logInPage(username, password)
'Get the full name of employee'
String name = BuzzPage.getFullName()
'Navigate to Dashboard page'
WebUI.click(findTestObject('Object Repository/CommonTestObject/clkItem', [('item') : clkItem]), FailureHandling.STOP_ON_FAILURE)


'Step 1:'
'Look at Employee Distribution by Location and click to the orange piece'
DashboardPage.clickItemChartLocation(findTestObject('Object Repository/TC010_VerifyDashboardChart/chartLocationItem'), location)
WebUI.scrollToElement(findTestObject('Object Repository/TC010_VerifyDashboardChart/titleChartLocation'), GlobalVariable.timeOut)
DashboardPage.interactWithChart()
String txtPercent = WebUI.getText(findTestObject('Object Repository/TC010_VerifyDashboardChart/dataChart'), FailureHandling.CONTINUE_ON_FAILURE).split('\\(')[1].split('\\%')[0]
println(txtPercent)
'ER:'
'Verify the New York Sales Office display correctly'
def percent = DashboardPage.percentChartLocation()//Get percent of chart in Directory menu and compare with actual data get from chart in Dashboard menu
WebUI.verifyEqual(txtPercent, percent, FailureHandling.CONTINUE_ON_FAILURE)


'Step 2:'
'Click to Buzz menu'
WebUI.click(findTestObject('Object Repository/CommonTestObject/clkItem', [('item') : titleBuzzPage]), FailureHandling.STOP_ON_FAILURE)
'ER:'
'The Buzz news feed displays - Verify title page is Buzz'
WebUI.verifyElementText(findTestObject('Object Repository/CommonTestObject/titlePage'), titleBuzzPage, FailureHandling.CONTINUE_ON_FAILURE)
'Verify header of Buzz page is Buzz Newsfeed'
WebUI.verifyElementText(findTestObject('Object Repository/TC010_VerifyDashboardChart/titleBuzzNewsFeed'), headerBuzzNewsfeed, FailureHandling.CONTINUE_ON_FAILURE)


'Step 3:'
'''Post something as: "Hello everyone" (it should random)'''
WebUI.setText(findTestObject('Object Repository/TC010_VerifyDashboardChart/txtPost'), post, FailureHandling.STOP_ON_FAILURE)
'Click on Post button'
WebUI.click(findTestObject('Object Repository/TC010_VerifyDashboardChart/btnPost'), FailureHandling.STOP_ON_FAILURE)
String dateTime = BuzzPage.getDate()
'ER:'
'The post will be posted successfully - Check the name and the post of user displays'
WebUI.verifyElementVisible(findTestObject('Object Repository/TC010_VerifyDashboardChart/tryBody',  [('name') : name, ('dateTime') : dateTime, ('body') : post]), FailureHandling.CONTINUE_ON_FAILURE)
List<WebElement> listPost = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/TC010_VerifyDashboardChart/tryBody', [('name') : name, ('dateTime') : dateTime, ('body') : post]), GlobalVariable.longTime)
WebUI.verifyEqual(listPost.size(), 1, FailureHandling.CONTINUE_ON_FAILURE)//verify only 1 post is displayed


'Step 4:'
'Pre-condition'
def beforeClickingHeart = WebUI.getText(findTestObject('Object Repository/TC010_VerifyDashboardChart/totalLikes',[('name') : name, ('dateTime') : dateTime, ('body') : post]), FailureHandling.CONTINUE_ON_FAILURE).split(" ")[0]
'''Click "heart" icon to like the post'''
WebUI.click(findTestObject('Object Repository/TC010_VerifyDashboardChart/btnHeart', [('name') : name, ('dateTime') : dateTime, ('body') : post]), FailureHandling.CONTINUE_ON_FAILURE)
'ER:'
'The number of like is increased by 1'
def afterClickingHeart = WebUI.getText(findTestObject('Object Repository/TC010_VerifyDashboardChart/totalLikes',[('name') : name, ('dateTime') : dateTime, ('body') : post]), FailureHandling.CONTINUE_ON_FAILURE).split(" ")[0]
WebUI.verifyEqual(Integer.parseInt(beforeClickingHeart), Integer.parseInt(afterClickingHeart) - 1, FailureHandling.CONTINUE_ON_FAILURE)


'Step 5:'
'Back to Dashboard page'
WebUI.back(FailureHandling.STOP_ON_FAILURE)
WebUI.refresh(FailureHandling.CONTINUE_ON_FAILURE)//need to refresh to display the newest post
'ER:'
'The dashboard page is displayed - The new post is also displayed in the Buzz Latest Posts section'
WebUI.verifyElementText(findTestObject('Object Repository/CommonTestObject/titlePage'), clkItem, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementVisible(findTestObject('Object Repository/TC010_VerifyDashboardChart/dashboardBodyPost', [('name') : name, ('dateTime') : dateTime, ('body') : post]), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()