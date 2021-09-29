@Report
Feature:Verify Microsite content

  Scenario Outline: I can successfully login to Bukalapak
    Given User access the website
    When I click Login button at homepage
    And I input email <email>
    And I click Next button
    And I input password <pass>
    And I click Login button
    Then I <nama> successfully logged in to Bukalapak

    Examples:
      | email                     | nama              | pass                            |
      | amandafloren11@gmail.com  | Amanda Florentina | 1E5KfqGHc2XfJS3ZuuMc8WrlLXAN82Kg|




