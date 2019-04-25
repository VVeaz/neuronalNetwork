import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        ArrayList <Neuron> firstLayer = new ArrayList<>();
        ArrayList <Neuron> secondLayer = new ArrayList<>();
        ArrayList <Neuron> thirdLayer = new ArrayList<>();

        int numberOfNeuronsFL =3;
        int numberOfNeuronsSL =2;
        int numberOfNeuronsTL =1;
        for(int i=0; i<numberOfNeuronsFL; i++){
            firstLayer.add(new Neuron(2));
        }
        for(int i=0; i<numberOfNeuronsSL; i++){
            secondLayer.add(new Neuron(numberOfNeuronsFL));
        }
        for(int i=0; i<numberOfNeuronsTL; i++){
            thirdLayer.add(new Neuron(numberOfNeuronsSL));
        }

        Random gen =new Random();
        System.out.println("Neuronal network\n\nFirst Layer");
        for(Neuron n : firstLayer){
            System.out.println("  weights:");
            for (double w:n.getWeight()){
                System.out.println("  "+w);
            }
            n.calculate(1, 1);
            System.out.println("  ans: "+n.stepFunction());
            System.out.println("----------------");
        }

        System.out.println("----------------\nSecond Layer");
        for(Neuron n: secondLayer){
            int [] entry = new int[numberOfNeuronsFL];
            int i=0;
            for(Neuron ne: firstLayer){
                entry[i++] = ne.stepFunction();
            }

            System.out.println("    weights:");
            for (double w:n.getWeight()){
                System.out.println("    "+w);
            }
            n.calculate(entry);
            System.out.println("    ans: "+n.stepFunction());
            System.out.println("----------------");

        }
        System.out.println("----------------\nThird Layer");
        for(Neuron n: thirdLayer){
            int [] entry = new int[numberOfNeuronsSL];
            int i=0;
            for(Neuron ne: secondLayer){
                entry[i++]=ne.stepFunction();
            }
            System.out.println("      weights:");
            for (double w:n.getWeight()){
                System.out.println("      "+w);
            }
            n.calculate(entry);
            System.out.println("      ans: "+n.stepFunction());
            System.out.println("----------------");
        }
        System.out.println("\n~~~~~~~~~~~~~~~~\n~~~~~~~~~~~~~~~~\nLEARNING");
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
