package bingoPrueba;

public class Validador {
    public static int verificarCarton(String[][]tablero,String numer,
    int pos,int pos2) {
        int acierto=0;  
        if(tablero[pos] [pos2].equals(numer)){
            tablero[ pos][ pos2]=null;
             acierto = 1;
        }
        return acierto;
    }
}
