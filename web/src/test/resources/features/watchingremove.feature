@all
Feature: Watching Remove

  @watchingremove

  Scenario:C1503732 "Keep Watching Carousel - Remove"

    Given I navigate to the CBS Digital website
    When I click on sign in button
    And I enter the email and password in sign in page
    Then I observe Edit mode turns on; Cancel, Remove and select options displayed
    Then I observe Selected thumbnails removed