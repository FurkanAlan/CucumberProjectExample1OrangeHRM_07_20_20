@login
Feature: Login
##  Background in altinda verilen Given bizim pre-condtion imiz oluyor ve her seferinde program once onu calisitiriyor
##  Background:
##    Given I successfully login to HRM

  @smoke
  Scenario: Valid login validation
    Given I enter valid username
    And I enter valid password
    When I click login button
    Then I successfully login Orange HRM