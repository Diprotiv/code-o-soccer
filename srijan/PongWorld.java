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
    private Player team1[] = new Player[3];
    private Player team2[] = new Player[3];
    private Ball ball;
    /**
     * Constructor for objects of class PongWorld.
     * 
     */
    public PongWorld() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1150, 720, 1); 
        register(team1, "./images/germany.png");
        register(team2, "./images/italy.png");
        prepare();
      
    }


    public void register(Player team[], String icon) {
        for(int i = 0; i < 3; i++) {
            if(i == 0) {
                team[i] = new Goalkeeper(ball);
            }
            else if(i == 1) {
                team[i] = new Defender(ball);
            }
            else {
                team[i] = new Attacker(ball);
            }
            team[i].setImage(icon);
        }
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
        ball = new Ball(leftCounter,rightCounter);
        addObject(ball, 300, 215);     
        register(team1, "./images/germany.png");
        register(team2, "./images/italy.png");
        addPlayers(team1, true);
        addPlayers(team2, false);
        reset();
        team2[0].setLocation(137,417);
        team2[1].setLocation(371,506);
        team2[2].setLocation(151,363);
        team1[1].setLocation(752,540);
        team1[0].setLocation(1013,365);
        team1[2].setLocation(741,494);
        team1[2].setLocation(769,234);
        team2[2].setLocation(394,235);
    }

    public void addPlayers(Player[] team, boolean right) {
        if(right) {
            addObject(team[0], 300, 200);
            addObject(team[1], 400, 200);
            addObject(team[2], 500, 200);
        }
        else {
            addObject(team[0], 200, 200);
            addObject(team[1], 100, 200);
            addObject(team[2], 50, 200);
        }
    }
    
    public void reset() {
        
        ball.setLocation(573,369);
        ball.reset();
    }
}
