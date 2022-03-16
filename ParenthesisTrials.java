/*
    This file is responsible
    for running the method and tests. 
*/

//Imports needed. 
import java.util.*;
import java.io.*;

public class ParenthesisTrials{

    //Global stack to maintain track of all of the parenthesis
    public static Stack<Character> parenthesisStack = new Stack<Character>();

    //Defining the balance method. 
    public static int balance(String parenthesis, int bottomPos, int topPos)
    {
        //If the two positions have not collided, continue with the traversal. 
        if(bottomPos <= topPos)
        {
            //Taking the middle position between the top and bottom
            int middle = bottomPos + (topPos - bottomPos)/2;

            //If we found an open parenthesis, simply push it to the stack
            if(parenthesis.charAt(middle) == '(')
            {
                parenthesisStack.push(parenthesis.charAt(middle));
            }
            //If we found a close parenthesis, only pop if we have a corresponding open one.
            //Else, we push the close parenthesis to the stack. 
            else if(parenthesis.charAt(middle) == ')')
            {
                if(!parenthesisStack.empty() && parenthesisStack.peek() == '(')
                    parenthesisStack.pop();
                else
                    parenthesisStack.push(parenthesis.charAt(middle));
            }

            //Going both ways: we want to traverse the whole string. 
            balance(parenthesis, bottomPos, middle - 1);
            balance(parenthesis, middle + 1, topPos);
        }
         
        //Returning the length of the stack, as it will hold all unsolved parenthesis.
        return parenthesisStack.size();
    }

    //Defining the linear balance method
    public static int linearBalance(String parenthesis){

        //For each character in the string
        for(Character p:parenthesis.toCharArray())
        {
            //If we found an open parenthesis, push it to the stack
            if(p == '(')
            {
                parenthesisStack.push(p);
            }
            //If we found a close parenthesis, only pop if we have a corresponding open one.
            //Else, we push the close parenthesis to the stack. 
            else if(p == ')')
            {
                if(!parenthesisStack.empty() && parenthesisStack.peek() == '(')
                    parenthesisStack.pop();
                else
                    parenthesisStack.push(p);
            }
        }
        //Returning the length of the stack, as it will hold all unsolved parenthesis
        return parenthesisStack.size();
    }

    //Method to compare both algorithms
    public static void compareAlgs(String parenthesis)
    {
        //Outputting the string currently being analyzed
        System.out.println("Current String :: " + parenthesis + "\n");

        //Starting the time of the binary algorithm
        long binaryAlgTimeStart = System.currentTimeMillis();
        //Storing the result of the binary algorithm
        int binaryResult = balance(parenthesis, 0, parenthesis.length()-1);
        //Ending the time of the binary algorithm
        long binaryAlgTimeEnd = System.currentTimeMillis();
        //Resetting the stack
        parenthesisStack.clear();

        //Starting the time of the linear algorithm
        long linearAlgTimeStart = System.currentTimeMillis();
        //Storing the result of the binary algorithm
        int linearResult = linearBalance(parenthesis);
        //Ending the time of the binary algorithm
        long linearAlgTimeEnd = System.currentTimeMillis();
        //Resetting the stack for other cases
        parenthesisStack.clear();

        //Printing the execution times
        System.out.println("Binary balance execution time :: " + (binaryAlgTimeEnd - binaryAlgTimeStart) + " ms");
        System.out.println("Linear balance execution time :: " + (linearAlgTimeEnd - linearAlgTimeStart) + " ms");

        //If both algorithms do not return the same result, output a warning message
        //and print the results. 
        if(binaryResult != linearResult)
        {
            System.out.println("WARNING! Inconsistent results between binary and linear balance for this case!");
            System.out.println("Linear balnace result is " + linearResult);
            System.out.println("Binary balance result is " + binaryResult);
        }
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

        //Running the comparisons between the cases
        compareAlgs(caseOne);
        compareAlgs(caseTwo);
        compareAlgs(caseThree);
        compareAlgs(caseFour);
        compareAlgs(caseFive);
        compareAlgs(monsterCase);
        
    }

}