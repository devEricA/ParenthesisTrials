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

# Outcome
Linear search out-performed binary search for this problem.
```
Binary balance execution time :: 858 ms
Linear balance execution time :: 438 ms
```
Furthermore, both of the algorithms returned different results for the 10 million case
```
Linear balance result is 5288
Binary balance result is 5278
```
The reason why linear search out performed binary search for this case is because we forced binary search to traverse both the left and right halfs of the list. Normally, the worst runtime case for binary search is [0(log n)](https://www.geeksforgeeks.org/complexity-analysis-of-binary-search/). However, that's due to the fact that binary search only needs to traverse one half of the list. In this case, binary search must traverse both halfs of the list because there are multiple targets within each half of the list, drastically increasing the runtime of the search.

Furthermore, for this problem, we only needed one loop for linear search. Other problems involving linear search that i've dealt with usually required 2. As a result, the run time for this linear search is 0(n), whereas my other linear solutions with 2 loops resulted in 0(n^2) runtime. 

In regards to the inconsistent results, this is due to the fact that both of the algorithms had different starting positions; linear search started at the beginning, binary search started in the middle. Binary search's divde and conquer approach resulted in a few missed parenthesis.

For future questions, binary search will be used if we are looking for one target. For problems with multiple targets, it's back to the drawing board if I want to avoid linear search. 

_Note: Execution times may vary due to computer specifications._

# Try it yourself
To see the results of this lab, simply compile and run ParenthesisTrials.java using an IDE of your choice.

Optionally, you can compile GiantStringGenerator.java in order to generate a new case of 10 million integers.

# Additional Notes
Compiled in a Linux Mint environment via CLI commands <code>javac ParenthesisTrialsjava </code> and <code> java ParenthesisTrials. </code>

Developed in Visual Studio Code using openjdk 17.0.2 2022-01-18