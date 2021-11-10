@all
Feature: Email

  @email

  Scenario: C1503578 "Email"
    Given I navigate to the CBS Digital website
    When I click on Sign In
    And I am at the sign in page
    Then Email field displays current email
