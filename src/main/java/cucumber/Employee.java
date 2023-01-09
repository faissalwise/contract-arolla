package cucumber;

public class Employee {

  private final String contract;
  private final int baseSalary;
  private int margin;

  public Employee(String contract, int baseSalary) {
    this.contract = contract;
    this.baseSalary = baseSalary;
  }

  public int getNetSalary() {
    if ("referent".equals(contract)) {
      return baseSalary + (margin - 35000) * 7 / 100;
    }
    if ("consulting".equals(contract)) {
      return baseSalary + (margin - 35000) * 15 / 100;
    }

    return this.baseSalary;
  }

  public void setMargin(int margin) {
    this.margin = margin;
  }
}
