# ParenthesisTrials
A lab that is about dealing with balanced parenthesis.

# Problem
Given a series of strings, output the minimum amount of parenthesis to make a string of parenthesis balanced.

# Test Cases
1. ((( 
2. ()) 
3. (()) 
4. )( 
5. Don'tmindme)
6. A gigantic string of 10 million open and close parenthesis.

# Output
1. 3
2. 1
3. 0
4. 2
5. 1

# Explanation Behind Approach
This problem is somewhat similar to [LargestArraySum](https://github.com/devEricA/LargestArraySum), where we have to traverse through a series of data in order to obtain a solution. 

This is another problem where I could draw up a linear search and be done with it. However, big cases will drag down the efficiency of that algorithm. Thus, to further test myself, I included the case of 10 million open and close parenthesis. 

Unlike in LargestArraySum, we are not conducting any sort of removals. Thus, we can use a modified version of BinarySearch to traverse through the string without fear of length changes. The reason for this use is because it greatly reduces the runtime of the program. 

# Try it yourself
To see the results of this lab, simply compile and run ParenthesisTrials.java using an IDE of your choice.

Optionally, you can compile GiantStringGenerator.java in order to generate a new case of 10 million integers.

# Additional Notes
Compiled in a Linux Mint environment via CLI commands <code>javac ParenthesisTrialsjava </code> and <code> java ParenthesisTrials. </code>

Developed in Visual Studio Code using openjdk 11.0.13 2021-10-19,