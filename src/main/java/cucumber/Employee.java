package cucumber;

public class Employee {
  private final ContractType contractType;
  private final int baseSalary;
  private int margin;

  public Employee(String contract, int baseSalary) {
    this.contractType = ContractType.valueOf(contract.toUpperCase());
    this.baseSalary = baseSalary;
  }

  public int getNetSalary() {
    return baseSalary + (margin - 35000) * contractType.percent / 100;
  }

  public void setMargin(int margin) {
    this.margin = margin;
  }

  private enum ContractType {
    NORMAL(0), REFERENT(7), CONSULTING(15);

    private final int percent;

    ContractType(int percent) {
      this.percent = percent;
    }
  }
}
