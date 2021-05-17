public enum Direction {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0),
    NULL(0,0);

    public int dx;
    public int dy;

    Direction(int dx, int dy){
        this.dx = dx;
        this.dy = dy;
    }
}
