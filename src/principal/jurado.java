
package principal;
import javax.swing.JTable;
class jurado {
   public static boolean verificarMarcados(JTable tablero) {
       boolean bingo=false;
       int acierto=0;
        for(int i=0;i<3;i++){
          for(int j=0;j<9;j++){
           if(tablero.getValueAt(i,j).equals("X")){
            acierto++;}
          }   
        }
    if(acierto==15){
    bingo=true;}
    return bingo;
   }
    public static void pedisteFinalizadorTermino(int finalizador) {
        if(finalizador==25){
        mensajero.perdiste();
        System.exit(0);
        }
    }
    public static int eliminarRepetidosTombola(int numer, int tombolaDatos) {
        int res=numer;
        String valores=String.valueOf(tombolaDatos);
        for (int i = 0; i <valores.length(); i++) {
            char r=(char) numer;
            if (valores.charAt(i)==r) {
               int entrada= generadorTabla.obtenerNumero();
               res=eliminarRepetidosTombola(entrada,tombolaDatos);
               break;
            }
        }
        return res;
    }  
}
