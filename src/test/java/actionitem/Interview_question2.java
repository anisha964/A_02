package actionitem;

import Resuable_Library.Abstract_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Interview_question2 extends Abstract_Class {

    @Test
    public void checkboxes() {
        driver.navigate().to("https://www.faculty.washington.edu/chudler/java/boxes.html");

        //clicking all the links


        List<WebElement> elements = driver.findElements(By.xpath("//*[@type='checkbox']"));
        System.out.println(elements.size());
        for (WebElement el : elements) {
           el.click();

        }

    }









    }
