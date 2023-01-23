package cucumber;

public class Employee {
  private ContractType contractType;
  private int baseSalary;
  private int revenue;

  private boolean validated;
  private String joinedDate;

  public Employee() {

  }

  public void setContractType(ContractType contractType) {
    this.contractType = contractType;
  }

  public void setBaseSalary(int baseSalary) {
    this.baseSalary = baseSalary;
  }

  public void setJoinedDate(String joinedDate) {
    this.joinedDate = joinedDate;
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

  public void setRevenue(int revenue) {
    this.revenue = revenue;
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
