package actionitem;

import Resuable_Library.Abstract_Class;
import org.testng.annotations.Test;

public class Interview_question4 extends Abstract_Class {

    @Test
    public void alphabets() {


        String[] letterList = new String[3];
        letterList[0] = "l";
        letterList[1] = "a";
        letterList[2] = "c";


        int i;
        for (i = 0; i<letterList.length; i++){

            if (letterList[i]=="a"|| letterList[i]=="e"||letterList[i]=="i"||letterList[i]=="o"||letterList[i]=="u"){
                System.out.println("vowel matches");
            }else{
                System.out.println("vowel does not match");
            }


        }//loop









    }




}
