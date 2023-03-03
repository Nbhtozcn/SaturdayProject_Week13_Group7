package testNG_DEMOQA;

import Utilities.UtilityClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoQA extends UtilityClass {
    @Test
    void testID1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/");
        String expectedTitle="DEMOQA";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }
    @Test
    void testID2(){

    }
    @Test
    void testID3(){
        driver.get("https://demoqa.com/");
        
        WebElement interactionOption = driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][5]"));
        interactionOption.click();


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement resizeable = driver.findElement(By.xpath("//span[text()='Resizable']"));
        resizeable.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demoqa.com/resizable/";

        Assert.assertEquals(actualUrl,expectedUrl, "The test is not successful");
    }
    @Test
    void testID4(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/");
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000)"); //scrolled down
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement widget= driver.findElement(By.xpath("//h5[text()= 'Widgets']"));
        widget.click();

        WebElement tollTips=driver.findElement(By.xpath("//span[text()='Tool Tips']"));
        tollTips.click();
        String ExpectedUrl="https://demoqa.com/tooltip/ ";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,ExpectedUrl);


    }
    @Test
    void testID5(){
        driver.get("https://demoqa.com/selectable/");

        WebElement selectFirst = driver.findElement(By.xpath("//li[text()='Cras justo odio']"));
        String colorBeforeSelect = selectFirst.getCssValue("background-color");
        System.out.println("Color before selection: " + colorBeforeSelect);

        selectFirst.click();

        String colorAfterSelect = selectFirst.getCssValue("background-color");
        System.out.println("Color after selection: " + colorAfterSelect);

        Assert.assertNotEquals(colorAfterSelect,colorBeforeSelect, "Test is not successful");

        quitDriver(3);

    }
    @Test
    void testID6(){
        driver.get("https://demoqa.com/selectable");
        Actions Action = new Actions(driver);
        WebElement item1 = driver.findElement(By.xpath("//*[@id='verticalListContainer']//li[1]"));
        String item1BeforeClick = item1.getCssValue("background-color");
        System.out.println(item1BeforeClick);
        Action.keyDown(item1, Keys.CONTROL).build().perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Click on Item 2 on the selectable list
        WebElement item2 = driver.findElement(By.xpath("//*[@id='verticalListContainer']//li[2]"));
        String item2BeforeClick = item2.getCssValue("background-color");
        System.out.println(item2BeforeClick);
        Action.keyDown(item2, Keys.CONTROL).build().perform();

        WebElement item3 = driver.findElement(By.xpath("//*[@id='verticalListContainer']//li[3]"));
        String item3BeforeClick = item3.getCssValue("background-color");
        System.out.println(item3BeforeClick);
        Action.keyDown(item3, Keys.CONTROL).build().perform();
        Action.keyUp(Keys.CONTROL);

        String item1AfterClick = item1.getCssValue("background-color");
        System.out.println(item1AfterClick);
        String item2AfterClick = item2.getCssValue("background-color");
        System.out.println(item2AfterClick);
        String item3AfterClick = item3.getCssValue("background-color");
        System.out.println(item3AfterClick);

        Assert.assertNotEquals(item1BeforeClick, item1AfterClick);
        Assert.assertNotEquals(item2BeforeClick, item2AfterClick);
        Assert.assertNotEquals(item3BeforeClick, item3AfterClick);

    }
    @Test
    void testID7(){

    }
    @Test
    void testID8(){
        driver.get("https://demoqa.com/resizable/");
        WebElement resizableBox= driver.findElement(By.id("resizableBoxWithRestriction"));
        Dimension dim = resizableBox.getSize();
        int beforeResizeWidth=dim.getWidth();
        wait(5);

        Actions actions=new Actions(driver);
        WebElement dragPoint= driver.findElement(By.cssSelector(".react-resizable-handle.react-resizable-handle-se"));
        Action resize = actions.clickAndHold(dragPoint).moveByOffset(100, 0).release().build();
        resize.perform();

        wait(5);
        Dimension dim2 = resizableBox.getSize();
        int afterResizeWidth=dim2.getWidth();
        Assert.assertEquals(beforeResizeWidth+100,afterResizeWidth);

    }
    @Test
    void testID9(){

    }
    @Test
    void testID10(){
        driver.get("https://demoqa.com/resizable/");

        WebElement resizableBox = driver.findElement(By.id("resizableBoxWithRestriction"));

        String beforeResize = resizableBox.getAttribute("style");
        System.out.println("Before resize: " + beforeResize);

        int beforeWidth = resizableBox.getSize().getWidth();
        int beforeHeight = resizableBox.getSize().getHeight();


        WebElement dragPoint = driver.findElement(By.xpath("//div[@id='resizableBoxWithRestriction']//span"));

        Actions actions = new Actions(driver);

        Action resizeDiagonally = actions.moveToElement(dragPoint).clickAndHold().moveByOffset(-50,-50).release().build();
        resizeDiagonally.perform();


        String afterResize = resizableBox.getAttribute("style");
        System.out.println("After resize: " + afterResize);

        int afterWidth = resizableBox.getSize().getWidth();
        int afterHeight = resizableBox.getSize().getHeight();

        int expectedWidth = 150;
        int expectedHeight = 150;

        Assert.assertEquals(afterHeight,expectedHeight, "The test is not successful");
        Assert.assertEquals(afterWidth,expectedWidth, "The test is not successful");

        quitDriver(3);


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
        driver.get("https://demoqa.com/slider/");
        //Locate the point
        WebElement slider= driver.findElement(By.xpath("//input[@class='range-slider range-slider--primary']"));
        String valueBefore = slider.getAttribute("value");

        Actions actions=new Actions(driver);
        actions.moveToElement(slider).click().dragAndDropBy(slider,120,0).build().perform();
        String valueAfter = slider.getAttribute("value");
        Assert.assertNotEquals(valueBefore,valueAfter);

    }
    @Test
    void testID15(){

    }
    @Test
    void testID16(){
        driver.get("https://demoqa.com/date-picker/");
        // <input type="text" id="datePickerMonthYearInput" class="" value="02/27/2023">
        WebElement inputDate = driver.findElement(By.id("datePickerMonthYearInput"));
        inputDate.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        WebElement todayDate = driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[@tabindex='0']"));
        String todayDateColor = todayDate.getCssValue("background-color");

        WebElement anotherDate = driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[@tabindex='-1']"));
        String anotherDateColor = anotherDate.getCssValue("background-color");

        Assert.assertNotEquals(todayDateColor,anotherDateColor,"Test is not successful");
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
        driver.get("https://demoqa.com/date-picker/");
        Actions actions=new Actions(driver);

        WebElement selectDate= driver.findElement(By.id("datePickerMonthYearInput"));
        //selectDate.clear();
        //actions.keyDown(selectDate,Keys.CONTROL).sendKeys("a").keyDown(Keys.BACK_SPACE).build().perform();
        actions.moveToElement(selectDate).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
        //actions.keyUp(selectDate,Keys.CONTROL).keyUp(Keys.BACK_SPACE).keyUp(selectDate.sendKeys("a");
        //WebElement selectDateAgain= driver.findElement(By.id("datePickerMonthYearInput"));
        selectDate.sendKeys("01/14/0030 ");

        WebElement selectedDay=driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--014 react-datepicker__day--selected']"));
        String selectedDayColor=selectedDay.getCssValue("background-color");

        WebElement otherDay=driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--013 react-datepicker__day--weekend']"));
        String otherDayColor=otherDay.getCssValue("background-color");

        //String expectedDateMonth ="21";
        String expectedDate="21/12/0023";

        WebElement currentDate=driver.findElement(By.xpath("//div[@class='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown react-datepicker__current-month--hasMonthDropdown']"));
        String currentMonthAndYear= currentDate.getText();
        System.out.println(currentMonthAndYear);

        Assert.assertEquals(currentDate,expectedDate,"current date is different than expected date ");
       // Assert.assertNotEquals(currentMonthAndYear,expectedDate);

    }


}
