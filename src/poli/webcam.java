package poli;

import java.io.IOException;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.NoPlayerException;
import javax.media.CannotRealizeException;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.Manager;
import javax.media.control.FrameGrabbingControl;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.media.Buffer;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;
import JImage.JIResizeImage;
import java.awt.FileDialog;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import javax.imageio.ImageIO;
import poli.conectar;


/**
 *
 * @author Familia
 */
public class webcam extends javax.swing.JFrame implements Runnable{

    Player player;
    BufferedImage bi;
    String nfile;
    FileInputStream fis;
    int longitudBytes;

    /**
     * Creates new form webcam
     */
    public webcam() {
        initComponents();
        setLocationRelativeTo(null);
        try {
            initCamera();
        } catch (IOException ex) {
            Logger.getLogger(webcam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoPlayerException ex) {
            Logger.getLogger(webcam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(webcam.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void initCamera() throws IOException, NoPlayerException, CannotRealizeException {
        {
            MediaLocator ml = new MediaLocator("vfw://0");
            player = Manager.createRealizedPlayer(ml);

            this.captura1.add(player.getVisualComponent());
            player.start();

        }
    }

    private void setImageButton(JToggleButton tbutton, Image image) {
        tbutton.setIcon(new ImageIcon(image));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanelSlider1 = new diu.swe.habib.JPanelSlider.JPanelSlider();
        cap = new javax.swing.JPanel();
        captura1 = new javax.swing.JToggleButton();
        capturar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        guar = new javax.swing.JPanel();
        guardar11 = new javax.swing.JToggleButton();
        guardar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSlider1.setBorder(null);
        jPanelSlider1.setOpaque(false);

        cap.setOpaque(false);
        cap.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        cap.add(captura1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 180));

        capturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BOTONES/CAPTURAR.png"))); // NOI18N
        capturar.setBorderPainted(false);
        capturar.setContentAreaFilled(false);
        capturar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BOTONES/CAPTURAR1.png"))); // NOI18N
        capturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capturarActionPerformed(evt);
            }
        });
        cap.add(capturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 130, 20));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/minimizar.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/minimizar1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        cap.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 110, 20));

        jPanelSlider1.add(cap, "card2");

        guar.setOpaque(false);
        guar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        guar.add(guardar11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 180));

        guardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/GUARDAR.png"))); // NOI18N
        guardar1.setBorderPainted(false);
        guardar1.setContentAreaFilled(false);
        guardar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/b_texto/GUARDAR1.png"))); // NOI18N
        guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar1ActionPerformed(evt);
            }
        });
        guar.add(guardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 210, 170, 20));

        jPanelSlider1.add(guar, "card3");

        getContentPane().add(jPanelSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 260, 250));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "CAMARA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 300, 300));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void capturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capturarActionPerformed
        FrameGrabbingControl fgc = (FrameGrabbingControl) player.getControl("javax.media.control.FrameGrabbingControl");
        Buffer buffer = fgc.grabFrame();
        BufferToImage bti = new BufferToImage((VideoFormat) buffer.getFormat());
        Image image = bti.createImage(buffer);
        JIResizeImage resize = new JIResizeImage();
        bi = (BufferedImage) image;
        Image imageresize = resize.rescale(bi, 150, 150);
        this.setImageButton(this.guardar11, imageresize);

    
        jPanelSlider1.setVisible(true);
        jPanelSlider1.nextPanel(10, guar, jPanelSlider1.right);


    }//GEN-LAST:event_capturarActionPerformed

    private void guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar1ActionPerformed
        FileDialog fd = new FileDialog(webcam.this, "Save Image", FileDialog.SAVE);
        fd.show();
        if (fd.getFile() != null) {
            nfile = fd.getDirectory() + fd.getFile() + ".jpg";
            try {
                File make = new File(nfile);
                try {
                    ImageIO.write(bi, "jpg", make);
                } catch (IOException ex) {
                    Logger.getLogger(webcam.class.getName()).log(Level.SEVERE, null, ex);

                }
                dispose();
            } catch (Exception ex) {
                Logger.getLogger(webcam.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_guardar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    this.setExtendedState(ICONIFIED);
    this.setExtendedState(1);// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        webcam wc = new webcam();
        wc.setVisible(true);

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new webcam().setVisible(false);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cap;
    private javax.swing.JToggleButton captura1;
    private javax.swing.JButton capturar;
    private javax.swing.JPanel guar;
    private javax.swing.JButton guardar1;
    private javax.swing.JToggleButton guardar11;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private diu.swe.habib.JPanelSlider.JPanelSlider jPanelSlider1;
    // End of variables declaration//GEN-END:variables
 conectar cc = new conectar();
    Connection cn = cc.conexion();

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
