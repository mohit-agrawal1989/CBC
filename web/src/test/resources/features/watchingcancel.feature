@all
Feature: Watching Cancel

  @watchingcancel

  Scenario:C1503733  "Keep Watching Carousel - Cancel"

    Given I navigate to the CBS Digital website
    When I click on sign in button
    And I enter the email and password in sign in page
    Then I observe Edit mode turns on; Cancel, Remove and select options displayed
    And I observe Edit mode turns off