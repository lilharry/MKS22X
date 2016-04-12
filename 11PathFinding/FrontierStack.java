public class FrontierStack<T> implements Frontier<T>{
    MyStack<T> frontier;
    public FrontierStack(){
	frontier = new MyStack<T>();
    }
    public void add(T element){
	frontier.push(element);
    }
    public T next(){
	return frontier.peek();
    }
    public boolean hasNext(){
	return !frontier.isEmpty();
    }
}
