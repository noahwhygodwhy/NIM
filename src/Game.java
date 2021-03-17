import java.util.ArrayList;

public class Game
{
    private ArrayList<Integer> piles;

    pNum turn;
    Player p1;
    Player p2;
    public Game(ArrayList<Integer> piles)
    {
        this.turn = pNum.P1;
        this.piles = piles;
    }
    public void givePlayer(Player p) throws PlayerException
    {
        if(p.getPNum() == pNum.P1)
        {
            if(this.p1 == null)
            {
                this.p1 = p;
            }
            else
            {
                throw new PlayerException("P1 spot already filled. Something has gone terribly wrong.");
            }
        }
        else
        {
            if(this.p2 == null)
            {
                this.p2 = p;
            }
            else
            {
                throw new PlayerException("P2 spot already filled. Something has gone terribly wrong.");
            }
        }
    }
    public void takeFrom(int pileIndex, int pinIndex, int quantity) throws MoveException
    //TODO: throws an exception if you can't take that many from a pile, or if the index + quantity would overflow
    {
        if(pileIndex < 0 || pileIndex >= piles.size()) //TODO: >= or > ..? test this pls
        {
            throw new MoveException("bad pile index");
        }
        int x = piles.get(pileIndex);
        
        System.out.println("pin index: " + pinIndex);
        System.out.println("quantity: " + quantity);
        System.out.println("x is " + x);

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
            piles.set(pileIndex, x-quantity);
        }
        if(pinIndex+quantity==x)
        {
            piles.set(pileIndex, x-quantity);
        }
        else
        {
            piles.set(pileIndex, x-pinIndex+quantity);
            piles.add(pileIndex, pinIndex);
        }
        piles.set(pileIndex, piles.get(pileIndex)-quantity);
        //this.notifyAll();
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
