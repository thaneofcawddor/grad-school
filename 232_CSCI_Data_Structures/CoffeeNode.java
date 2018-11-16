
public class Coffee implements Comparable
{
    private int price;
    private String color;
    private String company;
    private String distributor;
    
    Coffee(int price, String color, String company, String distributor)
    {
        this.price = price;
        this.color = color;
        this.company = company;
        this.distributor = distributor;
    }

    public int compareTo(Object o) {
        throw new Exception("Not defined.");
    }

    public String toString(){
        return "";
    }
}

public class CoffeeNode<E>
{
    private E data;
    private CoffeeNode<E> leftChild;
    private CoffeeNode<E> rightChild;

    //Constructor
    public CoffeeNode()
    {
        this.leftChild = null;
        this.rightChild = null;
        this.data = SomeCoffeeData;
    }

    public E getData(){
        return data;
    }

    //Get methods
    public CoffeeNode getLeft()
    {
        return leftChild;
    }
    
    public CoffeeNode getRight()
    {
        return rightChild;
    }
    
    //Set methods
    public void setRight(CoffeeNode node)
    {
        this.rightChild = node;
    }
  
    public void setLeft(CoffeeNode node)
    {
        this.leftChild = node;
    }

}
