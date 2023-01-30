package cucumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import cucumber.Employee.ContractType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestStepDefs {

  private final Employee employee = new Employee();
  private final Calendar calendar =
      new Calendar() {
        @Override
        public LocalDate today() {
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
          return LocalDate.parse(today, formatter);
        }
      };

  private final SalaryService salaryService = new SalaryService(calendar);
  private String today;

  @Given("employee has a {string} contract with a base salary of {int}")
  public void employeeHasAContractWithABaseSalaryOf(String contractType, int baseSalary) {
    employee.setContractType(ContractType.valueOf(contractType.toUpperCase()));
    employee.setBaseSalary(baseSalary);
  }

  @Then("the net salary is {int}")
  public void theNetSalaryIs(int netSalary) {
    assertThat(salaryService.getNetSalary(employee)).isEqualTo(netSalary);
  }

  @When("revenue is {int}")
  public void revenueIs(int revenue) {
    employee.setRevenue(revenue);
  }

  @Given("employee joined on {string}")
  public void employeeJoinedOn(String joinedDate) {
    employee.setJoinedDate(joinedDate);
  }

  @And("employee validated is {string}")
  public void employeeValidatedIs(String isValidated) {
    employee.setValidated(Boolean.parseBoolean(isValidated));
  }

  @Then("contract type is {string}")
  public void contractTypeIs(String contractType) {
    assertEquals(ContractType.valueOf(contractType.toUpperCase()), employee.getContractType());
  }

  @When("determine contract type for {string}")
  public void determineContractTypeFor(String today) {
    this.today = today;
    salaryService.determineContractType(employee);
  }

  @And("base salary is {int}")
  public void baseSalaryIs(int baseSalary) {
    employee.setBaseSalary(baseSalary);
  }

  @And("today is {string}")
  public void todayIs(String today) {
    this.today=today;
  }
}
