Feature: Test the account update functionality



  @Smoketest
   Scenario: TC_03 User is able to update a PET sucessfully on the store site

      Given user put the update pet request with id '1270' and dog name "Lovely Pluto"
      Then user get the response code '200'
      And user gets the updated id and name in response


  @Smoketest
  @Negativecase
  Scenario: TC_04 User is unable to update a PET with invalid data input

    Given user put the update pet request with invalid id '00000' and dog name "Snowy"
    Then user for the request with invalid id get error response code '400'
    And user gets the message for put request with invalid id as "Invalid ID supplied"

