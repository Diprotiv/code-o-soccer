import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* Write a description of class Attacker here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class Attacker extends Goalie1 {
    
    /**
     * Act - do whatever the Attacker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Attacker(Ball b) {
        super(b);
    }
    public void act() {
        // Add your action code here.
        checkKeys();
        super.act();
    }    
    public void checkKeys() {
        if (Greenfoot.isKeyDown("up") && getY() > 45) {
            deltaY = -5;
            setLocation(getX(), getY() - 5);
        }
        if (Greenfoot.isKeyDown("down") && getY() < getWorld().getHeight() - 45) {
            deltaY += 5;
            setLocation(getX(), getY() + 5);
        }
        if(Greenfoot.isKeyDown("left") && getX() > 75) {
            deltaX = -5;
            setLocation(getX() - 5, getY());
        }
        if(Greenfoot.isKeyDown("right") && getX() < 1072) {
            deltaX = 5;
            setLocation(getX() + 5, getY());
        }
    }    
}
