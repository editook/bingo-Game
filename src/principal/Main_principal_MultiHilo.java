
package principal;
public class Main_principal_MultiHilo {
   public static void main(String nomb,int dato) {
         if(dato==1){
        new juego(nomb).setVisible(true);
        }
        if(dato==2){
        new nuevo(nomb).setVisible(true);
        }
        if(dato==3){
        new mensajeGanador(nomb).setVisible(true);
        }
    }
    public static void main(String[]s) {
    RegistrarEditables();
    java.awt.EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
    new inicio().setVisible(true);
    }
    });
    }
private static void RegistrarEditables() {
     try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
}