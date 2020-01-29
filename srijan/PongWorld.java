import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class PongWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PongWorld extends World {
    private LeftCounter leftCounter; 
    private  RightCounter rightCounter;
    private Goalie1 goalie1;
    private Attacker attack1;
    private Goalie2 goalie2;
    private Ball ball;
    /**
     * Constructor for objects of class PongWorld.
     * 
     */
    public PongWorld() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1150, 720, 1); 
        
        prepare();
      
    }



    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare() {
        leftCounter = new LeftCounter();
        addObject(leftCounter, 300, 25);
        leftCounter.setLocation(195, 25);
        rightCounter = new RightCounter();
        addObject(rightCounter, 406, 25);
        leftCounter.setLocation(98,38);
        rightCounter.setLocation(191,38);
        reset();
    }
    
    public void reset() {
        if(ball == null) {
            ball = new Ball(leftCounter,rightCounter);
            goalie1 = new Goalkeeper(ball);
            attack1 = new Attacker(ball);
            goalie2 = new Goalie2(leftCounter);
            addObject(attack1, 300, 200);
            addObject(ball, 300, 215);                
            addObject(goalie2, 30, 219);
            addObject(goalie1, 579, 215);
        }
        
        goalie1.setLocation(574, 214);
        goalie2.setLocation(25, 215);
        goalie1.setLocation(575, 215);

        goalie1.setLocation(1014,369);
        goalie2.setLocation(135,357);
        ball.setLocation(573,369);
        ball.reset();
    }
}
