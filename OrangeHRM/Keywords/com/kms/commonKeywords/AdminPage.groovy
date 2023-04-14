package com.kms.commonKeywords

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.Random

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class AdminPage {
	
	@Keyword
	public void addNewAdmin(String role, String employee, String status, String username, String password) {
		List<String> headerAddUser = ['User Role', 'Employee Name', 'Status', 'Username', 'Password', 'Confirm Password']
		'Select User Role: Admin'
		WebUI.click(findTestObject('Object Repository/CommonTestObject/ddInfo', [('ddHeader') : headerAddUser[0]]), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/CommonTestObject/CreateNewAdmin/ddSelectItem', [('ddHeader') : headerAddUser[0], ('selectItem') : role]), FailureHandling.STOP_ON_FAILURE)
		'Select Employee Name'
		WebUI.setText(findTestObject('Object Repository/CommonTestObject/CreateNewAdmin/txtInfo', [('txtHeader') : headerAddUser[1]]), employee, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/CommonTestObject/CreateNewAdmin/selectEmployeeName'), GlobalVariable.longTime, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/CommonTestObject/CreateNewAdmin/selectEmployeeName'), FailureHandling.STOP_ON_FAILURE)
		'Select Status: Enabled'
		WebUI.click(findTestObject('Object Repository/CommonTestObject/ddInfo', [('ddHeader') : headerAddUser[2]]), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/CommonTestObject/CreateNewAdmin/ddSelectItem', [('ddHeader') : headerAddUser[2], ('selectItem') : status]), FailureHandling.STOP_ON_FAILURE)
		'Enter Username'
		WebUI.setText(findTestObject('Object Repository/CommonTestObject/CreateNewAdmin/txtInfo', [('txtHeader') : headerAddUser[3]]), username, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/CommonTestObject/CreateNewAdmin/warningCharacterUsername'), GlobalVariable.timeOut, FailureHandling.CONTINUE_ON_FAILURE)
		'Enter Password'
		WebUI.setText(findTestObject('Object Repository/CommonTestObject/CreateNewAdmin/txtInfo', [('txtHeader') : headerAddUser[4]]), password, FailureHandling.CONTINUE_ON_FAILURE)
		'Enter Confirm Password'
		WebUI.setText(findTestObject('Object Repository/CommonTestObject/CreateNewAdmin/txtInfo', [('txtHeader') : headerAddUser[5]]), password, FailureHandling.CONTINUE_ON_FAILURE)
		'Click Save button'
		WebUI.click(findTestObject('Object Repository/CommonTestObject/btnSave'), FailureHandling.STOP_ON_FAILURE)
		'Verify Loading Spinner is disappeared'
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/CommonTestObject/CreateNewAdmin/loadingSpinner'), GlobalVariable.longTime, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	@Keyword
	public void creatTotalRecordAdminUser(int eRecord) {
		def record = WebUI.getText(findTestObject('Object Repository/CommonTestObject/recordFound'), FailureHandling.CONTINUE_ON_FAILURE).split("\\) ")[0].replace("(", "")
		println(record)
		int aRecord = Integer.parseInt(record)
		while(Integer.parseInt(record) < eRecord) {
				WebUI.click(findTestObject('Object Repository/CommonTestObject/clkItem', [('item') : 'Admin']), FailureHandling.STOP_ON_FAILURE)
				WebUI.click(findTestObject('Object Repository/CommonTestObject/CreateNewAdmin/btnAddAdminUser'), FailureHandling.STOP_ON_FAILURE)
				Random rd = new Random()
				int randomNumber = rd.nextInt(100)
				addNewAdmin('Admin','o', 'Enabled','\\$$Admin$$admin\\' + randomNumber,'Admin123@@')
				record = WebUI.getText(findTestObject('Object Repository/CommonTestObject/recordFound'), FailureHandling.CONTINUE_ON_FAILURE).split("\\) ")[0].replace("(", "")
		}
		println('Data is prepared')
	}
	
	@Keyword
	public List<String> GetInfoCellFromTable(TestObject, String username) {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> infoCell = WebUiCommonHelper.findWebElements(TestObject, GlobalVariable.longTime)
		List<String> listFileName = new ArrayList<String>()
		for (int i=0; i < infoCell.size(); i++) {
			String cell = infoCell.get(i).getText()
			listFileName.add(cell)
		}
		println(listFileName)
		return listFileName
	}
}
