Feature: Validate personal details

  @Smoke
  Scenario: Validate multiple personal details using Map
    Given User is on the Orange Home Page
    And User logs in with "Admin" and "admin123"
    And User should see the dashboard
    And User navigates to My Info page
    And User inputs first name "John" in the first name field
    And User inputs middle name "A" in the middle name field
    And User inputs last name "Doe" in the last name field
    And User selects marital status "Married" in the dropdown
    When User clicked on save button
    Then User verifies the information has been saved

