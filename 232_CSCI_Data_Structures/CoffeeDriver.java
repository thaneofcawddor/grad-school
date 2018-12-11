public int compareTo(Object coffee1, Object coffee2){

/*  Returns 1 if coffee1 is greater than coffee2
    Returns -1 if coffee1 is less than coffee2
    Returns 0 it, after comparing all attributes, the two coffees are identical */

    System.out.println("compareTo being called on " + coffee1 + " and " + coffee2);

    if (coffee1.price - coffee2.price < 0){
        return -1;
    }
    else if (coffee1.price == coffee2.price){
      if (length(coffee1.company) < length(coffee2.company)){
        return -1
      }
      else if (coffee1.company == coffee2.company){
        if (length(coffee1.color)) < length(coffee2.color){
          return -1
        }
        else if (coffee1.color == coffee2.color){
          return 0
        }
        else{
          return 1
        }
      }
      else{
        return 1
      }
    }
    else{
        return 1;
    }
}

public static void main(String[] args) {

}
