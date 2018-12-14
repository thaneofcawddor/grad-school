public class Turtle extends JFrame(){
    private int x, y;
    private int angle;

    public static int width = 300;
    public static int height = 300;

    private static JPanel panel;
    private static JFrame jframe;
    private static Graphics graphics;

    public Turtle (int x, int y, int angle){
      if (jframe == null) {
           jframe= new JFrame("Turtle window");
           panel= new JPanel();
           panel.setPreferredSize(new Dimension(width, height));
           jframe.getContentPane().add(panel, BorderLayout.CENTER);
           jframe.pack();
           jframe.show();
           graphics= panel.getGraphics();
           clear();
           this.x= x;
           this.y= y;
           clear();

       }

       this.x= x;
       this.y= y;
       turtleAngle= ang;
   }
    }

    public void fd(){
      int currentx = x;
      int currenty = y;
      x += step * Math.cos(Math.toRadians(angle));
      y += step * Math.sin(Math.toRadians(angle));
      StdDraw.line(currentx, currenty, x, y);
    }

    public void right(turnDegree){
      angle -= turnDegree;
    }

    public void left(int turnDegree){
      angle += turnDegree;

    }

    public void penup(){
      penDown = false;
    }

    public void pendown(){
      penDown = true;
    }

    public void home(){
      goTo(0,0);
    }

    public void goTo(int a, int b){
      x = width/2 + a;
      y = height/2 + b;
    }

    public void xcor(){
      return x;
    }

    public void ycor(){
      return y;
    }

    public void setHeading(int rotationDegree){

    }

    public void speed(int speed){

    }

    public void pensize(int penSize){
      StdDraw.setPenRadius(penSize);
    }

    public void clear(){
      Color newColor = new Color(255, 255, 255);
      graphics.fillRect(0, 0, width, height);
      graphics.setColor(newColor);
    }

    public void penColor(int R, int G, int B){
      Color newColor = new Color(R, G, B);
      penColor.setColor(newColor);
    }
}

public class DrawingPanel extends JPanel(){

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
  norbert.goTo(-30, -25);
  norbert.penDown();
  norbert.penColor(0, 0, 255);
  norbert.fd(125);
}
