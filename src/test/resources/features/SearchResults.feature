Feature: Verify Search Results Page

  @smoke @regression @severity=critical @issue=BIG-38917 @tmsLink=TC-41
  Scenario: Home page -  Verify Search keyword is displayed
    Given I visit the web site as a guest user
    And I search for "snickers"
    Then I should be in Search Result page
    And Page should have search keyword as "snickers"

  @regression @tmsLink=TC-37 @severity=normal
  Scenario Outline: Home page -  Invalid Search strings validation
    Given I visit the web site as a guest user
    When I search for "<search_string>"
    Then I should be in "zero result" page
    Examples:
      | search_string                      |
      | xcvdv                              |
      | <script>alert('hi there')</script> |

  @regression @smoke @tmsLink=TC-30 @severity=minor
  Scenario: Search Result Page - Verify Sort By functionality Price (low-high)
    Given I visit the web site as a guest user
    When I search for "twix"
    Then I should be in Search Result page
    And I verify the Sort By "Price: Low to High" functionality
    # Notes:
    # Verify that products are displayed with non broken images and links, price and quick peek links and that
    # first product price is less than second product and last product
  #comment