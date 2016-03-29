public class ParenDemo{
    public static boolean isMatching(String s){
	String paren = "";
	for (int i = 0; i<s.length();i++){
	    String x = s.substring(i,i+1);
	    if ("({[<>]})".contains(x)){
		paren += x;
	    }
	}


	MyStack<String> stack = new MyStack<String>();
	String open = "({[<";
	String close= ")}]>";
	for (int i = 0; i<paren.length();i++){
	    String x = paren.substring(i,i+1);
	    if (open.contains(x)){
		stack.push(x);
	    }else{
		if (close.indexOf(x) == stack.peek().indexOf(x)){
		    stack.pop();
		}else{
		    return false;
		}
	    }
	}
	return !(open.contains(stack.pop()));

	

    }
    public static void main(String[]args){
	System.out.println(isMatching("()()"));
 
    }
}
