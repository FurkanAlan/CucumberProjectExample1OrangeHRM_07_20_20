package com.hrm.steps;

import com.hrm.pages.LoginPageWebElements;
import com.hrm.utils.CommonMethods;
import com.hrm.utils.Constants;
import com.hrm.utils.ExcelUtility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Map;

public class MultipleEmployeesWithMapsSteps extends CommonMethods {
    @Given("I logged in Orange HRM")
    public void i_logged_in_Orange_HRM() {
        LoginPageWebElements.login();
    }

    @When("I navigated to Add Employee page")
    public void i_navigated_to_Add_Employee_page() {
        Actions action = new Actions(driver);
        action.moveToElement(dBoard.PimBtn).perform();
        action.moveToElement(dBoard.addEmpBtn).click().perform();
    }

    @Then("I enter employee information from excel and save employee successfully")
    public void i_enter_employee_information_from_excel_and_save_employee_successfully(DataTable dataTable) {

        List<Map<String, String>> maps = dataTable.asMaps();
        for(Map<String, String> map : maps){
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sendText(addEmp.firstName, map.get("firstName"));
            sendText(addEmp.middleName, map.get("middleName"));
            sendText(addEmp.lastName, map.get("lastName"));

            String expEmpId = addEmp.empId.getAttribute("value");
            click(addEmp.createLoginDetailsBtn);

            sendText(addEmp.userName, map.get("userName"));
            sendText(addEmp.password, map.get("password"));
            sendText(addEmp.confirmPassword, map.get("password"));

            click(addEmp.saveBtn);


            String actEmpId = pDetails.empId.getAttribute("value");

            Assert.assertEquals("Emp ID mismatched", expEmpId, actEmpId);

            Actions action = new Actions(driver);
            action.moveToElement(pDetails.PimBtn).perform();
            action.moveToElement(pDetails.addEmpBtn).click().perform();

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
