package testNG_DEMOQA;

import Utilities.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoQA extends UtilityClass {
    @Test
    void testID1(){

    }
    @Test
    void testID2(){

    }
    @Test
    void testID3(){

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
        //Go to Url
        driver.get("https://demoqa.com/menu/#");

        //Locate the main_item_2
        WebElement main_item_2 = driver.findElement(By.xpath("//a[contains(text(),'Main Item 2')]"));
        Actions actions = new Actions(driver);
        //Locate the SubSublist
        WebElement SubSubList = driver.findElement(By.xpath("//a[contains(text(),'SUB SUB LIST »')]"));


        String beforeClickonMainItemColor = main_item_2.getCssValue("background-color");
        //With actions move to mouse to the element
        actions.moveToElement(main_item_2).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'SUB SUB LIST »')]")));

        String afterClickonMainItemcolor = main_item_2.getCssValue("background-color");





        SubSubList.click();



        WebElement SubSubItem2 = driver.findElement(By.xpath("//a[contains(text(),'Sub Sub Item 1')]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Sub Sub Item 1')]")));
        SubSubItem2.click();

        System.out.println("Before " + beforeClickonMainItemColor);
        System.out.println("After " + afterClickonMainItemcolor);
        Assert.assertEquals(SubSubList.isDisplayed(),true);
        Assert.assertEquals(SubSubItem2.isDisplayed(),true);
//        Assert.assertNotEquals(beforeClickonMainItemColor,afterClickonMainItemcolor);




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
        driver.get("https://demoqa.com/date-picker/");

        WebElement datepickerInput = driver.findElement(By.id("datePickerMonthYearInput"));
        datepickerInput.sendKeys(Keys.chord(Keys.HOME, Keys.SHIFT, Keys.END), Keys.BACK_SPACE);
        datepickerInput.clear();
        datepickerInput.sendKeys("12/21/2019");

//<div class="react-datepicker__day react-datepicker__day--021 react-datepicker__day--selected react-datepicker__day--weekend" tabindex="0" aria-label="Choose Saturday, December 21st, 2019" role="option" aria-disabled="false">21</div>

        WebElement calendar = driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day--selected')]"));

        WebElement notselectedcalendar = driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--020']"));

        String colorofSelectedDate = calendar.getCssValue("background-color");
        String colorofnotSelectedDate = notselectedcalendar.getCssValue("background-color");



//After wriAfter writing a date in format 12/21/2019 you should see a calendar with highlighted date 21/12/2019ting a date in format 12/21/2019 you should see a calendar with highlighted date 21/12/2019

        Assert.assertEquals(calendar.isDisplayed(),true);
        Assert.assertNotEquals(colorofnotSelectedDate,colorofSelectedDate);
        Assert.fail("Test shows that, the datepicker works as expected and chosen date highlighted But test case says it suppose to show 21/12/2019 on the calendar that's why this test failed.");




    }
    @Test
    void testID18(){

    }


}
