package neuralnetwork;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DrawArea extends JComponent{
    // Сурет салуға арналған 
    private Image image;
    // Сурет салуға қолданылатын Graphics2D объект 
    private Graphics2D g2;
    // Тышқан координаталары
    private int currentX, currentY, oldX, oldY;
    
    
    public DrawArea(){
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter(){
            
            public void mousePressed(MouseEvent e){
                // Тышқан басулы болғанда X және Y координаталарын сақтау 
                oldX = e.getX()-15;
                oldY = e.getY()-15;
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                // қозғалғандағы X, Y координаталары
                currentX = e.getX()-15;
                currentY = e.getY()-15;
                
                if(g2 != null){
                    // Егер G2 null болмаса түзу салу
                    g2.drawLine(oldX, oldY, currentX, currentY);
                    g2.drawLine(oldX, oldY, currentX, currentY+1);
                    g2.drawLine(oldX, oldY, currentX+1, currentY);
                    g2.drawLine(oldX, oldY, currentX+1, currentY+1);
                    g2.drawLine(oldX, oldY+1, currentX, currentY);
                    g2.drawLine(oldX, oldY+1, currentX, currentY+1);
                    g2.drawLine(oldX, oldY+1, currentX+1, currentY);
                    g2.drawLine(oldX, oldY+1, currentX+1, currentY+1);
                    
                    g2.drawLine(oldX+1, oldY, currentX, currentY);
                    g2.drawLine(oldX+1, oldY, currentX, currentY+1);
                    g2.drawLine(oldX+1, oldY, currentX+1, currentY);
                    g2.drawLine(oldX+1, oldY, currentX+1, currentY+1);
                    g2.drawLine(oldX+1, oldY+1, currentX, currentY);
                    g2.drawLine(oldX+1, oldY+1, currentX, currentY+1);
                    g2.drawLine(oldX+1, oldY+1, currentX+1, currentY);
                    g2.drawLine(oldX+1, oldY+1, currentX+1, currentY+1); 
                    
                    g2.drawLine(oldX, oldY, currentX, currentY);
                    g2.drawLine(oldX, oldY, currentX, currentY+2);
                    g2.drawLine(oldX, oldY, currentX+2, currentY);
                    g2.drawLine(oldX, oldY, currentX+2, currentY+2);
                    g2.drawLine(oldX, oldY+2, currentX, currentY);
                    g2.drawLine(oldX, oldY+2, currentX, currentY+2);
                    g2.drawLine(oldX, oldY+2, currentX+2, currentY);
                    g2.drawLine(oldX, oldY+2, currentX+2, currentY+2);
                    
                    g2.drawLine(oldX+2, oldY, currentX, currentY);
                    g2.drawLine(oldX+2, oldY, currentX, currentY+2);
                    g2.drawLine(oldX+2, oldY, currentX+2, currentY);
                    g2.drawLine(oldX+2, oldY, currentX+2, currentY+2);
                    g2.drawLine(oldX+2, oldY+2, currentX, currentY);
                    g2.drawLine(oldX+2, oldY+2, currentX, currentY+2);
                    g2.drawLine(oldX+2, oldY+2, currentX+2, currentY);
                    g2.drawLine(oldX+2, oldY+2, currentX+2, currentY+2); 
                    
                    g2.drawLine(oldX, oldY, currentX, currentY);
                    g2.drawLine(oldX, oldY, currentX, currentY+3);
                    g2.drawLine(oldX, oldY, currentX+3, currentY);
                    g2.drawLine(oldX, oldY, currentX+3, currentY+3);
                    g2.drawLine(oldX, oldY+3, currentX, currentY);
                    g2.drawLine(oldX, oldY+3, currentX, currentY+3);
                    g2.drawLine(oldX, oldY+3, currentX+3, currentY);
                    g2.drawLine(oldX, oldY+3, currentX+3, currentY+3);
                    
                    g2.drawLine(oldX+3, oldY, currentX, currentY);
                    g2.drawLine(oldX+3, oldY, currentX, currentY+3);
                    g2.drawLine(oldX+3, oldY, currentX+3, currentY);
                    g2.drawLine(oldX+3, oldY, currentX+3, currentY+3);
                    g2.drawLine(oldX+3, oldY+3, currentX, currentY);
                    g2.drawLine(oldX+3, oldY+3, currentX, currentY+3);
                    g2.drawLine(oldX+3, oldY+3, currentX+3, currentY);
                    g2.drawLine(oldX+3, oldY+3, currentX+3, currentY+3); 
                    
                    g2.drawLine(oldX, oldY, currentX, currentY);
                    g2.drawLine(oldX, oldY, currentX, currentY+4);
                    g2.drawLine(oldX, oldY, currentX+4, currentY);
                    g2.drawLine(oldX, oldY, currentX+4, currentY+4);
                    g2.drawLine(oldX, oldY+4, currentX, currentY);
                    g2.drawLine(oldX, oldY+4, currentX, currentY+4);
                    g2.drawLine(oldX, oldY+4, currentX+4, currentY);
                    g2.drawLine(oldX, oldY+4, currentX+4, currentY+4);
                    
                    g2.drawLine(oldX+4, oldY, currentX, currentY);
                    g2.drawLine(oldX+4, oldY, currentX, currentY+4);
                    g2.drawLine(oldX+4, oldY, currentX+4, currentY);
                    g2.drawLine(oldX+4, oldY, currentX+4, currentY+4);
                    g2.drawLine(oldX+4, oldY+4, currentX, currentY);
                    g2.drawLine(oldX+4, oldY+4, currentX, currentY+4);
                    g2.drawLine(oldX+4, oldY+4, currentX+4, currentY);
                    g2.drawLine(oldX+4, oldY+4, currentX+4, currentY+4); 
                    
                    
                    // Жаңарту қайта бояу
                    repaint();
                    // X және Y ағымдағы координаталарын oldX, oldY сақтау
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });
    }
    
    protected void paintComponent(Graphics g){
        if(image == null){
            // image null болса 250 х 250 кескін жасау
            image = createImage(250, 250);
            g2 = (Graphics2D) image.getGraphics();
            // тегістеуді қосу
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // тазалау
            clear();
        }     
        g.drawImage(image, 15, 15, null);
    }
    
    public void clear(){
        g2.setPaint(Color.white);
        // барлығын ақпен бояу арқылы тазалау
        g2.fillRect( 0, 0, 250, 250);
        g2.setPaint(Color.black);
        repaint();
    }
    
    // қызыл түсті жазу үшін
    public void red(){
        g2.setPaint(Color.red);
    }
    
    // қара түс үшін
    public void black(){
        g2.setPaint(Color.black);
    }
    
    // экрандағы суретті png форматтағы файлға жазу
    public void write(){
        try { 
            BufferedImage img = new BufferedImage(96, 96,BufferedImage.TYPE_INT_RGB);
            Graphics2D g = img.createGraphics();
            // тегістеу және сапаны арттыру үшін
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g.drawImage(image, 0, 0, 96, 96, null);
            // рессурстарды босату үшін
            g.dispose();
            ImageIO.write(img, "png", new File("image.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
