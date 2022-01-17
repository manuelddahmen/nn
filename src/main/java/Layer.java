public class Layer {
    private int sizeX;
    private int sizeY;
    private double [] w;
    private double [] input;
    private double [] output;
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

    public double function(double [] inputs, int i) {
        return dot(inputs, w);
    }

    private double dot(double[] inputs, double[] w) {
        double res = 0.0;
        for (int i = 0; i < w.length; i++) {
            res += inputs[i]*w[i];
        }
        return res;
    }

}
