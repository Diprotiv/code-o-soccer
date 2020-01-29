import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Paddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goalie1 extends Actor {  
    public Ball ball;
    public double deltaX, deltaY;
    public int diameter = 51;
    // private int diameter = imageWidth;
    public Goalie1(Ball b) {
        ball = b;
    }
    public boolean atToporBottom() {
        if (getY() < 20 || getY() > getWorld().getHeight() - 20)

            return true;
        else 
            return false;
    }

    /**x
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // checkKeys();
        detectCollision();
        move();
    }  

    public void move() {
        int xCoordinate = getX() + (int) Math.round(deltaX);
        int yCoordinate = getY() + (int) Math.round(deltaY);
        setLocation(xCoordinate, yCoordinate);
    }
    /**
     * Allows the movement of Paddle.
     */
 

    public void detectCollision() {
        Goalie1 another = (Goalie1) getOneIntersectingObject(Goalie1.class);
        if(another == null) {
            return;
        }
        int dx = another.getX() - getX();
        int dy = another.getY() - getY();
        double d = Math.sqrt(dx * dx + dy * dy);
        double minDist = (another.diameter / 2.0) + (diameter / 2.0);
        if(d <= minDist) {
            deltaX = deltaY = 0;
            another.deltaX = another.deltaY = 0;
        }
    }
    
 
}

