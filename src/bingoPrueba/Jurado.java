
package bingoPrueba;
public class Jurado {
    public static boolean verificarMarcados(String [][] tabla) {
       boolean bingo=false;
       int acierto=0;
        for(int i=0;i<3;i++){
          for(int j=0;j<9;j++){
           if(tabla[i][j]=="X"){
                acierto++;  
           }
          }   
        }
    if(acierto==15){
    bingo=true;
    }
    return bingo;
   }

    

    public static int eliminarRepetidos(int numer, int tombolaDatos) {
        int res=numer;
        String valores=String.valueOf(tombolaDatos);
        for (int i = 0; i <valores.length(); i++) {
            char r=(char) numer;
            if (valores.charAt(i)==r) {
                generadorTabla p1=new generadorTabla();
               int entrada=p1.obtenerNumero();
               res=eliminarRepetidos(entrada,tombolaDatos);
               break;
            }
        }
        
        return res;
    }
   
    
}
