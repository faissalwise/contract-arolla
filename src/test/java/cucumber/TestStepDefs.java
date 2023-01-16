package cucumber;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestStepDefs {

  private Employee employee;

  @Given("employee has a {string} contract with a base salary of {int}")
  public void employeeHasAContractWithABaseSalaryOf(String contractType, int baseSalary) {
    employee = new Employee(contractType, baseSalary);
  }

  @Then("the net salary is {int}")
  public void theNetSalaryIs(int netSalary) {
    assertThat(employee.getNetSalary()).isEqualTo(netSalary);
  }

  @When("revenue is {int}")
  public void revenueIs(int revenue) {
    employee.setRevenue(revenue);
  }
}
