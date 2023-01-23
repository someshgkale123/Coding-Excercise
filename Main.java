// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.HashMap;
import java.io.*;
import java.util.*;

class CodingExcercise {
    
    // This method maps the frequency count of each word in the sentence
    // Returns HashMap including word and frequency count
    public static HashMap<String, Integer> TraverseString(String str)
    {
        HashMap<String,Integer> countstr= new HashMap<String,Integer>();
        
        //Array of strings
        String[] strarr=str.split("\\s+");
        int strlength=strarr.length;
        
        //Populate HashMap countstr with the words and frequency
        for(int i=0;i<strlength;i++)
        {
            String currentchar=strarr[i];
            if(countstr.containsKey(strarr[i]))
            {
                countstr.put(strarr[i],countstr.get(strarr[i])+1);
            }
            else
            {
                countstr.put(strarr[i],1);
            }
          
        }
        SortMap(countstr);
        return countstr;
    }
        
    // This method sorts the HashMap using Two stacks in descending order based on frequency of the words
    // Returns Output having Count : Word
    public static void SortMap(HashMap<String, Integer> countstr)
    {
        // Initialize two stacks
        // Stack 1: Useful for maintaining the array of strings in descending order
        // Stack 2: temporary stack useful for adjusting if new string with more frequency found, main the previous lower count strings in tempstack
        Stack<String> stack = new Stack<String>();
        Stack<String> tempstack= new Stack<String>();
        for ( String key : countstr.keySet() ) 
        {
            if(stack.size()>0)
            {
                String laststr=stack.peek();
                // last count string in stack is greater, push new smaller count string
                if(countstr.get(laststr)>=countstr.get(key))
                {
                    stack.push(key);
                    //System.out.println(stack);
                }
                else
                {
                    // push string with lower count to tempstack
                    // push new higher count string to original stack
                    // push all the strings back to original stack from tempstack
                    while(stack.size()>0 && countstr.get(stack.peek())<countstr.get(key))
                    {
                        tempstack.push(stack.pop());
                    }
                    stack.push(key);
                    while(tempstack.size()>0){
                        stack.push(tempstack.pop());
                    }
                }
            }
            // push first string as stack is empty
            else
            {
            stack.push(key);
            
            }
        }
        // Result array with sorted words based on frequency in descending order
        List<String> result = new ArrayList(stack);
        for(int i=0;i<result.size();i++) 
        {
            System.out.println("Word Frequency Output is: ");
            System.out.println(countstr.get(result.get(i))+":"+result.get(i));
        }

        
    }
    
    public static void main(String[] args) 
    {
        // Sample inputs
        // String str = "the cat is in the bag";
        // String str = "   the cat";
        // String str = "the cat @ in the bag";
        // String str = "";
        // accepts new user input
        Scanner sc= new Scanner(System.in); 
        System.out.print("Enter a sentence: ");  
        String str= sc.nextLine().toLowerCase();
        // Trim non characters
        String Trimstr=str.replaceAll("[^a-zA-Z]"," ");
        if((Trimstr.trim()).isEmpty())
        {
            System.out.println("Output: None");
        }
        else
        {
            TraverseString(Trimstr.trim());
        }
        
    }
}