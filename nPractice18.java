package bot;

public class nPractice18 extends AbstractNeuralNetwork{
    //takes 2 inputs and decides which is greater
    public nPractice18(){
        super.setVariables();
        super.createWeightsAndBiases();
        createInputData();
        inputs.forEach(i -> {
            layers[0] = i;
            createTarget();
            forwardPropagation();
            //findErrorTotal(0);
            backPropagation();
            printInfo();
            updateWeightsAndBiases();
        });
    }
    
    public void createTarget(){
        target = new double[2];
        if(layers[0][0] > layers[0][1]){target[0] = 1; target[1] = 0;}
        else{target[0] = 0; target[1] = 1;}
    }
    
    public void createInputData(){          //vary inputs more to see if still works
        for(int i = 0; i < 100000; i++){
            double[] input = new double[2];
            input[0] = rand.nextInt(90);
            input[1] = rand.nextInt(90);
            while(input[1] == input[0]){
                input[1] = rand.nextInt(90);
            }
            inputs.add(input);
        }
    }
    
    public static void main(String[] args){
        new nPractice18();
    }
}
