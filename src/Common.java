public enum Messages
{
    WAIT_FOR_P2,    //server to client
    GIVE_MY_NAME,   //client to server, followed by a string of that player's name
    GIVE_OPP_NAME,  //server to each client, followed by a string of the opponent's name
    GAME_START,     //server to client, followed by a variable number of integers representing the piles, terminated with a 0, as piles can't have 0
    YOUR_TURN,      //server to client
    OPP_THINKING,   //server to client
    MAKE_MOVE,      //client to server, followed by 3 integers
    MOVE_MADE,      //server to client, followed by a variable number of integers representing the piles, terminated with a 0, as piles can't have 0
    MOVE_REJECTED,  //along with a message
    NEW_GAME,       //client to server
                    //then also server to client, followed by a variable number of integers representing the piles, terminated with a 0, as piles can't have 0
    QUIT,           //client to server
                    //and then also server to client

    
}
