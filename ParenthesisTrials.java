import java.util.*;
import java.lang.*;
import java.io.*;

public class ParenthesisTrials{

    //public static int count = 0;
    public static Stack<Character> parenthesisStack = new Stack<Character>();

    public static int balance(String parenthesis, int bottomPos, int topPos)
    {

        //If the two positions have not collided, continue with the array. 
        if(bottomPos <= topPos)
        {
            //Taking the middle position between the top and bottom
            int middle = bottomPos + (topPos - bottomPos)/2;

            if(parenthesis.charAt(middle) == '(')
            {
                parenthesisStack.push(parenthesis.charAt(middle));
            }
            else if(parenthesis.charAt(middle) == ')')
            {
                if(!parenthesisStack.empty() && parenthesisStack.peek() == '(')
                    parenthesisStack.pop();
                else
                    parenthesisStack.push(parenthesis.charAt(middle));
            }

            balance(parenthesis, bottomPos, middle - 1);
            balance(parenthesis, middle + 1, topPos);
        }
         
        return parenthesisStack.size();
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
        //After each case, the stack is reset. 
        System.out.println(balance(caseOne, 0 , caseOne.length()-1));
        parenthesisStack.clear();
        System.out.println(balance(caseTwo, 0 , caseTwo.length()-1));
        parenthesisStack.clear();
        System.out.println(balance(caseThree, 0 , caseThree.length()-1));
        parenthesisStack.clear();
        System.out.println(balance(caseFour, 0, caseFour.length()-1));
        parenthesisStack.clear();
        System.out.println(balance(caseFive, 0, caseFive.length()-1));
        parenthesisStack.clear();
        System.out.println(balance(monsterCase, 0, monsterCase.length()-1));
        parenthesisStack.clear();

        
    }

}