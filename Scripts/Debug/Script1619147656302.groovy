import com.dryan.page.BasePage
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


"Precondition - Start browser & init page factory"
def page = BasePage.initialize()


"Step 1: Navigate to Homepage"
page.navigateTo("https://demoqa.com/buttons")


"Step 2: Delay a certain time"
page.waitForPageLoad(5)

"Step 3: Click on button"
page.homePage.clickButton("Submit")

"Step 4: Close browser"
WebUI.closeBrowser()