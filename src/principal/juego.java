package principal;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.WindowConstants;
import javax.swing.border.*;
import javax.swing.table.*;

public class juego extends JFrame {

    private JTextField aciertos, contenedor, numero;
    private JButton bingo, carton, exit, mesclador;
    private JCheckBoxMenuItem obtenedorNombre, acercaJuergo, informacionPrograma;
    private JLabel tombola;
    private JMenu informacion, NameJugador, ComoJugar;
    private JMenuBar menuBar;
    private JScrollPane nombreColumnas;
    private JTable tablero;
    private int acierto, tombolaDatos, finalizador;
    private static String name;
    private URL url;

    public juego(String nombre) {
        name = nombre;
        configuracionesDefecto();
        componentsAlternativos();
    }

    private void configuracionesDefecto() {
        getContentPane().setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tombola = new JLabel();
        cartontext();
        bingoBtton();
        numeroText();
        tombolaGirador();
        contenedorTEXT();
        salirBtton();
        aciertosText();
        mescladorBottton();
        tableroTabla();
        barraMenu();
        pack();
    }

    private void componentsAlternativos() {
        datosDefault();
        url = getClass().getResource("imagenes/bola0.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(tombola.getWidth(), tombola.getHeight(), Image.SCALE_DEFAULT));
        tombola.setIcon(icono);
        this.repaint();
        aciertos.setText(aciertos.getText() + acierto);
        setSize(986, 688);
        setLocationRelativeTo(null);
    }

    private void datosDefault() {
        acierto = 0;
        finalizador = 0;
        tombolaDatos = 0;
    }

    private void tombolaGirador() {
        tombola.setBounds(640, 220, 280, 240);
        getContentPane().add(tombola);
        tombola.setEnabled(false);
    }

    private void cartontext() {
        carton = new JButton();
        carton.setBackground(new java.awt.Color(0, 153, 153));
        carton.setFont(new Font("OCR A Extended", 3, 18));
        carton.setText("comprar carton");
        carton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                cartonActionPerformed(evt);
            }
        });
        carton.setBounds(30, 100, 210, 40);
        getContentPane().add(carton);
    }

    private void bingoBtton() {
        bingo = new JButton();
        bingo.setBackground(new Color(0, 153, 153));
        bingo.setFont(new Font("OCR A Extended", 3, 18));
        bingo.setText("bingo");
        bingo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                bingoActionPerformed(evt);
            }
        });
        bingo.setBounds(30, 180, 210, 40);
        bingo.setEnabled(false);
        getContentPane().add(bingo);
    }

    private void numeroText() {
        numero = new JTextField();
        numero.setBackground(new Color(255, 255, 255));
        numero.setFont(new Font("OCR A Extended", 3, 24));
        numero.setForeground(new Color(0, 0, 0));
        numero.setHorizontalAlignment(JTextField.CENTER);
        numero.setBorder(null);
        numero.setBounds(750, 320, 60, 60);
        numero.setEditable(false);
        getContentPane().add(numero);
    }

    private void contenedorTEXT() {
        contenedor = new JTextField();
        contenedor.setBackground(new Color(0, 0, 0));
        contenedor.setFont(new Font("OCR A Extended", 1, 18));
        contenedor.setForeground(new Color(255, 255, 255));
        contenedor.setHorizontalAlignment(JTextField.TRAILING);
        contenedor.setBounds(0, 520, 970, 50);
        contenedor.setEditable(false);
        getContentPane().add(contenedor);
    }

    private void salirBtton() {
        exit = new JButton();
        exit.setBackground(new Color(0, 102, 102));
        exit.setText("EXIT");
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        exit.setBounds(880, 570, 80, 40);//posx,posy,tamx,tamy
        getContentPane().add(exit);
    }

    private void aciertosText() {
        aciertos = new JTextField();
        aciertos.setFont(new java.awt.Font("OCR A Extended", 3, 14));
        aciertos.setText("aciertos :");
        aciertos.setBounds(800, 80, 130, 50);
        aciertos.setEditable(false);
        getContentPane().add(aciertos);
    }

    private void mescladorBottton() {
        mesclador = new JButton();
        mesclador.setIcon(new ImageIcon(getClass().getResource("/principal/imagenes/Offline_status.png")));
        mesclador.setToolTipText("mesclador de tombola");
        mesclador.setBorder(null);
        mesclador.setBorderPainted(false);
        mesclador.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mesclador.setHorizontalTextPosition(SwingConstants.CENTER);
        mesclador.setInheritsPopupMenu(true);
        mesclador.setMargin(new Insets(0, 0, 0, 0));
        mesclador.setSelectedIcon(new ImageIcon(getClass().getResource("/principal/imagenes/Online_status.png"))); // NOI18N
        mesclador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mescladorActionPerformed(evt);
            }
        });
        mesclador.setBounds(380, 310, 120, 100);
        mesclador.setEnabled(false);
        getContentPane().add(mesclador);
    }

    private void tableroTabla() {
        tablero = new JTable();
        nombreColumnas = new JScrollPane();
        nombreColumnas.setFont(new Font("OCR A Extended", 3, 14));
        tablero.setBackground(new Color(0, 102, 102));
        tablero.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        tablero.setFont(new Font("OCR A Extended", 3, 14));
        tablero.setForeground(new Color(255, 255, 255));
        tablero.setModel(new DefaultTableModel(
                new Object[][]{//matriz
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null}},
                new String[]{
                    "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9"
                }
        ) {
            Class[] tipo = new Class[]{
                String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return tipo[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        TableroErramientas();
        nombreColumnas.setViewportView(tablero);
        inavalidarPosicionesTablero();
        nombreColumnas.setBounds(300, 70, 453, 90);
        getContentPane().add(nombreColumnas);
    }

    private void TableroErramientas() {
        tablero.setToolTipText("TABLERO DE BINGO");
        tablero.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        tablero.setGridColor(new Color(0, 0, 0));
        tablero.setSelectionBackground(new Color(102, 102, 255));
        tablero.setSelectionForeground(new Color(255, 153, 51));
        tablero.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablero.getTableHeader().setReorderingAllowed(false);
        tablero.addMouseListener(new MouseAdapter() {//la accion
            @Override
            public void mouseClicked(MouseEvent evt) {
                tableroMouseClicked(evt);
            }
        });
    }

    private void inavalidarPosicionesTablero() {
        if (tablero.getColumnModel().getColumnCount() > 0) {
            tablero.getColumnModel().getColumn(0).setResizable(false);
            tablero.getColumnModel().getColumn(1).setResizable(false);
            tablero.getColumnModel().getColumn(2).setResizable(false);
            tablero.getColumnModel().getColumn(3).setResizable(false);
            tablero.getColumnModel().getColumn(4).setResizable(false);
            tablero.getColumnModel().getColumn(5).setResizable(false);
            tablero.getColumnModel().getColumn(6).setResizable(false);
            tablero.getColumnModel().getColumn(7).setResizable(false);
            tablero.getColumnModel().getColumn(8).setResizable(false);
        }//invalidar posiciones de mover
    }

    private void barraMenu() {
        menuBar = new JMenuBar();
        informacion = new JMenu();
        ComoJugar = new JMenu();
        NameJugador = new JMenu();
        informacionPrograma = new JCheckBoxMenuItem();
        informacionPrograma = new JCheckBoxMenuItem();
        acercaJuergo = new JCheckBoxMenuItem();
        obtenedorNombre = new JCheckBoxMenuItem();
        informacion.setText("informacion");
        informacionPrograma.setSelected(true);
        informacionPrograma.setText("acerca del programa");
        informacionPrograma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                mensajeNocopiarActionPerformed(evt);
            }
        });
        informacion.add(informacionPrograma);
        menuBar.add(informacion);
        ComoJugar.setText("como jugar");
        acercaJuergo.setSelected(true);
        acercaJuergo.setText("acerca del juego");
        acercaJuergo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                aprenderActionPerformed(evt);
            }
        });
        ComoJugar.add(acercaJuergo);
        menuBar.add(ComoJugar);
        NameJugador.setText("nombre del jugador");
        obtenedorNombre.setSelected(true);
        obtenedorNombre.setText("obtener nombre");
        obtenedorNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                nombreJugadorActionPerformed(evt);
            }
        });
        NameJugador.add(obtenedorNombre);
        menuBar.add(NameJugador);
        setJMenuBar(menuBar);
    }
    //metodos accesadores

    private void cartonActionPerformed(ActionEvent evt) {
        carton.setEnabled(false);
        tombola.setEnabled(true);
        generarTabla();
        bingo.setEnabled(true);
        mesclador.setEnabled(true);
    }

    private void generarTabla() {
        generadorTabla.llenarVacios(tablero);
        generadorTabla.llenarNumeros(tablero);
        generadorTabla.ordenarPosiciones(tablero);
    }

    private void exitMouseClicked(MouseEvent evt) {
        nuevo n = new nuevo(name);
        dispose();
        n.setVisible(true);
    }

    private void mescladorActionPerformed(ActionEvent evt) {
        Hilo imagen = new Hilo();
        HiloSonido sonidoAranque = new HiloSonido();
        sonidoAranque.start();
        imagen.start();
    }

    private void tableroMouseClicked(MouseEvent evt) {
        int pos = tablero.getSelectedRow();
        int pos2 = tablero.getSelectedColumn();
        TableModel model = tablero.getModel();
        if (!tablero.getValueAt(pos, pos2).equals("***") || !tablero.getValueAt(pos, pos2).equals("X")) {
            int valor = Integer.parseInt(model.getValueAt(pos, pos2).toString());
            String dato1 = String.valueOf(valor);
            if (dato1.equals(numero.getText())) {
                String numer = numero.getText();
                acierto = acierto + valilador.verificarCarton(tablero, numer, pos, pos2);
                aciertos.setText("aciertos : " + acierto);
                HiloSonido hilo = new HiloSonido();
                hilo.ruidito();
                mensajero.correcto(dato1);
            } else {
                mensajero.mesajeIncorrecto(dato1);
            }
        }
        aciertos.setText("aciertos : " + acierto);
    }

    private void bingoActionPerformed(ActionEvent evt) {
        boolean ganador = jurado.verificarMarcados(tablero);
        if (ganador == true) {

            Main_principal_MultiHilo.main(name, 2);
            dispose();
        } else {
            mensajero.mentiroso();
        }
    }

    private void nombreJugadorActionPerformed(java.awt.event.ActionEvent evt) {
        mensajero.nombre(name);
    }

    private void aprenderActionPerformed(ActionEvent evt) {
        mensajero.comoJugar();
    }

    private void mensajeNocopiarActionPerformed(ActionEvent evt) {
        mensajero.menu1();
    }

    public class Hilo extends Thread {

        URL f;

        @Override
        public void run() {
            startRun();
        }

        private void startRun() {
            int t = 1;
            int bola, numer = 0;
            mesclador.setEnabled(false);
            for (int T = 0; T < 5; T++) {
                t = t + 50;
                for (int i = 0; i < 10; i++) {
                    bola = (int) (Math.random() * 13);
                    operacionesRotaje(bola, numer, t);
                }
            }
            contenedor.setText(contenedor.getText() + " " + numero.getText());
            finalizador++;
            jurado.pedisteFinalizadorTermino(finalizador);
            mesclador.setEnabled(true);
        }

        private void operacionesRotaje(int bola, int numer, int t) {
            try {
                numer = generadorTabla.obtenerNumero();
                tombolaDatos = tombolaDatos * 10 + numer;
                numer = jurado.eliminarRepetidosTombola(numer, tombolaDatos);
                posicionadorImagen(bola);
                numero.setText(String.valueOf(numer));
                Thread.sleep(t);
            } catch (InterruptedException ex) {
                Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private void posicionadorImagen(int bola) {
            f = getClass().getResource("imagenes/bola" + bola + ".png");
            ImageIcon imagen = new ImageIcon(f);
            Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(tombola.getWidth(), tombola.getHeight(), Image.SCALE_DEFAULT));
            tombola.setIcon(icono);
            repaint();
        }
    }

    public class HiloSonido extends Thread {

        sonido sun = new sonido();

        @Override
        public void run() {
            tocarSonido();
        }

        public void ruidito() {
            try {
                sun.moneditaSonido();
            } catch (IOException ex) {
                Logger.getLogger(HiloSonido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private void tocarSonido() {
            try {
                sun.ruidillo();
            } catch (IOException ex) {
                Logger.getLogger(HiloSonido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
