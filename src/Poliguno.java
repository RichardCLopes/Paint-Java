import java.awt.*;
import java.util.*;
 
public class Poliguno extends Figura
{
    protected Ponto centro;
    protected int   aresta, aresta2;
    protected Color   corInterna;
    
    public Poliguno (int x, int y)
    {
        this (x, y, Color.ORANGE, Color.darkGray);
    }
	
    public Poliguno (int x, int y, Color cor, Color corInterna)
    {
        super (cor);

        this.centro = new Ponto (x,y,cor);

        this.corInterna = corInterna;
    }

    public Poliguno (String s)
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

    
    public Ponto getCentro ()
    {
        return this.centro;
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
    	//g.setColor(this.corInterna);
        //g.fillRect(this.centro.getX(), this.centro.getY(),  // canto superior esquerdo de um Retangulo imaginario que contem o Retangulo
                 // this.aresta, this.aresta2);  // largura e altura
        
        

        int xpoints[] = {this.centro.getX(), 145+this.centro.getX(), this.centro.getX(), 145+this.centro.getX(), 25+this.centro.getX()};
        int ypoints[] = {this.centro.getY(), this.centro.getY(), 145+this.centro.getY(), 145+this.centro.getY(), 25+this.centro.getY()};
        int npoints = 5;
        
        g.setColor(this.corInterna);
        g.fillPolygon(xpoints, ypoints, npoints);
        g.setColor(this.cor);
        g.drawPolygon(xpoints, ypoints, npoints);
        
    }

    public String toString()
    {
        return "g:" +
               this.centro.getX() +
               ":" +
               this.centro.getY() +
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
