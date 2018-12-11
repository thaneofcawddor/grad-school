public class CoffeeNode{

  CoffeeNode left, right;
  int data;
  int height;

  /* Constructor */
  public CoffeeNode(){
    left = null;
    right = null;
    data = 0;
    height = 0;
  }

  /* Another Constructor to accept data*/
  public CoffeeNode(int n){
    left = null;
    right = null;
    data = n;
    height = 0;
  }
}

public class CoffeeTree<E extends Comparable>{

    private Node<E> root;

    CoffeeTree(E data){
        CoffeeNode<E> dummy = new CoffeeNode<E>(data);
        dummy.setNext(dummy);
        dummy.setPrevious(dummy);
        first = dummy;
    }

    /* Constructor */
    public CoffeeTree(){
        root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty(){
      return root == null;
    }

    /* Make the tree empty */
    public void makeEmpty(){
      return root = null;
    }

    /* Function to insert data */
    public void insert(CoffeeNode<E> data){
      root = insert(data, root);
    }

    /* Funcion to get height of node */
    private int height(CoffeeNode<E>){
      return E == null ? -1 : E.height;
    }

    /* Function to get max of left/right node */
    private int max(int rhs, int lhs){
      return lhs > rhs ? lhs : rhs;
    }

    /* Function to recursively insert data */
    private CoffeeNode insert(int x, CoffeeNode<E>){
      if (E == null)
        E = new CoffeeNode(E);

      else if (x < E.data){
        E.left = insert(x, E.left);
        if (height(E.left) - height(E.right) > 1){
          if (x < t.left.data){
            x = rotateWithLeftChild(E);
          }
          else{
            x = doubleWithLeftChild(E);
          }
        }
      }
      else if (x > E.data){
        E.right = insert(x, E.right);

      }
    }



    public void remove (CoffeeNode<E> data){

    }


    public void addInOrder (CoffeeNode<E> data){

    }

    public void print(){

    }

    public void printBackwards(){

    }
}
