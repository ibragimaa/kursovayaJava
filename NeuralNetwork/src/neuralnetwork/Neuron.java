package neuralnetwork;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Neuron {
    // кіру сигналдары
    private int InputInformation[][] = new int [20][20];
    // сызықты функциядан кейінгі нәтижелер сақтау үшін
    private double NewInformation[][] = new double [20][20];
    // синаптикалық салмақтар
    private double Weight[][] = new double [20][20];
    private int WeightInt[][] = new int [20][20];
    // сумматор нәтижесін сақтауға
    private double Sum = 0;
    // шығу сигналы
    private double OutputSignal = 0;
    // дельта салмақ
    private double DeltaWeight = 0;
    // қателік
    private double E;
    // салмақтарды жазу файлы аты
    private String Name;
    // файл аты
    private String FileName;
    
    // геттерлар мен сеттерлар
    public String getFileName() {
        return FileName;
    }

    public void setFileName(String FileName) {
        this.FileName = FileName;
    }
    
    public int[][] getInputInformation() {
        return InputInformation;
    }
     
    public void setInputInformation(int[][] InputInformation) {
        this.InputInformation = InputInformation;
    }

    public double[][] getNewInformation() {
        return NewInformation;
    }

    public void setNewInformation(double[][] NewInformation) {
        this.NewInformation = NewInformation;
    }

    public double[][] getWeight() {
        return Weight;
    }

    public void setWeight(double[][] Weight) {
        this.Weight = Weight;
    }
    
    public double getOutputSignal() {
        return OutputSignal;
    }

    public void setOutputSignal(double OutputSignal) {
        this.OutputSignal = OutputSignal;
    }

   
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    // салмақтарды оқу
    public void readWeight(){
        try{
            File file = new File(getFileName());
            FileReader Reader = new FileReader(file);
            if(Reader.ready())
            {
                char[] chars = new char[(int)file.length()];
                Reader.read(chars);
                String s = new String(chars);
                int []inputMassiv =  Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
                Reader.close();
                int k = 0;
                Scanner newelement = new Scanner(System.in);      
                    for(int i = 0; i < getWeight().length; i++){
                        for(int j = 0; j < getWeight().length; j++){
                            getWeight()[i][j] = inputMassiv[k++];
                        }
                    }
                }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    // кіру сигналдарын оқу
    public void read(){
        try{
            File file = new File("massiv.txt");
            FileReader fileReader = new FileReader(file);
            if(fileReader.ready())
            {
                char[] chars = new char[(int)file.length()];
                fileReader.read(chars);
                String s = new String(chars);
                int[]inputMassiv =  Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
                fileReader.close();
                int k = 0;
                    for(int i = 0; i < getInputInformation().length; i++){
                        for(int j = 0; j < getInputInformation().length; j++){
                            getInputInformation()[i][j] = inputMassiv[k++];
                        }
                    }
                }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    // сызықты функция салмақтарға көбейту
    public void linearFunction(){
        for(int i = 0; i < getNewInformation().length; i ++){
            for(int j = 0; j < getNewInformation().length; j++){
                getNewInformation()[i][j] = getInputInformation()[i][j] * getWeight()[i][j];
            }
        }
    }
    
    // сумматор
    public void adder(){
        Sum = 0;
        for(int i = 0; i < getNewInformation().length; i++){
            for(int j = 0; j < getNewInformation().length; j++){
                Sum += getNewInformation()[i][j];
            }
        }
    }
    
    // гиперболоидтық тангенс активациялау функциясы
    public void activationFunction(){
        setOutputSignal(Math.tanh(0.0000005*Sum));
    }
    
    // үйрену функциясы
    public void learning(){
            for(int i = 0; i < getNewInformation().length; i++){
                for(int j = 0; j < getNewInformation().length; j++){
                    E = (0.99 - getOutputSignal());
                    DeltaWeight = 0.2 * E * getInputInformation()[i][j];
                    getWeight()[i][j] = getWeight()[i][j] + DeltaWeight;
            }
        }
    }
    
    // салмақтарды жазу
    public void writeWeight(){
        try{
            FileWriter writer = new FileWriter(getName());
            for(int i = 0; i < getWeight().length; i++){
                for(int j = 0; j < getWeight().length; j++){
                    WeightInt[i][j] = (int)Weight[i][j];
                    writer.write(WeightInt[i][j] + " ");
                }
            }
            writer.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}