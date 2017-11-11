
package principal;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
public class nuevo extends JFrame {
    private static String name;
    private JLabel fondoImagen,msjSalir ;
    private JButton jugar,salir;
    public nuevo(String nombre) {
        name=nombre;
        initComponents();
    }                    
    private void initComponents() {
        getContentPane().setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jugarBtton();
        salirBtton();
        mensajeSlairTEXt();
        fonfoLabel();
        pack();
        setSize(400,200);
        setLocationRelativeTo(null);
    }   
    private void fonfoLabel() {
    fondoImagen= new JLabel();
    fondoImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/principal/imagenes/Setting_3.png")));
    fondoImagen.setBounds(0, 0, 360, 120);
    getContentPane().add(fondoImagen);}                                          
    private void jugarBtton() {
    jugar= new JButton();
    jugar.setText("volver a jugar");
        jugar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                jugarMouseClicked(evt);
            }
        });
        jugar.setBounds(210, 70, 130,30);
    getContentPane().add(jugar);}
    private void salirBtton() {
    salir = new JButton();
   salir.setText("si");
        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });
        salir.setBounds(80, 70, 110, 30);
    getContentPane().add(salir);}
    private void mensajeSlairTEXt() {
    msjSalir = new JLabel();
    msjSalir.setFont(new Font("OCR A Extended", 3, 14)); 
    msjSalir.setText("estas seguro que deseas salir?");
    msjSalir.setBounds(50, 20, 280, 34);
    getContentPane().add(msjSalir); }
    private void jugarMouseClicked(MouseEvent evt) {                                   
        Main_principal_MultiHilo.main(name, 1);
        dispose();
    }
    private void salirMouseClicked(MouseEvent evt) {                                   
      System.exit(0);
    } 

}
