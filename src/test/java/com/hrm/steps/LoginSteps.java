package com.hrm.steps;

import com.hrm.utils.CommonMethods;
import com.hrm.utils.ConfigsReader;
//import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LoginSteps extends CommonMethods {
    @Given("I enter valid username")
    public void i_enter_valid_username() {
        sendText(login.userName, ConfigsReader.getProperty("username"));
    }

    @Given("I enter valid password")
    public void i_enter_valid_password() {
        sendText(login.password, ConfigsReader.getProperty("password"));
    }

    @When("I click login button")
    public void i_click_login_button() {
        jsClick(login.loginBtn);
    }

    @Then("I successfully login Orange HRM")
    public void i_succussfully_login_Orange_HRM() {
        boolean isLogoDisplayed = dBoard.orangeHrmLogo.isDisplayed();
        Assert.assertTrue("Test Passed", isLogoDisplayed);
    }


    @Given("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String inputUserName, String inputPassword) {
        sendText(login.userName, inputUserName);
        sendText(login.password, inputPassword);
    }

    @Then("I see {string}")
    public void i_see(String expectedErrorMessage) {
        //bizim getText() metodunu uyguladimiz yerde eger value = "text text ..." bu sekilde olsaydi
        //bu text text ... ifadeyi alabilmek icin bizim getAttiribute("value") metodunu uygulamamiz
        // gerekecekti
        String actualErrorMessage = login.errMsg.getText();
//        Assert.assertTrue("hata var assertde",expectedErrorMessage.equals(actualErrorMessage));
        Assert.assertEquals("asserion da hata var", expectedErrorMessage, actualErrorMessage);
    }


    @When("I enter username and password I see error message")
    public void i_enter_username_and_password_I_see_error_message(io.cucumber.datatable.DataTable dataTableWithHeader) {
        //list of map
        List<Map<String, String>> maps = dataTableWithHeader.asMaps();

        //listedeki maps lerin icerisinde iterate edecegiz, listenin icerisi map oldugu icin bu sekilde yapildi
        for (Map<String, String> map : maps) {
            //birincisi WebElementi oluyor ikincisi ise ne gondercegimizi ifade ediyor
            //nereye ne gonderecegimiz seklinde de dusunulebilir
            //gonderecegimiz String ifadesini de olusturdumuz DataTable dan alicagmiz icin
            //gonderecegimiz ifadeler sirasiyla
            //username,  password,   hata mesaji olacak
            //butun key ifadeleri DataTable ile ayni olmak zorunda

            //DataTable in Scenerio Outline dan farkli, DT bir defa Browser Instance aciyor ve testleri bitirireseye
            // kadar loop yapiyor ancak SO ise herbir case icin testi bitiriyor ondan sonra yeni test icin yeniden
            // browser aciyor, yani ozet olarak test bir kere calisiyor DT icin ancak SO icin ise test sayisi kadar
            // test calisiyor

            sendText(login.userName, map.get("username"));
            sendText(login.password, map.get("password"));

            click(login.loginBtn);

            String actualErrorMessage = login.errMsg.getText();
            String expectedErrorMessage = map.get("errorMsg");

            Assert.assertEquals("Error message mismatched", expectedErrorMessage, actualErrorMessage);

        }
    }

    @When("I enter username and password I see error message without header")
    public void i_enter_username_and_password_I_see_error_message_without_header(DataTable dataTableNoHeader) {
        //eger tek degerli olsaydi bunu List<E> seklinde yapilabilirdi
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.

        List<List<String>> lists = dataTableNoHeader.asLists();

        for (List<String> list : lists) {
            sendText(login.userName, list.get(0));
            sendText(login.password, list.get(1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            click(login.loginBtn);

            String actualErrorMessage = login.errMsg.getText();
            String expectedErrorMessage = list.get(2);

            Assert.assertEquals("Someting went wrong", expectedErrorMessage, actualErrorMessage);


        }
    }
}
