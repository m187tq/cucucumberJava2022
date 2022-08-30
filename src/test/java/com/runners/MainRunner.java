package com.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/java/com/features/"},
        glue = {"com/steps"},
        //tags = "@Login_Both",
        //tags = "@LoginValidCredentials",
        tags = "@RegistrationFunctionality",
        //tags = "@NegativeLogin",
        //tags = "@e2e_array",
        //tags = "@e2e",
        monochrome = true,
        //dryRun = false,
        //Strict = false,
        //name = "Login",
        plugin = {"pretty",
                "html:target/cucumber",
                "json:target/cucumber.json",
                "html:target/cucumber-reports/cucumber-pretty",
                "rerun:target/cucumber-reports/rerun.txt" })

public class MainRunner extends AbstractTestNGCucumberTests {
// Parallel scenario execution //
 @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
