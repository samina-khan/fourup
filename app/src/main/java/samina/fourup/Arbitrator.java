/*
Copyright (c) 2015 Samina Khanam

This source file is licensed under the "MIT license”.
Please see the file COPYING in this distribution
for license terms.
*/

package samina.fourup;


public class Arbitrator implements GlobalConstants{
    public static int numMatches = 1;
    public static int numRedWon;
    public static int numYellowWon;

    public static int onGameEnd(int lastWinner){
        int status = KeepGoing;

        if(lastWinner == GCRed){
            numRedWon++;
        }
        else if(lastWinner == GCYellow){
            numYellowWon++;
        }

        if(numMatches == maxMatches){
            if(numRedWon > numYellowWon){
                status = RedWins;
            }
            else if(numYellowWon > numRedWon){
                status = YellowWins;
            }
            else{
                status = Tied;
            }
            reset();
        }
        else{
            numMatches++;
        }
        return status;
    }

    private static void reset() {
        numMatches = 1;
        numRedWon = 0;
        numYellowWon = 0;
    }

}
