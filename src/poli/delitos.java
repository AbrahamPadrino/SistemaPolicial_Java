/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poli;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Equipo
 */
public class delitos extends javax.swing.JFrame {

    DefaultTableModel model;
    Statement sent;
    CallableStatement cst;
    Connection conect;
    int contador = 0;

    public delitos() {
        initComponents();

        setLocationRelativeTo(null);
        final Color alphaZero = new Color(0, true);
        jScrollPane1.setBorder(null);
        tabla.setBorder(null);
        tabla.setBackground(alphaZero);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.getViewport().setBackground(alphaZero);
        n_delito.setBackground(new Color(0, 0, 0, 40));
        buscador.setBackground(new Color(0, 0, 0, 40));
        cargar("");
        modificar.setVisible(false);
        cancelar.setEnabled(false);
        eliminar.setEnabled(false);
        editar.setEnabled(false);
    }

    void cargar(String valor) {
        try {
            String[] titulos = {"ID", "DELITOS"};
            String[] registros = new String[2];
            String sql = "SELECT * FROM delitos where delito LIKE '%" + valor + "%' ";
            model = new DefaultTableModel(null, titulos);
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("delito");

                model.addRow(registros);
            }
            tabla.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        n_delito = new javax.swing.JTextField();
        eliminar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        editar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        buscador = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        n_delito.setForeground(new java.awt.Color(255, 255, 255));
        n_delito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(n_delito, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 180, -1));

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/ELIMINAR.png"))); // NOI18N
        eliminar.setBorderPainted(false);
        eliminar.setContentAreaFilled(false);
        eliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/ELIMINAR1.png"))); // NOI18N
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 120, -1));

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/CANCELAR.png"))); // NOI18N
        cancelar.setBorderPainted(false);
        cancelar.setContentAreaFilled(false);
        cancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/CANCELAR1.png"))); // NOI18N
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 120, -1));

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/GUARDAR.png"))); // NOI18N
        guardar.setBorderPainted(false);
        guardar.setContentAreaFilled(false);
        guardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/GUARDAR1.png"))); // NOI18N
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        getContentPane().add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 120, -1));

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/N_SALIR.png"))); // NOI18N
        salir.setBorderPainted(false);
        salir.setContentAreaFilled(false);
        salir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/N_SALIR1.png"))); // NOI18N
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 120, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 370, 170));

        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/EDITAR.png"))); // NOI18N
        editar.setBorderPainted(false);
        editar.setContentAreaFilled(false);
        editar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/EDITAR1.png"))); // NOI18N
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        getContentPane().add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 120, -1));

        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/MODIFICAR.png"))); // NOI18N
        modificar.setBorderPainted(false);
        modificar.setContentAreaFilled(false);
        modificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/MODIFICAR1.png"))); // NOI18N
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        getContentPane().add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 120, -1));

        buscador.setForeground(new java.awt.Color(255, 255, 255));
        buscador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscadorKeyReleased(evt);
            }
        });
        getContentPane().add(buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 43, 180, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "BUSCADOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 200, 45));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("AGREGAR DELITOS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 510, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f_todo.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 260));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        cargar("");
        modificar.setVisible(false);
        guardar.setVisible(true);
        guardar.setEnabled(true);

        cancelar.setEnabled(false);
        editar.setEnabled(false);
        eliminar.setEnabled(false);

        n_delito.setText("");
        buscador.setText("");
    }//GEN-LAST:event_cancelarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        String regist;
        String sql = ("");
        String exp = n_delito.getText();

        boolean existe = false; //variable bandera para comprobar si NO existe el expediente en la BD

        try {
            sql = "SELECT * FROM delitos WHERE delito = '" + exp + "'";

            ResultSet rs = sent.executeQuery(sql);

            while (rs.next()) {
                existe = true;
                if (existe == true) {
                    regist = rs.getString("delito");
                    if (exp.equals(regist)) {
                        JOptionPane.showMessageDialog(null, "" + regist + "  YA EXISTE", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        n_delito.setText("");
                        buscador.setText("");
                    }
                }
            } //fin while res.next
            if (existe == false) {
                String c1;

                c1 = n_delito.getText();

                sql = "INSERT INTO delitos(delito) VALUES(?)";
                try {
                    PreparedStatement pst = cn.prepareCall(sql);

                    pst.setString(1, c1);

                    int n = pst.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "Registro Guardado");
                    }
                    cargar("");
                    n_delito.setText("");
                    buscador.setText("");
                    modificar.setVisible(false);
                    editar.setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(delitos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_guardarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed

        try {

            int fila = tabla.getSelectedRow();
            String sql = "delete from delitos where ID = " + tabla.getValueAt(fila, 0);
            sent = cn.createStatement();
            int n = sent.executeUpdate(sql);
            if (n > 0) {

            }

            cargar("");
            n_delito.setText("");
            buscador.setText("");
            modificar.setVisible(false);
            guardar.setVisible(true);
            editar.setVisible(true);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }

    }//GEN-LAST:event_eliminarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        n_delito.requestFocus();
        modificar.setVisible(true);
        cancelar.setEnabled(true);
        editar.setEnabled(false);
        eliminar.setEnabled(false);
        guardar.setVisible(false);
        editar.setEnabled(false);
        buscador.setText("");
    }//GEN-LAST:event_editarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed

        String regist;
        String sql = ("");
        String exp = n_delito.getText();

        boolean existe = false; //variable bandera para comprobar si NO existe el expediente en la BD

        try {
            sql = "SELECT * FROM delitos WHERE delito = '" + exp + "'";

            ResultSet rs = sent.executeQuery(sql);

            while (rs.next()) {
                existe = true;
                if (existe == true) {
                    regist = rs.getString("delito");
                    if (exp.equals(regist)) {
                        JOptionPane.showMessageDialog(null, "" + regist + "  YA EXISTE", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        n_delito.setText("");
                        buscador.setText("");
                    }
                }
            } //fin while res.next
            if (existe == false) {
                String c1;

                c1 = n_delito.getText();

                try {
                    sql = "Update delitos set delito=?"
                            + "where id=?";
                    int fila = tabla.getSelectedRow();
                    String dao = (String) tabla.getValueAt(fila, 0);
                    PreparedStatement pst = cn.prepareStatement(sql);
                    pst.setString(1, c1);

                    pst.setString(2, dao);
                    int n = pst.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "Registro Modificado");

                    }
                } catch (HeadlessException | SQLException e) {

                }
            }
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_modificarActionPerformed

    private void buscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorKeyReleased
        cargar(buscador.getText());
    }//GEN-LAST:event_buscadorKeyReleased

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if (evt.getButton() == 1) {
            int pst = tabla.getSelectedRow();
            try {
                String sql = "SELECT * FROM delitos where id= " + tabla.getValueAt(pst, 0).toString();
                sent = cn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                n_delito.setText(rs.getString("delito"));
                buscador.setText("");
                guardar.setEnabled(false);
                modificar.setVisible(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        eliminar.setEnabled(true);
        editar.setEnabled(true);
    }//GEN-LAST:event_tablaMouseClicked

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed

        dispose();
        cargar("");
    }//GEN-LAST:event_salirActionPerformed

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
            java.util.logging.Logger.getLogger(delitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(delitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(delitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(delitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new delitos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscador;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField n_delito;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
conectar cc = new conectar();
    Connection cn = cc.conexion();
}
