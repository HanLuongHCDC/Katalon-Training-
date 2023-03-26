package com.helper.webtable

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory



public class GridHelper {
@Keyword
	public void SortFunction() {

		WebDriver driver = DriverFactory.getWebDriver()

		List<WebElement> element = driver.findElements(By.xpath("//table[@id='table2']//tr/td[3]"));

		List<String> originalList = new ArrayList<String>();

		List<String> tempList = new ArrayList<String>();

		for(int i=0;i < element.size();i++) {

			String str=element.get(i).getText();

			originalList.add(str);

			tempList.add(str);
		}

		Collections.sort(tempList);

		if(tempList.equals(originalList)){

			KeywordUtil.markPassed("Sort function is working");
		}
		else {

			KeywordUtil.markFailed("Sort function is not working");
		}
	}
}
