/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
/**
 *
 * @author EMRE
 */
public class Masalar implements ActionListener{
    
    
    
    JFrame jfmasalar;
    JPanel jpmasalar;
    
    JButton BMasa1;
    JButton BMasa2;
    JButton BMasa3;
    JButton BMasa4;
    JButton geriDon;


    public Masalar(){
       
        getJfmasalar().add(getJpmasalar());
        
        getJfmasalar().setVisible(true);
        getJpmasalar().add(getBMasa1());
        getJpmasalar().add(getBMasa2());
        getJpmasalar().add(getBMasa3());
        getJpmasalar().add(getBMasa4());
        getJpmasalar().add(getgeriDon());

    }
    
    Font font1 = new Font("Footlight MT Light", Font.BOLD, 35);
    Font font2 = new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 20);
    Font font3 = new Font("Arial", Font.BOLD, 15);
    Font font4 = new Font("Arial", Font.BOLD, 30);
    Font font5 = new Font("Arial", Font.BOLD, 30);
      
    public JFrame getJfmasalar() {
        if (jfmasalar == null) {
            jfmasalar = new JFrame("MASALAR");
            jfmasalar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jfmasalar.setBounds(300, 50, 800, 300);
            
        }
        return jfmasalar;
    }

    public void setJfmasalar(JFrame jfmasalar) {
        this.jfmasalar = jfmasalar;
    }

     public JPanel getJpmasalar() {
        if (jpmasalar == null) {
            jpmasalar = new JPanel();
            jpmasalar.setLayout(null);
            jpmasalar.setBackground(Color.WHITE);
           

        }
        return jpmasalar;
    }

    public void setJpmasalar(JPanel jpmasalar) {
        this.jpmasalar = jpmasalar;
    }

    //masa-1
    
    public  Masa1 getMf1() {
        Masa1 mf1=new Masa1();
        return mf1;
    }  
       
 public JButton getBMasa1() {
        if (BMasa1 == null) {
            BMasa1 = new JButton();
            BMasa1.setBounds(50, 50, 150, 150);
            //BMasa1.setBackground(Color.red);
            BMasa1.setBorder(null);
            BMasa1.setForeground(Color.white);
            BMasa1.setFont(font2);
            BMasa1.setHorizontalTextPosition(SwingConstants.CENTER);
            BMasa1.setVerticalTextPosition(SwingConstants.CENTER);
            BMasa1.setIcon(new ImageIcon("src\\gui\\masa1.png"));
            
            BMasa1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

            jfmasalar.setVisible(false);

            BMasa1.addActionListener(getMf1());

		   }
               
		});            
    }      
        return BMasa1;

     }
    public void setBMasa1(JButton BMasa1) {
        this.BMasa1 = BMasa1;
    }
    
    
    
    //masa-1 bitiş...
    
    //masa-2
    
         public  Masa2 getMasa22() {
        Masa2 mf2=new Masa2();
        return mf2;
    }  
 public JButton getBMasa2() {
        if (BMasa2 == null) {
            BMasa2 = new JButton();
            BMasa2.setBounds(225, 50, 150, 150);
            BMasa2.setBackground(Color.red);
            BMasa2.setBorder(null);
            BMasa2.setForeground(Color.white);
            BMasa2.setFont(font2);
            BMasa2.setHorizontalTextPosition(SwingConstants.CENTER);
            BMasa2.setVerticalTextPosition(SwingConstants.CENTER);
            BMasa2.setIcon(new ImageIcon("src\\gui\\MASA2.png"));
            BMasa2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

            jfmasalar.setVisible(false);

            BMasa2.addActionListener(getMasa22());

		   }
               
		});            
    }      
        return BMasa2;

     }
    public void setBMasa2(JButton BMasa2) {
        this.BMasa2 = BMasa2;
    }
    
    
    
    //masa-2 bitiş...
    
    
    
    //masa-3
    
       public  Masa3 getMasa33() {
        Masa3 mf3=new Masa3();
        return mf3;
    }   
 public JButton getBMasa3() {
        if (BMasa3 == null) {
            BMasa3 = new JButton();
            BMasa3.setBounds(400, 50, 150, 150);
            BMasa3.setBackground(Color.red);
            BMasa3.setBorder(null);
            BMasa3.setForeground(Color.white);
            BMasa3.setFont(font2);
            BMasa3.setHorizontalTextPosition(SwingConstants.CENTER);
            BMasa3.setVerticalTextPosition(SwingConstants.CENTER);            
            BMasa3.setIcon(new ImageIcon("src\\gui\\MASA3.png"));
            BMasa3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

            jfmasalar.setVisible(false);

            BMasa3.addActionListener(getMasa33());

		   }
               
		});            
    }      
        return BMasa3;

     }
    public void setBMasa3(JButton BMasa3) {
        this.BMasa3 = BMasa3;
    }
    
    
    
    //masa-3 bitiş...
    
    
    //masa-4
    
          public  Masa4 getMasa44() {
        Masa4 mf4=new Masa4();
        return mf4;
    }  
 public JButton getBMasa4() {
        if (BMasa4 == null) {
            BMasa4 = new JButton();
            BMasa4.setBounds(575, 50, 150, 150);
            BMasa4.setBackground(Color.red);
            BMasa4.setBorder(null);
            BMasa4.setForeground(Color.white);
            BMasa4.setFont(font2);
            BMasa4.setIcon(new ImageIcon("src\\gui\\MASA4.png"));
            BMasa4.setHorizontalTextPosition(SwingConstants.CENTER);
            BMasa4.setVerticalTextPosition(SwingConstants.CENTER);            
           BMasa4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

            jfmasalar.setVisible(false);

            BMasa4.addActionListener(getMasa44());

		   }
               
		});              
    }      
        return BMasa4;

     }
    public void setBMasa4(JButton BMasa4) {
        this.BMasa4 = BMasa4;
    }
    
    
    
    //masa-3 bitiş...
            public  AnaEkran getAna() {
        AnaEkran ana=new AnaEkran();
        return ana;
    }  
       
     public JButton getgeriDon() {
        if (geriDon == null) {
            geriDon = new JButton();
            geriDon.setBounds(575, 220, 150, 30);
            geriDon.setBackground(Color.red);
            geriDon.setBorder(null);
            geriDon.setHorizontalTextPosition(SwingConstants.CENTER);
            geriDon.setVerticalTextPosition(SwingConstants.CENTER);
            geriDon.setIcon(new ImageIcon("src\\gui\\geridon.png"));
            geriDon.setForeground(Color.white);
            geriDon.setFont(font2);
            geriDon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


             geriDon.addActionListener(getAna());
             jfmasalar.setVisible(false);

		   }
               
		});            
    }      
        
        
        return geriDon;
    }

    public void setgeriDon(JButton geriDon) {
        this.geriDon = geriDon;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {

    }
    
}
