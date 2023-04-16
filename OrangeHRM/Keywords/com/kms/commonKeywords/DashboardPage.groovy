package com.kms.commonKeywords

import org.openqa.selenium.By
import org.openqa.selenium.Rectangle
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

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
//		driver.manage().window().setSize(new Dimension(375, 812))
		def canvas = driver.findElement(By.xpath("//p[contains(.,'Location')]//ancestor::div[contains(@class,'widget-header')]//following-sibling::div[contains(@class,'widget-body')]//canvas"))
//		def canvas_dimension = canvas.getSize()
//		println(canvas_dimension)
//		def canvas_center_x = canvas_dimension.getWidth()/2
//		def canvas_center_y = canvas_dimension.getHeight()/2
//		int button_x = (canvas_center_x/3)*2
//		int button_y = (canvas_center_y/3)*2
//		println(button_x)
//		println(button_y)
////		WebUI.mouseOverOffset(findTestObject('Object Repository/TC010_VerifyDashboardChart/canvasChartLocation'), button_x, button_y, FailureHandling.CONTINUE_ON_FAILURE)
//		new Actions(driver).moveToElement(canvas, button_x, button_y).click().perform()
		Rectangle r = canvas.getRect()
		println(r.getX())
		println(r.getY())
		int button_x = (r.getX()/3)*2
		int button_y = (r.getY()/3)*2
		new Actions(driver).moveToElement(canvas, button_x, button_y).click().perform()
//		WebUI.mouseOverOffset(findTestObject('Object Repository/TC010_VerifyDashboardChart/canvasChartLocation'), r.getX(), r.getY(), FailureHandling.CONTINUE_ON_FAILURE)
		
	}
}
