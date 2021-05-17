import java.awt.event.KeyEvent;

public class KeyEventDispatcher implements java.awt.KeyEventDispatcher {

    Frame frame;
    Direction direction;

    KeyEventDispatcher(Frame frame){
        this.frame = frame;
        direction = Direction.RIGHT;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {

        if ((e.getKeyCode() == KeyEvent.VK_W) && (e.getID() == KeyEvent.KEY_PRESSED )) {
            direction = Direction.UP;

        } else if ((e.getKeyCode() == KeyEvent.VK_S) && (e.getID() == KeyEvent.KEY_PRESSED)){

            direction = Direction.DOWN;

        } else if ((e.getKeyCode() == KeyEvent.VK_A) && (e.getID() == KeyEvent.KEY_PRESSED)) {

            direction = Direction.LEFT;

        } else if ((e.getKeyCode() == KeyEvent.VK_D) && (e.getID() == KeyEvent.KEY_PRESSED)) {

            direction = Direction.RIGHT;

        } else if ((e.getKeyCode() == KeyEvent.VK_E) && (e.getID() == KeyEvent.KEY_PRESSED)) {
            if (frame.bombs<7) {
                frame.bombs += 1;
            }
        }
        frame.setDirection(direction);
        return false;
    }
}

