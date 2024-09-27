import java.awt.*;
import edu.princeton.cs.introcs.StdDraw;

public class Flower {
    /**
     * @param x x coordinate of the center of this ellipse
     * @param y y coordinate of the center of this ellipse
     * @param halfWidth half the width of this ellipse
     * @param halfHeight half the height of this ellipse
     * @param count depth of the recursion, initial call passes 0
     */
    private static void flower(Color[] palette, double x, double y, double
            halfWidth, double halfHeight, int count){

        if(count==5){
            return;
        }

        count++;
        halfWidth/=2;
        halfHeight/=2;
        int index = (int)(Math.random()*palette.length);
        StdDraw.setPenColor(palette[index]);
        StdDraw.ellipse(x, y, halfWidth*2, halfHeight*2);
        flower(palette,x+halfWidth,y,halfWidth,halfHeight,count);
        flower(palette,x-halfWidth,y,halfWidth,halfHeight,count);
        flower(palette,x,y+halfWidth,halfWidth,halfHeight,count);
        flower(palette,x,y-halfWidth,halfWidth,halfHeight,count);
        flower(palette,x,y,halfWidth,halfHeight,count);
        }

    public class NotFlower {
        /**
         * @param x is the x-coordinate of the center of the square
         * @param y is the y-coordinate of the center of the square
         * @param halfLength one half the length of any side of the square
         * @param count depth of the recursion, initial call passes 0
         */

        private static void notFlower(Color[] palette, double x, double y, double halfLength, int count) {
            if(count==5) {
                return;
            }
            count++;
            halfLength /= 2;
            int index = (int) (Math.random() * palette.length);
            StdDraw.setPenColor(palette[index]);
            StdDraw.square(x, y, halfLength);
            notFlower(palette,x+halfLength,y,halfLength,count);
            notFlower(palette,x-halfLength,y,halfLength,count);
            notFlower(palette,x,y+halfLength,halfLength,count);
            notFlower(palette,x,y-halfLength,halfLength,count);
            notFlower(palette,x,y,halfLength,count);
        }
    }


    public static void main(String args[]) {
        Color[] palette = {StdDraw.BLUE, StdDraw.GREEN, StdDraw.RED, StdDraw.BLACK};
        flower(palette, .5, .5, .6, .6, 0);
        NotFlower.notFlower(palette, .5, .5, .6, 0);
    }
}

