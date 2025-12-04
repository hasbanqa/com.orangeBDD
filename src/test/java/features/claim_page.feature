Feature: Create Claim
@Smoke
  Scenario: User logged in as an Admin and create a claim
    Given User is on the Orange Home Page
    And User logs in with "Admin" and "admin123"
    And User should see the dashboard
    And User clicks on the claim option
    And User clicks on assign claim button
    And User searched by "john" and select the result in the search box
    And User selects "Travel Allowance" from the event dropdown
    And User selects US Dollar from the currency dropdown
    And User inputs cooments in the remarks input field
    When User clicks on create button
    Then User verifies the claims has been created successfully