

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.Segment;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Client extends MessageListener {
    public int clientnum;


    //dddddpublic Frame frame = new Frame(Direction.NULL);
    public Client() throws IOException{

    }
    Frame frame = new Frame(Direction.NULL);
    public static void main(String[] args) throws IOException, InterruptedException {


        Client client = new Client();
        client.start();


    }
    public void start() throws IOException, InterruptedException {
        //Direction direction = Direction.NULL;

        String host = "127.0.0.1";
        int port = 420;
        Socket socket = new Socket(host, port);

        StreamWorker postman = new StreamWorker(socket.getInputStream(), socket.getOutputStream());
        postman.addListener(this);
        postman.start();

        frame.setPostman(postman);
        KeyboardFocusManager keyboardManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        KeyEventDispatcher keyEventDispatcher = new KeyEventDispatcher(frame);
        keyboardManager.addKeyEventDispatcher(keyEventDispatcher);
        while(true){
            frame.repaint();
            Thread.sleep(20);
        }

    }


    @Override
    public void onMessage(String text) throws IOException {

        StringTokenizer tokenizer = new StringTokenizer(text);


        String token = tokenizer.nextToken();
        if (token.equals("ID")) {
            String number = tokenizer.nextToken();
            clientnum = Integer.parseInt(number);
            frame.number = clientnum;
            System.out.println("Your number in this Server: " + clientnum);

        }
        if (token.equals("Coordxr")){

            String token1 = tokenizer.nextToken();
            if (!token1.equals(Integer.toString(frame.number))){
                String token2 = tokenizer.nextToken();

                frame.crewx[Integer.parseInt(token1)-1] = Integer.parseInt(token2);
            }

        }
        if (token.equals("Coordxl")){

            String token1 = tokenizer.nextToken();
            if (!token1.equals(Integer.toString(frame.number))){
                String token2 = tokenizer.nextToken();

                frame.crewx[Integer.parseInt(token1)-1] = Integer.parseInt(token2);
            }
        }
        if (token.equals("Coordxu")){

            String token1 = tokenizer.nextToken();
            if (!token1.equals(Integer.toString(frame.number))){
                String token2 = tokenizer.nextToken();

                frame.crewy[Integer.parseInt(token1)-1] = Integer.parseInt(token2);
            }
        }
        if (token.equals("Coordxd")){

            String token1 = tokenizer.nextToken();
            if (!token1.equals(Integer.toString(frame.number))){
                String token2 = tokenizer.nextToken();

                frame.crewy[Integer.parseInt(token1)-1] = Integer.parseInt(token2);
            }
        }
        if (token.equals("Bomb")) {
            String token1 = tokenizer.nextToken();
            String token2 = tokenizer.nextToken();
            String token3 = tokenizer.nextToken();

            frame.claimers.add(new Mines(Integer.parseInt(token1),Integer.parseInt(token2),Integer.parseInt(token3)));


        }
        if (token.equals("Bullet")) {
            String token1 = tokenizer.nextToken();
            String token2 = tokenizer.nextToken();
            String token3 = tokenizer.nextToken();
            String token4 = tokenizer.nextToken();
            String token5 = tokenizer.nextToken();
            System.out.println(token1);
            frame.bullets.add(new Bullets(Double.parseDouble(token1),Double.parseDouble(token2),Integer.parseInt(token3),Integer.parseInt(token4),Integer.parseInt(token5)));
        }
        if (token.equals("Remove")) {
            String token1 = tokenizer.nextToken();
            frame.bullets.remove(Integer.parseInt(token1));
        }
        if (token.equals("Dead")) {
            String token1 = tokenizer.nextToken();
            frame.crewx[Integer.parseInt(token1)-1] = 0;
            frame.crewy[Integer.parseInt(token1)-1] = 0;
        }
        if (token.equals("Deadb")){
            String token1 = tokenizer.nextToken();
            if (Integer.parseInt(token1)==frame.number){
                System.exit(44);
            }
        }








    }

    @Override
    public void onDisconnect() {

    }
}
