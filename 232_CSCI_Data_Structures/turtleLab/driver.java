public class Turtle extends JFrame(){
    private int x, y;
    private int angle;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if(grid == null){
           int w = this.getWidth();
           int h = this.getHeight();
           grid = (BufferedImage)(this.createImage(w,h));
           gc = grid.createGraphics();

        }
        g2.drawImage(grid, null, 0, 0);
    }

    public void fd(){

    }

    public void right(){

    }

    public void left(){

    }

    public void penup(){

    }

    public void pendown(){

    }

    public void home(){

    }

    public void goTo(){

    }

    public void xcor(){

    }

    public void ycor(){

    }

    public void setHeading(int rotationDegree){

    }

    public void speed(int speed){

    }

    public void pensize(int penSize){

    }

    public void clear(){

    }

    public void penColor(int R, int G, int B){

    }
}

public static void main(String[] args){
  Turtle norbert = new Turtle();
  try{Thread.sleep(200);}catch(Exception e){}
  norbert.penColor(255, 255, 0);
  norbert.setPenSize(5);
  int sides =8;
  int length = 55;
  for(int i = 0; i< sides; i++){
    norbert.fd(length);
    norbert.left(360/sides);
  }
  norbert.penUp();
  norbert.goTO(-30, -25);
  norbert.penDown();
  norbert.penColor(0, 0, 255);
  norbert.fd(125);
}
