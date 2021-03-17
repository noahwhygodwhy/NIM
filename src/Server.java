import java.util.ArrayList;
import java.util.Arrays;

public class Server
{

    private static void badArgs()
    {
        System.err.println("Usage: java NimServer hostname port-number [true] [pile1 [pile2 ...]]");
        System.exit(-1);
    }

    public static void main(String[] args)
    {
        if (args.length < 2) badArgs();

        String hostname = args[0];
        String port = args[1];

        boolean verbose = false;

        if (args.length > 2)
        {
            if (args[2].equals("true"))
            {
                verbose = true;
            }
        }

        ArrayList<Integer> defaultPiles = new ArrayList<>();

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
            defaultPiles = new ArrayList((ArrayList<Integer>)Arrays.asList(3, 4, 5));
        }


    }
}