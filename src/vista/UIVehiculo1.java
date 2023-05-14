/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import control.TipovehiculoJpaController;
import control.VehiculoJpaController;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.TModeloVehiculo;
import modelo.Tipovehiculo;
import modelo.Vehiculo;

/**
 *
 * @author Elias
 */
public class UIVehiculo1 extends javax.swing.JDialog {

        private VehiculoJpaController cvehiculo;
        private TipovehiculoJpaController ctipov;
        private Vehiculo vehiculo;
        private Tipovehiculo tipov;
        private List<Tipovehiculo> tiposv;
        private List<Vehiculo> tipos;
        private TModeloVehiculo modelot;

        /**
         * Creates new form InVehiculo
         */
        public UIVehiculo1(java.awt.Frame parent, boolean modal) {
                super(parent, modal);
                initComponents();
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("1ProyectoVehiculoPU");
                ctipov = new TipovehiculoJpaController(emf);
                cvehiculo = new VehiculoJpaController(emf);
                tiposv = ctipov.findTipovehiculoEntities();
                tipos = cvehiculo.findVehiculoEntities();
                modelot = new TModeloVehiculo(tipos);
                modelot.fireTableDataChanged();
                TablaVehiculos.setModel(modelot);
                cargartipov();
                setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        }

        private void cargartipov() {
                tiposv = ctipov.findTipovehiculoEntities();
                combo_tipo.removeAllItems();
                for (Tipovehiculo tv : tiposv) {
                        combo_tipo.addItem(tv.getNombre());
                }
        }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_Placa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Spin_año = new javax.swing.JSpinner();
        Combo_color = new javax.swing.JComboBox<>();
        Combo_marca = new javax.swing.JComboBox<>();
        combo_tipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaVehiculos = new javax.swing.JTable();
        panelRound1 = new Herramientas.PanelRound();
        boton = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(204, 255, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(248, 248, 248));
        jLabel3.setText("Vehiculos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(248, 248, 248));
        jLabel6.setText("Tipo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        txt_Placa.setBackground(new java.awt.Color(248, 248, 248));
        txt_Placa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Placa.setForeground(new java.awt.Color(1, 1, 1));
        txt_Placa.setText("Placa");
        txt_Placa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_PlacaMouseClicked(evt);
            }
        });
        txt_Placa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PlacaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 280, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(248, 248, 248));
        jLabel8.setText("Placa");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(248, 248, 248));
        jLabel9.setText("Año");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(248, 248, 248));
        jLabel10.setText("Color");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(248, 248, 248));
        jLabel11.setText("Marca");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        Spin_año.setModel(new javax.swing.SpinnerNumberModel(2000, 2000, 2023, 1));
        jPanel1.add(Spin_año, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 100, -1));

        Combo_color.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Azul", "Blanco", "Gris", "Negro", "Rojo", "Plata", "Verde" }));
        jPanel1.add(Combo_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 100, -1));

        Combo_marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FIAT", "NISAN", "KIA", "CHEBROLET", "MG", "SUZUKY", "VW", " " }));
        jPanel1.add(Combo_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        jPanel1.add(combo_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 100, -1));

        TablaVehiculos.setBackground(new java.awt.Color(153, 204, 255));
        TablaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaVehiculos.setSelectionBackground(new java.awt.Color(51, 0, 51));
        jScrollPane1.setViewportView(TablaVehiculos);

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

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 100, 40));

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
    }// </editor-fold>//GEN-END:initComponents

    private void txt_PlacaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_PlacaMouseClicked
        txt_Placa.setText("");
    }//GEN-LAST:event_txt_PlacaMouseClicked

    private void txt_PlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PlacaActionPerformed

    private void botonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMouseClicked
        vehiculo = new Vehiculo();
                if (!txt_Placa.getText().trim().equalsIgnoreCase("")) {
                        vehiculo.setPlaca(txt_Placa.getText());
                        vehiculo.setColor((String) Combo_color.getSelectedItem());
                        vehiculo.setAnio((Integer) Spin_año.getValue());
                        vehiculo.setMarca((String) Combo_marca.getSelectedItem());
                        vehiculo.setTipo(tiposv.get(combo_tipo.getSelectedIndex()));
                        cvehiculo.create(vehiculo);
                        modelot.fireTableDataChanged();
                        tipos.add(vehiculo);
                }
    }//GEN-LAST:event_botonMouseClicked

    private void panelRound1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRound1MouseClicked

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
                        java.util.logging.Logger.getLogger(UIVehiculo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(UIVehiculo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(UIVehiculo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(UIVehiculo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                                UIVehiculo1 dialog = new UIVehiculo1(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> Combo_color;
    private javax.swing.JComboBox<String> Combo_marca;
    private javax.swing.JSpinner Spin_año;
    private javax.swing.JTable TablaVehiculos;
    private javax.swing.JLabel boton;
    private javax.swing.JComboBox<String> combo_tipo;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Herramientas.PanelRound panelRound1;
    private javax.swing.JTextField txt_Placa;
    // End of variables declaration//GEN-END:variables
}
