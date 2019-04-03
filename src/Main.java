public class Main {


    public static void main(String[] args) {
        Neuron neuron = new Neuron(4);
        neuron.calculate(1,0,1,1);
        System.out.println(neuron.stepFunction());
    }
}
