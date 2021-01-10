/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.*;
import java.awt.BorderLayout;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class HesapIstatistik implements ActionListener {
     Connection con;
    Font font1 = new Font("Footlight MT Light", Font.BOLD, 35);
    Font font2 = new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 20);
    Font font3 = new Font("Arial", Font.BOLD, 15);
    Font font4 = new Font("Arial", Font.BOLD, 30);
    Font font5 = new Font("Arial", Font.BOLD, 30);
    
      public HesapIstatistik(){
        getIstatistikFrame().add(getIstatistikPanel());
        getIstatistikFrame().setVisible(true);
        
        getIstatistikPanel().add(getSatisIstatistikLabel());  
        getIstatistikPanel().add(getGoruntule()); 
          getIstatistikPanel().add(getTplmucret()); 
          getIstatistikPanel().add(getSifirla());
        getIstatistikPanel().add(getgeriDon());



    }

  

 
    
     JFrame IstatistikFrame;
     JPanel IstatistikPanel;
     JLabel SatisIstatistikLabel;
     JButton Goruntule;
     JLabel Tplmucret;
     JTable tablo;
     JButton Sifirla;
    JButton geriDon;




  
     
     
     
     
     
     
     
     
    public JFrame getIstatistikFrame() {
         if (IstatistikFrame == null) {
            IstatistikFrame = new JFrame("İSTATİSTİKLER");
            IstatistikFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            IstatistikFrame.setBounds(300, 100, 750, 580);
            
        }
        
        
        return IstatistikFrame;
    }

    public void setIstatistikFrame(JFrame IstatistikFrame) {
        this.IstatistikFrame = IstatistikFrame;
    }
     
    
    
      public JPanel getIstatistikPanel() {
          if (IstatistikPanel == null) {
            IstatistikPanel = new JPanel();
            IstatistikPanel.setLayout(null);
            IstatistikPanel.setBackground(Color.white);
            IstatistikPanel.setBounds(0, 0, 0, 0);

        }
          
        return IstatistikPanel;
    }

    public void setIstatistikPanel(JPanel IstatistikPanel) {
        this.IstatistikPanel = IstatistikPanel;
    }
    
        public JLabel getSatisIstatistikLabel() {
            if (SatisIstatistikLabel==null) {
        SatisIstatistikLabel = new JLabel("Satış İstatistikleri");
        SatisIstatistikLabel.setBounds(280, 10, 240, 50);
        SatisIstatistikLabel.setForeground(Color.black);
        SatisIstatistikLabel.setFont(font2);

        }
        return SatisIstatistikLabel;
    }

    public void setSatisIstatistikLabel(JLabel SatisIstatistikLabel) {
        this.SatisIstatistikLabel = SatisIstatistikLabel;
    }
    
        public JLabel getTplmucret() {
        if (Tplmucret==null) {
        Tplmucret = new JLabel("Satış Yapılan Toplam Tutar : 0 TL");
        Tplmucret.setBounds(25, 485, 340, 50);
        Tplmucret.setForeground(Color.black);
        Tplmucret.setFont(font2);

        }
        return Tplmucret;
    }

    public void setTplmucret(JLabel Tplmucret) {
        this.Tplmucret = Tplmucret;
    }
    
    
       public JButton getGoruntule() {
           if (Goruntule == null) {
            Goruntule = new JButton();
            Goruntule.setBounds(20, 70, 240, 50);
            Goruntule.setBackground(Color.red);
            Goruntule.setBorder(null);
            Goruntule.setHorizontalTextPosition(SwingConstants.CENTER);
            Goruntule.setVerticalTextPosition(SwingConstants.CENTER);
            Goruntule.setIcon(new ImageIcon("src\\gui\\goruntule.png"));    
            Goruntule.setForeground(Color.white);
            Goruntule.setFont(font2);
            Goruntule.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                  Statement st;
                  ResultSet rs;
                try {  
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otomasyon","root","");
        st=con.createStatement();
                       Object[] sutunAdlari={"No","Masa No","Tutar"};
            rs=st.executeQuery("SELECT * FROM istatistik");
            Vector satirlar=new Vector();
            int fatura = 0;
            while(rs.next()){
                Object[] degerler={rs.getInt(1),rs.getString(2),rs.getString(3)};
                satirlar.add(degerler);
                fatura += rs.getInt(3);
            }
            Object[][] satirDegerleri=new Object[satirlar.size()][3];
            for(int i=0;i<satirlar.size();i++){
                satirDegerleri[i]=(Object[]) satirlar.get(i);
            }
            
            
            
            getTplmucret().setText("Satış Yapılan Toplam Tutar : "+fatura+" TL");

            tablo=new JTable(satirDegerleri,sutunAdlari);
            JScrollPane scrollpaneli=new JScrollPane(tablo);
            scrollpaneli.setBounds(20,130,675,350);
            IstatistikPanel.add(scrollpaneli);


                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Masa1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Masa1.class.getName()).log(Level.SEVERE, null, ex);
                }
                

}


		   
               
		});            
    }      
        return Goruntule;
    }

    public void setGoruntule(JButton Goruntule) {
        this.Goruntule = Goruntule;
    }
    
      public JButton getSifirla() {
          if (Sifirla == null) {
            Sifirla = new JButton();
            Sifirla.setBounds(280, 70, 250, 50);
            Sifirla.setBackground(Color.white);
            Sifirla.setBorder(null);
            Sifirla.setHorizontalTextPosition(SwingConstants.CENTER);
            Sifirla.setVerticalTextPosition(SwingConstants.CENTER);
            Sifirla.setIcon(new ImageIcon("src\\gui\\sifirla.png"));          
            Sifirla.setForeground(Color.white);
            Sifirla.setFont(font2);
            Sifirla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                  Statement st;
                  ResultSet rs;
                try {  
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otomasyon","root","");
            
            String sorgu=String.format("TRUNCATE TABLE istatistik");
            Statement stmt=con.createStatement(); 
            stmt.executeUpdate(sorgu);
         
            getTplmucret().setText("Toplam Tutar : 0 TL");

            

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Masa1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Masa1.class.getName()).log(Level.SEVERE, null, ex);
                }
                

}


		   
               
		});            
    }      
        
          
          
        return Sifirla;
    }

    public void setSifirla(JButton Sifirla) {
        this.Sifirla = Sifirla;
    }
    
       public  AnaEkran getAna() {
        AnaEkran ana=new AnaEkran();
        return ana;
    }  
       
     public JButton getgeriDon() {
        if (geriDon == null) {
            geriDon = new JButton();
            geriDon.setBounds(550, 70, 150, 50);
            geriDon.setBackground(Color.white);
            geriDon.setBorder(null);
            geriDon.setHorizontalTextPosition(SwingConstants.CENTER);
            geriDon.setVerticalTextPosition(SwingConstants.CENTER);
            geriDon.setIcon(new ImageIcon("src\\gui\\geridon1.png"));
            geriDon.setForeground(Color.white);
            geriDon.setFont(font2);
            geriDon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


             geriDon.addActionListener(getAna());
             IstatistikFrame.setVisible(false);

		   }
               
		});            
    }      
        
        
        return geriDon;
    }

    public void setgeriDon(JButton geriDon) {
        this.geriDon = geriDon;
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
