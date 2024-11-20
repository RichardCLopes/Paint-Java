import java.awt.*;
import java.util.*;
 
public class Elipse extends Figura
{
    protected Ponto centro;
    protected int   raioX;
    protected int   raioY;
    protected Color   corInterna;
    
    public Elipse (int x, int y, int raioX, int raioY)
    {
        this (x, y, raioX, raioY, Color.ORANGE, Color.darkGray);
    }
	
    public Elipse (int x, int y, int raioX, int raioY, Color cor, Color corInterna)
    {
        super (cor);

        this.centro = new Ponto (x,y,cor);
        this.raioX   = raioX;
        this.raioY   = raioY;
        this.corInterna = corInterna;
    }

    public Elipse (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x  = Integer.parseInt(quebrador.nextToken());
        int   y  = Integer.parseInt(quebrador.nextToken());

        int   raioX = Integer.parseInt(quebrador.nextToken());
        int   raioY = Integer.parseInt(quebrador.nextToken());
        

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B

        this.centro = new Ponto (x,y,cor);
        this.raioX   = raioX;
        this.raioY   = raioY;
        this.cor    = cor;
    }

    public void setCentro (int x, int y)
    {
        this.centro = new Ponto (x,y,this.getCor());
    }

    public void setRaioX (int raioX)
    {
        this.raioX = raioX;
    }
    public void setRaioY (int raioY)
    {
        this.raioY = raioY;
    }

    public Ponto getCentro ()
    {
        return this.centro;
    }

    public int getRaioX ()
    {
        return this.raioX;
    }
    public int getRaioY ()
    {
        return this.raioY;
    }
    public void setCorInterna (Color corInterna)
    {
        this.corInterna = corInterna;
    }
    public Color getCorInterna ()
    {
        return this.corInterna;
    }

    public void torneSeVisivel (Graphics g)
    {
    	g.setColor(this.corInterna);
        g.fillOval(this.centro.getX()-this.raioX, this.centro.getY()-this.raioY,  // canto superior esquerdo de um quadrado imaginario que contem o Elipse
                2*this.raioX, 2*this.raioY);
        g.setColor(this.cor);
        g.drawOval(this.centro.getX()-this.raioX, this.centro.getY()-this.raioY,  // canto superior esquerdo de um quadrado imaginario que contem o Elipse
                   2*this.raioX, 2*this.raioY);  // largura e altura
    }

    public String toString()
    {
        return "e:" +
               this.centro.getX() +
               ":" +
               this.centro.getY() +
               ":" +
               this.raioX +
               ":" +
               this.raioY +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue() +
               ":" +
               this.corInterna.getRed() +
               ":" +
               this.corInterna.getGreen() +
               ":" +
               this.corInterna.getBlue();
    }
}
