package com.helper.downloadfile

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil

public class DownloadFile {

	@Keyword
	public void VerifyFileDownloaded() {

		File downloadFolder = new File("C:\\Users\\hanluong\\Downloads");
		List downloadFile = Arrays.asList(downloadFolder.list());

		if (downloadFile.contains('menu.csv')) {
			KeywordUtil.markPassed("Download file successfully")
		}
		else {
			KeywordUtil.markFailed("Download file failed")
		}
	}
}
