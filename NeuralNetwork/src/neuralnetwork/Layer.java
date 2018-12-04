package neuralnetwork;

// бір қабатты желі
public class Layer { 
    // шығу сигналдары массиві
    private double arrayOutputSignals[] = new double[10];
    // максимум мәні
    private double max = 0;
    // нәтижені сақтау үшін
    private int a = 0;
    // сандар нейрондары
    Neuron one = new Neuron();
    Neuron two = new Neuron();
    Neuron three = new Neuron();
    Neuron four = new Neuron();
    Neuron five = new Neuron();
    Neuron six = new Neuron();
    Neuron seven = new Neuron();
    Neuron eight = new Neuron();
    Neuron nine = new Neuron();
    Neuron zero = new Neuron();
    
     public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
    
    // нейрондар функционалын жүзеге асыру
    public void createNeuron(){
  
            one.setName("WeightOne.txt");
            one.setFileName("WeightOne.txt");
            one.readWeight();
            one.read();
            one.linearFunction();
            one.adder();
            one.activationFunction();
  
            two.setName("WeightTwo.txt");
            two.setFileName("WeightTwo.txt");
            two.readWeight();
            two.read();
            two.linearFunction();
            two.adder();
            two.activationFunction();
            
            three.setName("WeightThree.txt");
            three.setFileName("WeightThree.txt");
            three.readWeight();
            three.read();
            three.linearFunction();
            three.adder();
            three.activationFunction();
  
            four.setName("WeightFour.txt");
            four.setFileName("WeightFour.txt");
            four.readWeight();
            four.read();
            four.linearFunction();
            four.adder();
            four.activationFunction();
            
            five.setName("WeightFive.txt");
            five.setFileName("WeightFive.txt");
            five.readWeight();
            five.read();
            five.linearFunction();
            five.adder();
            five.activationFunction();
  
            six.setName("WeightSix.txt");
            six.setFileName("WeightSix.txt");
            six.readWeight();
            six.read();
            six.linearFunction();
            six.adder();
            six.activationFunction();
            
            seven.setName("WeightSeven.txt");
            seven.setFileName("WeightSeven.txt");
            seven.readWeight();
            seven.read();
            seven.linearFunction();
            seven.adder();
            seven.activationFunction();
  
            eight.setName("WeightEight.txt");
            eight.setFileName("WeightEight.txt");
            eight.readWeight();
            eight.read();
            eight.linearFunction();
            eight.adder();
            eight.activationFunction();
  
            eight.setName("WeightEight.txt");
            eight.setFileName("WeightEight.txt");
            eight.readWeight();
            eight.read();
            eight.linearFunction();
            eight.adder();
            eight.activationFunction();
            
            nine.setName("WeightNine.txt");
            nine.setFileName("WeightNine.txt");
            nine.readWeight();
            nine.read();
            nine.linearFunction();
            nine.adder();
            nine.activationFunction();
             
            zero.setName("WeightZero.txt");
            zero.setFileName("WeightZero.txt");
            zero.readWeight();
            zero.read();
            zero.linearFunction();
            zero.adder();
            zero.activationFunction();
    }
    
    // ең үлкен шығу сигналын табу
    public void max(){
       arrayOutputSignals[0] = zero.getOutputSignal();
       arrayOutputSignals[1] = one.getOutputSignal();
       arrayOutputSignals[2] = two.getOutputSignal();
       arrayOutputSignals[3] = three.getOutputSignal();
       arrayOutputSignals[4] = four.getOutputSignal();
       arrayOutputSignals[5] = five.getOutputSignal();
       arrayOutputSignals[6] = six.getOutputSignal();
       arrayOutputSignals[7] = seven.getOutputSignal();
       arrayOutputSignals[8] = eight.getOutputSignal();
       arrayOutputSignals[9] = nine.getOutputSignal();
       max = arrayOutputSignals[0];
       
        for (int i = 0; i < 10; i++) {
            if (arrayOutputSignals[i] > max) {
                max = arrayOutputSignals[i];
            }
        }
    }
    
    // сәйкес нейрон символын анықтау
    public void detection(){
       if(max == arrayOutputSignals[0]){
            setA(0);
       } 
       else if(max == arrayOutputSignals[1]){
            setA(1);
       } 
       else if(max == arrayOutputSignals[2]){
            setA(2);
       }
       else if(max == arrayOutputSignals[3]){
            setA(3);
       }
       else if(max == arrayOutputSignals[4]){
            setA(4);
       }
       else if(max == arrayOutputSignals[5]){
            setA(5);
       }
       else if(max == arrayOutputSignals[6]){
            setA(6);
       }
       else if(max == arrayOutputSignals[7]){
            setA(7);
       }
       else if(max == arrayOutputSignals[8]){
            setA(8);
       }
       else if(max == arrayOutputSignals[9]){
            setA(9);
       }
    }
}
