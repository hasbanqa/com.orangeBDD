Feature: Login

  Scenario: User logged in as an Admin
    Given User is on the Orange Home Page
    When User logs in with "Admin" and "admin123"
    Then User should see the dashboard