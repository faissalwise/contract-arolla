package cucumber;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Then;

public class TestStepDefs {

  @Then("fail")
  void fail() {
    assertThat(true).isFalse();
  }
}
