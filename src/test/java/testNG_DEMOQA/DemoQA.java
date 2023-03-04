package testNG_DEMOQA;


import Utilities.UtilityClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        driver.get("https://demoqa.com/");
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000)"); //scrolled down
        WebElement interactionsButton= driver.findElement(By.xpath("//h5[contains(text(), 'Interactions')]/.."));
        interactionsButton.click();
        String actualUrl=driver.getCurrentUrl();
        System.out.println(actualUrl);
        String expectedUrl="https://demoqa.com/interaction/";
        System.out.println(actualUrl.equals(expectedUrl));

    }
    @Test
    void testID3(){



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
        driver.get("https://demoqa.com/selectable/");
        WebElement item1= driver.findElement(By.xpath("//li[text()='Cras justo odio']"));
        WebElement item2= driver.findElement(By.xpath("//li[text()='Dapibus ac facilisis in']"));
        WebElement item3= driver.findElement(By.xpath("//li[text()='Morbi leo risus']"));
        Actions actions=new Actions(driver);
        String item1BackgroundColorBefore=item1.getCssValue("background-color");
        String item2BackgroundColorBefore=item2.getCssValue("background-color");
        String item3BackgroundColorBefore=item3.getCssValue("background-color");
        Action click3Items=actions.moveToElement(item1).keyDown(Keys.COMMAND).click(item1).click(item2).click(item3).click(item2).release().build();
        click3Items.perform();
        wait(3);
        String item1BackgroundColorAfter=item1.getCssValue("background-color");
        String item2BackgroundColorAfter=item2.getCssValue("background-color");
        String item3BackgroundColorAfter=item3.getCssValue("background-color");
        Assert.assertEquals(item1BackgroundColorBefore,item1BackgroundColorAfter);
        Assert.assertNotEquals(item2BackgroundColorBefore,item2BackgroundColorAfter);
        Assert.assertEquals(item3BackgroundColorBefore,item3BackgroundColorAfter);
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
        driver.get("https://demoqa.com/resizable/");
        WebElement resizableBox= driver.findElement(By.id("resizable"));
        int widthBefore=resizableBox.getSize().width;
        wait(2);
        //<span class="react-resizable-handle react-resizable-handle-se"></span>
        WebElement element= driver.findElement(By.cssSelector("span[class='react-resizable-handle react-resizable-handle-se']"));
       Actions actions=new Actions(driver);
       Action dragAndPull=actions.moveToElement(element).clickAndHold().moveByOffset(0,100).build();
       dragAndPull.perform();
       int widthAfter=resizableBox.getSize().width;
       Assert.assertEquals(widthAfter,widthBefore+200);

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




    }
    @Test
    void testID11(){
        driver.get("https://demoqa.com/droppable");

        // 2. Drag the element to the target

        //<div id="draggable" class="drag-box mt-4 ui-draggable ui-draggable-handle" style="position: relative; left: -36px; top: -37px;">Drag me</div>
        WebElement draggableItem = driver.findElement(By.id("draggable"));
        //<div id="droppable" class="drop-box ui-droppable"><p>Drop here</p></div>
        WebElement droppableItem = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        Action dragAndDropToTheTarget = actions.dragAndDrop(draggableItem,droppableItem).build();
        dragAndDropToTheTarget.perform();

        //Expected Result= After dragging the element to the target, you should see the element is within the target square and
        // the target square is colored blue with inscription, Dropped!

        //<div id="droppable" class="drop-box ui-droppable"><p>Drop here</p></div>
        //<div id="droppable" class="drop-box ui-droppable ui-state-highlight"><p>Dropped!</p></div>

        WebElement  beforeDroppableItemColor = driver.findElement(By.xpath("//div[@class='drop-box ui-droppable']"));
        String beforeDropColor = beforeDroppableItemColor.getCssValue("background-color");
        System.out.println("item's color value before dropped =" + beforeDropColor);

        WebElement  afterDroppableItemColor = driver.findElement(By.xpath("//div[@class='drop-box ui-droppable ui-state-highlight']"));
        String afterDropColor = afterDroppableItemColor.getCssValue("background-color");
        System.out.println("item's color value after dropped ="  + afterDropColor);

        Assert.assertNotSame(beforeDropColor, afterDropColor);

        //Dropped!
        WebElement successMessage = driver.findElement(By.id("droppable"));
        Assert.assertTrue(successMessage.getText().contains("Dropped!"),"Test is not successful");

    }


    @Test
    void testID12(){
        driver.get("https://demoqa.com/select-menu/");
        WebElement selectOption = driver.findElement(By.xpath("//div[@class=' css-1wa3eu0-placeholder']"));
        selectOption.click();
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Group 1, option 2')]")));
        List<String> options = new ArrayList<>(Arrays.asList("Group 1, option 1","Group 1, option 2","Group 2, option 1","Group 2, option 2","A root option","Another root option"));
        Random random = new Random();
        String randomOption = options.get(random.nextInt(options.size()));
        WebElement options1 = driver.findElement(By.xpath("//div[contains(text(),'"+randomOption+"')]"));
        actions.moveToElement(options1).click().perform();


        /**2*/
        WebElement secondDropMenu= driver.findElement(By.id("selectOne"));
        secondDropMenu.click();
        Actions actions1 = new Actions(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Mr.')]")));
        List<String> selectOne = new ArrayList<>(Arrays.asList("Dr.","Mr.","Mrs.","Ms.","Prof.","Other"));
        Random random1 = new Random();
        String randomOption1 = selectOne.get(random1.nextInt(selectOne.size()));
        WebElement options2 = driver.findElement(By.xpath("//div[contains(text(),'"+randomOption1+"')]"));
        actions.moveToElement(options2).click().perform();

        /**3*/
        //<select id="oldSelectMenu">
        WebElement oldStyleMenu=driver.findElement(By.id("oldSelectMenu"));
        oldStyleMenu.click();
        Select select=new Select(oldStyleMenu);
        List<WebElement> optionsOldMenu = select.getOptions();
        Random rand = new Random();
        int index = rand.nextInt(optionsOldMenu.size());
        select.selectByIndex(index);
        oldStyleMenu.click();

        /**4*/

        WebElement multiMenu=driver.findElement(By.cssSelector("div[class=' css-1wa3eu0-placeholder']"));
        multiMenu.click();
        Actions actions2=new Actions(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Blue']")));
        actions2.moveToElement(driver.findElement(By.xpath("//div[text()='Blue']"))).click().perform();
        actions2.moveToElement(driver.findElement(By.xpath("//div[text()='Red']"))).click().perform();
        actions2.moveToElement(driver.findElement(By.xpath("//div[text()='Black']"))).click().perform();
        actions2.moveToElement(driver.findElement(By.xpath("//div[text()='Green']"))).click().perform();

        /**5*/
        //<select multiple="" name="cars" id="cars"><option value="volvo">Volvo</option><option value="saab">Saab</option><option value="opel">Opel</option><option value="audi">Audi</option></select>

        WebElement standardMultiSelect=driver.findElement(By.id("cars"));
        Select select1=new Select(standardMultiSelect);
        select1.selectByIndex(2);


    }

    @Test
    void testID13() {
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
        Assert.assertEquals(SubSubList.isDisplayed(), true);
        Assert.assertEquals(SubSubItem2.isDisplayed(), true);
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
            driver.get("https://demoqa.com/slider");

            //2. Move the slider by clicking on a slide bar;
            //<input type="range" class="range-slider range-slider--primary" min="0" max="100" value="25" style="--value:25;">

            WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
            Actions actions = new Actions(driver);

            Action sliderAction = actions.click(slider).moveByOffset(100,0).build();
            sliderAction.perform();

            //<div class="range-slider__tooltip__label">25</div><div class="range-slider__tooltip__arrow"></div></div>
            WebElement sliderValue1 = driver.findElement(By.cssSelector(".range-slider__tooltip__label"));
            String sliderRecentValue = sliderValue1.getText();
            System.out.println("Slider recent value =" +sliderRecentValue);

            //<input id="sliderValue" class="form-control" value="25">
            WebElement valueBox = driver.findElement(By.id("sliderValue"));
            String sliderValueBox = valueBox.getAttribute("value");
            System.out.println("Slider value box =" +sliderValueBox);

            Assert.assertEquals(sliderRecentValue, sliderValueBox,"Test is not successful");



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

