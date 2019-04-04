import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Neuron {

    private List<Double>weight;
    private double weightedSum;

    Neuron(int size) {
        weight = new LinkedList<>();
        Random generator = new Random();
        for (int i=0; i<size; i++){
            weight.add(i,generator.nextDouble());
        }
    }
    void calculate(int... entry){
        weightedSum = 0;
        for(int i=0; i<weight.size(); i++){
            weightedSum+=weight.get(i)*entry[i];
        }

    }
    int stepFunction(){
        //  System.out.println(weight);
        if(weightedSum>=0.7)
            return 1;
        return 0;
    }
    void learn(int[]x0, int[]x1, int[] answer, double learningCoefficient ){
        Random generatorIndex = new Random();
        for(int i=0; i<50000; i++){
            int index = generatorIndex.nextInt(x0.length);
            calculate(x0[index],x1[index]);
            double newWeightX0 = weight.get(0)+x0[index]*(answer[index]-stepFunction())*learningCoefficient;
            double newWeightX1 = weight.get(1)+x1[index]*(answer[index]-stepFunction())*learningCoefficient;
            weight.set(0, newWeightX0);
            weight.set(1,newWeightX1);
        }
    }

}
