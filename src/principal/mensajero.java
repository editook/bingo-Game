
package principal;
import javax.swing.JOptionPane;
public class mensajero {
    public static void mesajeIncorrecto(String dato1) {
        JOptionPane.showMessageDialog(null,dato1+"  incorrecto mira el numero de la tombola: ");
    }
   public static void mentiroso() {
        JOptionPane.showMessageDialog(null,"MENTIROSO! el numero de aciertos debe ser 15");
    }
    public static void menu1() {
        JOptionPane.showMessageDialog(null,"prohibido ser copia no sirve");
    }
   public static void nombre(String name) {
        JOptionPane.showMessageDialog(null,name);
    }
   public static void correcto(String dato1) {
       JOptionPane.showMessageDialog(null,"   correcto :   "+dato1);
    }
    public static void nameIncorrecto() {
        JOptionPane.showMessageDialog(null,"nombre incorrecto");
    }
    public static void saludo(String nomb) {
        JOptionPane.showMessageDialog(null,"HOLA  "+nomb);
    }
   public static void perdiste() {
        JOptionPane.showMessageDialog(null,"acabas de terminar tus oportunidades PERDISTE JAJAJAJ xD");
    }
   public static void comoJugar() {
        JOptionPane.showMessageDialog(null,"genera tu carton aleatoriamnete para poder juegar el bingo\n en caso de que no te guste los numeros pon la opcion exit para volver\n a escojer el carton o salir del juego, gira la tombola para obtener numeros>0 y <=90, marca los numeros salientes\n debes acumular 15 ciertos y presionar bingo .en caso de que la tombola \n genere el doble de numeros de aciertos perderas automaticamente");
    }
}
