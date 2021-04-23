package com.dryan.page

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


class BaseAction {
	def navigateTo(def url) {
		WebUI.navigateToUrl(url);
	}

	def waitForPageLoad(int timeOut) {
		WebUI.waitForPageLoad(timeOut)
	}
}
