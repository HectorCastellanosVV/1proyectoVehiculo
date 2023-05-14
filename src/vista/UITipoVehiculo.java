/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import control.TipovehiculoJpaController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import modelo.Tipovehiculo;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;
import modelo.TModeloTipoV;

/**
 *
 * @author Elias
 */
public class UITipoVehiculo extends javax.swing.JDialog {

    private Tipovehiculo tipov;//clase entidad
    private TipovehiculoJpaController ctv;//manipular los datos
    private EntityManagerFactory emf;//objeto para acceder a la base de datos
    private List<Tipovehiculo> tipos;
    private TModeloTipoV modelot;

    /**
     * Creates new form UIVechiculo_a
     */
    public UITipoVehiculo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        emf = Persistence.createEntityManagerFactory("1ProyectoVehiculoPU");
        ctv = new TipovehiculoJpaController(emf);
        tipos = ctv.findTipovehiculoEntities();
        modelot = new TModeloTipoV(tipos);
        modelot.fireTableDataChanged();
        Tabla1.setModel(modelot);
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_tipo = new javax.swing.JTextField();
        txt_caracteristica = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelRound1 = new Herramientas.PanelRound();
        boton = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(64, 64, 64));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(204, 255, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(248, 248, 248));
        jLabel3.setText("Agregar Tipo de Vehiculos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        txt_tipo.setBackground(new java.awt.Color(248, 248, 248));
        txt_tipo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_tipo.setForeground(new java.awt.Color(1, 1, 1));
        txt_tipo.setText("Tipo");
        txt_tipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_tipoMouseClicked(evt);
            }
        });
        txt_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tipoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 280, 30));

        txt_caracteristica.setBackground(new java.awt.Color(248, 248, 248));
        txt_caracteristica.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_caracteristica.setForeground(new java.awt.Color(1, 1, 1));
        txt_caracteristica.setText("Caracteristicas");
        txt_caracteristica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_caracteristicaMouseClicked(evt);
            }
        });
        txt_caracteristica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_caracteristicaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_caracteristica, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 280, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(248, 248, 248));
        jLabel6.setText("Tipo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(248, 248, 248));
        jLabel8.setText("Caracteristica");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, 20));

        panelRound1.setBackground(new java.awt.Color(8, 8, 8));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);
        panelRound1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound1MouseClicked(evt);
            }
        });

        boton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        boton.setForeground(new java.awt.Color(248, 248, 248));
        boton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        boton.setText("Agregar");
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boton, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(boton, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 110, 40));

        jScrollPane1.setBackground(new java.awt.Color(1, 1, 1));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        Tabla1.setBackground(new java.awt.Color(32, 32, 32));
        Tabla1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        Tabla1.setForeground(new java.awt.Color(255, 255, 255));
        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Usuario", "Hora de ingreso", "Hora de salida", "Número de telefono", "Title 5"
            }
        ));
        Tabla1.setAlignmentY(3.0F);
        Tabla1.setRowHeight(27);
        jScrollPane1.setViewportView(Tabla1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 510, 160));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tipoMouseClicked
        txt_tipo.setText("");
    }//GEN-LAST:event_txt_tipoMouseClicked

    private void txt_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tipoActionPerformed

    private void txt_caracteristicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_caracteristicaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_caracteristicaMouseClicked

    private void txt_caracteristicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_caracteristicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_caracteristicaActionPerformed

    private void panelRound1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRound1MouseClicked

    private void botonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMouseClicked
        tipov = new Tipovehiculo();
        if (!txt_tipo.getText().trim().equalsIgnoreCase("")) {
            tipov.setNombre(txt_tipo.getText());
            tipov.setCaracteristicas(txt_caracteristica.getText());
            ctv.create(tipov);//insertar objeto de CLASE VEHICULO
            tipos.add(tipov);
            modelot.fireTableDataChanged();

        }
    }//GEN-LAST:event_botonMouseClicked

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
            java.util.logging.Logger.getLogger(UITipoVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UITipoVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UITipoVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UITipoVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UITipoVehiculo dialog = new UITipoVehiculo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla1;
    private javax.swing.JLabel boton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Herramientas.PanelRound panelRound1;
    private javax.swing.JTextField txt_caracteristica;
    private javax.swing.JTextField txt_tipo;
    // End of variables declaration//GEN-END:variables
}
