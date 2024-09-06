package com.mycompany.juego_poo;

public class Dado {

    private String[] caras;

    public Dado(String[] caras) {
        this.caras = caras;
    }

    public String[] getCaras() {
        return caras;
    }

    public void dibujoOpciones(String[] opcs) {
        String[][] dibujoComodin = {{"+", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "+"},
        {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
        {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
        {"|", " ", " ", " ", " ", " ", "?", " ", " ", " ", " ", " ", "|"},
        {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
        {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
        {"+", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "+"}};

        String[][] dibujoCalavera = {{"+", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "+"},
        {"|", " ", " ", " ", " ", "_", "_", "_", " ", " ", " ", " ", "|"},
        {"|", " ", " ", " ", "/", " ", " ", " ", "\\", " ", " ", " ", "|"},
        {"|", " ", " ", "|", "(", ")", " ", "(", ")", "|", " ", " ", "|"},
        {"|", " ", " ", " ", "\\", " ", "^", " ", "/", " ", " ", " ", "|"},
        {"|", " ", " ", " ", " ", "V", "V", "V", " ", " ", " ", " ", "|"},
        {"+", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "+"}};

        String[][] dibujoEstrella = {{"+", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "+"},
        {"|", " ", " ", " ", " ", " ", ".", " ", " ", " ", " ", " ", "|"},
        {"|", " ", " ", " ", " ", ",", "0", ",", " ", " ", " ", " ", "|"},
        {"|", " ", "'", "o", "o", "0", "0", "0", "o", "o", "'", " ", "|"},
        {"|", " ", " ", " ", "'", "0", "0", "0", "'", " ", " ", " ", "|"},
        {"|", " ", " ", " ", "0", "'", " ", "'", "0", " ", " ", " ", "|"},
        {"+", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "+"}};

        for (int k = 0; k < dibujoCalavera.length; k++) {
            for (int j = 0; j < opcs.length; j++) {
                if (opcs[j].equals("calavera")) {
                    for (int l = 0; l < dibujoCalavera[k].length; l++) {
                        System.out.print(dibujoCalavera[k][l]);
                    }
                } else if (opcs[j].equals("estrella")) {
                    for (int l = 0; l < dibujoEstrella[k].length; l++) {
                        System.out.print(dibujoEstrella[k][l]);
                    }
                } else if (opcs[j].equals("comodín")) {
                    for (int l = 0; l < dibujoComodin[k].length; l++) {
                        System.out.print(dibujoComodin[k][l]);
                    }
                }
                System.out.print("  "); //
            }
            System.out.println(); //
        }
    }
}
