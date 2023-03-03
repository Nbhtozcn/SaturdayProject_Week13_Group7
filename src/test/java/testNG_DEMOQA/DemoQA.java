package testNG_DEMOQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DemoQA {
    @Test
    void testID1(){

    }
    @Test
    void testID2(){

    }
    @Test
    void testID3(){
        public static void main(String[] args) {
            // Set the path of the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

            // Create a new instance of the ChromeDriver
            WebDriver driver = new ChromeDriver();

            // Navigate to the demoqa.com website
            driver.get("https://demoqa.com/");

            // Click on the "interaction" button
            driver.findElement(By.xpath("//a[text()='Interactions']")).click();

            // Get the current URL
            String currentUrl = driver.getCurrentUrl();

            // Print the current URL to the console
            System.out.println("Current URL: " + currentUrl);

            // Quit the driver
            driver.quit();
    }
    @Test
    void testID4(){

    }
    @Test
    void testID5(){

    }
    @Test
    void testID6(){

    }
    @Test
    void testID7(){

    }
    @Test
    void testID8(){

    }
    @Test
    void testID9(){
        public static void main(String[] args) {
            WebDriverManager.chromedriver().setup();

            WebDriver driver = new ChromeDriver();

            driver.get("https://demoqa.com/selectable/");

            // Find the selectable list
            WebElement selectableList = driver.findElement(By.id("selectable"));

            //Use Actions class to simulate user actions
            Actions actions = new Actions(driver);

            //Press the control key and click on the first 3 items
            actions.keyDown(Keys.CONTROL)
                    .click(selectableList.findElement(By.xpath("//li[@class='mt-2 list-group-item list-group-item-action' and text()='Cras justo odio']")))
                    .click(selectableList.findElement(By.xpath(".//li[2]")))
                    .click(selectableList.findElement(By.xpath(".//li[3]")))
                    .keyUp(Keys.CONTROL)
                    .perform();

            // Click on the second item again to deselect others
            actions.click(selectableList.findElement(By.xpath(".//li[2]")))
                    .perform();

            // Verify that only the second item is highlighted
            boolean item1Highlighted = selectableList.findElement(By.xpath(".//li[1]")).getAttribute("class").contains("ui-selected");
            boolean item2Highlighted = selectableList.findElement(By.xpath(".//li[2]")).getAttribute("class").contains("ui-selected");
            boolean item3Highlighted = selectableList.findElement(By.xpath(".//li[3]")).getAttribute("class").contains("ui-selected");

            if (!item1Highlighted && item2Highlighted && !item3Highlighted) {
                System.out.println("Selection test passed!");
            } else {
                System.out.println("Selection test failed!");
            }

            driver.quit();

        }
    }
    @Test
    void testID10(){

    }
    @Test
    void testID11(){

    }
    @Test
    void testID12(){

    }
    @Test
    void testID13(){

    }
    @Test
    void testID14(){

    }
    @Test
    void testID15(){

    }
    @Test
    void testID16(){

    }
    @Test
    void testID17(){

    }
    @Test
    void testID18(){

    }


}
