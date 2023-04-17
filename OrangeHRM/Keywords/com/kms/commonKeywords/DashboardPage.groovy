package com.kms.commonKeywords

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class DashboardPage {
	@Keyword
	public void clickItemChartLocation(testObject, String eItem) {
		List<WebElement> listItem = WebUiCommonHelper.findWebElements(testObject, GlobalVariable.longTime)
		for(int i=0; i < listItem.size(); i++) {
			String item = listItem.get(i).getText()
			println(item)
			if(!item.equals(eItem)) {
				listItem.get(i).click()
				println('The item ' + item + ' is removed')
			}
			else {
				println('Keeping the item ' + item)
			}
		}
	}
	
	@Keyword
	public void interactWithChart() {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement canvas = driver.findElement(By.xpath("//p[contains(.,'Location')]//ancestor::div[contains(@class,'widget-header')]//following-sibling::div[contains(@class,'widget-body')]//canvas"))
		def canvas_dimension = canvas.getSize()
		println(canvas_dimension)
		def canvas_center_x = canvas_dimension.getWidth()/2
		def canvas_center_y = canvas_dimension.getHeight()/2
		int button_x = (canvas_center_x/3)
		int button_y = (canvas_center_y/3)
		println(button_x)
		println(button_y)
		new Actions(driver).moveToElement(canvas, button_x, button_y).click().build().perform()
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", canvas)
//		executor.executeScript("arguments[0].click();", canvas);		
	}
	
	@Keyword
	public def percentChartLocation() {
		WebUI.click(findTestObject('Object Repository/CommonTestObject/clkItem', [('item') : 'Directory']), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/CommonTestObject/btnSearch'), FailureHandling.STOP_ON_FAILURE)
		def totalRecord = WebUI.getText(findTestObject('Object Repository/CommonTestObject/recordFound'), FailureHandling.CONTINUE_ON_FAILURE).split("\\) ")[0].replace("(", "")
		println(totalRecord)
		//Check the number of records of specified Location
		WebUI.click(findTestObject('Object Repository/TC006_VerifyDirectory/ddLocation'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/TC006_VerifyDirectory/selectLocation'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/CommonTestObject/btnSearch'), FailureHandling.STOP_ON_FAILURE)
		def locationRecord = WebUI.getText(findTestObject('Object Repository/CommonTestObject/recordFound'), FailureHandling.CONTINUE_ON_FAILURE).split("\\) ")[0].replace("(", "")
		println(locationRecord)
		float percent = (Integer.parseInt(locationRecord)/Integer.parseInt(totalRecord))*100
		println(String.format('%.2f', percent))
		return String.format('%.2f', percent)
	}
}
