public class Layer {
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
        return 0.0;
    }
    /***
     * Not implemented yet
     * @return
     */
    public double updateW() {
        double w1 = 0.0, w2 = 0.0;
        for(int i=0; i<input.length; i++) {
            w1 += input[i]*output[i];
            w2 += input[i]*input[i];
        }
        return w1/w2;
    }
}
