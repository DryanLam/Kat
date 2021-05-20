import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import internal.GlobalVariable as GlobalVariable

def TAGS_EXECUTION = ""

if(GlobalVariable.IS_PROFILING == true) {
	TAGS_EXECUTION = "Regession"
} else {
	TAGS_EXECUTION = GlobalVariable.TAGS
}

CucumberKW.runFeatureFolderWithTags('Include/features', TAGS_EXECUTION)