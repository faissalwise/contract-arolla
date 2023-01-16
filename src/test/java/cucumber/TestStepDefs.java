package cucumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import cucumber.Employee.ContractType;
import io.cucumber.java.en.And;
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

  @Given("employee joined on {string}")
  public void employeeJoinedOn(String arg0) {
    employee = new Employee(arg0);
  }

  @And("employee validated is {string}")
  public void employeeValidatedIs(String arg0) {
    employee.setValidated(Boolean.parseBoolean(arg0));
  }

  @Then("contract type is {string}")
  public void contractTypeIs(String arg0) {
    assertEquals(ContractType.valueOf(arg0.toUpperCase()), employee.getContractType());
  }

  @When("determine contract type for {string}")
  public void determineContractTypeFor(String arg0) {
    employee.determineContractType(arg0);
  }
}
