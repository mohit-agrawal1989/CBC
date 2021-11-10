@all
Feature: Show Poster

  @showposter

  Scenario: C1503946" Show Poster Art displayed for all the shows in search results"
    Given I navigate to the CBS Digital website

    Then I type show and observe Show Poster Art displayed for all the shows in search results
