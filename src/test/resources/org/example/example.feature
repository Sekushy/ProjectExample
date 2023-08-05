Feature: An example

  Scenario: Valid email US
    Given I am on the main page
    When the email value of "tester@test.com" is inputted
    And the submit button is clicked
    Then the newsletter confirmation pop-up appears

  Scenario: Valid email RO
    Given I am on the main page
    When the email value of "tester@test.ro" is inputted
    And the submit button is clicked

  Scenario: Negative over character limit
    Given I am on the main page
    When the email value of "AAaaaaaaaaaaaaaaaaaaaaaaaa" is inputted
    And the submit button is clicked

  Scenario: Navigate to virtual page
    Given I am on the main page
    When I click the read more button for the virtual section
    Then the "Virtual" page opens

  Scenario: Navigate to virtual page
    Given I am on the main page
    When I click the read more button for the hybrid section
    Then the hybrid page opens