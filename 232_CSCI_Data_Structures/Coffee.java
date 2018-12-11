public class Coffee implements Comparable{

    CoffeeNode left, right;
    int price;
    String color;
    String company;
    String distributor;

    public Coffee(int price, String color, String company, String distributor)
    {
        this.price = price;
        this.color = color;
        this.company = company;
        this.distributor = distributor;

        data =

        left = null;
        right = null;
        height = 0;
    }

    public int compareTo(Object o) {
        throw new Exception("Not defined.");
    }

    public String toString(){
        return "";
    }
}
