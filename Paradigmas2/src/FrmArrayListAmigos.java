import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

public class FrmArrayListAmigos extends JFrame {
    DefaultListModel modelo = new DefaultListModel();
    ArrayList<String> listaVideojuegos = new ArrayList<>();

    public FrmArrayListAmigos() {
        initComponents();
        listaVideojuegos.add("Mario Bros");
        listaVideojuegos.add("Tetris");
        listaVideojuegos.add("Minecraft");
        listaVideojuegos.add("GTA V");
        listaVideojuegos.add("Fornite");
        listaVideojuegos.add("The legend of zelda");
        listaVideojuegos.add("Call of duty");
        listaVideojuegos.add("Pac/man");
        listaVideojuegos.add("Warcraft");
        listaVideojuegos.add("Resident Evil");
        llenarJListVideojuegos();
    }
    public void llenarJListVideojuegos(){
        modelo.removeAllElements();
        for (int i = 0; i < listaVideojuegos.size(); i++) {
            modelo.addElement(listaVideojuegos.get(i));
        }
    }
    private void initComponents(){
        lblSalir = new JLabel();
        lblMinimizar = new JLabel();
        lblTitulo = new JLabel();
        panelSuperior = new JPanel();

        //Caracteristicas de la ventana

        getContentPane().setBackground(new Color(255,189,89));
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 19, 19));
        //leer imagen para etiqueta
        ImageIcon iconoVideojuegos = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("titulo.png")).getScaledInstance(600, 190, Image.SCALE_SMOOTH));
        //Establacer un layout de 2 renglones y una columna
        setLayout(null);
        //Agregar boton de salir
        ImageIcon iconorojo = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("rojo.png")).getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        lblSalir.setBounds(570,0,30,30);
        lblSalir.setIcon(iconorojo);
        lblSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        //Agregar boton de minimizar
        ImageIcon iconoVerde = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("amarillo.png")).getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        lblMinimizar.setBounds(540,0,30,30);
        lblMinimizar.setIcon(iconoVerde);
        lblMinimizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(lblMinimizar);
                frame.setExtendedState(JFrame.ICONIFIED);
            }
        });




        lblTitulo.setBounds(0,30,600,150);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setIcon(iconoVideojuegos);

        panelSuperior.setBounds(0,0,600,30);
        panelSuperior.setLayout(null);
        panelSuperior.setBackground(new Color(241, 241, 241));
        panelSuperior.add(lblSalir);
        panelSuperior.add(lblMinimizar);
        add(panelSuperior);
        add(lblTitulo);

        JListVideojuegos = new JList<>();
        JListVideojuegos.setPreferredSize(new Dimension(300,60));
        JListVideojuegos.setVisibleRowCount(5);
        JListVideojuegos.setModel(modelo);

        panelParteInferior = new JPanel();
        panelParteInferior.setBounds(0,180,600,220);
        panelParteInferior.setBackground(new Color(255,189,89));
        panelParteInferior.setLayout(new GridLayout(1,2,20,20));
        add(panelParteInferior);
        panelParteInferior.add(add(new JScrollPane(JListVideojuegos)));

        //Panel donde se colocan botones
        panelBotones = new JPanel();
        panelBotones.setBackground(new Color(255,189,89));
        panelBotones.setLayout(new GridLayout(3,1,10,10));
        panelParteInferior.add(panelBotones);

        //Se establecen botones y se anaden al panel
        btnAgregar = new JButton("Agregar videojuego");
        btnBuscar = new JButton("Buscar videojuego");
        btnBorrar = new JButton("Borrar videojuego");
        JButton[] botonesPanel = {btnAgregar,btnBuscar,btnBorrar};
        propiedadesBotones(botonesPanel);


        //Eventos
        btnAgregar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnAgregarActionPerfomed(e);
                    }
                }
        );
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBorrarActionPerfomed(e);
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBuscarActionPerfomed(e);
            }
        });

        panelBotones.add(btnAgregar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnBorrar);

    }
    //Lista de eventos
    public void btnAgregarActionPerfomed(ActionEvent event){
        String nombreVideojuego = JOptionPane.showInputDialog("Escribe el nombre del videojuego");
        if (nombreVideojuego.equals("")||nombreVideojuego.equals(" ")||nombreVideojuego==null){
            return;
        }
        listaVideojuegos.add(nombreVideojuego);
        llenarJListVideojuegos();
    }
    public void btnBuscarActionPerfomed(ActionEvent event){
        String nombreVideojuego = JOptionPane.showInputDialog("Escribe el nombre del videojuego para buscar");
        if (nombreVideojuego.equals("")||nombreVideojuego.equals(" ")||nombreVideojuego==null){
            return;
        }
        if (listaVideojuegos.contains(nombreVideojuego)){
            JOptionPane.showMessageDialog(this,"Videojuego encontrado");
        }else {
            JOptionPane.showMessageDialog(this, "No se encontro el videojuego");
        }
    }
    public void btnBorrarActionPerfomed(ActionEvent event){
        String nombreVideojuego = JOptionPane.showInputDialog("Escribe el videojuego a borrar");
        Boolean encontrado = false;
        if (nombreVideojuego.equals("")||nombreVideojuego.equals(" ")||nombreVideojuego==null){
            return;
        }
        Iterator<String> iterador = listaVideojuegos.iterator();
        while (iterador.hasNext()){
            if (nombreVideojuego.equals(iterador.next())){
                iterador.remove();
                encontrado=true;
                JOptionPane.showMessageDialog(this, "Videojuego eliminado");
            }
        }
        if (!encontrado){
            JOptionPane.showMessageDialog(this,"No se encontro el elemento");
        }
        llenarJListVideojuegos();
    }
    //Aplicar propiedadas a botones
    public void propiedadesBotones (JButton[] botones){
        for (JButton boton:botones) {
            boton.setBackground(new Color(250, 157, 39));
            boton.setFocusPainted(false);
            boton.setFocusable(false);
            //boton.setForeground(Color.lightGray);
            //boton.setBorderPainted(false);
            // Agregar el MouseListener al botón
            boton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    // El cursor ha entrado en el área del botón
                    boton.setBorder(BorderFactory.createLineBorder(Color.RED));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // El cursor ha salido del área del botón
                    boton.setBorder(UIManager.getBorder("Button.border"));
                }
            });
        }
    }

    public static void main(String[] args) {
        new FrmArrayListAmigos().setVisible(true);
    }

    //Se declaran los controles que llevara el formulario
    private JList<String> JListVideojuegos;
    private JLabel lblSalir;
    private JLabel lblMinimizar;
    private JLabel lblTitulo;
    private JButton btnAgregar;
    private JButton btnBuscar;
    private JButton btnBorrar;
    JPanel panelSuperior;
    JPanel panelBotones;
    JPanel panelParteInferior;
}