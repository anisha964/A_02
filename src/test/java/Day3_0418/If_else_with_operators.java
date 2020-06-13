package Day3_0418;

public class If_else_with_operators {

    public static void main(String[] args) {


        //scenario is if student grade is 90 to 100 is A
        //if student grade us 80 to below 90 then its B
        // if student grade is 70 to below 80 then its C
        //if anything below C is a failure

        //define a variable which will represent grade number
        int grade =77;
        //&& represents and operator in java
        //|| or operator one of the condition has to be true
        if (grade >= 90 && grade <= 100) {
            System.out.println("Student grade is A ");
        } else if (grade >= 80 && grade < 90) {
            System.out.println("Student grade is B");
        } else if (grade >= 70 && grade < 80) {
            System.out.println("Student grade is C");
        } else {
            System.out.println(" Student grade is F");
        } //end of conditional statements


    }//end of main method


}// end of java class
