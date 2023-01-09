package cucumber;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestStepDefs {

  @Given("employee has a {string} contract with a base salary of {int}")
  public void employeeHasAContractWithABaseSalaryOf(String contractType, int baseSalary) {
  }

  @When("employee has received his salary")
  public void employeeHasReceivedHisSalary() {
  }

  @Then("the net salary is {int}")
  public void theNetSalaryIs(int netSalary) {
  }
}
