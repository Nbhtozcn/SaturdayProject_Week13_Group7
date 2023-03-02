package testNG_DEMOQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.text.Utilities;

import static Utilities.UtilityClass.driver;

public class DemoQA extends Utilities {
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
    void testID11() {

            // TC_11 Module: Droppable _ Validate dragging the element to the target

            // 1. Go to the url: ""https://demoqa.com""/droppable/
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

    }
    @Test
    void testID13(){

    }
    @Test
    void testID14(){

    }
    @Test
    void testID15(){
            //TC_15 Module: Slider_Validate sliding the slider by clicking on a bar

            //1. Go to the url: "https://demoqa.com/slider"/
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

    }
    @Test
    void testID18(){

    }


}
