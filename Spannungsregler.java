import java.awt.*;
import java.awt.event.*;

public class Spannungsregler extends Frame
{
  
  //----------------------------------------------------------------------------
  // Schriftarten definieren
  //----------------------------------------------------------------------------
  Font Ueberschrift = new Font("Arial", Font.BOLD, 16);
  Font Normal = new Font("Arial", Font.PLAIN, 12);
  //----------------------------------------------------------------------------
  
  public Spannungsregler()
  {
    
  }    
  
  public void Text(Graphics g)
  {
    g.setColor(Color.black);
    g.fillRoundRect(49,69,502,512,30,30);
    g.setColor(Color.white);
    g.fillRoundRect(50,70,500,510,30,30);
    g.setColor(Color.black); 
    
    g.setFont(Ueberschrift);
    g.drawString("Spannungsregler",230,100);
  }
}
