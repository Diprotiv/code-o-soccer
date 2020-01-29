import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goalkeeper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goalkeeper extends Goalie1
{
    /**
     * Act - do whatever the Goalkeeper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Goalkeeper(Ball b) {
        super(b);
    }
    
    public void act() {
        // Add your action code here.
        followBall();
    }    
    public void followBall() {
        if(ball.getY() < 280) {
            deltaY = 280;
        }
        else if(ball.getY() > 440) {
            deltaY = 440;
        }
        else {
            deltaY = ball.getY();
        }    
        setLocation(getX(), (int) deltaY);
        deltaY = 0;
    }
}
