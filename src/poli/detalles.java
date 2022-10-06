/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poli;


import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Equipo
 */
public class detalles extends javax.swing.JFrame implements Runnable {

    DefaultTableModel model;
    Statement sent;
    CallableStatement cst;
    Connection conect;
    int contador = 0;

    public detalles() {
        initComponents();

        setLocationRelativeTo(null);
        deshabilitar_campos();
        final Color alphaZero = new Color(0, true);
        jScrollPane1.setBorder(null);
        tabla.setBorder(null);
        tabla.setBackground(alphaZero);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.getViewport().setBackground(alphaZero);

        cedula.setBackground(new Color(0, 0, 0, 40));
        cargar("");
        limpiar();
        cargarfecha("");

        cedula.setBackground(new Color(0, 0, 0, 40));

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
        cedula.setVisible(false);
        fechas.setVisible(false);
        buscar.setVisible(false);
        jScrollPane3.getViewport().setOpaque(false);
        jScrollPane3.getViewport().setBackground(alphaZero);

        try {

            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery("select * from registro_policial");
            while (rs.next()) {
                this.fechas.addItem(rs.getString("FechaR"));
            }
            contador++;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        contar();
    }

    void deshabilitar_campos() {
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
    
    void cargar(String valor) {
        try {
            String[] titulos = {"ID", "NOMBRES", "APELLIDOS", "CEDULA", "DELITO", "FECHA REFERENCIAL","USUARIO"};
            String[] registros = new String[10];
            String sql = "SELECT * FROM registro_policial where Cedula LIKE '%" + valor + "%' ";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("Nombres");
                registros[2] = rs.getString("Apellidos");
                registros[3] = rs.getString("Cedula");
                registros[4] = rs.getString("Delito");
                registros[5] = rs.getString("FechaR");
                registros[6] = rs.getString("idfuncionario");

                model.addRow(registros);
            }
            tabla.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    void cargarfecha(String valor) {
        try {
            String[] titulos = {"ID", "NOMBRES", "APELLIDOS", "CEDULA", "DELITO", "FECHA REFERENCIAL","USUARIO"};
            String[] registros = new String[10];
            String sql = "SELECT * FROM registro_policial where FechaR LIKE '%" + valor + "%' ";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("Nombres");
                registros[2] = rs.getString("Apellidos");
                registros[3] = rs.getString("Cedula");
                registros[4] = rs.getString("Delito");
                registros[5] = rs.getString("FechaR");
                registros[6] = rs.getString("idfuncionario");

                model.addRow(registros);
            }
            tabla.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    void limpiar() {
        cedula.setText("");

        fechas.setSelectedIndex(0);
    }

    void contar() {
        for (int x = 0; x <= tabla.getRowCount(); x++) {
            valor.setText("" + x);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSlider1 = new diu.swe.habib.JPanelSlider.JPanelSlider();
        busqueda = new javax.swing.JPanel();
        ficha = new javax.swing.JPanel();
        fechas = new javax.swing.JComboBox();
        cedula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        Nombres = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Cedula = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Edad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Apellidos = new javax.swing.JTextField();
        LugarN = new javax.swing.JTextField();
        EstadoCivil = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        LugarResid = new javax.swing.JTextField();
        txtcamara = new javax.swing.JLabel();
        NombrePadre = new javax.swing.JTextField();
        CondicionP = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        NombreMadre = new javax.swing.JTextField();
        Nacionalidad = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        FechaN = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Ocupacion = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        CondicionM = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Delito = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        Observacion = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        c_buscador = new javax.swing.JComboBox();
        buscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        valor = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSlider1.setBorder(null);
        jPanelSlider1.setOpaque(false);

        busqueda.setOpaque(false);
        busqueda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ficha.setOpaque(false);
        ficha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        busqueda.add(ficha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        fechas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));
        fechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechasActionPerformed(evt);
            }
        });
        busqueda.add(fechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 240, 160, -1));

        cedula.setForeground(new java.awt.Color(255, 255, 255));
        cedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cedulaKeyReleased(evt);
            }
        });
        busqueda.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 240, 160, -1));

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        tabla.setForeground(new java.awt.Color(255, 255, 255));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.setOpaque(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        busqueda.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 980, 110));

        Nombres.setForeground(new java.awt.Color(255, 255, 255));
        Nombres.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        busqueda.add(Nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 230, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NOMBRES:");
        busqueda.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CÉDULA:");
        busqueda.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        Cedula.setForeground(new java.awt.Color(255, 255, 255));
        Cedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        busqueda.add(Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 110, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("EDAD:");
        busqueda.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        Edad.setForeground(new java.awt.Color(255, 255, 255));
        Edad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        busqueda.add(Edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 40, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("L. NACIMIENTO:");
        busqueda.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("APELLIDOS:");
        busqueda.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        Apellidos.setForeground(new java.awt.Color(255, 255, 255));
        Apellidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        busqueda.add(Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 240, -1));

        LugarN.setForeground(new java.awt.Color(255, 255, 255));
        LugarN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        busqueda.add(LugarN, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 370, -1));

        EstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Soltero(a)", "Casado(a)", "Comprometido(a)", "Divorciado(a)", "Viudo(a)" }));
        busqueda.add(EstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 103, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ESTADO CIVIL:");
        busqueda.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        LugarResid.setForeground(new java.awt.Color(255, 255, 255));
        LugarResid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        busqueda.add(LugarResid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 320, -1));

        txtcamara.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        busqueda.add(txtcamara, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 140, 150));

        NombrePadre.setForeground(new java.awt.Color(255, 255, 255));
        NombrePadre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        busqueda.add(NombrePadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 250, -1));

        CondicionP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Vivo", "Fallecido" }));
        busqueda.add(CondicionP, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 110, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("NOMBRE PADRE:");
        busqueda.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("CONDICIÓN:");
        busqueda.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, -1, -1));

        NombreMadre.setForeground(new java.awt.Color(255, 255, 255));
        NombreMadre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        busqueda.add(NombreMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 250, -1));

        Nacionalidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Venezolano(a)", "Extranjero(a)" }));
        busqueda.add(Nacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 102, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("NACIONALIDAD:");
        busqueda.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        FechaN.setOpaque(false);
        busqueda.add(FechaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 130, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("F. NACIMIENTO");
        busqueda.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("OCUPACIÓN:");
        busqueda.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        Ocupacion.setForeground(new java.awt.Color(255, 255, 255));
        Ocupacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        busqueda.add(Ocupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 150, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("NOMBRE MADRE:");
        busqueda.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        CondicionM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Vivo", "Fallecido" }));
        busqueda.add(CondicionM, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 110, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("CONDICIÓN:");
        busqueda.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("DELITO:");
        busqueda.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, -1));

        Delito.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));
        Delito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelitoActionPerformed(evt);
            }
        });
        busqueda.add(Delito, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 160, -1));

        jScrollPane3.setBorder(null);
        jScrollPane3.setOpaque(false);

        Observacion.setColumns(20);
        Observacion.setForeground(new java.awt.Color(255, 255, 255));
        Observacion.setLineWrap(true);
        Observacion.setRows(5);
        Observacion.setBorder(null);
        Observacion.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        Observacion.setOpaque(false);
        jScrollPane3.setViewportView(Observacion);

        busqueda.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 720, 70));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("L.RESIDENCIA:");
        busqueda.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "OBSERVACIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        busqueda.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 750, 100));

        c_buscador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "CEDULA", "FECHA" }));
        c_buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_buscadorActionPerformed(evt);
            }
        });
        busqueda.add(c_buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 200, 160, -1));

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/buscar.png"))); // NOI18N
        buscar.setBorderPainted(false);
        buscar.setContentAreaFilled(false);
        buscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/buscar1.png"))); // NOI18N
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        busqueda.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 280, 140, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/r_individual.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/r_individual1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        busqueda.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 465, -1, 30));
        busqueda.add(valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 60, -1));
        busqueda.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 130, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/r_mensual.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/r_mensual1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        busqueda.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 465, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/INICIO.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/INICIO1.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        busqueda.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 465, -1, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/INCIDENTE.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/INCIDENTE2.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        busqueda.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 465, -1, 30));

        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "BUSCAR POR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        busqueda.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 185, 180, 50));

        jPanelSlider1.add(busqueda, "card2");

        getContentPane().add(jPanelSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 500));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaKeyReleased
        cargar(cedula.getText());
        contar();
    }//GEN-LAST:event_cedulaKeyReleased

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if (evt.getButton() == 1) {
            int pst = tabla.getSelectedRow();
            ImageIcon foto;
            InputStream is;
            try {
                String sql = "SELECT * FROM registro_policial where Id= " + tabla.getValueAt(pst, 0).toString();
                sent = cn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                Nombres.setText(rs.getString("Nombres"));
                Apellidos.setText(rs.getString("Apellidos"));
                Cedula.setText(rs.getString("Cedula"));
                cedula.setText(rs.getString("Cedula"));
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
                Observacion.setText(rs.getString("Observacion"));
                CondicionP.setSelectedItem(rs.getString("CondicionP"));
                is = rs.getBinaryStream("foto");
                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon(bi);

                Image img = foto.getImage();
                Image newimg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);

                ImageIcon newicon = new ImageIcon(newimg);

                txtcamara.setIcon(newicon);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            } catch (IOException ex) {
                Logger.getLogger(detalles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void c_buscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_buscadorActionPerformed
        if (c_buscador.getSelectedItem().equals("Seleccione...")) {
            cedula.setVisible(false);
            fechas.setVisible(false);

            buscar.setVisible(false);
            cargar("");
            cargarfecha("");
            limpiar();
        }
        if (c_buscador.getSelectedItem().equals("CEDULA")) {
            cedula.setVisible(true);
            fechas.setVisible(false);

            buscar.setVisible(false);
            cargar("");
            cargarfecha("");
            limpiar();
        }
        if (c_buscador.getSelectedItem().equals("FECHA")) {
            cedula.setVisible(false);
            fechas.setVisible(true);

            buscar.setVisible(true);
            cargar("");
            cargarfecha("");
            limpiar();
        }
    }//GEN-LAST:event_c_buscadorActionPerformed

    private void fechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechasActionPerformed

    }//GEN-LAST:event_fechasActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        cargarfecha(fechas.getSelectedItem().toString());
        contar();
    }//GEN-LAST:event_buscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String ubicacionreporte = System.getProperty("user.dir") + "/src/report2.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(ubicacionreporte);
            Map parametro = new HashMap();

            parametro.put("CED", cedula.getText());

            JasperPrint print = JasperFillManager.fillReport(jasperReport, parametro, cn);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        cargar("");
 
        cargarfecha("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
try {
            String ubicacionreporte = System.getProperty("user.dir") + "/src/r_fecha.jasper";
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(ubicacionreporte);
            Map parametro = new HashMap();

            parametro.put("fr", fechas.getSelectedItem());

            JasperPrint print = JasperFillManager.fillReport(jasperReport, parametro, cn);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        cargar("");

        cargarfecha("");// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    a.consulta.setEnabled(true);
    dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    datalles_incidentes op = new datalles_incidentes();
    op.setVisible(true);
    jButton4.setEnabled(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void DelitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DelitoActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new detalles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apellidos;
    private javax.swing.JTextField Cedula;
    private javax.swing.JComboBox CondicionM;
    private javax.swing.JComboBox CondicionP;
    private javax.swing.JComboBox Delito;
    private javax.swing.JTextField Edad;
    private javax.swing.JComboBox EstadoCivil;
    private com.toedter.calendar.JDateChooser FechaN;
    private javax.swing.JTextField LugarN;
    private javax.swing.JTextField LugarResid;
    private javax.swing.JComboBox Nacionalidad;
    private javax.swing.JTextField NombreMadre;
    private javax.swing.JTextField NombrePadre;
    private javax.swing.JTextField Nombres;
    private javax.swing.JTextArea Observacion;
    private javax.swing.JTextField Ocupacion;
    private javax.swing.JButton buscar;
    private javax.swing.JPanel busqueda;
    private javax.swing.JComboBox c_buscador;
    private javax.swing.JTextField cedula;
    private javax.swing.JComboBox fechas;
    private javax.swing.JPanel ficha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private diu.swe.habib.JPanelSlider.JPanelSlider jPanelSlider1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel txtcamara;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
conectar cc = new conectar();
    Connection cn = cc.conexion();

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
