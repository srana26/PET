Feature: Test the get account functionality



  @Smoketest
   Scenario: TC_05 User is able to get a PET sucessfully from the store site

      Given user call the get pet request with id '1270'
      Then user get the success response code '200'
      And user gets the pet details in the response



  @Smoketest
  @Negativecase
  Scenario: TC_06 User is unable to get a PET with invalid id input

    Given user uses get pet request with invalid id '00'
    Then user get the error response code '404'
    And user gets the error message for get request "Pet not found"

