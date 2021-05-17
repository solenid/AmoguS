
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class Frame extends JFrame implements MouseListener {

    public int[] crewx = new int[10];
    public int[] crewy = new int[10];

    StreamWorker postman;
    BufferedImage back;
    BufferedImage logo;
    BufferedImage map;
    BufferedImage miner;
    BufferedImage proximitymines;
    Direction direction;
    Crewmate crewmate ;

    public  int countcoordx = 0;
    public  int countcoordy = 0;
    public int cx;
    public int cy;
    public int number=0;
    public int bombx1;
    public int bomby1;
    public int bombx2;
    public int bomby2;
    public int bombx3;
    public int bomby3;
    int a;
    int b;
    int c;
    int d;

    public boolean bomb1planted = false;
    public boolean bomb2planted = false;
    public boolean bomb3planted = false;


    ArrayList<Bullets> bullets = new ArrayList<Bullets>();
    ArrayList<Mines> claimers = new ArrayList<Mines>();


    public int bombs=0;

    //
    ArrayList<RectangleWall> rekt = new ArrayList<RectangleWall>();
    ArrayList<Crewmate> crew = new ArrayList<Crewmate>();

    Frame(Direction direction) throws IOException {

        this.setSize(1551, 871);
        this.setLocation(-7, 0);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.addMouseListener(this);
        this.direction = direction;
        rekt.add(new RectangleWall(2020,40,400,600));
        rekt.add(new RectangleWall(20,1640,800,400));
        rekt.add(new RectangleWall(20,2040,200,1600));
        rekt.add(new RectangleWall(620,2040,200,400));
        rekt.add(new RectangleWall(220,3040,800,600));
        rekt.add(new RectangleWall(4020,40,400,1200));
        rekt.add(new RectangleWall(2020,1040,400,2600));
        rekt.add(new RectangleWall(1220,1660,800,800));
        rekt.add(new RectangleWall(2420,1640,600,600));
        rekt.add(new RectangleWall(1420,3040,600,600));
        rekt.add(new RectangleWall(4820,840,800,400));
        rekt.add(new RectangleWall(3420,1640,1000,600));
        rekt.add(new RectangleWall(4420,1640,2000,400));
        rekt.add(new RectangleWall(4220,2240,200,800));
        rekt.add(new RectangleWall(4220,3440,200,600));
        rekt.add(new RectangleWall(4420,2840,800,200));
        rekt.add(new RectangleWall(4820,3040,400,400));
        rekt.add(new RectangleWall(6220,2040,200,1400));
        rekt.add(new RectangleWall(5620,2840,600,600));
        rekt.add(new RectangleWall(4420,3840,3600,200));
        rekt.add(new RectangleWall(6020,840,1600,400));
        rekt.add(new RectangleWall(7220,440,400,400));
        rekt.add(new RectangleWall(6820,1240,200,1000));
        rekt.add(new RectangleWall(6820,2640,200,800));
        rekt.add(new RectangleWall(7020,3240,1000,200));

            crew.add(new Crewmate(760,420,0,0));


        this.logo = ImageIO.read(new File("C:\\Users\\Мегадрайв\\IdeaProjects\\Among ass\\src\\CompLexity_Gaming_logo.svg.png"));
        this.setIconImage(logo);
        //this.crewmate = new Crewmate(this);

        this.map = ImageIO.read(new File("C:\\Users\\Мегадрайв\\IdeaProjects\\Among ass\\src\\imgonline-com-ua-Resize-FNYMYWFXYQDP.png"));
        this.back = ImageIO.read(new File("C:\\Users\\Мегадрайв\\IdeaProjects\\Among ass\\src\\planety-kosmos-space-tma-svet-neizvestnost-zvezda-vselennaia.png"));
        this.proximitymines = ImageIO.read(new File("C:\\Users\\Мегадрайв\\IdeaProjects\\Among ass\\src\\imgonline-com-ua-Resize-mbtlq4k75U.png"));
        this.miner = ImageIO.read(new File("C:\\Users\\Мегадрайв\\IdeaProjects\\Among ass\\src\\imgonline-com-ua-Resize-ag1mnZWeqdnK.png"));
        createBufferStrategy(2);
    }
    @Override
    public void paint(Graphics g) {


        //super.paint(g);
        BufferStrategy bufferStrategy = getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(2);
            bufferStrategy = getBufferStrategy();
        }
        g = bufferStrategy.getDrawGraphics();
        g.setColor(Color.white);
        //g.fillRect(-10,-10,2000,2000);
        g.setColor(Color.red);
        //g.drawImage(back,-7,0,null);
        //g.fillRect((getWidth() - 31) / 2, (getHeight() - 31) / 2, 31, 31);
        g.drawImage(miner,(getWidth()-51)/2,(getHeight()-26)/2,null);
        //g.fillRect(134,0,20,800);
        //prop1+=25;
        //g.drawLine(100,50+prop1,600,150+prop1);
        //System.out.println("f"+(getWidth()-31)/2);
        //System.out.println("h"+(getHeight()-31)/2);
        //System.out.println(getWidth());
        //if (bullets.size()!=0) {

        //}
        this.crewmate = new Crewmate(this);






        switch (direction) {

            case RIGHT:
                System.out.println(number);
                this.crewmate.coordx += countcoordx;
                //countcoordx+=15;
                g.drawImage(back, -7, 0, null);

                //System.out.println(crewmate.coordy);
                //System.out.println(countcoordy);
                //System.out.println((getHeight()-31)/2);

                if (crewmate.coordx + 7975 - 43 > (getWidth() - 31) / 2) {



                    //System.out.println(direction);


                    //System.out.println(crewmate.x);
                    g.setColor(Color.red);
                    g.drawImage(map, 20 + crewmate.coordx, 40 + crewmate.coordy + countcoordy, null);
                    if ((bombs==1)&&(bomb1planted==false)){
                        g.drawImage(proximitymines,760 + bombx1,420 + bomby1,null);
                        postman.sendMessage("Bomb " + number + " " + countcoordx + " " + countcoordy);
                        bomb1planted = true;

                    }
                    if ((bombs==2)&&(bomb2planted==false)){
                        g.drawImage(proximitymines,760 + bombx2,420 + bomby2,null);
                        bomb2planted = true;
                        postman.sendMessage("Bomb " + number + " " + countcoordx + " " + countcoordy);
                    }
                    if ((bombs==3)&&(bomb3planted==false)){
                        g.drawImage(proximitymines,760 + bombx3,420 + bomby3,null);
                        bomb3planted = true;
                        postman.sendMessage("Bomb " + number + " " + countcoordx + " " + countcoordy);
                    }
                    if (bomb1planted == true){
                        System.out.println("bombx" + bombx1);
                        g.setColor(Color.green);
                        g.drawImage(proximitymines,760 + bombx1,420 + bomby1,null);
                        //g.fillRect(760 + bombx1,420 + bomby1,20,20);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb2planted == true){
                        System.out.println("bombx2" + bombx2);
                        g.setColor(Color.green);
                        g.drawImage(proximitymines,760 + bombx2,420 + bomby2,null);
                        //g.fillRect(760 + bombx2,420 + bomby2,20,20);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb3planted == true){
                        System.out.println("bombx3" + bombx3);
                        g.setColor(Color.green);
                        g.drawImage(proximitymines,760 + bombx3,420 + bomby3,null);
                        //g.fillRect(760 + bombx3,420 + bomby3,20,20);
                        //System.exit(5);
                        //bombplanted = false;
                    }

                    for(int i=0;i<claimers.size();i++){
                        if (claimers.get(i).mineid==number){
                            g.setColor(Color.green);
                            //g.drawImage(proximitymines,claimers.get(i).x,claimers.get(i).y,null);
                            g.fillRect(claimers.get(i).x,claimers.get(i).y,20,20);
                        }
                    }
                    Random random = new Random();
                    Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                    g.setColor(color);
                    //System.out.println(crewmate.x + cx );
                    //System.out.println(rekt.get(i).rectx + rekt.get(i).rectwid);
                    //System.out.println( crewmate.y + cy );
                    //System.out.println(rekt.get(i).recty + rekt.get(i).recthei);

                    for (int i = 0; i < 15; i++) {
                        //System.out.println("x"+cx);
                        //System.out.println("y"+cy);
                        //System.out.println(i);
                        if ((crewmate.x + cx + 15 + 73 > rekt.get(i).rectx) && (crewmate.x + cx + 15 + 73 < (rekt.get(i).rectx + rekt.get(i).rectwid)) && (crewmate.y + cy + 28 > rekt.get(i).recty) && (crewmate.y + cy + 28 < (rekt.get(i).recty + rekt.get(i).recthei))) {
                            //2020,40,400,600
                            //System.out.println("робит");
                            ///System.out.println(cx);
                            //System.out.println(cy);
                            //System.exit(i);
                            countcoordx +=15;
                            cx-=15;
                            if (bomb1planted == true) {

                                bombx1 += 15;
                            }
                            if (bomb2planted == true) {

                                bombx2 += 15;
                            }
                            if (bomb3planted == true) {

                                bombx3 += 15;
                            }

                            //
                        }
                    }
                    countcoordx -= 15;
                    if (bomb1planted == true) {
                        bombx1 -= 15;
                    }
                    if (bomb2planted == true) {
                        bombx2 -= 15;
                    }
                    if (bomb3planted == true) {
                        bombx3 -= 15;
                    }
                    postman.sendMessage("Coordxr " + number + " " + countcoordx);
                    cx += 15;
                    g.setColor(Color.red);
                    //g.drawImage(map, 20 + crewmate.coordx, 40 + crewmate.coordy + countcoordy, null);
                    g.setColor(color);
                    g.fillRect(2020 + crewmate.coordx, 40 + crewmate.coordy + countcoordy, 400, 600);
                    //g.fillRect(rekt.get(0).rectx + crewmate.coordx, rekt.get(0).recty + crewmate.coordy + countcoordy, 400, 600);
                    g.fillRect(20 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 800, 400);
                    g.fillRect(20 + crewmate.coordx, 2040 + crewmate.coordy + countcoordy, 200, 1600);
                    g.fillRect(620 + crewmate.coordx, 2040 + crewmate.coordy + countcoordy, 200, 400);
                    g.fillRect(220 + crewmate.coordx, 3040 + crewmate.coordy + countcoordy, 800, 600);
                    g.fillRect(4020 + crewmate.coordx, 40 + crewmate.coordy + countcoordy, 400, 1200);
                    g.fillRect(2020 + crewmate.coordx, 1040 + crewmate.coordy + countcoordy, 400, 2600);
                    g.fillRect(1220 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 800, 800);
                    g.fillRect(2420 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 600, 600);
                    g.fillRect(1420 + crewmate.coordx, 3040 + crewmate.coordy + countcoordy, 600, 600);
                    g.fillRect(4820 + crewmate.coordx, 840 + crewmate.coordy + countcoordy, 800, 400);
                    g.fillRect(3420 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 1000, 600);
                    g.fillRect(4420 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 2000, 400);
                    g.fillRect(4220 + crewmate.coordx, 2240 + crewmate.coordy + countcoordy, 200, 800);
                    g.fillRect(4220 + crewmate.coordx, 3440 + crewmate.coordy + countcoordy, 200, 600);
                    g.fillRect(4420 + crewmate.coordx, 2840 + crewmate.coordy + countcoordy, 800, 200);
                    g.fillRect(4820 + crewmate.coordx, 3040 + crewmate.coordy + countcoordy, 400, 400);
                    g.fillRect(6220 + crewmate.coordx, 2040 + crewmate.coordy + countcoordy, 200, 1400);
                    g.fillRect(5620 + crewmate.coordx, 2840 + crewmate.coordy + countcoordy, 600, 600);
                    g.fillRect(4420 + crewmate.coordx, 3840 + crewmate.coordy + countcoordy, 3600, 200);
                    g.fillRect(6020 + crewmate.coordx, 840 + crewmate.coordy + countcoordy, 1600, 400);
                    g.fillRect(7220 + crewmate.coordx, 440 + crewmate.coordy + countcoordy, 400, 400);
                    g.fillRect(6820 + crewmate.coordx, 1240 + crewmate.coordy + countcoordy, 200, 1000);
                    g.fillRect(6820 + crewmate.coordx, 2640 + crewmate.coordy + countcoordy, 200, 800);
                    g.fillRect(7020 + crewmate.coordx, 3240 + crewmate.coordy + countcoordy, 1000, 200);



                } else {
                    g.setColor(Color.red);
                    g.drawImage(map, 20 + crewmate.coordx, 40 + crewmate.coordy + countcoordy, null);
                    Random random = new Random();
                    if (bomb1planted == true){
                        System.out.println("bombx1" + bombx1);
                        //g.setColor(Color.green);
                        //g.drawImage(proximitymines,760 + bombx1,420 + bomby1,null);
                        //g.fillRect(760 + bombx1,420 + bomby1,20,20);
                        g.drawImage(proximitymines,760 + bombx1, 420 + bomby1,null);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb2planted == true){
                        System.out.println("bombx2" + bombx2);
                        //g.setColor(Color.green);
                        //g.drawImage(proximitymines,760 + bombx2,420 + bomby2,null);
                        g.drawImage(proximitymines,760 + bombx2, 420 + bomby2,null);
                        //g.fillRect(760 + bombx2,420 + bomby2,20,20);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb3planted == true){
                        System.out.println("bombx3" + bombx3);
                        //g.setColor(Color.green);
                        //g.drawImage(proximitymines,760 + bombx3,420 + bomby3,null);
                        g.drawImage(proximitymines,760 + bombx1, 420 + bomby1,null);
                        //g.fillRect(760 + bombx3,420 + bomby3,20,20);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb1planted == true){
                        System.out.println("bombx" + bombx1);
                        g.setColor(Color.green);
                        g.drawImage(proximitymines,760 + bombx1,420 + bomby1,null);
                        //g.fillRect(760 + bombx1,420 + bomby1,20,20);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb2planted == true){
                        System.out.println("bombx2" + bombx2);
                        g.setColor(Color.green);
                        g.drawImage(proximitymines,760 + bombx2,420 + bomby2,null);
                        //g.fillRect(760 + bombx2,420 + bomby2,20,20);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb3planted == true){
                        System.out.println("bombx3" + bombx3);
                        g.setColor(Color.green);
                        g.drawImage(proximitymines,760 + bombx3,420 + bomby3,null);
                        //g.fillRect(760 + bombx3,420 + bomby3,20,20);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                    g.setColor(color);
                    g.fillRect(2020 + crewmate.coordx, 40 + crewmate.coordy + countcoordy, 400, 600);
                    g.fillRect(20 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 800, 400);
                    g.fillRect(20 + crewmate.coordx, 2040 + crewmate.coordy + countcoordy, 200, 1600);
                    g.fillRect(620 + crewmate.coordx, 2040 + crewmate.coordy + countcoordy, 200, 400);
                    g.fillRect(220 + crewmate.coordx, 3040 + crewmate.coordy + countcoordy, 800, 600);
                    g.fillRect(4020 + crewmate.coordx, 40 + crewmate.coordy + countcoordy, 400, 1200);
                    g.fillRect(2020 + crewmate.coordx, 1040 + crewmate.coordy + countcoordy, 400, 2600);
                    g.fillRect(1220 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 800, 800);
                    g.fillRect(2420 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 600, 600);
                    g.fillRect(1420 + crewmate.coordx, 3040 + crewmate.coordy + countcoordy, 600, 600);
                    g.fillRect(4820 + crewmate.coordx, 840 + crewmate.coordy + countcoordy, 800, 400);
                    g.fillRect(3420 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 1000, 600);
                    g.fillRect(4420 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 2000, 400);
                    g.fillRect(4220 + crewmate.coordx, 2240 + crewmate.coordy + countcoordy, 200, 800);
                    g.fillRect(4220 + crewmate.coordx, 3440 + crewmate.coordy + countcoordy, 200, 600);
                    g.fillRect(4420 + crewmate.coordx, 2840 + crewmate.coordy + countcoordy, 800, 200);
                    g.fillRect(4820 + crewmate.coordx, 3040 + crewmate.coordy + countcoordy, 400, 400);
                    g.fillRect(6220 + crewmate.coordx, 2040 + crewmate.coordy + countcoordy, 200, 1400);
                    g.fillRect(5620 + crewmate.coordx, 2840 + crewmate.coordy + countcoordy, 600, 600);
                    g.fillRect(4420 + crewmate.coordx, 3840 + crewmate.coordy + countcoordy, 3600, 200);
                    g.fillRect(6020 + crewmate.coordx, 840 + crewmate.coordy + countcoordy, 1600, 400);
                    g.fillRect(7220 + crewmate.coordx, 440 + crewmate.coordy + countcoordy, 400, 400);
                    g.fillRect(6820 + crewmate.coordx, 1240 + crewmate.coordy + countcoordy, 200, 1000);
                    g.fillRect(6820 + crewmate.coordx, 2640 + crewmate.coordy + countcoordy, 200, 800);
                    g.fillRect(7020 + crewmate.coordx, 3240 + crewmate.coordy + countcoordy, 1000, 200);

                }


                g.setColor(Color.red);
                //g.fillRect((getWidth() - 31) / 2, (getHeight() - 31) / 2, 31, 31);
                g.drawImage(miner,(getWidth()-51)/2,(getHeight()-26)/2,null);
                //g.drawRect((getWidth()-51)/2,(getHeight()-26)/2,103,53);
                g.setColor(Color.red);

                for(int i=0;claimers.size()>i;i++){

                    if (claimers.get(i).mineid!=number){
                        for (int j=0;j<10;j++){
                            System.out.println("eeeeeeeeeeeeeeeeeeeee" + crewx[j]);
                            if (j!=number-1){
                                if ((claimers.get(i).x>=crewmate.coordx)&&(claimers.get(i).x<=crewmate.coordx+103)&&(claimers.get(i).y>=crewmate.coordy+countcoordy)&&(claimers.get(i).y<=crewmate.coordy + countcoordy+53)){
                                    postman.sendMessage("Dead " + number);
                                    System.exit(i);
                                }
                            }
                        }


                    }
                }
                for(int i=0;i<10;i++){
                    if (i!=number-1){
                        //System.out.println(760 + crewx[i]+crewmate.coordx);
                        //System.out.println(crewx[i] + "zstxdfcgvuhbj");
                        //System.out.println(420 + crewy[i] + crewmate.coordy + countcoordy);
                        //g.fillRect(760 - crewx[i]+crewmate.coordx,420 - crewy[i] + crewmate.coordy + countcoordy,31,31);
                        g.drawImage(miner,760 - crewx[i] + crewmate.coordx,420 - crewy[i] + crewmate.coordy + countcoordy,null);

                    }
                }
                for (int i = 0; i < bullets.size(); i++) {
                    if (bullets.get(i).id==number) {

                        if ((Math.abs(bullets.get(i).bulletx) - Math.abs(bullets.get(i).gotox) < 1 && Math.abs(bullets.get(i).bulletx) - Math.abs(bullets.get(i).gotox) > -1) && (Math.abs(bullets.get(i).bullety) - Math.abs(bullets.get(i).gotoy) < 1 && Math.abs(bullets.get(i).bullety) - Math.abs(bullets.get(i).gotoy) > -1)) {

                            System.out.println("123456789");
                            postman.sendMessage("Remove " + i);
                        } else {
                            bullets.get(i).bulletx += (bullets.get(i).gotox - bullets.get(i).bulletx) / 15;
                            bullets.get(i).bullety += (bullets.get(i).gotoy - bullets.get(i).bullety) / 15;
                            g.setColor(Color.red);
                            int k1 = (int) (getWidth() / 2 - 11 + bullets.get(i).bulletx + countcoordx);
                            int k2 = (int) (getHeight() / 2 + 15 + bullets.get(i).bullety + countcoordy);
                            g.fillOval(k1, k2, 10, 10);
                        }
                        for (int j = 0; j < 10; j++) {
                            if (j != number - 1) {
                                g.setColor(Color.red);
                                //g.drawRect(760 - crewx[j] + crewmate.coordx, 420 - crewy[j] + crewmate.coordy + countcoordy, 103, 53);
                                int a1 = (int) (getWidth() / 2 - 11 + bullets.get(i).bulletx + countcoordx);
                                int a2 = (int) (getHeight() / 2 + 15 + bullets.get(i).bullety + countcoordy);
                                //System.out.println(760 - crewx[j] + crewmate.coordx + "икс");
                                //System.out.println(a1);
                                //System.out.println(420 - crewy[j] + crewmate.coordy + countcoordy + "игрик");
                                //System.out.println(a2);
                                if ((770 - crewx[j] + crewmate.coordx< a1) && (770 - crewx[j] + crewmate.coordx> a1 - 113) && (453 - crewy[j] + crewmate.coordy + countcoordy < a2) && (453 - crewy[j] + crewmate.coordy + countcoordy > a2 - 63)) {
                                    postman.sendMessage("Deadb " + number);

                                    System.out.println("DEEEEEEEEEEEEEEEEEEEEEEEEAD");
                                }
                            }
                        }



                    }

                }
                //g.fillRect(crew.get(0).x, crew.get(0).y, 31, 31);
                //g.fillRect(crew.get(1).x, crew.get(1).y, 31, 31);
                //g.fillRect(crew.get(2).x, crew.get(2).y, 31, 31);
                //g.fillRect(crew.get(3).x, crew.get(3).y, 31, 31);
                //g.fillRect(crew.get(4).x, crew.get(4).y, 31, 31);
                //g.fillRect(crew.get(5).x, crew.get(5).y, 31, 31);
                //g.fillRect(crew.get(6).x, crew.get(6).y, 31, 31);
                //g.fillRect(crew.get(7).x, crew.get(7).y, 31, 31);
                //g.fillRect(crew.get(8).x, crew.get(8).y, 31, 31);
                //g.fillRect(crew.get(9).x, crew.get(9).y, 31, 31);

                break;


            case LEFT:

                this.crewmate.coordx += countcoordx;
                //System.out.println(crewmate.coordx);
                //System.out.println(crewmate.coordy + countcoordy);
                g.drawImage(back, -7, 0, null);


                if (((40 + crewmate.coordx - 5 < (getWidth() - 31) / 2))) {
                    g.setColor(Color.red);
                    //System.out.println(countcoordx);
                    g.drawImage(map, 20 + crewmate.coordx, 40 + crewmate.coordy + countcoordy, null);
                    if ((bombs==1)&&(bomb1planted==false)){
                        g.setColor(Color.green);
                        g.drawImage(proximitymines,760 + bombx1,420 + bomby1,null);
                        //g.fillRect(760 + bombx1,420 + bomby1,20,20);
                        bomb1planted = true;
                        postman.sendMessage("Bomb1 " + number + " " + countcoordx + " " + countcoordy);

                    }
                    if ((bombs==2)&&(bomb2planted==false)){
                        g.setColor(Color.green);
                        g.drawImage(proximitymines,760 + bombx2,420 + bomby2,null);
                        //g.fillRect(760 + bombx2,420 + bomby2,20,20);
                        bomb2planted = true;
                        postman.sendMessage("Bomb2 " + number + " " + countcoordx + " " + countcoordy);
                    }
                    if ((bombs==3)&&(bomb3planted==false)){
                        g.setColor(Color.green);
                        g.drawImage(proximitymines,760 + bombx3,420 + bomby3,null);
                        //g.fillRect(760 + bombx3,420 + bomby3,20,20);
                        bomb3planted = true;
                        postman.sendMessage("Bomb3 " + number + " " + countcoordx + " " + countcoordy);
                    }
                    if (bomb1planted == true){
                        System.out.println("bombx" + bombx1);
                        g.setColor(Color.green);
                        g.drawImage(proximitymines,760 + bombx1,420 + bomby1,null);
                        //g.fillRect(760 + bombx1,420 + bomby1,20,20);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb2planted == true){
                        System.out.println("bombx2" + bombx2);
                        g.setColor(Color.green);
                        g.drawImage(proximitymines,760 + bombx2,420 + bomby2,null);
                        //g.fillRect(760 + bombx2,420 + bomby2,20,20);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb3planted == true){
                        System.out.println("bombx3" + bombx3);
                        g.setColor(Color.green);
                        g.drawImage(proximitymines,760 + bombx3,420 + bomby3,null);
                        //g.fillRect(760 + bombx3,420 + bomby3,20,20);
                        //System.exit(5);
                        //bombplanted = false;
                    }

                    Random random = new Random();
                    Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                    g.setColor(color);
                    for (int i = 0; i < 15; i++) {
                        if ((crewmate.x + cx - 33 > rekt.get(i).rectx) && (crewmate.x + cx - 33 < (rekt.get(i).rectx + rekt.get(i).rectwid)) && (crewmate.y + cy + 15 > rekt.get(i).recty) && (crewmate.y + cy + 15 < (rekt.get(i).recty + rekt.get(i).recthei))) {
                            //System.exit(i);
                            countcoordx -= 15;
                            cx += 15;
                            if (bomb1planted == true) {

                                bombx1 -= 15;
                            }
                            if (bomb2planted == true) {

                                bombx2 -= 15;
                            }
                            if (bomb3planted == true) {

                                bombx3 -= 15;
                            }
                        }
                    }
                    if (bomb1planted == true) {
                        bombx1 += 15;
                    }
                    if (bomb2planted == true) {
                        bombx2 += 15;
                    }
                    if (bomb3planted == true) {
                        bombx3 += 15;
                    }
                    countcoordx += 15;
                    postman.sendMessage("Coordxl " + number + " " + countcoordx);
                    cx -= 15;
                    g.setColor(Color.red);
                    //g.drawImage(map, 20 + crewmate.coordx, 40 + crewmate.coordy + countcoordy, null);
                    g.setColor(color);
                    g.fillRect(2020 + crewmate.coordx, 40 + crewmate.coordy + countcoordy, 400, 600);
                    g.fillRect(20 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 800, 400);
                    g.fillRect(20 + crewmate.coordx, 2040 + crewmate.coordy + countcoordy, 200, 1600);
                    g.fillRect(620 + crewmate.coordx, 2040 + crewmate.coordy + countcoordy, 200, 400);
                    g.fillRect(220 + crewmate.coordx, 3040 + crewmate.coordy + countcoordy, 800, 600);
                    g.fillRect(4020 + crewmate.coordx, 40 + crewmate.coordy + countcoordy, 400, 1200);
                    g.fillRect(2020 + crewmate.coordx, 1040 + crewmate.coordy + countcoordy, 400, 2600);
                    g.fillRect(1220 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 800, 800);
                    g.fillRect(2420 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 600, 600);
                    g.fillRect(1420 + crewmate.coordx, 3040 + crewmate.coordy + countcoordy, 600, 600);
                    g.fillRect(4820 + crewmate.coordx, 840 + crewmate.coordy + countcoordy, 800, 400);
                    g.fillRect(3420 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 1000, 600);
                    g.fillRect(4420 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 2000, 400);
                    g.fillRect(4220 + crewmate.coordx, 2240 + crewmate.coordy + countcoordy, 200, 800);
                    g.fillRect(4220 + crewmate.coordx, 3440 + crewmate.coordy + countcoordy, 200, 600);
                    g.fillRect(4420 + crewmate.coordx, 2840 + crewmate.coordy + countcoordy, 800, 200);
                    g.fillRect(4820 + crewmate.coordx, 3040 + crewmate.coordy + countcoordy, 400, 400);
                    g.fillRect(6220 + crewmate.coordx, 2040 + crewmate.coordy + countcoordy, 200, 1400);
                    g.fillRect(5620 + crewmate.coordx, 2840 + crewmate.coordy + countcoordy, 600, 600);
                    g.fillRect(4420 + crewmate.coordx, 3840 + crewmate.coordy + countcoordy, 3600, 200);
                    g.fillRect(6020 + crewmate.coordx, 840 + crewmate.coordy + countcoordy, 1600, 400);
                    g.fillRect(7220 + crewmate.coordx, 440 + crewmate.coordy + countcoordy, 400, 400);
                    g.fillRect(6820 + crewmate.coordx, 1240 + crewmate.coordy + countcoordy, 200, 1000);
                    g.fillRect(6820 + crewmate.coordx, 2640 + crewmate.coordy + countcoordy, 200, 800);
                    g.fillRect(7020 + crewmate.coordx, 3240 + crewmate.coordy + countcoordy, 1000, 200);



                } else {
                    g.drawImage(map, 20 + crewmate.coordx, 40 + crewmate.coordy + countcoordy, null);
                    if (bomb1planted == true){
                        System.out.println("bombx" + bombx1);
                        //g.setColor(Color.green);
                        //g.fillRect(760 + bombx1,420 + bomby1,20,20);
                        g.drawImage(proximitymines,760 + bombx1, 420 + bomby1,null);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb2planted == true){
                        System.out.println("bombx2" + bombx2);
                        //g.setColor(Color.green);
                        //g.fillRect(760 + bombx2,420 + bomby2,20,20);
                        g.drawImage(proximitymines,760 + bombx2, 420 + bomby2,null);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb3planted == true){
                        System.out.println("bombx3" + bombx3);
                        //g.setColor(Color.green);
                        //g.fillRect(760 + bombx3,420 + bomby3,20,20);
                        g.drawImage(proximitymines,760 + bombx3, 420 + bomby3,null);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    Random random = new Random();
                    Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                    g.setColor(color);
                    g.fillRect(2020 + crewmate.coordx, 40 + crewmate.coordy + countcoordy, 400, 600);
                    g.fillRect(20 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 800, 400);
                    g.fillRect(20 + crewmate.coordx, 2040 + crewmate.coordy + countcoordy, 200, 1600);
                    g.fillRect(620 + crewmate.coordx, 2040 + crewmate.coordy + countcoordy, 200, 400);
                    g.fillRect(220 + crewmate.coordx, 3040 + crewmate.coordy + countcoordy, 800, 600);
                    g.fillRect(4020 + crewmate.coordx, 40 + crewmate.coordy + countcoordy, 400, 1200);
                    g.fillRect(2020 + crewmate.coordx, 1040 + crewmate.coordy + countcoordy, 400, 2600);
                    g.fillRect(1220 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 800, 800);
                    g.fillRect(2420 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 600, 600);
                    g.fillRect(1420 + crewmate.coordx, 3040 + crewmate.coordy + countcoordy, 600, 600);
                    g.fillRect(4820 + crewmate.coordx, 840 + crewmate.coordy + countcoordy, 800, 400);
                    g.fillRect(3420 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 1000, 600);
                    g.fillRect(4420 + crewmate.coordx, 1640 + crewmate.coordy + countcoordy, 2000, 400);
                    g.fillRect(4220 + crewmate.coordx, 2240 + crewmate.coordy + countcoordy, 200, 800);
                    g.fillRect(4220 + crewmate.coordx, 3440 + crewmate.coordy + countcoordy, 200, 600);
                    g.fillRect(4420 + crewmate.coordx, 2840 + crewmate.coordy + countcoordy, 800, 200);
                    g.fillRect(4820 + crewmate.coordx, 3040 + crewmate.coordy + countcoordy, 400, 400);
                    g.fillRect(6220 + crewmate.coordx, 2040 + crewmate.coordy + countcoordy, 200, 1400);
                    g.fillRect(5620 + crewmate.coordx, 2840 + crewmate.coordy + countcoordy, 600, 600);
                    g.fillRect(4420 + crewmate.coordx, 3840 + crewmate.coordy + countcoordy, 3600, 200);
                    g.fillRect(6020 + crewmate.coordx, 840 + crewmate.coordy + countcoordy, 1600, 400);
                    g.fillRect(7220 + crewmate.coordx, 440 + crewmate.coordy + countcoordy, 400, 400);
                    g.fillRect(6820 + crewmate.coordx, 1240 + crewmate.coordy + countcoordy, 200, 1000);
                    g.fillRect(6820 + crewmate.coordx, 2640 + crewmate.coordy + countcoordy, 200, 800);
                    g.fillRect(7020 + crewmate.coordx, 3240 + crewmate.coordy + countcoordy, 1000, 200);

                }
                g.setColor(Color.red);
                //g.fillRect((getWidth() - 31) / 2, (getHeight() - 31) / 2, 31, 31);
                g.drawImage(miner,(getWidth()-51)/2,(getHeight()-26)/2,null);
                g.setColor(Color.red);
                for(int i=0;i<10;i++){
                    if (i!=number-1){
                        //g.fillRect(760 - crewx[i] + crewmate.coordx,420 - crewy[i] + crewmate.coordy + countcoordy,31,31);
                        g.drawImage(miner,760 - crewx[i] + crewmate.coordx,420 - crewy[i] + crewmate.coordy + countcoordy,null);
                    }
                }
                for(int i=0;claimers.size()>i;i++){

                    if (claimers.get(i).mineid!=number){
                        for (int j=0;j<10;j++){
                            System.out.println("eeeeeeeeeeeeeeeeeeeee" + crewx[j]);
                            if (j!=number-1){
                                if ((claimers.get(i).x>=crewmate.coordx)&&(claimers.get(i).x<=crewmate.coordx+103)&&(claimers.get(i).y>=crewmate.coordy+countcoordy)&&(claimers.get(i).y<=crewmate.coordy + countcoordy+53)){
                                    postman.sendMessage("Dead " + number);
                                    System.exit(i);
                                }
                            }
                        }


                    }
                }
                for (int i = 0; i < bullets.size(); i++) {
                    if (bullets.get(i).id==number) {

                        if ((Math.abs(bullets.get(i).bulletx) - Math.abs(bullets.get(i).gotox) < 1 && Math.abs(bullets.get(i).bulletx) - Math.abs(bullets.get(i).gotox) > -1) && (Math.abs(bullets.get(i).bullety) - Math.abs(bullets.get(i).gotoy) < 1 && Math.abs(bullets.get(i).bullety) - Math.abs(bullets.get(i).gotoy) > -1)) {

                            System.out.println("123456789");
                            postman.sendMessage("Remove " + i);
                        } else {
                            bullets.get(i).bulletx += (bullets.get(i).gotox - bullets.get(i).bulletx) / 15;
                            bullets.get(i).bullety += (bullets.get(i).gotoy - bullets.get(i).bullety) / 15;
                            g.setColor(Color.red);
                            int k1 = (int) (getWidth() / 2 - 11 + bullets.get(i).bulletx + countcoordx);
                            int k2 = (int) (getHeight() / 2 + 15 + bullets.get(i).bullety + countcoordy);
                            g.fillOval(k1, k2, 10, 10);
                        }
                        for (int j = 0; j < 10; j++) {
                            if (j != number - 1) {
                                g.setColor(Color.red);
                                //g.drawRect(760 - crewx[j] + crewmate.coordx, 420 - crewy[j] + crewmate.coordy + countcoordy, 103, 53);
                                int a1 = (int) (getWidth() / 2 - 11 + bullets.get(i).bulletx + countcoordx);
                                int a2 = (int) (getHeight() / 2 + 15 + bullets.get(i).bullety + countcoordy);
                                //System.out.println(760 - crewx[j] + crewmate.coordx + "икс");
                                //System.out.println(a1);
                                //System.out.println(420 - crewy[j] + crewmate.coordy + countcoordy + "игрик");
                                //System.out.println(a2);
                                if ((770 - crewx[j] + crewmate.coordx< a1) && (770 - crewx[j] + crewmate.coordx> a1 - 113) && (453 - crewy[j] + crewmate.coordy + countcoordy < a2) && (453 - crewy[j] + crewmate.coordy + countcoordy > a2 - 63)) {
                                    postman.sendMessage("Deadb " + number);

                                    System.out.println("DEEEEEEEEEEEEEEEEEEEEEEEEAD");
                                }
                            }
                        }


                    }

                }

                break;
            case UP:

                this.crewmate.coordy += countcoordy;
                //System.out.println(cy);
                g.drawImage(back, -7, 0, null);


                if ((crewmate.coordy + 80 - 13 < (getHeight() - 31) / 2)) {
                    //System.out.println(direction);

                    g.setColor(Color.red);
                    g.drawImage(map, 20 + crewmate.coordx + countcoordx, 40 + crewmate.coordy, null);
                    if ((bombs==1)&&(bomb1planted==false)){
                        g.setColor(Color.green);
                        g.fillRect(760 + bombx1,420 + bomby1,20,20);
                        bomb1planted = true;
                        postman.sendMessage("Bomb1 " + number + " " + countcoordx + " " + countcoordy);

                    }
                    if ((bombs==2)&&(bomb2planted==false)){
                        g.setColor(Color.green);
                        g.fillRect(760 + bombx2,420 + bomby2,20,20);
                        bomb2planted = true;
                        postman.sendMessage("Bomb2 " + number + " " + countcoordx + " " + countcoordy);

                    }
                    if ((bombs==3)&&(bomb3planted==false)){
                        g.setColor(Color.green);
                        g.fillRect(760 + bombx3,420 + bomby3,20,20);
                        bomb3planted = true;
                        postman.sendMessage("Bomb2 " + number + " " + countcoordx + " " + countcoordy);

                    }
                    if (bomb1planted == true){
                        System.out.println("bomby" + bomby1);
                        //g.setColor(Color.green);
                        g.drawImage(proximitymines,760 + bombx1, 420 + bomby1,null);
                        //g.fillRect(760 + bombx1,420 + bomby1,20,20);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb2planted == true){
                        System.out.println("bomby" + bomby2);
                        //g.setColor(Color.green);
                        g.drawImage(proximitymines,760 + bombx2, 420 + bomby2,null);
                        //g.fillRect(760 + bombx2,420 + bomby2,20,20);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb3planted == true){
                        System.out.println("bomby" + bomby3);
                        //g.setColor(Color.green);
                        g.drawImage(proximitymines,760 + bombx3, 420 + bomby3,null);
                        //g.fillRect(760 + bombx3,420 + bomby3,20,20);
                        //System.exit(5);
                        //bombplanted = false;
                    }

                    Random random = new Random();
                    Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                    g.setColor(color);
                    for (int i = 0; i < 15; i++) {
                        if ((crewmate.x + cx + 50  > rekt.get(i).rectx) && (crewmate.x + cx + 50  < (rekt.get(i).rectx + rekt.get(i).rectwid)) && (crewmate.y + cy > rekt.get(i).recty) && (crewmate.y + cy < (rekt.get(i).recty + rekt.get(i).recthei))) {
                            //System.out.println();
                            //System.exit(i);
                            countcoordy -= 15;
                            cy += 15;
                            if (bomb1planted == true) {

                                bomby1 -= 15;
                            }
                            if (bomb2planted == true) {

                                bomby2 -= 15;
                            }
                            if (bomb3planted == true) {

                                bomby3 -= 15;
                            }
                        }
                    }
                    if (bomb1planted == true) {
                        bomby1 += 15;
                    }
                    if (bomb2planted == true) {
                        bomby2 += 15;
                    }
                    if (bomb3planted == true) {
                        bomby3 += 15;
                    }
                    countcoordy += 15;
                    postman.sendMessage("Coordxu " + number + " " + countcoordy);
                    cy -= 15;
                    g.setColor(Color.red);
                    //g.drawImage(map, 20 + crewmate.coordx + countcoordx, 40 + crewmate.coordy, null);
                    g.setColor(color);
                    g.fillRect(2020 + crewmate.coordx + countcoordx, 40 + crewmate.coordy, 400, 600);
                    g.fillRect(20 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 800, 400);
                    g.fillRect(20 + crewmate.coordx + countcoordx, 2040 + crewmate.coordy, 200, 1600);
                    g.fillRect(620 + crewmate.coordx + countcoordx, 2040 + crewmate.coordy, 200, 400);
                    g.fillRect(220 + crewmate.coordx + countcoordx, 3040 + crewmate.coordy, 800, 600);
                    g.fillRect(4020 + crewmate.coordx + countcoordx, 40 + crewmate.coordy, 400, 1200);
                    g.fillRect(2020 + crewmate.coordx + countcoordx, 1040 + crewmate.coordy, 400, 2600);
                    g.fillRect(1220 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 800, 800);
                    g.fillRect(2420 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 600, 600);
                    g.fillRect(1420 + crewmate.coordx + countcoordx, 3040 + crewmate.coordy, 600, 600);
                    g.fillRect(4820 + crewmate.coordx + countcoordx, 840 + crewmate.coordy, 800, 400);
                    g.fillRect(3420 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 1000, 600);
                    g.fillRect(4420 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 2000, 400);
                    g.fillRect(4220 + crewmate.coordx + countcoordx, 2240 + crewmate.coordy, 200, 800);
                    g.fillRect(4220 + crewmate.coordx + countcoordx, 3440 + crewmate.coordy, 200, 600);
                    g.fillRect(4420 + crewmate.coordx + countcoordx, 2840 + crewmate.coordy, 800, 200);
                    g.fillRect(4820 + crewmate.coordx + countcoordx, 3040 + crewmate.coordy, 400, 400);
                    g.fillRect(6220 + crewmate.coordx + countcoordx, 2040 + crewmate.coordy, 200, 1400);
                    g.fillRect(5620 + crewmate.coordx + countcoordx, 2840 + crewmate.coordy, 600, 600);
                    g.fillRect(4420 + crewmate.coordx + countcoordx, 3840 + crewmate.coordy, 3600, 200);
                    g.fillRect(6020 + crewmate.coordx + countcoordx, 840 + crewmate.coordy, 1600, 400);
                    g.fillRect(7220 + crewmate.coordx + countcoordx, 440 + crewmate.coordy, 400, 400);
                    g.fillRect(6820 + crewmate.coordx + countcoordx, 1240 + crewmate.coordy, 200, 1000);
                    g.fillRect(6820 + crewmate.coordx + countcoordx, 2640 + crewmate.coordy, 200, 800);
                    g.fillRect(7020 + crewmate.coordx + countcoordx, 3240 + crewmate.coordy, 1000, 200);



                } else {
                    g.drawImage(map, 20 + crewmate.coordx + countcoordx, 40 + crewmate.coordy, null);
                    if (bomb1planted == true){
                        System.out.println("bomby" + bomby1);
                        //g.setColor(Color.green);
                        //g.fillRect(760 + bombx1,420 + bomby1,20,20);
                        g.drawImage(proximitymines,760 + bombx1, 420 + bomby1,null);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb2planted == true){
                        System.out.println("bomby" + bomby2);
                        //g.setColor(Color.green);
                        //g.fillRect(760 + bombx2,420 + bomby2,20,20);
                        g.drawImage(proximitymines,760 + bombx2, 420 + bomby2,null);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb3planted == true){
                        System.out.println("bomby" + bomby3);
                        //g.setColor(Color.green);
                        //g.fillRect(760 + bombx3,420 + bomby3,20,20);
                        g.drawImage(proximitymines,760 + bombx3, 420 + bomby3,null);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    Random random = new Random();
                    Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                    g.setColor(color);
                    g.fillRect(2020 + crewmate.coordx + countcoordx, 40 + crewmate.coordy, 400, 600);
                    g.fillRect(20 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 800, 400);
                    g.fillRect(20 + crewmate.coordx + countcoordx, 2040 + crewmate.coordy, 200, 1600);
                    g.fillRect(620 + crewmate.coordx + countcoordx, 2040 + crewmate.coordy, 200, 400);
                    g.fillRect(220 + crewmate.coordx + countcoordx, 3040 + crewmate.coordy, 800, 600);
                    g.fillRect(4020 + crewmate.coordx + countcoordx, 40 + crewmate.coordy, 400, 1200);
                    g.fillRect(2020 + crewmate.coordx + countcoordx, 1040 + crewmate.coordy, 400, 2600);
                    g.fillRect(1220 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 800, 800);
                    g.fillRect(2420 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 600, 600);
                    g.fillRect(1420 + crewmate.coordx + countcoordx, 3040 + crewmate.coordy, 600, 600);
                    g.fillRect(4820 + crewmate.coordx + countcoordx, 840 + crewmate.coordy, 800, 400);
                    g.fillRect(3420 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 1000, 600);
                    g.fillRect(4420 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 2000, 400);
                    g.fillRect(4220 + crewmate.coordx + countcoordx, 2240 + crewmate.coordy, 200, 800);
                    g.fillRect(4220 + crewmate.coordx + countcoordx, 3440 + crewmate.coordy, 200, 600);
                    g.fillRect(4420 + crewmate.coordx + countcoordx, 2840 + crewmate.coordy, 800, 200);
                    g.fillRect(4820 + crewmate.coordx + countcoordx, 3040 + crewmate.coordy, 400, 400);
                    g.fillRect(6220 + crewmate.coordx + countcoordx, 2040 + crewmate.coordy, 200, 1400);
                    g.fillRect(5620 + crewmate.coordx + countcoordx, 2840 + crewmate.coordy, 600, 600);
                    g.fillRect(4420 + crewmate.coordx + countcoordx, 3840 + crewmate.coordy, 3600, 200);
                    g.fillRect(6020 + crewmate.coordx + countcoordx, 840 + crewmate.coordy, 1600, 400);
                    g.fillRect(7220 + crewmate.coordx + countcoordx, 440 + crewmate.coordy, 400, 400);
                    g.fillRect(6820 + crewmate.coordx + countcoordx, 1240 + crewmate.coordy, 200, 1000);
                    g.fillRect(6820 + crewmate.coordx + countcoordx, 2640 + crewmate.coordy, 200, 800);
                    g.fillRect(7020 + crewmate.coordx + countcoordx, 3240 + crewmate.coordy, 1000, 200);

                }
                g.setColor(Color.red);
                //g.fillRect((getWidth() - 31) / 2, (getHeight() - 31) / 2, 31, 31);
                g.drawImage(miner,(getWidth()-51)/2,(getHeight()-26)/2,null);
                g.setColor(Color.red);
                for(int i=0;i<10;i++){
                    if (i!=number-1){
                        //g.fillRect(760 - crewx[i] + crewmate.coordx + countcoordx,420 - crewy[i] + crewmate.coordy,31,31);
                        g.drawImage(miner,760 - crewx[i] + crewmate.coordx + countcoordx,420 - crewy[i] + crewmate.coordy,null);
                    }
                }
                for(int i=0;claimers.size()>i;i++){

                    if (claimers.get(i).mineid!=number){
                        for (int j=0;j<10;j++){
                            System.out.println("eeeeeeeeeeeeeeeeeeeee" + crewx[j]);
                            if (j!=number-1){
                                if ((claimers.get(i).x>=crewmate.coordx + countcoordx)&&(claimers.get(i).x<=crewmate.coordx + countcoordx+103)&&(claimers.get(i).y>=crewmate.coordy)&&(claimers.get(i).y<=crewmate.coordy +53)){
                                    postman.sendMessage("Dead " + number);
                                    System.exit(i);
                                }
                            }
                        }


                    }
                }
                for (int i = 0; i < bullets.size(); i++) {
                    if (bullets.get(i).id==number) {

                        if ((Math.abs(bullets.get(i).bulletx) - Math.abs(bullets.get(i).gotox) < 1 && Math.abs(bullets.get(i).bulletx) - Math.abs(bullets.get(i).gotox) > -1) && (Math.abs(bullets.get(i).bullety) - Math.abs(bullets.get(i).gotoy) < 1 && Math.abs(bullets.get(i).bullety) - Math.abs(bullets.get(i).gotoy) > -1)) {

                            System.out.println("123456789");
                            postman.sendMessage("Remove " + i);
                        } else {
                            bullets.get(i).bulletx += (bullets.get(i).gotox - bullets.get(i).bulletx) / 15;
                            bullets.get(i).bullety += (bullets.get(i).gotoy - bullets.get(i).bullety) / 15;
                            g.setColor(Color.red);
                            int k1 = (int) (getWidth() / 2 - 11 + bullets.get(i).bulletx + countcoordx);
                            int k2 = (int) (getHeight() / 2 + 15 + bullets.get(i).bullety + countcoordy);
                            g.fillOval(k1, k2, 10, 10);
                        }
                        for (int j = 0; j < 10; j++) {
                            if (j != number - 1) {
                                g.setColor(Color.red);
                                //g.drawRect(760 - crewx[j] + crewmate.coordx + countcoordx, 420 - crewy[j] + crewmate.coordy , 103, 53);
                                int a1 = (int) (getWidth() / 2 - 11 + bullets.get(i).bulletx + countcoordx);
                                int a2 = (int) (getHeight() / 2 + 15 + bullets.get(i).bullety + countcoordy);
                                //System.out.println(760 - crewx[j] + crewmate.coordx + "икс");
                                //System.out.println(a1);
                                //System.out.println(420 - crewy[j] + crewmate.coordy + countcoordy + "игрик");
                                //System.out.println(a2);
                                if ((770 - crewx[j] + crewmate.coordx  + countcoordx< a1) && (770 - crewx[j] + crewmate.coordx + countcoordx> a1 - 113) && (453 - crewy[j] + crewmate.coordy< a2) && (453 - crewy[j] + crewmate.coordy> a2 - 63)) {
                                    postman.sendMessage("Deadb " + number);

                                    System.out.println("DEEEEEEEEEEEEEEEEEEEEEEEEAD");
                                }
                            }
                        }


                    }

                }


                break;
            case DOWN:

                this.crewmate.coordy += countcoordy;

                g.drawImage(back, -7, 0, null);
                postman.sendMessage("Coordxd " + number + " " + countcoordy);
                if (((crewmate.coordy + 3980 - 43 > (getHeight() - 31) / 2))) {
                    //System.out.println(direction);
                    g.setColor(Color.red);
                    g.drawImage(map, 20 + crewmate.coordx + countcoordx, 40 + crewmate.coordy, null);
                    if ((bombs==1)&&(bomb1planted==false)){
                        g.setColor(Color.green);
                        g.fillRect(760 + bombx1,420 + bomby1,20,20);
                        bomb1planted = true;
                        postman.sendMessage("Bomb1 " + number + " " + countcoordx + " " + countcoordy);

                    }
                    if ((bombs==2)&&(bomb2planted==false)){
                        g.setColor(Color.green);
                        g.fillRect(760 + bombx2,420 + bomby2,20,20);
                        bomb2planted = true;
                        postman.sendMessage("Bomb2 " + number + " " + countcoordx + " " + countcoordy);

                    }
                    if ((bombs==3)&&(bomb3planted==false)){
                        g.setColor(Color.green);
                        g.fillRect(760 + bombx3,420 + bomby3,20,20);
                        bomb3planted = true;
                        postman.sendMessage("Bomb2 " + number + " " + countcoordx + " " + countcoordy);

                    }
                    if (bomb1planted == true){
                        System.out.println("bomby" + bomby1);
                        //g.setColor(Color.green);
                        //g.fillRect(760 + bombx1,420 + bomby1,20,20);
                        g.drawImage(proximitymines,760 + bombx1, 420 + bomby1,null);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb2planted == true){
                        System.out.println("bomby" + bomby2);
                        //g.setColor(Color.green);
                        //g.fillRect(760 + bombx2,420 + bomby2,20,20);
                        g.drawImage(proximitymines,760 + bombx2, 420 + bomby2,null);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb3planted == true){
                        System.out.println("bomby" + bomby3);
                        //g.setColor(Color.green);
                        //g.fillRect(760 + bombx3,420 + bomby3,20,20);
                        g.drawImage(proximitymines,760 + bombx3, 420 + bomby3,null);
                        //System.exit(5);
                        //bombplanted = false;
                    }

                    Random random = new Random();
                    Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                    g.setColor(color);
                    for (int i = 0; i < 15; i++) {
                        if ((crewmate.x + cx + 15  > rekt.get(i).rectx) && (crewmate.x + cx + 25  < (rekt.get(i).rectx + rekt.get(i).rectwid)) && (crewmate.y + cy + 25 + 63 > rekt.get(i).recty) && (crewmate.y + cy + 25 + 63 < (rekt.get(i).recty + rekt.get(i).recthei))) {
                            //System.exit(i);
                            countcoordy += 15;
                            cy -= 15;
                            if (bomb1planted == true) {

                                bomby1 += 15;
                            }
                            if (bomb2planted == true) {

                                bomby2 += 15;
                            }
                            if (bomb3planted == true) {

                                bomby3 += 15;
                            }
                        }
                    }
                    if (bomb1planted == true) {
                        bomby1 -= 15;
                    }
                    if (bomb2planted == true) {
                        bomby2 -= 15;
                    }
                    if (bomb3planted == true) {
                        bomby3 -= 15;
                    }
                    countcoordy -= 15;
                    postman.sendMessage("Coordxd " + number + " " + countcoordy);
                    cy += 15;
                    g.setColor(Color.red);
                    //s
                    //g.drawImage(map, 20 + crewmate.coordx + countcoordx, 40 + crewmate.coordy, null);
                    g.setColor(color);
                    g.fillRect(2020 + crewmate.coordx + countcoordx, 40 + crewmate.coordy, 400, 600);
                    g.fillRect(20 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 800, 400);
                    g.fillRect(20 + crewmate.coordx + countcoordx, 2040 + crewmate.coordy, 200, 1600);
                    g.fillRect(620 + crewmate.coordx + countcoordx, 2040 + crewmate.coordy, 200, 400);
                    g.fillRect(220 + crewmate.coordx + countcoordx, 3040 + crewmate.coordy, 800, 600);
                    g.fillRect(4020 + crewmate.coordx + countcoordx, 40 + crewmate.coordy, 400, 1200);
                    g.fillRect(2020 + crewmate.coordx + countcoordx, 1040 + crewmate.coordy, 400, 2600);
                    g.fillRect(1220 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 800, 800);
                    g.fillRect(2420 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 600, 600);
                    g.fillRect(1420 + crewmate.coordx + countcoordx, 3040 + crewmate.coordy, 600, 600);
                    g.fillRect(4820 + crewmate.coordx + countcoordx, 840 + crewmate.coordy, 800, 400);
                    g.fillRect(3420 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 1000, 600);
                    g.fillRect(4420 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 2000, 400);
                    g.fillRect(4220 + crewmate.coordx + countcoordx, 2240 + crewmate.coordy, 200, 800);
                    g.fillRect(4220 + crewmate.coordx + countcoordx, 3440 + crewmate.coordy, 200, 600);
                    g.fillRect(4420 + crewmate.coordx + countcoordx, 2840 + crewmate.coordy, 800, 200);
                    g.fillRect(4820 + crewmate.coordx + countcoordx, 3040 + crewmate.coordy, 400, 400);
                    g.fillRect(6220 + crewmate.coordx + countcoordx, 2040 + crewmate.coordy, 200, 1400);
                    g.fillRect(5620 + crewmate.coordx + countcoordx, 2840 + crewmate.coordy, 600, 600);
                    g.fillRect(4420 + crewmate.coordx + countcoordx, 3840 + crewmate.coordy, 3600, 200);
                    g.fillRect(6020 + crewmate.coordx + countcoordx, 840 + crewmate.coordy, 1600, 400);
                    g.fillRect(7220 + crewmate.coordx + countcoordx, 440 + crewmate.coordy, 400, 400);
                    g.fillRect(6820 + crewmate.coordx + countcoordx, 1240 + crewmate.coordy, 200, 1000);
                    g.fillRect(6820 + crewmate.coordx + countcoordx, 2640 + crewmate.coordy, 200, 800);
                    g.fillRect(7020 + crewmate.coordx + countcoordx, 3240 + crewmate.coordy, 1000, 200);



                } else {
                    g.drawImage(map, 20 + crewmate.coordx + countcoordx, 40 + crewmate.coordy, null);
                    if (bomb1planted == true){
                        System.out.println("bomby" + bomby1);
                        //g.setColor(Color.green);
                        //g.fillRect(760 + bombx1,420 + bomby1,20,20);
                        g.drawImage(proximitymines,760 + bombx1, 420 + bomby1,null);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb2planted == true){
                        System.out.println("bomby" + bomby2);
                        //g.setColor(Color.green);
                        //g.fillRect(760 + bombx2,420 + bomby2,20,20);
                        g.drawImage(proximitymines,760 + bombx2, 420 + bomby2,null);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    if (bomb3planted == true){
                        System.out.println("bomby" + bomby3);
                        //g.setColor(Color.green);
                        //g.fillRect(760 + bombx3,420 + bomby3,20,20);
                        g.drawImage(proximitymines,760 + bombx3, 420 + bomby3,null);
                        //System.exit(5);
                        //bombplanted = false;
                    }
                    Random random = new Random();
                    Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                    g.setColor(color);
                    g.fillRect(2020 + crewmate.coordx + countcoordx, 40 + crewmate.coordy, 400, 600);
                    g.fillRect(20 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 800, 400);
                    g.fillRect(20 + crewmate.coordx + countcoordx, 2040 + crewmate.coordy, 200, 1600);
                    g.fillRect(620 + crewmate.coordx + countcoordx, 2040 + crewmate.coordy, 200, 400);
                    g.fillRect(220 + crewmate.coordx + countcoordx, 3040 + crewmate.coordy, 800, 600);
                    g.fillRect(4020 + crewmate.coordx + countcoordx, 40 + crewmate.coordy, 400, 1200);
                    g.fillRect(2020 + crewmate.coordx + countcoordx, 1040 + crewmate.coordy, 400, 2600);
                    g.fillRect(1220 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 800, 800);
                    g.fillRect(2420 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 600, 600);
                    g.fillRect(1420 + crewmate.coordx + countcoordx, 3040 + crewmate.coordy, 600, 600);
                    g.fillRect(4820 + crewmate.coordx + countcoordx, 840 + crewmate.coordy, 800, 400);
                    g.fillRect(3420 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 1000, 600);
                    g.fillRect(4420 + crewmate.coordx + countcoordx, 1640 + crewmate.coordy, 2000, 400);
                    g.fillRect(4220 + crewmate.coordx + countcoordx, 2240 + crewmate.coordy, 200, 800);
                    g.fillRect(4220 + crewmate.coordx + countcoordx, 3440 + crewmate.coordy, 200, 600);
                    g.fillRect(4420 + crewmate.coordx + countcoordx, 2840 + crewmate.coordy, 800, 200);
                    g.fillRect(4820 + crewmate.coordx + countcoordx, 3040 + crewmate.coordy, 400, 400);
                    g.fillRect(6220 + crewmate.coordx + countcoordx, 2040 + crewmate.coordy, 200, 1400);
                    g.fillRect(5620 + crewmate.coordx + countcoordx, 2840 + crewmate.coordy, 600, 600);
                    g.fillRect(4420 + crewmate.coordx + countcoordx, 3840 + crewmate.coordy, 3600, 200);
                    g.fillRect(6020 + crewmate.coordx + countcoordx, 840 + crewmate.coordy, 1600, 400);
                    g.fillRect(7220 + crewmate.coordx + countcoordx, 440 + crewmate.coordy, 400, 400);
                    g.fillRect(6820 + crewmate.coordx + countcoordx, 1240 + crewmate.coordy, 200, 1000);
                    g.fillRect(6820 + crewmate.coordx + countcoordx, 2640 + crewmate.coordy, 200, 800);
                    g.fillRect(7020 + crewmate.coordx + countcoordx, 3240 + crewmate.coordy, 1000, 200);

                }
                g.setColor(Color.red);
                //g.fillRect((getWidth() - 31) / 2, (getHeight() - 31) / 2, 31, 31);
                g.drawImage(miner,(getWidth()-51)/2,(getHeight()-26)/2,null);
                g.setColor(Color.red);
                for(int i=0;i<10;i++){
                    if (i!=number-1){
                        //g.fillRect(760 - crewx[i] + crewmate.coordx + countcoordx,420 - crewy[i] + crewmate.coordy,31,31);
                        g.drawImage(miner,760 - crewx[i] + crewmate.coordx + countcoordx,420 - crewy[i] + crewmate.coordy,null);
                    }
                }
                for(int i=0;claimers.size()>i;i++){

                    if (claimers.get(i).mineid!=number){
                        for (int j=0;j<10;j++){
                            System.out.println("eeeeeeeeeeeeeeeeeeeee" + crewx[j]);
                            if (j!=number-1){
                                if ((claimers.get(i).x>=crewmate.coordx + countcoordx)&&(claimers.get(i).x<=crewmate.coordx + countcoordx+103)&&(claimers.get(i).y>=crewmate.coordy)&&(claimers.get(i).y<=crewmate.coordy +53)){
                                    postman.sendMessage("Dead " + number);
                                    System.exit(i);
                                }
                            }
                        }


                    }
                }
                for (int i = 0; i < bullets.size(); i++) {
                    if (bullets.get(i).id==number) {

                        if ((Math.abs(bullets.get(i).bulletx) - Math.abs(bullets.get(i).gotox) < 1 && Math.abs(bullets.get(i).bulletx) - Math.abs(bullets.get(i).gotox) > -1) && (Math.abs(bullets.get(i).bullety) - Math.abs(bullets.get(i).gotoy) < 1 && Math.abs(bullets.get(i).bullety) - Math.abs(bullets.get(i).gotoy) > -1)) {

                            System.out.println("123456789");
                            postman.sendMessage("Remove " + i);
                        } else {
                            bullets.get(i).bulletx += (bullets.get(i).gotox - bullets.get(i).bulletx) / 15;
                            bullets.get(i).bullety += (bullets.get(i).gotoy - bullets.get(i).bullety) / 15;
                            g.setColor(Color.red);
                            int k1 = (int) (getWidth() / 2 - 11 + bullets.get(i).bulletx + countcoordx);
                            int k2 = (int) (getHeight() / 2 + 15 + bullets.get(i).bullety + countcoordy);
                            g.fillOval(k1, k2, 10, 10);
                        }
                        for (int j = 0; j < 10; j++) {
                            if (j != number - 1) {
                                g.setColor(Color.red);
                                //g.drawRect(760 - crewx[j] + crewmate.coordx + countcoordx, 420 - crewy[j] + crewmate.coordy , 103, 53);
                                int a1 = (int) (getWidth() / 2 - 11 + bullets.get(i).bulletx + countcoordx);
                                int a2 = (int) (getHeight() / 2 + 15 + bullets.get(i).bullety + countcoordy);
                                //System.out.println(760 - crewx[j] + crewmate.coordx + "икс");
                                //System.out.println(a1);
                                //System.out.println(420 - crewy[j] + crewmate.coordy + countcoordy + "игрик");
                                //System.out.println(a2);
                                if ((770 - crewx[j] + crewmate.coordx  + countcoordx< a1) && (770 - crewx[j] + crewmate.coordx + countcoordx> a1 - 113) && (453 - crewy[j] + crewmate.coordy< a2) && (453 - crewy[j] + crewmate.coordy> a2 - 63)) {
                                    postman.sendMessage("Deadb " + number);

                                    System.out.println("DEEEEEEEEEEEEEEEEEEEEEEEEAD");
                                }
                            }
                        }


                    }

                }


                break;
        }
        g.dispose();
        bufferStrategy.show();


    }
    public void setDirection(Direction direction){
        this.direction = direction;
    }
    public void setPostman(StreamWorker p) {
        postman = p;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if ((e.getX()>=getWidth()/2)&&(e.getY()<=getHeight()/2)) {
            a=-countcoordx;
            b=-countcoordy;
            c=-countcoordx + e.getX() - getWidth() / 2;
            d=-countcoordy + e.getY() - getHeight() / 2;
            postman.sendMessage("Bullet " + a + " " + b + " " + c + " " + d + " " + number);
        } else if((e.getX()<getWidth()/2)&&(e.getY()<getHeight()/2)){
            a=-countcoordx;
            b=-countcoordy;
            c=-countcoordx + e.getX() - getWidth() / 2;
            d=-countcoordy + e.getY() - getHeight() / 2;
            postman.sendMessage("Bullet " + a + " " + b + " " + c + " " + d + " " + number);

        } else if ((e.getX()<=getWidth()/2)&&(e.getY()>=getHeight()/2)){
            a=-countcoordx;
            b=-countcoordy;
            c=-countcoordx + e.getX() - getWidth() / 2;
            d=-countcoordy + e.getY() - getHeight() / 2;
            postman.sendMessage("Bullet " + a + " " + b + " " + c + " " + d + " " + number);

        } else if ((e.getX()>getWidth()/2)&&(e.getY()>getHeight()/2)){
            a=-countcoordx;
            b=-countcoordy;
            c=-countcoordx + e.getX() - getWidth() / 2;
            d=-countcoordy + e.getY() - getHeight() / 2;
            postman.sendMessage("Bullet " + a + " " + b + " " + c + " " + d + " " + number);

        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
//I like beer
