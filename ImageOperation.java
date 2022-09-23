import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageOperation {
    public static void ops(int key)
    {
        JFileChooser filechoose=new JFileChooser();
        filechoose.showOpenDialog(null);
        File file = filechoose.getSelectedFile();
        //file input syream reader
        try{
            FileInputStream fl=new FileInputStream(file);
            byte[]data=new byte[fl.available()];
            fl.read(data);
            int i=0;
            for(byte b:data){
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }

            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fl.close();
            JOptionPane.showMessageDialog(null, "Done");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    
    public static void main(String[] args) {
        
        JFrame f=new JFrame();
         f.setTitle("Image Encryption");
         f.setSize(400,420);
         f.setLocationRelativeTo(null);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font =new Font("Roboto",Font.BOLD,23);
            //creating button
            JButton b=new JButton();
            b.setText("Select Image");
            b.setFont(font);
                //creating textfield
            JTextField tf=new JTextField(10);
            tf.setFont(font);

            b.addActionListener(e->{
                System.out.println("Button Clicked");
               String tx= tf.getText();
               int tmp=Integer.parseInt(tx);
               ops(tmp); 

            });

        
           
            
            f.setLayout(new FlowLayout());
            f.add(b);
            f.add(tf);
         f.setVisible(true);

    }
}
