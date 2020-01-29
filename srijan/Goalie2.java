import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Paddle here.
 * 
 * @author Justin Durbin 
 * @version 2013
 */
public class Goalie2 extends Actor
{	
private LeftCounter counterPoints;
    public Goalie2(LeftCounter leftcounter)
    {
        counterPoints = leftcounter;
    }
    
    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        checkKeys();
        detectCollision();
    }  

    /**
     * test if the ball is at the top or the bottom
     */
    public boolean atTopOrBottom()
    {
        if (getY() < 78 || getY() > getWorld().getHeight() - 48)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * Allows the movement of Paddle.
     */
    public void checkKeys()
    {
        if (Greenfoot.isKeyDown("w")&&getY() > 80)
        {
            setLocation(getX(), getY()-5);
        }

        if (Greenfoot.isKeyDown("s")&&getY() < getWorld().getHeight() - 50)
        {
            setLocation(getX(), getY()+5);
        }
    }
    public void detectCollision()
    {
        Actor actor = getOneIntersectingObject(null);
        if (actor != null)
        {
            Greenfoot.playSound("click.wav");
        }
    }
}

