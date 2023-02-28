package Ordenamiento1.TareaColeccionLinkedList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.Iterator;
import java.util.LinkedList;

public class LenguajesDeProgramacionMenu extends JFrame {
    DefaultListModel modelo = new DefaultListModel();
    static LinkedList<String> listaLenguajes = new LinkedList<>();
    private JList<String> jListProgramas;
    private JLabel lblSalir;
    private JLabel lblMinimizar;
    private JLabel lblTitulo;
    private JLabel lblLogo;
    private JLabel lblDesarrollador;
    private JButton btnAgregar;
    private JButton btnAgregarFinal;
    private JButton btnAgregarPrincipio;
    private JButton btnEliminarElemento;
    private Point mouseDownCompCoords = null;
    JPanel panelSuperior;
    JPanel panelBotones;
    JPanel panelLogo;
    JPanel panelParteInferior;
    JPanel panelPieApp;


    public void llenarLinkedListLenguajes(){
        modelo.removeAllElements();
        for (int i = 0; i < listaLenguajes.size(); i++) {
            modelo.addElement(listaLenguajes.get(i));
        }
    }

    public LenguajesDeProgramacionMenu() throws HeadlessException {
        listaLenguajes.add("Rust");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 600);
        this.setUndecorated(true);
        this.setShape(new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 19, 19));
        this.setBackground(new Color(143, 24, 77, 200));
        setLayout(null);
        initComponents();
        llenarLinkedListLenguajes();
    }

    private void initComponents() {
        lblSalir=new JLabel();
        lblMinimizar=new JLabel();
        lblTitulo = new JLabel("Lenguajes de programación 2023");
        this.getContentPane().setLayout(null);
        panelSuperior = new JPanel();
        panelSuperior.setLayout(null);
        panelSuperior.setBounds(-5,0,408,30);
        panelSuperior.setOpaque(true);
        panelSuperior.setBackground(new Color(255,255,255,80));
        panelSuperior.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords = e.getPoint();
            }
        });
        panelSuperior.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
            }
        });
        getContentPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        //Agregar boton de salida
        ImageIcon iconorojo = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("rojo.png")).getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        lblSalir.setBounds(370,0,30,30);
        lblSalir.setIcon(iconorojo);
        lblSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        //Agregar boton de minimizar
        ImageIcon iconoAmarillo = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Yellow.png")).getScaledInstance(20, 23, Image.SCALE_SMOOTH));
        lblMinimizar.setBounds(340,0,30,30);
        lblMinimizar.setIcon(iconoAmarillo);
        lblMinimizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(lblMinimizar);
                frame.setExtendedState(JFrame.ICONIFIED);
            }
        });

        //Agregar Lbl de titulo de ventana
        lblTitulo.setFont(new Font("Roboto Medium",Font.PLAIN,15));
        lblTitulo.setBounds(15,5,250,20);
        //Agregar Panel para contener Logo
        panelLogo = new JPanel();
        panelLogo.setBounds(0,35,400,150);
        panelLogo.setBackground(new Color(143, 24, 77, 200));
            //Imagen del logo
        ImageIcon logoRusty = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Rustyy.png")).getScaledInstance(200,150,Image.SCALE_SMOOTH));
        lblLogo = new JLabel();
        lblLogo.setIcon(logoRusty);
        //Agregar panel contenedor de botones
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4,1,20,10));
        panelBotones.setBounds(0,190,400,200);
        panelBotones.setBackground(new Color(143, 24, 77, 200));

        //Panel para mostrar Tabla
            //Cargamos Jlist para subir a la Tabla
        jListProgramas = new JList<>();
        jListProgramas.setPreferredSize(new Dimension(300,60));
        jListProgramas.setVisibleRowCount(9);
        jListProgramas.setModel(modelo);
        //Panel para tabla
        panelParteInferior = new JPanel();
        panelParteInferior.setBounds(0,400,400,183);
        panelParteInferior.setBackground(new Color(255,189,120));
        //Anadimos JScrollPane
        panelParteInferior.add(add(new JScrollPane(jListProgramas)));

        //Pie de pagina de la App
        panelPieApp = new JPanel();
        panelPieApp.setBounds(0,583,400,17);
        panelPieApp.setOpaque(true);
        panelPieApp.setBackground(new Color(143, 24, 77, 200));
        lblDesarrollador=new JLabel("Desarrollado por Orion-Black® (Jesús González Becerril)");
        lblDesarrollador.setForeground(Color.white);
        lblDesarrollador.setFont(new Font("Roboto regular",Font.PLAIN,10));

        btnAgregar=new RoundButton("Agregar lenguaje");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String lenguaje = JOptionPane.showInputDialog(null,"Escribe el lenguaje de programacion","Agregar al LinkedList",JOptionPane.QUESTION_MESSAGE);
                if (lenguaje.equals("")||lenguaje.equals(" ")||lenguaje==null){
                    return;
                }
                listaLenguajes.add(lenguaje);
                llenarLinkedListLenguajes();
            }
        });
        btnAgregarPrincipio=new RoundButton("Agregar lenguaje al principio");
        btnAgregarPrincipio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String lenguaje = JOptionPane.showInputDialog(null,"Escribe el lenguaje de programacion","Agregar al principio",JOptionPane.QUESTION_MESSAGE);
                if (lenguaje.equals("")||lenguaje.equals(" ")||lenguaje==null){
                    return;
                }
                listaLenguajes.addFirst(lenguaje);
                llenarLinkedListLenguajes();
            }
        });
        btnAgregarFinal=new RoundButton("Agregar lenguaje al final");
        btnAgregarFinal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String lenguaje = JOptionPane.showInputDialog(null,"Escribe el lenguaje de programacion","Agregar al final",JOptionPane.QUESTION_MESSAGE);
                if (lenguaje.equals("")||lenguaje.equals(" ")||lenguaje==null){
                    return;
                }
                listaLenguajes.addLast(lenguaje);
                llenarLinkedListLenguajes();
            }
        });
        btnEliminarElemento = new RoundButton("Eliminar elemento por nombre");
        btnEliminarElemento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String lenguaje = JOptionPane.showInputDialog(null,"Escribe el lenguaje a borrar","Borrar Elemento",JOptionPane.ERROR_MESSAGE);
                Boolean encontrado = false;
                if (lenguaje.equals("")||lenguaje.equals(" ")||lenguaje==null){
                    return;
                }
                Iterator<String> iterador = listaLenguajes.iterator();
                while (iterador.hasNext()){
                    if (lenguaje.equals(iterador.next())){
                        iterador.remove();
                        encontrado=true;
                        JOptionPane.showMessageDialog(null, "Lenguaje eliminado");
                    }
                }
                if (!encontrado){
                    JOptionPane.showMessageDialog(null,"No se encontro el elemento");
                }
                llenarLinkedListLenguajes();
            }
        });

        panelBotones.add(btnAgregar);
        panelBotones.add(btnAgregarFinal);
        panelBotones.add(btnAgregarPrincipio);
        panelBotones.add(btnEliminarElemento);

        panelLogo.add(lblLogo);

        panelSuperior.add(lblSalir);
        panelSuperior.add(lblMinimizar);
        panelSuperior.add(lblTitulo);

        panelPieApp.add(lblDesarrollador);
        getContentPane().add(panelSuperior);
        getContentPane().add(panelLogo);
        getContentPane().add(panelBotones);
        getContentPane().add(panelParteInferior);
        getContentPane().add(panelPieApp);


    }
    public static void main(String[] args) {
        LenguajesDeProgramacionMenu g1 = new LenguajesDeProgramacionMenu();
        g1.setVisible(true);
    }
    private static void mostrarLista(LinkedList<String> lista) {
        System.out.printf("%nLista de lenguajes de programacion: %n");
        for (String lenguaje : lista) {
            System.out.println("-" + lenguaje);
        }
    }
}
