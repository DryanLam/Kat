import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import internal.GlobalVariable as GlobalVariable

def TAGS_EXECUTION = ""

if(GlobalVariable.IS_PROFILING == "true") {
	TAGS_EXECUTION = "@Regression"
} else {
	TAGS_EXECUTION = GlobalVariable.TAGS
}

println(GlobalVariable.IS_PROFILING)
println(TAGS_EXECUTION)

CucumberKW.runFeatureFolderWithTags('Include/features', TAGS_EXECUTION)