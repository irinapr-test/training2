package test.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features="src/test/java/test/cucumber",
        glue={"stepDefinitions"},
        plugin={"pretty","html:target/cucumber-Report.html", "json:target/report.json"})
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

//TODO failed, can't find a reason


}
