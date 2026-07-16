Feature: Rest API testing framework using java rest assured

  Background: Creation of job
    Given create new user with status code 201

  @Smoke_test
  Scenario: Get user details
    Given get user details with status code 200
    Then delete user details with status code 200
