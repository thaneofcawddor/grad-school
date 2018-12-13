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
          if (x < E.left.data){
            x = rotateWithLeftChild(E);
          }
          else{
            x = doubleWithLeftChild(E);
          }
        }
      }
      else if (x > E.data){
        E.right = insert(x, E.right);
        if (height(E.right) - height(E.left) > 1){
          if (x < E.right.data){
            x = rotateWithRightChild(E);
          }
          else{
              x = doubleWithRightChild(E);
          }
        }
      }
      // Or else it is a duplicate, so do not add
      else {
        return E;
      }
    }

/* Performs a single rotation to correct a right-right error and corrects the height */
    private CoffeeNode<T> rotateRightRightSingle(CoffeeNode<T> currentNode){

      System.out.println("Beginning left rotation on node: " + currentNode.getData());

      CoffeeNode<T> newRootNode = currentNode.getRight();
      CoffeeNode<T> newLeftNode = newRootNode.getLeft();

      newRootNode.setNewLeft(currentNode);
      currentNode.setNewRight(newLeftNode);

      currentNode.setHeight(getHeight(currentNode));
      newRootNode.setHeight(getHeight(newRootNode));

      return newRootNode;

      /* This should work too:
      newRootNode.height = max(height(newRootNode.right), currentNode.height) + 1;
      */
    }

/* Performs a double rotation to correct a right-left error by doing the first rotation
then sending the result, now a right-right error, to the single rotation method */
    private CoffeeNode<T> rotateRightLeftDouble(CoffeeNode<T> currentNode){

      System.out.println("Beginning first of two rotations on node: " + currentNode.getData())

      CoffeeNode<T> newRightChild = currentNode.getRight();
      CoffeeNode<T> newRightNode = newRightChild.getLeft();
      CoffeeNode<T> newLeftChild = newRightChild.getRight();

      currentNode.setRight(newRightNode);
      newRightNode.setRight(newRightChild);
      newRightNode.setLeft(newLeftChild);

      rotateRightRightSingle(currentNode);
    }

}
