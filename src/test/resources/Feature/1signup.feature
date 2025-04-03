Feature: Signup

  Scenario: User successfully signs up
    Given I launch the browser and navigate to Magento home page
    When I click on Create an Account
    And I enter first name
    And I enter last name
    And I enter email address
    And I enter password and confirm password
    And I click on Create Account button
    Then I should see a success message
