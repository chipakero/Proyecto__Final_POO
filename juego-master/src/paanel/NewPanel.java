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
import javax.swing.ImageIcon;

/**
 *
 * @author Diego
 */
public class NewPanel extends JPanel implements ActionListener {
    
    private Datos Jugador;
    public Timer time;
    public int z, y, x, c, f, w;
    public int caminar, plataforma, salto, score = 0;
    private Sound sonido;

    public NewPanel() {
        this.sonido = new Sound("soundtrack.wav");
        addKeyListener(new TAdapter());
        setFocusable(true);
        this.time = new Timer(25, this);
        this.sonido.loop();
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
            g.drawImage(Fondo, 0, i, null);
        }
        g.drawImage(Plataforma, (310), (w + 240), (310 + 45), (w + 240 + 45), plataforma * 45, 0, plataforma * 45 + 45, 45, this);
        g.drawImage(Derecha, (x + 300), (z + 200 + y), (c + x + 300 + 63), (z + y + 200 + 63), caminar * 63, 0, caminar * 63 + 63, 63, this);
        
       
        for(int i=200;i>-500;i-=250){
            
            for(int j=0;j<10;j+=(int)(Math.random()*550)){
            g.drawImage(Plataforma, (j), (i), (j + 45), ( i + 45), plataforma * 45, 0, plataforma * 45 + 45, 45, this);
            }
        }
       

        

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((x + 300), (z + 260 + y), (63), (3));
    }

    public void Saltos() {

        Rectangle Reset1 = new Rectangle((310), (w + 240), 45, 5);
        if (Reset1.intersects(getBounds())) {
            salto = 0;
            z += 1;
        } else {
            score += 1;
        }

    }

    public void GameOver() {
        Rectangle gameover = new Rectangle(0, 475, 640, 3);
        Rectangle ninja = getBounds();

        if ((ninja.intersects(gameover))) {
            System.out.println(score);
            System.out.println("Game Over");
            time.stop();
            this.Jugador.setScore(score);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (caminar == 9) {
            caminar = 0;
        } else {
            caminar++;
        }
        if (plataforma == 13) {
            plataforma = 0;
        } else {
            plataforma++;
        }
        w += 1;
        f += 3;
        z += 2;
        GameOver();
        Saltos();
        repaint();
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
            }
            if (key == KeyEvent.VK_P) {
                time.stop();
            }
            if (key == KeyEvent.VK_RIGHT) {
                x += 20;
                c = 0;
            } else if (key == KeyEvent.VK_LEFT) {
                x -= 20;
                if (c == 0) {
                    c -= 126;
                }
            }
            if (key == KeyEvent.VK_UP && salto < 1) {
                y -= 150;
                salto = 1;
            }
            if (key == KeyEvent.VK_DOWN) {
                y += 50;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    }
}
