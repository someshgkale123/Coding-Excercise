# Coding-Excercise

Given a piece of text, this program maps each word in the text and the number of times it occurred.
The words are sorted by frequency, in descending order.

Added few testcases to test on:
1. If empty text
2. If text has special characters
3. If text includes whitespaces at first or end
4. If text has lowercase and uppercase inputs


Approach:

1. Used HashMap to get count of different words in the text
2. Used Two stacks to keep track of higher count words and sorting them in descending order in original stack:
    
    Stack 1: Useful for maintaining the array of strings in descending order
    
    Stack 2: Temporary stack useful for adjusting if new string with more frequency found, pop and push the previous lower count strings in tempstack,
              push the higher count string and then retrieve all the pushed strings from tempstack.
