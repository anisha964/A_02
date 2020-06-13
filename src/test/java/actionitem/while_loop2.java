package actionitem;

public class while_loop2 {

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


        int z = 0;
        while (z < zipcode.length) {

            System.out.println("my zipcode is " + zipcode[z]+" and my street number is "+ streetNumber[z]);

            z = z + 1;

        }//end of while loop





    }//end of main method


}// end of java class
