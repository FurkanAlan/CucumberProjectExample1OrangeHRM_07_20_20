package com.hrm.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.utils.ConfigsReader;
import com.hrm.utils.Constants;
import org.openqa.selenium.support.PageFactory;


public class BaseClass extends Constants{

    public BaseClass() {
        PageFactory.initElements(driver, this);
    }

    public static WebDriver driver;

    public static void setUp() {

        Properties configs=ConfigsReader.readProperties();
        String browser=configs.getProperty("browser").toLowerCase();

        switch (browser) {
            case "chrome":
//                System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_FILEPATH);
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
//                System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_FILEPATH);
                driver=new FirefoxDriver();
                break;

            default:
                System.out.println("Invalid Browser Name");
                break;
        }

        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigsReader.getProperty("url"));
    }

    public static void tearDown() {
        driver.quit();
    }
}