package cucumber;

public class Employee {
  private final SalaryService salaryService = new SalaryService(this);
  private ContractType contractType;
  private int baseSalary;
  private int revenue;

  private boolean validated;
  private String joinedDate;

  public void setContractType(ContractType contractType) {
    this.contractType = contractType;
  }

  public SalaryService getSalaryService() {
    return salaryService;
  }

  public int getBaseSalary() {
    return baseSalary;
  }

  public int getRevenue() {
    return revenue;
  }

  public boolean isValidated() {
    return validated;
  }

  public String getJoinedDate() {
    return joinedDate;
  }

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
    return salaryService.getNetSalary();
  }

  public void setRevenue(int revenue) {
    this.revenue = revenue;
  }

  public int calculateMargin() {
    return salaryService.calculateMargin();
  }

  public void determineContractType(String today) {
    salaryService.determineContractType(today);
  }

  public enum ContractType {
    NORMAL(0),
    REFERENT(7),
    CONSULTING(15);

    public final int percent;

    ContractType(int percent) {
      this.percent = percent;
    }

  }
}
