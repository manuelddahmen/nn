package one.empty3.neunet;

import one.empty3.library.Point2D;
import one.empty3.library.core.testing.Resolution;

import java.awt.*;

public class FeatureDescriptor {
    private double [][] fd;

    public FeatureDescriptor(int resX, int resY) {
        fd = new double[resX][resY];

    }

    public double[][] getFd() {
        return fd;
    }

    public void setFd(double[][] fd) {
        this.fd = fd;
    }

    public double match(Layer layer) {
        double score = 0.0;
        int wd = fd.length/3;
        int hd = fd[0].length/3;
        int wi = layer.getSizeX();
        int hi = layer.getSizeY();

        Resolution dimD = new Resolution(wd, hd);
        Resolution dimI = new Resolution(wi, hi);
        Point2D min = new Point2D(0,0);
        Point2D max = new Point2D(0,0);

        double incrX, incrY;
        if(wd<=wi && hd<=hi) { // Feature descriptor size <<< sample size
            if(wd>hd) {
                min.x = 1.0;
                min.y = 1.0/dimI.x()*dimI.y();
                max.x = dimI.x();
                max.y = dimI.y();

                incrX = 1.0/dimI.x();
                incrY = 1.0/dimI.x();
            } else {
                min.x = 1.0/dimI.y()*dimI.x();
                min.y = 1.0;
                max.x = dimI.x();
                max.y = dimI.y();

                incrX = 1.0/dimI.y();
                incrY = 1.0/dimI.y();
            }
        } else {
            return -1;
        }
        double xRes=0,yRes=0;
        double xCurr=0,yCurr=0;
        while(xRes< max.x&&yRes<max.y) {
            for(xCurr=0; xCurr<=layer.getSizeX()-fd.length; xCurr+=1) {
                for(yCurr=0; yCurr<=layer.getSizeY()-fd[0].length; yCurr+=1) {
                    Rectangle rectangle = new Rectangle((int)(xCurr), (int)(yCurr),
                            layer.getSizeX(), layer.getSizeY());

                    // Match feature of size rectangle.wh in rectangle
                    // According to colors variations.
                    // Tenir en compte les composantes rgb.??

                    //Point3D color1 = layer.getPixel(xCurr, yCurr);
                    //Point3D colorDescription1 = new Rectangle(i)

                }

            }
        }
        return score;
    }
}
