Feature: Search

  As a user
  I should review the relevant products using search


  @search
 Scenario Outline: Verify products returned are relevant
    Given I open homepage "https://www.amazon.co.uk/" with title as "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more"
    When I click sign button
    And I enter username "tmtntesting@gmail.com"
    And I click continue
    And I enter password"Testing@22"
    And I click sign-In button
    And I do search for "<searchOption>"
    Then I should get relevant products as results "<searchOption>"

    Examples:
    |searchOption |
    |hoodie   |
    |t-shirt   |
    |watch    |
