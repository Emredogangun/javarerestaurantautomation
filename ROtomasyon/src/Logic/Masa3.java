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


/**
 *
 * @author EMRE
 */
public class Masa3 implements ActionListener{
        Connection con;
    Font font1 = new Font("Footlight MT Light", Font.BOLD, 35);
    Font font2 = new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 20);
    Font font3 = new Font("Arial", Font.BOLD, 15);
    Font font4 = new Font("Arial", Font.BOLD, 30);
    Font font5 = new Font("Arial", Font.BOLD, 30);
    
    public Masa3(){
        getMasa3Frame().add(getMasa3Panel());
        getMasa3Frame().setVisible(true);
        
         getMasa3Panel().add(getArayemekler());
        getMasa3Panel().add(getArayemekl());
        getMasa3Panel().add(getArayemeklr());        
        getMasa3Panel().add(getArayemekName());
        
        
        getMasa3Panel().add(getAnayemekler());
        getMasa3Panel().add(getAnayemekl());
        getMasa3Panel().add(getAnayemeklr());
        getMasa3Panel().add(getAnayemekName());
        
        getMasa3Panel().add(getSalata());       
        getMasa3Panel().add(getSalatal());
        getMasa3Panel().add(getSalatalr());        
        getMasa3Panel().add(getSalataName());

        getMasa3Panel().add(getIcecek());       
        getMasa3Panel().add(getIcecekl());
        getMasa3Panel().add(getIceceklr());
        getMasa3Panel().add(getIcecekName());

        getMasa3Panel().add(getsiparisGoruntule());
        getMasa3Panel().add(getgeriDon());
        getMasa3Panel().add(getanasayfaDon());
        getMasa3Panel().add(getekle());
        getMasa3Panel().add(getHesapal());
        getMasa3Panel().add(getTplmucret());  

    }




    JLabel Tplmucret;

    
    JFrame Masa3Frame;
    JPanel Masa3Panel;
 
    
    JLabel anayemekName;
    JLabel anayemekl;
    JComboBox AnaYemekler;
    JLabel anayemeklr;
    int anaYemekf=0;
    
    JLabel arayemekName;
    JLabel arayemekl;
    JLabel arayemeklr;    
    JComboBox AraYemekler;
    int araYemekf=0;
    
    
    JLabel salatal;
    JComboBox Salata;
    int salataf=0;
    JLabel Salatalr;    
    JLabel SalataName;
    
    JLabel iceceklr;       
    JLabel icecekl;
    JComboBox Icecek;
    int icecekf=0;
    JLabel IcecekName;
    
    JButton siparisGoruntule;
    JButton geriDon;
    JButton anasayfaDon;
    JButton ekle;
    JButton Hesapal;

    JTable tablo;







public JFrame getMasa3Frame() {
        if (Masa3Frame == null) {
            Masa3Frame = new JFrame("MASA 2");
            Masa3Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Masa3Frame.setBounds(300, 10, 735, 720);
            
        }
        return Masa3Frame;
    }

    public void setMasa3Frame(JFrame Masa3Frame) {
        this.Masa3Frame = Masa3Frame;
    }
    
    public JPanel getMasa3Panel() {
        if (Masa3Panel == null) {
            Masa3Panel = new JPanel();
            Masa3Panel.setLayout(null);
            Masa3Panel.setBackground(Color.white);
            Masa3Panel.setBounds(0, 0, 0, 0);

        }
        return Masa3Panel;
    }

    public void setJp(JPanel jp) {
        this.Masa3Panel = Masa3Panel;
    }
  
    //ana yemek
        public JLabel getAnayemekName() {
        if (anayemekName==null) {
        anayemekName = new JLabel("Ana Yemekler");
        //x y w h
            anayemekName.setBounds(20, 10, 150, 30);
            anayemekName.setForeground(Color.black);
            anayemekName.setBackground(Color.LIGHT_GRAY);  
            anayemekName.setOpaque(true);
        }
        return anayemekName;
    }
    
    public void setanayemekName(JLabel anayemekName) {
        this.anayemekName = anayemekName;
    }
    
       public JComboBox getAnayemekler() {  
        String s2[] = { "Seçiniz...", "Tavada Patlıcan", "Arnavut Ciğeri", "Yeşilçam Köftesi", "Ispanaklı Köfte", "Köfteli Mantar", "Karbonatlı Köfte", "Fellah Köftesi", "Zade Kebabı","Tokat Kebabı"};  
        int fiyat2[] = { 0,34,27,28,35,32,29,25,26,40 }; 
        JComboBox AnaYemekler = new JComboBox(s2);
        AnaYemekler.setSize(200, 50);
        AnaYemekler.setBounds(20, 50, 150, 30);
        AnaYemekler.setBackground(Color.yellow);
        AnaYemekler.addItemListener(new ItemListener() {
            
        // combobox a tıklandıgında... 
            public void itemStateChanged(ItemEvent event) {
                JComboBox comboBox = (JComboBox) event.getSource();

                // tıklandıgında itemi atıyor...
                Object item = event.getItem();

                if (event.getStateChange() == ItemEvent.SELECTED) {
                    getAnayemekl().setText(""+fiyat2[AnaYemekler.getSelectedIndex()]);
                    anaYemekf=fiyat2[AnaYemekler.getSelectedIndex()];
                    anayemeklr.setIcon(new ImageIcon(images1[AnaYemekler.getSelectedIndex()]));

                }
            }
        });
        return AnaYemekler;
    }

    public void setAnaYemekler(JComboBox AnaYemekler) {
        this.AnaYemekler = AnaYemekler;
    }
    
        public JLabel getAnayemekl() {
        if (anayemekl==null) {
        anayemekl = new JLabel("0");
        //x y w h
            anayemekl.setBounds(20, 90, 150, 30);
            anayemekl.setForeground(Color.black);
            anayemekl.setBackground(Color.LIGHT_GRAY);  
            anayemekl.setOpaque(true);
        }
        return anayemekl;
    }
    
    public void setAnayemekl(JLabel anayemekl) {
        this.anayemekl = anayemekl;
    }
    //resim olayı 
    String images1[]={"src\\gui\\anaresim.jpg"
            ,"src\\gui\\anayemek1.jpg"
            ,"src\\gui\\anayemek2.jpg"
            ,"src\\gui\\anayemek3.jpg"
            ,"src\\gui\\anayemek4.jpg"
            ,"src\\gui\\anayemek5.jpg"
            ,"src\\gui\\anayemek6.jpg"
            ,"src\\gui\\anayemek7.jpg"
            ,"src\\gui\\anayemek8.jpg"
            ,"src\\gui\\anayemek9.jpg"};
       public JLabel getAnayemeklr() {
        if (anayemeklr==null) {
        anayemeklr = new JLabel("");
            anayemeklr.setBounds(20, 150, 150, 200);
            anayemeklr.setForeground(Color.black);
            anayemeklr.setBackground(Color.white);  
            anayemeklr.setIcon(new ImageIcon("src\\gui\\default.jpg"));
            anayemeklr.setOpaque(true);
        }
        return anayemeklr;
    }
    public void setAnayemeklr(JLabel anayemeklr) {
        this.anayemeklr = anayemeklr;
    } 
    //resimolayı bitiş..
    //buraya kadar arayemek
    
    
    
    
    
    
   
    
    
    
    
    
    
    
 
    
    
    
    
    ////bundan sonrası
    
    
            //Arayemek ...
        public JLabel getArayemekName() {
        if (arayemekName==null) {
        arayemekName = new JLabel("Ara Yemekler");
        //x y w h
            arayemekName.setBounds(190, 10, 150, 30);
            arayemekName.setForeground(Color.black);
            arayemekName.setBackground(Color.LIGHT_GRAY);  
            arayemekName.setOpaque(true);
        }
        return arayemekName;
    }
    
    public void setArayemekName(JLabel arayemekName) {
        this.arayemekName = arayemekName;
    }

       public JComboBox getArayemekler() {  
      String s2[] = { "Seçiniz...", "Patates Graten", "Kabak Graten", "Kabak Karnıyarık", "Sulu Börek", "Ali Nazik", "Pazı Kavurması", "Pilav", "Kabak Dolması","Tokat Sarması"};  
        int fiyat2[] = { 0,11,14,17,22,25,18,15,13,10 }; 
        JComboBox AraYemekler = new JComboBox(s2);
        AraYemekler.setSize(200, 50);
        AraYemekler.setBounds(190, 50, 150, 30);
        AraYemekler.setBackground(Color.yellow);
        AraYemekler.addItemListener(new ItemListener() {
            
        // combobox a tıklandıgında... 
            public void itemStateChanged(ItemEvent event) {
                JComboBox comboBox = (JComboBox) event.getSource();

                // tıklandıgında itemi atıyor...
                Object item = event.getItem();

                if (event.getStateChange() == ItemEvent.SELECTED) {
                    getArayemekl().setText(""+fiyat2[AraYemekler.getSelectedIndex()]);
                    araYemekf=fiyat2[AraYemekler.getSelectedIndex()];
                    arayemeklr.setIcon(new ImageIcon(images2[AraYemekler.getSelectedIndex()]));

                }
            }
        });
        return AraYemekler;
    }

    public void setAraYemekler(JComboBox AraYemekler) {
        this.AraYemekler = AraYemekler;
    }
    
        public JLabel getArayemekl() {
        if (arayemekl==null) {
        arayemekl = new JLabel("0");
        //x y w h
            arayemekl.setBounds(190, 90, 150, 30);
            arayemekl.setForeground(Color.black);
            arayemekl.setBackground(Color.LIGHT_GRAY);  
            arayemekl.setOpaque(true);
        }
        return arayemekl;
    }
    
    public void setArayemekl(JLabel arayemekl) {
        this.arayemekl = arayemekl;
    }
    //resim olayı 
    String images2[]={"src\\gui\\anaresim.jpg"
            ,"src\\gui\\arayemek1.jpg"
            ,"src\\gui\\arayemek2.png"
            ,"src\\gui\\arayemek3.jpg"
            ,"src\\gui\\arayemek4.jpg"
            ,"src\\gui\\arayemek5.jpg"
            ,"src\\gui\\arayemek6.jpg"
            ,"src\\gui\\arayemek7.jpg"
            ,"src\\gui\\arayemek8.jpg"
            ,"src\\gui\\arayemek9.jpg"};
       public JLabel getArayemeklr() {
        if (arayemeklr==null) {
        arayemeklr = new JLabel("");
            arayemeklr.setBounds(190, 150, 150, 200);
            arayemeklr.setForeground(Color.black);
            arayemeklr.setBackground(Color.white);  
            arayemeklr.setIcon(new ImageIcon("src\\gui\\default.jpg"));
            arayemeklr.setOpaque(true);
        }
        return arayemeklr;
    }
    public void setArayemeklr(JLabel arayemeklr) {
        this.arayemeklr = arayemeklr;
    } 
    //resimolayı bitiş..
    //buraya kadar arayemek
   
    
    
    
    
    
    //Salatalar

        public JLabel getSalataName() {
        if (SalataName==null) {
        SalataName = new JLabel("Salatalar");
        //x y w h
            SalataName.setBounds(360, 10, 150, 30);
            SalataName.setForeground(Color.black);
            SalataName.setBackground(Color.LIGHT_GRAY);  
            SalataName.setOpaque(true);
        }
        return SalataName;
    }
    
    public void setSalataName(JLabel SalataName) {
        this.SalataName = SalataName;
    }
    
     public JComboBox getSalata() {  
              String s3[] = { "Seçiniz...", "Bostana Salatası ", "Pirpirim Salatası", "Sezar Salatası", "Ton Balıklı Salata", "Tavuklu Salatası", "Roka Salatası", "Rus Salatası ", "Brokoli Salatası", "Çoban Salata"};  
        int fiyat3[] = { 0,12,9,16,17,11,10,18,7,15 }; 
        JComboBox Salata = new JComboBox(s3);
        Salata.setSize(200, 50);
        Salata.setBounds(360, 50, 150, 30);
        Salata.setBackground(Color.yellow);
        Salata.addItemListener(new ItemListener() {
            
        // combobox a tıklandıgında... 
            public void itemStateChanged(ItemEvent event) {
                JComboBox comboBox = (JComboBox) event.getSource();

                // tıklandıgında itemi atıyor...
                Object item = event.getItem();

                if (event.getStateChange() == ItemEvent.SELECTED) {
                    getSalatal().setText(""+fiyat3[Salata.getSelectedIndex()]);
                    salataf=fiyat3[Salata.getSelectedIndex()];
                    Salatalr.setIcon(new ImageIcon(images3[Salata.getSelectedIndex()]));

                }
            }
        });
        return Salata;
    }

    public void setSalata(JComboBox Salata) {
        this.Salata = Salata;
    }
    
        public JLabel getSalatal() {
        if (salatal==null) {
        salatal = new JLabel("0");
        //x y w h
            salatal.setBounds(360, 90, 150, 30);
            salatal.setForeground(Color.black);
            salatal.setBackground(Color.LIGHT_GRAY);  
            salatal.setOpaque(true);
        }
        return salatal;
    }
    
    public void setSalatal(JLabel salatal) {
        this.salatal = salatal;
    }
    
    
    
     //resim olayı 
    String images3[]={"src\\gui\\anaresim.jpg"
            ,"src\\gui\\salata1.jpg"
            ,"src\\gui\\salata2.jpg"
            ,"src\\gui\\salata3.jpg"
            ,"src\\gui\\salata4.jpg"
            ,"src\\gui\\salata5.jpg"
            ,"src\\gui\\salata6.jpg"
            ,"src\\gui\\salata7.jpg"
            ,"src\\gui\\salata8.jpg"
            ,"src\\gui\\salata9.jpg"};

       public JLabel getSalatalr() {
        if (Salatalr==null) {
        Salatalr = new JLabel("");
            Salatalr.setBounds(360, 150, 150, 200);
            Salatalr.setForeground(Color.black);
            Salatalr.setBackground(Color.white);  
            Salatalr.setIcon(new ImageIcon("src\\gui\\default.jpg"));
            Salatalr.setOpaque(true);
        }
        return Salatalr;
    }
    public void setSalatalr(JLabel Salatalr) {
        this.Salatalr = Salatalr;
    } 
    //resimolayı bitiş..
    //buraya kadar Salatalar
   
    
    //içecekler
    
     public JLabel getIcecekName() {
        if (IcecekName==null) {
        IcecekName = new JLabel("İçecekler");
        //x y w h
            IcecekName.setBounds(530, 10, 150, 30);
            IcecekName.setForeground(Color.black);
            IcecekName.setBackground(Color.LIGHT_GRAY);  
            IcecekName.setOpaque(true);
        }
        return IcecekName;
    }
    
    public void setIcecekName(JLabel IcecekName) {
        this.IcecekName = IcecekName;
    }
    
     public JComboBox getIcecek() {  
        String s3[] = { "Seçiniz...", "Kola ", "Su", "Ayran", "Çay", "Soda", "Soğuk Çay", "Portakal Suyu", "Limonata", "Gazoz" };  
        int fiyat3[] = { 0,5,2,3,1,6,4,8,7,9 };
        JComboBox Icecek = new JComboBox(s3);
        Icecek.setSize(200, 50);
        Icecek.setBounds(530, 50, 150, 30);
        Icecek.setBackground(Color.yellow);
        Icecek.addItemListener(new ItemListener() {
            
            public void itemStateChanged(ItemEvent event) {
                JComboBox comboBox = (JComboBox) event.getSource();

                Object item = event.getItem();

                if (event.getStateChange() == ItemEvent.SELECTED) {
                    getIcecekl().setText(""+fiyat3[Icecek.getSelectedIndex()]);
                    icecekf=fiyat3[Icecek.getSelectedIndex()];
                    iceceklr.setIcon(new ImageIcon(images4[Icecek.getSelectedIndex()]));

                }
            }
        });
        return Icecek;
    }

    public void setIcecek(JComboBox Icecek) {
        this.Icecek = Icecek;
    }
    
        public JLabel getIcecekl() {
        if (icecekl==null) {
        icecekl = new JLabel("0");
            icecekl.setBounds(530, 90, 150, 30);
            icecekl.setForeground(Color.black);
            icecekl.setBackground(Color.LIGHT_GRAY);  
            icecekl.setOpaque(true);
        }
        return icecekl;
    }
    
    public void setIcecekl(JLabel icecekl) {
        this.icecekl = icecekl;
    }
     //resim olayı
        String images4[]={"src\\gui\\anaresim.jpg"
            ,"src\\gui\\icecek1.jpg"
            ,"src\\gui\\icecek2.jpg"
            ,"src\\gui\\icecek3.png"
            ,"src\\gui\\icecek4.jpg"
            ,"src\\gui\\icecek5.jpg"
            ,"src\\gui\\icecek6.jpg"
            ,"src\\gui\\icecek7.jpg"
            ,"src\\gui\\icecek8.jpg"
            ,"src\\gui\\icecek9.jpg"};
    
       public JLabel getIceceklr() {
        if (iceceklr==null) {
        iceceklr = new JLabel("");
            iceceklr.setBounds(530, 150, 150, 200);
            iceceklr.setForeground(Color.black);
            iceceklr.setBackground(Color.white);  
            iceceklr.setIcon(new ImageIcon("src\\gui\\default.jpg"));
            iceceklr.setOpaque(true);
        }
        return iceceklr;
    }
    public void setIceceklr(JLabel iceceklr) {
        this.iceceklr = iceceklr;
    } 
    //resimolayı bitiş..
    //buraya kadar içecekler
   
    
  
    public JLabel getTplmucret() {
        if (Tplmucret==null) {
        Tplmucret = new JLabel("Toplam Tutar : 0 TL");
        Tplmucret.setBounds(475, 585, 240, 50);
        Tplmucret.setForeground(Color.black);
        Tplmucret.setFont(font2);

        }
        return Tplmucret;
    }

    public void setTplmucret(JLabel Tplmucret) {
        this.Tplmucret = Tplmucret;
    }
  
    
    
    
    public JButton getsiparisGoruntule() {
        if (siparisGoruntule == null) {
            siparisGoruntule = new JButton();
            siparisGoruntule.setBounds(20, 640, 240, 30);
            siparisGoruntule.setBackground(Color.red);
            siparisGoruntule.setBorder(null);
            siparisGoruntule.setHorizontalTextPosition(SwingConstants.CENTER);
            siparisGoruntule.setVerticalTextPosition(SwingConstants.CENTER);
            siparisGoruntule.setIcon(new ImageIcon("src\\gui\\siparisgoruntule.png"));
            siparisGoruntule.setForeground(Color.white);
            siparisGoruntule.setFont(font2);
            siparisGoruntule.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                  Statement st;
                  ResultSet rs;
                try {  
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otomasyon","root","");
        st=con.createStatement();
                       Object[] sutunAdlari={"Sipariş No","Masa No","Ana Yemek","Ara Yemek","Salata","İcecek","Hesap"};
            rs=st.executeQuery("SELECT * FROM siparisler WHERE masano='3'");
            Vector satirlar=new Vector();
            int fatura = 0;
            while(rs.next()){
                Object[] degerler={rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)};
                satirlar.add(degerler);
                fatura += rs.getInt(7);
            }
            Object[][] satirDegerleri=new Object[satirlar.size()][7];
            for(int i=0;i<satirlar.size();i++){
                satirDegerleri[i]=(Object[]) satirlar.get(i);
            }
            
            
            
            getTplmucret().setText("Toplam Tutar : "+fatura+" TL");

            tablo=new JTable(satirDegerleri,sutunAdlari);
            JScrollPane scrollpaneli=new JScrollPane(tablo);
            scrollpaneli.setBounds(20,350,675,230);
            Masa3Panel.add(scrollpaneli);


                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Masa3.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Masa3.class.getName()).log(Level.SEVERE, null, ex);
                }
                

}


		   
               
		});            
    }      
        
        
        return siparisGoruntule;
    }

    public void setSiparisGoruntule(JButton siparisGoruntule) {
        this.siparisGoruntule = siparisGoruntule;
    }
    
    
    
        public JButton getHesapal() {
        if (Hesapal == null) {
            Hesapal = new JButton();
            Hesapal.setBounds(180, 600, 150, 30);
            Hesapal.setBackground(Color.red);
            Hesapal.setBorder(null);
            Hesapal.setHorizontalTextPosition(SwingConstants.CENTER);
            Hesapal.setVerticalTextPosition(SwingConstants.CENTER);
            Hesapal.setIcon(new ImageIcon("src\\gui\\hesabiode.png"));
            Hesapal.setForeground(Color.white);
            Hesapal.setFont(font2);
            Hesapal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                  Statement st;
                  ResultSet rs;
                try {  
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otomasyon","root","");
        st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM siparisler WHERE masano='3'");
            int fatura = 0;
            while(rs.next()){
                fatura += rs.getInt(7);
            }
            String sorgu=String.format("DELETE FROM siparisler WHERE masano='3'");
            Statement stmt=con.createStatement(); 
            stmt.executeUpdate(sorgu);
            try{
            Statement stmtt=con.createStatement(); 
            String sorguu=String.format("insert into istatistik values(NULL, '3', %d)", fatura);
            stmtt.executeUpdate(sorguu);
                    }catch(Exception e){ System.out.println(e);}
                        getTplmucret().setText("Toplam Tutar : 0 TL");

            

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Masa3.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Masa3.class.getName()).log(Level.SEVERE, null, ex);
                }
                

}


		   
               
		});            
    }      
        
        
        return Hesapal;
    }

    public void setHesapal(JButton Hesapal) {
        this.Hesapal = Hesapal;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
    public  Masalar getM() {
        Masalar m=new Masalar();
        return m;
 }  
       
    public JButton getgeriDon() {
        if (geriDon == null) {
            geriDon = new JButton();
            geriDon.setBounds(280, 640, 150, 30);
            geriDon.setBackground(Color.red);
            geriDon.setBorder(null);
            geriDon.setHorizontalTextPosition(SwingConstants.CENTER);
            geriDon.setVerticalTextPosition(SwingConstants.CENTER);
            geriDon.setIcon(new ImageIcon("src\\gui\\geridon.png"));
            geriDon.setForeground(Color.white);
            geriDon.setFont(font2);
            geriDon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


             geriDon.addActionListener(getM());
            Masa3Frame.setVisible(false);

		   }
               
		});            
    }      
        
        
        return geriDon;
    }

    public void setgeriDon(JButton geriDon) {
        this.geriDon = geriDon;
    }
    
        public  AnaEkran getAna() {
        AnaEkran ana=new AnaEkran();
        return ana;
    }  
       
    public JButton getanasayfaDon() {
        if (anasayfaDon == null) {
            anasayfaDon = new JButton();
            anasayfaDon.setBounds(450, 640, 240, 30);
            anasayfaDon.setBackground(Color.red);
            anasayfaDon.setBorder(null);
            anasayfaDon.setHorizontalTextPosition(SwingConstants.CENTER);
            anasayfaDon.setVerticalTextPosition(SwingConstants.CENTER);
            anasayfaDon.setIcon(new ImageIcon("src\\gui\\anasayfayadon.png"));
            anasayfaDon.setForeground(Color.white);
            anasayfaDon.setFont(font2);
            anasayfaDon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


             anasayfaDon.addActionListener(getAna());
              Masa3Frame.setVisible(false);

		   }
               
		});            
    }      
                return anasayfaDon;
    }

    public void setanasayfaDon(JButton anasayfaDon) {
        this.anasayfaDon = anasayfaDon;
    }
    
     public JButton getekle() {
        if (ekle == null) {
            ekle = new JButton();
            ekle.setBounds(20, 600, 150, 30);
            ekle.setBackground(Color.red);
            ekle.setBorder(null);
            ekle.setHorizontalTextPosition(SwingConstants.CENTER);
            ekle.setVerticalTextPosition(SwingConstants.CENTER);
            ekle.setIcon(new ImageIcon("src\\gui\\hesabaekle.png"));
            ekle.setForeground(Color.white);
            ekle.setFont(font2);
            ekle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try{
            Class.forName("com.mysql.jdbc.Driver");  
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otomasyon","root","");
                    }catch(Exception e){ System.out.println(e);}
                

                int AnaYemek = anaYemekf;
                int AraYemek = araYemekf;
                int Salataucret = salataf;
                int icecekucret = icecekf;
                String masano = "3";
                String yemekadi = null;
                String arayemekadi = null;
                String salataadi = null;
                String icecekadi = null;
                int toplamucret = anaYemekf +  araYemekf +  salataf + icecekf;
                if (AnaYemek == 0)
                {
                    yemekadi = "YOK";
                } else if (AnaYemek == 34)
                {
                    yemekadi = "Tavada Patlican";
                } else if (AnaYemek == 27)
                {
                    yemekadi = "Arnavut Cigeri";
                } else if (AnaYemek == 28)
                {
                    yemekadi = "Yesilcam Koftesi";
                }   else if (AnaYemek == 35)
                {
                    yemekadi = "Ispanaklı Köfte";
                }else if (AnaYemek == 32)
                {
                    yemekadi = "Köfteli Mantar";
                }else if (AnaYemek == 29)
                {
                    yemekadi = "Karbonatli Köfte";
                }
                else if (AnaYemek == 25)
                {
                    yemekadi = "Fellah Köftesi";
                }
                else if (AnaYemek == 26)
                {
                    yemekadi = "Zade Kebabi";
                }
                else if (AnaYemek == 40)
                {
                    yemekadi = "Tokat Kebabi";
                }
                
             
                if (AraYemek == 0)
                {
                    arayemekadi = "YOK";
                } else if (AraYemek == 11)
                {
                    arayemekadi = "Patates Graten";
                } else if (AraYemek == 14)
                {
                    arayemekadi = "Kabak Graten";
                } else if (AraYemek == 17)
                {
                    arayemekadi = "Kabak Karniyarik";
                }else if (AraYemek == 22)
                {
                    arayemekadi = "Sulu Börek";
                }else if (AraYemek == 25)
                {
                    arayemekadi = "Ali Nazik";
                }else if (AraYemek == 18)
                {
                    arayemekadi = "Pazi Kavurmasi";
                }else if (AraYemek == 15)
                {
                    arayemekadi = "Pilav";
                }else if (AraYemek == 13)
                {
                    arayemekadi = "Kabak Dolmasi";
                }else if (AraYemek == 10)
                {
                    arayemekadi = "Tokat Sarmasi";
                }
                
                
                if (Salataucret == 0)
                {
                    salataadi = "YOK";
                } else if (Salataucret == 12)
                {
                    salataadi = "Bostana Salatası";
                } else if (Salataucret == 9)
                {
                    salataadi = "Pirpirim Salatasi";
                } else if (Salataucret == 16)
                {
                    salataadi = "Sezar Salatasi";
                }else if (Salataucret == 17)
                {
                    salataadi = "Ton Balıkli Salata";
                }else if (Salataucret == 11)
                {
                    salataadi = "Tavuklu Salata";
                }else if (Salataucret == 10)
                {
                    salataadi = "Roka Salatasi";
                }else if (Salataucret == 18)
                {
                    salataadi = "Rus Salatasi";
                }else if (Salataucret == 7)
                {
                    salataadi = "Brokoli Salatasi";
                }else if (Salataucret == 15)
                {
                    salataadi = "Coban Salata";
                }

                
                if (icecekucret == 0)
                {
                    icecekadi = "YOK";
                } else if (icecekucret == 5)
                {
                    icecekadi = "Kola";
                } else if (icecekucret == 2)
                {
                    icecekadi = "Su";
                } else if (icecekucret == 3)
                {
                    icecekadi = "Ayran";
                }else if (icecekucret == 1)
                {
                    icecekadi = "Cay";
                }else if (icecekucret == 6)
                {
                    icecekadi = "Soda";
                }else if (icecekucret == 4)
                {
                    icecekadi = "Soguk Cay";
                }else if (icecekucret == 8)
                {
                    icecekadi = "Portakal Suyu";
                }else if (icecekucret == 7)
                {
                    icecekadi = "Limonata";
                }else if (icecekucret == 9)
                {
                    icecekadi = "Gazoz";
                }
                
                try{
            Statement stmt=con.createStatement(); 
            String sorgu=String.format("insert into siparisler values(NULL, '%s', '%s','%s','%s','%s', %d)", masano,yemekadi,arayemekadi,salataadi,icecekadi,toplamucret);
            stmt.executeUpdate(sorgu);
                    }catch(Exception e){ System.out.println(e);}
                

		   }
               
		});            
    }      
        
        
        return ekle;
    }

    public void setekle(JButton geriDon) {
        this.ekle = ekle;
    }
    
    
  
    
        @Override
    public void actionPerformed(ActionEvent ae) {
     
        
    }

    
}