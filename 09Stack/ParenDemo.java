import java.io.*;
import java.util.*;


public class ParenDemo{
    public static boolean isMatching(String s){
	MyStack<Character> parens = new MyStack<Character>();
	for (char next : s.toCharArray()){
	    if (next == ')' ||
		next == '}' ||
		next == ']' ||
		next == '>'){
		try{
		    if (parens.pop() != expectedChar(next)){

			return false;
		    }
		}catch(NoSuchElementException e){
		    return false;
		}
		
	    } 
	    if (next == '(' ||
		next == '{' ||
		next == '[' ||
		next == '<'){
		parens.push(next);
	    }
	    
	    
	}
	return parens.isEmpty();

	

    }

    private static char expectedChar(char x){
	if (x == '}'){
	    return '{';
	}
	if (x == ')'){
	    return '(';
	}
	if (x == '>'){
	    return '<';
	}
	if (x == ']'){
	    return '[';
	}
	
	throw new IllegalArgumentException();

    }
    public static void main(String[]args){
	System.out.println(isMatching("()()"));
 
    }
}
