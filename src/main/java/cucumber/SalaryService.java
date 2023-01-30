package cucumber;

import cucumber.Employee.ContractType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryService {
  private final Calendar calendar;

  public SalaryService(Calendar calendar) {
    this.calendar = calendar;
  }

  public int getNetSalary(Employee employee) {
    return employee.getBaseSalary()
        + Math.max(
        0, (calculateMargin(employee) - 35000) * determineContractType(employee).percent / 100);
  }

  private int calculateMargin(Employee employee) {
    return employee.getRevenue() - (employee.getBaseSalary() * 16 / 10);
  }

  public ContractType determineContractType(Employee employee) {
    if(employee.getContractType() == null){
      if (employee.isValidated()) {
        employee.setContractType(Employee.ContractType.CONSULTING);
      } else {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate joinedLocalDate = LocalDate.parse(employee.getJoinedDate(), formatter);
        LocalDate todayLocalDate = calendar.today();
        int years = todayLocalDate.getYear() - joinedLocalDate.getYear();
        if (years > 2) {
          employee.setContractType(Employee.ContractType.REFERENT);
        }
        else {
          employee.setContractType(Employee.ContractType.NORMAL);
        }
      }
    }
    return  employee.getContractType();
  }
}
