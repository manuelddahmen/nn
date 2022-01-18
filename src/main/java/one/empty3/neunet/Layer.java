package one.empty3.neunet;

public class Layer implements Comparable{
    private Net network;
    private int sizeX;
    private int sizeY;
    private double [] w;
    protected double [] input;
    protected double [] output;
    public Layer(int sizeX) {
        this.sizeX = sizeX;
        w = new double[sizeX];
        input = new double[sizeX];
        output = new double[sizeX];
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public double[] getW() {
        return w;
    }

    public void setW(double[] w) {
        this.w = w;
    }

    public double[] getInput() {
        return input;
    }

    public void setInput(double[] input) {
        this.input = input;
    }

    public double[] getOutput() {
        return output;
    }

    public void setOutput(double[] output) {
        this.output = output;
    }

    public double function() {
        return dot(input, w);
    }

    private double dot(double[] inputs, double[] w) {
        double res = 0.0;
        for (int i = 0; i < w.length; i++) {
            res += inputs[i]*w[i];
        }
        return res;
    }

    /***
     * Not implemented yet
     * @return
     */
    public double error() {
        double e = 0.0;
        for(int i=0; i<w.length; i++) {
            e = e + Math.pow(output[i]-input[i]*w[i], 2);

        }
        return e;
    }
    /***
     * Not implemented yet
     * @return
     */
    public void updateW() {
        double e = error();
        double w1 = 0.0, w2 = 0.0;
        for(int i=0; i<w.length; i++) {
            w[i] = w[i] + e*(function()-network.getPredictedResult().getOutputValues())*input[i];
        }
        return ;
    }

    public double sigmoid(double [] x, double [] w) {
        double z = dot(x, w);
        return 1. / (1. + Math.exp(-z));
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Layer && o.getClass().equals(getClass())) {
            Layer o1 = (Layer) o;
            if(o1.w.equals(w))
                return 0;
        }
        return -1;
    }
}
