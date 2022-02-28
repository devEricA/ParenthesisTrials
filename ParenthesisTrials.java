import java.util.*;
import java.lang.*;
import java.io.*;

public class ParenthesisTrials{


    public static int balance(String parenthesis, int bottomPos, int topPos, int count)
    {

        //If the two positions have not collided, continue with the array. 
        if(bottomPos <= topPos)
        {
            //Taking the middle position between the top and bottom
            int middle = bottomPos + (topPos - bottomPos)/2;
            
            if(parenthesis.charAt(middle) == '(')
                count += 1;
            else if(parenthesis.charAt(middle) == ')')
                count -= 1; 
             
            balance(parenthesis, bottomPos, middle - 1, count);
            balance(parenthesis, middle + 1, topPos, count);
        }
         
        return count;
    }

    //Main area where we will run the cases.
    public static void main(String [] args) throws IOException{
        
        // Defining the small test cases
        String caseOne = "(((";
        String caseTwo = "())";
        String caseThree = "(())";
        String caseFour = ")(";
        String caseFive = "Don'tMindMe)";

        // Defining the 10 million test case
        Scanner file = new Scanner(new File("10MillionString.txt"));
        String monsterCase = file.next();
        file.close();

        //Running the method in all of the test cases
        System.out.println(balance(caseOne, 0 , caseOne.length()-1, 0));
        System.out.println(balance(caseTwo, 0 , caseTwo.length()-1, 0));
        System.out.println(balance(caseThree, 0 , caseThree.length()-1, 0));
        System.out.println(balance(caseFour, 0, caseFour.length()-1, 0));
        System.out.println(balance(caseFive, 0, caseFive.length()-1, 0));
        System.out.println(balance(monsterCase, 0, monsterCase.length()-1, 0));

        
    }

}