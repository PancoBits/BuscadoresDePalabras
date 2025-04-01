package Interfaz;

import java.awt.*;
import java.awt.event.*;
import java.applet.AudioClip;
import java.net.URL;
import java.util.Arrays;
import javax.swing.*;
import java.awt.Cursor;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 * Clase Ventana que me genera todo el apartado gráfico
 *
 * @author Franco Rodríguez & Yoserth Camacho
 */
public class Ventana extends JFrame {

    /**
     * Panel donde esta se piden los nombres, el botón de reglas y el botón de
     * iniciar juego
     */
    public JPanel IngresoNombres;
    /**
     * Muestra el texto cambiante del nombre 1
     */
    public JLabel Nombre1;
    /**
     * Muestra el texto cambiante del nombre 2
     */
    public JLabel Nombre2;
    /**
     * Se guarda el nombre del Jugador 1
     */
    public JTextField Jugador1;
    /**
     * Se guarda el nombre del Jugador 2
     */
    public JTextField Jugador2;
    /**
     * Responsable de darle inicio al juego
     */
    public JButton Inicio;
    /**
     * Responsable de mostrar el Panel de Reglas
     */
    public JButton Reglas;
    /**
     * Panel donde se muestra las Reglas y los créditos del Proyecto
     */
    public JPanel Instrucciones;
    /**
     * Responsable de volver al Panel de Pedir los Nombres
     */
    public JButton Flecha;
    /**
     * Matriz donde están todas las casillas de la sopa de letras
     */
    public JLabel[][] labels;
    /**
     * Tiempo restante de cada turno
     */
    public int tiempo = 30;
    /**
     * Nombre del jugador actual
     */
    public String Player = "";
    /**
     * Numero de jugadas de la partida
     */
    public int Jugadas = 0;
    /**
     * Numero del turno actual
     */
    public int Cambio = 0;
    /**
     * Panel donde esta todos los elementos de la sopa de letra
     */
    public JPanel Todo;
    /**
     * Label donde se muestra el Nombre del jugador actual
     */
    public JLabel JugadorActual = new JLabel();
    /**
     * Almacena el texto cambiante de Letras a buscar
     */
    public JLabel BuscarPalabras = new JLabel();
    /**
     * Almacena el texto cambiante de la puntuación del jugador 1
     */
    public JLabel Punt1 = new JLabel();
    /**
     * Almacena el texto cambiante de la puntuación del jugador 2
     */
    public JLabel Punt2 = new JLabel();
    /**
     * Es el responsable de la duración de los turnos
     */
    public Timer timer;
    /**
     * Comprueba si se esta presionando el mouse
     */
    public boolean mover = false;
    /**
     * La Primera posición de la fila que se marca
     */
    public int PosicionInicialR = 0;
    /**
     * La Primera posición de la columna que se marca
     */
    public int PosicionInicialC = 0;
    /**
     * La ultima posición de la fila cuando se deja de presionar el mouse
     */
    public int PosicionFinalR = 0;
    /**
     * La ultima posición de la columna cuando se deja de presionar el mouse
     */
    public int PosicionFinalC = 0;
    /**
     * Palabra seleccionada
     */
    public String palabra = "";
    /**
     * Palabras encontradas por el jugador 1
     */
    public int PuntosJug1 = 0;
    /**
     * Palabras encontradas por el jugador 2
     */
    public int PuntosJug2 = 0;
    /**
     * Cantidad de letras de las Palabras encontradas por el jugador 1
     */
    public int PuntosLetrasJug1 = 0;
    /**
     * Cantidad de letras de las Palabras encontradas por el jugador 1
     */
    public int PuntosLetrasJug2 = 0;
    /**
     * Responsable de indicar cuantas palabras se han encontrado
     */
    public int PalabrasEncontradas = 0;
    /**
     * Almacena el texto cambiante del tiempo restante del turno
     */
    public JLabel tiempoLabel = new JLabel("00:30");
    /**
     * Almacena la lista de las palabras a buscar
     */
    public JLabel ListaPalabras[];
    /**
     * Responsable de indicar cuando el tiempo finaliza o se pausa
     */
    public boolean FinTiempo = false;
    /**
     * Almacena el color predeterminado del Jugador 1
     */
    public Color Player1 = Color.RED;
    /**
     * Almacena el color predeterminado del Jugador 2
     */
    public Color Player2 = new Color(0, 153, 250);
    /**
     * Representa el botón de guardado
     */
    public JButton botonGuardar;
    /**
     * Representa el botón de configuración
     */
    public JButton botonConfiguracion;
    /**
     * Es el encargado de desactivar o activar el sonido del juego
     */
    public JCheckBox checkBoxSonido = new JCheckBox("Activar/Deshabilitar Sonido", true);
    /**
     * Es el encargado de desactivar o activar la música del juego
     */
    public JCheckBox checkBoxMusica;
    /**
     * Almacena si el sonido esta activado o desactivado
     */
    public boolean sonido = true;
    /**
     * Almacena el texto cambiando del nombre del jugador 1
     */
    public JLabel Jug1 = new JLabel();
    /**
     * Almacena el texto cambiando del nombre del jugador 2
     */
    public JLabel Jug2 = new JLabel();
    /**
     * Guarda el tiempo de juego del Jugador 1
     */
    public int Tiempo1 = 0;
    /**
     * Guarda el tiempo de juego del Jugador 2
     */
    public int Tiempo2 = 0;
    /**
     * Guarda cual es la temática en la que se esta jugando actualmente
     */
    public int Tematica = 0;
    /**
     * Guarda la dirección de la imagen de fondo
     */
    public URL ruta;
    /**
     * Guarda la dirección de la imagen de fondo
     */
    public URL rutaT;
    /**
     * Botón para escoger un color personalizado del jugador 1
     */
    public JButton Color1;
    /**
     * Botón para escoger un color personalizado del jugador 2
     */
    public JButton Color2;
    /**
     * Palabras validas que se pueden encontrar
     */
    public ArrayList<String> palabrasValidas = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"));
    /**
     * Matriz predefinida con las palabras a buscar
     */
    public char[][] matriz = new char[20][20];
    
    /**
     * Crea la Ventana Principal de la sopa de letras
     */
    public Ventana() {
        //Le damos tamaño a la ventana
        this.setSize(650, 600);
        //Hacemos que al momento de darle en la X no deja de ejecutarse el programa
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        //Evitamos que pueda redimensionarse
        this.setResizable(false);
        //Le damos un titulo a la ventana
        this.setTitle("BUSCADORES DE PALABRAS");
        //Hacemos que aparezca centrada en la pantalla
        this.setLocationRelativeTo(null);
        //Le quitamos el layout para poder poner los JPanel donde queramos
        this.setLayout(null);
        //Creamos una URL donde se guardara la dirección del logo del juego
        URL url = getClass().getResource("Decoracion/Icono.png");
        ImageIcon logo = new ImageIcon(url);
        //Le añadimos un logo a la ventana
        this.setIconImage(logo.getImage());

        //Le añadimos un WindowClosing para que al cerrar lanza un aviso de ¿seguro que desea salir?
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (sonido) {
                    //Añadimos un sonido cuando haga click
                    AudioClip click;
                    click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SClick.wav"));
                    click.play();
                }
                //Creamos el arreglo con las opciones a elegir
                String[] op = {"¡Claro!", "No, quiero jugar"};
                //Dependiendo de que se escoja será la acción a realizar
                int i = JOptionPane.showOptionDialog(null, "¿Realmente deseas salir?", "Salida del Programa", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op, op[0]);
                //Si la opción escogida es la 0 o sea salir se ejecuta lo de adentro
                if (i == 0) {
                    if (sonido) {
                        //Añadimos un sonido cuando se cierra
                        AudioClip click;
                        click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SBye.wav"));
                        click.play();
                    }
                    //Desaparecemos el Jframe
                    setVisible(false);

                    //Un timer para que dentro de 2s se cierre el juego completamente (Duración del sonido de cerrar)
                    Timer Salir = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //Mostramos e pantalla una despedida
                            JOptionPane.showMessageDialog(null, "Hasta la próxima...");
                            //Concluimos el programa
                            System.exit(0);
                        }
                    });
                    //Iniciamos el timer
                    Salir.start();
                } else {
                    if (sonido) {
                        //Añadimos un sonido cuando se haga click en no o en x
                        AudioClip click;
                        click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SClick.wav"));
                        click.play();
                    }
                }
            }
        });

        //Iniciamos los componentes del Jframe
        IniciarComponentes();
        //Hacemos visible el Jframe
        this.setVisible(true);
    }

    /**
     * Iniciamos todos los componentes de la ventana inicial
     */
    public void IniciarComponentes() {
        IngresoNombres = new JPanel(null);
        IngresoNombres.setBounds(0, 0, this.getWidth(), this.getHeight());
        IngresoNombres.setBackground(Color.WHITE);
        //Añadimos el JPanel al JFrame
        this.getContentPane().add(IngresoNombres);
        //Llamamos los elementos que piden el nombre de los jugadores
        PedirNombres();
        //Llamamos al escuchador de presionar el botón de reglas
        SiguienteReglas();
        //Llamamos al escuchador de presionar el botón de Inicio
        InicioJuego();
    }

    /**
     * Interfaz de pedir los nombres
     */
    public void PedirNombres() {

        //Agregamos un icono con la imagen representativa del juego
        ImageIcon icon = new ImageIcon(getClass().getResource("Decoracion/Titulo.png"));
        JLabel Titulo = new JLabel();
        //Se la asignamos al titulo
        Titulo.setIcon(new ImageIcon(icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        //Le damos tamaño a la imagen
        Titulo.setBounds(215, 10, 200, 200);
        //La añadimos al JPanel
        IngresoNombres.add(Titulo);

        //Añadimos un titulo
        Nombre1 = new JLabel("Jugador 1");
        //Le damos tamaño y Posición
        Nombre1.setBounds(-50, Titulo.getY() + 200, this.getWidth(), 35 + 10);
        //Le damos un alineamiento horizontal
        Nombre1.setHorizontalAlignment(JLabel.CENTER);
        //Le damos un color
        Nombre1.setForeground(Player1);
        //Le damos un tipo de letra
        Nombre1.setFont(new Font("Roboto Condensed", 1, Nombre1.getHeight() - 5));
        //Lo añadimos al JPanel
        IngresoNombres.add(Nombre1);

        Jugador1 = new JTextField("Ingrese el nombre del jugador 1");
        Jugador1.setBounds((this.getWidth() / 4) - 10, Nombre1.getY() + 60, this.getWidth() / 2, 25);
        Jugador1.setHorizontalAlignment(JLabel.CENTER);
        Jugador1.setForeground(Color.DARK_GRAY);
        Jugador1.setOpaque(false); //Le eliminamos el fondo
        Jugador1.setBorder(null); //Le eliminamos el borde
        Jugador1.setFont(new Font("Roboto Condensed", 1, Jugador1.getHeight() - 3));
        IngresoNombres.add(Jugador1);

        //Añadimos un separador debajo del Text Field para la ilusión de que se escribe sobre el
        JSeparator Separa1 = new JSeparator();
        Separa1.setBounds((this.getWidth() / 4) - 10, Jugador1.getY() + 30, this.getWidth() / 2, Jugador1.getHeight() + 5);
        Separa1.setBackground(Color.red);
        Separa1.setFocusable(false);
        IngresoNombres.add(Separa1);

        icon = new ImageIcon(getClass().getResource("Decoracion/Color.png"));
        Color1 = new JButton();
        Color1.setIcon(new ImageIcon(icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        Color1.setBounds(Nombre1.getX() + 450, Nombre1.getY() + 10, 30, 30);
        Color1.setOpaque(false);
        Color1.setContentAreaFilled(false);
        Color1.setBorderPainted(false);
        Color1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Color1.setFocusable(false);
        IngresoNombres.add(Color1);

        Nombre2 = new JLabel("Jugador 2");
        Nombre2.setBounds(Nombre1.getX(), Jugador1.getY() + 60, this.getWidth(), Jugador1.getHeight() + 20);
        Nombre2.setHorizontalAlignment(JLabel.CENTER);
        Nombre2.setForeground(Player2);
        Nombre2.setFont(new Font("Roboto Condensed", 1, Nombre2.getHeight() - 5));
        IngresoNombres.add(Nombre2);

        Jugador2 = new JTextField("Ingrese el nombre del jugador 2");
        Jugador2.setBounds((this.getWidth() / 4) - 10, Nombre2.getY() + 60, this.getWidth() / 2, Jugador1.getHeight());
        Jugador2.setHorizontalAlignment(JLabel.CENTER);
        Jugador2.setForeground(Color.DARK_GRAY);
        Jugador2.setOpaque(false);
        Jugador2.setBorder(null);
        Jugador2.setFont(new Font("Roboto Condensed", 1, Jugador1.getHeight() - 3));
        IngresoNombres.add(Jugador2);

        JSeparator Separa2 = new JSeparator();
        Separa2.setBounds((this.getWidth() / 4) - 10, Jugador2.getY() + 30, this.getWidth() / 2, Jugador1.getHeight() + 5);
        Separa2.setBackground(Color.red);
        Separa2.setFocusable(false);
        IngresoNombres.add(Separa2);

        icon = new ImageIcon(getClass().getResource("Decoracion/Color.png"));
        Color2 = new JButton();
        Color2.setIcon(new ImageIcon(icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        Color2.setBounds(Nombre2.getX() + 450, Nombre2.getY() + 10, 30, 30);
        Color2.setOpaque(false);
        Color2.setContentAreaFilled(false);
        Color2.setBorderPainted(false);
        Color2.setFocusable(false);
        Color2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        IngresoNombres.add(Color2);

        Reglas = new JButton("REGLAS");
        Reglas.setBounds((this.getWidth() / 4), Jugador2.getY() + 60, 100, 70);
        Reglas.setFont((new Font("Roboto Condensed", 1, 15)));
        Reglas.setForeground(Color.black);
        Reglas.setBackground(new Color(240, 0, 0));
        //Le cambiamos el cursor por el de la mano para incentivar a presionar
        Reglas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Reglas.setBorderPainted(false);
        Reglas.setFocusable(false);
        IngresoNombres.add(Reglas);

        Inicio = new JButton("INICIO");
        Inicio.setBounds(Reglas.getX() + 173, Jugador2.getY() + 60, 100, 70);
        Inicio.setFont((new Font("Roboto Condensed", 1, 15)));
        Inicio.setForeground(Color.black);
        Inicio.setBackground(new Color(0, 240, 0));
        Inicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Inicio.setBorderPainted(false);
        Inicio.setFocusable(false);
        IngresoNombres.add(Inicio);

        //Los TextField del nombre se vaciaran dependiendo de su contenido
        DespejarTextField(Jugador1);
        DespejarTextField(Jugador2);

        //Llamamos a los selectores de colores que se activaran cuando se presionen esos botones
        SelectColor(Color1);
        SelectColor(Color2);

        //Agregamos una decoración de fondo
        icon = new ImageIcon(getClass().getResource("Decoracion/Fondo1.jpg"));
        JLabel Fondo = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));
        Fondo.setBounds(0, 0, this.getWidth(), this.getHeight());
        IngresoNombres.add(Fondo);
    }

    /**
     * Encargada de guardar el color personalizada creado por el usuario
     *
     * @param Col Recibe o el botón del color 1 o el botón del color 2
     */
    public void SelectColor(JButton Col) {

        //Un listener cuando se presione
        ActionListener oyenteDeAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sonido) {
                    //Reproducimos un sonido al presionarlo
                    AudioClip press;
                    press = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SClick.wav"));
                    press.play();
                }
                if (Col == Color1) {
                    //Abrimos un selector de color personalizado
                    Color color = JColorChooser.showDialog(null, "Seleccione el Color del Jugador 1", Color.BLACK);
                    //Asignamos ese color al jugador
                    Player1 = color;
                    Nombre1.setForeground(Player1);
                } else if (Col == Color2) {
                    //Abrimos un selector de color personalizado
                    Color color = JColorChooser.showDialog(null, "Seleccione el Color del Jugador 2", Color.BLACK);
                    Player2 = color;
                    Nombre2.setForeground(Player2);

                }
            }
        };
        Col.addActionListener(oyenteDeAccion);
    }

    /**
     * Acciones al presionar el Botón de Reglas
     */
    public void SiguienteReglas() {

        ActionListener oyenteDeAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sonido) {
                    //Creamos un objeto de AudioClip
                    AudioClip press;
                    //Le asignamos el audio que reproducirá
                    press = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SReglas.wav"));
                    //Al momento de hacer click se reproducirá
                    press.play();
                }
                //Buscamos el JPanel de los Jugadores y lo eliminamos
                getContentPane().remove(IngresoNombres);
                //Al eliminarse validamos si hay regiones sucias
                revalidate();
                //Indicamos que se debe repintar
                repaint();
                //Llamamos al método que me muestre las reglas
                Reglamento();
                revalidate();
                repaint();
                
                //Incluimos una decoración a las reglas
                URL url = getClass().getResource("Decoracion/Fondo2.jpg");
                ImageIcon icon = new ImageIcon(url);
                JLabel Fondo = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)));
                Fondo.setBounds(0, 0, getWidth(), getHeight());
                Instrucciones.add(Fondo);
            }
        };
        //Añadimos el Listener al botón de las Reglas
        Reglas.addActionListener(oyenteDeAccion);
        
        Reglas.addMouseListener(new MouseAdapter() {
            //Añadimos listener de pasar por encima y salir para hacer mas sensación de que se debe presionar el botón
            @Override
            public void mouseEntered(MouseEvent e) {
                Reglas.setBackground(new Color(250, 45, 45)); //Le ponemos un color mas claro que el predeterminado
                Reglas.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Reglas.setBackground(new Color(240, 0, 0)); //Regresamos al color predeterminado una vez se sale del botón
                Reglas.setForeground(Color.black);
            }
        });
    }

    /**
     * Muestra las reglas del juego de la Sopa de Letras y los Créditos
     */
    public void Reglamento() {
        Instrucciones = new JPanel(null);
        Instrucciones.setBounds(0, 0, this.getWidth(), this.getHeight());
        //Añadimos el nuevo JPanel al Jframe
        getContentPane().add(Instrucciones);

        JLabel Titulo = new JLabel("Instrucciones");
        Titulo.setBounds(-5, 15, this.getWidth(), 35);
        Titulo.setHorizontalAlignment(JLabel.CENTER);
        Titulo.setFont(new Font("Roboto Condensed", 1, Titulo.getHeight() - 1));
        Titulo.setForeground(Color.green);
        Instrucciones.add(Titulo);

        JLabel Parrafo = new JLabel("<html><div style='text-align: justify;'>La sopa de letras es un juego de palabras que consiste en encontrar palabras ocultas en una cuadrícula de letras.<br>"
                + "Las reglas del juego son las siguientes:<br>"
                + "- Cada jugador tiene un turno para buscar una palabra de la lista de palabras de la tematica.<br>"
                + "- Las palabras pueden estar en cualquier dirección: horizontal, vertical, diagonal, de izquierda a derecha, de derecha a izquierda, de arriba a abajo o de abajo a arriba.<br>"
                + "- Las palabras deben marcarse haciendo clic en la primera o última letra y arrastrando el puntero del ratón hasta el otro extremo de la palabra.<br>"
                + "- Si la secuencia de letras seleccionada es una de las palabras escondidas en la sopa de letras será un acierto.<br>"
                + "- El ganador de la partida será el jugador que haya encontrado más palabras.<br>"
                + "- En caso de empate vence quien sume entre sus palabras encontradas un menor número de letras.</div><html>");
        Parrafo.setBounds(75, 20, 490, 475);
        Parrafo.setFont((new Font("Roboto Condensed", 1, 17)));
        Parrafo.setForeground(Color.BLACK);
        Instrucciones.add(Parrafo);

        JLabel Creditos = new JLabel("Diseño y Programación");
        Creditos.setBounds(-10, 475, this.getWidth(), 25);
        Creditos.setHorizontalAlignment(JLabel.CENTER);
        Creditos.setFont(new Font("Roboto Condensed", 1, Creditos.getHeight() - 1));
        Creditos.setForeground(new Color(135, 206, 235));
        Instrucciones.add(Creditos);

        JLabel Autores = new JLabel("Franco Rodríguez & Daniel Camacho");
        Autores.setBounds(-10, Creditos.getY() + 30, this.getWidth(), 30);
        Autores.setHorizontalAlignment(JLabel.CENTER);
        Autores.setFont(new Font("Roboto Condensed", 1, Autores.getHeight() - 4));
        Autores.setForeground(new Color(123, 50, 250));
        Instrucciones.add(Autores);

        URL url = getClass().getResource("Decoracion/flecha.png");
        ImageIcon icon = new ImageIcon(url);
        Flecha = new JButton();
        Flecha.setIcon(new ImageIcon(icon.getImage().getScaledInstance(63, 48, Image.SCALE_SMOOTH)));
        Flecha.setBounds(5, 5, 63, 48);
        Flecha.setOpaque(false);
        Flecha.setContentAreaFilled(false);
        Flecha.setBorderPainted(false);
        Flecha.setFocusable(false);
        Instrucciones.add(Flecha);

        //Creamos un fondo semitransparente en las reglas para poder observar mejor las letras
        url = getClass().getResource("Decoracion/blanco.png");
        icon = new ImageIcon(url);
        JLabel Blanco = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(520, 535, Image.SCALE_SMOOTH)));
        Blanco.setBounds(60, 10, 520, 535);
        Instrucciones.add(Blanco);
        //Llamamos al listener de la flecha de regreso
        VolverMenu();
    }

    /**
     * Acciones al presionar la flecha de regreso
     */
    public void VolverMenu() {
        ActionListener oyenteDeAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sonido) {
                    AudioClip press;
                    press = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SReturn.wav"));
                    press.play();
                }

                getContentPane().remove(Instrucciones);
                revalidate();
                repaint();
                //Llamamos al Jpanel inicial de los nombres
                IniciarComponentes();
                revalidate();
                repaint();
            }
        };
        //Añadimos el Listener a la flecha de regreso
        Flecha.addActionListener(oyenteDeAccion);
    }

    /**
     * Acciones al presionar el botón de Jugar
     */
    public void InicioJuego() {
        ActionListener oyenteDeAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Comprobamos si ya fueron introducidos los nombres de los jugadores
                if (!(((Jugador1.getText().equals("Ingrese el nombre del jugador 1")) || (Jugador2.getText().equals("Ingrese el nombre del jugador 2"))) || (((Jugador1.getText().isEmpty()) || (Jugador2.getText().isEmpty()))))) {
                    if (sonido) {
                        AudioClip press;
                        press = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SInicio.wav"));
                        press.play();
                    }
                    getContentPane().remove(IngresoNombres);
                    revalidate();
                    repaint();

                    // Mostrar el panel de temáticas
                    MostrarPanelTematicas();
                    revalidate();
                    repaint();

                } else { //Si no se introdujeron marca un error con un sonido y muestra que deben de ingresarse
                    if (sonido) {
                        AudioClip error;
                        error = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SError.wav"));
                        error.play();
                    }
                    JOptionPane.showMessageDialog(null, "Ingresé el Nombre de ambos Jugadores");
                }
            }
        };

        //Añadimos el Listener al botón de inicio
        Inicio.addActionListener(oyenteDeAccion);
        Inicio.addMouseListener(new MouseAdapter() {

            @Override //Marcamos cada letra donde pasamos el mouse
            public void mouseEntered(MouseEvent e) {
                Inicio.setBackground(new Color(74, 250, 74));
                Inicio.setForeground(Color.white);
            }

            @Override //Desmarcamos cada letra donde no este el mouse
            public void mouseExited(MouseEvent e) {
                Inicio.setBackground(new Color(0, 240, 0));
                Inicio.setForeground(Color.black);
            }
        });
    }

    /**
     * Nos ayuda a dejar en blanco o poner predeterminado el texto de los
     * TextField
     *
     * @param Seleccionado Depende del TextField seleccionado ocurrirán las
     * cosas
     */
    public void DespejarTextField(JTextField Seleccionado) {

        if (Seleccionado == Jugador1) { //Se identifica el Textfield que se ingreso

            Seleccionado.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (Seleccionado.getText().length() >= 14) { // limite es el número máximo de caracteres
                        e.consume(); // esto ignora el último carácter ingresado
                    }
                    if (Seleccionado.getText().equals("Ingrese el nombre del jugador 1")) {
                        Seleccionado.setText("");
                        Seleccionado.setForeground(Color.BLACK);
                    }
                    //Si el otro campo esta vació lo regresa a su texto y color predeterminado
                    if (String.valueOf(Jugador2.getText()).isEmpty()) {
                        Jugador2.setText("Ingrese el nombre del jugador 2");
                        Jugador2.setForeground(Color.DARK_GRAY);
                    }
                }
            });

            Seleccionado.addMouseListener(new MouseAdapter() { //Le añadimos un MousePressed
                @Override
                public void mousePressed(MouseEvent e) {
                    //Si se presiono y el texto es el predeterminado se borra y se cambia el color de la fuente
                    if (Seleccionado.getText().equals("Ingrese el nombre del jugador 1")) {
                        Seleccionado.setText("");
                        Seleccionado.setForeground(Color.BLACK);
                    }
                    //Si el otro campo esta vació lo regresa a su texto y color predeterminado
                    if (String.valueOf(Jugador2.getText()).isEmpty()) {
                        Jugador2.setText("Ingrese el nombre del jugador 2");
                        Jugador2.setForeground(Color.DARK_GRAY);
                    }
                }
            });
        } else if (Seleccionado == Jugador2) {

            Seleccionado.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (Seleccionado.getText().length() >= 14) { // limite es el número máximo de caracteres
                        e.consume(); // esto ignora el último carácter ingresado
                    }
                    if (Seleccionado.getText().equals("Ingrese el nombre del jugador 2")) {
                        Seleccionado.setText("");
                        Seleccionado.setForeground(Color.BLACK);
                    }
                    if (String.valueOf(Jugador1.getText()).isEmpty()) {
                        Jugador1.setText("Ingrese el nombre del jugador 1");
                        Jugador1.setForeground(Color.DARK_GRAY);
                    }
                }
            });

            Seleccionado.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (Seleccionado.getText().equals("Ingrese el nombre del jugador 2")) {
                        Seleccionado.setText("");
                        Seleccionado.setForeground(Color.BLACK);
                    }
                    if (String.valueOf(Jugador1.getText()).isEmpty()) {
                        Jugador1.setText("Ingrese el nombre del jugador 1");
                        Jugador1.setForeground(Color.DARK_GRAY);
                    }
                }
            });
        }
    }

    /**
     * Define el tema escogido por el usuario
     * @param n Numero del tema escogido por el usuario
     */
    public void Tema(int n) {
        //Dependiendo de la elección se asignaran las palabras a buscar y la matriz
        if (n == 1) {
            char[][] EquiposFutbol = {
                {'M', 'B', 'A', 'H', 'I', 'R', 'N', 'O', 'N', 'E', 'W', 'C', 'A', 'S', 'T', 'L', 'E', 'R', 'S', 'M'},
                {'P', 'I', 'V', 'S', 'W', 'L', 'A', 'D', 'I', 'S', 'P', 'N', 'S', 'S', 'A', 'S', 'E', 'L', 'B', 'A'},
                {'O', 'I', 'L', 'D', 'Z', 'P', 'P', 'N', 'L', 'N', 'V', 'A', 'P', 'A', 'R', 'T', 'P', 'S', 'A', 'D'},
                {'E', 'C', 'H', 'A', 'F', 'V', 'O', 'D', 'I', 'X', 'H', 'P', 'L', 'S', 'S', 'I', 'S', 'M', 'R', 'R'},
                {'U', 'V', 'E', 'E', 'N', 'S', 'L', 'Y', 'O', 'S', 'A', 'L', 'A', 'E', 'I', 'O', 'A', 'A', 'C', 'I'},
                {'Y', 'J', 'E', 'V', 'R', 'L', 'I', 'U', 'N', 'A', 'I', 'N', 'H', 'S', 'S', 'R', 'V', 'S', 'E', 'D'},
                {'T', 'B', 'S', 'R', 'B', 'P', 'O', 'I', 'O', 'V', 'A', 'C', 'S', 'E', 'S', 'L', 'A', 'L', 'L', 'A'},
                {'R', 'D', 'E', 'R', 'T', 'H', 'Ñ', 'N', 'E', 'S', 'N', 'S', 'Q', 'E', 'S', 'S', 'T', 'A', 'O', 'R'},
                {'R', 'O', 'M', 'A', 'A', 'O', 'T', 'S', 'A', 'A', 'Q', 'C', 'L', 'I', 'M', 'I', 'N', 'A', 'N', 'M'},
                {'X', 'A', 'H', 'J', 'R', 'G', 'N', 'O', 'M', 'Q', 'E', 'L', 'E', 'L', 'D', 'I', 'N', 'S', 'A', 'A'},
                {'A', 'E', 'S', 'L', 'E', 'H', 'C', 'O', 'G', 'T', 'A', 'A', 'Y', 'L', 'T', 'B', 'S', 'B', 'R', 'H'},
                {'H', 'V', 'M', 'A', 'R', 'S', 'E', 'T', 'Y', 'Y', 'T', 'N', 'U', 'N', 'Ñ', 'G', 'F', 'L', 'O', 'N'},
                {'N', 'J', 'A', 'T', 'A', 'L', 'A', 'N', 'T', 'A', 'Y', 'C', 'E', 'L', 'L', 'L', 'I', 'L', 'I', 'E'},
                {'R', 'I', 'V', 'E', 'R', 'P', 'L', 'J', 'L', 'N', 'U', 'R', 'K', 'S', 'X', 'V', 'K', 'P', 'A', 'T'},
                {'E', 'B', 'R', 'I', 'G', 'H', 'T', 'O', 'N', 'S', 'O', 'E', 'X', 'A', 'E', 'P', 'U', 'R', 'R', 'T'},
                {'Y', 'O', 'V', 'M', 'A', 'P', 'R', 'I', 'D', 'I', 'I', 'S', 'J', 'R', 'M', 'S', 'S', 'S', 'E', 'O'},
                {'A', 'X', 'V', 'E', 'N', 'C', 'U', 'S', 'F', 'A', 'O', 'A', 'P', 'T', 'T', 'E', 'N', 'H', 'T', 'T'},
                {'B', 'A', 'J', 'U', 'V', 'E', 'N', 'T', 'U', 'S', 'L', 'O', 'S', 'S', 'N', 'S', 'L', 'H', 'N', 'O'},
                {'W', 'L', 'A', 'Z', 'I', 'O', 'N', 'T', 'U', 'S', 'O', 'R', 'J', 'A', 'B', 'L', 'G', 'F', 'I', 'L'},
                {'M', 'A', 'R', 'I', 'E', 'L', 'L', 'A', 'I', 'L', 'K', 'L', 'L', 'E', 'Y', 'S', 'I', 'R', 'A', 'P'},};
            
            //Copiamos la Matriz de EquipoFutbol a la matriz principal del juego
            for (int i = 0; i < matriz.length; i++) {
                System.arraycopy(EquiposFutbol[i], 0, matriz[i], 0, matriz[i].length);
            }
            
            //Le asignamos a la lista de palabras, las palabras a buscar
            String EquipoM[] = {"BARCELONA", "LIVERPOOL", "BAYERN", "ARSENAL", "PARIS", "CHELSEA", "MANCHESTER", "TOTTENHAM", "NEWCASTLE", "BRIGHTON", "LION", "MARSELLA", "MILAN", "INTER", "JUVENTUS", "EVERTON", "NAPOLI", "ATALANTA", "FIORENTINA", "ROMA", "LAZIO", "AJAX", "MADRID", "SEVILLA"};
            for (int i = 0; i < palabrasValidas.size(); i++) {
                palabrasValidas.set(i, EquipoM[i]);
            }
            
            //Asiganamos las rutas de las decoraciones que se cambiaran dependiendo de la tematica
            ruta = getClass().getResource("Decoracion/F1.jpg");
            rutaT = getClass().getResource("Decoracion/T1.png");
            
        } else if (n == 2) {
            char[][] Felinos = {
                {'C', 'B', 'L', 'Y', 'E', 'R', 'N', 'O', 'L', 'J', 'S', 'G', 'P', 'H', 'A', 'S', 'G', 'E', 'L', 'L'},
                {'U', 'A', 'E', 'S', 'T', 'I', 'G', 'R', 'E', 'S', 'A', 'M', 'U', 'S', 'A', 'V', 'A', 'A', 'J', 'E'},
                {'N', 'I', 'O', 'D', 'Z', 'P', 'L', 'N', 'T', 'P', 'V', 'G', 'P', 'E', 'R', 'I', 'T', 'S', 'R', 'O'},
                {'A', 'C', 'N', 'C', 'F', 'V', 'E', 'L', 'I', 'G', 'R', 'E', 'U', 'S', 'P', 'S', 'O', 'S', 'G', 'P'},
                {'G', 'I', 'E', 'E', 'E', 'S', 'O', 'Y', 'G', 'L', 'A', 'A', 'A', 'A', 'I', 'A', 'E', 'E', 'A', 'A'},
                {'U', 'J', 'L', 'V', 'P', 'J', 'T', 'H', 'P', 'A', 'J', 'T', 'P', 'S', 'R', 'A', 'R', 'M', 'N', 'R'},
                {'A', 'B', 'S', 'A', 'A', 'P', 'O', 'I', 'A', 'V', 'A', 'L', 'S', 'E', 'L', 'U', 'A', 'D', 'I', 'D'},
                {'R', 'A', 'V', 'G', 'S', 'C', 'R', 'I', 'N', 'R', 'O', 'P', 'U', 'M', 'A', 'B', 'N', 'L', 'O', 'O'},
                {'O', 'T', 'U', 'L', 'A', 'N', 'T', 'A', 'T', 'E', 'Q', 'B', 'W', 'U', 'M', 'A', 'L', 'D', 'N', 'L'},
                {'I', 'A', 'T', 'S', 'Q', 'L', 'O', 'O', 'E', 'C', 'R', 'M', 'E', 'B', 'D', 'N', 'M', 'K', 'I', 'E'},
                {'R', 'S', 'B', 'O', 'R', 'N', 'E', 'O', 'R', 'T', 'R', 'U', 'Y', 'Y', 'S', 'L', 'I', 'N', 'C', 'E'},
                {'O', 'V', 'M', 'N', 'O', 'D', 'E', 'T', 'A', 'B', 'A', 'M', 'B', 'I', 'N', 'O', 'C', 'A', 'Ñ', 'A'},
                {'T', 'J', 'D', 'M', 'Z', 'B', 'O', 'G', 'H', 'J', 'S', 'E', 'R', 'V', 'A', 'L', 'I', 'F', 'T', 'I'},
                {'L', 'C', 'A', 'R', 'A', 'C', 'A', 'L', 'L', 'N', 'U', 'H', 'K', 'S', 'J', 'Ñ', 'K', 'P', 'F', 'T'},
                {'I', 'T', 'I', 'G', 'R', 'I', 'L', 'L', 'O', 'S', 'P', 'M', 'S', 'O', 'C', 'E', 'L', 'O', 'T', 'E'},
                {'N', 'O', 'V', 'G', 'E', 'O', 'F', 'F', 'R', 'O', 'Y', 'A', 'S', 'P', 'M', 'S', 'S', 'E', 'F', 'E'},
                {'J', 'U', 'V', 'S', 'H', 'E', 'L', 'L', 'C', 'A', 'O', 'R', 'O', 'T', 'T', 'E', 'N', 'T', 'A', 'M'},
                {'G', 'A', 'T', 'O', 'S', 'E', 'L', 'V', 'A', 'T', 'L', 'G', 'B', 'E', 'N', 'G', 'A', 'L', 'A', 'O'},
                {'T', 'Y', 'P', 'E', 'S', 'C', 'R', 'I', 'P', 'T', 'S', 'A', 'C', 'A', 'L', 'A', 'G', 'F', 'C', 'L'},
                {'G', 'A', 'T', 'O', 'N', 'I', 'E', 'V', 'E', 'J', 'K', 'Y', 'G', 'M', 'O', 'N', 'T', 'E', 'S', 'H'},};

            for (int i = 0; i < matriz.length; i++) {
                System.arraycopy(Felinos[i], 0, matriz[i], 0, matriz[i].length);
            }
            
            String FelinosM[] = {"LEON", "TIGRE", "LIGRE", "JAGUAR", "CERVAL", "PANTERA", "BORNEO", "CARACAL", "GEOFFROY", "GATOSELVA", "GATONIEVE", "PUMA", "SERVAL", "OCELOTE", "BENGALA", "MONTES", "MARGAY", "BAMBINO", "LINCE", "GUEPARDO", "JAGUARUNDI", "LEOPARDO", "CUNAGUARO", "TIGRILLO"};
            for (int i = 0; i < palabrasValidas.size(); i++) {
                palabrasValidas.set(i, FelinosM[i]);
            }
            
            ruta = getClass().getResource("Decoracion/F2.gif");
            rutaT = getClass().getResource("Decoracion/T2.png");
            
        } else if (n == 3) {
            char[][] LenguajesProgramacion = {
                {'B', 'B', 'J', 'Y', 'E', 'R', 'N', 'O', 'L', 'L', 'S', 'P', 'P', 'H', 'A', 'S', 'K', 'E', 'L', 'L'},
                {'P', 'A', 'A', 'S', 'R', 'E', 'A', 'C', 'T', 'S', 'H', 'M', 'S', 'S', 'A', 'V', 'I', 'A', 'J', 'F'},
                {'O', 'I', 'V', 'D', 'Z', 'P', 'L', 'N', 'T', 'P', 'V', 'N', 'P', 'P', 'R', 'I', 'P', 'S', 'R', 'H'},
                {'I', 'C', 'A', 'C', 'F', 'V', 'E', 'D', 'Y', 'X', 'H', 'M', 'O', 'S', 'E', 'S', 'S', 'S', 'G', 'P'},
                {'U', 'I', 'E', 'E', 'E', 'S', 'O', 'Y', 'G', 'S', 'A', 'A', 'A', 'R', 'I', 'U', 'E', 'E', 'A', 'S'},
                {'Y', 'J', 'L', 'V', 'P', 'Y', 'T', 'H', 'O', 'N', 'J', 'T', 'P', 'S', 'S', 'A', 'V', 'M', 'N', 'P'},
                {'T', 'B', 'S', 'A', 'B', 'P', 'O', 'I', 'O', 'M', 'A', 'L', 'S', 'E', 'L', 'L', 'A', 'B', 'I', 'E'},
                {'J', 'A', 'V', 'A', 'S', 'C', 'R', 'I', 'P', 'T', 'O', 'A', 'Q', 'R', 'S', 'B', 'T', 'L', 'T', 'R'},
                {'A', 'T', 'A', 'L', 'A', 'N', 'T', 'A', 'A', 'L', 'Q', 'B', 'W', 'U', 'M', 'A', 'L', 'Y', 'N', 'L'},
                {'I', 'N', 'T', 'S', 'Q', 'L', 'O', 'O', 'B', 'Q', 'R', 'M', 'E', 'B', 'D', 'S', 'N', 'S', 'E', 'S'},
                {'K', 'S', 'V', 'F', 'L', 'P', 'H', 'O', 'A', 'T', 'R', 'U', 'Y', 'Y', 'S', 'I', 'S', 'B', 'R', 'A'},
                {'O', 'V', 'M', 'N', 'O', 'D', 'E', 'T', 'S', 'Y', 'T', 'N', 'S', 'A', 'Ñ', 'C', 'F', 'S', 'O', 'N'},
                {'T', 'J', 'D', 'B', 'Z', 'B', 'O', 'G', 'H', 'S', 'Y', 'C', 'R', 'T', 'S', 'W', 'I', 'F', 'T', 'I'},
                {'L', 'H', 'T', 'M', 'L', 'I', 'L', 'J', 'L', 'N', 'U', 'H', 'K', 'S', 'J', 'Ñ', 'K', 'P', 'F', 'T'},
                {'I', 'R', 'O', 'U', 'A', 'C', 'S', 'S', 'L', 'S', 'P', 'A', 'S', 'C', 'A', 'L', 'U', 'N', 'S', 'N'},
                {'N', 'O', 'V', 'M', 'A', 'D', 'R', 'I', 'D', 'K', 'I', 'S', 'S', 'P', 'M', 'S', 'S', 'E', 'F', 'E'},
                {'J', 'U', 'V', 'S', 'H', 'E', 'L', 'L', 'C', 'A', 'O', 'T', 'O', 'T', 'T', 'E', 'N', 'T', 'A', 'M'},
                {'R', 'A', 'M', 'N', 'E', 'W', 'C', 'A', 'S', 'T', 'L', 'E', 'S', 'S', 'S', 'S', 'L', 'H', 'W', 'O'},
                {'T', 'Y', 'P', 'E', 'S', 'C', 'R', 'I', 'P', 'T', 'S', 'S', 'C', 'A', 'L', 'A', 'G', 'F', 'C', 'L'},
                {'A', 'B', 'C', 'D', 'E', 'K', 'G', 'H', 'I', 'J', 'K', 'L', 'G', 'E', 'Y', 'I', 'S', 'R', 'S', 'H'},};

            for (int i = 0; i < matriz.length; i++) {
                System.arraycopy(LenguajesProgramacion[i], 0, matriz[i], 0, matriz[i].length);
            }
            
            String ProgramacionM[] = {"JAVA", "REACT", "PHP", "MATLAB", "PYTHON", "JAVASCRIPT", "SQL", "BASH", "NODE", "HTML", "KOTLIN", "VISUALBASIC", "SHELL", "TYPESCRIPT", "RUST", "RUBY", "SWIFT", "PASCAL", "NET", "SCALA", "CSS", "HASKELL", "ASSEMBLY", "PERL"};
            for (int i = 0; i < palabrasValidas.size(); i++) {
                palabrasValidas.set(i, ProgramacionM[i]);
            }
            
            ruta = getClass().getResource("Decoracion/F3.jpg");
            rutaT = getClass().getResource("Decoracion/T3.png");
        }
        //Llamamos a la funcion del juego y empezaria la partida
        Juego();
        revalidate();
        repaint();
    }

    /**
     * Pantalla de seleccion de la tematica
     */
    public void MostrarPanelTematicas() {
        // Creamos el nuevo panel de temáticas
        JPanel TematicaPanel = new JPanel(null);
        TematicaPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.getContentPane().add(TematicaPanel);

        // Añadimos la JLabel en la parte superior
        JLabel TematicaLabel = new JLabel("Elige la temática de la sopa de letras:");
        TematicaLabel.setBounds(0, 5, this.getWidth(), 30);
        TematicaLabel.setHorizontalAlignment(JLabel.CENTER);
        TematicaLabel.setFont(new Font("Roboto Condensed", 1, 20));
        TematicaLabel.setForeground(Color.WHITE);
        TematicaPanel.add(TematicaLabel);

        //Agregamos la imagen del tema de equipos de futbol
        ImageIcon icon = new ImageIcon(getClass().getResource("Decoracion/F1O.jpg"));
        JLabel EquiposT = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        EquiposT.setBounds(70, 50, 200, 200);
        EquiposT.setCursor(new Cursor(Cursor.HAND_CURSOR));
        TematicaPanel.add(EquiposT);

        //Agregamos el boton de los equipos de futbol que acompañara al JLabel
        JButton FutbolButton = new JButton("Equipos de Fútbol");
        FutbolButton.setBounds(EquiposT.getX(), EquiposT.getY() + 200, 200, 20);
        FutbolButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        icon = new ImageIcon(getClass().getResource("Decoracion/Tema2O.gif"));
        JLabel FelinosT = new JLabel(icon);
        FelinosT.setBounds(EquiposT.getX() + 300, 50, 200, 200);
        FelinosT.setCursor(new Cursor(Cursor.HAND_CURSOR));
        TematicaPanel.add(FelinosT);

        JButton FelinosButton = new JButton("Felinos");
        FelinosButton.setBounds(FelinosT.getX(), FelinosT.getY() + 200, 200, 20);
        FelinosButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        icon = new ImageIcon(getClass().getResource("Decoracion/F3O.jpg"));
        JLabel ProgramacionT = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        ProgramacionT.setBounds(FutbolButton.getX(), FutbolButton.getY() + 50, 200, 200);
        ProgramacionT.setCursor(new Cursor(Cursor.HAND_CURSOR));
        TematicaPanel.add(ProgramacionT);

        JButton ProgramacionButton = new JButton("Tecnología en Programación");
        ProgramacionButton.setBounds(ProgramacionT.getX(), ProgramacionT.getY() + 200, 200, 20);
        ProgramacionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        icon = new ImageIcon(getClass().getResource("Decoracion/Soon.png"));
        JLabel ProximoT = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        ProximoT.setBounds(FutbolButton.getX() + 300, FutbolButton.getY() + 50, 200, 200);
        TematicaPanel.add(ProximoT);

        // Añadimos ActionListener para los JLabel
        EquiposT.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (sonido) {
                    //Añadimos un sonido cuando se presione el cual cambia dependiendo del tema
                    AudioClip click;
                    click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/1S.wav"));
                    click.play();
                }
                // Removemos el panel de eleccion de tematica
                getContentPane().remove(TematicaPanel);
                revalidate();
                repaint();
                //Cargamos la matriz y las palabras a buscar de la temática escogida
                Tematica = 1;
                Tema(Tematica);
            }

            @Override //Resaltamos el Jlabel donde se este encima para que destaque más la elección
            public void mouseEntered(MouseEvent e) {
                if (sonido) {
                    //Sonido de cuando se pase por encima de la seleccion
                    AudioClip check;
                    check = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SCheck.wav"));
                    check.play();
                }
                //Cambiamos la imagen a una más clara para resalta la selección
                ImageIcon icon = new ImageIcon(getClass().getResource("Decoracion/F1.jpg"));
                EquiposT.setIcon(new ImageIcon(icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
            }

            @Override //Si nos salimos del JLabel llevamos otra vez la imagen a la normalidad
            public void mouseExited(MouseEvent e) {
                ImageIcon icon = new ImageIcon(getClass().getResource("Decoracion/F1O.jpg"));
                EquiposT.setIcon(new ImageIcon(icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
            }
        });

        FelinosT.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (sonido) {
                    //Añadimos un sonido cuando se salga
                    AudioClip click;
                    click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/2S.wav"));
                    click.play();
                }
                getContentPane().remove(TematicaPanel);
                revalidate();
                repaint();
                Tematica = 2;
                Tema(Tematica);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (sonido) {
                    AudioClip check;
                    check = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SCheck.wav"));
                    check.play();
                }
                ImageIcon icon = new ImageIcon(getClass().getResource("Decoracion/Tema2.gif"));
                FelinosT.setIcon(icon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ImageIcon icon = new ImageIcon(getClass().getResource("Decoracion/Tema2O.gif"));
                FelinosT.setIcon(icon);
            }
        });

        ProgramacionT.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (sonido) {
                    AudioClip click;
                    click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/3S.wav"));
                    click.play();
                }
                getContentPane().remove(TematicaPanel);
                revalidate();
                repaint();
                Tematica = 3;
                Tema(Tematica);
            }

            @Override 
            public void mouseEntered(MouseEvent e) {
                if (sonido) {
                    AudioClip check;
                    check = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SCheck.wav"));
                    check.play();
                }
                ImageIcon icon = new ImageIcon(getClass().getResource("Decoracion/F3.jpg"));
                ProgramacionT.setIcon(new ImageIcon(icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ImageIcon icon = new ImageIcon(getClass().getResource("Decoracion/F3O.jpg"));
                ProgramacionT.setIcon(new ImageIcon(icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
            }
        });

        // Añadimos ActionListener para los botones
        FutbolButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (sonido) {
                    //Añadimos un sonido cuando se seleccione
                    AudioClip click;
                    click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SClick.wav"));
                    click.play();
                }
                // Removemos el panel de eleccion de tematica
                getContentPane().remove(TematicaPanel);
                revalidate();
                repaint();
                //Cargamos la matriz y las palabras a buscar de la temática escogida
                Tematica = 1;
                Tema(Tematica);
            }
        });

        FelinosButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (sonido) {
                    AudioClip click;
                    click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SClick.wav"));
                    click.play();
                }
                getContentPane().remove(TematicaPanel);
                revalidate();
                repaint();
                Tematica = 2;
                Tema(Tematica);
            }
        });

        ProgramacionButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (sonido) {
                    AudioClip click;
                    click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SClick.wav"));
                    click.play();
                }
                getContentPane().remove(TematicaPanel);
                revalidate();
                repaint();
                Tematica = 3;
                Tema(Tematica);
            }
        });

        //Añadir componentes al panel
        TematicaPanel.add(TematicaLabel);
        TematicaPanel.add(FutbolButton);
        TematicaPanel.add(FelinosButton);
        TematicaPanel.add(ProgramacionButton);

        //Añadimos una image de decoración de fondo
        icon = new ImageIcon(getClass().getResource("Decoracion/Fondo.jpg"));
        JLabel Fondo = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));
        Fondo.setBounds(0, 0, this.getWidth(), this.getHeight());
        TematicaPanel.add(Fondo);
    }

    /**
     * JLabel donde estara todo el contenido de la sopa de letras
     */
    public void Juego() {
        //Declaramos el JPanel donde se adjuntaran todos los componentes de la sopa de letras
        Todo = new JPanel(null);
        Todo.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.getContentPane().add(Todo);

        //Declaramos la cuadricula donde estaran todas las palabras
        JLabel Cuadricula = new JLabel();
        Cuadricula.setLayout(new GridLayout(matriz.length, matriz[0].length));
        labels = new JLabel[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                JLabel label = new JLabel(Character.toString(matriz[i][j]), SwingConstants.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setFont(new Font("Arial", Font.BOLD, 12));
                label.setForeground(Color.BLACK);
                final int row = i;
                final int col = j;

                //Creamos Listener para cuando se Presione un click del mouse, se pase por encima, o el mouse se salga
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) { //Cuando se presiona es cuando se empieza a arrastrar por lo que mover pasa a true
                        if (sonido) {
                            //Añadimos un sonido cuando se presiona
                            AudioClip click;
                            click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SClick.wav"));
                            click.play();
                        }
                        mover = true;
                    }

                    @Override //Marcamos cada letra donde pasamos el mouse
                    public void mouseEntered(MouseEvent e) {
                        marcarPalabra(row, col);
                    }

                    @Override //Desmarcamos cada letra donde no este el mouse
                    public void mouseExited(MouseEvent e) {
                        SalirPalabra(row, col);
                    }
                });

                //Creamos listener para cuando se esta moviendo presionando el mouse y cuando no se esta presionando
                label.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        CaptarPalabra(row, col); //El mouseDragged sera el encargado de guardar la posicion inicial de la fila y columna ya que es donde se empieza a mantener presionado
                    }

                    @Override
                    public void mouseMoved(MouseEvent e) { //El mouseMoved sera el encargado de guardar la ultima posicion de la fila y columna ya que cuando se active es cuando se deja de mantener presionado
                        TerminarPalabra(row, col);
                    }
                });

                labels[i][j] = label;
                Cuadricula.add(label);
            }
        }

        //Añadimos la cuadricula al JPanel donde esta todo
        Cuadricula.setBounds(175, 100, 450, 450);
        Todo.add(Cuadricula);

        //Llamamos al metodo turno para defirnir el primer jugador
        Turno();
        Todo.add(JugadorActual); //Añadimos al JPanel el mensaje cambiante de jugador actual
        Todo.add(BuscarPalabras); //Añadimos al JPanel el mensaje cambiante de buscar palabras

        //Añadimos un resalte a la cuadricula para que no se pierda en el fondo
        URL url = getClass().getResource("Decoracion/blanco.png");
        ImageIcon icon = new ImageIcon(url);
        JLabel Blanco = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(Cuadricula.getWidth() - 10, Cuadricula.getHeight() - 10, Image.SCALE_SMOOTH)));
        Blanco.setBounds(180, 105, Cuadricula.getWidth() - 10, Cuadricula.getHeight() - 10);
        Todo.add(Blanco);

        // Cargar el icono de guardar
        url = getClass().getResource("Decoracion/Guardar.png");
        icon = new ImageIcon(url);

        //Creamos el boton
        botonGuardar = new JButton();
        //Le añadimos el icono escalando a las dimenciones necesitadas
        botonGuardar.setIcon(new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        botonGuardar.setBounds(590, 20, 25, 25);
        //Desactivamos unas caracteristicas del boton para que solo se muestre la imagen
        botonGuardar.setOpaque(false);
        botonGuardar.setContentAreaFilled(false);
        botonGuardar.setBorderPainted(false);
        botonGuardar.setFocusable(false);
        //Le cambiamos el cursor
        botonGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sonido) {
                    //Añadimos un sonido cuando se presiona
                    AudioClip click;
                    click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SClick.wav"));
                    click.play();
                }
                //Cuando se de click me abrira una ventana de VentanaOpciones
                VentanaOpciones ventanaOpciones = new VentanaOpciones(botonGuardar);
                ventanaOpciones.setVisible(true);
            }
        });
        //La añadimos al JPanel
        Todo.add(botonGuardar);

        botonConfiguracion = new JButton();
        //Botón de Configuración
        url = getClass().getResource("Decoracion/Config.png");
        icon = new ImageIcon(url);
        botonConfiguracion.setIcon(new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        botonConfiguracion.setBounds(botonGuardar.getX(), botonGuardar.getY() + 30, 25, 25);
        botonConfiguracion.setOpaque(false);
        botonConfiguracion.setContentAreaFilled(false);
        botonConfiguracion.setBorderPainted(false);
        botonConfiguracion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botonConfiguracion.setFocusable(false);
        botonConfiguracion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sonido) {
                    //Añadimos un sonido cuando se presiona
                    AudioClip click;
                    click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SClick.wav"));
                    click.play();
                }
                //Cuando se de click me abrira una ventana de Configuracion
                VentanaOpciones ventanaOpciones = new VentanaOpciones(botonConfiguracion);
                ventanaOpciones.setVisible(true);
            }
        });
        Todo.add(botonConfiguracion);

        // Cargar el GIF del reloj
        ImageIcon relojIcono = new ImageIcon(getClass().getResource("Decoracion/Reloj.gif"));

        // Crear un JLabel para mostrar el GIF del reloj
        JLabel relojLabel = new JLabel(relojIcono);
        relojLabel.setBounds(8, 15, relojIcono.getIconWidth(), relojIcono.getIconHeight());
        Todo.add(relojLabel);

        // Crear el JLabel para mostrar el tiempo
        tiempoLabel.setBounds(90, 15, 100, 100); // Ajusta las coordenadas según tus necesidades
        tiempoLabel.setFont(new Font("Roboto Condensed", 1, 30));

        Todo.add(tiempoLabel);

        //Un label aparte para mostrar el texto no cambiante del tiempo
        JLabel TiempRes = new JLabel("<html><div style='text-align: center;'>Tiempo<br>Restante:</div><html>");
        TiempRes.setBounds(tiempoLabel.getX(), tiempoLabel.getY() - 25, 125, 85); // Ajusta las coordenadas según tus necesidades
        TiempRes.setFont(new Font("Roboto Condensed", 1, 14));
        TiempRes.setForeground(Color.BLACK);
        Todo.add(TiempRes);

        //Creamos la lista de palabras que se deben de encontrar
        int salto = 0; //El salto será la distancia entre las palabras
        ListaPalabras = new JLabel[palabrasValidas.size()]; //Una matriz con todas las palabras
        for (int i = 0; i < palabrasValidas.size(); i++) {
            if (i < palabrasValidas.size() / 2) {
                //Un JLabel por cada palabra
                JLabel label = new JLabel(palabrasValidas.get(i));
                label.setBounds(10, 140 + salto, 100, 20);
                label.setFont((new Font("Roboto Condensed", 1, label.getHeight() - 8)));
                label.setForeground(Color.BLACK);
                ListaPalabras[i] = label;
                Todo.add(ListaPalabras[i]);
                salto += 20;
            } else {
                //Cuando se mostraron la primera mitad vuelve a donde se puso la primera pero más a la derecha para hacer una doble columna
                if ((palabrasValidas.size() / 2) == i) {
                    salto = 0;
                    JLabel label = new JLabel(palabrasValidas.get(i));
                    label.setBounds(100, 140 + salto, 100, 20);
                    label.setFont((new Font("Roboto Condensed", 1, label.getHeight() - 8)));
                    label.setForeground(Color.BLACK);
                    ListaPalabras[i] = label;
                    Todo.add(ListaPalabras[i]);
                    salto += 20;
                } else {
                    JLabel label = new JLabel(palabrasValidas.get(i));
                    label.setBounds(100, 140 + salto, 100, 20);
                    label.setFont((new Font("Roboto Condensed", 1, label.getHeight() - 8)));
                    label.setForeground(Color.BLACK);
                    ListaPalabras[i] = label;
                    Todo.add(ListaPalabras[i]);
                    salto += 20;
                }
            }
        }

        //Creamos un Jlabel que muestra el nombre del jugador 1 y su respectivo color
        Jug1.setText(Jugador1.getText());
        Jug1.setBounds(10, 365, 200, 100);
        Jug1.setFont(new Font("Roboto Condensed", 1, 20));
        Jug1.setForeground(Player1);
        Todo.add(Jug1);

        //Creamos un JLabel que muestra el texto cambiante de los puntos del jugador
        Punt1 = new JLabel("Puntos: " + PuntosJug1);
        Punt1.setBounds(20, Jug1.getY() + 30, 200, 100);
        Punt1.setFont(new Font("Roboto Condensed", 1, 30));
        Punt1.setForeground(Player1);
        Todo.add(Punt1);

        //Creamos un Jlabel que muestra el nombre del jugador 2 y su respectivo color
        Jug2.setText(Jugador2.getText());
        Jug2.setBounds(10, Punt1.getY() + 50, 200, 100);
        Jug2.setFont(new Font("Roboto Condensed", 1, 20));
        Jug2.setForeground(Player2);
        Todo.add(Jug2);

        //Creamos un JLabel que muestra el texto cambiante de los puntos del jugador
        Punt2 = new JLabel("Puntos: " + PuntosJug2);
        Punt2.setBounds(20, Jug2.getY() + 30, 200, 100);
        Punt2.setFont(new Font("Roboto Condensed", 1, 30));
        Punt2.setForeground(Player2);
        Todo.add(Punt2);

        //Llamamos al metodo Temporizador para iniciar el tiempo del turno
        Temporizador();

        //Añadimos un resalte las palabras a buscar, el tiempo y el nombre de los jugadores para que no se pierda en el fondo
        url = getClass().getResource("Decoracion/blanco.png");
        icon = new ImageIcon(url);
        JLabel Blanco1 = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(170, 535, Image.SCALE_SMOOTH)));
        Blanco1.setBounds(5, 10, 170, 535);
        Todo.add(Blanco1);

        //Añadimos el titulo de la tematica que varía dependiendo de la temática escogida
        icon = new ImageIcon(rutaT);
        JLabel Titulo = new JLabel(icon);
        Titulo.setBounds(Cuadricula.getX() + 5, 10, 400, 50);
        Todo.add(Titulo);

        //Añadimos un resalte al titulo, turno actual y los botones de configuracion y guardar para que no se pierda en el fondo
        url = getClass().getResource("Decoracion/blanco.png");
        icon = new ImageIcon(url);
        JLabel Blanco2 = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(444, 85, Image.SCALE_SMOOTH)));
        Blanco2.setBounds(Cuadricula.getX() + 5, 10, 440, 85);
        Todo.add(Blanco2);

        //Dependiendo de la temática estará cambiando el fondo del juego
        icon = new ImageIcon(ruta);
        if (Tematica != 2) {
            JLabel Fondito = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(Todo.getWidth(), Todo.getHeight(), Image.SCALE_SMOOTH)));
            Fondito.setBounds(0, 0, Todo.getWidth(), Todo.getHeight());
            Todo.add(Fondito);
            revalidate();
            repaint();
        } else {
            JLabel Fondito = new JLabel(icon);
            Fondito.setBounds(0, 0, Todo.getWidth(), Todo.getHeight());
            Todo.add(Fondito);
            revalidate();
            repaint();
        }

        //Mostramos en pantalla el turno del primer jugador
        if (Jugadas == 0) {
            //Me muestra en Pantalla quien es el primer jugador
            JOptionPane.showMessageDialog(this, "El Primer Jugador es: " + Player);
            //Aumenta el numero ya que no se volvera a escoger un primer jugador
            Jugadas++;
        }
    }

    /**
     * Determinara el Turno inicial y el cambio de turno, además del color de
     * cada jugador
     */
    public void Turno() {
        //Si es la primera vez que se ingresa genera al jugador N1
        if (Jugadas == 0) {
            //Genera 2 numeros random que representan al jugador 1 y 2
            int Num1 = (int) (Math.random() * 6) + 1;
            int Num2 = (int) (Math.random() * 6) + 1;
            boolean si = false;

            //Comprueba cual es mayor y asi se escoge el jugador que empieza
            do {
                if (Num1 > Num2) {
                    Player = Jugador1.getText();
                    si = true;
                    Cambio = 1;
                } else if (Num1 < Num2) {
                    Player = Jugador2.getText();
                    si = true;
                    Cambio = 2;
                } else {
                    Num1 = (int) (Math.random() * 6) + 1;
                    Num2 = (int) (Math.random() * 6) + 1;
                    si = false;
                } //Si son iguales repite la generacion de los numeros, el bucle no termina amenos de que haya dos numeros distintos
            } while (si == false);

            //Me muestra el turno actual
            JugadorActual.setText("Es turno de: " + Player);
            JugadorActual.setBounds(195, 60, this.getWidth(), 31);
            JugadorActual.setFont(new Font("Roboto Condensed", 1, JugadorActual.getHeight() - 4));

            //Me muestra el texto de palabras a buscar que variará dependiendo del turno
            BuscarPalabras.setText("Palabras a Buscar");
            BuscarPalabras.setBounds(10, 65, 180, 100); // Ajusta las coordenadas según tus necesidades
            BuscarPalabras.setFont(new Font("Roboto Condensed", 1, 18));

            //Dependiendo de que jugador haya sido el primero cambia el color 
            if (Cambio == 1) {
                BuscarPalabras.setForeground(Player1);
                JugadorActual.setForeground(Player1);
                tiempoLabel.setForeground(Player1);
            } else if (Cambio == 2) {
                BuscarPalabras.setForeground(Player2);
                JugadorActual.setForeground(Player2);
                tiempoLabel.setForeground(Player2);
            }

        } else {
            //Comprueba cual es el turno actual para cambiar al turno siguiente
            if (Cambio == 1) { //Si el turno lo tiene el jugador 1 cambia los colores y al nombre al del jugador 2
                Player = Jugador2.getText();
                JugadorActual.setText("Es turno de: " + Player);
                JugadorActual.setForeground(Player2);
                tiempoLabel.setForeground(Player2);
                BuscarPalabras.setForeground(Player2);
                Cambio++; //Aumentamos el numero ya que se esta cambiando al jugador 2
            } else if (Cambio == 2) { //Si el turno lo tiene el jugador 2 cambia los colores y al nombre al del jugador 1
                Player = Jugador1.getText();
                JugadorActual.setText("Es turno de: " + Player);
                JugadorActual.setForeground(Player1);
                tiempoLabel.setForeground(Player1);
                BuscarPalabras.setForeground(Player1);
                Cambio--; //Reducimos el numero ya que se esta cambiando al jugador 1
            }
        }
        tiempo = 30; //Como paso un turno, el tiempo del turno se reinicia a 30
    }

    /**
     * Nos sirve para determinar la duracion de cada turno
     */
    public void Temporizador() {
        // Creamos un timer que se ejecuta cada 1 segundo
        timer = new Timer(1000, new ActionListener() {
            // Contador de segundos

            @Override
            public void actionPerformed(ActionEvent e) {
                // Si el contador llega a cero, paramos el timer y cambio de turno
                if (tiempo == 0) {
                    ((Timer) e.getSource()).stop();
                    //Cambiamos de turno
                    Turno();
                    //Comprueba si el tiempo fue pausado por que se escogio una palabra o porque se acabo el tiempo
                    if (FinTiempo) {
                        timer.stop();
                    } else {
                        Temporizador();
                    }
                    //Inicia el JLabel del tiempo en 30
                    tiempoLabel.setText("00:30");
                } else {
                    // Si no, restamos un segundo y mostramos el contador en la venta
                    tiempo--;
                    int minutos = tiempo / 60;
                    int segundosRestantes = tiempo % 60;
                    // Formatear los minutos y segundos a dos dígitos
                    String tiempoFormateado = String.format("%02d:%02d", minutos, segundosRestantes);
                    tiempoLabel.setText(tiempoFormateado);
                }

                if (Cambio == 1) {
                    Tiempo1++;
                } else if (Cambio == 2) {
                    Tiempo2++;
                }

            }
        });
        // Iniciamos el timer
        timer.start();
    }

    /**
     * Nos sirve para marcar la palabra dependiendo del jugador
     *
     * @param row Fila de la matriz
     * @param col Columna de la Matriz
     */
    public void marcarPalabra(int row, int col) {
        if (!(mover)) { //Si no se esta siendo presionada o sea no hay movimiento me marca las letras dependiendo del turno
            if (labels[row][col].getVerifyInputWhenFocusTarget() == true) { //Si la palabra ya fue marcada no pasa de aquí
                if (Cambio == 1) { //Si esta en el turno del jugador 1 será rojo
                    labels[row][col].setBackground(Player1); //Cambiamos al color del jugador
                    labels[row][col].setForeground(Color.WHITE); //Cambiamos el color de la letra para que destaque más
                    labels[row][col].setOpaque(true); //Activamos la opacidad para que se muestre el fondo
                } else if (Cambio == 2) { //Si esta en el turno del jugador 2 será azul
                    labels[row][col].setBackground(Player2);
                    labels[row][col].setForeground(Color.WHITE);
                    labels[row][col].setOpaque(true);
                }
            }
        }
    }

    /**
     * Nos sirve para regresar la palabra a la normalidad cuando el mouse no
     * esta encima
     *
     * @param row Fila de la Matriz
     * @param col Columna de la Matriz
     */
    public void SalirPalabra(int row, int col) {
        if (!(mover)) { //Si no se esta siendo presionada o sea no hay movimiento me desmarca las letras
            if (labels[row][col].getVerifyInputWhenFocusTarget() == true) {
                labels[row][col].setOpaque(false); //Regresamos la opacidad a false para que no se muestre el fondo
                labels[row][col].setForeground(Color.black); //Regresamos el color de la letra a la normal
                labels[row][col].setBackground(Color.WHITE); //Regresamos el color de fondo a lo normal
            }
        }
    }

    /**
     * Nos sirve para Conocer la posicion inicial de donde se presiono
     *
     * @param row Fila de la matriz
     * @param col Columna de la Matriz
     */
    public void CaptarPalabra(int row, int col) {
        PosicionInicialR = row; //Guardamos las filas y columnas iniciales en sus respectivas variables
        PosicionInicialC = col;
    }

    /**
     * Nos sirve para conocer cuando se dejo de marcar la palabra
     *
     * @param row Fila de la matriz
     * @param col Columna de la Matriz
     */
    public void TerminarPalabra(int row, int col) {
        if (mover) { //Una vez se empieza a captar las palabras empieza y cuando se detiene guardamos la posicion de la matriz
            PosicionFinalR = row;
            PosicionFinalC = col;
            mover = false; //Hacemos mover false ya que cuando se activa el listener es cuando se dejo de presionar 
            Comprobacion(); //Llamamos a la comprobacion para saber si es una palabra valida
        }
    }

    /**
     * Nos ayuda a comprobar si la palabra seleccionada es valida
     */
    public void Comprobacion() {
        int inicio, fin, indice; //Declaramos unas variables auxiliares
        boolean encontrado = false, sube = false;
        Jugadas++; //Como se algo se selecciono aumenta el numero de jugadas
        //Si solamente se desplazo horizontalmente
        if (PosicionInicialR == PosicionFinalR && PosicionInicialC != PosicionFinalC) {
            //Comprobamos cual es el menor para hacer bucle y poder leerlas de derecha a izquierda o viceversa
            if (PosicionInicialC > PosicionFinalC) {
                inicio = PosicionFinalC;
                fin = PosicionInicialC;
            } else {
                inicio = PosicionInicialC;
                fin = PosicionFinalC;
            }

            //Unimos las letras que se seleccionaron en el recorrido
            for (int i = inicio; i <= fin; i++) {
                palabra += labels[PosicionInicialR][i].getText();
            }

            //Comprobamos si la palabra formada se encuentra en el arreglo
            if (palabrasValidas.contains(palabra)) {
                encontrado = true;
                //Si pertenece la marcamos y evitamos que se pueda desmarcar
                for (int i = inicio; i <= fin; i++) {
                    marcarPalabra(PosicionInicialR, i);
                    InmunePalabra(PosicionInicialR, i);
                }
            } else { //Si no se encontro la palabra la volteamos para revisar por el otro lado
                palabra = new StringBuilder().append(palabra).reverse().toString();
                if (palabrasValidas.contains(palabra)) {
                    encontrado = true;
                    //Si pertenece la marcamos y evitamos que se pueda desmarcar
                    for (int i = inicio; i <= fin; i++) {
                        marcarPalabra(PosicionInicialR, i);
                        InmunePalabra(PosicionInicialR, i);
                    }
                }
            }
            //Si solamente se desplazo verticalmente
        } else if (PosicionInicialR != PosicionFinalR && PosicionInicialC == PosicionFinalC) {

            //Comprobamos cual es el menor para hacer bucle y poder leerlas de abajo hacia arriba o viceversa
            if (PosicionInicialR > PosicionFinalR) {
                inicio = PosicionFinalR;
                fin = PosicionInicialR;
            } else {
                inicio = PosicionInicialR;
                fin = PosicionFinalR;
            }

            //Unimos las letras que se seleccionaron en el recorrido
            for (int i = inicio; i <= fin; i++) {
                palabra += labels[i][PosicionInicialC].getText();
            }

            //Comprobamos si la palabra formada se encuentra en el arreglo
            if (palabrasValidas.contains(palabra)) {
                encontrado = true;
                //Si pertenece la marcamos y evitamos que se pueda desmarcar
                for (int i = inicio; i <= fin; i++) {
                    marcarPalabra(i, PosicionInicialC);
                    InmunePalabra(i, PosicionInicialC);
                }
            } else {
                palabra = new StringBuilder().append(palabra).reverse().toString();
                if (palabrasValidas.contains(palabra)) {
                    encontrado = true;
                    //Si pertenece la marcamos y evitamos que se pueda desmarcar
                    for (int i = inicio; i <= fin; i++) {
                        marcarPalabra(i, PosicionInicialC);
                        InmunePalabra(i, PosicionInicialC);
                    }
                }
            }

            //Si se movio en diagonal
        } else if (PosicionInicialR != PosicionFinalR && PosicionInicialC != PosicionFinalC) {

            //Si se movio en diagonal \ tanto de arriba hacia abajo como viceversa
            if ((PosicionInicialR < PosicionFinalR && PosicionInicialC < PosicionFinalC) || (PosicionInicialR > PosicionFinalR && PosicionInicialC > PosicionFinalC)) {

                //Comprobamos si esta de subida o de bajada
                if (PosicionInicialR < PosicionFinalR) {
                    sube = false;
                } else {
                    sube = true;
                }

                //Dependiendo del valor se ejecutara unas instrucciones o otras
                if (sube) {

                    for (int i = 0; i <= PosicionInicialR - PosicionFinalR; i++) {
                        palabra += labels[PosicionFinalR + i][PosicionFinalC + i].getText();
                    }

                    //Comprobamos si la palabra formada se encuentra en el arreglo
                    if (palabrasValidas.contains(palabra)) {
                        encontrado = true;
                        //Si pertenece la marcamos y evitamos que se pueda desmarcar
                        for (int i = 0; i <= PosicionInicialR - PosicionFinalR; i++) {
                            marcarPalabra(PosicionInicialR - i, PosicionInicialC - i);
                            InmunePalabra(PosicionInicialR - i, PosicionInicialC - i);
                        }
                    } else {
                        palabra = new StringBuilder().append(palabra).reverse().toString();
                        if (palabrasValidas.contains(palabra)) {
                            encontrado = true;
                            //Si pertenece la marcamos y evitamos que se pueda desmarcar
                            for (int i = 0; i <= PosicionInicialR - PosicionFinalR; i++) {
                                marcarPalabra(PosicionInicialR - i, PosicionInicialC - i);
                                InmunePalabra(PosicionInicialR - i, PosicionInicialC - i);
                            }
                        }
                    }

                } else {

                    for (int i = 0; i <= PosicionFinalR - PosicionInicialR; i++) {
                        palabra += labels[PosicionInicialR + i][PosicionInicialC + i].getText();
                    }
                    //Comprobamos si la palabra formada se encuentra en el arreglo
                    if (palabrasValidas.contains(palabra)) {
                        encontrado = true;
                        //Si pertenece la marcamos y evitamos que se pueda desmarcar
                        for (int i = 0; i <= PosicionFinalR - PosicionInicialR; i++) {
                            marcarPalabra(PosicionInicialR + i, PosicionInicialC + i);
                            InmunePalabra(PosicionInicialR + i, PosicionInicialC + i);
                        }
                    } else {
                        palabra = new StringBuilder().append(palabra).reverse().toString();
                        if (palabrasValidas.contains(palabra)) {
                            encontrado = true;
                            //Si pertenece la marcamos y evitamos que se pueda desmarcar
                            for (int i = 0; i <= PosicionFinalR - PosicionInicialR; i++) {
                                marcarPalabra(PosicionInicialR + i, PosicionInicialC + i);
                                InmunePalabra(PosicionInicialR + i, PosicionInicialC + i);
                            }
                        }
                    }
                }

                //Si se movio en diagonal / de abajo hacia arriba   
            } else if (PosicionInicialR > PosicionFinalR && PosicionInicialC < PosicionFinalC) {
                //Unimos las letras que se seleccionaron en el recorrido

                for (int i = 0; i <= PosicionInicialR - PosicionFinalR; i++) {
                    palabra += labels[PosicionFinalR + i][PosicionFinalC - i].getText();
                }

                //Comprobamos si la palabra formada se encuentra en el arreglo
                if (palabrasValidas.contains(palabra)) {
                    encontrado = true;
                    //Si pertenece la marcamos y evitamos que se pueda desmarcar
                    for (int i = 0; i <= PosicionInicialR - PosicionFinalR; i++) {
                        marcarPalabra(PosicionInicialR - i, PosicionInicialC + i);
                        InmunePalabra(PosicionInicialR - i, PosicionInicialC + i);
                    }
                } else {
                    palabra = new StringBuilder().append(palabra).reverse().toString();
                    if (palabrasValidas.contains(palabra)) {
                        encontrado = true;
                        //Si pertenece la marcamos y evitamos que se pueda desmarcar
                        for (int i = 0; i <= PosicionInicialR - PosicionFinalR; i++) {
                            marcarPalabra(PosicionInicialR - i, PosicionInicialC + i);
                            InmunePalabra(PosicionInicialR - i, PosicionInicialC + i);
                        }
                    }
                }

                //Si se movio en diagonal / de arriba hacia abajo       
            } else if (PosicionInicialR < PosicionFinalR && PosicionInicialC > PosicionFinalC) {

                //Unimos las letras que se seleccionaron en el recorrido
                for (int i = 0; i <= PosicionFinalR - PosicionInicialR; i++) {
                    palabra += labels[PosicionInicialR + i][PosicionInicialC - i].getText();
                }

                //Comprobamos si la palabra formada se encuentra en el arreglo
                if (palabrasValidas.contains(palabra)) {
                    encontrado = true;
                    //Si pertenece la marcamos y evitamos que se pueda desmarcar
                    for (int i = 0; i <= PosicionFinalR - PosicionInicialR; i++) {
                        marcarPalabra(PosicionInicialR + i, PosicionInicialC - i);
                        InmunePalabra(PosicionInicialR + i, PosicionInicialC - i);
                    }
                } else {
                    palabra = new StringBuilder().append(palabra).reverse().toString();
                    if (palabrasValidas.contains(palabra)) {
                        encontrado = true;
                        //Si pertenece la marcamos y evitamos que se pueda desmarcar
                        for (int i = 0; i <= PosicionFinalR - PosicionInicialR; i++) {
                            marcarPalabra(PosicionInicialR + i, PosicionInicialC - i);
                            InmunePalabra(PosicionInicialR + i, PosicionInicialC - i);
                        }
                    }
                }
            }

        }
        //Si la palabra fue encontrada
        if (encontrado) {

            if (sonido) {
                //Incluimos un sonido de que se encontro la palabra
                AudioClip Correcto;
                Correcto = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SCorrecto.wav"));
                Correcto.play();
            }

            //Evitamos que la palabra vuelva a salir
            indice = palabrasValidas.indexOf(palabra);
            palabrasValidas.set(indice, "0");

            //Dependiendo del turno se suman los puntos a uno u otro jugador
            if (Cambio == 1) {
                PuntosJug1++;
                PuntosLetrasJug1 += palabra.length();
                //Tambien se actualizan los datos que cambian
                ListaPalabras[indice].setForeground(Player1);
                Punt1.setText("Puntos: " + PuntosJug1);
            } else if (Cambio == 2) {
                PuntosJug2++;
                PuntosLetrasJug2 += palabra.length();
                ListaPalabras[indice].setForeground(Player2);
                Punt2.setText("Puntos: " + PuntosJug2);
            }

            //Detenemos el tiempo para que no siga corriendo de fondo y lo reiniciamos
            timer.stop();
            tiempo = 0;
            FinTiempo = true;
            timer.start();
            //Mostramos en pantalla la palabra encontrada
            JOptionPane.showMessageDialog(this, "Enhorabuena, la palabra: " + palabra + " ha sido encontrada");
            timer.start();
            FinTiempo = false;

            //Aumentamos el numero de palabras encontrados
            PalabrasEncontradas++;
        } else {

            if (sonido) {
                //Incluimos un sonido de que no se encontro la palabra
                AudioClip Incorrecto;
                Incorrecto = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SIncorrecto.wav"));
                Incorrecto.play();
            }

            timer.stop();
            tiempo = 0;
            FinTiempo = true;
            timer.start();
            //Mostramos en pantalla que no se pudo encontrar la palabra
            JOptionPane.showMessageDialog(this, "Mala Suerte, la palabra no ha sido encontrada");
            timer.start();
            FinTiempo = false;

            //Desmarcamos la posicion inicial donde empezo la seleccion
            if (labels[PosicionInicialR][PosicionInicialC].getVerifyInputWhenFocusTarget() == true) {
                labels[PosicionInicialR][PosicionInicialC].setBackground(Color.WHITE);
                labels[PosicionInicialR][PosicionInicialC].setForeground(Color.black);
                labels[PosicionInicialR][PosicionInicialC].setOpaque(false);
            }
        }
        palabra = ""; //Volvemos a la palabra a vacio

        //Comprobamos si ya se encontraron todas las palabras
        if (palabrasValidas.size() == PalabrasEncontradas) {
            timer.stop();
            if (sonido) {
                //Reproducimos un sonido de victoria cuando eso pase
                AudioClip Win;
                Win = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SVictoria.wav"));
                Win.play();
            }

            //Comprobamos quien encontro mas palabras y en caso de empate el que tenga menos letras en sus palabras gana
            if (PuntosJug1 > PuntosJug2) {
                JOptionPane.showMessageDialog(this, "El ganador es: " + Jugador1.getText());
            } else if (PuntosJug1 < PuntosJug2) {
                JOptionPane.showMessageDialog(this, "El ganador es: " + Jugador2.getText());
            } else {
                if (PuntosLetrasJug1 < PuntosLetrasJug2) {
                    JOptionPane.showMessageDialog(this, "El ganador es: " + Jugador1.getText());
                } else if (PuntosLetrasJug1 > PuntosLetrasJug2) {
                    JOptionPane.showMessageDialog(this, "El ganador es: " + Jugador2.getText());
                } else {
                    JOptionPane.showMessageDialog(this, "El Ganador es... Sorpresivamente es un Empate");
                }
            }
            VentanaOpciones ventanaOpciones = new VentanaOpciones(null);
            ventanaOpciones.setVisible(true);
        }
    }

    /**
     * Nos ayuda a evitar que la palabra sea superpuesta por un color cuando se
     * pasa por encima
     *
     * @param row Fila de la matriz
     * @param col Columna de la matriz
     */
    public void InmunePalabra(int row, int col) {
        //Lo hacemos false porque predeterminado viene en true
        labels[row][col].setVerifyInputWhenFocusTarget(false);
    }

    /**
     * Nos ayuda a guardar el progreso del juego
     *
     * @throws IOException Lanzador de excepcion
     */
    public void guardarJuego() throws IOException {

        //Creamos un selector de archivos, pero en este caso que sea solo la ruta que se seleccion
        JFileChooser Select = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        Select.setDialogTitle("Seleccione la carpeta donde guardara la partida");
        Select.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        //Guardamos si se selecciono o no
        int Selecciono = Select.showSaveDialog(null);

        //Si se selecciono empieza el progreso de guardado
        if (Selecciono == JFileChooser.APPROVE_OPTION) {

            //Creamos los objetos que nos ayudaran a realizar las operaciones
            FileWriter guardado = null;
            PrintWriter lectura = null;

            try { //Creamos un Try y Catch para las excepciones

                //Nombramos el Guardado como Partida.txt
                guardado = new FileWriter(Select.getSelectedFile() + "\\Partida.dat");

                //Empezamos la lectura de los datos
                lectura = new PrintWriter(guardado);

                //Guardamos la temática actual
                lectura.println("D-" + Tematica);

                //Guardamos los nombres y puntos de los Jugadores
                lectura.print("1-" + Jugador1.getText());
                lectura.print("-" + PuntosJug1);
                lectura.print("-" + PuntosLetrasJug1);
                lectura.println("-" + Tiempo1);
                lectura.print("2-" + Jugador2.getText());
                lectura.print("-" + PuntosJug2);
                lectura.print("-" + PuntosLetrasJug2);
                lectura.println("-" + Tiempo2);

                //Guardamos el tiempo del turno actual
                lectura.println("t-" + tiempo);

                //Guardamos el turno actual
                lectura.println("T-" + Cambio);

                //Guardamos las palabras de la lista de encontrados de lado izquierdo
                lectura.print("L-");
                for (int i = 0; i < palabrasValidas.size(); i++) { //Un bucle que se repetira segun la cantidad de palabras a buscar

                    if ((1 + i) != palabrasValidas.size()) { //Comprueba si esta en la ultima posicion o no
                        //Dependiendo del color con que este marcada la guardamos
                        if (ListaPalabras[i].getForeground() == Player1) { //1 Si es el jugador 1
                            lectura.print(1 + "-");
                        } else if (ListaPalabras[i].getForeground() == Player2) { //2 Si es el jugador 2
                            lectura.print(2 + "-");
                        } else { //0 Si no esta marcada
                            lectura.print(0 + "-");
                        }

                    } else { //Si es la ultima posicion evitamos el "-"

                        if (ListaPalabras[i].getForeground() == Player1) {
                            lectura.println(1);
                        } else if (ListaPalabras[i].getForeground() == Player2) {
                            lectura.println(2);
                        } else {
                            lectura.println(0);
                        }
                    }
                }

                //Guardamos si las palabras de la cuadricula estan marcadas
                lectura.print("M-");
                for (int i = 0; i < matriz.length; i++) { //El for se repetira por la longitud de las filas y las columnas
                    for (int j = 0; j < matriz[i].length; j++) {
                        if ((1 + i) != matriz.length || (1 + j) != matriz[i].length) { //Comprobamos si no es la ultima posicion
                            if (labels[i][j].getBackground() == Player1) { //Comprobamos el color de los label para saber si estan marcados
                                lectura.print(1 + "-");
                            } else if (labels[i][j].getBackground() == Player2) {
                                lectura.print(2 + "-");
                            } else {
                                lectura.print(0 + "-");
                            }
                        } else {
                            if (labels[i][j].getBackground() == Player1) {
                                lectura.println(1);
                            } else if (labels[i][j].getBackground() == Player2) {
                                lectura.println(2);
                            } else {
                                lectura.println(0);
                            }
                        }
                    }
                }

                //Guardamos la lista de las palabras que quedan por buscar
                lectura.print("S-");
                for (int i = 0; i < palabrasValidas.size(); i++) {
                    if ((1 + i) != palabrasValidas.size()) {
                        lectura.print(palabrasValidas.get(i) + "-");

                    } else {
                        lectura.println(palabrasValidas.get(i));
                    }
                }

                //Guardamos la cantidad de palabras encontradas
                lectura.println("P-" + PalabrasEncontradas);

                //Guardamos la Cantidad se Jugadas
                lectura.println("C-" + Jugadas);

                if (sonido) {
                    //Incluimos un sonido de que se guardo con exito
                    AudioClip Correcto;
                    Correcto = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SExito.wav"));
                    Correcto.play();
                }

                JOptionPane.showMessageDialog(null, "Se ha Guardado con Exito");
            } catch (Exception e) {
                //Si salta una excepcion la mostramos en pantalla
                if (sonido) {
                    //Incluimos un sonido de que no se guardo con exito
                    AudioClip Fallo;
                    Fallo = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SFallo.wav"));
                    Fallo.play();
                }

                JOptionPane.showMessageDialog(this, "No se pudo guardar: " + e.getMessage());
            } finally {
                //Cerramos el archivo una vez termina la escritura de datos
                guardado.close();
            }
        } else {
            //Si no se selecciona una ruta simplemente no se selecciono y no se pudo guardar
            if (sonido) {
                //Incluimos un sonido de que no se guardo con exito
                AudioClip Fallo;
                Fallo = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SFallo.wav"));
                Fallo.play();
            }
            JOptionPane.showMessageDialog(null, "No se ha seleccionado una direccion");
        }
    }

    /**
     * Nos ayuda a leer la partida guardada
     */
    public void cargarJuego() {

        //Creamos un selector de archivos, pero en este caso que sea solo pueda seleccionar .txt
        JFileChooser Select = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de Partida", "dat");
        Select.setFileFilter(filtro); //Usamos el filtro para solo seleccion de txt
        int Selecciono = Select.showOpenDialog(null);

        if (Selecciono == JFileChooser.APPROVE_OPTION) {

            //Creamos los objetos que nos ayudaran a realizar las operaciones
            FileReader guardado;
            BufferedReader lectura;

            try {
                //Seleccionamos el archivo de la partida
                guardado = new FileReader(Select.getSelectedFile());

                //Comprobamos si esta listo para ser leido
                if (guardado.ready()) {

                    //Empezamos a leerlo
                    lectura = new BufferedReader(guardado);
                    String info;

                    //Seguira leyendo mientras no encuentre una linea vacia
                    while ((info = lectura.readLine()) != null) {

                        //Cargamos la temática que estaba cuando se guardo
                        if (info.charAt(0) == 'D') {
                            String[] Separado = info.split("-");
                            getContentPane().remove(Todo);
                            revalidate();
                            repaint();
                            Tematica = Integer.parseInt(Separado[1]);
                            Tema(Tematica);
                            timer.stop();
                        }

                        //Con la numeracion que hicimos al guardar cargamos las datos especificos que queremos obtener
                        //Cargamos el nombre y puntuacion del jugador 1
                        if (info.charAt(0) == '1') {
                            String[] Separado = info.split("-");
                            Jugador1.setText(Separado[1]);
                            PuntosJug1 = Integer.parseInt(Separado[2]);
                            PuntosLetrasJug1 = Integer.parseInt(Separado[3]);
                            Tiempo1 = Integer.parseInt(Separado[4]);
                            Punt1.setText("Puntos: " + PuntosJug1);
                            Jug1.setText(Jugador1.getText());
                        }

                        //Cargamos el nombre y puntuacion del jugador 2
                        if (info.charAt(0) == '2') {
                            String[] Separado = info.split("-");
                            Jugador2.setText(Separado[1]);
                            PuntosJug2 = Integer.parseInt(Separado[2]);
                            PuntosLetrasJug2 = Integer.parseInt(Separado[3]);
                            Tiempo2 = Integer.parseInt(Separado[4]);
                            Punt2.setText("Puntos: " + PuntosJug2);
                            Jug2.setText(Jugador2.getText());
                        }

                        //Cargamos el tiempo que restante del turno
                        if (info.charAt(0) == 't') {
                            String[] Separado = info.split("-");
                            tiempo = Integer.parseInt(Separado[1]);
                            int minutos = tiempo / 60;
                            int segundosRestantes = tiempo % 60;
                            String tiempoFormateado = String.format("%02d:%02d", minutos, segundosRestantes);
                            tiempoLabel.setText(tiempoFormateado);
                        }

                        //Cargamos el turno que estaba cuando se guardo
                        if (info.charAt(0) == 'T') {
                            String[] Separado = info.split("-");
                            Cambio = Integer.parseInt(Separado[1]);

                            //Dependiendo del turno actualizamos todos los datos
                            if (Cambio == 1) { //Si el turno lo tiene el jugador 1 cambia los colores y al nombre al del jugador 2
                                Player = Jugador1.getText();
                                JugadorActual.setText("Es turno de: " + Player);
                                JugadorActual.setForeground(Player1);
                                tiempoLabel.setForeground(Player1);
                                BuscarPalabras.setForeground(Player1);

                            } else if (Cambio == 2) { //Si el turno lo tiene el jugador 2 cambia los colores y al nombre al del jugador 1
                                Player = Jugador2.getText();
                                JugadorActual.setText("Es turno de: " + Player);
                                JugadorActual.setForeground(Player2);
                                tiempoLabel.setForeground(Player2);
                                BuscarPalabras.setForeground(Player2);
                            }
                        }

                        //Cargamos la lista de palabras que se deben de buscar que esta del lado izquierdo
                        if (info.charAt(0) == 'L') {

                            String[] Separado = info.split("-");

                            //Dependiendo del color guardado, marca la lista de un color u otro
                            for (int i = 0; i < palabrasValidas.size(); i++) {
                                if (Integer.parseInt(Separado[1 + i]) == 1) {
                                    ListaPalabras[i].setForeground(Player1);
                                } else if (Integer.parseInt(Separado[1 + i]) == 2) {
                                    ListaPalabras[i].setForeground(Player2);
                                } else {
                                    ListaPalabras[i].setForeground(Color.black);
                                }
                            }
                        }

                        //Cargamos la matriz de los labels
                        if (info.charAt(0) == 'M') {
                            int aux = 0;
                            String[] Separado = info.split("-");
                            for (int i = 0; i < matriz.length; i++) {
                                for (int j = 0; j < matriz[i].length; j++) { //Dependiendo de si esta marcada cambia los datos
                                    if (Integer.parseInt(Separado[1 + aux]) == 1) {
                                        labels[i][j].setBackground(Player1);
                                        labels[i][j].setForeground(Color.WHITE);
                                        labels[i][j].setOpaque(true);
                                        labels[i][j].setVerifyInputWhenFocusTarget(false);
                                    } else if (Integer.parseInt(Separado[1 + aux]) == 2) {
                                        labels[i][j].setBackground(Player2);
                                        labels[i][j].setForeground(Color.WHITE);
                                        labels[i][j].setOpaque(true);
                                        labels[i][j].setVerifyInputWhenFocusTarget(false);
                                    } else {
                                        labels[i][j].setBackground(Color.WHITE);
                                        labels[i][j].setForeground(Color.black);
                                        labels[i][j].setOpaque(false);
                                        labels[i][j].setVerifyInputWhenFocusTarget(true);
                                    }
                                    aux++;
                                }
                            }
                        }

                        //Cargamos el arreglo de las matriz actuales
                        if (info.charAt(0) == 'S') {
                            String[] Separado = info.split("-");
                            for (int i = 0; i < palabrasValidas.size(); i++) {
                                palabrasValidas.set(i, Separado[i + 1]);
                            }
                        }

                        //Cargamos la cantidad de palabras restantes
                        if (info.charAt(0) == 'P') {
                            String[] Separado = info.split("-");
                            PalabrasEncontradas = Integer.parseInt(Separado[1]);
                        }

                        //Cargamos la cantidad de Jugadas
                        if (info.charAt(0) == 'C') {
                            String[] Separado = info.split("-");
                            Jugadas = Integer.parseInt(Separado[1]);
                        }

                    }
                    if (sonido) {
                        //Incluimos un sonido de que se cargo con exito
                        AudioClip Correcto;
                        Correcto = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SExito.wav"));
                        Correcto.play();
                    }

                    JOptionPane.showMessageDialog(null, "La partida ha sido cargada exitosamente");
                } else {
                    if (sonido) {
                        //Incluimos un sonido de que no se cargo con exito
                        AudioClip Fallo;
                        Fallo = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SFallo.wav"));
                        Fallo.play();
                    }

                    //Si no se pudo alistar muestra un mensaje
                    JOptionPane.showMessageDialog(null, "No se pudo leer el archivo");
                }
            } catch (Exception e) {
                if (sonido) {
                    //Incluimos un sonido de que no se cargo con exito
                    AudioClip Fallo;
                    Fallo = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SFallo.wav"));
                    Fallo.play();
                }

                //Si lanza la excepcion la muestra en pantalla
                JOptionPane.showMessageDialog(this, "No se pudo Cargar: " + e.getMessage());
            }
        } else {
            if (sonido) {
                //Incluimos un sonido de que no se cargo con exito
                AudioClip Fallo;
                Fallo = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SFallo.wav"));
                Fallo.play();
            }

            //Iniciamos el tiempo y mostramos en pantalla que no se pudo cargar
            timer.start();
            JOptionPane.showMessageDialog(null, "No se seleccionó un archivo");
        }
    }

    /**
     * Nos ayudara a poder mostrar invocar un JDialog
     */
    public class VentanaOpciones extends JDialog {

        /**
         * Nos sirve para crear el JDialog dependiendo del boton presionado
         *
         * @param Click Le pasamos un JButton dependiendo si es Configuracion o
         * guardado
         */
        public VentanaOpciones(JButton Click) {
            //Detenemos el tiempo
            timer.stop();
            //Configuramos la ventana
            setModal(true);
            setResizable(false);

            //Le añadimos un WindowClosing para que al cerrar inicie el tiempo
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    if (sonido) {
                        //Añadimos un sonido cuando se salga
                        AudioClip click;
                        click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SClick.wav"));
                        click.play();
                    }
                    //Al momento de cerrar la ventana el tiempo vuelve a correr
                    timer.start();
                }
            });
            
            //Dependiendo de que elemento se le paso, mostrara guardar, las opciones o salir
            if (Click == botonGuardar) {
                VentanaGuardado();
            } else if (Click == botonConfiguracion) {
                VentanaConfiguracion();
            } else {
                Salida();
            }
        }

        /**
         * Es el encargado de mostrar las configuraciones de guardado
         */
        public void VentanaGuardado() {
            setSize(240, 110);
            setLocationRelativeTo(null);
            //Le cambiamos el titulo
            setTitle("Opciones De Guardado");
            // JPanel para las opciones
            JPanel panel = new JPanel();

            // Botón para guardar
            ImageIcon icon = new ImageIcon(getClass().getResource("Decoracion/New.png"));
            JButton botonGuardar = new JButton("Guardar");
            //Le añadimos la imagen al boton
            botonGuardar.setIcon(new ImageIcon(icon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
            //Cambiamos el cursor
            botonGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            //Quitamos que puede ser focusable 
            botonGuardar.setFocusable(false);
            botonGuardar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (sonido) {
                            //Añadimos un sonido cuando se presiona
                            AudioClip click;
                            click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SClick.wav"));
                            click.play();
                        }

                        //Llamamos a la funcion de llamar el juego
                        guardarJuego();
                        //Iniciamos el tiempo despues que se termina de guardar
                        timer.start();
                    } catch (IOException ex) {
                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dispose(); // Cierra la ventana después de guardar
                }
            });
            panel.add(botonGuardar);

            // Botón para cargar
            icon = new ImageIcon(getClass().getResource("Decoracion/Cargar.png"));
            JButton botonCargar = new JButton("Cargar");
            botonCargar.setIcon(new ImageIcon(icon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
            botonCargar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            botonCargar.setFocusable(false);
            botonCargar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (sonido) {
                        //Añadimos un sonido cuando se presiona
                        AudioClip click;
                        click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SClick.wav"));
                        click.play();
                    }

                    //Llamamos a la funcion de cargar el juego
                    cargarJuego();
                    timer.start();
                    dispose(); // Cierra la ventana después de cargar
                }
            });
            panel.add(botonCargar);

            // Botón para salir
            icon = new ImageIcon(getClass().getResource("Decoracion/Cerrar.png"));
            JButton botonSalir = new JButton("Salir");
            botonSalir.setIcon(new ImageIcon(icon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
            botonSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            botonSalir.setFocusable(false);
            botonSalir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (sonido) {
                        //Añadimos un sonido cuando se presiona
                        AudioClip click;
                        click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SClick.wav"));
                        click.play();
                    }

                    timer.start();
                    dispose(); // Cierra la ventana sin hacer nada
                }
            });
            panel.add(botonSalir);

            // Agrega el panel al contenido del diálogo
            this.getContentPane().add(panel);
        }

        /**
         * Es el encargado de mostrar las configuracion general
         */
        public void VentanaConfiguracion() {
            setSize(240, 110);
            setLocationRelativeTo(null);
            //Le cambiamos el titulo
            setTitle("Opciones Generales");
            // JPanel para las opciones
            JPanel panel = new JPanel();

            //Le añadimos un listener al checkBox
            checkBoxSonido.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    //Si es seleccionada activamos el sonido
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        //Añadimos un sonido cuando se activa
                        AudioClip check;
                        check = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SCheck.wav"));
                        check.play();
                        sonido = true;
                    } else {//Si se deselecciona desactivamos todos los sonidos
                        sonido = false;
                    }
                }
            });
            panel.add(checkBoxSonido);

            // Botón para salir
            ImageIcon icon = new ImageIcon(getClass().getResource("Decoracion/Cerrar.png"));
            JButton botonSalir = new JButton("Salir");
            botonSalir.setIcon(new ImageIcon(icon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
            botonSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            botonSalir.setFocusable(false);
            botonSalir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (sonido) {
                        //Añadimos un sonido cuando se presiona
                        AudioClip click;
                        click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SClick.wav"));
                        click.play();
                    }
                    timer.start();
                    dispose(); // Cierra la ventana sin hacer nada
                }
            });
            panel.add(botonSalir);

            this.getContentPane().add(panel);
        }

        /**
         * Nos ayuda a mostrar las opciones cuando termina el juego
         */
        public void Salida() {
            //Le quitamos la posibilidad de cerrarse 
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            setSize(180, 170);
            setLocationRelativeTo(this);
            //Le cambiamos el titulo
            setTitle("Fin de la partida");
            // JPanel para las opciones
            JPanel panel = new JPanel();

            //Boton de regresar al menu
            ImageIcon icon = new ImageIcon(getClass().getResource("Decoracion/flecha.png"));
            JButton botonMenu = new JButton("Otra Temática");
            botonMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            botonMenu.setFocusable(false);
            botonMenu.setIcon(new ImageIcon(icon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
            botonMenu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (sonido) {
                        //Añadimos un sonido cuando se presiona
                        AudioClip click;
                        click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SClick.wav"));
                        click.play();
                    }
                    dispose();
                    //Llamamos a la funcion de restaurar los valores predeterminados
                    Restaurar();
                    for (int i = 0; i < ListaPalabras.length; i++) {
                        ListaPalabras[i].setForeground(Color.BLACK);
                    }
                    //Llamamos a la funcion del menu de tematicas
                    MostrarPanelTematicas();
                    revalidate();
                    repaint();
                }
            });
            panel.add(botonMenu);

            icon = new ImageIcon(getClass().getResource("Decoracion/Reinicio.png"));
            // Botón para Reiniciar
            JButton botonRepetir = new JButton("Volver a Jugar");
            botonRepetir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            botonRepetir.setFocusable(false);
            botonRepetir.setIcon(new ImageIcon(icon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
            botonRepetir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (sonido) {
                        //Añadimos un sonido cuando se presiona
                        AudioClip click;
                        click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SClick.wav"));
                        click.play();
                    }
                    dispose();
                    if (sonido) {
                        AudioClip press;
                        press = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SInicio.wav"));
                        press.play();
                    }
                    //Llamamos a la funcion de restaurar los valores predeterminados
                    Restaurar();
                    //Llamamos a la funcion que inicia el juego
                    Juego();
                    for (int i = 0; i < ListaPalabras.length; i++) {
                        ListaPalabras[i].setForeground(Color.BLACK);
                    }
                    revalidate();
                    repaint();
                }
            });
            panel.add(botonRepetir);

            icon = new ImageIcon(getClass().getResource("Decoracion/Estadistica.png"));
            // Botón para salir
            JButton botonEstadisticas = new JButton("Estadisticas");
            botonEstadisticas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            botonEstadisticas.setFocusable(false);
            botonEstadisticas.setIcon(new ImageIcon(icon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
            botonEstadisticas.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (sonido) {
                        //Añadimos un sonido cuando se presiona
                        AudioClip click;
                        click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SClick.wav"));
                        click.play();
                    }
                    getContentPane().remove(panel);
                    revalidate();
                    repaint();
                    Estadisticas();
                    revalidate();
                    repaint();
                }
            });
            panel.add(botonEstadisticas);

            // Botón para salir
            icon = new ImageIcon(getClass().getResource("Decoracion/Cerrar.png"));
            JButton botonSalir = new JButton("Salir");
            botonSalir.setIcon(new ImageIcon(icon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
            botonSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            botonSalir.setFocusable(false);
            botonSalir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (sonido) {
                        //Añadimos un sonido cuando se presiona
                        AudioClip click;
                        click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SBye.wav"));
                        click.play();
                    }
                    dispose();
                    //Desaparecemos el JFrame
                    setVisible(false);
                    //Si se presiona en 2 segundo se cierra el juego
                    Timer Salir = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //Mostramos un ultimo mensaje de despedida antes de cerrarlo
                            JOptionPane.showMessageDialog(null, "Hasta la próxima...");
                            System.exit(0);
                        }
                    });
                    //Iniciamos el timer
                    Salir.start();
                }
            });
            panel.add(botonSalir);

            this.getContentPane().add(panel);
        }

        /**
         * Encargado de mostrar las estadisticas en pantalla
         */
        public void Estadisticas() {
            //Eliminamos todos los listener activos de window
            for (WindowListener wl : getWindowListeners()) {
                removeWindowListener(wl);
            }
            setSize(250, 350);
            setLocationRelativeTo(this);
            //Le cambiamos el titulo
            setTitle("Estadisticas de la Partida");

            JPanel panel = new JPanel(); //Le creamos un layaout para que los objetos esten ordenados en Y
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            //Le añadimos un WindowClosing para que regrese al menu anterior
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    if (sonido) {
                        //Añadimos un sonido cuando se salga
                        AudioClip click;
                        click = java.applet.Applet.newAudioClip(getClass().getResource("Decoracion/SClick.wav"));
                        click.play();
                    }
                    //Removemos el panel actual
                    getContentPane().remove(panel);

                    //Refrescamos
                    revalidate();
                    repaint();

                    //Llamamos al panel anterior
                    Salida();
                    revalidate();
                    repaint();
                }
            });

            //Nombre del Jugador 1
            JLabel Jug1 = new JLabel(Jugador1.getText());
            Jug1.setFont(new Font("Roboto Condendsed", 1, 15));
            Jug1.setForeground(Player1);
            JPanel aux1 = new JPanel(); //Creamos paneles auxiliares por cada objeto que se ingresara
            aux1.add(Jug1);

            //Puntuacion del jugador 1
            JLabel Puntos1 = new JLabel("Puntuacion: " + Integer.toString(PuntosJug1));
            Puntos1.setFont(new Font("Roboto Condendsed", 1, 15));
            JPanel aux2 = new JPanel();
            aux2.add(Puntos1);

            //El numero de letras que encontro el jugador 1
            JLabel PuntosP1 = new JLabel("N° Letras encontradas: " + Integer.toString(PuntosLetrasJug1));
            PuntosP1.setFont(new Font("Roboto Condendsed", 1, 15));
            JPanel aux3 = new JPanel();
            aux3.add(PuntosP1);

            //El tiempo de juego del jugador 1
            JLabel TiempoJ1 = new JLabel();
            int minutos = Tiempo1 / 60;
            int segundosRestantes = Tiempo1 % 60;
            String tiempoFormateado = String.format("Tiempo de Juego: %02d:%02d", minutos, segundosRestantes);
            TiempoJ1.setText(tiempoFormateado);
            TiempoJ1.setFont(new Font("Roboto Condendsed", 1, 15));
            JPanel aux4 = new JPanel();
            aux4.add(TiempoJ1);

            JLabel Jug2 = new JLabel(Jugador2.getText());
            Jug2.setFont(new Font("Roboto Condendsed", 1, 15));
            Jug2.setForeground(Player2);
            JPanel aux5 = new JPanel();
            aux5.add(Jug2);

            JLabel Puntos2 = new JLabel("Puntuacion: " + Integer.toString(PuntosJug2));
            Puntos2.setFont(new Font("Roboto Condendsed", 1, 15));
            JPanel aux6 = new JPanel();
            aux6.add(Puntos2);

            JLabel PuntosP2 = new JLabel("N° Letras encontradas: " + Integer.toString(PuntosLetrasJug2));
            PuntosP2.setFont(new Font("Roboto Condendsed", 1, 15));
            JPanel aux7 = new JPanel();
            aux7.add(PuntosP2);

            JLabel TiempoJ2 = new JLabel();
            minutos = Tiempo2 / 60;
            segundosRestantes = Tiempo2 % 60;
            tiempoFormateado = String.format("Tiempo de Juego: %02d:%02d", minutos, segundosRestantes);
            TiempoJ2.setText(tiempoFormateado);
            TiempoJ2.setFont(new Font("Roboto Condendsed", 1, 15));
            JPanel aux8 = new JPanel();
            aux8.add(TiempoJ2);

            JLabel CantJugadas = new JLabel("Jugadas Totales: " + Jugadas);
            CantJugadas.setFont(new Font("Roboto Condendsed", 3, 15));
            JPanel aux9 = new JPanel();
            aux9.add(CantJugadas);

            minutos = (Tiempo1 + Tiempo2) / 60;
            segundosRestantes = (Tiempo1 + Tiempo2) % 60;
            tiempoFormateado = String.format("Duracion Partida: %02d:%02d", minutos, segundosRestantes);
            JLabel TotalTiempo = new JLabel(tiempoFormateado);
            TotalTiempo.setFont(new Font("Roboto Condendsed", 3, 15));
            JPanel aux10 = new JPanel();
            aux10.add(TotalTiempo);

            //Añadimos los paneles auxiliares para que se centren en el panel principal
            panel.add(aux1);
            panel.add(Box.createVerticalStrut(-10)); //Añadimos este objeto invisible que reduce el espacio entre los elementos
            panel.add(aux2);
            panel.add(Box.createVerticalStrut(-10));
            panel.add(aux3);
            panel.add(Box.createVerticalStrut(-10));
            panel.add(aux4);
            panel.add(Box.createVerticalStrut(-10));
            panel.add(aux5);
            panel.add(Box.createVerticalStrut(-10));
            panel.add(aux6);
            panel.add(Box.createVerticalStrut(-10));
            panel.add(aux7);
            panel.add(Box.createVerticalStrut(-10));
            panel.add(aux8);
            panel.add(aux9);
            panel.add(Box.createVerticalStrut(-10));
            panel.add(aux10);

            this.getContentPane().add(panel);
        }

    }

    /**
     * Nos ayuda a regresar a los valor por defectos de lol objetos
     */
    public void Restaurar() {
        //Regresamos todos los valores a su defecto
        palabrasValidas.clear();
        String Palabras[] = new String[ListaPalabras.length];
        for (int i = 0; i < ListaPalabras.length; i++) {
            Palabras[i] = ListaPalabras[i].getText();
        }
        palabrasValidas.addAll(Arrays.asList(Palabras));

        PuntosJug1 = 0;
        PuntosJug2 = 0;
        PuntosLetrasJug1 = 0;
        PuntosLetrasJug2 = 0;
        Jugadas = 0;
        Tiempo1 = 0;
        Tiempo2 = 0;
        PalabrasEncontradas = 0;

        //Removemos el panel de todo para generar el nuevo panel
        this.getContentPane().remove(Todo);
        revalidate();
        repaint();
    }
}
