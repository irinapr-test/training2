package test.cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/resources/featureFile",
        monochrome= true,
        glue={"cucumber"}
       )
public class CucumberTestRunnerJUNIT {

       /*
       java.lang.AbstractMethodError: Receiver class io.cucumber.junit.JUnitCucumberOptionsProvider$JunitCucumberOptions does not define or inherit an implementation of the resolved method 'abstract boolean strict()' of interface io.cucumber.core.options.CucumberOptionsAnnotationParser$CucumberOptions.
       */
}
