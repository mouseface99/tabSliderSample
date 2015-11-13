package net.miek.baseapp;

import android.graphics.Color;

/**
 * Created by Mike Wang on 2015/11/12.
 */
public class Utils {

    public static int getColor(){
        int r = (int)(Math.random()*0xff);
        int g = (int)(Math.random()*0xff);
        int b = (int)(Math.random()*0xff);

        return Color.rgb(r, g, b);
    }
}
