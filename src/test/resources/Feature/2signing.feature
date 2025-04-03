Feature: Signing

  Scenario: User successfully signs in
    Given I launch the browser and navigate to Magento home page
    When I click on Sign In link
    And I enter the generated email and password
    And I click on Sign In button
    Then I should be logged in successfully
