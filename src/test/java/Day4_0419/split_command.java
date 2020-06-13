package Day4_0419;

public class split_command {


    public static void main(String[] args) {
      // create a string message first and store it as a string variable

      String message="Welcome to_Selenium Automation class";

      //I want to only print the keyword 'Selenium' from my message variable
      //we need to define string array variable in order to split the message

      String[]arrayResult= message.split(" ");
      //print the result
      System.out.println("my final message is " + arrayResult[2]);

      String[]array2= arrayResult[1].split("_");
      System.out.println("My new message is "+ array2[1]);








    }//end of main method








}// end of java class
