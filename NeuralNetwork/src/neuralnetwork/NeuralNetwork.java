package neuralnetwork;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @version 2017.0
 * @author Adilkhan
 */
public class NeuralNetwork{
    
    // батырмалар
    JButton blackBtn, redBtn, clearBtn, identificationBtn;
    JButton numberBtn[] = new JButton[10];
    // класстар объектілерін жасау
    final DrawArea drawArea = new DrawArea();
    final Conversion conversion = new Conversion();
    final Layer layer = new Layer(); 
   
    private int Symbol = 0;
    
    // графикалық интерфейс элементтері
    private JFrame frame = new JFrame("Нейрожелі версия 17.0");
    private Container content = frame.getContentPane();
    private JPanel digits = new JPanel();
    private JLabel digit = new JLabel();
    private Font font = new Font("Verdana", Font.PLAIN, 150); 
   
    ActionListener actionListener = new ActionListener(){
        
        // батырмаларды өңдеу
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == clearBtn){
                drawArea.clear();
            } else if(e.getSource()== blackBtn){
                drawArea.black();
            } else if(e.getSource() == redBtn){
                drawArea.red();
            } else if(e.getSource() == identificationBtn){
                drawArea.write();
                conversion.rgb();
                conversion.pruning();
                conversion.newImage();
                conversion.rgbNewImage();
                conversion.write();
                layer.createNeuron();
                layer.max();
                layer.detection();
                Symbol = layer.getA();
                digit.setText(Integer.toString(Symbol));
            } else if(e.getSource() == numberBtn[0]){
                for(int i = 0; i < 1000; i++){
                    layer.zero.learning();
                }
                layer.zero.writeWeight();
            } else if(e.getSource() == numberBtn[1]){
                for(int i = 0; i < 1000; i++){
                    layer.one.learning();
                }
                layer.one.writeWeight();
            } else if(e.getSource() == numberBtn[2]){
                for(int i = 0; i < 1000; i++){
                    layer.two.learning();
                }
                layer.two.writeWeight();
            } else if(e.getSource() == numberBtn[3]){
                for(int i = 0; i < 1000; i++){
                    layer.three.learning();
                }
                layer.three.writeWeight();
            } else if(e.getSource() == numberBtn[4]){
                for(int i = 0; i < 1000; i++){
                    layer.four.learning();
                }
                layer.four.writeWeight();
            } else if(e.getSource() == numberBtn[5]){
                for(int i = 0; i < 1000; i++){
                    layer.five.learning();
                }
                layer.five.writeWeight();
            } else if(e.getSource() == numberBtn[6]){
                for(int i = 0; i < 1000; i++){
                    layer.six.learning();
                }
                layer.six.writeWeight();
            } else if(e.getSource() == numberBtn[7]){
                for(int i = 0; i < 1000; i++){
                    layer.seven.learning();
                }
                layer.seven.writeWeight();
            } else if(e.getSource() == numberBtn[8]){
                for(int i = 0; i < 1000; i++){
                    layer.eight.learning();
                }
                layer.eight.writeWeight();
            } else if(e.getSource() == numberBtn[9]){
                for(int i = 0; i < 1000; i++){
                    layer.nine.learning();
                }
                layer.nine.writeWeight();
            }
        }
    };
    public void show(){
        
        // Layout орнату
        content.setLayout(new GridLayout(2,2));
        digits.setLayout(new GridLayout());
        // content pane-ге қосу
        content.add(drawArea);
        // түс беру
        content.setBackground(Color.DARK_GRAY);
        digits.setBackground(Color.DARK_GRAY);
        // басқару элементтерін жасау
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(4, 0));
       
        digits.setLayout(new GridLayout(5 , 2));
        // басқару элементтері аймағының түсі
        controls.setBackground(Color.DARK_GRAY);
        // шрифт қасиеттерін беру
        digit.setFont(font);
        // жазу түсі
        digit.setForeground(Color.white);
        // жазуды центрге шығару 
        digit.setHorizontalAlignment(JLabel.CENTER);
        
        // батырмалар
        blackBtn = new JButton("Қара");
        blackBtn.addActionListener(actionListener);
        redBtn = new JButton("Қызыл");
        redBtn.addActionListener(actionListener);
        clearBtn = new JButton("Тазалау");
        clearBtn.addActionListener(actionListener);
        identificationBtn = new JButton("Анықтау");
        identificationBtn.addActionListener(actionListener);
        for(int i = 0; i < 10; i++){
            numberBtn[i] = new JButton(i + "");
            numberBtn[i].addActionListener(actionListener);
        }
        
        
        // панельге қосу
        controls.add(blackBtn);
        controls.add(redBtn);
        controls.add(clearBtn);
        controls.add(identificationBtn);
        for(int i = 0; i < 10; i++){
            digits.add(numberBtn[i]);
        }
        
        // content pane-ге қосу 
        content.add(controls);
        content.add(digits);
        content.add(digit);
        
        frame.setSize(600, 600);
        // терезені жабуға
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // көріну үшің
        frame.setVisible(true);     
    }

        public static void main(String[] args){
        NeuralNetwork network = new  NeuralNetwork();
        network.show();
    }    
};