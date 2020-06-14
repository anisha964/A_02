  Feature: Google Test Scenarios
  Scenario Outline: TC01: Allow user to capture google search number on search result
    #following use case covers google test scenarios
    Given I navigate to google home page
    When I enter a keyword <Cars> on search field
    When I click on search icon
    When I capture search result and print it
    When Click on more
    Then I can select the value <More>

    Examples:
      |Cars|More|
      |Lexus|Videos|
      |BMW|Books|

    #each scenario/scenario out line are individual test cases. no relationship between
    #them
    Scenario: TC02: Allow user to go to google sign in page
