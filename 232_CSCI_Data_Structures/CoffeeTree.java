public class CoffeeTree<E extends Comparable>{

    private Node<E> root;
    
    CoffeeTree(E data){
        CoffeeNode<E> dummy = new CoffeeNode<E>(data);
        dummy.setNext(dummy);
        dummy.setPrevious(dummy);
        first = dummy;
    }

    public void remove (CoffeeNode<E> data){

    }

    public void add (CoffeeNode<E> data){

    }

    public void addInOrder (CoffeeNode<E> data){

    }

    public void print(){

    }

    public void printBackwards(){

    }
}