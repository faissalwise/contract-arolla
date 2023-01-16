package cucumber;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
  private ContractType contractType;
  private int baseSalary;
  private int revenue;

  private boolean validated;
  private String joinedDate;

  public void setValidated(boolean validated) {
    this.validated = validated;
  }

  public ContractType getContractType() {
    return contractType;
  }

  public Employee(String joinedDate) {
    this.joinedDate = joinedDate;
  }

  public Employee(String contract, int baseSalary) {
    this.contractType = ContractType.valueOf(contract.toUpperCase());
    this.baseSalary = baseSalary;
  }

  public int getNetSalary() {
    return baseSalary + Math.max(0, (calculateMargin() - 35000) * contractType.percent / 100);
  }

  public void setRevenue(int revenue) {
    this.revenue = revenue;
  }

  public int calculateMargin() {
    return revenue - (baseSalary * 16 / 10);
  }

  public void determineContractType(String today) {
    if (validated) {
      contractType = ContractType.CONSULTING;
    } else {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      LocalDate joinedLocalDate = LocalDate.parse(this.joinedDate, formatter);
      LocalDate todayLocalDate = LocalDate.parse(today, formatter);
      int years = todayLocalDate.getYear() - joinedLocalDate.getYear();
      if (years > 2) contractType = ContractType.REFERENT;
      else contractType = ContractType.NORMAL;
    }
  }

  public enum ContractType {
    NORMAL(0),
    REFERENT(7),
    CONSULTING(15);

    private final int percent;

    ContractType(int percent) {
      this.percent = percent;
    }
  }
}
