package oneasad;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.lang.model.element.Element;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class CalculatorTest {
    //WebDriver driver; //browser testing

    static AppiumDriver driver; //appium mobile testing

    //AndroidDriver driver; //android testing
    //IOSDriver driver; //IOS testing

    public static void main(String[] args){
        try {
            openCalculator();
            testAllbuttons();
            findSum();
        }
        catch (Exception exp){
            exp.getCause();
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
    }
    public static void openCalculator() throws URISyntaxException, MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "SM-A32");
        //cap.setCapability("udid", "RF8T11EBSQE");
        cap.setCapability("udid", "192.168.1.8:40013");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "13");
        cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
        cap.setCapability("automationName", "UiAutomator2"); // for Android
        cap.setCapability("uiautomator2ServerInstallTimeout", 600);  // Set to 60 seconds

        URI uri = new URI("http://192.168.1.2:4723/");
        URL url = uri.toURL();

        //URI uri = new URI("http://127.0.0.1:4723/");
        //URI uri = new URI("http://10.140.49.26:4723/");

        driver = new AppiumDriver(url, cap);

    }
    public static void findSum(){
        WebElement two = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02"));
        WebElement add = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
        WebElement three = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03"));
        WebElement equal = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));
        WebElement screen = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
        two.click();
        add.click();
        three.click();
        equal.click();
        String result = screen.getText();
        System.out.println("Calculation result " + result.charAt(0));
    }
    public static void testAllbuttons(){
        WebElement[] buttons = {
                driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_00")),
                driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_dot")),
                driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_01")),
                driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02")),
                driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03")),
                driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_04")),
                driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")),
                driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_06")),
                driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07")),
                driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_08")),
                driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_09"))
        };

        WebElement add = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
        WebElement sub = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_sub"));
        WebElement mul = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_mul"));
        WebElement div = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_div"));
        WebElement percentage = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_percentage"));
        WebElement parenthesis = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_parenthesis"));
        WebElement clear = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_clear"));

        WebElement dot = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_dot"));
        dot.click();

        for(WebElement btn: buttons)
            btn.click();

        add.click(); buttons[2].click();
        sub.click(); buttons[3].click();
        mul.click(); buttons[4].click();
        div.click(); buttons[5].click();
        percentage.click(); buttons[6].click();
        mul.click(); parenthesis.click();
        buttons[7].click(); parenthesis.click();
        clear.click();
    }
}
