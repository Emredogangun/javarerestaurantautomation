/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
import Logic.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author EMRE
 */
public class AnaEkran implements ActionListener{

    public AnaEkran(){
               
        getJf().add(getJp());
        
        getJf().setVisible(true);
        
                
        getJp().add(getBMasalar());
        
        getJp().add(getHesap());

        getJp().add(getCikis());
        
        
    }

    Font font1 = new Font("Footlight MT Light", Font.BOLD, 35);
    Font font2 = new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 20);
    Font font3 = new Font("Arial", Font.BOLD, 15);
    Font font4 = new Font("Arial", Font.BOLD, 30);
    Font font5 = new Font("Arial", Font.BOLD, 30);

    JFrame jf;
    JPanel jp;
    
    JButton BMasalar;

    JButton Cikis;
    
    JButton Hesap;
    
    
      
    public JFrame getJf() {
        if (jf == null) {
            jf = new JFrame("ANA EKRAN");
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setBounds(300, 50, 500, 620);
            
        }
        return jf;
    }

    public void setJf(JFrame jf) {
        this.jf = jf;
    }

     public JPanel getJp() {
        if (jp == null) {
            jp = new JPanel();
            jp.setLayout(null);
            jp.setBackground(Color.WHITE);

        }
        return jp;
    }

    public void setJp(JPanel jp) {
        this.jp = jp;
    }

 public  Masalar getMf() {
        Masalar mf=new Masalar();
        return mf;
    }     
 public JButton getBMasalar() {
        if (BMasalar == null) {
            BMasalar = new JButton();
            BMasalar.setBounds(100, 50, 300, 150);
            BMasalar.setBorder(null);
            BMasalar.setHorizontalTextPosition(SwingConstants.CENTER);
            BMasalar.setVerticalTextPosition(SwingConstants.CENTER);
            BMasalar.setIcon(new ImageIcon("src\\gui\\MASALAR.png"));
            BMasalar.setForeground(Color.white);
            BMasalar.setFont(font2);
            BMasalar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

            jf.setVisible(false);

            BMasalar.addActionListener(getMf());

		   }
               
		});            
    }      
        return BMasalar;

     }
    public void setBMasalar(JButton BMasalar) {
        this.BMasalar = BMasalar;
    }
    
    public  HesapIstatistik getHesapi() {
        HesapIstatistik Hesapi=new HesapIstatistik();
        return Hesapi;
    } 
    
         public JButton getHesap() {
        if (Hesap == null) {
            Hesap = new JButton();
            Hesap.setBounds(100, 225, 300, 150);
            Hesap.setBorder(null);
            Hesap.setForeground(Color.white);
            Hesap.setFont(font2);
            Hesap.setHorizontalTextPosition(SwingConstants.CENTER);
            Hesap.setVerticalTextPosition(SwingConstants.CENTER);
            Hesap.setIcon(new ImageIcon("src\\gui\\istatistikler.png"));
            Hesap.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {

                     jf.setVisible(false);

                    Hesap.addActionListener(getHesapi());
            
		   }
		});
            
            
            }      
            
        return Hesap;
     }
         
    public void setHesap(JButton Hesap) {
        this.Hesap = Hesap;        
    }
 
     public JButton getCikis() {
        if (Cikis == null) {
            Cikis = new JButton();
            Cikis.setBounds(100, 400, 300, 150);
            Cikis.setBorder(null);
            Cikis.setHorizontalTextPosition(SwingConstants.CENTER);
            Cikis.setVerticalTextPosition(SwingConstants.CENTER);
            Cikis.setIcon(new ImageIcon("src\\gui\\cikis.png"));
            Cikis.setForeground(Color.white);
            Cikis.setFont(font2);
            
            Cikis.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {

                    System.exit(0);
            
		   }
		});
    }        
        return Cikis;
     }
    public void setCikis(JButton Cikis) {
        this.Cikis = Cikis;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
           
}
