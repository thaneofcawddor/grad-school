public class Coffee implements Comparable{

    Coffee left, right;
    int price;
    String color;
    String company;

    public Coffee(int price, String color, String company)
    {
        this.price = price;
        this.color = color;
        this.company = company;

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
