/*
    This file is responsible
    for generating the 10 million strings. 
*/


//Imports needed
import java.util.*;
import java.math.*;
import java.io.*;

public class GiantStringGenerator {
    
    public static void main (String [] args) throws IOException{

        //Generating the file where we will store the integers
        File fileForTheBigOne = new File("10MillionString.txt");
        fileForTheBigOne.createNewFile();
        
        //Loading the file with randomly generated integers
        FileWriter loader = new FileWriter(fileForTheBigOne);
        Random random = new Random();
        loader.write("");

        //Number used to generate the parenthesis
        //Declared outside of loop in order to save space. 
        int nextNumber;
        for(int x = 0; x<10000000; x++)
        {
            // Used to ensure generation of numbers
            // System.out.println(random.nextInt(2)+1);
        
            // Generating the random string
            nextNumber = random.nextInt(2)+1;
            if(nextNumber == 1)
            {
                loader.append("(");
            }
            else{
                loader.append(")");
            }

        }
        //Closing the file
        loader.flush();
        loader.close();

    }

}
