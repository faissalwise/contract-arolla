package cucumber;

public class Employee {

  private String contract;
  private int baseSalary;
  private int margin;

  public Employee(String contract, int baseSalary) {
    this.contract = contract;
    this.baseSalary = baseSalary;
  }

  public int getNetSalary() {
    if ("referent".equals(contract)) {
      return baseSalary + (margin - 35000) * 7 / 100;
    }

    return this.baseSalary;
  }

  public void setMargin(int margin) {
    this.margin = margin;
  }
}
