
package principal;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
public class mensajeGanador extends JFrame {
    private static String name;
    private JLabel mensaje;
    private JButton jugar,salir;
    public mensajeGanador(String nombre) {
        name=nombre;
        configuraciones();  
    }                       
    private void configuraciones() {
        getContentPane().setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        salirBtton();
        botonJugar();
        fondoMensaje();
        pack();
        setSize(359,200);
        setLocationRelativeTo(null);
    }   
    private void salirBtton() {
    salir = new JButton();
    salir.setText("salir");
        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });
        salir.setBounds(50, 70, 110, 25);
    getContentPane().add(salir);}
    private void botonJugar() {
    jugar = new JButton();
    jugar.setText("continuar");
        jugar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                jugarMouseClicked(evt);
            }
        });
        jugar.setBounds(210, 70, 79, 25);
    getContentPane().add(jugar);}
    private void fondoMensaje() {
    mensaje = new JLabel();
    mensaje.setFont(new Font("OCR A Extended", 3, 14)); 
    mensaje.setText("ganaste el bingo !!!!!!!!!");
    mensaje.setBounds(50, 20, 280, 34);
    getContentPane().add(mensaje);}
    private void salirMouseClicked(MouseEvent evt) {                                   
        System.exit(0);
    }                                  
    private void jugarMouseClicked(MouseEvent evt) {                                   
    Main_principal_MultiHilo.main(name, 1);
    dispose();
    }                                                               
}
