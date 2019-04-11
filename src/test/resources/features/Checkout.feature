Feature:  As A User I want to search for sweets on amazon So I can find my preferred brands.

  @regression @tmsLink=TC-03 @severity=normal
  Scenario: Verify Guest checkout for multiple item
    Given I visit the web site as a guest user
    When I search for following Candies and ADD the cheapest candy of each
      | Snickers |
      | Twix     |
      | Skittles |
    When I click on "Proceed to Checkout" button on Cart page
    Then I should be redirected to Login page

  @regression @smoke @severity=blocker @issue=BIG-38916 @tmsLink=TC-06
  Scenario: Verify Guest checkout for single item
    Given I visit the web site as a guest user
    When I search for "cakes"
    Then I should be in Search Result page
    And I verify the Sort By "Price: Low to High" functionality
    And I click on "first" Product Thumbnail in search results page
    Then I should redirect to PDP page
    And I click Add to cart button
    When I click on "Proceed to Checkout" button on Cart page
    Then I should be redirected to Login page
