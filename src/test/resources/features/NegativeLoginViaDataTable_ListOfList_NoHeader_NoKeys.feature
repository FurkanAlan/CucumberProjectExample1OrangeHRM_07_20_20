#Feature: Negative login test with Excel
#
#  Scenario: Negative Testing With DataTable And There is WithOut Header
#    When I enter username and password I see error message without header
#      | Admin    | Qwerty123 | Invalid credentials      |
#      | Admin    |           | Password cannot be empty |
#      | Admin123 | QWer123   | Invalid credentials      |
#      |          | admin123  | Username cannot be empty |
#      |          |           | Username cannot be empty |