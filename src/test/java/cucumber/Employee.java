package cucumber;

public class Employee {

  private String contract;
  private int baseSalary;

  public Employee(String contract, int baseSalary) {
    this.contract = contract;
    this.baseSalary = baseSalary;
  }

  public int getNetSalary(){
    return this.baseSalary;
  }

}
