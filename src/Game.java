import java.util.ArrayList;

public class Game
{
    private ArrayList<Integer> piles;

    boolean playerOnesTurn;
    Player p1;
    Player p2;
    public Game(ArrayList<Integer> piles)
    {
        this.turn = true;
        this.piles = new ArrayList<Integer>(piles);
    }
    public void givePlayer(Player p) throws PlayerException
    {
        if(this.p1 == null)
        {
            this.p1 = p;
        }
        else if(this.p2 == null)
        {
            this.p2 = p;            
        }
        else
        {
            throw new PlayerException("All player spots already filled. Something has gone terribly wrong.");
        }
    }
    public synchronized void takeFrom(int pileIndex, int pinIndex, int quantity) throws MoveException
    //TODO: throws an exception if you can't take that many from a pile, or if the index + quantity would overflow
    {
        if(pileIndex < 0 || pileIndex >= piles.size()) //TODO: >= or > ..? test this pls
        {
            throw new MoveException("bad pile index");
        }
        int x = piles.get(pileIndex);
        
        if(pinIndex >= x)
        {
            throw new MoveException("pin index too high");
        }
        System.out.println("sum :" + (pinIndex + quantity ));
        if(pinIndex + quantity > x)
        {
            throw new MoveException("quantity too high");
        }

        /*
        3 cases
        index is 0, and the value is just subtracted
        pinIndex + quantity == x, and the value is just subtracted
        index > 0 and pinIndex+quantity<x , and the value is split into two values, the first being pinIndex, the second being x-(pinIndex+quantity)
        */
        if(pinIndex == 0)
        {
            if(x == quantity)
            {
                piles.remove(pileIndex);
            }
            else
            {
                piles.set(pileIndex, (x-quantity));
            }
        }
        else if(pinIndex+quantity==x)
        {
            piles.set(pileIndex, (x-quantity));
        }
        else
        {
            piles.set(pileIndex, (x-(pinIndex+quantity)));
            piles.add(pileIndex, pinIndex);
        }
        synchronized(this)
        {
            this.notifyAll();
        }
    }
    
    @Override
    public String toString()
    {
        String x = "";
        for(int i : piles)
        {
            x += i  + " ";
        }
        return x;
    }
}
