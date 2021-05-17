

import java.awt.*;

public class Crewmate {
    int x;
    int y;
    int coordx = 0;
    int coordy = 0;
    public Crewmate(Frame frame){
        this.coordx = 0;
        this.x = 760;
        this.coordy = 0;
        this.y = 420;
    }
    public Crewmate(int x,int y,int coordx,int coordy){
        this.coordx = coordx;
        this.x = x;
        this.coordy = coordy;
        this.y = y;

    }
    public Crewmate(){

    }

}
