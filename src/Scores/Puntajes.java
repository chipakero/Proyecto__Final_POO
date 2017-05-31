/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.StringTokenizer;
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

    public void GuardarDatos() throws IOException, ParseException {
        File a = new File("Scores.txt");
        FileReader Reader = new FileReader(a);
        BufferedReader reader2 = new BufferedReader(Reader);
        String Datos;
        if (a.canRead()) {
            while ((Datos = reader2.readLine()) != null) {
                StringTokenizer Token = new StringTokenizer(Datos, ":");
                String[] Tokens = new String[Token.countTokens()];
                for (int i = 0; i < Tokens.length; i++) {
                    Tokens[i] = Token.nextToken();
                }

                for (Datos b : this.TabladePuntajes.values()) {
                    PrintStream c = new PrintStream(a);
                    if (Tokens[1].equals(b.getNombre())) {
                        c.println(b.getNombre() + ":" + b.getScore());
                    } else if (!Tokens[1].equals(b.getNombre())) {
                        b.setNombre(Tokens[1]);
                        b.setScore(Integer.parseInt(Tokens[2]));
                        addJugador(b);
                        c.println(b.getNombre() + ":" + b.getScore());
                    }
                }

            }

        }else {
            for (Datos b : this.TabladePuntajes.values()) {
                PrintStream c = new PrintStream(a);
                c.println(b.getNombre() + ":" + b.getScore());
            }
        }
    }

    public void addJugador(Datos Jugador) {
        if (!this.TabladePuntajes.containsKey(Jugador.getNombre())) {
            this.TabladePuntajes.put(Jugador.getNombre(), Jugador);
        } else if (this.TabladePuntajes.containsKey(Jugador.getNombre())) {
            this.TabladePuntajes.remove(Jugador.getNombre(), Jugador);
            this.TabladePuntajes.put(Jugador.getNombre(), Jugador);
        }
    }

}
