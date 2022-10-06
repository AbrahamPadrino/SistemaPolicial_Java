
package poli;

import Animacion.Fade;
import JImage.JIResizeImage;
import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import com.sun.awt.AWTUtilities;
import java.awt.FileDialog;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.media.Buffer;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.net.URISyntaxException;
import poli.Cerrar;
import poli.Cerrar;
import poli.Cerrar;
import poli.conectar;
import poli.conectar;
import poli.conectar;
import poli.delitos;
import poli.delitos;
import poli.delitos;
import poli.detalles;
import poli.detalles;
import poli.detalles;
import poli.login;
import poli.login;
import poli.login;
import poli.webcam;
import poli.webcam;
import poli.webcam;

/**
 *
 * @author Equipo
 */
public class a extends javax.swing.JFrame implements Runnable {

    String hora, minutos, segundos, ampm, año, mes, dia;
    Calendar calendario;
    Thread h1;
    Player player;
    BufferedImage bi;
    String nfile;
    int contador = 0;
    DefaultTableModel model;
    Statement sent;
    CallableStatement cst;

    String caja, caja_edita_delito, caja_elimina_delito, caja_edita_incidente, caja_elimina_incidente;

    FileInputStream fis;
    int longitudBytes;

    public a() {
        initComponents();
        setLocationRelativeTo(null);
        CargarPersonalesIncidentes("");
        CargarPersonalesDelitos("");
        CargarUsuarios("");
        jlbdia1.setVisible(false);
        bGuardar.setEnabled(false);
        bCancelar.setEnabled(false);
        bEditar.setEnabled(false);
        bEliminar.setEnabled(false);
        bModificar.setEnabled(false);
        idfuncionario.setEditable(false);
        dee();
        dee2();
        fecha();
        h1 = new Thread(this);
        h1.start();

        Calendar cal = Calendar.getInstance();
        String fecha = cal.get(cal.DATE) + "/" + cal.get(cal.MONTH) + "/" + cal.get(cal.YEAR);

        String hora = cal.get(cal.HOUR_OF_DAY) + ":" + cal.get(cal.MINUTE) + ":" + cal.get(cal.SECOND);

        this.lbHora.setText(hora);
        vertical2.setVisible(false);

        final Color alphaZero = new Color(0, true);

        menu.setBackground(alphaZero);
        jPanelSlider1.setVisible(false);

        jScrollPane1.setBorder(null);

        tabla_d.setBorder(null);
        tabla_d.setBackground(alphaZero);
        tabla_d2.setBorder(null);
        tabla_d2.setBackground(alphaZero);
        detalles.setBorder(null);
        detalles.setBackground(alphaZero);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.getViewport().setBackground(alphaZero);
        jScrollPane3.setBorder(null);
        jScrollPane3.getViewport().setOpaque(false);
        jScrollPane3.getViewport().setBackground(alphaZero);
        jScrollPane4.getViewport().setOpaque(false);
        jScrollPane4.getViewport().setBackground(alphaZero);
        jScrollPane5.getViewport().setOpaque(false);
        jScrollPane5.getViewport().setBackground(alphaZero);
        jScrollPane5.setBorder(null);
        jPanelSlider2.setVisible(true);
        jPanelSlider2.nextPanel(10, r_incidentes, jPanelSlider2.right);
        r_delitos.setVisible(false);

        buscadorI.setBackground(new Color(0, 0, 0, 40));
        buscadorD.setBackground(new Color(0, 0, 0, 40));
        Nombres.setBackground(new Color(0, 0, 0, 40));
        Apellidos.setBackground(new Color(0, 0, 0, 40));
        Cedula.setBackground(new Color(0, 0, 0, 40));
        Edad.setBackground(new Color(0, 0, 0, 40));
        LugarN.setBackground(new Color(0, 0, 0, 40));
        Ocupacion.setBackground(new Color(0, 0, 0, 40));
        LugarResid.setBackground(new Color(0, 0, 0, 40));
        NombreMadre.setBackground(new Color(0, 0, 0, 40));
        NombrePadre.setBackground(new Color(0, 0, 0, 40));
        Observacion.setBackground(new Color(0, 0, 0, 40));
        nombres.setBackground(new Color(0, 0, 0, 40));
        apellidos.setBackground(new Color(0, 0, 0, 40));
        cedula.setBackground(new Color(0, 0, 0, 40));
        direccion.setBackground(new Color(0, 0, 0, 40));
        detalles.setBackground(new Color(0, 0, 0, 40));
        UserName.setBackground(new Color(0, 0, 0, 40));
        UserName1.setBackground(new Color(0, 0, 0, 40));
        UserName2.setBackground(new Color(0, 0, 0, 40));
        UserName3.setBackground(new Color(0, 0, 0, 40));
        UserName4.setBackground(new Color(0, 0, 0, 40));
        Pass.setBackground(new Color(0, 0, 0, 40));
        Pass1.setBackground(new Color(0, 0, 0, 40));
        Pass2.setBackground(new Color(0, 0, 0, 40));
        Pass3.setBackground(new Color(0, 0, 0, 40));
        Pass4.setBackground(new Color(0, 0, 0, 40));
        nombre_user.setBackground(new Color(0, 0, 0, 40));
        clave.setBackground(new Color(0, 0, 0, 40));
        idfuncionario.setBackground(new Color(0, 0, 0, 40));

        buscador3.setBackground(new Color(0, 0, 0, 40));

        try {
            initCamera();
        } catch (IOException ex) {
            Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoPlayerException ex) {
            Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery("select * from delitos");
            while (rs.next()) {
                this.Delito.addItem(rs.getString("delito"));
            }
            contador++;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        dbimg();
    }

    private void initCamera() throws IOException, NoPlayerException, CannotRealizeException {

    }

    void dbotones() {
        txtcamara.setEnabled(false);
        ir_camara.setEnabled(false);
        b_imagen.setEnabled(false);

    }
    
    void hbotones() {
        txtcamara.setEnabled(true);
        ir_camara.setEnabled(true);
        b_imagen.setEnabled(true);

    }
    void act_campos() {
        Delito.setEnabled(true);
        Observacion.setEnabled(true);
    }
    void des_campos() {
        Delito.setEnabled(false);
        Observacion.setEnabled(false);
    }

    void dgm2() {
        guardar.setVisible(false);
        modificar2.setVisible(true);
        modificar.setVisible(false);
        guardar2.setVisible(false);
    }

    void dgm() {
        guardar.setVisible(false);
        modificar2.setVisible(false);
        modificar.setVisible(true);
        guardar2.setVisible(false);
    }

    void CargarPersonalesDelitos(String valor) {
        try {
            String[] titulos = {"Id", "Nombres", "Apellidos", "Cedula", "Edad", "LugarResid", "idfuncionario"};
            String[] registros = new String[7];
            String sql = "SELECT * FROM registro_personal where Cedula LIKE '%" + valor + "%' ";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("Id");
                registros[1] = rs.getString("Nombres");
                registros[2] = rs.getString("Apellidos");
                registros[3] = rs.getString("Cedula");
                registros[4] = rs.getString("Edad");
                registros[5] = rs.getString("LugarResid");
                registros[6] = rs.getString("idfuncionario");
                model.addRow(registros);
            }
            tabla_d2.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    void CargarPersonalesIncidentes(String valor) {
        try {
            String[] titulos = {"Id", "Nombres", "Apellidos", "Cedula", "Direccion", "idfuncionario"};
            String[] registros = new String[6];
            String sql = "SELECT * FROM registro_personal_incidentes where Cedula LIKE '%" + valor + "%' ";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("Id");
                registros[1] = rs.getString("Nombres");
                registros[2] = rs.getString("Apellidos");
                registros[3] = rs.getString("Cedula");
                registros[4] = rs.getString("Direccion");
                registros[5] = rs.getString("idfuncionario");

                model.addRow(registros);
            }
            tabla_d.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    void CargarUsuarios(String valor) {
        try {
            String[] titulos = {"id", "nombre_user", "clave", "tipo_user"};
            String[] registros = new String[4];
            String sql = "SELECT * FROM usuarios where nombre_user LIKE '%" + valor + "%' ";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("nombre_user");
                registros[2] = rs.getString("clave");
                registros[3] = rs.getString("tipo_user");
                model.addRow(registros);
            }
            tabla_d3.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    void limpiar_r_delitos() {
        Nombres.setText("");
        Apellidos.setText("");
        Cedula.setText("");
        Edad.setText("");
        FechaN.setCalendar(null);
        LugarN.setText("");
        Nacionalidad.setSelectedIndex(0);
        EstadoCivil.setSelectedIndex(0);
        Ocupacion.setText("");
        LugarResid.setText("");
        NombreMadre.setText("");
        CondicionM.setSelectedIndex(0);
        NombrePadre.setText("");
        CondicionP.setSelectedIndex(0);
    }

    void limpiar_d_policial() {
        Delito.setSelectedIndex(0);
        Observacion.setText("");
        txtcamara.setText("");
    }

    void limpiar_r_incidentes() {
        nombres.setText("");
        apellidos.setText("");
        cedula.setText("");
        direccion.setText("");
        detalles.setText("");
    }

    void LimpiarUsuarios() {
        nombre_user.setText("");
        clave.setText("");
        tipo_user.setSelectedIndex(0);
    }

    void hab_campos_usuarios() {
        nombre_user.setEnabled(true);
        clave.setEnabled(true);
        tipo_user.setEnabled(true);
    }

    void des_campos_usuarios() {
        nombre_user.setEnabled(false);
        clave.setEnabled(false);
        tipo_user.setEnabled(false);
    }

    void dee() {
        editar.setVisible(false);
        eliminar.setVisible(false);
    }

    void eee() {
        editar.setVisible(true);
        eliminar.setVisible(true);
    }

    void dee2() {
        editar2.setVisible(false);
        eliminar2.setVisible(false);
    }

    void eee2() {
        editar2.setVisible(true);
        eliminar2.setVisible(true);
    }

    void confirmar(String usuario, String contraseña) {
        String condicion = "";
        String sql = "SELECT * FROM usuarios WHERE nombre_user='" + usuario + "' && clave='" + contraseña + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                condicion = rs.getString("tipo_user");
            }
            if (condicion.equals("Administrador")) {

                jPanelSlider2.setVisible(true);
                jPanelSlider2.nextPanel(10, r_usuarios, jPanelSlider2.left);
                usuarios.setEnabled(false);

            }
            if (!condicion.equals("Administrador")) {
                JOptionPane.showMessageDialog(this, "Usted No Es ADMINISTRADOR!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void ConfirmarEditarDelito(String usuario, String contraseña) {
        String condicion = "";
        String sql = "SELECT * FROM usuarios WHERE nombre_user='" + usuario + "' && clave='" + contraseña + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                condicion = rs.getString("tipo_user");
            }
            if (condicion.equals("Administrador")) {
                dgm();
                dbotones();
                habilitar_datos_delito();
                jPanelSlider2.setVisible(true);
                jPanelSlider2.nextPanel(10, d_delito, jPanelSlider2.right);

            }
            if (!condicion.equals("Administrador")) {
                JOptionPane.showMessageDialog(this, "Usted No Es ADMINISTRADOR!");

            }
        } catch (SQLException ex) {
            Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void ConfirmarEliminarDelito(String usuario, String contraseña) {
        String condicion = "";
        String sql = ("");
        sql = "SELECT * FROM usuarios WHERE nombre_user='" + usuario + "' && clave='" + contraseña + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                condicion = rs.getString("tipo_user");
            }
            if (condicion.equals("Administrador")) {

                try {
                    Object[] options = {"Si", "No"};
                    int d = JOptionPane.showOptionDialog(null, "¿Desea Eliminar Este Registro?", "ATENCION",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (d == JOptionPane.YES_OPTION) {

                        int fila = tabla_d2.getSelectedRow();
                        sql = "delete from registro_personal where Id = " + tabla_d2.getValueAt(fila, 0);
                        sent = cn.createStatement();
                        int n = sent.executeUpdate(sql);
                        if (n > 0) {
                            JOptionPane.showMessageDialog(null, "Registro Eliminado");
                        }

                    }
                    CargarPersonalesDelitos("");
                    limpiar_r_delitos();
                    denuncia.setEnabled(true);
                    eliminar.setVisible(false);
                    editar.setVisible(false);
                    jPanelSlider2.setVisible(true);
                    jPanelSlider2.nextPanel(10, r_delitos, jPanelSlider2.right);
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
                }

            }
            if (!condicion.equals("Administrador")) {
                JOptionPane.showMessageDialog(this, "Usted No Es ADMINISTRADOR!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void ConfirmarEditarIncidente(String usuario, String contraseña) {
        String condicion = "";
        String sql = "SELECT * FROM usuarios WHERE nombre_user='" + usuario + "' && clave='" + contraseña + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                condicion = rs.getString("tipo_user");
            }
            if (condicion.equals("Administrador")) {

                dgm2();
                dbotones();
                guardar2.setVisible(false);
                modificar2.setVisible(true);
                jPanelSlider2.setVisible(true);
                jPanelSlider2.nextPanel(10, d_incidentes, jPanelSlider2.right);

            }
            if (!condicion.equals("Administrador")) {
                JOptionPane.showMessageDialog(this, "Usted No Es ADMINISTRADOR!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void ConfirmarEliminarIncidente(String usuario, String contraseña) {
        String condicion = "";
        String sql = "SELECT * FROM usuarios WHERE nombre_user='" + usuario + "' && clave='" + contraseña + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                condicion = rs.getString("tipo_user");
            }
            if (condicion.equals("Administrador")) {

                try {
                    Object[] options = {"Si", "No"};
                    int d = JOptionPane.showOptionDialog(null, "¿Desea Eliminar Este Registro?", "ATENCION",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (d == JOptionPane.YES_OPTION) {

                        int fila = tabla_d.getSelectedRow();
                        sql = "delete from registro_personal_incidentes where Id = " + tabla_d.getValueAt(fila, 0);
                        sent = cn.createStatement();
                        int n = sent.executeUpdate(sql);
                        if (n > 0) {
                            JOptionPane.showMessageDialog(null, "Registro Eliminado");
                        }

                    }
                    CargarPersonalesIncidentes("");
                    limpiar_r_incidentes();
                    incidente.setEnabled(true);
                    eliminar2.setVisible(false);
                    editar2.setVisible(false);
                    jPanelSlider2.setVisible(true);
                    jPanelSlider2.nextPanel(10, r_incidentes, jPanelSlider2.right);
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
                }

            }
            if (!condicion.equals("Administrador")) {
                JOptionPane.showMessageDialog(this, "Usted No Es ADMINISTRADOR!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void hbimg() {
        txtcamara.setVisible(true);
        b_imagen.setVisible(true);
        ir_camara.setVisible(false);

    }

    void dbimg() {
        txtcamara.setVisible(false);
        b_imagen.setVisible(false);
        ir_camara.setVisible(true);
    }

    void deshabilitar_datos_delito() {
        Nombres.setEditable(false);
        Apellidos.setEditable(false);
        Cedula.setEditable(false);
        FechaN.setEnabled(false);
        LugarN.setEditable(false);
        Nacionalidad.setEnabled(false);
        EstadoCivil.setEnabled(false);
        Ocupacion.setEditable(false);
        LugarResid.setEditable(false);
        NombreMadre.setEditable(false);
        CondicionM.setEnabled(false);
        NombrePadre.setEditable(false);
        CondicionP.setEnabled(false);
    }

    void habilitar_datos_delito() {
        Nombres.setEditable(true);
        Apellidos.setEditable(true);
        Cedula.setEditable(true);
        FechaN.setEnabled(true);
        LugarN.setEditable(true);
        Nacionalidad.setEnabled(true);
        EstadoCivil.setEnabled(true);
        Ocupacion.setEditable(true);
        LugarResid.setEditable(true);
        NombreMadre.setEditable(true);
        CondicionM.setEnabled(true);
        NombrePadre.setEditable(true);
        CondicionP.setEnabled(true);
    }
    
    void deshabilitar_datos_incidente() {
        nombres.setEditable(false);
        apellidos.setEditable(false);
        cedula.setEditable(false);
        direccion.setEditable(false);
    }
    void habilitar_datos_incidente() {
        nombres.setEditable(true);
        apellidos.setEditable(true);
        cedula.setEditable(true);
        direccion.setEditable(true);
    }

    private void setImageButton(JToggleButton tbutton, Image image) {
        tbutton.setIcon(new ImageIcon(image));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cne = new javax.swing.JButton();
        lbHora = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jlbdia = new javax.swing.JLabel();
        jlbdia1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        escudo = new javax.swing.JLabel();
        jPanelSlider1 = new diu.swe.habib.JPanelSlider.JPanelSlider();
        menu2 = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        denuncia = new javax.swing.JButton();
        incidente = new javax.swing.JButton();
        consulta = new javax.swing.JButton();
        usuarios = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        FONDO = new javax.swing.JLabel();
        idfuncionario = new javax.swing.JTextField();
        vertical1 = new javax.swing.JButton();
        vertical2 = new javax.swing.JButton();
        BioPol2 = new javax.swing.JLabel();
        jPanelSlider2 = new diu.swe.habib.JPanelSlider.JPanelSlider();
        r_incidentes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_d = new javax.swing.JTable();
        delito = new javax.swing.JButton();
        buscadorI = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        editar2 = new javax.swing.JButton();
        eliminar2 = new javax.swing.JButton();
        f_fondo1 = new javax.swing.JLabel();
        r_delitos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla_d2 = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        inci = new javax.swing.JButton();
        buscadorD = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        editar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        f_fondo4 = new javax.swing.JLabel();
        r_usuarios = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabla_d3 = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        nombre_user = new javax.swing.JTextField();
        clave = new javax.swing.JPasswordField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        tipo_user = new javax.swing.JComboBox();
        buscador3 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        bEditar = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        bGuardar = new javax.swing.JButton();
        bRegistrar = new javax.swing.JButton();
        bInicio = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        f_fondo5 = new javax.swing.JLabel();
        d_incidentes = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        detalles = new javax.swing.JTextArea();
        apellidos = new javax.swing.JTextField();
        nombres = new javax.swing.JTextField();
        cedula = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        guardar2 = new javax.swing.JButton();
        modificar2 = new javax.swing.JButton();
        inicio2 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        f_fondo3 = new javax.swing.JLabel();
        d_delito = new javax.swing.JPanel();
        txtcamara = new javax.swing.JLabel();
        ir_camara = new javax.swing.JButton();
        b_imagen = new javax.swing.JButton();
        Delito = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        Nombres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Apellidos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Cedula = new javax.swing.JTextField();
        Edad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        FechaN = new com.toedter.calendar.JDateChooser();
        Ocupacion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        EstadoCivil = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        Nacionalidad = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        LugarN = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        LugarResid = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        CondicionM = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        NombreMadre = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        NombrePadre = new javax.swing.JTextField();
        CondicionP = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        d_filia = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Observacion = new javax.swing.JTextArea();
        mas = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        inicio = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        f_fondo = new javax.swing.JLabel();
        confirma = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        UserName = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        Pass = new javax.swing.JPasswordField();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jBorde = new javax.swing.JLabel();
        f_fondo6 = new javax.swing.JLabel();
        confirma_editar_d = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        UserName1 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        Pass1 = new javax.swing.JPasswordField();
        aceptar1 = new javax.swing.JButton();
        cancelar1 = new javax.swing.JButton();
        jBorde1 = new javax.swing.JLabel();
        f_fondo7 = new javax.swing.JLabel();
        confirma_editar_i = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        UserName2 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        Pass2 = new javax.swing.JPasswordField();
        aceptar2 = new javax.swing.JButton();
        cancelar3 = new javax.swing.JButton();
        jBorde3 = new javax.swing.JLabel();
        f_fondo9 = new javax.swing.JLabel();
        confirma_eliminar_d = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        UserName3 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        Pass3 = new javax.swing.JPasswordField();
        aceptar3 = new javax.swing.JButton();
        cancelar2 = new javax.swing.JButton();
        jBorde2 = new javax.swing.JLabel();
        f_fondo8 = new javax.swing.JLabel();
        confirma_eliminar_i = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        UserName4 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        Pass4 = new javax.swing.JPasswordField();
        aceptar4 = new javax.swing.JButton();
        cancelar4 = new javax.swing.JButton();
        jBorde4 = new javax.swing.JLabel();
        f_fondo10 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BOTONES/cne1.png"))); // NOI18N
        cne.setToolTipText("Consultar Datos");
        cne.setBorderPainted(false);
        cne.setContentAreaFilled(false);
        cne.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cne.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BOTONES/cne2.png"))); // NOI18N
        cne.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BOTONES/cne3.png"))); // NOI18N
        cne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cneActionPerformed(evt);
            }
        });
        getContentPane().add(cne, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 360, 150, 40));

        lbHora.setBackground(new java.awt.Color(255, 51, 153));
        lbHora.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        lbHora.setForeground(new java.awt.Color(255, 255, 255));
        lbHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHora.setText("hora");
        getContentPane().add(lbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 420, 160, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BOTONES/CANDADO.png"))); // NOI18N
        jButton1.setText("Cerrar Sesión");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, 130, -1));

        jlbdia.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jlbdia.setForeground(new java.awt.Color(255, 255, 255));
        jlbdia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbdia.setText("dia");
        jlbdia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jlbdia, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 440, 160, 30));

        jlbdia1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jlbdia1.setForeground(new java.awt.Color(255, 255, 255));
        jlbdia1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbdia1.setText("dia");
        jlbdia1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jlbdia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 440, 160, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Registro y Control Policial");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 50, -1, 10));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Sistema Automatizado de ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, -1, 10));

        escudo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/es3.png"))); // NOI18N
        getContentPane().add(escudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 70, 140, 310));

        jPanelSlider1.setBorder(null);
        jPanelSlider1.setOpaque(false);

        menu2.setOpaque(false);

        javax.swing.GroupLayout menu2Layout = new javax.swing.GroupLayout(menu2);
        menu2.setLayout(menu2Layout);
        menu2Layout.setHorizontalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        menu2Layout.setVerticalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        jPanelSlider1.add(menu2, "card3");

        menu.setOpaque(false);
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        denuncia.setForeground(new java.awt.Color(255, 255, 255));
        denuncia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/DENUNCIA.png"))); // NOI18N
        denuncia.setBorderPainted(false);
        denuncia.setContentAreaFilled(false);
        denuncia.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/DENUNCIA2.png"))); // NOI18N
        denuncia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denunciaActionPerformed(evt);
            }
        });
        menu.add(denuncia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, -1));

        incidente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/INCIDENTE.png"))); // NOI18N
        incidente.setBorderPainted(false);
        incidente.setContentAreaFilled(false);
        incidente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/INCIDENTE2.png"))); // NOI18N
        incidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incidenteActionPerformed(evt);
            }
        });
        menu.add(incidente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 120, -1));

        consulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/CONSULTA.png"))); // NOI18N
        consulta.setBorderPainted(false);
        consulta.setContentAreaFilled(false);
        consulta.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/CONSULTA2.png"))); // NOI18N
        consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaActionPerformed(evt);
            }
        });
        menu.add(consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, -1));

        usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/USUARIO.png"))); // NOI18N
        usuarios.setBorderPainted(false);
        usuarios.setContentAreaFilled(false);
        usuarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/USUARIO2.png"))); // NOI18N
        usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosActionPerformed(evt);
            }
        });
        menu.add(usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 120, -1));

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/SALIR.png"))); // NOI18N
        salir.setBorderPainted(false);
        salir.setContentAreaFilled(false);
        salir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/SALIR2.png"))); // NOI18N
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        menu.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 120, -1));

        FONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/F_F.png"))); // NOI18N
        menu.add(FONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 270));

        jPanelSlider1.add(menu, "card2");

        getContentPane().add(jPanelSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 100, 140, 230));

        idfuncionario.setBackground(new java.awt.Color(0, 102, 153));
        idfuncionario.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        idfuncionario.setForeground(new java.awt.Color(255, 255, 255));
        idfuncionario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idfuncionario.setDisabledTextColor(new java.awt.Color(0, 102, 153));
        idfuncionario.setOpaque(false);
        idfuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idfuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(idfuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 470, 100, -1));

        vertical1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vertical.png"))); // NOI18N
        vertical1.setBorderPainted(false);
        vertical1.setContentAreaFilled(false);
        vertical1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vertical11.png"))); // NOI18N
        vertical1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vertical1ActionPerformed(evt);
            }
        });
        getContentPane().add(vertical1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, 20, 500));

        vertical2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vertical2.png"))); // NOI18N
        vertical2.setBorderPainted(false);
        vertical2.setContentAreaFilled(false);
        vertical2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vertical22.png"))); // NOI18N
        vertical2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vertical2ActionPerformed(evt);
            }
        });
        getContentPane().add(vertical2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, -1, 20, 500));

        BioPol2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        BioPol2.setForeground(new java.awt.Color(255, 255, 255));
        BioPol2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BioPol2.setText("SARCPOLI");
        getContentPane().add(BioPol2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 130, 30));

        jPanelSlider2.setBorder(null);
        jPanelSlider2.setOpaque(false);

        r_incidentes.setOpaque(false);
        r_incidentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_d.setForeground(new java.awt.Color(255, 255, 255));
        tabla_d.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_d.setOpaque(false);
        tabla_d.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_dMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_d);

        r_incidentes.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 790, 330));

        delito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/DENUNCIA.png"))); // NOI18N
        delito.setBorderPainted(false);
        delito.setContentAreaFilled(false);
        delito.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/DENUNCIA2.png"))); // NOI18N
        delito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delitoActionPerformed(evt);
            }
        });
        r_incidentes.add(delito, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 120, 30));

        buscadorI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscadorI.setForeground(new java.awt.Color(255, 255, 255));
        buscadorI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscadorI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscadorIMouseClicked(evt);
            }
        });
        buscadorI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorIActionPerformed(evt);
            }
        });
        buscadorI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscadorIKeyReleased(evt);
            }
        });
        r_incidentes.add(buscadorI, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 25, 280, 30));

        jLabel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "BUSCADOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        r_incidentes.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 300, 50));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("REGISTROS POR INCIDENTES");
        r_incidentes.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 290, 30));

        editar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/EDITAR.png"))); // NOI18N
        editar2.setBorderPainted(false);
        editar2.setContentAreaFilled(false);
        editar2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/EDITAR1.png"))); // NOI18N
        editar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar2ActionPerformed(evt);
            }
        });
        r_incidentes.add(editar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 439, -1, 40));

        eliminar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/ELIMINAR.png"))); // NOI18N
        eliminar2.setBorderPainted(false);
        eliminar2.setContentAreaFilled(false);
        eliminar2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/ELIMINAR1.png"))); // NOI18N
        eliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar2ActionPerformed(evt);
            }
        });
        r_incidentes.add(eliminar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 439, -1, 40));

        f_fondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f_todo.png"))); // NOI18N
        f_fondo1.setText("jLabel13");
        r_incidentes.add(f_fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 480));

        jPanelSlider2.add(r_incidentes, "card4");

        r_delitos.setOpaque(false);
        r_delitos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBorder(null);
        jScrollPane4.setOpaque(false);

        tabla_d2.setForeground(new java.awt.Color(255, 255, 255));
        tabla_d2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_d2.setOpaque(false);
        tabla_d2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_d2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabla_d2);

        r_delitos.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 790, 330));

        jLabel25.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "BUSCADOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        r_delitos.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 300, 50));

        inci.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/INCIDENTE.png"))); // NOI18N
        inci.setBorder(null);
        inci.setBorderPainted(false);
        inci.setContentAreaFilled(false);
        inci.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/INCIDENTE2.png"))); // NOI18N
        inci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inciActionPerformed(evt);
            }
        });
        r_delitos.add(inci, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        buscadorD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscadorD.setForeground(new java.awt.Color(255, 255, 255));
        buscadorD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscadorD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscadorDMouseClicked(evt);
            }
        });
        buscadorD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscadorDKeyReleased(evt);
            }
        });
        r_delitos.add(buscadorD, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 25, 280, 30));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("REGISTROS POR DENUNCIAS / DELITOS");
        r_delitos.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 420, 30));

        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/EDITAR.png"))); // NOI18N
        editar.setBorder(null);
        editar.setBorderPainted(false);
        editar.setContentAreaFilled(false);
        editar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/EDITAR1.png"))); // NOI18N
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        r_delitos.add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 439, -1, 40));

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/ELIMINAR.png"))); // NOI18N
        eliminar.setBorder(null);
        eliminar.setBorderPainted(false);
        eliminar.setContentAreaFilled(false);
        eliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/ELIMINAR1.png"))); // NOI18N
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        r_delitos.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 439, -1, 40));

        f_fondo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f_todo.png"))); // NOI18N
        f_fondo4.setText("jLabel13");
        r_delitos.add(f_fondo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 480));

        jPanelSlider2.add(r_delitos, "card5");

        r_usuarios.setOpaque(false);
        r_usuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane6.setBorder(null);
        jScrollPane6.setOpaque(false);

        tabla_d3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_d3.setOpaque(false);
        tabla_d3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_d3MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabla_d3);

        r_usuarios.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 790, 260));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Usuario:");
        r_usuarios.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        nombre_user.setForeground(new java.awt.Color(255, 255, 255));
        r_usuarios.add(nombre_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 180, -1));

        clave.setForeground(new java.awt.Color(255, 255, 255));
        r_usuarios.add(clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 160, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Contraseña:");
        r_usuarios.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Tipo de Usuario:");
        r_usuarios.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        tipo_user.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Administrador", "Invitado" }));
        r_usuarios.add(tipo_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 120, -1));

        buscador3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscador3.setForeground(new java.awt.Color(255, 255, 255));
        buscador3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscador3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscador3KeyReleased(evt);
            }
        });
        r_usuarios.add(buscador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 118, 280, 30));

        jLabel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "BUSCADOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        r_usuarios.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 300, 60));

        bEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/EDITAR.png"))); // NOI18N
        bEditar.setBorderPainted(false);
        bEditar.setContentAreaFilled(false);
        bEditar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/EDITAR1.png"))); // NOI18N
        bEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarActionPerformed(evt);
            }
        });
        r_usuarios.add(bEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, -1, 30));

        bModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/MODIFICAR.png"))); // NOI18N
        bModificar.setBorderPainted(false);
        bModificar.setContentAreaFilled(false);
        bModificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/MODIFICAR1.png"))); // NOI18N
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });
        r_usuarios.add(bModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, -1, 30));

        bEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/ELIMINAR.png"))); // NOI18N
        bEliminar.setBorderPainted(false);
        bEliminar.setContentAreaFilled(false);
        bEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/ELIMINAR1.png"))); // NOI18N
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });
        r_usuarios.add(bEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, -1, 30));

        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/CANCELAR.png"))); // NOI18N
        bCancelar.setBorderPainted(false);
        bCancelar.setContentAreaFilled(false);
        bCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/CANCELAR1.png"))); // NOI18N
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });
        r_usuarios.add(bCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, -1, 30));

        bGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/GUARDAR.png"))); // NOI18N
        bGuardar.setBorderPainted(false);
        bGuardar.setContentAreaFilled(false);
        bGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/GUARDAR1.png"))); // NOI18N
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });
        r_usuarios.add(bGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, -1, 30));

        bRegistrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        bRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/mas.png"))); // NOI18N
        bRegistrar.setText("Registrar");
        bRegistrar.setBorderPainted(false);
        bRegistrar.setContentAreaFilled(false);
        bRegistrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/mas1.png"))); // NOI18N
        bRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistrarActionPerformed(evt);
            }
        });
        r_usuarios.add(bRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, -1));

        bInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/INICIO.png"))); // NOI18N
        bInicio.setBorderPainted(false);
        bInicio.setContentAreaFilled(false);
        bInicio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/INICIO1.png"))); // NOI18N
        bInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInicioActionPerformed(evt);
            }
        });
        r_usuarios.add(bInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 130, -1));

        jLabel37.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "NUEVO USUARIO:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        r_usuarios.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 790, 90));

        f_fondo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f_todo.png"))); // NOI18N
        f_fondo5.setText("jLabel13");
        r_usuarios.add(f_fondo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 480));

        jPanelSlider2.add(r_usuarios, "card5");

        d_incidentes.setOpaque(false);
        d_incidentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("NOMBRES:");
        d_incidentes.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("APELLIDOS:");
        d_incidentes.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("CÉDULA:");
        d_incidentes.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("DIRECCIÓN:");
        d_incidentes.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        jScrollPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        detalles.setColumns(20);
        detalles.setForeground(new java.awt.Color(255, 255, 255));
        detalles.setLineWrap(true);
        detalles.setRows(5);
        detalles.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        detalles.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        detalles.setOpaque(false);
        jScrollPane5.setViewportView(detalles);

        d_incidentes.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 780, 250));

        apellidos.setForeground(new java.awt.Color(255, 255, 255));
        apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidosKeyTyped(evt);
            }
        });
        d_incidentes.add(apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 310, -1));

        nombres.setForeground(new java.awt.Color(255, 255, 255));
        nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombresKeyTyped(evt);
            }
        });
        d_incidentes.add(nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 310, -1));

        cedula.setForeground(new java.awt.Color(255, 255, 255));
        cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cedulaKeyTyped(evt);
            }
        });
        d_incidentes.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 130, -1));

        direccion.setForeground(new java.awt.Color(255, 255, 255));
        direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                direccionKeyTyped(evt);
            }
        });
        d_incidentes.add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 470, -1));

        guardar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/GUARDAR.png"))); // NOI18N
        guardar2.setBorderPainted(false);
        guardar2.setContentAreaFilled(false);
        guardar2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/GUARDAR1.png"))); // NOI18N
        guardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar2ActionPerformed(evt);
            }
        });
        d_incidentes.add(guardar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 432, 120, 20));

        modificar2.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        modificar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/MODIFICAR.png"))); // NOI18N
        modificar2.setBorderPainted(false);
        modificar2.setContentAreaFilled(false);
        modificar2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/MODIFICAR1.png"))); // NOI18N
        modificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar2ActionPerformed(evt);
            }
        });
        d_incidentes.add(modificar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, -1, -1));

        inicio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/INICIO.png"))); // NOI18N
        inicio2.setBorderPainted(false);
        inicio2.setContentAreaFilled(false);
        inicio2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/INICIO1.png"))); // NOI18N
        inicio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicio2ActionPerformed(evt);
            }
        });
        d_incidentes.add(inicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "DATOS PERSONALES: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        d_incidentes.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 100));

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "DETALLES DEL INCIDENTE: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        d_incidentes.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 810, 290));

        f_fondo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f_todo.png"))); // NOI18N
        f_fondo3.setText("jLabel13");
        d_incidentes.add(f_fondo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 480));

        jPanelSlider2.add(d_incidentes, "card4");

        d_delito.setOpaque(false);
        d_delito.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcamara.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        d_delito.add(txtcamara, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 150, 150));

        ir_camara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BOTONES/camara.png"))); // NOI18N
        ir_camara.setBorderPainted(false);
        ir_camara.setContentAreaFilled(false);
        ir_camara.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BOTONES/camara1.png"))); // NOI18N
        ir_camara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir_camaraActionPerformed(evt);
            }
        });
        d_delito.add(ir_camara, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 50, 30));

        b_imagen.setFont(new java.awt.Font("Aharoni", 1, 11)); // NOI18N
        b_imagen.setForeground(new java.awt.Color(0, 255, 255));
        b_imagen.setText("BUSCAR IMG");
        b_imagen.setBorderPainted(false);
        b_imagen.setContentAreaFilled(false);
        b_imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_imagenActionPerformed(evt);
            }
        });
        d_delito.add(b_imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 110, 100, 30));

        Delito.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));
        d_delito.add(Delito, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 120, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NOMBRES:");
        d_delito.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        Nombres.setForeground(new java.awt.Color(255, 255, 255));
        Nombres.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombresKeyTyped(evt);
            }
        });
        d_delito.add(Nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 230, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("APELLIDOS:");
        d_delito.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        Apellidos.setForeground(new java.awt.Color(255, 255, 255));
        Apellidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ApellidosKeyTyped(evt);
            }
        });
        d_delito.add(Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 240, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CÉDULA:");
        d_delito.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        Cedula.setForeground(new java.awt.Color(255, 255, 255));
        Cedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CedulaKeyTyped(evt);
            }
        });
        d_delito.add(Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 110, -1));

        Edad.setForeground(new java.awt.Color(255, 255, 255));
        Edad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Edad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EdadKeyTyped(evt);
            }
        });
        d_delito.add(Edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 40, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("EDAD:");
        d_delito.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("F. NACIMIENTO");
        d_delito.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        FechaN.setOpaque(false);
        d_delito.add(FechaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 124, -1));

        Ocupacion.setForeground(new java.awt.Color(255, 255, 255));
        Ocupacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Ocupacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                OcupacionKeyTyped(evt);
            }
        });
        d_delito.add(Ocupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 150, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("OCUPACIÓN:");
        d_delito.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        EstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Soltero(a)", "Casado(a)", "Comprometido(a)", "Divorciado(a)", "Viudo(a)" }));
        d_delito.add(EstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 103, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ESTADO CIVIL:");
        d_delito.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));

        Nacionalidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Venezolano(a)", "Extranjero(a)" }));
        d_delito.add(Nacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 102, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("NACIONALIDAD:");
        d_delito.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        LugarN.setForeground(new java.awt.Color(255, 255, 255));
        LugarN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LugarN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                LugarNKeyTyped(evt);
            }
        });
        d_delito.add(LugarN, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 240, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("L. NACIMIENTO:");
        d_delito.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("L.RESIDENCIA:");
        d_delito.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        LugarResid.setForeground(new java.awt.Color(255, 255, 255));
        LugarResid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LugarResid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                LugarResidKeyTyped(evt);
            }
        });
        d_delito.add(LugarResid, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 280, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("NOMBRE MADRE:");
        d_delito.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        CondicionM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Vivo", "Fallecido" }));
        d_delito.add(CondicionM, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 110, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("CONDICIÓN:");
        d_delito.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        NombreMadre.setForeground(new java.awt.Color(255, 255, 255));
        NombreMadre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NombreMadre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombreMadreKeyTyped(evt);
            }
        });
        d_delito.add(NombreMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 250, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("NOMBRE PADRE:");
        d_delito.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        NombrePadre.setForeground(new java.awt.Color(255, 255, 255));
        NombrePadre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NombrePadre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombrePadreKeyTyped(evt);
            }
        });
        d_delito.add(NombrePadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 250, -1));

        CondicionP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Vivo", "Fallecido" }));
        d_delito.add(CondicionP, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 110, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("CONDICIÓN:");
        d_delito.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, -1, -1));

        d_filia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        d_filia.setForeground(new java.awt.Color(255, 255, 255));
        d_filia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d_filia.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "DATOS FILIATORIOS:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        d_filia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        d_delito.add(d_filia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 790, 250));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("DELITO:");
        d_delito.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jScrollPane3.setOpaque(false);

        Observacion.setColumns(20);
        Observacion.setForeground(new java.awt.Color(255, 255, 255));
        Observacion.setLineWrap(true);
        Observacion.setRows(5);
        Observacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Observacion.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        Observacion.setOpaque(false);
        jScrollPane3.setViewportView(Observacion);

        d_delito.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 510, 130));

        mas.setFont(new java.awt.Font("Vani", 3, 18)); // NOI18N
        mas.setForeground(new java.awt.Color(255, 255, 255));
        mas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/mas.png"))); // NOI18N
        mas.setToolTipText("");
        mas.setBorderPainted(false);
        mas.setContentAreaFilled(false);
        mas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/mas1.png"))); // NOI18N
        mas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masActionPerformed(evt);
            }
        });
        d_delito.add(mas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 30, 20));

        actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/actualizar.png"))); // NOI18N
        actualizar.setBorderPainted(false);
        actualizar.setContentAreaFilled(false);
        actualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/actualizar1.png"))); // NOI18N
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        d_delito.add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 20, 20));

        modificar.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/MODIFICAR.png"))); // NOI18N
        modificar.setBorderPainted(false);
        modificar.setContentAreaFilled(false);
        modificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/MODIFICAR1.png"))); // NOI18N
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        d_delito.add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 345, -1, -1));

        guardar.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/GUARDAR.png"))); // NOI18N
        guardar.setBorder(null);
        guardar.setBorderPainted(false);
        guardar.setContentAreaFilled(false);
        guardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/GUARDAR1.png"))); // NOI18N
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        d_delito.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));

        inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/INICIO.png"))); // NOI18N
        inicio.setBorder(null);
        inicio.setBorderPainted(false);
        inicio.setContentAreaFilled(false);
        inicio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/INICIO1.png"))); // NOI18N
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });
        d_delito.add(inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "REGISTRO POLICIAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        d_delito.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 790, 190));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "OBSERVACIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        d_delito.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 530, 160));

        f_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f_todo.png"))); // NOI18N
        f_fondo.setText("jLabel13");
        d_delito.add(f_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 480));

        jPanelSlider2.add(d_delito, "card3");

        confirma.setOpaque(false);
        confirma.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Usuario:");
        confirma.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        UserName.setForeground(new java.awt.Color(102, 102, 102));
        UserName.setDisabledTextColor(new java.awt.Color(0, 102, 153));
        UserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserNameActionPerformed(evt);
            }
        });
        confirma.add(UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 120, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Contraseña:");
        confirma.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        Pass.setForeground(new java.awt.Color(255, 255, 255));
        confirma.add(Pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 100, -1));

        aceptar.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        aceptar.setForeground(new java.awt.Color(255, 255, 255));
        aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/aceptar.png"))); // NOI18N
        aceptar.setBorderPainted(false);
        aceptar.setContentAreaFilled(false);
        aceptar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/aceptar1.png"))); // NOI18N
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        confirma.add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 120, -1));

        cancelar.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        cancelar.setForeground(new java.awt.Color(255, 255, 255));
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/CANCELAR.png"))); // NOI18N
        cancelar.setBorderPainted(false);
        cancelar.setContentAreaFilled(false);
        cancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/CANCELAR1.png"))); // NOI18N
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        confirma.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 120, -1));

        jBorde.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "CONFIRMAR CUENTA: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        confirma.add(jBorde, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 260, 140));

        f_fondo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f_todo.png"))); // NOI18N
        f_fondo6.setText("jLabel13");
        confirma.add(f_fondo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 480));

        jPanelSlider2.add(confirma, "card5");

        confirma_editar_d.setOpaque(false);
        confirma_editar_d.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Usuario:");
        confirma_editar_d.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        UserName1.setForeground(new java.awt.Color(102, 102, 102));
        UserName1.setDisabledTextColor(new java.awt.Color(0, 102, 153));
        confirma_editar_d.add(UserName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 120, -1));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Contraseña:");
        confirma_editar_d.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        Pass1.setForeground(new java.awt.Color(255, 255, 255));
        confirma_editar_d.add(Pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 100, -1));

        aceptar1.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        aceptar1.setForeground(new java.awt.Color(255, 255, 255));
        aceptar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/aceptar.png"))); // NOI18N
        aceptar1.setBorderPainted(false);
        aceptar1.setContentAreaFilled(false);
        aceptar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/aceptar1.png"))); // NOI18N
        aceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar1ActionPerformed(evt);
            }
        });
        confirma_editar_d.add(aceptar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 120, -1));

        cancelar1.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        cancelar1.setForeground(new java.awt.Color(255, 255, 255));
        cancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/CANCELAR.png"))); // NOI18N
        cancelar1.setBorderPainted(false);
        cancelar1.setContentAreaFilled(false);
        cancelar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/CANCELAR1.png"))); // NOI18N
        cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar1ActionPerformed(evt);
            }
        });
        confirma_editar_d.add(cancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 120, -1));

        jBorde1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "CONFIRMAR CUENTA: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        confirma_editar_d.add(jBorde1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 260, 140));

        f_fondo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f_todo.png"))); // NOI18N
        f_fondo7.setText("jLabel13");
        confirma_editar_d.add(f_fondo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 480));

        jPanelSlider2.add(confirma_editar_d, "card5");

        confirma_editar_i.setOpaque(false);
        confirma_editar_i.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Usuario:");
        confirma_editar_i.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        UserName2.setForeground(new java.awt.Color(102, 102, 102));
        UserName2.setDisabledTextColor(new java.awt.Color(0, 102, 153));
        confirma_editar_i.add(UserName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 120, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Contraseña:");
        confirma_editar_i.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        Pass2.setForeground(new java.awt.Color(255, 255, 255));
        confirma_editar_i.add(Pass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 100, -1));

        aceptar2.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        aceptar2.setForeground(new java.awt.Color(255, 255, 255));
        aceptar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/aceptar.png"))); // NOI18N
        aceptar2.setBorderPainted(false);
        aceptar2.setContentAreaFilled(false);
        aceptar2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/aceptar1.png"))); // NOI18N
        aceptar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar2ActionPerformed(evt);
            }
        });
        confirma_editar_i.add(aceptar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 110, -1));

        cancelar3.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        cancelar3.setForeground(new java.awt.Color(255, 255, 255));
        cancelar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/CANCELAR.png"))); // NOI18N
        cancelar3.setBorderPainted(false);
        cancelar3.setContentAreaFilled(false);
        cancelar3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/CANCELAR1.png"))); // NOI18N
        cancelar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar3ActionPerformed(evt);
            }
        });
        confirma_editar_i.add(cancelar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 120, -1));

        jBorde3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "CONFIRMAR CUENTA: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        confirma_editar_i.add(jBorde3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 260, 140));

        f_fondo9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f_todo.png"))); // NOI18N
        f_fondo9.setText("jLabel13");
        confirma_editar_i.add(f_fondo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 480));

        jPanelSlider2.add(confirma_editar_i, "card5");

        confirma_eliminar_d.setOpaque(false);
        confirma_eliminar_d.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Usuario:");
        confirma_eliminar_d.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        UserName3.setForeground(new java.awt.Color(102, 102, 102));
        UserName3.setDisabledTextColor(new java.awt.Color(0, 102, 153));
        confirma_eliminar_d.add(UserName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 120, -1));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Contraseña:");
        confirma_eliminar_d.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        Pass3.setForeground(new java.awt.Color(255, 255, 255));
        confirma_eliminar_d.add(Pass3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 100, -1));

        aceptar3.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        aceptar3.setForeground(new java.awt.Color(255, 255, 255));
        aceptar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/aceptar.png"))); // NOI18N
        aceptar3.setBorderPainted(false);
        aceptar3.setContentAreaFilled(false);
        aceptar3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/aceptar1.png"))); // NOI18N
        aceptar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar3ActionPerformed(evt);
            }
        });
        confirma_eliminar_d.add(aceptar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 120, -1));

        cancelar2.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        cancelar2.setForeground(new java.awt.Color(255, 255, 255));
        cancelar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/CANCELAR.png"))); // NOI18N
        cancelar2.setBorderPainted(false);
        cancelar2.setContentAreaFilled(false);
        cancelar2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/CANCELAR1.png"))); // NOI18N
        cancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar2ActionPerformed(evt);
            }
        });
        confirma_eliminar_d.add(cancelar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 120, -1));

        jBorde2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "CONFIRMAR CUENTA: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        confirma_eliminar_d.add(jBorde2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 260, 140));

        f_fondo8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f_todo.png"))); // NOI18N
        f_fondo8.setText("jLabel13");
        confirma_eliminar_d.add(f_fondo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 480));

        jPanelSlider2.add(confirma_eliminar_d, "card5");

        confirma_eliminar_i.setOpaque(false);
        confirma_eliminar_i.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Usuario:");
        confirma_eliminar_i.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        UserName4.setForeground(new java.awt.Color(102, 102, 102));
        UserName4.setDisabledTextColor(new java.awt.Color(0, 102, 153));
        confirma_eliminar_i.add(UserName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 120, -1));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Contraseña:");
        confirma_eliminar_i.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        Pass4.setForeground(new java.awt.Color(255, 255, 255));
        confirma_eliminar_i.add(Pass4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 100, -1));

        aceptar4.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        aceptar4.setForeground(new java.awt.Color(255, 255, 255));
        aceptar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/aceptar.png"))); // NOI18N
        aceptar4.setBorderPainted(false);
        aceptar4.setContentAreaFilled(false);
        aceptar4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/aceptar1.png"))); // NOI18N
        aceptar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar4ActionPerformed(evt);
            }
        });
        confirma_eliminar_i.add(aceptar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 120, -1));

        cancelar4.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        cancelar4.setForeground(new java.awt.Color(255, 255, 255));
        cancelar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/CANCELAR.png"))); // NOI18N
        cancelar4.setBorderPainted(false);
        cancelar4.setContentAreaFilled(false);
        cancelar4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/CANCELAR1.png"))); // NOI18N
        cancelar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar4ActionPerformed(evt);
            }
        });
        confirma_eliminar_i.add(cancelar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 120, -1));

        jBorde4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "CONFIRMAR CUENTA: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        confirma_eliminar_i.add(jBorde4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 260, 140));

        f_fondo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f_todo.png"))); // NOI18N
        f_fondo10.setText("jLabel13");
        confirma_eliminar_i.add(f_fondo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 480));

        jPanelSlider2.add(confirma_eliminar_i, "card5");

        getContentPane().add(jPanelSlider2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 810, 480));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vertical1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vertical1ActionPerformed
        vertical1.setVisible(false);
        vertical2.setVisible(true);
        escudo.setVisible(false);
        jPanelSlider1.setVisible(true);
        jPanelSlider1.nextPanel(10, menu, jPanelSlider1.left);
    }//GEN-LAST:event_vertical1ActionPerformed

    private void vertical2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vertical2ActionPerformed
        jPanelSlider1.setVisible(true);
        jPanelSlider1.nextPanel(10, menu2, jPanelSlider1.right);
        vertical1.setVisible(true);
        vertical2.setVisible(false);
        escudo.setVisible(true);

    }//GEN-LAST:event_vertical2ActionPerformed

    private void denunciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denunciaActionPerformed
        CargarPersonalesDelitos("");
        limpiar_r_incidentes();
        habilitar_datos_incidente();
        hbotones();
        des_campos();
        guardar.setVisible(true);
        jPanelSlider2.setVisible(true);
        jPanelSlider2.nextPanel(10, d_delito, jPanelSlider2.left);
        denuncia.setEnabled(false);
        incidente.setEnabled(true);
        consulta.setEnabled(true);
        usuarios.setEnabled(true);

        vertical1.setVisible(true);
        vertical2.setVisible(false);
        escudo.setVisible(true);
        modificar.setVisible(false);
        jPanelSlider1.setVisible(true);
        jPanelSlider1.nextPanel(10, menu2, jPanelSlider1.right);
    }//GEN-LAST:event_denunciaActionPerformed

    private void incidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incidenteActionPerformed
        limpiar_r_delitos();
        habilitar_datos_delito();
        guardar2.setVisible(true);
        jPanelSlider2.setVisible(true);
        jPanelSlider2.nextPanel(10, d_incidentes, jPanelSlider2.left);
        denuncia.setEnabled(true);
        incidente.setEnabled(false);
        consulta.setEnabled(true);
        usuarios.setEnabled(true);

        vertical1.setVisible(true);
        vertical2.setVisible(false);
        escudo.setVisible(true);
        modificar2.setVisible(false);
        jPanelSlider1.setVisible(true);
        jPanelSlider1.nextPanel(10, menu2, jPanelSlider1.right);
    }//GEN-LAST:event_incidenteActionPerformed

    private void consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaActionPerformed
        detalles co = new detalles();
        co.setVisible(true);
       
        consulta.setEnabled(false);
        habilitar_datos_delito();

        vertical1.setVisible(true);
        vertical2.setVisible(false);
        escudo.setVisible(true);
        jPanelSlider1.setVisible(true);
        jPanelSlider1.nextPanel(10, menu2, jPanelSlider1.right);
    }//GEN-LAST:event_consultaActionPerformed

    private void usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosActionPerformed
        caja = idfuncionario.getText();
        UserName.setText(caja);
        UserName.setEditable(false);
        habilitar_datos_delito();
        habilitar_datos_incidente();
        limpiar_r_delitos();
        limpiar_r_incidentes();

        denuncia.setEnabled(true);
        incidente.setEnabled(true);
        consulta.setEnabled(true);
        usuarios.setEnabled(false);

        jPanelSlider2.setVisible(true);
        jPanelSlider2.nextPanel(10, confirma, jPanelSlider2.left);

        vertical1.setVisible(true);
        vertical2.setVisible(false);
        escudo.setVisible(true);
        jPanelSlider1.setVisible(true);
        jPanelSlider1.nextPanel(10, menu2, jPanelSlider1.right);
    }//GEN-LAST:event_usuariosActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        salir.setEnabled(false);
        Cerrar s = new Cerrar();
        s.setVisible(true);
    }//GEN-LAST:event_salirActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        String regist;
        String sql = ("");
        String exp = Cedula.getText();

        boolean existe = false; //variable bandera para comprobar si NO existe el expediente en la BD

        try {
            sql = "SELECT * FROM registro_personal WHERE Cedula = '" + exp + "'";

            ResultSet rs = sent.executeQuery(sql);

            while (rs.next()) {
                existe = true;
                if (existe == true) {
                    regist = rs.getString("Cedula");
                    if (exp.equals(regist)) {
                        JOptionPane.showMessageDialog(null, "El Titular de: " + regist + " Está Registrado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                        if (Delito.getSelectedItem().equals("Seleccione...")) {
                            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Delito' Vacio", "aviso", 1);
                        } else if (Observacion.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Observaciones' Vacio", "aviso", 1);
                        } else {

                            String no, ap, ce, ed, fn, ln, na, ec, oc, lr, nm, cm, np, cp, de, fe, ob, fp, a, fr;

                            no = Nombres.getText();
                            ap = Apellidos.getText();
                            ce = Cedula.getText();
                            ed = Edad.getText();
                            fn = FechaN.getDateFormatString();
                            ln = LugarN.getText();
                            na = Nacionalidad.getActionCommand();
                            ec = EstadoCivil.getActionCommand();
                            oc = Ocupacion.getText();
                            lr = LugarResid.getText();
                            nm = NombreMadre.getText();
                            cm = CondicionM.getActionCommand();
                            np = NombrePadre.getText();
                            cp = CondicionP.getActionCommand();
                            de = Delito.getActionCommand();
                            fe = jlbdia.getText();
                            ob = Observacion.getText();
                            fp = idfuncionario.getText();
                            a = txtcamara.getText();
                            fr = jlbdia1.getText();

                            sql = "INSERT INTO registro_policial (Nombres, Apellidos, Cedula, Edad, FechaN, LugarN, Nacionalidad, EstadoCivil, Ocupacion, LugarResid, NombreMadre, CondicionM, NombrePadre, CondicionP, Delito, FechaD, Observacion, idfuncionario, foto, FechaR) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                            try {
                                PreparedStatement pst = cn.prepareCall(sql);

                                pst.setString(1, no);
                                pst.setString(2, ap);
                                pst.setString(3, ce);
                                pst.setString(4, ed);
                                pst.setDate(5, new java.sql.Date(FechaN.getDate().getTime()));
                                pst.setString(6, ln);
                                pst.setString(7, Nacionalidad.getSelectedItem().toString());
                                pst.setString(8, EstadoCivil.getSelectedItem().toString());
                                pst.setString(9, oc);
                                pst.setString(10, lr);
                                pst.setString(11, nm);
                                pst.setString(12, CondicionM.getSelectedItem().toString());
                                pst.setString(13, np);
                                pst.setString(14, CondicionP.getSelectedItem().toString());
                                pst.setString(15, Delito.getSelectedItem().toString());
                                pst.setString(16, fe);
                                pst.setString(17, ob);
                                pst.setString(18, fp);
                                pst.setBinaryStream(19, fis, longitudBytes);
                                pst.setString(20, fr);

                                txtcamara.setIcon(null);
                                int n = pst.executeUpdate();
                                if (n > 0) {
                                    JOptionPane.showMessageDialog(null, "Registro Creado Exitosamente");
                                }

                            } catch (SQLException ex) {
                                Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            limpiar_d_policial();
                        }
                    }
                }
            } //fin while res.next
            if (existe == false) {
                if (Nombres.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Nombres' Vacio", "aviso", 1);
                } else if (Apellidos.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Apellidos' Vacio", "aviso", 1);
                } else if (Cedula.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Cedula' Vacio", "aviso", 1);
                } else if (Edad.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Edad' Vacio", "aviso", 1);
                } else if (FechaN.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Fecha' Vacio", "aviso", 1);
                } else if (LugarN.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'LugarN' Vacio", "aviso", 1);
                } else if (Nacionalidad.getSelectedItem().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Nacionalidad' Vacio", "aviso", 1);
                } else if (EstadoCivil.getSelectedItem().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Estado Civil' Vacio", "aviso", 1);
                } else if (Ocupacion.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Ocupacion' Vacio", "aviso", 1);
                } else if (LugarResid.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Lugar R' Vacio", "aviso", 1);
                } else if (NombreMadre.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Nombre Madre' Vacio", "aviso", 1);
                } else if (CondicionM.getSelectedItem().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Condicion Madre' Vacio", "aviso", 1);
                } else if (NombrePadre.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Nombre Padre' Vacio", "aviso", 1);
                } else if (CondicionP.getSelectedItem().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Condicion Padre' Vacio", "aviso", 1);
                } else if (idfuncionario.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Campo del Funcionario Está Vacio", "aviso", 1);
                } else {

                    String nom, apell, ced, edd, fnacim, lnacim, nacional, edocivil, ocupa, lresid, nomma, conma, nompa, conpa, fun;

                    nom = Nombres.getText();
                    apell = Apellidos.getText();
                    ced = Cedula.getText();
                    edd = Edad.getText();
                    fnacim = FechaN.getDateFormatString();
                    lnacim = LugarN.getText();
                    nacional = Nacionalidad.getActionCommand();
                    edocivil = EstadoCivil.getActionCommand();
                    ocupa = Ocupacion.getText();
                    lresid = LugarResid.getText();
                    nomma = NombreMadre.getText();
                    conma = CondicionM.getActionCommand();
                    nompa = NombrePadre.getText();
                    conpa = CondicionP.getActionCommand();
                    fun = idfuncionario.getText();

                    sql = "INSERT INTO registro_personal (Nombres, Apellidos, Cedula, Edad, FechaN, LugarN, Nacionalidad, EstadoCivil, Ocupacion, LugarResid, NombreMadre, CondicionM, NombrePadre, CondicionP, idfuncionario) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                    try {
                        PreparedStatement pst = cn.prepareCall(sql);

                        pst.setString(1, nom);
                        pst.setString(2, apell);
                        pst.setString(3, ced);
                        pst.setString(4, edd);
                        pst.setDate(5, new java.sql.Date(FechaN.getDate().getTime()));
                        pst.setString(6, lnacim);
                        pst.setString(7, Nacionalidad.getSelectedItem().toString());
                        pst.setString(8, EstadoCivil.getSelectedItem().toString());
                        pst.setString(9, ocupa);
                        pst.setString(10, lresid);
                        pst.setString(11, nomma);
                        pst.setString(12, CondicionM.getSelectedItem().toString());
                        pst.setString(13, nompa);
                        pst.setString(14, CondicionP.getSelectedItem().toString());
                        pst.setString(15, fun);

                        int n = pst.executeUpdate();
                        if (n > 0) {
                            JOptionPane.showMessageDialog(null, "Registro Creado Exitosamente");

                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                if (Delito.getSelectedItem().equals("Seleccione...")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Delito' Vacio", "aviso", 1);
                } else if (Observacion.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Observaciones' Vacio", "aviso", 1);
                } else {

                    String no, ap, ce, ed, fn, ln, na, ec, oc, lr, nm, cm, np, cp, de, fe, ob, fp, f, ffrr;

                    no = Nombres.getText();
                    ap = Apellidos.getText();
                    ce = Cedula.getText();
                    ed = Edad.getText();
                    fn = FechaN.getDateFormatString();
                    ln = LugarN.getText();
                    na = Nacionalidad.getActionCommand();
                    ec = EstadoCivil.getActionCommand();
                    oc = Ocupacion.getText();
                    lr = LugarResid.getText();
                    nm = NombreMadre.getText();
                    cm = CondicionM.getActionCommand();
                    np = NombrePadre.getText();
                    cp = CondicionP.getActionCommand();
                    de = Delito.getActionCommand();
                    fe = jlbdia.getText();
                    ob = Observacion.getText();
                    fp = idfuncionario.getText();
                    f = txtcamara.getText();
                    ffrr = jlbdia1.getText();

                    sql = "INSERT INTO registro_policial (Nombres, Apellidos, Cedula, Edad, FechaN, LugarN, Nacionalidad, EstadoCivil, Ocupacion, LugarResid, NombreMadre, CondicionM, NombrePadre, CondicionP, Delito, FechaD, Observacion, idfuncionario, foto, FechaR) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                    try {
                        PreparedStatement pst = cn.prepareCall(sql);

                        pst.setString(1, no);
                        pst.setString(2, ap);
                        pst.setString(3, ce);
                        pst.setString(4, ed);
                        pst.setDate(5, new java.sql.Date(FechaN.getDate().getTime()));
                        pst.setString(6, ln);
                        pst.setString(7, Nacionalidad.getSelectedItem().toString());
                        pst.setString(8, EstadoCivil.getSelectedItem().toString());
                        pst.setString(9, oc);
                        pst.setString(10, lr);
                        pst.setString(11, nm);
                        pst.setString(12, CondicionM.getSelectedItem().toString());
                        pst.setString(13, np);
                        pst.setString(14, CondicionP.getSelectedItem().toString());
                        pst.setString(15, Delito.getSelectedItem().toString());
                        pst.setString(16, fe);
                        pst.setString(17, ob);
                        pst.setString(18, fp);
                        pst.setBinaryStream(19, fis, longitudBytes);
                        pst.setString(20, ffrr);

                        txtcamara.setIcon(null);

                        int n = pst.executeUpdate();
                        if (n > 0) {
                            JOptionPane.showMessageDialog(null, "Registro Creado Exitosamente");
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    limpiar_d_policial();
                }
            }
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_guardarActionPerformed

    private void delitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delitoActionPerformed
        buscadorD.setText("");
        r_delitos.setVisible(true);
        r_incidentes.setVisible(false);
    }//GEN-LAST:event_delitoActionPerformed

    private void inciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inciActionPerformed
        buscadorI.setText("");
        r_delitos.setVisible(false);
        r_incidentes.setVisible(true);
    }//GEN-LAST:event_inciActionPerformed

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        limpiar_r_delitos();
        limpiar_d_policial();
        habilitar_datos_delito();
        txtcamara.setIcon(null);
        buscadorD.setText("");
        denuncia.setEnabled(true);
        dee();
        CargarPersonalesDelitos("");
        habilitar_datos_delito();
        jPanelSlider2.setVisible(true);
        jPanelSlider2.nextPanel(10, r_delitos, jPanelSlider2.right);

    }//GEN-LAST:event_inicioActionPerformed

    private void tabla_d2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_d2MouseClicked
        eee();
        deshabilitar_datos_delito();
        if (evt.getButton() == 1) {
            int pst = tabla_d2.getSelectedRow();
            try {
                String sql = "SELECT * FROM registro_personal where Id= " + tabla_d2.getValueAt(pst, 0).toString();
                sent = cn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                Nombres.setText(rs.getString("Nombres"));
                Apellidos.setText(rs.getString("Apellidos"));
                Cedula.setText(rs.getString("Cedula"));
                buscadorD.setText(rs.getString("Cedula"));
                Edad.setText(rs.getString("Edad"));
                FechaN.setDate(rs.getDate("FechaN"));
                LugarN.setText(rs.getString("LugarN"));
                Nacionalidad.setSelectedItem(rs.getString("Nacionalidad"));
                EstadoCivil.setSelectedItem(rs.getString("EstadoCivil"));
                Ocupacion.setText(rs.getString("Ocupacion"));
                LugarResid.setText(rs.getString("LugarResid"));
                NombreMadre.setText(rs.getString("NombreMadre"));
                CondicionM.setSelectedItem(rs.getString("CondicionM"));
                NombrePadre.setText(rs.getString("NombrePadre"));
                CondicionP.setSelectedItem(rs.getString("CondicionP"));

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_d2MouseClicked

    private void guardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar2ActionPerformed
        String regist;
        String sql = ("");
        String exp = cedula.getText();

        boolean existe = false; //variable bandera para comprobar si NO existe el expediente en la BD

        try {
            sql = "SELECT * FROM registro_personal_incidentes WHERE Cedula = '" + exp + "'";

            ResultSet rs = sent.executeQuery(sql);

            while (rs.next()) {
                existe = true;
                if (existe == true) {
                    regist = rs.getString("Cedula");
                    if (exp.equals(regist)) {
                        JOptionPane.showMessageDialog(null, "El Titular de: " + regist + " está Registrado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                        if (jlbdia.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'fecha' Vacio", "aviso", 1);
                        } else if (detalles.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'detalles' Vacio", "aviso", 1);
                        } else {

                            String noI, apI, ceI, diI, feI, deI, fpI;

                            noI = nombres.getText();
                            apI = apellidos.getText();
                            ceI = cedula.getText();
                            diI = direccion.getText();
                            feI = jlbdia.getText();
                            deI = detalles.getText();
                            fpI = idfuncionario.getText();

                            sql = "INSERT INTO registro_policial_incidentes (Nombres, Apellidos, Cedula, Direccion, Fecha, Detalles, idfuncionario) VALUES(?,?,?,?,?,?,?)";

                            try {
                                PreparedStatement pst = cn.prepareCall(sql);

                                pst.setString(1, noI);
                                pst.setString(2, apI);
                                pst.setString(3, ceI);
                                pst.setString(4, diI);
                                pst.setString(5, feI);
                                pst.setString(6, deI);
                                pst.setString(7, fpI);

                                int n = pst.executeUpdate();
                                if (n > 0) {
                                    JOptionPane.showMessageDialog(null, "Registro Creado Exitosamente");
                                }

                            } catch (SQLException ex) {
                                Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            } //fin while res.next
            if (existe == false) {
                if (nombres.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Nombres' Vacio", "aviso", 1);
                } else if (apellidos.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Apellidos' Vacio", "aviso", 1);
                } else if (cedula.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Cédula' Vacio", "aviso", 1);
                } else if (direccion.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Dirección' Vacio", "aviso", 1);
                } else if (idfuncionario.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Campo del Funcionario Está Vacio", "aviso", 1);
                } else {

                    String noI, apI, ceI, diI, fpI;

                    noI = nombres.getText();
                    apI = apellidos.getText();
                    ceI = cedula.getText();
                    diI = direccion.getText();
                    fpI = idfuncionario.getText();

                    sql = "INSERT INTO registro_personal_incidentes (Nombres, Apellidos, Cedula, Direccion, idfuncionario) VALUES(?,?,?,?,?)";

                    try {
                        PreparedStatement pst = cn.prepareCall(sql);

                        pst.setString(1, noI);
                        pst.setString(2, apI);
                        pst.setString(3, ceI);
                        pst.setString(4, diI);
                        pst.setString(5, fpI);

                        int n = pst.executeUpdate();
                        if (n > 0) {
                            JOptionPane.showMessageDialog(null, "Registro Creado Exitosamente");

                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                if (detalles.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Detalles' Vacio", "aviso", 1);
                } else if (idfuncionario.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Campo del Funcionario Está Vacio", "aviso", 1);
                } else {

                    String noI, apI, ceI, diI, feI, deI, fpI;

                    noI = nombres.getText();
                    apI = apellidos.getText();
                    ceI = cedula.getText();
                    diI = direccion.getText();
                    feI = jlbdia.getText();
                    deI = detalles.getText();
                    fpI = idfuncionario.getText();

                    sql = "INSERT INTO registro_policial_incidentes (Nombres, Apellidos, Cedula, Direccion, Fecha, Detalles, idfuncionario) VALUES(?,?,?,?,?,?,?)";

                    try {
                        PreparedStatement pst = cn.prepareCall(sql);

                        pst.setString(1, noI);
                        pst.setString(2, apI);
                        pst.setString(3, ceI);
                        pst.setString(4, diI);
                        pst.setString(5, feI);
                        pst.setString(6, deI);
                        pst.setString(7, fpI);

                        int n = pst.executeUpdate();
                        if (n > 0) {
                            JOptionPane.showMessageDialog(null, "Registro Creado Exitosamente");
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            rs.close();
            detalles.setText("");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_guardar2ActionPerformed

    private void tabla_dMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_dMouseClicked
        if (evt.getButton() == 1) {
            int pst = tabla_d.getSelectedRow();
            try {
                String sql = "SELECT * FROM registro_personal_incidentes where Id= " + tabla_d.getValueAt(pst, 0).toString();
                sent = cn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                nombres.setText(rs.getString("Nombres"));
                apellidos.setText(rs.getString("Apellidos"));
                cedula.setText(rs.getString("Cedula"));
                buscadorI.setText(rs.getString("Cedula"));
                direccion.setText(rs.getString("Direccion"));

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        eee2();
        deshabilitar_datos_incidente();
// TODO add your handling code here:
    }//GEN-LAST:event_tabla_dMouseClicked

    private void masActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masActionPerformed
        delitos h = new delitos();
        h.setVisible(true);
    }//GEN-LAST:event_masActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        Delito.removeAllItems();
        Delito.addItem("Seleccione...");

        try {

            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery("select * from delitos");
            while (rs.next()) {
                this.Delito.addItem(rs.getString("delito"));
            }
            contador--;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
    }//GEN-LAST:event_actualizarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        if (Nombres.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Nombres' Vacio", "aviso", 1);
        } else if (Apellidos.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Apellidos' Vacio", "aviso", 1);
        } else if (Cedula.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Cédula' Vacio", "aviso", 1);
        } else if (Edad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Edad' Vacio", "aviso", 1);
        } else if (FechaN.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Lugar Nacimiento' Vacio", "aviso", 1);
        } else if (LugarN.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Fecha Nacimiento' Vacio", "aviso", 1);
        } else if (Nacionalidad.getSelectedItem().equals("Seleccione...")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Nacionalidad' Vacio", "aviso", 1);
        } else if (EstadoCivil.getSelectedItem().equals("Seleccione...")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Estado Civil' Vacio", "aviso", 1);
        } else if (Ocupacion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Ocupación' Vacio", "aviso", 1);
        } else if (LugarResid.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Lugar Residencia' Vacio", "aviso", 1);
        } else if (NombreMadre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Nombres de Madre' Vacio", "aviso", 1);
        } else if (CondicionM.getSelectedItem().equals("Seleccione...")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Condición Mamá' Vacio", "aviso", 1);
        } else if (NombrePadre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Nombres de Padre' Vacio", "aviso", 1);
        } else if (CondicionP.getSelectedItem().equals("Seleccione...")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Condición Papá' Vacio", "aviso", 1);
        } else {
            String nnoo, aapp, ccee, eedd, ffnn, llnn, nnaa, eecc, oocc, llrr, nnmm, ccmm, nnpp, ccpp, iiff;
            String sql = "";

            nnoo = Nombres.getText();
            aapp = Apellidos.getText();
            ccee = Cedula.getText();
            eedd = Edad.getText();
            ffnn = FechaN.getDateFormatString();
            llnn = LugarN.getText();
            nnaa = Nacionalidad.getActionCommand();
            eecc = EstadoCivil.getActionCommand();
            oocc = Ocupacion.getText();
            llrr = LugarResid.getText();
            nnmm = NombreMadre.getText();
            ccmm = CondicionM.getActionCommand();
            nnpp = NombrePadre.getText();
            ccpp = CondicionP.getActionCommand();
            iiff = idfuncionario.getText();

            try {
                sql = "Update registro_personal set Nombres = ?, Apellidos = ?, Cedula = ?, Edad = ?, FechaN = ?, LugarN = ?, Nacionalidad = ?, EstadoCivil = ?, Ocupacion = ?, LugarResid = ?, NombreMadre = ?, CondicionM = ?, NombrePadre = ?, CondicionP =?, idfuncionario = ? "
                        + "where Id=?";
                int fila = tabla_d2.getSelectedRow();
                String dae = (String) tabla_d2.getValueAt(fila, 0);
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, nnoo);
                pst.setString(2, aapp);
                pst.setString(3, ccee);
                pst.setString(4, eedd);
                pst.setDate(5, new java.sql.Date(FechaN.getDate().getTime()));
                pst.setString(6, llnn);
                pst.setString(7, (Nacionalidad.getSelectedItem().toString()));
                pst.setString(8, (EstadoCivil.getSelectedItem().toString()));
                pst.setString(9, oocc);
                pst.setString(10, llrr);
                pst.setString(11, nnmm);
                pst.setString(12, (CondicionM.getSelectedItem().toString()));
                pst.setString(13, nnpp);
                pst.setString(14, (CondicionP.getSelectedItem().toString()));
                pst.setString(15, iiff);
                pst.setString(16, dae);
                int n = pst.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                }

                //limpiar_r_delitos();
                deshabilitar_datos_delito();
                CargarPersonalesDelitos("");
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_modificarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed

        caja_edita_delito = idfuncionario.getText();
        UserName1.setText(caja_edita_delito);
        UserName1.setEditable(false);
        habilitar_datos_delito();

        editar.setEnabled(true);
        eliminar.setEnabled(true);
        denuncia.setEnabled(false);

        jPanelSlider2.setVisible(true);
        jPanelSlider2.nextPanel(10, confirma_editar_d, jPanelSlider2.left);

        vertical1.setVisible(true);
        vertical2.setVisible(false);
        escudo.setVisible(true);
        jPanelSlider1.setVisible(true);
        jPanelSlider1.nextPanel(10, menu2, jPanelSlider1.right);
    }//GEN-LAST:event_editarActionPerformed

    private void modificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar2ActionPerformed
        if (nombres.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'nombres' Vacio", "aviso", 1);
        } else if (apellidos.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'apellidos' Vacio", "aviso", 1);
        } else if (cedula.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'cedula' Vacio", "aviso", 1);
        } else if (direccion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'direccion' Vacio", "aviso", 1);
        } else {
            String nus, aus, cus, dus, idus;
            String sql = "";

            nus = nombres.getText();
            aus = apellidos.getText();
            cus = cedula.getText();
            dus = direccion.getText();
            idus = idfuncionario.getText();

            try {
                sql = "Update registro_personal_incidentes set Nombres=?, Apellidos=?, Cedula=?, Direccion=?, idfuncionario=?"
                        + "where Id=?";
                int fila = tabla_d.getSelectedRow();
                String dao = (String) tabla_d.getValueAt(fila, 0);
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, nus);
                pst.setString(2, aus);
                pst.setString(3, cus);
                pst.setString(4, dus);
                pst.setString(5, idus);
                pst.setString(6, dao);
                int n = pst.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                }
                limpiar_r_incidentes();
                CargarPersonalesIncidentes("");
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_modificar2ActionPerformed

    private void inicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicio2ActionPerformed
        dee2();
        habilitar_datos_incidente();
        buscadorI.setText("");
        limpiar_r_incidentes();
        CargarPersonalesIncidentes("");
        incidente.setEnabled(true);
        jPanelSlider2.setVisible(true);
        jPanelSlider2.nextPanel(10, r_incidentes, jPanelSlider2.right);        // TODO add your handling code here:
    }//GEN-LAST:event_inicio2ActionPerformed

    private void editar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar2ActionPerformed

        caja_edita_incidente = idfuncionario.getText();
        UserName2.setText(caja_edita_incidente);
        UserName2.setEditable(false);

        editar2.setEnabled(true);
        eliminar2.setEnabled(true);
        incidente.setEnabled(false);
        
        habilitar_datos_incidente();

        jPanelSlider2.setVisible(true);
        jPanelSlider2.nextPanel(10, confirma_editar_i, jPanelSlider2.left);

        vertical1.setVisible(true);
        vertical2.setVisible(false);
        escudo.setVisible(true);
        jPanelSlider1.setVisible(true);
        jPanelSlider1.nextPanel(10, menu2, jPanelSlider1.right);
    }//GEN-LAST:event_editar2ActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        String usuario = UserName.getText();
        String contraseña = new String(Pass.getPassword());
        confirmar(usuario, contraseña);
        // TODO add your handling code here:
    }//GEN-LAST:event_aceptarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        limpiar_r_incidentes();
        buscadorI.setText("");
        dee2();
        usuarios.setEnabled(true);
        jPanelSlider2.setVisible(true);
        jPanelSlider2.nextPanel(10, r_incidentes, jPanelSlider2.right);

        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        if (nombre_user.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'USUARIO' Vacio", "aviso", 1);
        } else if (clave.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'CONTRASEÑA' Vacio", "aviso", 1);
        } else if (tipo_user.getSelectedItem().equals("Seleccione...")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'TIPO DE USUARIO' Vacio", "aviso", 1);
        } else {
            String us, cc, tu;
            String sql = "";

            us = nombre_user.getText();
            cc = clave.getText();
            tu = tipo_user.getActionCommand();

            sql = "INSERT INTO usuarios (nombre_user, clave, tipo_user) VALUES(?,?,?)";

            try {
                PreparedStatement pst = cn.prepareCall(sql);

                pst.setString(1, us);
                pst.setString(2, cc);
                pst.setString(3, (tipo_user.getSelectedItem().toString()));

                int n = pst.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario Creado Exitosamente");

                }
                LimpiarUsuarios();
                des_campos_usuarios();
                bGuardar.setEnabled(false);
                bCancelar.setEnabled(false);

                bRegistrar.setEnabled(true);
                CargarUsuarios("");
            } catch (SQLException ex) {
                Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_bGuardarActionPerformed

    private void tabla_d3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_d3MouseClicked
        if (evt.getButton() == 1) {
            int pst = tabla_d3.getSelectedRow();
            try {
                String sql = "SELECT * FROM usuarios where id= " + tabla_d3.getValueAt(pst, 0).toString();
                sent = cn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                nombre_user.setText(rs.getString("nombre_user"));
                clave.setText(rs.getString("clave"));
                tipo_user.setSelectedItem(rs.getString("tipo_user"));
                des_campos_usuarios();
                bGuardar.setEnabled(false);
                bRegistrar.setEnabled(true);
                bEditar.setEnabled(true);
                bEliminar.setEnabled(true);
                bCancelar.setEnabled(true);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            // TODO add your handling code here:
    }//GEN-LAST:event_tabla_d3MouseClicked
    }
    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        bGuardar.setEnabled(false);
        bModificar.setEnabled(false);
        bCancelar.setEnabled(false);

        bRegistrar.setEnabled(true);
        bEditar.setEnabled(true);
        bEditar.setEnabled(false);
        bEliminar.setEnabled(false);

        LimpiarUsuarios();
        des_campos_usuarios();    // TODO add your handling code here:
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarActionPerformed
        nombre_user.requestFocus();
        bGuardar.setEnabled(true);
        bCancelar.setEnabled(true);
        bRegistrar.setEnabled(false);
        bEditar.setEnabled(false);
        bEliminar.setEnabled(false);
        LimpiarUsuarios();
        hab_campos_usuarios();        // TODO add your handling code here:
    }//GEN-LAST:event_bRegistrarActionPerformed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed
        bModificar.setEnabled(true);
        bEditar.setEnabled(false);
        bEliminar.setEnabled(false);
        bRegistrar.setEnabled(false);
        hab_campos_usuarios();        // TODO add your handling code here:
    }//GEN-LAST:event_bEditarActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        if (nombre_user.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Usuario' Vacio", "aviso", 1);
        } else if (clave.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Contraseña' Vacio", "aviso", 1);
        } else if (tipo_user.getSelectedItem().equals("Seleccione...")) {
            JOptionPane.showMessageDialog(null, "Ha Dejado el Campo 'Tipo de Usuario' Vacio", "aviso", 1);
        } else {
            String us, cc, tu;
            String sql = "";

            us = nombre_user.getText();
            cc = clave.getText();
            tu = (String) tipo_user.getSelectedItem();

            try {
                sql = "Update usuarios set nombre_user=?, clave=?, tipo_user=?"
                        + "where id=?";
                int fila = tabla_d3.getSelectedRow();
                String dao = (String) tabla_d3.getValueAt(fila, 0);
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, us);
                pst.setString(2, cc);
                pst.setString(3, tu);
                pst.setString(4, dao);
                int n = pst.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                }
                LimpiarUsuarios();
                des_campos_usuarios();
                bRegistrar.setEnabled(true);
                bModificar.setEnabled(false);
                bEditar.setEnabled(true);
                bEditar.setEnabled(false);
                bCancelar.setEnabled(false);
                CargarUsuarios("");
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_bModificarActionPerformed

    private void buscador3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscador3KeyReleased
        CargarUsuarios(buscador3.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_buscador3KeyReleased

    private void ir_camaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir_camaraActionPerformed
   
        webcam j = new webcam();
        j.setVisible(true);
        hbimg();
    }//GEN-LAST:event_ir_camaraActionPerformed

    private void b_imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_imagenActionPerformed
        act_campos();
        txtcamara.setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {

            try {
                fis = new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes = (int) j.getSelectedFile().length();
                try {
                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(txtcamara.getWidth(), txtcamara.getHeight(), Image.SCALE_DEFAULT);
                    txtcamara.setIcon(new ImageIcon(icono));
                    txtcamara.updateUI();
                    b_imagen.setVisible(false);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: " + ex);

                }
            } catch (FileNotFoundException ex) {

            }
        }
    }//GEN-LAST:event_b_imagenActionPerformed

    private void buscadorIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorIKeyReleased
        CargarPersonalesIncidentes(buscadorI.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_buscadorIKeyReleased

    private void buscadorIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscadorIActionPerformed

    private void buscadorDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorDKeyReleased
        CargarPersonalesDelitos(buscadorD.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_buscadorDKeyReleased

    private void aceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar1ActionPerformed
        String usuario = UserName1.getText();
        String contraseña = new String(Pass1.getPassword());
        ConfirmarEditarDelito(usuario, contraseña);
        Pass1.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_aceptar1ActionPerformed

    private void cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar1ActionPerformed
        limpiar_r_delitos();
        denuncia.setEnabled(true);
        Pass1.setText("");
        buscadorD.setText("");
        dee();
        CargarPersonalesDelitos("");

        jPanelSlider2.setVisible(true);
        jPanelSlider2.nextPanel(10, r_delitos, jPanelSlider2.right);        // TODO add your handling code here:
    }//GEN-LAST:event_cancelar1ActionPerformed

    private void aceptar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar3ActionPerformed
        String usuario = UserName3.getText();
        String contraseña = new String(Pass3.getPassword());
        ConfirmarEliminarDelito(usuario, contraseña);
        Pass3.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_aceptar3ActionPerformed

    private void cancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar2ActionPerformed
        limpiar_r_delitos();
        denuncia.setEnabled(true);
        Pass3.setText("");
        buscadorD.setText("");
        dee();
        CargarPersonalesDelitos("");

        jPanelSlider2.setVisible(true);
        jPanelSlider2.nextPanel(10, r_delitos, jPanelSlider2.right);           // TODO add your handling code here:
    }//GEN-LAST:event_cancelar2ActionPerformed

    private void aceptar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar2ActionPerformed
        String usuario = UserName2.getText();
        String contraseña = new String(Pass2.getPassword());
        ConfirmarEditarIncidente(usuario, contraseña);
        Pass2.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_aceptar2ActionPerformed

    private void cancelar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar3ActionPerformed
        limpiar_r_incidentes();
        incidente.setEnabled(true);
        Pass2.setText("");
        buscadorI.setText("");
        dee2();
        CargarPersonalesIncidentes("");

        jPanelSlider2.setVisible(true);
        jPanelSlider2.nextPanel(10, r_incidentes, jPanelSlider2.right);    // TODO add your handling code here:
    }//GEN-LAST:event_cancelar3ActionPerformed

    private void aceptar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar4ActionPerformed
        String usuario = UserName4.getText();
        String contraseña = new String(Pass4.getPassword());
        ConfirmarEliminarIncidente(usuario, contraseña);
        Pass4.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_aceptar4ActionPerformed

    private void cancelar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar4ActionPerformed
        limpiar_r_incidentes();
        incidente.setEnabled(true);
        Pass4.setText("");
        buscadorD.setText("");
        dee2();
        CargarPersonalesIncidentes("");

        jPanelSlider2.setVisible(true);
        jPanelSlider2.nextPanel(10, r_incidentes, jPanelSlider2.right);         // TODO add your handling code here:
    }//GEN-LAST:event_cancelar4ActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        caja_elimina_delito = idfuncionario.getText();
        UserName3.setText(caja_elimina_delito);
        UserName3.setEditable(false);
        buscadorD.setText("");

        editar.setEnabled(true);
        eliminar.setEnabled(true);
        denuncia.setEnabled(false);

        jPanelSlider2.setVisible(true);
        jPanelSlider2.nextPanel(10, confirma_eliminar_d, jPanelSlider2.left);

        vertical1.setVisible(true);
        vertical2.setVisible(false);
        escudo.setVisible(true);
        jPanelSlider1.setVisible(true);
        jPanelSlider1.nextPanel(10, menu2, jPanelSlider1.right);        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        try {
            Object[] options = {"Si", "No"};
            int d = JOptionPane.showOptionDialog(null, "¿Desea Eliminar Este Usuario?", "ATENCION",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (d == JOptionPane.YES_OPTION) {

                int fila = tabla_d3.getSelectedRow();
                String sql = "delete from usuarios where id = " + tabla_d3.getValueAt(fila, 0);
                sent = cn.createStatement();
                int n = sent.executeUpdate(sql);
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                }
            }
            CargarUsuarios("");
            LimpiarUsuarios();
            bEliminar.setEnabled(false);
            bEditar.setEnabled(false);
            bCancelar.setEnabled(false);
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_bEliminarActionPerformed

    private void eliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar2ActionPerformed
        caja_elimina_incidente = idfuncionario.getText();
        UserName4.setText(caja_elimina_incidente);
        UserName4.setEditable(false);
        buscadorI.setText("");

        editar2.setEnabled(true);
        eliminar2.setEnabled(true);
        incidente.setEnabled(false);

        jPanelSlider2.setVisible(true);
        jPanelSlider2.nextPanel(10, confirma_eliminar_i, jPanelSlider2.left);

        vertical1.setVisible(true);
        vertical2.setVisible(false);
        escudo.setVisible(true);
        jPanelSlider1.setVisible(true);
        jPanelSlider1.nextPanel(10, menu2, jPanelSlider1.right);        // TODO add your handling code here:
    }//GEN-LAST:event_eliminar2ActionPerformed

    private void buscadorIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscadorIMouseClicked
        CargarPersonalesIncidentes("");
        dee2();// TODO add your handling code here:
    }//GEN-LAST:event_buscadorIMouseClicked

    private void buscadorDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscadorDMouseClicked
        CargarPersonalesDelitos("");
        dee();// TODO add your handling code here:
    }//GEN-LAST:event_buscadorDMouseClicked

    private void cneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cneActionPerformed
        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                try {
                    java.net.URI uri = new java.net.URI("http://www.cne.gob.ve/web/index.php");
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                }
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cneActionPerformed

    private void NombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombresKeyTyped
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas           
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas           
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_NombresKeyTyped

    private void ApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ApellidosKeyTyped
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas           
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas           
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_ApellidosKeyTyped

    private void LugarNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LugarNKeyTyped
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas           
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas           
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_LugarNKeyTyped

    private void OcupacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OcupacionKeyTyped
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas           
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas           
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_OcupacionKeyTyped

    private void LugarResidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LugarResidKeyTyped
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas           
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas           
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_LugarResidKeyTyped

    private void NombreMadreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreMadreKeyTyped
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas           
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas           
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_NombreMadreKeyTyped

    private void NombrePadreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombrePadreKeyTyped
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas           
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas           
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_NombrePadreKeyTyped

    private void nombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombresKeyTyped
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas           
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas           
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_nombresKeyTyped

    private void apellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidosKeyTyped
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas           
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas           
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_apellidosKeyTyped

    private void direccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionKeyTyped
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas           
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas           
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_direccionKeyTyped

    private void cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaKeyTyped
        char car = evt.getKeyChar();
        if (cedula.getText().length() >= 10) {
            evt.consume();
        }
        if ((car < '0' || car > '9')) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaKeyTyped

    private void CedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CedulaKeyTyped
        char car = evt.getKeyChar();
        if (Cedula.getText().length() >= 10) {
            evt.consume();
        }
        if ((car < '0' || car > '9')) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_CedulaKeyTyped

    private void EdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EdadKeyTyped
        char car = evt.getKeyChar();
        if (Edad.getText().length() >= 10) {
            evt.consume();
        }
        if ((car < '0' || car > '9')) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_EdadKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    login log = new login();
    log.setVisible(true);
    dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void UserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserNameActionPerformed

    private void bInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInicioActionPerformed
    jPanelSlider2.setVisible(true);
    jPanelSlider2.nextPanel(10, r_delitos, jPanelSlider2.right);        // TODO add your handling code here:
    }//GEN-LAST:event_bInicioActionPerformed

    private void idfuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idfuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idfuncionarioActionPerformed

    public void fecha() {
        String fecha = Fecha();
        String fecha0 = Fecha0();
        jlbdia.setText(fecha);
        jlbdia1.setText(fecha0);

    }

    public String nombre(int mes) {
        switch (mes) {
            case 0:
                return "Enero";
            case 1:
                return "Febrero";
            case 2:
                return "Marzo";
            case 3:
                return "Abril";
            case 4:
                return "Mayo";
            case 5:
                return "Junio";
            case 6:
                return "Julio";
            case 7:
                return "08";
            case 8:
                return "09";
            case 9:
                return "10";
            case 10:
                return "11";
            case 11:
                return "12";
        }
        return "ERROR";
    }

    public String Fecha() {
        GregorianCalendar fecha = new GregorianCalendar();

        int dia = fecha.get(fecha.DAY_OF_MONTH);
        int mes = fecha.get(fecha.MONTH);
        int año = fecha.get(fecha.YEAR);
        String mifecha = String.valueOf(dia) + "/" + nombre(mes) + "/" + String.valueOf(año);
        return mifecha;

    }

    public String Fecha0() {
        GregorianCalendar fecha = new GregorianCalendar();

        int dia = fecha.get(fecha.DAY_OF_MONTH);
        int mes = fecha.get(fecha.MONTH);
        int año = fecha.get(fecha.YEAR);
        String mifecha = nombre(mes) + "/" + String.valueOf(año);
        return mifecha;

    }

    /**
     * @param args the command line arguments
     */
    public static String fechaActual() { //metodo para capturar fecha
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");

        return formatoFecha.format(fecha);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(a.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(a.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(a.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(a.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new a().setVisible(true);
            }
        });
    }

    public void run() {

        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            lbHora.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apellidos;
    private javax.swing.JLabel BioPol2;
    private javax.swing.JTextField Cedula;
    private javax.swing.JComboBox CondicionM;
    private javax.swing.JComboBox CondicionP;
    private javax.swing.JComboBox Delito;
    private javax.swing.JTextField Edad;
    private javax.swing.JComboBox EstadoCivil;
    private javax.swing.JLabel FONDO;
    private com.toedter.calendar.JDateChooser FechaN;
    private javax.swing.JTextField LugarN;
    private javax.swing.JTextField LugarResid;
    private javax.swing.JComboBox Nacionalidad;
    private javax.swing.JTextField NombreMadre;
    private javax.swing.JTextField NombrePadre;
    private javax.swing.JTextField Nombres;
    private javax.swing.JTextArea Observacion;
    private javax.swing.JTextField Ocupacion;
    private javax.swing.JPasswordField Pass;
    private javax.swing.JPasswordField Pass1;
    private javax.swing.JPasswordField Pass2;
    private javax.swing.JPasswordField Pass3;
    private javax.swing.JPasswordField Pass4;
    private javax.swing.JTextField UserName;
    private javax.swing.JTextField UserName1;
    private javax.swing.JTextField UserName2;
    private javax.swing.JTextField UserName3;
    private javax.swing.JTextField UserName4;
    private javax.swing.JButton aceptar;
    private javax.swing.JButton aceptar1;
    private javax.swing.JButton aceptar2;
    private javax.swing.JButton aceptar3;
    private javax.swing.JButton aceptar4;
    private javax.swing.JButton actualizar;
    private javax.swing.JTextField apellidos;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bEditar;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bInicio;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bRegistrar;
    private javax.swing.JButton b_imagen;
    private javax.swing.JTextField buscador3;
    private javax.swing.JTextField buscadorD;
    private javax.swing.JTextField buscadorI;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton cancelar1;
    private javax.swing.JButton cancelar2;
    private javax.swing.JButton cancelar3;
    private javax.swing.JButton cancelar4;
    private javax.swing.JTextField cedula;
    private javax.swing.JPasswordField clave;
    private javax.swing.JButton cne;
    public javax.swing.JPanel confirma;
    public javax.swing.JPanel confirma_editar_d;
    public javax.swing.JPanel confirma_editar_i;
    public javax.swing.JPanel confirma_eliminar_d;
    public javax.swing.JPanel confirma_eliminar_i;
    public static javax.swing.JButton consulta;
    private javax.swing.JPanel d_delito;
    private javax.swing.JLabel d_filia;
    private javax.swing.JPanel d_incidentes;
    private javax.swing.JButton delito;
    private javax.swing.JButton denuncia;
    private javax.swing.JTextArea detalles;
    private javax.swing.JTextField direccion;
    private javax.swing.JButton editar;
    private javax.swing.JButton editar2;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton eliminar2;
    private javax.swing.JLabel escudo;
    private javax.swing.JLabel f_fondo;
    private javax.swing.JLabel f_fondo1;
    private javax.swing.JLabel f_fondo10;
    private javax.swing.JLabel f_fondo3;
    private javax.swing.JLabel f_fondo4;
    private javax.swing.JLabel f_fondo5;
    private javax.swing.JLabel f_fondo6;
    private javax.swing.JLabel f_fondo7;
    private javax.swing.JLabel f_fondo8;
    private javax.swing.JLabel f_fondo9;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton guardar;
    private javax.swing.JButton guardar2;
    public static javax.swing.JTextField idfuncionario;
    private javax.swing.JButton inci;
    private javax.swing.JButton incidente;
    private javax.swing.JButton inicio;
    private javax.swing.JButton inicio2;
    private javax.swing.JButton ir_camara;
    private javax.swing.JLabel jBorde;
    private javax.swing.JLabel jBorde1;
    private javax.swing.JLabel jBorde2;
    private javax.swing.JLabel jBorde3;
    private javax.swing.JLabel jBorde4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private diu.swe.habib.JPanelSlider.JPanelSlider jPanelSlider1;
    private diu.swe.habib.JPanelSlider.JPanelSlider jPanelSlider2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel jlbdia;
    private javax.swing.JLabel jlbdia1;
    private javax.swing.JLabel lbHora;
    private javax.swing.JButton mas;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel menu2;
    private javax.swing.JButton modificar;
    private javax.swing.JButton modificar2;
    private javax.swing.JTextField nombre_user;
    private javax.swing.JTextField nombres;
    private javax.swing.JPanel r_delitos;
    private javax.swing.JPanel r_incidentes;
    private javax.swing.JPanel r_usuarios;
    public static javax.swing.JButton salir;
    private javax.swing.JTable tabla_d;
    private javax.swing.JTable tabla_d2;
    private javax.swing.JTable tabla_d3;
    private javax.swing.JComboBox tipo_user;
    private javax.swing.JLabel txtcamara;
    private javax.swing.JButton usuarios;
    private javax.swing.JButton vertical1;
    private javax.swing.JButton vertical2;
    // End of variables declaration//GEN-END:variables

    public void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "" + h;
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }

    private void setImageButton(JButton guardara, Image imageresize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    conectar cc = new conectar();
    Connection cn = cc.conexion();
}
