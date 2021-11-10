@all
Feature: Show

	@show
	Scenario Outline: C1503954 Show Full Episode Page
		Given I navigate to the CBS Digital website
#		When I update access as "<userType>"
		And I navigate to the CBS Digital website
		And I am at the Home page
		And I click Shows
		And I am at the Shows page
		And I click on the first show


		Examples:
			|userType|episodeType|lockType|
			|Anonymous|free|unlocked|
			|Anonymous|locked|locked|
			|Registered|free|unlocked|
			|Registered|locked|locked|
			|Ghost|free|unlocked|
#	|Ghost|locked|unlocked| #should be invalid, ghost shouldn't have locked
			|AuthZ|free|unlocked|
#	|AuthZ|locked|unlocked| #should be invalid, authz shouldn't have locked

	@show2
	Scenario Outline: C1503968 Show Home Page is displayed
		Given I navigate to the CBS Digital website
		When I update access as "<userType>"
		And I navigate to the CBS Digital website
		And I am at the Home page
		And I click Shows
		And I am at the Shows page
		And I click on the show titled "<showTitle>"
		Then I am at the "<showTitle>" show page

		Examples:
			|userType|showTitle|
			|Anonymous|NCIS|
#	|Anonymous|Big Brother|
#	|Anonymous|SEAL Team|
	
	
	
	
	
	