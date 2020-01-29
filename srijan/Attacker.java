import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* Write a description of class Attacker here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class Attacker extends Player {
    
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
            setLocation(getX(), getY() - 5);
        }
        if (Greenfoot.isKeyDown("down") && getY() < getWorld().getHeight() - 45) {
            setLocation(getX(), getY() + 5);
        }
        if(Greenfoot.isKeyDown("left") && getX() > 75) {
            setLocation(getX() - 5, getY());
        }
        if(Greenfoot.isKeyDown("right") && getX() < 1072) {
            setLocation(getX() + 5, getY());
        }
    }    
}
