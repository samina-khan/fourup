package samina.fourup;

/*
Copyright (c) 2015 Samina Khanam

This source file is licensed under the "MIT license”.
Please see the file COPYING in this distribution
for license terms.
*/
//Minimax Algorithm ideas from https://www.udacity.com/course/intro-to-artificial-intelligence--cs271
public class ArtificialIntelligence {


    static final int MAX_DEPTH = 8;
    static final float WIN_REVENUE = 1f;
    static final float LOSE_REVENUE = -1f;
    static final float UNCERTAIN_REVENUE = 0f;

    AIBoard board;

    public ArtificialIntelligence(AIBoard board) {
        this.board = board;
    }


    public int makeTurn() {
        double maxValue = 2. * Integer.MIN_VALUE;
        int move = 0;

        // Search all columns for the one that has the best value. Search is stopped when a move hits this WIN_REVENUE.
        for (int column = 0; column < board.getWidth(); column++) {
            if (board.isValidMove(column)) {

                double value = moveValue(column);
                if (value > maxValue)
                {
                    maxValue = value;
                    move = column;
                    if (value == WIN_REVENUE) {
                        break;
                    }
                }
            }
        }
        // Make the move
        System.out.println("AI: I have a move");
        board.makeMoveAI(move);
        return move;
    }

    double moveValue(int column) {
        // To determine the value of a move, first make the move,
        // estimate that state and then undo the move again.
        board.makeMoveAI(column);
        double val =alphabeta(MAX_DEPTH,Integer.MIN_VALUE,Integer.MAX_VALUE, false);
        board.undoMoveAI(column);
        return val;
    }

    double alphabeta(int depth, double alpha,double beta,boolean maximizingPlayer) {
        //System.out.println("Alphabeta: looping? maximizingPlayer:"+maximizingPlayer +" depth:"+depth);
        boolean hasWinner = board.hasWinner();

        if (depth == 0 || hasWinner) {
            double score = 0;
            if (hasWinner) {
                score = board.playerIsWinner()? LOSE_REVENUE: WIN_REVENUE;
            } else {
                score = UNCERTAIN_REVENUE;
            }

            return score/ (MAX_DEPTH - depth + 1); //Giving priority to better results in the more recent future than the distant future.
        }

        if (maximizingPlayer)
        {
            for (int column = 0; column < board.getWidth(); column++) {
                if (board.isValidMove(column)) {
                    board.makeMoveAI(column);
                    alpha =Math.max(alpha,alphabeta(depth - 1,alpha,beta,false));
                    board.undoMoveAI(column);
                    if (beta <= alpha) {
                        break;
                    }
                }
            }
            return alpha;
        }
        else
        {
            for (int column = 0; column < board.getWidth(); column++) {
                if (board.isValidMove(column))
                {
                    board.makeMovePlayer(column);
                    beta =Math.min(beta,alphabeta(depth - 1,alpha,beta,true));
                    board.undoMovePlayer(column);
                    if (beta <= alpha) {
                        break;
                    }
                }
            }
            return beta;
        }
    }
}
