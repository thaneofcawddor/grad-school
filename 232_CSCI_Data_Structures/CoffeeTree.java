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

    private rotateWithRightChild(CoffeeNode currentNode){
      CoffeeNode newRootNode = currentNode.right;
      CoffeeNode newLeftNode = newRootNode.left;

      newRootNode.setLeft(currentNode);
      currentNode.setRight(newLeftNode);

      currentNode.height = max(height(currentNode.left), height(currentNode.right)) + 1;
      newRootNode.height = max(height(newRootNode.right), currentNode.height) + 1;
    }

    private doubleWithRightChild(CoffeeNode currentNode){
      CoffeeNode newRightChild = currentNode.right;
      CoffeeNode newRightNode = newRightChild.left;
      CoffeeNode newLeftChild = newRightChild.right;

      currentNode.setRight(newRightNode);
      newRightNode.setRight(newRightChild);
      newRightNode.setLeft(newLeftChild);

      rotateWithRightChild(currentNode);
    }

}
