package test.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class test {

    @Given("give step")
    public void login() {
        System.out.println("step given");
    }

    @When("when step")
    public void user() {
        System.out.println("step when");
    }

    @Then("then step")
    public void main() {
        System.out.println("step then");
    }



}
