/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import control.InfraccionJpaController;
import control.TipovehiculoJpaController;
import control.VehiculoJpaController;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Infraccion;
import modelo.TModeloInfraccion;
import modelo.TModeloVehiculo;
import modelo.Tipovehiculo;
import modelo.Vehiculo;

/**
 *
 * @author Elias
 */
public class UIAgregarInfraccion extends javax.swing.JDialog {
        private Infraccion infraccion;
        private InfraccionJpaController cinfraccion;
        private List<Infraccion> listInfracciones;
        private TModeloInfraccion modelot;

        /**
         * Creates new form InVehiculo
         */
        public UIAgregarInfraccion(java.awt.Frame parent, boolean modal) {
                super(parent, modal);
                initComponents();
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("1ProyectoVehiculoPU");
                cinfraccion = new InfraccionJpaController(emf);
                listInfracciones = cinfraccion.findInfraccionEntities();
                modelot = new TModeloInfraccion(listInfracciones);
                modelot.fireTableDataChanged();
                TablaInfraccion.setModel(modelot);
                setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        }


        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_Multa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaInfraccion = new javax.swing.JTable();
        panelRound1 = new Herramientas.PanelRound();
        boton = new javax.swing.JLabel();
        txt_Descripcion = new javax.swing.JTextField();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(204, 255, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(248, 248, 248));
        jLabel3.setText("Agregar Infracción");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(248, 248, 248));
        jLabel6.setText("Multa:        $");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        txt_Multa.setBackground(new java.awt.Color(248, 248, 248));
        txt_Multa.setForeground(new java.awt.Color(1, 1, 1));
        txt_Multa.setText("Placa");
        txt_Multa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_MultaMouseClicked(evt);
            }
        });
        txt_Multa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MultaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Multa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 280, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(248, 248, 248));
        jLabel8.setText("Descripción");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        TablaInfraccion.setBackground(new java.awt.Color(153, 204, 255));
        TablaInfraccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaInfraccion.setSelectionBackground(new java.awt.Color(51, 0, 51));
        jScrollPane1.setViewportView(TablaInfraccion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 80, 400, 190));

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
                .addComponent(boton, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(boton, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 100, 40));

        txt_Descripcion.setBackground(new java.awt.Color(248, 248, 248));
        txt_Descripcion.setForeground(new java.awt.Color(1, 1, 1));
        txt_Descripcion.setText("Placa");
        txt_Descripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_DescripcionMouseClicked(evt);
            }
        });
        txt_Descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DescripcionActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 280, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jLabel7))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_MultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MultaMouseClicked
        txt_Multa.setText("");
    }//GEN-LAST:event_txt_MultaMouseClicked

    private void txt_MultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MultaActionPerformed

    private void botonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMouseClicked
        infraccion = new Infraccion();
                if (!txt_Multa.getText().trim().equalsIgnoreCase("") && !txt_Descripcion.getText().trim().equalsIgnoreCase("")) {
                        String descripcion=txt_Descripcion.getText();
                        String multa=txt_Multa.getText();
                        infraccion.setDescripcion(descripcion);
                        infraccion.setMulta(multa);
                        cinfraccion.create(infraccion);
                        modelot.fireTableDataChanged();
                        listInfracciones.add(infraccion);
                }
    }//GEN-LAST:event_botonMouseClicked

    private void panelRound1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRound1MouseClicked

    private void txt_DescripcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_DescripcionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DescripcionMouseClicked

    private void txt_DescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DescripcionActionPerformed

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
                        java.util.logging.Logger.getLogger(UIAgregarInfraccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(UIAgregarInfraccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(UIAgregarInfraccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(UIAgregarInfraccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
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
                                UIAgregarInfraccion dialog = new UIAgregarInfraccion(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable TablaInfraccion;
    private javax.swing.JLabel boton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Herramientas.PanelRound panelRound1;
    private javax.swing.JTextField txt_Descripcion;
    private javax.swing.JTextField txt_Multa;
    // End of variables declaration//GEN-END:variables
}
