package com.hrm.runners;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//@ExtendedCucumberOptions(jsonReport = "target/*.json",
//        retryCount = 0,
//        detailedReport = true,
//        detailedAggregatedReport = true,
//        overviewReport = true,
//        coverageReport = true,
//        featureOverviewChart = true,
//        jsonUsageReport = "target/*.json",
//        usageReport = true,
//        screenShotLocation = "/screenshots/",
//        screenShotSize = "300px",
//        toPDF = true,
//        excludeCoverageTags = {"@flaky"},
//        includeCoverageTags = {"@passed"},
//        outputFolder = "target")
@CucumberOptions(

        //1.way
        features= "src/test/resources/features"
//        features = "src/test/resources/features/NegativeLogin.feature"
//        features = "src/test/resources/features/PositiveLogin.feature"
        //2.way
//        features = "classpath:features"
        , glue = "com/hrm/steps"
        //to implement steps if there are not defined in the StepDefintion dryRun = true olarak kullanilir
//        , dryRun = true
        , plugin = {"pretty", "html:target/html/cucumber-default", "json:target/cucumber.json", "rerun:target/failed.txt"}
//		, tags = "smoke"
        , monochrome = true
)
public class Runner {

}