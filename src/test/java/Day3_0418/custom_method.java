package Day3_0418;

public class custom_method {
    // purpose of these user defined custom methods so that I can reuse it again and again
    // and call it on my main method when i need to use them.
    //user defined custom methods will be created here
    //void method only executes your statement inside that method
    //lets create one void first
    public static void voidAdd(int a ,int b){
        int result= a+b;
        System.out.println("my addition result is " + result);
    }//end of void method

    //create name method as return method
    //return method execute your statements as well as returns you the result you want
    public static int returnAdd(int a, int b) {
        int result = a + b;
        System.out.println(" My addition result is " + result);
        return result;// will return the result c
    } //end of return  method









}//end of java class

