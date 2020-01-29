
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;

public class Ball extends Actor
{
    private int direction;
    private double friction = -0.9;
    public int diameter = 30;
    private double deltaX; // change in x direction
    private double deltaY; // change in y direction
    private LeftCounter leftCounterPoints;
    private RightCounter rightCounterPoints;
    private int leftCounterPointsAdd;
    private int rightCounterPointsAdd;
    public Ball(LeftCounter leftcounter,RightCounter rightcounter)
    {
        leftCounterPoints = leftcounter;
        rightCounterPoints = rightcounter;
        leftCounterPointsAdd = 0;
        rightCounterPointsAdd = 0;
    
        deltaX = deltaY = 1;
        
    }

    public void reset() {
        deltaX = deltaY = 1;
    }
    
    /**
     * Act - do whatever the ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(atGoal()) {
            if(getX() > 100) {
                leftCounterPoints.add(1);
                getWorldOfType(PongWorld.class).reset();
            }
            else {
                rightCounterPoints.add(1);
                getWorldOfType(PongWorld.class).reset();
            }
            return;
        }
        detectPaddle();
        ballMove();
        if (leftCounterPointsAdd == 10) {
            leftGameWon();
            Greenfoot.playSound("WINNER.wav");
            

        }
        if (rightCounterPointsAdd == 10) {
            rightGameWon();
            Greenfoot.playSound("WINNER.wav");
        }
    }

    /**
     * move the ball
     */
    public void ballMove() {
        int xCoordinate = getX() + (int) Math.round(deltaX);
        int yCoordinate = getY() + (int) Math.round(deltaY);
        setLocation(xCoordinate, yCoordinate);
        if (atTopOrBottom()) {
            deltaY *= friction;
        }
        if(atLeftOrRight()) {
            deltaX *= friction;
        }
        deltaX = Math.min(deltaX, 2);
        deltaX = Math.max(deltaX, -2);
        deltaY = Math.min(deltaY, 2);
        deltaY = Math.max(deltaY, -2);
        /*
        if (atSides() == true) {
            setLocation(300, 215);
            do 
            {
                direction = Greenfoot.getRandomNumber(6);
            }
            while (direction == 3);
            deltaX = direction - 3;
            deltaY = direction - 3;
        }
       */
    }

    /**
     * test if the ball is at the top or the bottom
     */
    public boolean atTopOrBottom()
    {
        if (getY() - diameter / 3 < 45 || getY() + diameter / 3 > getWorld().getHeight() - 45) {
            return true;
        }
        else {
            return false;
        }
    }
    
        /**
     * test if the ball is at the top or the bottom
     */
    public boolean atLeftOrRight() {
        if (getX() < 75 || getX() > 1072) {
            return true;
        }
        else {
            return false;
        }
    }

    public void detectPaddle() {
        Goalie1 rightPaddle = (Goalie1) getOneIntersectingObject(Goalie1.class);
        Goalie2 leftPaddle = (Goalie2) getOneIntersectingObject(Goalie2.class);
        if (rightPaddle!= null) {
            collide(rightPaddle);
            /*
            deltaX = -deltaX;
            int offset = getY() - rightPaddle.getY();
            deltaY = deltaY + offset/10;
            */
        }

        if (leftPaddle!= null) {
            deltaX = -deltaX;
            int offset = getY() - leftPaddle.getY();
            deltaY = deltaY + offset/10;
        }
    }

    public boolean atGoal() {
        if(getX() >= 1070 && getY() >= 284 && getY() <= 436) {
            return true;
        }
        if(getX() <= 80 && getY() >= 284 && getY() <= 436) {
            return true;
        }
        return false;
    }

    public void rightGameWon() {
        Greenfoot.stop();
    }

    public void leftGameWon() {
        Greenfoot.stop();
    }
    
    public void collide(Goalie1 paddle) {
        int dy = paddle.getX() - getX();
        int dx = paddle.getY() - getY();
        double d = Math.sqrt(dx * dx + dy * dy);
        double minDist = (paddle.diameter / 2.0) + (diameter / 2.0);
        if(d <= minDist + 1) {    
            double angle = Math.atan2(dy, dx);
            double targetX = getX() + Math.sin(angle) * minDist;
            double targetY = getY() + Math.cos(angle) * minDist;
            double aX = targetX - getX();
            double aY = targetY - getY();
            deltaX = - (aX);
            deltaY = - (aY);
        }
    }
}

