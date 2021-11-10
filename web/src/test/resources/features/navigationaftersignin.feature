@all
Feature: Navigation After Sign In

  @navigationaftersignin

  Scenario: C1503671 "Verify navigation menu (after sign in)"
    Given I navigate to the CBS Digital website
    When I click on Sign In
    And I am at the sign in page
    When I enter the email and password as "aqatv001p@gmail.com" and "aaaaaa"
    And I click continue
    Then I observe Home | Shows | Live TV | Schedule | TV Provider | Search | Sign In Options | Try Paramount+