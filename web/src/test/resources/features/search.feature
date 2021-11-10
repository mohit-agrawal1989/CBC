@all
Feature: Search

  @search, @smoke
  Scenario Outline: C1503937 Entering invalid term won't display any results
    Given I navigate to the CBS Digital website
    And I click on the Search Icon
    And I enter an invalid term
    Then there should be no results displayed
    And An invalid search term error should appear

    Examples:
      |userType|
      |Anonymous|
      |Registered|
      |Ghost|
      |AuthZ|

  @search, @smoke
  Scenario Outline: C1503938 Entering valid search term (full title) displays at least one show card
    Given I navigate to the CBS Digital website
    And I click on the Search Icon
    And I enter a valid term
    Then At least one show card should appear

    Examples:
      |userType|
      |Anonymous|
      |Registered|
      |Ghost|
      |AuthZ|

  @search, @smoke
  Scenario Outline: C1503939 Entering a single letter displays results
    Given I navigate to the CBS Digital website
    And I click on the Search Icon
    And I enter a single letter term
    Then At least one show card should appear

    Examples:
      |userType|
      |Anonymous|
      |Registered|
      |Ghost|
      |AuthZ|

  @search, @smoke
  Scenario Outline: C1503940 Entering numbers displays results (if applicable)
    Given I navigate to the CBS Digital website
    And I click on the Search Icon
    And I enter the term "bull"
    Then At least one show card should appear

    Examples:
      |userType|
      |Anonymous|
      |Registered|
      |Ghost|
      |AuthZ|

	#unable to read recently inputted text in the input field
#	@search2
  #Scenario Outline: C1503941 Each character from the search field can be removed manually
  #Given I navigate to the CBS Digital website
  #When I update access as "<userType>"
  #And I click on the Search Icon
  #And I enter the term "random"
  #And I delete one character
  #Then the term should be "rando"
  #And I delete one character
  #Then the term should be "1"
  #And I delete one character
  #Then the search term should be empty

  #Examples:
#	|userType|
#	|Anonymous|
#	|Registered|
#	|Ghost|
#	|AuthZ|

  @search, @smoke
  Scenario Outline: C1503942 Space at the beginning and at the end of the search term ignored
    Given I navigate to the CBS Digital website
    And I click on the Search Icon
    And I enter the term " bull"
    Then At least one show card should appear
    And I clear the search input
    And I enter the term "bull "
    Then At least one show card should appear
    And I clear the search input
    And I enter the term "     bull"
    Then At least one show card should appear
    And I clear the search input
    And I enter the term "bull       "
    Then At least one show card should appear
    And I clear the search input

    Examples:
      |userType|
      |Anonymous|
      |Registered|
      |Ghost|
      |AuthZ|

  @search, @smoke
  Scenario Outline: C1503943 Search results shouldn't go away when entering spaces
    Given I navigate to the CBS Digital website
    And I click on the Search Icon
    And I enter the term "bull"
    Then At least one show card should appear
    And I append the search term with a space
    Then At least one show card should appear
    And I append the search term with a space
    Then At least one show card should appear
    And I append the search term with a space
    Then At least one show card should appear

    Examples:
      |userType|
      |Anonymous|
      |Registered|
      |Ghost|
      |AuthZ|

  @search, @smoke
  Scenario Outline: C1503944 X button closes the Search overlay
    Given I navigate to the CBS Digital website
    And I click on the Search Icon
    And I click on the Search Close Icon
    Then I am at the Home page

    Examples:
      |userType|
      |Anonymous|
      |Registered|
      |Ghost|
      |AuthZ|

  @search, @smoke
  Scenario Outline: C1503945 Search refreshes on every update (removing or adding 1 character)
    Given I navigate to the CBS Digital website
    When I update access as "<userType>"
    And I click on the Search Icon
    And I enter the term "b"
    Then the results should show "bull"
    And the results should show "blue bloods"
    And I append the search term with "u"
    And the results should show "bull"
    And the results should not show "blue bloods"
    And I delete a letter from the search term
    Then the results should show "bull"
    And the results should show "blue bloods"

    Examples:
      |userType|
      |Anonymous|
#	|Registered|
#	|Ghost|
#	|AuthZ|

  @search, @smoke
  Scenario Outline: C1503948 Selecting show poster from the search results open Show page
    Given I navigate to the CBS Digital website
    And I click on the Search Icon
    And I enter the term "b"
    And the results should show "b positive"
    And I click the first result with the term "b positive"
    Then I arrive at the showpage of "b positive"

    Examples:
      |userType|
      |Anonymous|
      |Registered|
      |Ghost|
      |AuthZ|

  @search, @smoke
  Scenario Outline: C1503949 Search result persist as long as the show has a correct title
    Given I navigate to the CBS Digital website
    And I click on the Search Icon
    And I enter the term "b"
    And the results should show "big brother"
    And I append the search term with "i"
    And the results should show "big brother"
    And I append the search term with "g"
    And the results should show "big brother"
    And I append the search term with " "
    And the results should show "big brother"
    And I append the search term with "b"
    And the results should show "big brother"
    And I append the search term with "r"
    And the results should show "big brother"
    And I append the search term with "o"
    And the results should show "big brother"
    And I append the search term with "t"
    And the results should show "big brother"
    And I click the first result with the term "big brother"
    Then I arrive at the showpage of "big brother"

    Examples:
      |userType|
      |Anonymous|
      |Registered|
      |Ghost|
      |AuthZ|

#  @search, @smoke
#  Scenario Outline: C1503950 Search results updates when typing more characters
#    Given I navigate to the CBS Digital website
#    And I click on the Search Icon
#    And I enter the term "bull"
#    And the results should show "bull"
#    And I append the search term with "e"
#    And there should be no results displayed
#    And An invalid search term error should appear
#    And I delete a letter from the search term
#    Then the results should show "bull"
#
#    Examples:
#      |userType|
#      |Anonymous|
#      |Registered|
#      |Ghost|
#      |AuthZ|