import java.util.Stack;

public class FrontierStack<T> implements Frontier<T>{
    Stack<T> frontier;
    public FrontierStack(){
	frontier = new Stack<T>();
    }
    public void add(T element){
	frontier.push(element);
    }
    public T next(){
	return frontier.peek();
    }
    public boolean hasNext(){
	return frontier.empty();
    }
}
