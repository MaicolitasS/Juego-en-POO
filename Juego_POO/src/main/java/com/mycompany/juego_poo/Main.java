package com.mycompany.juego_poo;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static boolean verificar(int[] puntajes) {
        for (int i = 0; i < puntajes.length; i++) {
            if (puntajes[i] >= 13) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();
        int cantJugadores = 0;

        boolean finDelJuego = false;

        do {
            System.out.println("Ingrese la cantidad de jugadores (Minimo 2): ");
            cantJugadores = entrada.nextInt();
            entrada.nextLine();
        } while (cantJugadores < 2);

        Jugador[] jugadores = new Jugador[cantJugadores];// array vacio de jugadores

        for (int i = 0; i < cantJugadores; i++) {
            System.out.println("Ingrese el nombre del jugador #" + (i + 1) + ":");// crea a los jugadores con nombre y puntaje inicial en cero
            String nom = entrada.nextLine();
            Jugador j = new Jugador(nom, 0);
            jugadores[i] = j;
        }
        System.out.println();

        Dado[] dados = new Dado[13]; // bolsa de dados vacia

        for (int i = 0; i < dados.length; i++) {
            if (i < 6) {
                DadoOro dadoO = new DadoOro();
                dados[i] = dadoO;
            } else {
                if (i < 10) {
                    DadoPlata dadoP = new DadoPlata();//llena la bolsa con cada tipo de dado y aqui utiliza la herencia
                    dados[i] = dadoP;
                } else {
                    DadoBronce dadoB = new DadoBronce();
                    dados[i] = dadoB;
                }
            }
        }

        do {
            for (int i = 0; i < cantJugadores; i++) {
                boolean conti = true;
                System.out.print("Puntajes: ");
                for (int j = 0; j < cantJugadores; j++) {
                    System.out.print(jugadores[j].getNombre() + " = " + jugadores[j].getPuntaje() + " ");//getters para consultar nombres y puntajes
                }
                System.out.println();
                System.out.println();
                System.out.println("Ahora es el turno de " + jugadores[i].getNombre());
                int calaveras = 0;//se valida la acumulacion de calaveras
                do {

                    String[] opciones = new String[3];
                    int[] posicionDados = new int[3];
                    System.out.println("Obteniendo los tres dados del cubo...");
                    System.out.println("Lanzando los tres dados...");
                    System.out.println();
                    for (int j = 0; j < 3; j++) {
                        int dadoRandom = random.nextInt(dados.length);
                        posicionDados[j] = dadoRandom;
                        int caraAleatoria = random.nextInt(5);

                        String valor = dados[dadoRandom].getCaras()[caraAleatoria];//agarra dado de la bolsa y utiliza el getcaras heredado para elegir una cara aleatoria
                        opciones[j] = valor;
                    }
                    int estrellas = 0;
                    int comodines = 0;

                    for (int j = 0; j < opciones.length; j++) {
                        if (opciones[j].equals("calavera")) {
                            calaveras++;
                        } else if (opciones[j].equals("estrella")) {
                            estrellas++;
                        } else if (opciones[j].equals("comodín")) {
                            comodines++;
                        }
                    }

                    //Dibujar caras con metodo de clase dado
                    dados[i].dibujoOpciones(opciones);

                    for (int j = 0; j < posicionDados.length; j++) {
                        if (posicionDados[j] <= 5) {
                            System.out.print("     Oro     ");
                        } else if (posicionDados[j] <= 9) {
                            System.out.print("     Plata     ");
                        } else {
                            System.out.print("     Bronce     ");
                        }
                    }
                    System.out.println();

                    System.out.println("Estrellas: " + estrellas + " Calaveras: " + calaveras);
                    System.out.println();

                    if (calaveras >= 3) {
                        jugadores[i].setPuntaje(0); // reinicia puntaje por las calaveras
                        conti = false;
                        break;
                    } else {
                        jugadores[i].setPuntaje(jugadores[i].getPuntaje() + estrellas);//suma puntaje de estrellas
                    }

                    if (jugadores[i].getPuntaje() >= 13) {//valida si el jugador gana
                        System.out.print("Puntajes: ");
                        for (int j = 0; j < cantJugadores; j++) {
                            System.out.print(jugadores[j].getNombre() + " = " + jugadores[j].getPuntaje() + " ");
                        }
                        System.out.println();
                        System.out.println(jugadores[i].getNombre() + " ha alcanzado o superado 13 puntos!");
                        System.out.println();
                        conti = false;
                        finDelJuego = true;
                        break;
                    }

                    String seguir = "";
                    while (!seguir.equals("s") && !seguir.equals("n")) {
                        System.out.println("¿" + jugadores[i].getNombre() + " quieres jugar de nuevo [S/N]?: ");
                        seguir = entrada.nextLine().toLowerCase();
                    }

                    if (seguir.equals("n")) {
                        conti = false;
                    }
                } while (conti);

                if (finDelJuego) {
                    break;
                }
            }
        } while (!finDelJuego);

        int ganador = 0;
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].getPuntaje() >= 13) {// selecciona el ganador segun su puntaje
                ganador = i;
                break;
            }
        }
        System.out.println("¡Ganó " + jugadores[ganador].getNombre());
        System.out.println("¡Gracias por jugar!");
    }
}

