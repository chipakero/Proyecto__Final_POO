/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Grimma
 */
public class DibujosPJ {
    private Image[] Images;
    
    DibujosPJ(){
        this.Images = new Image[6];
    }
    
    private Image Imagen(String Name){
        ImageIcon ii = new ImageIcon(Name);
        Image image = ii.getImage();
        return image;
    }
    
    private void ArreglodeDibujos(){
        Images[1]= Imagen("Derecha.png");
        Images[2]= Imagen("Izquierda.png");
        Images[3]= Imagen("Caminar.png");
        Images[4]= Imagen("Caminar2.png");
        Images[5]= Imagen("saltoderecha.png");
        Images[6]= Imagen("saltoizquierda.png");
    }
    
    public Image CargarImagen(int i){
        return Images[i];
    }
    
}
