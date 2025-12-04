Feature: Remove Candidate


  Scenario: User logged in as an Admin
    Given User is on the Orange Home Page
    And User logs in with "Admin" and "admin123"
    And User should see the dashboard
    And User clicks on Recruitment option
    And User search "John" in the candidate name search box
    And User selects the candidate name from the auto suggestive dropdown menu
    When User clicks on delete button
    Then User verifies the candidate has been deleted successfully