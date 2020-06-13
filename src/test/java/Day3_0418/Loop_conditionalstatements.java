package Day3_0418;

public class Loop_conditionalstatements {


    public static void main(String[] args) {

        String[] city = new String[4];
        city[0] = "Brooklyn";
        city[1] = "Queens";
        city[2] = "Manhattan";
        city[3] = "Bronx";

        for (int i = 0; i < city.length; i++) {
            //using if else if condition
            // string have equal () command == but integer must have==
            // equal command when the expected value is matching the array value
            //equal Ignorance case command will ignore case sensitivity as  the array value
            // spelling is correct
       if (city[i]=="Brooklyn") {
           System.out.println("My city is " + city[i]);
       } else if (city[i]== "Queens") {
           System.out.println( "My city is " + city[i]);
       }
            // different operators are &&,||,>,<,<=,>=,==

            //using operators to meet the same conditions as above
            if (city[i].equals("Brooklyn") || city[i] == "Queens") {
                System.out.println(" My city is " + city[i]);
            }//end of operator conditions

        }// end of loop


    }// end of main method


}// end of java class
