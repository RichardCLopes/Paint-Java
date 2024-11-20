import java.awt.*;
import java.util.*;
 
public class Retangulo extends Figura
{
    protected Ponto centro;
    protected int   aresta, aresta2;
    protected Color   corInterna;
    
    public Retangulo (int x, int y, int aresta, int aresta2)
    {
        this (x, y, aresta, aresta2, Color.ORANGE, Color.darkGray);
    }
	
    public Retangulo (int x, int y, int aresta, int aresta2, Color cor, Color corInterna)
    {
        super (cor);

        this.centro = new Ponto (x,y,cor);
        this.aresta   = aresta;
        this.aresta2   = aresta2;
        this.corInterna = corInterna;
    }

    public Retangulo (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x  = Integer.parseInt(quebrador.nextToken());
        int   y  = Integer.parseInt(quebrador.nextToken());

        int   aresta = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B

        this.centro = new Ponto (x,y,cor);
        this.aresta   = aresta;
        this.cor    = cor;
    }

    public void setCentro (int x, int y)
    {
        this.centro = new Ponto (x,y,this.getCor());
    }

    public void setAresta (int aresta)
    {
        this.aresta = aresta;
    }

    public Ponto getCentro ()
    {
        return this.centro;
    }

    public int getAresta ()
    {
        return this.aresta;
    }
    public void setCorInterna (Color corInterna)
    {
        this.corInterna = corInterna;
    }
    public Color getCorInterna ()
    {
        return this.corInterna;
    }
    public void setAresta2 (int aresta2)
    {
        this.aresta2 = aresta2;
    }
    public int getAresta2 ()
    {
        return this.aresta2;
    }

    public void torneSeVisivel (Graphics g)
    {
    	g.setColor(this.corInterna);
        g.fillRect(this.centro.getX(), this.centro.getY(),  // canto superior esquerdo de um Retangulo imaginario que contem o Retangulo
                   this.aresta, this.aresta2);  // largura e altura
        
        g.setColor(this.cor);
        g.drawRect(this.centro.getX(), this.centro.getY(),  // canto superior esquerdo de um Retangulo imaginario que contem o Retangulo
                   this.aresta, this.aresta2);  // largura e altura
    }

    public String toString()
    {
        return "r:" +
               this.centro.getX() +
               ":" +
               this.centro.getY() +
               ":" +
               this.aresta +
               ":" +
               this.aresta2 +
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
