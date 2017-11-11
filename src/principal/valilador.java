
package principal;
import javax.swing.JTable;
class valilador {
    public static int verificarCarton(JTable tablero, String numer, int pos, int pos2) {
        int acierto=0;  
        if(tablero.getValueAt(pos, pos2).equals(numer)){
            tablero.setValueAt("X", pos, pos2);
             acierto = 1;
        }
        return acierto;
    }
}
