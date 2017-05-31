/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scores;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.TreeMap;

/**
 *
 * @author Grimma
 */
public class Puntajes {
    private TreeMap<String, Datos> TabladePuntajes;

    public Puntajes() {
        this.TabladePuntajes = new TreeMap<>();
    }
    
    public void GuardarDatos() throws IOException{
        File a = new File("Scores.txt");
        for(Datos b : this.TabladePuntajes.values()){
            PrintStream c = new PrintStream (new File("Registro.txt"));
            c.println(b.getNombre()+":"+b.getScore());
        }
        
    }

    public void addJugador(Datos Jugador) {
        if(!this.TabladePuntajes.containsKey(Jugador.getNombre())){
            this.TabladePuntajes.put(Jugador.getNombre(), Jugador);
        }else if(this.TabladePuntajes.containsKey(Jugador.getNombre())){
            this.TabladePuntajes.remove(Jugador.getNombre(), Jugador);
            this.TabladePuntajes.put(Jugador.getNombre(), Jugador);
        }
    }
    
}
