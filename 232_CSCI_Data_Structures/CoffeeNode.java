
public class CoffeeNode implements Comparable{

    CoffeeNode left, right;
    int data;
    int height;

    public CoffeeNode()
    {
        left = null;
        right = null;
        height = 0;
        data = 0;
    }

    public CoffeeNode(Coffee coffee)
    {
        left = null;
        right = null;
        height = 0;
        data = coffee;
    }

}
