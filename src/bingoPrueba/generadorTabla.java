
package bingoPrueba;

public class generadorTabla {
     private int acierto;
    public generadorTabla(){
        acierto=0;
    }
  public void  llenarVacios(String carton[][]){ 
      for(int i=0;i<3;i++){
          int contador=0;
          while(contador<4){
          for(int j=0;j<9;j++){     
          int x=(int)(Math.random()*10);
           if(x<5){
               carton[i][j]="***";
               contador++;
                }
          if(contador==4){
                   break;}
          else{if ( j==8){
                   j=0;
                   limpiar(carton,i);
                   contador=0;
              }
           }
          }
          }
        }   
    
}

    private void limpiar (String carton[][], int fila){
    for (int j=0; j<9;j++){
        carton [fila][j]=null;
    }
    }

public void llenarNumeros(String [][]carton) {
      
        for(int i=0;i<3;i++){
          for(int j=0;j<9;j++){
            if(carton [i][j]==null){              
                
                int x=obtenerNumero();
                //String valor=String.valueOf(x);
               String valor=verificarRepetido(carton,x,i,j);
                    carton[i][j]=String.valueOf(x);
             
            }
      
          }
        }
    }

    public int obtenerNumero() {
       int x=(int)(Math.random()*90);
       if(x==0){
      x= obtenerNumero();
       }
       return x;
    }

    private String verificarRepetido(String[][]tablero,int x,int pos1,int pos2) {
        
        String res=String.valueOf(x);
        for(int i=pos1-1;i>=0;i--){
          for(int j=pos2-1;j>=0;j--){
            if(tablero[i][j].equals(res)){ 
                int numer=obtenerNumero();
                res=String.valueOf(numer);
                verificarRepetido(tablero,numer,pos1,pos2);
                break;
            }
          }
        }
        return res;
    }
    public int contadorAsterisco (String[][] carton){
        int c=0;
        for (int i=0;i<3; i++){
            for (int j=0;j<9;j++){
               if (carton [i][j]=="***"){
                   c++;
                }
            }
        }
        return c;
    }
    public int contadornumeros(String[][]carton){
        int c=0;
        for (int i=0;i<3; i++){
            for (int j=0;j<9;j++){
               if (!"***".equals(carton [i][j])){
                   int a=Integer.parseInt(carton[i][j]);
                   if(a>0&&a<91){
                   c++;
                   }
                }
            }
        }
        return c;
    }
    public int detectaRepetidos (String [][]prueba){
        int c=0;
        for (int i=0;i<3; i++){
            for (int j=0;j<9;j++){
                if (!"***".equals(prueba[i][j])){     
                     String a=prueba[i][j];
                     for(int t=0;t<3;t++){
                         for(int h=0;h<9;h++){                     
                            if(a==prueba[t][h]){
                                c++;
                            }
                         }
                     }
                }
            }
            
        }
        return c;
    }
}