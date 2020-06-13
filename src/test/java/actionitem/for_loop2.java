package actionitem;

public class for_loop2 {

    public static void main(String[] args) {

        String[] zipcode = new String[4];

        zipcode[0] = "11218";
        zipcode[1] = "11217";
        zipcode[2] = "11216";
        zipcode[3] = "11215";

        int[] streetNumber = new int[4];
        streetNumber[0] = 5;
        streetNumber[1] = 6;
        streetNumber[2] = 32;
        streetNumber[3] = 31;

        for (int i = 0; i < zipcode.length; i++) {

            System.out.println("my zipcode is " + zipcode[i] + " and my street number is " + streetNumber[i]);


        } //end of loop



    } //end of main method


}//end of java class
