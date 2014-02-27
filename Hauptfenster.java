//------------------------------------------------------------------------------
// Projekt:     "Elektro-Rechner"                                           
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
// Funktion:    Berechnung elektronischer Bauteile -> Ohm'sches Gesetz, 
//              Vowiderstände für LEDs, Kondensatorladungen, 
//              Bestückungsberechnung für spezielle Bauteile 
//              (z.B. Frequenzberechnung NE555)
//------------------------------------------------------------------------------
// Autoren:     Marcel Kolzau, Sven Oetken, Ben Laurinat
//------------------------------------------------------------------------------
// Datum:       19.02.2014
// Version:     v 1.0
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------
// Einbindung der Bibliotheken
//------------------------------------------------------------------------------
import java.awt.*;
import java.awt.event.*;
//------------------------------------------------------------------------------

public class Hauptfenster extends Frame 
{
  //--------------------------------------------------------------------------
  int i=1;        // Variable zur Buttonfunktion (welcher Button wurde betaetigt)
  
  double R1 = 0;
  double R2 = 0;
  double R3 = 0;
  double I1 = 0;
  double I2 = 0;
  double I3 = 0;
  double U_eingang = 1;
  double U_ausgang = 0;
  double C = 0;
  double Xc = 0;
  
  //--------------------------------------------------------------------------
  // Farben definieren ( R G B )
  //--------------------------------------------------------------------------
  Color dunkelgruen = new Color(0x22,0xDD,0x88);
  //--------------------------------------------------------------------------
  
  //----------------------------------------------------------------------------
  // Schriftarten definieren
  //----------------------------------------------------------------------------
  Font Ueberschrift = new Font("Arial", Font.BOLD, 16);
  Font Normal = new Font("Arial", Font.PLAIN, 12);
  Font Fett = new Font("Arial", Font.BOLD, 12);
  //----------------------------------------------------------------------------
  
  public Hauptfenster()
  {        
    
    
    
    //--------------------------------------------------------------------------
    // Fenster-Einstellungen
    //--------------------------------------------------------------------------
    // Fenstertitel vergeben
    setTitle("Elektro-Rechner");
    
    // Einbindung der Funktion zum Schließen des Fensters
    addWindowListener (new WindowLauscher());
    
    // Fenstergröße bestimmen
    setSize (600,600);
    
    setBackground(dunkelgruen);  
    
    // Sichtbarkeit einstellen
    setResizable(false);
    setVisible(true);  
    //--------------------------------------------------------------------------       
    
    
    //--------------------------------------------------------------------------
    // Anlegen der übergeordneten Menüleiste, auf welcher die Menüelemente 
    // liegen werden
    //--------------------------------------------------------------------------
    MenuBar menueLeiste = new MenuBar ();
    //--------------------------------------------------------------------------
    
    
    //--------------------------------------------------------------------------
    // Anlegen der Menüelemente
    //--------------------------------------------------------------------------
    
    
    //--------------------------------------------------------------------------
    Menu ELEKTRO_RECHNER = new Menu ("Elektro-Rechner");
    //--------------------------------------------------------------------------
    
    
    MenuItem Startseite = new MenuItem ("Startseite");
    Startseite.addActionListener(
    new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Graphics g = getGraphics();
        
        g.setColor(Color.black);
        g.fillRoundRect(49,69,502,512,30,30);
        g.setColor(Color.white);
        g.fillRoundRect(50,70,500,510,30,30);
        g.setColor(Color.black);
        
        g.setFont(Ueberschrift);
        g.drawString("Willkommen beim Elektro-Rechner",170,100);
      }
    }
    );
    
    
    MenuItem Beenden = new MenuItem ("Beenden");
    Beenden.addActionListener(
    new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        System.exit(0);
      }
    }
    );
    
    ELEKTRO_RECHNER.add(Startseite);
    ELEKTRO_RECHNER.addSeparator();
    ELEKTRO_RECHNER.add(Beenden);
    
    menueLeiste.add(ELEKTRO_RECHNER);
    
    //--------------------------------------------------------------------------
    // Menüpunkt "Schaltungen"
    
    Menu SCHALTUNGEN = new Menu ("Schaltungen");
    //--------------------------------------------------------------------------
    
    Menu Grundlagen = new Menu ("Grundlagen");
    
    Menu Ne555 = new Menu ("NE555");
    
    Menu Lm317 = new Menu ("LM317");
    
    Menu Ops = new Menu ("OP's");
    
    SCHALTUNGEN.add(Grundlagen);    
    SCHALTUNGEN.add(Ne555);
    SCHALTUNGEN.add(Lm317);
    SCHALTUNGEN.add(Ops);
    
    //--------------------------------------------------------------------------
    // Unterpunkte für "Grundlagen" 
    //--------------------------------------------------------------------------
    MenuItem OhmGesetz = new MenuItem ("Ohm'sches Gesetz");
    OhmGesetz.addActionListener(
    new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Graphics g = getGraphics();
        
        OhmGesetz ohmgesetz = new OhmGesetz();
        ohmgesetz.Text(g);
        
        
        /*
        g.setColor(Color.black);
        g.fillRoundRect(49,69,502,512,30,30);
        g.setColor(Color.white);
        g.fillRoundRect(50,70,500,510,30,30);
        g.setColor(Color.black); 
        
        g.setFont(Ueberschrift);
        g.drawString("Ohm'sches Gesetz",230,100);
        */
      }
    }
    );
    Grundlagen.add(OhmGesetz);
    
    MenuItem Kondensatoren = new MenuItem ("Kondensatoren");
    Kondensatoren.addActionListener(
    new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Graphics g = getGraphics();
        
        Kondensatoren kondensatoren = new Kondensatoren();
        kondensatoren.Text(g);
      }
    }
    );
    Grundlagen.add(Kondensatoren);
    
    MenuItem Spannungsteiler = new MenuItem ("Spannungsteiler");
    Spannungsteiler.addActionListener(
    new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Graphics g = getGraphics();
        
        Spannungsteiler spannungsteiler = new Spannungsteiler();
        spannungsteiler.Text(g);
      }
    }
    );
    Grundlagen.add(Spannungsteiler);
    //--------------------------------------------------------------------------
    
    
    //--------------------------------------------------------------------------
    // Unterpunkte für "NE555"
    //--------------------------------------------------------------------------
    MenuItem Astabil = new MenuItem("Astabil");
    Astabil.addActionListener(
    new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Graphics g = getGraphics();
        
        Astabil astabil = new Astabil();
        astabil.Text(g);
      }
    }
    );
    Ne555.add(Astabil);
    
    MenuItem Monostabil = new MenuItem("Monostabil");
    Monostabil.addActionListener(
    new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Graphics g = getGraphics();
        
        Monostabil monostabil = new Monostabil();
        monostabil.Text(g);
      }
    }
    );
    Ne555.add(Monostabil);
    //--------------------------------------------------------------------------
    
    
    //--------------------------------------------------------------------------
    // Unterpunkte für "LM317"
    //--------------------------------------------------------------------------
    MenuItem Spannungsregler = new MenuItem("...als Spannungsregler");
    Spannungsregler.addActionListener(
    new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Graphics g = getGraphics();
        
        Spannungsregler spannungsregler = new Spannungsregler();
        spannungsregler.Text(g);
      }
    }
    );
    Lm317.add(Spannungsregler);
    
    MenuItem Konstantstromquelle = new MenuItem("...als Konstantstromquelle");
    Konstantstromquelle.addActionListener(
    new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Graphics g = getGraphics();
        
        Konstantstromquelle konstantstromquelle = new Konstantstromquelle();
        konstantstromquelle.Text(g);
      }
    }
    );
    Lm317.add(Konstantstromquelle);
    //--------------------------------------------------------------------------
    
    
    //--------------------------------------------------------------------------
    // Unterpunkte für "OP's"
    //--------------------------------------------------------------------------
    MenuItem Invertierend = new MenuItem("Invertierender Verstärker");
    Invertierend.addActionListener(
    new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Graphics g = getGraphics();
        
        Invertierend invertierend = new Invertierend();
        invertierend.Text(g);
      }
    }
    );
    Ops.add(Invertierend);
    
    MenuItem Nichtinvertierend = new MenuItem("Nicht invertierender Verstärker");
    Nichtinvertierend.addActionListener(
    new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Graphics g = getGraphics();
        
        Nichtinvertierend nichtinvertierend = new Nichtinvertierend();
        nichtinvertierend.Text(g);
      }
    }
    );
    Ops.add(Nichtinvertierend);
    
    MenuItem Summier = new MenuItem("Summierverstärker");
    Summier.addActionListener(
    new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Graphics g = getGraphics();
        
        Summier summier = new Summier();
        summier.Text(g);
      }
    }
    );
    Ops.add(Summier);
    
    MenuItem Differenzierinvertierer = new MenuItem("Differenzier-Invertierer");
    Differenzierinvertierer.addActionListener(
    new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Graphics g = getGraphics();
        
        Differenzierinvertierer differenzierinvertierer = new Differenzierinvertierer();
        differenzierinvertierer.Text(g);
      }
    }
    );
    Ops.add(Differenzierinvertierer);
    
    MenuItem Integrierinvertierer = new MenuItem("Integrier-Invertierer");
    Integrierinvertierer.addActionListener(
    new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Graphics g = getGraphics();
        
        Integrierinvertierer integrierinvertierer = new Integrierinvertierer();
        integrierinvertierer.Text(g);
      }
    }
    );
    Ops.add(Integrierinvertierer);
    //--------------------------------------------------------------------------
    
    
    menueLeiste.add(SCHALTUNGEN);
    
    
    //--------------------------------------------------------------------------
    Menu INFO = new Menu ("Informationen");
    //--------------------------------------------------------------------------
    
    Menu Version = new Menu ("Version");
    MenuItem Hilfe = new MenuItem ("Hilfefenster öffnen");
    Hilfe.addActionListener(
    new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        
        Frame hilfsFenster = new Frame("Hilfefenster") {
          public void paint(Graphics g) {
            g.setColor(Color.black);
            g.setFont(Ueberschrift);
            g.drawString("Hilfefenster",140,40);
            
            g.setFont(Fett);
            g.drawString("- Menüpunkt 'Elektro-Rechner'",10,60);
            g.setFont(Normal);
            g.drawString("Hier kann das Programm unter 'Beenden' verlassen werden.", 10, 80);
            g.setFont(Fett);
            g.drawString("- Menüpunkt 'Schaltungen'", 10, 100);
            g.setFont(Normal);
            g.drawString("Hier kann zwischen diversen Berechnungsarten gewählt werden.", 10, 120);
            g.drawString("", 10, 140);
          }
        };
        hilfsFenster.addWindowListener(
        new WindowAdapter() {
          public void windowClosing(WindowEvent event) {
            event.getWindow().dispose();
          }
        }
        );
        hilfsFenster.setSize(370, 160);
        hilfsFenster.setResizable(false);
        hilfsFenster.setVisible(true);
        
        
        
      }
    }
    );
    
    
    INFO.add(Version);
    INFO.add(Hilfe);
    
    Version.addSeparator();
    Version.add ("v 1.0");
    Version.addSeparator();
    
    menueLeiste.add(INFO); 
    
    setMenuBar(menueLeiste);   
    
  }
  
  public void paint(Graphics g)
  {
    g.setColor(Color.black);
    g.fillRoundRect(49,69,502,512,30,30);
    g.setColor(Color.white);
    g.fillRoundRect(50,70,500,510,30,30);
    g.setColor(Color.black);
    g.setFont(Ueberschrift);
    g.drawString("Willkommen beim Elektro-Rechner",170,100);
  }
  
  class WindowLauscher extends WindowAdapter
  {
    public void windowClosing(WindowEvent e)
    {
      System.exit(0);
    }
  }
  
  public static void main (String[] args) 
  {
    Hauptfenster H = new Hauptfenster ();   
  }
}
