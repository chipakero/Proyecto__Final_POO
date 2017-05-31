/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja_jump;

/**
 *
 * @author Diego
 */
import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;


public class Ninja_jump extends JFrame {

    public Ninja_jump() {
        add(new NewPanel());
    }

    public static void main(String[] args) {
        Ninja_jump frame = new Ninja_jump();
        frame.setTitle("Ninja Jump");
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}

class NewPanel extends JPanel implements ActionListener, MouseListener {

    private final Timer time;
    private int x = 0, y = 0, z, w = 0, p = 0;
    private int secuencia = 0, plataforma = 0;
    private final Random rnd = new Random();
    private final int[] Posicion = new int[500];
    private int x1;

    public NewPanel() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        this.time = new Timer(25, this);
        this.time.start();
        this.x = 0;
        this.addMouseListener(this);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image Fondo = loadImage("panorama.png");
        for (int i = 0 + y; i > -500 - z; i -= 480) {
            g.drawImage(Fondo, 0, i, null);
        }
        
        
        Image StandR = loadImage("Muñeco2.png");
        Image StandL = loadImage("Muñeco1.png");
        Image Salto1 = loadImage("saltoderecha.png");
        Image Salto2 = loadImage("saltoizquierda.png");
        Image Plataforma = loadImage("plataforma.png");

        //TAdapter a = new TAdapter();
        //g.drawImage(StandR, 289 + x, 209, x + 289 + 100, 209 + 100, secuencia * 63, 0, secuencia * 63 + 63, 63, this);
        g.drawImage(StandL, 289 + x, z + 209 + p, x + 289 + 100, z + 209 + 100 + p, secuencia * 63, 0, secuencia * 63 + 63, 63, this);
        g.setColor(Color.white);
        g.drawRect(0, 440, 640, 10);
        g.drawRect(305 + x, 209, 70, 100);

        for (int i = 0 - z; i > -100 - y; i -= 210) {
                g.drawRect(30, 35 + z, 60, 15);
                g.drawImage(Plataforma, 30, 0 + y + i, 30 + 45, 45 + 45 + y + i, plataforma * 45, 0, plataforma * 45 + 45, 45, this);
        }
        for (int i = 390 - z; i > -100 - y; i -= 210) {
                g.drawRect(30, 35 + z, 60, 15);
                g.drawImage(Plataforma, 500, 0 + y + i, 500 + 45, 45 + 45 + y + i, plataforma * 45, 0, plataforma * 45 + 45, 45, this);
        }
        for (int i = 240 - z; i > -100 - y; i -= 210) {
                g.drawRect(30, 35 + z, 60, 15);
                g.drawImage(Plataforma, 190, 0 + y + i, 190 + 45, 45 + 45 + y + i, plataforma * 45, 0, plataforma * 45 + 45, 45, this);
        }
        for (int i = 115 - z; i > -100 - y; i -= 210) {
                g.drawRect(30, 35 + z, 60, 15);
                g.drawImage(Plataforma, 350, 0 + y + i, 350 + 45, 45 + 45 + y + i, plataforma * 45, 0, plataforma * 45 + 45, 45, this);
        }
        

        /*    for (int i = 10; i < 1000; i += 100) {
            for (int j = -120 + y; j > -500 - z; j -= 633) {
                if (i % 7 == 0) {
                    g.drawRect(i, j + y + 27, 100, 20);
                    g.drawImage(Plataforma, i, j + y, 10 + 45 + 50 + i, 10 + 45 + 25 + y + j, plataforma * 4, 0, plataforma * 45 + 45, 45, this);
                }
            }
        }*/
 /*   for (int i = 50; i < 1000; i += 100) {
            for (int j = 100 + y; j > -500 - z; j -= 311) {
                if (i % 7 == 0) {
                    g.drawRect(i, j + y + 27, 100, 20);
                    g.drawImage(Plataforma, i, j + y, 10 + 45 + 50 + i, 10 + 45 + 25 + y + j, plataforma * 4, 0, plataforma * 45 + 45, 45, this);
                }
            }
        }*/
 /* for (int i = 90; i < 1000; i += 100) {
            for (int j = -120 + y; j > -500 - z; j -= 361) {
                if ((i % 7 == 0)) {
                    g.drawRect(i, j + y + 27, 100, 20);
                    g.drawImage(Plataforma, i, j + y, 10 + 45 + 50 + i, 10 + 45 + 25 + y + j, plataforma * 4, 0, plataforma * 45 + 45, 45, this);
                }
            }
        }*/
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(289 + x, p + z + 209, 100, 100);

    }

    public void Gameover() {
        Rectangle Ninja = getBounds();
        Rectangle perder = new Rectangle(0, 440, 640, 10);
        if ((Ninja.intersects(perder))) {

            System.out.println("GAME OVER");

            time.stop();

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.secuencia == 9) {
            this.secuencia = 0;
        } else {
            this.secuencia++;
        }
        if (this.plataforma == 8) {
            this.plataforma = 0;
        } else {
            this.plataforma++;
        }
        z += 1;
        p += 1;
        w += 1;
        y += 2;
        Gameover();
        repaint();
        

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point mp = e.getPoint();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

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
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            int count = 0;

            if (key == KeyEvent.VK_RIGHT) {
                if (x <= 270) {
                    x += 15;     
                }
            }
            if (key == KeyEvent.VK_LEFT) {
                if (x >= -320) {
                    x -= 15;
                }

            }
            if (key == KeyEvent.VK_UP) {
                if(p!=-210){
                    p-= 10;
                }else{
                    
                }
            }
            if (key == KeyEvent.VK_DOWN) {
                
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

            int key = e.getKeyCode();
            if (key == KeyEvent.VK_UP) {
                

            }
        }
    }

}
