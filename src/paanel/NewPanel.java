/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paanel;

import Scores.Datos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.PrintStream;
import javax.swing.ImageIcon;

/**
 *
 * @author Diego
 */
public class NewPanel extends JPanel implements ActionListener {
    
    private Datos Jugador;
    private boolean Estado = true;
    public Timer time, time2;
    public int z, y, x, c, f, w, t, tiempo, v;
    public int caminar, plataforma, salto, score = 0;
    private Sound sonido;
    private int azar= (int)(Math.random()*190);
    private int azar1= (int)(Math.random()*400);
    private int azar2= (int)(Math.random()*610);
    
    

    public NewPanel() {
        this.sonido = new Sound("soundtrack.wav");
        addKeyListener(new TAdapter());
        setFocusable(true);
        this.time = new Timer(25+v, this);
//        this.time2 = new Timer(1000, this);
//        this.time2.start();
        
        this.sonido.loop();
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image Derecha = loadImage("Derecha.png");
        Image Fondo = loadImage("panorama.png");
        Image Iquierda = loadImage("Stand1.png");
        Image SaltoIzq = loadImage("Saltar1.png");
        Image SaltoDer = loadImage("Saltar2.png");
        Image Plataforma = loadImage("plataforma.png");
        for (int i = 0 + f; i > -500 - z; i -= 480) {
            g.drawImage(Fondo, 0, i, this);
        }
        g.drawImage(Plataforma, (310), (w + 240), (310 + 45), (w + 240 + 45), plataforma * 45, 0, plataforma * 45 + 45, 45, this);
        g.drawImage(Derecha, (x + 300), (z + 200 + y), (c + x + 300 + 63), (z + y + 200 + 63), caminar * 63, 0, caminar * 63 + 63, 63, this);
        
       
        for(int i=200+f;i>-0-z;i-=150){
            
            g.drawImage(Plataforma, (azar), ( i), (azar + 45), (i + 45), plataforma * 45, 0, plataforma * 45 + 45, 45, this);
            
        }
         for(int i=200+f;i>-0-z;i-=150){
            
            
            g.drawImage(Plataforma, (azar1), ( i), (azar1 + 45), (i + 45), plataforma * 45, 0, plataforma * 45 + 45, 45, this);
            
        }
          for(int i=200+f;i>-0-z;i-=150){
            
            g.drawImage(Plataforma, (azar2), ( i), (azar2 + 45), (i + 45), plataforma * 45, 0, plataforma * 45 + 45, 45, this);
            
        }

       
       

        

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((x + 300), (z + 260 + y), (c+63), (3));
        
    }

    public void Saltos() {
            for(int i=200+f;i>-500-z;i-=150){
            
            Rectangle p= new Rectangle((azar), (i+20), (45), (5));  
            Rectangle Reset1 = new Rectangle((310), (w + 240), 45, 5);
            
            if (Reset1.intersects(getBounds())) {
            salto = 0;
            z += 1;
        }else if(getBounds().intersects(p)) {
            salto = 0;
            z += 1;
            
                 }else{
            score += 1;
            }
        }
    }
     public void Saltos2() {
            for(int i=200+f;i>-500-z;i-=150){
            
            Rectangle p= new Rectangle((azar1), (i+20), (45), (5));  
            Rectangle Reset1 = new Rectangle((310), (w + 240), 45, 5);
            
            if (Reset1.intersects(getBounds())) {
            salto = 0;
            z += 1;
        }else if(getBounds().intersects(p)) {
            salto = 0;
            z += 1;
            
                 }else{
            score += 1;
            }
        }
    }
    
      public void Saltos3() {
            for(int i=200+f;i>-500-z;i-=150){
            
            Rectangle p= new Rectangle((azar2), (i+20), (45), (5));  
            Rectangle Reset1 = new Rectangle((310), (w + 240), 45, 5);
            
            if (Reset1.intersects(getBounds())) {
            salto = 0;
            z += 1;
        }else if(getBounds().intersects(p)) {
            salto = 0;
            z += 1;
            
                 }else{
            score += 1;
            }
        }
    }

    public void GameOver() {
        Rectangle gameover = new Rectangle(0, 475, 640, 100);
        Rectangle ninja = getBounds();

        if ((ninja.intersects(gameover))) {
            System.out.println("Game Over");
            System.out.println(" Puntaje ");
            System.out.println(score);
            Estado = false;
       //     this.Jugador.setScore(score);
            this.sonido.stop();
            tiempototal();
            
           
            time.stop();
            
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (plataforma == 13) {
            plataforma = 0;
        } else {
            plataforma++;
        }
        if (caminar == 9) {
                  caminar = 0;
                  } else{
               caminar++;
        }
        
             f += 2;
             z += 3;
        
          w+=2;
          t+=1;
       
        
       
        velocidad();
        GameOver();
        Saltos();
        Saltos2();
        Saltos3();
        repaint();
    }
    public void velocidad(){
         if(t>=10){
            v=20;
        }else if(t>=35){
            v=35;
        }
    }
    public void tiempototal(){
        tiempo=t/25;
        
        System.out.println("Tiempo Total " + tiempo + " Segundos");
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    class TAdapter extends KeyAdapter {

        public TAdapter() {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            c = 0;

            if (key == KeyEvent.VK_ENTER) {
                time.start();
                sonido.loop();
            }
            if (key == KeyEvent.VK_P) {
                time.stop();
                
            }
            if (key == KeyEvent.VK_RIGHT) {
                 if(x<=270){
                  x += 20;
                 }
                c = 0;
            } else if (key == KeyEvent.VK_LEFT) {
                
                if(x>=-280){
                     x -= 20;
                }
               
            }
            if (key == KeyEvent.VK_UP && salto < 1) {
                y -= 200;
                salto = 1;
            }
            if (key == KeyEvent.VK_DOWN) {
             y+=10;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    }
}
