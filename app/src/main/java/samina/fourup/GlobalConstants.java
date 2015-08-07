/*
Copyright (c) 2015 Samina Khanam

This source file is licensed under the "MIT license”.
Please see the file COPYING in this distribution
for license terms.
*/

package samina.fourup;


public interface GlobalConstants {
    public static final int GCPlayAI = 1;
    public static final int GCPlayPass = 2;
    public static final int GCPlayOnline = 3;

    public static final int GCRed = 0;
    public static final int GCYellow = 1;
    public static final int GCBlack = 2;


    public static final int standardNumRows = 6;
    public static final int standardNumCols = 7;
    public static final int numDisksToWin = 4;

    public static final int maxMatches = 3;

    public static final int KeepGoing = -1;
    public static final int RedWins = 0;
    public static final int YellowWins = 1;
    public static final int Tied = 2;

    public static final float WIN_REVENUE = 1f;
    public static final float LOSE_REVENUE = -1f;
    public static final float UNCERTAIN_REVENUE = 0f;
    public static final int MAX_DEPTH = 8;



}
