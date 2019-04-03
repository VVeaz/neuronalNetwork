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
          System.out.println(weight);
        if(weightedSum>=0.7)
            return 1;
        return 0;
    }

}
