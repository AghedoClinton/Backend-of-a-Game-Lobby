package upei.cs;

import upei.cs.algs4.MaxPQ;
import upei.cs.algs4.MinPQ;


/**
 * Class to track the two middle players:
 * 1. the lowest ranked player (best) amoung the half of players that are highest ranked (worst)
 *  (best of the worst)
 *
 * 2. the highest ranked player (worst) amoung the half of players that are lowest ranked (best)
 *  (worst of the best)
 *
 *  Remember if there is an odd number of players then the median player is considered to
 *  be the worst of the best.
 *
 *  Remember: low rankings are good, high rankings are bad.
 *
 *  DO NOT alter the method headers for the public constructor,
 *  nor put or bestOfTheWorst or worstOfTheBest methods
 *
 *  Unit-testing relies on their exact method header matching their original state
 *
 */
public class BubbleTracker {
    //initialize Min and Max Priority Queues data structure
     MaxPQ<Player> bestPlayers=new MaxPQ<Player>();
     MinPQ<Player> worstPlayers=new MinPQ<Player>();

    /**
     * Public Constructor Don't change this
     */
    public BubbleTracker() {

    }

    /**
     * Put a player with name and rank into the data structure
     * requires the player.name and player.rank are distinct
     * @param player the player being inserted into the data structure
     */
    public void put(Player player){
        if (bestPlayers.size() == 0){//if there are no players
            bestPlayers.insert(player);
        }
        else {
            bestPlayers.insert(player); // insert in MaxPQ

            if((bestPlayers.size()+worstPlayers.size()) % 2 == 0){ //after inserting, check if size is even
                Player max=bestPlayers.delMax(); // remove player from maxPQ
                worstPlayers.insert(max);// store the player in minPQ
            }
            else {
                if(bestPlayers.max().rank() > worstPlayers.min().rank()) { //if the new players rank is worse than the root of the worsePlayer PQ
                    Player tempMax=bestPlayers.delMax();//store the value in temp
                    Player tempMin=worstPlayers.delMin();
                    //swap the values from both roots
                    bestPlayers.insert(tempMin);
                    worstPlayers.insert(tempMax);
                }
            }
        }
    }

    /**
     * Return the name of the driver who has the best ranking (lowest numeric value)
     * in the bottom half of all drivers.
     *
     * In the case of an odd number of drivers (>=3) this will return the ranking immediately worse (higher value)
     * than the median value. In the case of 1 driver only, that driver will be returned.
     *
     * Recall that the best possible ranking is 1 and higher numbers translate into worse rankings
     *
     * @return the best ranking player (lowest numeric score) in the bottom 50\% of player or empty string in the case their
     * is no such player
     */
    public String bestOfTheWorst(){
        if(bestPlayers.size() == 1 && worstPlayers.isEmpty()){ // if there is just one player
            return "";
        }
        else if(worstPlayers.isEmpty()){// if the minPQ is empty return empty string
            return "";
        }
        else {
            return worstPlayers.min().name(); // return players name
        }

    }

    /**
     * Return the name of the player who has the poorest ranking (largest numerical ranking number)
     * in the top half of all players.
     *
     * In the case there are an odd number of players
     * this will return the exact median unless there is only one driver
     * in which case this returns empty string.
     *
     * Recall the top ranked player possible has ranking 1
     * @return the worst ranking player in the top 50\% of players or empty string if
     * no such driver exists
     */
    public String worstOfTheBest() {
        if(bestPlayers.isEmpty()){ // if maxPQ is empty return empty string
            return "";
        }
        else {
            return bestPlayers.max().name(); // return players name
        }

    }
}
