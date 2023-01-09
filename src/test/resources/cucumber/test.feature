Feature: Test Contracts

  Scenario: Normal contract
    Given employee has a "normal" contract with a base salary of 1000
    Then the net salary is 1000

  Scenario: Referent contract
    Given employee has a "referent" contract with a base salary of 1500
    When margin is 45000
    Then the net salary is 2200