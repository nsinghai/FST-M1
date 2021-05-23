@activity2_5
Feature: Data driven test with Example

Scenario Outline: Testing with Data from Scenario
    Given User is onto Login page
    When User Enters "<Usernames>" and "<Passwords>"
    Then Read the page Title and confirmation message
    And Close the browsers
    
Examples:
    | Usernames | Passwords |
    | admin     | password  |
    | adminUser | Password  |