Feature: Admin - Add Employee



  Scenario: Add employee to the system
    Given User is on the Orange Home Page
    And User logs in with "Admin" and "admin123"
    And User should see the dashboard
    And User navigates to PIM options
    And User clicks on Add Employee button
    And User inserts first name in the first name field
    And User inserts middle name in the middle name field
    And User inserts last name in the last name field
    And User inserts a random employee ID in the employee ID field
    And user clicks on create login details toggle on options
    And user inputs user name in the user name field
    And user inputs password in the password field
    And user inputs password in the confirm password field
    When User clicks on the save button
    Then User verifies the employee has been added successfully