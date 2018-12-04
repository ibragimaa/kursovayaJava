package neuralnetwork;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

//суретті нейрондарға дейін түрлендіру үшін
public class Conversion extends JComponent{
    private Image img;
    // файл аты
    private String Name = "image.png";
    // суреттің әр пикселінің сандық мәнін сақтау үшін
    private final int Massiv[][] = new int[96][96];
    // жаңа кішірейтілген суреттің сандар массиві үшін
    private final int NewMassiv[][] = new int[20][20];
    // санның солтүстік шекарасы
    private int NumberNorth = 0;
    // санның оңтүстік шекарасы
    private int NumberSouth = 0;
    // санның батыс шекарасы
    private int NumberWest = 0;
    // санның шығыс шекарасы
    private int NumberEast = 0;
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    // суретті сандар матрицасына айналдыру
    public void rgb(){
        try{
        File image = new File(getName());
        BufferedImage buff = ImageIO.read(image);
            for(int i = 0; i < buff.getWidth(); i++){
                for(int j =0; j < buff.getHeight(); j++){
                    Color c = new Color(buff.getRGB(i, j));
                    // әр пиксель RGB каналдарының мәндерін алу
                    int r = c.getRed();
                    int g = c.getGreen();
                    int b = c.getBlue();
                    // сұр градациясын алу
                    int k = (int)(0.299 * r + 0.587 * g + b * 0.114); 
                    
                    if(k < 128){
                        Massiv[j][i] = 1;
                    }
                    else{
                        Massiv[j][i] = 0;
                    }
                }
            }
        }
        catch(IOException exception){
            System.out.println("Қате: " + exception);
        }
        
    }
    
    // жаңа кішірейтілген сурет матрицасын алу
    public void rgbNewImage(){
        try{
        File image = new File("newImage.png");
        BufferedImage buff = ImageIO.read(image);
            for(int i = 0; i < buff.getWidth(); i++){
                for(int j =0; j < buff.getHeight(); j++){
                    Color c = new Color(buff.getRGB(i, j));
                     // әр пиксель RGB каналдарының мәндерін алу
                    int r = c.getRed();
                    int g = c.getGreen();
                    int b = c.getBlue();
                    // сұр градациясын алу
                    int k = (int)(0.299 * r + 0.587 * g + b * 0.114); 
                    
                    if(k == 255){
                        NewMassiv[j][i] = -1;
                    }
                    else{
                        NewMassiv[j][i] = 10;
                    }
                }
            }
        }
        catch(IOException exception){
            System.out.println("Қате: " + exception);
        }
        
    }
    
    // Енгізілген санның шеткі нүктелер координатасын анықтау үшін
    public void pruning(){ 
        for(int i = 0; i < Massiv.length; i++){
            for(int j = 0; j < Massiv.length; j++){
                if(Massiv[i][j] != 0){
                    if(NumberSouth <= 91 ){
                        NumberSouth = i + 5;
                    }
                    else{
                        NumberSouth = i;
                    }
                }
            }
        }
        for(int i = Massiv.length - 1; i > 0; i--){
            for(int j = Massiv.length - 1; j > 0; j--){
                if(Massiv[i][j] != 0){
                    if(NumberNorth >= 5 ){
                        NumberNorth = i - 4;
                    }
                    else{
                        NumberNorth = i;
                    }
                }
            }
        }
        for(int j = 0; j < Massiv.length; j++){
            for(int i = 0; i < Massiv.length; i++){
                if(Massiv[i][j] != 0){
                    if(NumberEast <= 91 ){
                        NumberEast = j + 5;
                    }
                    else{
                        NumberEast = j;
                    }
                }
            }
        }
        for(int j = Massiv.length - 1; j > 0; j--){
            for(int i = Massiv.length - 1; i > 0; i--){
                if(Massiv[i][j] != 0){
                    if(NumberWest >= 5 ){
                        NumberWest = j - 4;
                    }
                    else{
                        NumberWest = j;
                    }
                }
            }
        }
    }
    
    // жаңа кішірейтілген сурет алу
    public void newImage(){
        try{
            BufferedImage img = ImageIO.read(new File("image.png"));
            // кесу 
            img = img.getSubimage( NumberWest, NumberNorth, NumberEast-NumberWest, NumberSouth-NumberNorth);
            
            BufferedImage scaled = new BufferedImage(20, 20,
            BufferedImage.TYPE_INT_RGB);
            Graphics2D g = scaled.createGraphics();
            // сурет сапасын арттыру үшін
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g.drawImage(img, 0, 0, 20, 20, null);
            g.dispose();
 
            ImageIO.write(scaled, "png", new File("newImage.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    // жаңа массивті мәтіндік файлға жазу
    public void write(){
        try{
            FileWriter writer = new FileWriter("massiv.txt");
            for(int i = 0; i < NewMassiv.length; i++){
                for(int j = 0; j < NewMassiv.length; j++){ 
                    writer.write(NewMassiv[i][j] + " ");
                }
            }
            writer.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}

