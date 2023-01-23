package cucumber;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryService {

    public int getNetSalary(Employee employee) {
        return employee.getBaseSalary() + Math.max(0, (calculateMargin(employee) - 35000) * employee.getContractType().percent / 100);
    }

    private int calculateMargin(Employee employee) {
        return employee.getRevenue() - (employee.getBaseSalary() * 16 / 10);
    }

    public void determineContractType(String today, Employee employee) {
        if (employee.isValidated()) {
            employee.setContractType(Employee.ContractType.CONSULTING);
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate joinedLocalDate = LocalDate.parse(employee.getJoinedDate(), formatter);
            LocalDate todayLocalDate = LocalDate.parse(today, formatter);
            int years = todayLocalDate.getYear() - joinedLocalDate.getYear();
            if (years > 2) employee.setContractType(Employee.ContractType.REFERENT);
            else employee.setContractType(Employee.ContractType.NORMAL);
        }
    }
}