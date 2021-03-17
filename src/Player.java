import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;


enum pNum
{
    P1,
    P2
}

public class Player extends Thread
{
    private String name;
    private Socket socket;
    private PrintStream out;
    private Scanner in;
    private Game game;
    private pNum pnum;
    public Player(Socket socket, Game g, pNum pnum) throws IOException
    {
        this.pnum = pnum;
        this.game = g;
        this.socket = socket;
        this.out = new PrintStream(socket.getOutputStream());
        this.in = new Scanner(socket.getInputStream());
    }

    public void close() throws IOException
    {
        this.in.close();
        this.out.close();
        this.socket.close();
    }
    public void run()
    {

    }
    public pNum getPNum()
    {
        return this.pnum;
    }
}
