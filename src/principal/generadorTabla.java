
package principal;
import javax.swing.JTable;
public class generadorTabla {
public static void llenarVacios(JTable tablero) {
        for(int i=0;i<3;i++){
          int contador=0;
          while(contador<4){
          for(int j=0;j<9;j++){     
          int x=(int)(Math.random()*10);
           if(x<5){
               tablero.setValueAt("***", i,j);
               contador++;
                }
          if(contador==4){
                   break;}
          else{if ( j==8){
                   j=0;
                   limpiar(tablero,i);
                   contador=0;
              }
            }
          }
        }
    } 
}
    private static void limpiar(JTable tablero,int fila) {
            for (int j=0; j<9;j++){
        tablero.setValueAt(null,fila, j);
    }
    }
    public static void llenarNumeros(JTable tablero) {
        for(int i=0;i<3;i++){
          for(int j=0;j<9;j++){
          if(tablero.getValueAt(i,j)!="***"){              
          int x=obtenerNumero();
          String r=verificarRepetido(tablero,x,i,j);
               tablero.setValueAt(r,i,j);
            }
          }
        }
    }
    public static int obtenerNumero() {
        int res=(int)(Math.random()*90);
            if(res==0){
            res=obtenerNumero();
            }
        return res;
    }
    private static String verificarRepetido(JTable tablero,int x,int pos1,int pos2) {
        String res=String.valueOf(x);
        for(int i=0;i<=pos1;i++){
          for(int j=0;j<=pos2;j++){
            if(tablero.getValueAt(i,j)==res){ 
                if(pos1==i && pos2==j){
                    i=10;
                   break; 
                }
                else{
                verificarRepetido(tablero,obtenerNumero(),pos1,pos2);
                }   
            }
          }
        }
        return res;
    }
    public static void ordenarPosiciones(JTable tablero) {
        for (int i = 0; i <3; i++) {  
           ordenarFila(tablero,i);
        }
    }
    private static void ordenarFila(JTable tablero,int x){
        String izq,der,buffer;
        for (int i = 0; i < 9-1; i++) {
            if(tablero.getValueAt(x,i)!="***"){
            for (int j = i+1; j < 9; j++) {
                if(tablero.getValueAt(x,j)!="***"){
                izq=(String) tablero.getValueAt(x, i);
                der=(String)tablero.getValueAt(x, j);
                int numero = Integer.parseInt(izq);
                int numero2=Integer.parseInt(der);
                if(numero>numero2){
                    buffer=(String) tablero.getValueAt(x,j);
                    tablero.setValueAt(tablero.getValueAt(x,i),x,j);
                    tablero.setValueAt(buffer,x,i);
                }
                } 
            }
           }
        }
       
    }
}
