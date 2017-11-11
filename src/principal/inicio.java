
package principal;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.logging.*;
import javax.swing.*;
public class inicio extends JFrame{
    private static String nomb;
    private JButton salir,empesarJuego;
    private JLabel textNombre,fondos,cargador;
    private JTextField nameTextArea;//aqui se escribe
    public inicio() {        
        configuraciones();  
    }
    private void configuraciones() {
        getContentPane().setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game Bingo");
        modeloDeMaus();
        nombreText();
        nameEreaText();
        fondos();
        salirBtoon();
        empesarJuegoBtton();
        cargadorBarra();
        pack();
        setSize(490,380);
        setLocationRelativeTo(null);
    }  
    private void modeloDeMaus() {
       setCursor(new Cursor(Cursor.HAND_CURSOR));//tipo de cursor 
    }
    private void nameEreaText() {
    nameTextArea = new JTextField();
    nameTextArea.setBounds(140, 140, 160, 30);
    getContentPane().add(nameTextArea);}

    private void cargadorBarra() {
    cargador = new JLabel();
    cargador.setBounds(10, 280, 440, 40);
    getContentPane().add(cargador);}
    private void nombreText() {
    textNombre= new JLabel();
    textNombre.setText("NOMBRE : ");
    textNombre.setBounds(80, 130, 70, 40);
    getContentPane().add(textNombre);}
    private void fondos() {
        for (int i = 0; i < 2; i++) {
            fondos = new JLabel(); 
            fondos.setIcon(new ImageIcon(getClass().getResource("/principal/imagenes/fondo"+i+".png"))); 
            if(i==0){fondos.setBounds(70, 40, 90, 70); 
            }
            else{fondos.setBounds(300, 40, 90, 70);}
            getContentPane().add(fondos);
        }
    }
    private void empesarJuegoBtton() {
    empesarJuego = new JButton();
    empesarJuego.setFont(new java.awt.Font("OCR A Extended", 3, 14)); // NOI18N
    empesarJuego.setText("Empesar juego");
    empesarJuego.addMouseListener(new MouseAdapter() {
    @Override
     public void mouseClicked(MouseEvent evt) {
     entrarMouseClicked(evt);}
     });
     empesarJuego.setBounds(100, 210, 170, 25);
     getContentPane().add(empesarJuego);}
    private void salirBtoon() {
    salir = new JButton();
    salir.setFont(new Font("OCR A Extended", 1, 14));
        salir.setText("salir");
        salir.addMouseListener(new MouseAdapter() {
            @Override//sobre escritura sobre carga de metodo
            public void mouseClicked(MouseEvent evt) {
                salidaMouseClicked(evt);
            }
        });
    salir.setBounds(290, 210, 100, 30);
    getContentPane().add(salir);}
    private void salidaMouseClicked(MouseEvent evt) {                                      
    System.exit(0);
    }                           
    private void entrarMouseClicked(MouseEvent evt) {                                      
       String nombre=nameTextArea.getText();
       if(valido(nombre)){
        Hilo h=new Hilo();
        nomb=nombre;
        h.start();   
       }
       else{ mensajero.nameIncorrecto();}
    }                                                 
    private boolean valido(String nombre) {
       boolean res=true;
       char letra;
       if(nombre.length()>0){
        for (int i = 0; i < nombre.length(); i++) {
            letra=nombre.charAt(i);
            if(letra>='a' && letra<='z' || letra>='A' && letra<='Z'){
            }
            else{
            res=false;
            break; 
           }
        }
       }
       else{
        res=false;
       }
        return res;
    }
    
    private class Hilo extends Thread{
        URL f; 
        @Override
    public void run(){
        cargando();
    }
    private void cargandoImagen(int i) {
        f=getClass().getResource("imagenes/cargando"+i+".png");
        ImageIcon imagen = new ImageIcon(f);
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(cargador.getWidth(), cargador.getHeight(), Image.SCALE_DEFAULT));
        cargador.setIcon(icono);
        repaint();
    }
    private void cargando() {
        for (int i = 0; i < 6; i++) {
            try {
                cargandoImagen(i);
                Thread.sleep(100);
            } catch (InterruptedException ex) {Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);}
        }
        mensajero.saludo(nomb);
        Main_principal_MultiHilo.main(nomb,1);
        dispose();}
    }
}
