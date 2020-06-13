package actionitem;

import Resuable_Library.Abstract_Class;
import org.testng.annotations.Test;

public class Interview_question3 extends Abstract_Class {


    // Result function with N
    @Test
    public static void result() {
        int i;

        for (i = 1; i <= 100; i++) {
            if (i % 5 != 0) {

                System.out.println(i + " ");
            }

        }


    }//loop


}



















