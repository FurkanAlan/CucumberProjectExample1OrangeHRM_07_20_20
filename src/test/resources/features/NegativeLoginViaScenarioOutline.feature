#@login
#Feature: Login
#
#  @regression
#  Scenario Outline: Invalid login error message validation
#    Given I enter username "<username>" and password "<password>"
#    When I click login button
#    Then I see "<errorMsg>"
##data table ozeeligi olarak herbirini sirasiyla calistirip kapatiyor
#    Examples:
#      | username | password  | errorMsg                 |
#      | Admin    | Qwerty123 | Invalid credentials      |
#      | Admin    |           | Password cannot be empty |
#      | Admin123 | QWer123   | Invalid credentials      |
#      |          | admin123  | Username cannot be empty |
#      |          |           | Username cannot be empty |
#
#
#
##      Examples:
##      | username | password  | errorMsg                                     |
##      | Admin    | Qwerty123 | Ungültige Benutzernamen-Passwort-Kombination |
##      | Admin    |           | Das Passwort darf nicht leer sein            |
##      | Admin123 | QWer123   | Ungültige Benutzernamen-Passwort-Kombination |
##      |          | admin123  | Der Benutzername darf nicht leer sein        |
##      |          |           | Der Benutzername darf nicht leer sein        |