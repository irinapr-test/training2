package test.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features="src/test/java/resources/featureFile/E2E.feature",
        monochrome= true,
        glue={"test.cucumber.E2EStepDefinitionImplementation"}
       )
public class CucumberTestRunnerTestNg extends AbstractTestNGCucumberTests {

/*
java.lang.AbstractMethodError: Receiver class io.cucumber.testng.TestNGCucumberOptionsProvider
$TestNGCucumberOptions does not define or inherit an implementation of the resolved method '
abstract boolean strict()' of interface io.cucumber.core.options.CucumberOptionsAnnotationParser$CucumberOptions.
 */


}
