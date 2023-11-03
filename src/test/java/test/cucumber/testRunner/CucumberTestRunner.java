package test.cucumber.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features="src/test/java/test/cucumber/featureFile",
        glue={"stepDefinitions"}
       )
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

//TODO failed, can't find a reason, in progress


}
