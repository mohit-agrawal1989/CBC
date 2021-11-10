@all
Feature: Hidden Password

  @hiddenpassword


  Scenario: C1503653 "Password field displays hidden password (as asterisks)"

    Given I navigate to the CBS Digital website
    When I click on sign in button
    Then I observe Password field displays hidden password