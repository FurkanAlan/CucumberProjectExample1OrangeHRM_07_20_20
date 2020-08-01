Feature: Add Employee

  Scenario: Add Multiple Employees With Excel
    Given I logged in Orange HRM
    When I navigated to Add Employee page
    Then I enter employee information from excel and save employee successfully
      | firstName | middleName | lastName | userName          | password     |
      | George    | G          | Hagi     | ghagi@gmail.com   | gHagi123-=   |
      | Michael   | M          | Owen     | mowen@gmail.com   | mOwen123-=   |
      | Donald    | D          | Trump    | dtrump@gmail.com  | dTrump123-=  |
      | Gokhan    | Hasan      | Sas      | ghsas@gmail.com   | ghSas123-=   |
      | Hakan     | H          | Sukur    | hsukur@gmail.com  | hSukur123-=  |
      | James     | Jame       | Jones    | jjjones@gmail.com | jjJones123-= |