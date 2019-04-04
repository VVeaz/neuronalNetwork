public class Main {


    public static void main(String[] args) {
        Neuron neuron = new Neuron(2); //random weight
        int [] learningPacketX0 = {1,0,0,1};
        int [] learningPacketX1 = {1,1,0,0};
        int [] answerPacketAND = {1,0,0,0};
        int [] answerPacketOR = {1,1,0,1};
        double coefficient = 0.01;
        System.out.println("Weights before learn and: "+neuron.getWeight());
        neuron.calculate(1,1);
        System.out.println("1 and 1 = "+neuron.stepFunction());


        neuron.calculate(1,0);
        System.out.println("1 and 0 = "+neuron.stepFunction());

        neuron.calculate(0,1);
        System.out.println("0 and 1 = "+neuron.stepFunction());

        neuron.calculate(0,0);
        System.out.println("0 and 0 = "+neuron.stepFunction());

        neuron.learn(learningPacketX0,learningPacketX1,answerPacketAND,coefficient);


        System.out.println("Weights after learn and: "+neuron.getWeight());
        neuron.calculate(1,1);
        System.out.println("1 and 1 = "+neuron.stepFunction());


        neuron.calculate(1,0);
        System.out.println("1 and 0 = "+neuron.stepFunction());

        neuron.calculate(0,1);
        System.out.println("0 and 1 = "+neuron.stepFunction());

        neuron.calculate(0,0);
        System.out.println("0 and 0 = "+neuron.stepFunction());
        //------
        neuron.generateRandomWeights(2);
        System.out.println("Weights before learn or: "+neuron.getWeight());
        neuron.calculate(1,1);
        System.out.println("1 or 1 = "+neuron.stepFunction());


        neuron.calculate(1,0);
        System.out.println("1 or 0 = "+neuron.stepFunction());

        neuron.calculate(0,1);
        System.out.println("0 or 1 = "+neuron.stepFunction());

        neuron.calculate(0,0);
        System.out.println("0 or 0 = "+neuron.stepFunction());

        neuron.learn(learningPacketX0,learningPacketX1,answerPacketOR,coefficient);


        System.out.println("Weights after learn or: "+neuron.getWeight());
        neuron.calculate(1,1);
        System.out.println("1 or 1 = "+neuron.stepFunction());


        neuron.calculate(1,0);
        System.out.println("1 or 0 = "+neuron.stepFunction());

        neuron.calculate(0,1);
        System.out.println("0 or 1 = "+neuron.stepFunction());

        neuron.calculate(0,0);
        System.out.println("0 or 0 = "+neuron.stepFunction());
    }
}
