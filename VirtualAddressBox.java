/* You will write a Java program that decomposes a virtual address into a page number and an offset within the page .
 *
 * @author (Joshua Gilliland,Ivan Nataren, Anthony Sorti, Kian Afshari)
 * @version (3/3/2019)
 */
import java.util.Scanner;
import java.lang.Math;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class VirtualAddressBox extends JFrame {
    double base = 2;    //intialize double variable, base, to 2
        double pow9 = Math.pow(base, 9); //intialize double variable to 2^9
        double pow10 = Math.pow(base, 10); //intialize double variable to 2^10
        double pow11 = Math.pow(base, 11); //intialize double variable to 2^11
        double pow12 = Math.pow(base, 12); //intialize double variable to 2^12
        double pow13 = Math.pow(base, 13); //intialize double variable to 2^13
        double pow14 = Math.pow(base, 14); //intialize double variable to 2^14
        double pow32 = Math.pow(base, 32); //intialize double variable to 2^32
        double size = 0;// variable that will hold the page size value  between 2^9 and 2^14
        
        
  
  JLabel label1 = new JLabel("Please select from the following the page size: ");
  ButtonGroup group = new ButtonGroup();
  JRadioButton option1 = new JRadioButton((int)pow9 +" (2^9)");
  JRadioButton option2 = new JRadioButton((int)pow10 +" (2^10)");  
  JRadioButton option3 = new JRadioButton((int)pow11 +" (2^11)");
  JRadioButton option4 = new JRadioButton((int)pow12 +" (2^12)");
  JRadioButton option5 = new JRadioButton((int)pow13 +" (2^13)");
  JRadioButton option6 = new JRadioButton((int)pow14 +" (2^14)");
  
  JLabel label2 = new JLabel("Please enter a virtual address, up to 4294967295 (2^32-1) ");
  JTextField address = new JTextField(12);
  float vAddress; //holds the virtual Address input
  JButton calc = new JButton("calculate");// Action button that makes the calculation of the page number and offset
  JLabel result = new JLabel(); // will display the page number and offset
  
  
  
  


   public static void main(String[] args) throws IOException {
   //creates the window
        VirtualAddressBox window = new VirtualAddressBox();
        window.setSize(400,400);
        window.setLocation(400,400);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
   public VirtualAddressBox () {
      super("Virtual Address Calculator");
      setLayout(new FlowLayout());
      add(label1);
      // button group makes sure one button is selected at a time
      group.add(option1);
      group.add(option2);
      group.add(option3);
      group.add(option4);
      group.add(option5);
      group.add(option6);
      
      add(option1);
      add(option2);
      add(option3);
      add(option4);
      add(option5);
      add(option6);
      

      add(label2);
      add(address);
      add(calc);
      add(result);
      
      
       HandlerClass handler = new HandlerClass();
     
      
      option1.addItemListener(handler);
      option2.addItemListener(handler);
      option3.addItemListener(handler);
      option4.addItemListener(handler);
      option5.addItemListener(handler);
      option6.addItemListener(handler);
      
      calc.addActionListener(handler);
      }
      public class HandlerClass implements ActionListener, ItemListener {

       public void itemStateChanged(ItemEvent e){
         Object source = e.getSource();
         int select = e.getStateChange();
         //each button changes the value of size
         if (select == ItemEvent.SELECTED)
            if (source == option1)
               size = pow9;
            else if(source == option2)
               size = pow10;    
            else if(source == option3)
               size = pow11;
            else if(source == option4)
               size = pow12;
            else if(source == option5)
               size = pow13;
            else if(source == option6)
               size = pow14;
            
        }
        
       public void actionPerformed(ActionEvent e){
         Object source = e.getSource();    
        try{
         vAddress = Float.parseFloat(address.getText());
         if(source == calc)
            if(vAddress >= 0 && vAddress <= pow32 - 1){
               result.setText(" Your Page number is: " + (int)(vAddress/size) +"  At Offset: " + (int)(vAddress%size)); //Changes the label based on the calc button
               
               }
                
            else{
               group.clearSelection();
               result.setText(" Invalid Number"); }  // catches numbers <0 or > 2^32         
               }
         
         catch(Exception i) {   //catches illegal argument inputs for vAddress
            
               result.setText(" Invalid"); }
                                                    } 
     
        
        }
}