import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Server extends MessageListener{
    ArrayList<Mines> claimers = new ArrayList<Mines>();
    ArrayList<Bullets> bullets = new ArrayList<Bullets>();
    public int[] coordx = new int[10];
    public int[] coordy = new int[10];
    public int useless=0;

    public int number=1;
    ArrayList<StreamWorker> postmans = new ArrayList<>();
    ArrayList<String> textsOfServer = new ArrayList<>();

    public Server(){

    }
    public void run() throws IOException {

        for (int i=0;i<10;i++){
            coordx[i] = 0;
            coordy[i] = 0;
        }
        ServerSocket server = new ServerSocket(420);

        while (true) {
            Socket client = server.accept();
            StreamWorker postman = new StreamWorker(client.getInputStream(), client.getOutputStream());
            postman.addListener(this);
            postman.sendMessage("Welcome, this Server for you");
            postman.sendMessage("ID "+ number);
            number+=1;
            for (int i = 0; i < textsOfServer.size(); i = i + 1){
                postman.sendMessage(textsOfServer.get(i));
            }
            postman.start();
            postmans.add(postman);


        }
    }
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.run();
    }
    @Override
    public void onMessage(String text) throws IOException {
        textsOfServer.add(text);
        StringTokenizer tokenizer = new StringTokenizer(text);
        String token0 = tokenizer.nextToken();
        if (token0.equals("Coordxr")){
            String token1 = tokenizer.nextToken();
            String token2 = tokenizer.nextToken();

            coordx[Integer.parseInt(token1)-1] = Integer.parseInt(token2);
        }
        if (token0.equals("Coordxl")){
            String token1 = tokenizer.nextToken();
            String token2 = tokenizer.nextToken();

            coordx[Integer.parseInt(token1)-1] = Integer.parseInt(token2);
        }
        if (token0.equals("Coordxu")){
            String token1 = tokenizer.nextToken();
            String token2 = tokenizer.nextToken();

            coordy[Integer.parseInt(token1)-1] = Integer.parseInt(token2);
        }
        if (token0.equals("Coordxd")){
            String token1 = tokenizer.nextToken();
            String token2 = tokenizer.nextToken();

            coordy[Integer.parseInt(token1)-1] = Integer.parseInt(token2);
        }
        if (token0.equals("Bomb")) {
            String token1 = tokenizer.nextToken();
            String token2 = tokenizer.nextToken();
            String token3 = tokenizer.nextToken();

            claimers.add(new Mines(Integer.parseInt(token1),Integer.parseInt(token2),Integer.parseInt(token3)));


        }
        if (token0.equals("Bullet")) {
            String token1 = tokenizer.nextToken();
            String token2 = tokenizer.nextToken();
            String token3 = tokenizer.nextToken();
            String token4 = tokenizer.nextToken();
            String token5 = tokenizer.nextToken();
            System.out.println(token1);
            bullets.add(new Bullets(Double.parseDouble(token1),Double.parseDouble(token2),Integer.parseInt(token3),Integer.parseInt(token4),Integer.parseInt(token5)));
        }
        if (token0.equals("Remove")) {
            String token1 = tokenizer.nextToken();
            bullets.remove(Integer.parseInt(token1));
        }
        if (token0.equals("Dead")) {
            String token1 = tokenizer.nextToken();
            coordx[Integer.parseInt(token1)-1] = 0;
            coordy[Integer.parseInt(token1)-1] = 0;
        }
        if (token0.equals("Deadb")){
            String token1 = tokenizer.nextToken();
            useless+=Integer.parseInt(token1);
        }


        for (int i = 0; i < postmans.size(); i++) {
            StreamWorker postman1 = postmans.get(i);
            postman1.sendMessage(text);
        }
        System.out.println(text);
    }

    @Override
    public void onDisconnect() {
        coordx[number-1] = 0;
        coordy[number-1] = 0;
        number = number - 1;

        System.out.println("Livnul");
    }
}
