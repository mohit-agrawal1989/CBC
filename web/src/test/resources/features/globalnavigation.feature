@all @wwqqaa2 @sdfsdxcv43 @fsdgsgsdgdsfgsdvervservsdv
Feature: Global Navigation

	Background: I Navigate to CBS Digital website
		Given I navigate to the CBS Digital website

	@globalnavigation
	Scenario: C1503738 Global Navigation - SHOWS
		When I click Shows
		Then I am at the Shows page

	@globalnavigation
	Scenario: C1503739 Global Navigation - LIVE TV
		When I click Live TV
		Then I am at the Live TV page

	@globalnavigation
	Scenario: C1503741 Global Navigation - TV PROVIDER
		When I click TV Provider
		Then I am at the TV Provider page

	@globalnavigation
	Scenario: C1503744 TRY Paramount+ CTA
		When I click Try Paramount Plus


	@globalnavigation
	Scenario: C1503855 Live TV Page - CBS (Local Station)
		And I click on Cbs Local Station
		Then I am at the Cbs Local Station page


	@globalnavigation
	Scenario: C1503863 Free User have access only to CBSN, CBS Sports HQ, ET Live
		When I update access as "Anonymous"
		And I select livetv options and click on local station and observe the stream
		Then I am at the Locked Cbs Local Station page
		And I navigate to the CBS Digital website
		Then I select livetv option and click on CBSN News and observe the stream
		And I navigate to the CBS Digital website
		Then I select livetv options and click on CBS Sports and observe the stream
		And I navigate to the CBS Digital website
		Then I select livetv options and click on ET Live and observe the stream

	@globalnavigation, @smoke
	Scenario Outline: C1503924 Schedule Page
		And I navigate to the CBS Digital website
		And I click on Schedule
		Then I am at the Schedule page
		And Shows, Dates, and Times are displayed

		Examples:
			|userType|
			|Anonymous|
			|Registered|
			|Ghost|
			|AuthZ|