@all
Feature: Navigation

  @navigation

  Scenario: C1503670 "Verify navigation menu (prior to sign in)"
    Given I navigate to the CBS Digital website
    Then I observe Home | Shows | Live TV | Schedule | TV Provider | Search | Sign In Options | Try Paramount+ is displayed