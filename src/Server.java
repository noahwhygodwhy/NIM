import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class Server
{

    private static void badArgs()
    {
        System.err.println("Usage: java NimServer hostname port-number [true] [pile1 [pile2 ...]]");
        System.exit(-1);
    }

    public static void main(String[] args) throws IOException
    {
        ArrayList<Integer> defaultPiles = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));

        Game ga = new Game(defaultPiles);
        System.out.println(ga);
        try
        {
            ga.takeFrom(3, 1, 3);
        }
        catch(MoveException e)
        {
            System.out.println("e");
            System.out.println(e);
        }
        System.out.println(ga);


        System.exit(0);


        if (args.length < 2) badArgs();

        String hostname = args[0];

        int port = 0;
        try
        {
            port = Integer.parseInt(args[1]);
        }
        catch(NumberFormatException e)
        {
            badArgs();
        }
        if(port < 1024 || port > 65535)
        {
            System.err.println("Port must be between 1024 and 65535");
            badArgs();
        }
        

        boolean verbose = false;

        if (args.length > 2)
        {
            if (args[2].equals("true"))
            {
                verbose = true;
            }
        }

        //ArrayList<Integer> defaultPiles = new ArrayList<>();

        try
        {
            for(int i = verbose?3:2; i<args.length; i++)
            {
                defaultPiles.add(Integer.parseInt(args[i]));
            }
        }
        catch(NumberFormatException e)
        {
            badArgs();
        }
        if(defaultPiles.isEmpty())
        {
            defaultPiles = new ArrayList<Integer>(Arrays.asList(3, 4, 5));
        }

        ServerSocket serversocket = new ServerSocket();
        serversocket.bind (new InetSocketAddress (hostname, port));

        ArrayList<Player> players = new ArrayList<Player>();

        while(true)
        {
            /*Game g = new Game(defaultPiles);
            Socket socketUno = serversocket.accept();
            Player p1 = new Player(socketUno, g, pNum.P1);
            players.add(p1);
            p1.start();
            Socket socketDos = serversocket.accept();
            Player p2 = new Player(socketDos, g, pNum.P2);
            players.add(p2);
            p2.start();*/
        }
        //serversocket.close();
        /*do i need this
        for(Session s : sessions)
        {
            s.join();
        }*/


    }
}