package one.empty3.neunet;

public class HiddenLayer extends Layer{
    private Dimension dimensionZ;

    public HiddenLayer(int sizeX, int sizeY) {
        super(sizeX, sizeY);
    }

    /***
     * Brut calculus
     * @param dw
     * @return
     */
    public double[] gradient(double dw) {
        double h = error();
        double[] g = new double[getW().length];
        for(int i=0; i<getW().length; i++) {
            double[] wa = getW().clone();
            wa[i] = getW()[i]+dw;
            double a = error(wa);
            g[i] = (a-h)/dw;
        }
        return g;
    }

}
