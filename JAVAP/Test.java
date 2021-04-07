package JAVAP;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test extends JFrame
{
       public Test()
       {
           setLayout( new FlowLayout() );

           JButton normal = new JButton("Normal");
           add(normal);

           JButton test1 = new JButton("Test 1")
           {
               @Override
               public void paintComponent(Graphics g)
               {
                   g.setColor( Color.GREEN );
                   g.fillRect(0, 0, getSize().width, getSize().height);
                   super.paintComponent(g);
               }
           };
           test1.setContentAreaFilled(false);
           add(test1);
       }

       public static void main(String[] args)
       {
           try
           {
//          UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
           }
           catch (Exception e2) {}

           MFrame frame = new MFrame();
      //     frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
           frame.pack();
           frame.setLocationRelativeTo( null );
           frame.setVisible(true);
       }
}