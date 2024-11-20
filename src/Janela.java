import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JTextField;


 
@SuppressWarnings("unused")
public class Janela extends JFrame 
{
    protected static final long serialVersionUID = 1L;

    protected JButton btnPonto   = new JButton ("Ponto"),
                      btnLinha   = new JButton ("Linha"),
                      btnCirculo = new JButton ("Circulo"),
                      btnElipse  = new JButton ("Elipse"),
                      btnQuadrado  = new JButton ("Quadrado"),
                      btnRetangulo  = new JButton ("Retangulo"),
                      btnPoliguno = new JButton ("Poligono"),
                      btnTexto = new JButton ("Texto"),
                      btnCores   = new JButton ("Cores"),
                      btnAbrir   = new JButton ("Abrir"),
                      btnSalvar  = new JButton ("Salvar"),
                      btnApagar  = new JButton ("Apagar"),
                      btnSair    = new JButton ("Sair");
    protected JTextField txtRaio = new JTextField ("150"); 
    protected JLabel txtRaio2 = new JLabel ("Raio apagar:"); 
    protected MeuJPanel pnlDesenho = new MeuJPanel ();
    
    protected JLabel statusBar1 = new JLabel ("Mensagem:"),
                     statusBar2 = new JLabel ("Coordenada:");

    protected boolean esperaPonto, esperaInicioReta, esperaFimReta, esperaCentroCirculo, esperaRaioCirculo, esperaCentroElipse, esperaFimElipse;
    protected boolean esperaInicioQuadrado, esperaArestaQuadrado;
    protected boolean esperaInicioRetangulo, esperaArestaRetangulo,  esperaAresta2Retangulo;
    protected boolean esperaInicioPoliguno, esperaFimPoliguno;
    protected boolean esperaInicioApagar, esperaFimApagar;
    protected boolean esperaTexto;
   
    
    protected Color corInterna = Color.white, corExterna = Color.black, corFundo = new Color(238,238,238);
    protected Ponto p1;
    protected Ponto p2;
    protected Ponto p3;
    protected int aresta, aresta2;

	String raioteste;
    
    protected Vector<Figura> figuras = new Vector<Figura>();
   

    public Janela ()
    {
        super("Editor Gr�fico");

        try
        {
            Image btnPontoImg = ImageIO.read(getClass().getResource("resources/ponto.jpg"));
            btnPonto.setIcon(new ImageIcon(btnPontoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo ponto.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnLinhaImg = ImageIO.read(getClass().getResource("resources/linha.jpg"));
            btnLinha.setIcon(new ImageIcon(btnLinhaImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo linha.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnCirculoImg = ImageIO.read(getClass().getResource("resources/circulo.jpg"));
            btnCirculo.setIcon(new ImageIcon(btnCirculoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo circulo.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnElipseImg = ImageIO.read(getClass().getResource("resources/elipse.jpg"));
            btnElipse.setIcon(new ImageIcon(btnElipseImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo elipse.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        try
        {
            Image btnQuadradoImg = ImageIO.read(getClass().getResource("resources/quadrado.jpg"));
            btnQuadrado.setIcon(new ImageIcon(btnQuadradoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo elipse.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        try
        {
            Image btnRetanguloImg = ImageIO.read(getClass().getResource("resources/babu2 (1).jpg"));
            btnRetangulo.setIcon(new ImageIcon(btnRetanguloImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo elipse.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        try
        {
            Image btPoligunoImg = ImageIO.read(getClass().getResource("resources/babu3 (1).jpg"));
            btnPoliguno.setIcon(new ImageIcon(btPoligunoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo elipse.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        try
        {
            Image btnTextoImg = ImageIO.read(getClass().getResource("resources/babu4 (1).jpg"));
            btnTexto.setIcon(new ImageIcon(btnTextoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo elipse.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnCoresImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
            btnCores.setIcon(new ImageIcon(btnCoresImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo cores.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnAbrirImg = ImageIO.read(getClass().getResource("resources/abrir.jpg"));
            btnAbrir.setIcon(new ImageIcon(btnAbrirImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo abrir.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnSalvarImg = ImageIO.read(getClass().getResource("resources/salvar.jpg"));
            btnSalvar.setIcon(new ImageIcon(btnSalvarImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo salvar.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnApagarImg = ImageIO.read(getClass().getResource("resources/apagar.jpg"));
            btnApagar.setIcon(new ImageIcon(btnApagarImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo apagar.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnSairImg = ImageIO.read(getClass().getResource("resources/sair.jpg"));
            btnSair.setIcon(new ImageIcon(btnSairImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo sair.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        btnPonto.addActionListener (new DesenhoDePonto());
        btnLinha.addActionListener (new DesenhoDeReta ());
        btnCirculo.addActionListener (new DesenhoDeCirculo());
        btnElipse.addActionListener (new DesenhoDeElipse());
        btnQuadrado.addActionListener (new DesenhoDeQuadrado());
        btnRetangulo.addActionListener (new DesenhoDeRetangulo());
        btnPoliguno.addActionListener (new DesenhoDePoliguno());
        btnTexto.addActionListener (new Texto());
        btnCores.addActionListener (new Cores());
        btnApagar.addActionListener (new Apagar());
        btnSalvar.addActionListener (new Salvar());
        btnAbrir.addActionListener (new Abrir());
        btnSair.addActionListener (new Sair());
        
        
        JPanel     pnlBotoes = new JPanel();
        FlowLayout flwBotoes = new FlowLayout(); 
        pnlBotoes.setLayout (flwBotoes);

        pnlBotoes.add (btnAbrir);
        pnlBotoes.add (btnSalvar);
        pnlBotoes.add (btnPonto);
        pnlBotoes.add (btnLinha);
        pnlBotoes.add (btnCirculo);
        pnlBotoes.add (btnElipse);
        pnlBotoes.add (btnQuadrado);
        pnlBotoes.add (btnRetangulo);
        pnlBotoes.add (btnPoliguno);
        pnlBotoes.add (btnTexto);
        pnlBotoes.add (btnCores);
        pnlBotoes.add (btnApagar);
        pnlBotoes.add (btnSair);

        JPanel     pnlStatus = new JPanel();
        GridLayout grdStatus = new GridLayout(1,2);
        pnlStatus.setLayout(grdStatus);

        pnlStatus.add(statusBar1);
        pnlStatus.add(statusBar2);

        Container cntForm = this.getContentPane();
        cntForm.setLayout (new BorderLayout());
        cntForm.add (pnlBotoes,  BorderLayout.NORTH);
        cntForm.add (pnlDesenho, BorderLayout.CENTER);
        cntForm.add (pnlStatus,  BorderLayout.SOUTH);
        
        
        txtRaio.setName("50");  
        txtRaio.setSize(150, 180);  
        
        JPanel     pnlApagar = new JPanel();
        GridLayout grdApagar = new GridLayout(0,1);
        pnlStatus.setLayout(grdApagar);
        pnlApagar.add (txtRaio2);
        pnlApagar.add (txtRaio);
        txtRaio.setVisible(false);
        txtRaio2.setVisible(false);
        
        cntForm.add (pnlApagar,  BorderLayout.EAST);
        
        this.addWindowListener (new FechamentoDeJanela());

        this.setSize (1500,900);
        this.setVisible (true);
    }

    protected class MeuJPanel extends    JPanel 
                              implements MouseListener,
                                         MouseMotionListener
    {
	public MeuJPanel()
        {
            super();

            this.addMouseListener       (this);
            this.addMouseMotionListener (this);
        }

        public void paint (Graphics g)
        {
            for (int i=0 ; i<figuras.size(); i++)
                figuras.get(i).torneSeVisivel(g);
        }
        
        public void mousePressed (MouseEvent e)
        {
            if (esperaPonto)
            {
                figuras.add (new Ponto (e.getX(), e.getY(), corExterna));
                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                esperaPonto = true;
            }
            else
                if (esperaInicioReta)
                {
                    p1 = new Ponto (e.getX(), e.getY(), corExterna);
                    esperaInicioReta = false;
                    esperaFimReta = true;
                    statusBar1.setText("Mensagem: clique no ponto final da reta");    
                 }
                 else
                    if (esperaFimReta)
                    {
                        esperaInicioReta = true;
                        esperaFimReta = false; 
                        figuras.add (new Linha(p1.getX(), p1.getY(), e.getX(), e.getY(), corExterna));
                        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                        String a = figuras.toString();
                       System.out.print(a);
                        statusBar1.setText("Mensagem:");    
                    }
                    else
						if (esperaCentroCirculo)
						{
							p1 = new Ponto (e.getX(), e.getY(), corExterna);
							esperaCentroCirculo = false;
							esperaRaioCirculo = true;
							statusBar1.setText("Mensagem: clique no limite do circulo");    
						 }
						 else
							if (esperaRaioCirculo)
							{
								esperaCentroCirculo = true;
								esperaRaioCirculo = false;
								figuras.add (new Circulo (p1.getX(), p1.getY(), (int)Math.round(Math.sqrt(Math.pow(p1.getX()-e.getX(),2)+Math.pow(p1.getY()-e.getY(),2))), corExterna, corInterna));
								figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
								statusBar1.setText("Mensagem:");    
							}
							else
								if (esperaCentroElipse)
								{
									p1 = new Ponto (e.getX(), e.getY(), corExterna);
									esperaCentroElipse = false;
									esperaFimElipse = true;
									statusBar1.setText("Mensagem: clique no limite da Elipse");    
								 }
								 else
									if (esperaFimElipse)
									{
										esperaCentroElipse = true;
										esperaFimElipse = false;
										int  raioX = Math.abs(p1.getX() - e.getX());
										int  raioY = Math.abs(p1.getY() - e.getY());
										figuras.add (new Elipse (p1.getX(), p1.getY(), raioX, raioY , corExterna, corInterna));
										figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
										statusBar1.setText("Mensagem:");    
									}
									else
										if (esperaInicioQuadrado)
										{
											p1 = new Ponto (e.getX(), e.getY(), corExterna);
											esperaInicioQuadrado = false;
											esperaArestaQuadrado = true;
											statusBar1.setText("Mensagem: clique na Aresta Secundaria");      
										 }
										 else
											if (esperaArestaQuadrado)
											{
												esperaInicioQuadrado = true;
												esperaArestaQuadrado = false;
												aresta = (int)Math.round(Math.sqrt(Math.pow(p1.getX()-e.getX(),2)+Math.pow(p1.getY()-e.getY(),2)));
												figuras.add (new Quadrado (Math.abs(p1.getX() ), Math.abs(p1.getY()), aresta , corExterna, corInterna));
												// pra cima e esquerda problma
												/*
												if(p1.getX() > e.getX()) 
												{
													figuras.add (new Quadrado (Math.abs(p1.getX() - aresta ), Math.abs(p1.getY()), aresta , corExterna, corInterna));
												}
												if(p1.getY() > e.getY()) 
												{
													figuras.add (new Quadrado (Math.abs(p1.getX()), Math.abs(p1.getY()- aresta), aresta , corExterna, corInterna));
												}
												if(p1.getY() > e.getY() || p1.getX() > e.getX()) 
												{
													figuras.add (new Quadrado (Math.abs(p1.getX()- aresta), Math.abs(p1.getY()- aresta), aresta , corExterna, corInterna));
												}
												*/
												
												figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
												statusBar1.setText("Mensagem:");    
											}
											else
												if (esperaInicioRetangulo)
												{
													p1 = new Ponto (e.getX(), e.getY(), corExterna);
													esperaInicioRetangulo = false;
													esperaArestaRetangulo = true;
													esperaAresta2Retangulo = false;
													statusBar1.setText("Mensagem: clique na Aresta Secundaria");    
													//System.out.printf( "00000000");
												 }
												 else
													if (esperaArestaRetangulo)
													{
														p2 = new Ponto (e.getX(), e.getY(), corExterna);
														esperaInicioRetangulo = false;
														esperaArestaRetangulo = false;
														esperaAresta2Retangulo = true;
														//System.out.printf( "11111111");
														statusBar1.setText("Mensagem: clique na Aresta final");
														}
													else            
										            if (esperaAresta2Retangulo)
													{
										            	p3 = new Ponto (e.getX(), e.getY(), corExterna);
										            	esperaInicioRetangulo = true;
														esperaArestaRetangulo = false;
														esperaAresta2Retangulo = false;
														aresta  = (int)Math.round(Math.sqrt(Math.pow(p1.getX()-p2.getX(),2)+Math.pow(p1.getY()-p2.getY(),2)));
														aresta2 = (int)Math.round(Math.sqrt(Math.pow(p2.getX()-p3.getX(),2)+Math.pow(p2.getY()-p3.getY(),2)));
														figuras.add (new Retangulo (Math.abs(p1.getX() ), Math.abs(p1.getY()), aresta2, aresta , corExterna, corInterna));
														figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
														statusBar1.setText("Mensagem:");  	
													}
										            else            
											            if (esperaTexto)
														{
											            	p1 = new Ponto (e.getX(), e.getY(), corExterna);
											            	
															statusBar1.setText("Mensagem:");  	
														}
											            else
															if (esperaInicioPoliguno)
															{
																p1 = new Ponto (e.getX(), e.getY(), corExterna);
																esperaInicioPoliguno = true;
																
																//System.out.printf( "11111111");

																figuras.add (new Poliguno (Math.abs(p1.getX() ), Math.abs(p1.getY()), corExterna, corInterna));
																figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
																statusBar1.setText("Mensagem:");  	
																statusBar1.setText("Mensagem: clique na Aresta final");
																}
															
														          

        }
        
        public void mouseReleased (MouseEvent e)
        {}
        
        public void mouseClicked (MouseEvent e)
        {}
        
        public void mouseEntered (MouseEvent e)
        {}

        public void mouseExited (MouseEvent e)
        {}
        
        public void mouseDragged(MouseEvent e)
        {
        	if (esperaPonto)
            {
                figuras.add (new Ponto (e.getX(), e.getY(), corExterna));
                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                esperaPonto = true;
            }
            else
                if (esperaInicioReta)
                {
                    p1 = new Ponto (e.getX(), e.getY(), corExterna);
                    esperaInicioReta = false;
                    esperaFimReta = true;
                    statusBar1.setText("Mensagem: clique no ponto final da reta");    
                 }
                 else
                    if (esperaFimReta)
                    {
                        esperaInicioReta = false;
                        esperaFimReta = true; 
                        figuras.add (new Linha(p1.getX(), p1.getY(), e.getX(), e.getY(), corExterna));
                        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                        
                        statusBar1.setText("Mensagem:");    
                        String a = Linha.class.toString();
            			System.out.print(a);
                    }
                    else
						if (esperaCentroCirculo)
						{
							p1 = new Ponto (e.getX(), e.getY(), corExterna);
							esperaCentroCirculo = false;
							esperaRaioCirculo = true;
							statusBar1.setText("Mensagem: clique no limite do circulo");    
						 }
						 else
							if (esperaRaioCirculo)
							{
								esperaCentroCirculo = false;
								esperaRaioCirculo = true;
								figuras.add (new Circulo (p1.getX(), p1.getY(), (int)Math.round(Math.sqrt(Math.pow(p1.getX()-e.getX(),2)+Math.pow(p1.getY()-e.getY(),2))), corExterna, corInterna));
								figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
								statusBar1.setText("Mensagem:");    
							}
							else
								if (esperaCentroElipse)
								{
									p1 = new Ponto (e.getX(), e.getY(), corExterna);
									esperaCentroElipse = false;
									esperaFimElipse = true;
									statusBar1.setText("Mensagem: clique no limite da Elipse");    
								 }
								 else
									if (esperaFimElipse)
									{
										esperaCentroElipse = false;
										esperaFimElipse = true;
										int  raioX = Math.abs(p1.getX() - e.getX());
										int  raioY = Math.abs(p1.getY() - e.getY());
										figuras.add (new Elipse (p1.getX(), p1.getY(), raioX, raioY , corExterna, corInterna));
										figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
										statusBar1.setText("Mensagem:");    
									}
									else
										if (esperaInicioQuadrado)
										{
											p1 = new Ponto (e.getX(), e.getY(), corExterna);
											esperaInicioQuadrado = false;
											esperaArestaQuadrado = true;
											statusBar1.setText("Mensagem: clique na Aresta Secundaria");    
										 }
										 else
											if (esperaArestaQuadrado)
											{
												esperaInicioQuadrado = false;
												esperaArestaQuadrado = true;
												aresta = (int)Math.round(Math.sqrt(Math.pow(p1.getX()-e.getX(),2)+Math.pow(p1.getY()-e.getY(),2)));
												figuras.add (new Quadrado (Math.abs(p1.getX() ), Math.abs(p1.getY()), aresta , corExterna, corInterna));
												// pra cima e esquerda problma
												/*
												if(p1.getX() > e.getX()) 
												{
													figuras.add (new Quadrado (Math.abs(p1.getX() - aresta ), Math.abs(p1.getY()), aresta , corExterna, corInterna));
												}
												if(p1.getY() > e.getY()) 
												{
													figuras.add (new Quadrado (Math.abs(p1.getX()), Math.abs(p1.getY()- aresta), aresta , corExterna, corInterna));
												}
												if(p1.getY() > e.getY() || p1.getX() > e.getX()) 
												{
													figuras.add (new Quadrado (Math.abs(p1.getX()- aresta), Math.abs(p1.getY()- aresta), aresta , corExterna, corInterna));
												}
												*/
												figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
												statusBar1.setText("Mensagem:");    
											}
											else
												if (esperaInicioRetangulo)
												{
													p1 = new Ponto (e.getX(), e.getY(), corExterna);
													esperaInicioRetangulo = false;
													esperaArestaRetangulo = true;
													esperaAresta2Retangulo = false;
													statusBar1.setText("Mensagem: clique na Aresta Secundaria");    
													//System.out.printf( "00000000");
												 }
												 else
													if (esperaArestaRetangulo)
													{
														p2 = new Ponto (e.getX(), e.getY(), corExterna);
														esperaInicioRetangulo = false;
														esperaArestaRetangulo = false;
														esperaAresta2Retangulo = true;
														//System.out.printf( "11111111");
														statusBar1.setText("Mensagem: clique na Aresta Final");  
														}
													else            
										            if (esperaAresta2Retangulo)
													{
										            	p3 = new Ponto (e.getX(), e.getY(), corExterna);
										            	esperaInicioRetangulo = false;
														esperaArestaRetangulo = false;
														esperaAresta2Retangulo = true;
														aresta  = (int)Math.round(Math.sqrt(Math.pow(p1.getX()-p2.getX(),2)+Math.pow(p1.getY()-p2.getY(),2)));
														aresta2 = (int)Math.round(Math.sqrt(Math.pow(p2.getX()-p3.getX(),2)+Math.pow(p2.getY()-p3.getY(),2)));
														figuras.add (new Retangulo (Math.abs(p1.getX() ), Math.abs(p1.getY()), aresta2, aresta , corExterna, corInterna));
														figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
														statusBar1.setText("Mensagem:");  	
													}
										            else            
											            if (esperaInicioApagar)
														{
											            	
											            	p1 = new Ponto (e.getX(), e.getY(), corExterna);
											            	esperaInicioApagar = false;
											            	esperaFimApagar = true;
															statusBar1.setText("Mensagem: clique no limite do circulo");   
															raioteste = txtRaio.getText();
														 }
														 else
															if (esperaFimApagar)
															{
																raioteste = txtRaio.getText();
																esperaInicioApagar = true;
																esperaFimApagar = false;
																figuras.add (new Circulo (p1.getX(), p1.getY(), Integer.parseInt(raioteste) , corFundo, corFundo));
																figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
																statusBar1.setText("Mensagem:");	
																txtRaio.setVisible(false);
													            txtRaio2.setVisible(false);
															}
        	
        }

        public void mouseMoved(MouseEvent e)
        {
            statusBar2.setText("Coordenada: "+e.getX()+","+e.getY());
            
        }
    }

    protected class DesenhoDePonto implements ActionListener
    {
          public void actionPerformed (ActionEvent e)    
          {
              esperaPonto         = true;
              esperaInicioReta    = false;
              esperaFimReta       = false;
              esperaCentroCirculo = false;
              esperaRaioCirculo   = false;
              esperaCentroElipse = false;
              esperaFimElipse = false;
              esperaInicioQuadrado= false; 
              esperaArestaQuadrado= false;
              esperaInicioRetangulo = false;
              esperaArestaRetangulo = false;
              esperaAresta2Retangulo = false;
              esperaInicioApagar = false;
              esperaFimApagar = false;
              esperaTexto = false;
              esperaInicioPoliguno = false;
              esperaFimPoliguno = false;
              statusBar1.setText("Mensagem: clique o local do ponto desejado");
          }
    }

    protected class DesenhoDeReta implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
              esperaPonto         = false;
              esperaInicioReta    = true;
              esperaFimReta       = false;
              esperaCentroCirculo = false;
              esperaRaioCirculo   = false;
              esperaCentroElipse = false;
              esperaFimElipse = false;
              esperaInicioQuadrado= false; 
              esperaArestaQuadrado= false;
              esperaInicioRetangulo = false;
              esperaArestaRetangulo = false;
              esperaAresta2Retangulo = false;
              esperaInicioApagar = false;
              esperaFimApagar = false;
              esperaTexto = false;
              esperaInicioPoliguno = false;
              esperaFimPoliguno = false;
            statusBar1.setText("Mensagem: clique o ponto inicial da reta");
        }
    }
    
    protected class DesenhoDeCirculo implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
        	
              esperaPonto         = false;
              esperaInicioReta    = false;
              esperaFimReta       = false;
              esperaCentroCirculo = true;
              esperaRaioCirculo   = false;
              esperaCentroElipse = false;
              esperaFimElipse = false;
              esperaInicioQuadrado= false; 
              esperaArestaQuadrado= false;
              esperaInicioRetangulo = false;
              esperaArestaRetangulo = false;
              esperaAresta2Retangulo = false;
              esperaInicioApagar = false;
              esperaFimApagar = false;
              esperaTexto = false;
              esperaInicioPoliguno = false;
              esperaFimPoliguno = false;

            statusBar1.setText("Mensagem: clique no centro do circulo");
        }
    }
    protected class DesenhoDeElipse implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
              esperaPonto         = false;
              esperaInicioReta    = false;
              esperaFimReta       = false;
              esperaCentroCirculo = false;
              esperaRaioCirculo   = false;
              esperaCentroElipse = true;
              esperaFimElipse = false;
              esperaInicioQuadrado= false; 
              esperaArestaQuadrado= false;
              esperaInicioRetangulo = false;
              esperaArestaRetangulo = false;
              esperaAresta2Retangulo = false;
              esperaInicioApagar = false;
              esperaFimApagar = false;
              esperaTexto = false;
              esperaInicioPoliguno = false;
              esperaFimPoliguno = false;
              

            statusBar1.setText("Mensagem: clique no centro da Elipse");
        }
    }
    protected class DesenhoDeQuadrado implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
              esperaPonto         = false;
              esperaInicioReta    = false;
              esperaFimReta       = false;
              esperaCentroCirculo = false;
              esperaRaioCirculo   = false;
              esperaCentroElipse = false;
              esperaFimElipse = false;
              esperaInicioQuadrado= true; 
              esperaArestaQuadrado= false;
              esperaInicioRetangulo = false;
              esperaArestaRetangulo = false;
              esperaAresta2Retangulo = false;
              esperaInicioApagar = false;
              esperaFimApagar = false;
              esperaTexto = false;
              esperaInicioPoliguno = false;
              esperaFimPoliguno = false;
              
              

            statusBar1.setText("Mensagem: clique na Aresta inicial");
        }
    }
    protected class DesenhoDeRetangulo implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
              esperaPonto         = false;
              esperaInicioReta    = false;
              esperaFimReta       = false;
              esperaCentroCirculo = false;
              esperaRaioCirculo   = false;
              esperaCentroElipse = false;
              esperaFimElipse = false;
              esperaInicioQuadrado= false; 
              esperaArestaQuadrado= false;
              esperaInicioRetangulo = true;
              esperaArestaRetangulo = false;
              esperaAresta2Retangulo = false;
              esperaInicioApagar = false;
              esperaFimApagar = false;
              esperaTexto = false;
              esperaInicioPoliguno = false;
              esperaFimPoliguno = false;
              
              
              

            statusBar1.setText("Mensagem: clique na Aresta inicial");
        }
    }
    protected class DesenhoDePoliguno implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
              esperaPonto         = false;
              esperaInicioReta    = false;
              esperaFimReta       = false;
              esperaCentroCirculo = false;
              esperaRaioCirculo   = false;
              esperaCentroElipse = false;
              esperaFimElipse = false;
              esperaInicioQuadrado= false; 
              esperaArestaQuadrado= false;
              esperaInicioRetangulo = false;
              esperaArestaRetangulo = false;
              esperaAresta2Retangulo = false;
              esperaInicioApagar = false;
              esperaFimApagar = false;
              esperaTexto = false;
              esperaInicioPoliguno = true;
              esperaFimPoliguno = false;
              

            statusBar1.setText("Mensagem: clique na Aresta inicial");
        }
    }
    protected class Texto implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
              esperaPonto         = false;
              esperaInicioReta    = false;
              esperaFimReta       = false;
              esperaCentroCirculo = false;
              esperaRaioCirculo   = false;
              esperaCentroElipse = false;
              esperaFimElipse = false;
              esperaInicioQuadrado= false; 
              esperaArestaQuadrado= false;
              esperaInicioRetangulo = false;
              esperaArestaRetangulo = false;
              esperaAresta2Retangulo = false;
              esperaInicioApagar = false;
              esperaFimApagar = false;
              esperaTexto = true;
              esperaInicioPoliguno = false;
              esperaFimPoliguno = false;
              

            statusBar1.setText("Mensagem: Este Não Funcina");
        }
    }
    protected class Cores extends JFrame  implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
        	Color initialcolor=Color.black;    
        	corExterna =JColorChooser.showDialog(this,"Select a color",initialcolor); 
        	corInterna =JColorChooser.showDialog(this,"Select a color",initialcolor);  
        	
                  
        }
     }
    protected class Apagar extends JFrame  implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
        	esperaPonto         = false;
            esperaInicioReta    = false;
            esperaFimReta       = false;
            esperaCentroCirculo = false;
            esperaRaioCirculo   = false;
            esperaCentroElipse = false;
            esperaFimElipse = false;
            esperaInicioQuadrado= false; 
            esperaArestaQuadrado= false;
            esperaInicioRetangulo = false;
            esperaArestaRetangulo = false;
            esperaAresta2Retangulo = false;
            esperaInicioApagar = true;
            esperaFimApagar = false;
            esperaTexto = false;
            esperaInicioPoliguno = false;
            esperaFimPoliguno = false;
            
            txtRaio.setVisible(true);//jtext
            txtRaio2.setVisible(true);//jlabel
           
            raioteste = txtRaio.getText();
            

            statusBar1.setText("Mensagem: clique o local para apagar (Arrastando)");        	
                  
        }
     }
    protected class Sair extends JFrame  implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
        	
        	this.invalidate();
        	this.validate();
        	this.repaint();
        	this.setVisible(false); //you can't see me!
        	this.dispose(); //Destroy the JFrame object
        	System.exit(0);
            statusBar1.setText("Mensagem: Nao funcina");        	
                  
        }
     }

    protected class Salvar extends JFrame    implements ActionListener  
    {
    	public void test() throws IOException {
    		JFileChooser file = new JFileChooser(); 
            file.setFileSelectionMode(JFileChooser.FILES_ONLY);
            file.showSaveDialog(null);
            //file.showOpenDialog(null);
            File arquivo = file.getSelectedFile();
            
            
    	    FileWriter arq = new FileWriter(arquivo+".txt");
    	    PrintWriter gravarArq = new PrintWriter(arq);
    	    gravarArq.printf(figuras.toString());
    	    arq.close();
    	  }

		@Override
		public void actionPerformed(ActionEvent arg0) {
			        
            
            
            
			// TODO Auto-generated method stub
			try {
				test();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
     }
    protected class Abrir extends JFrame    implements ActionListener  
    {
    	public void test() throws IOException {
    		
			String part1, part2, part3, part4, part5, part6, part7, part8, part9, part10;
			part1 = part2 = part3 = part4 = part5 = part6 = part7 = part8 = part9 = part10 = null;
			Color corExterna2, corInterna2;
    		int posicao = -1;
    		JFileChooser file = new JFileChooser(); 
            file.setFileSelectionMode(JFileChooser.FILES_ONLY);
            //file.showSaveDialog(null);
            file.showOpenDialog(null);
            File arquivo = file.getSelectedFile();
    	
    		try {
    		      FileReader arq = new FileReader(arquivo);
    		      BufferedReader lerArq = new BufferedReader(arq);
    		 
    		      String linha = lerArq.readLine(); // lê a primeira linha
    		// a variável "linha" recebe o valor "null" quando o processo
    		// de repetição atingir o final do arquivo texto
    		      
    		      //System.out.print(linha);
  		  			do {//divisao
  		  			posicao ++;
  		  			posicao ++;
  		  		
    		    	  switch (linha.charAt(posicao))
    		    	  {
    		    	  case 'p': 
    		    		  posicao ++;
    		    		  			posicao ++;
			    		    		part1 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part1 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part1);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part2 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part2 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			posicao ++;
			    		    		part7 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part7 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part7);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part8 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part8 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part8);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part9 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ',' && linha.charAt(posicao) != ']') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part9 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  				
    		    		  			}
    		    		  			corInterna2 = new Color((Integer.parseInt(part7)), (Integer.parseInt(part8)), (Integer.parseInt(part9)));
    		    		  			figuras.add (new Ponto ((Integer.parseInt(part1)), (Integer.parseInt(part2)), corInterna2));
    		    	                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
    		    	                break;
    		    	  case 'l': 
    		    		  posicao ++;
    		    		  			posicao ++;
			    		    		part1 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part1 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part1);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part2 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part2 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			
    		    		  			posicao ++;
			    		    		part3 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part3 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part3);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part4 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part4 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			
    		    		  			posicao ++;
			    		    		part7 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part7 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part7);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part8 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part8 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part8);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part9 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ',' && linha.charAt(posicao) != ']') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part9 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  				
    		    		  			}
    		    		  			corInterna2 = new Color((Integer.parseInt(part7)), (Integer.parseInt(part8)), (Integer.parseInt(part9)));
    		    		  			figuras.add (new Linha((Integer.parseInt(part1)), (Integer.parseInt(part2)), (Integer.parseInt(part3)), (Integer.parseInt(part4)), corInterna2));
    		                        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
    		    	                break;
    		    	  case 'c': 
    		    		  posicao ++;
    		    		  			posicao ++;
			    		    		part1 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part1 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part1);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part2 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part2 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part2);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part3 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part3 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part3);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part4 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part4 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part4);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part5 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part5 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part5);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part6 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part6 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part6);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part7 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part7 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part7);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part8 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part8 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part8);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part9 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ',' && linha.charAt(posicao) != ']') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part9 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  				
    		    		  			}
    		    		  			//System.out.print(part9);
    		    		  			//System.out.print(linha.charAt(posicao));//,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
    		    		  			corExterna2 = new Color((Integer.parseInt(part4)), (Integer.parseInt(part5)), (Integer.parseInt(part6))); // Color white
    		    		  			corInterna2 = new Color((Integer.parseInt(part7)), (Integer.parseInt(part8)), (Integer.parseInt(part9)));
    		    		  			//System.out.print(corExterna2);
    		    		  			//System.out.print(corInterna2);
    		    		  			figuras.add (new Circulo (Integer.parseInt(part1), Integer.parseInt(part2), Integer.parseInt(part3),corExterna2, corInterna2));
    								figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
    		    		  			break;
    		    		  			
    		    	  case 'e': 
    		    		  posicao ++;
    		    		  			posicao ++;
			    		    		part1 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part1 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part1);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part2 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part2 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part2);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part3 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part3 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part3);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part10 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part10 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part10);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part4 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part4 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part4);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part5 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part5 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part5);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part6 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part6 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part6);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part7 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part7 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part7);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part8 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part8 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part8);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part9 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ',' && linha.charAt(posicao) != ']') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part9 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  				
    		    		  			}
    		    		  			//System.out.print(part9);
    		    		  			//System.out.print(linha.charAt(posicao));//,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
    		    		  			corExterna2 = new Color((Integer.parseInt(part4)), (Integer.parseInt(part5)), (Integer.parseInt(part6))); // Color white
    		    		  			corInterna2 = new Color((Integer.parseInt(part7)), (Integer.parseInt(part8)), (Integer.parseInt(part9)));
    		    		  			//System.out.print(corExterna2);
    		    		  			//System.out.print(corInterna2);
    		    		  			figuras.add (new Elipse ((Integer.parseInt(part1)), (Integer.parseInt(part2)), (Integer.parseInt(part3)), (Integer.parseInt(part10)) , corExterna2, corInterna2));
									figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
    		    		  			
    		    		  			break;
    		    	  case 'q': 
    		    		  posicao ++;
    		    		  			posicao ++;
			    		    		part1 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part1 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part1);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part2 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part2 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part2);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part3 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part3 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part3);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part4 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part4 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part4);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part5 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part5 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part5);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part6 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part6 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part6);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part7 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part7 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part7);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part8 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part8 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part8);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part9 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ',' && linha.charAt(posicao) != ']') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part9 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  				
    		    		  			}
    		    		  			//System.out.print(part9);
    		    		  			//System.out.print(linha.charAt(posicao));//,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
    		    		  			corExterna2 = new Color((Integer.parseInt(part4)), (Integer.parseInt(part5)), (Integer.parseInt(part6))); // Color white
    		    		  			corInterna2 = new Color((Integer.parseInt(part7)), (Integer.parseInt(part8)), (Integer.parseInt(part9)));
    		    		  			//System.out.print(corExterna2);
    		    		  			//System.out.print(corInterna2);
    		    		  			figuras.add (new Quadrado ((Integer.parseInt(part1)), (Integer.parseInt(part2)), (Integer.parseInt(part3)) , corExterna2, corInterna2));
									figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
    		    		  			break;
    		    	  case 'r': 
    		    		  posicao ++;
    		    		  			posicao ++;
			    		    		part1 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part1 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part1);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part2 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part2 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part2);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part3 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part3 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part3);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part10 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part10 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part10);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part4 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part4 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part4);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part5 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part5 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part5);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part6 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part6 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part6);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part7 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part7 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part7);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part8 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part8 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part8);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part9 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ',' && linha.charAt(posicao) != ']') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part9 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  				
    		    		  			}
    		    		  			//System.out.print(part9);
    		    		  			//System.out.print(linha.charAt(posicao));//,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
    		    		  			corExterna2 = new Color((Integer.parseInt(part4)), (Integer.parseInt(part5)), (Integer.parseInt(part6))); // Color white
    		    		  			corInterna2 = new Color((Integer.parseInt(part7)), (Integer.parseInt(part8)), (Integer.parseInt(part9)));
    		    		  			//System.out.print(corExterna2);
    		    		  			//System.out.print(corInterna2);
    		    		  			figuras.add (new Retangulo  ((Integer.parseInt(part1)), (Integer.parseInt(part2)), (Integer.parseInt(part3)), (Integer.parseInt(part10)) , corExterna2, corInterna2));
									figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
									
    		    		  			
    		    		  			break;
    		    	  case 'g': 
    		    		  posicao ++;
    		    		  			posicao ++;
			    		    		part1 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part1 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part1);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part2 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part2 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part2);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			
    		    		  			posicao ++;
			    		    		part4 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part4 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part4);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part5 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part5 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part5);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part6 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part6 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part6);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part7 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part7 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part7);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part8 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ':') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part8 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  			}
    		    		  			//System.out.print(part8);
    		    		  			//System.out.print(linha.charAt(posicao));//:::::
    		    		  			
    		    		  			posicao ++;
			    		    		part9 = String.valueOf(linha.charAt(posicao));
			  		  				posicao ++;//p1
    		    		  			while(linha.charAt(posicao) != ',' && linha.charAt(posicao) != ']') { //p1
    		    		  				//System.out.print(linha.charAt(posicao));
    		    		  				 part9 += linha.charAt(posicao);
    		    		  				posicao ++;//p1
    		    		  				
    		    		  			}
    		    		  			//System.out.print(part9);
    		    		  			//System.out.print(linha.charAt(posicao));//,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
    		    		  			corExterna2 = new Color((Integer.parseInt(part4)), (Integer.parseInt(part5)), (Integer.parseInt(part6))); // Color white
    		    		  			corInterna2 = new Color((Integer.parseInt(part7)), (Integer.parseInt(part8)), (Integer.parseInt(part9)));
    		    		  			//System.out.print(corExterna2);
    		    		  			//System.out.print(corInterna2);
    		    		  			figuras.add (new Poliguno (Integer.parseInt(part1), Integer.parseInt(part2), corExterna2, corInterna2));
    								figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
    		    		  			break;
    		    		  			
    		    		  			
    		    		  default:
    		    			  break;
    		    	  }
    		    	 //System.out.print(linha.charAt(posicao));
    		    //posicao ++;    		 //divisao   		  	
  		  		}while(linha.charAt(posicao) == ','); //divisao
  		  		
    		      
    		      arq.close();
    		    } catch (IOException e) {
    		        System.err.printf("Erro na abertura do arquivo: %s.\n",
    		          e.getMessage());
    		    }
    	}
    		

		@Override
		public void actionPerformed(ActionEvent arg0) {
			        
            
            
            
			// TODO Auto-generated method stub
			try {
				test();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
     }
    

    protected class FechamentoDeJanela extends WindowAdapter
    {
        public void windowClosing (WindowEvent e)
        {
            System.exit(0);
        }
    }
}
