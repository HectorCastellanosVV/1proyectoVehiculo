/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import control.InfraccionJpaController;
import control.InfraccionesJpaController;
import control.TipovehiculoJpaController;
import control.VehiculoJpaController;
import control.exceptions.NonexistentEntityException;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import modelo.Infraccion;
import modelo.Infracciones;
import modelo.TModeloInfraccion;
import modelo.TModeloPagoInfracciones;
import modelo.TModeloVehiculo;
import modelo.Tipovehiculo;
import modelo.Vehiculo;

public class UIPagoInfraccion extends javax.swing.JFrame {

    private InfraccionesJpaController cInfracciones;
    private VehiculoJpaController cvehiculo;
    private Vehiculo vehiculo;
    private Infracciones infracciones;
    private List<Vehiculo> Lista_vehiculos;
    private List<Infracciones> Lista_Infracciones;
    private TModeloPagoInfracciones modeloPago;
    private ArrayList idVehiculo = new ArrayList();

    public UIPagoInfraccion() {
        initComponents();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("1ProyectoVehiculoPU");
        cInfracciones = new InfraccionesJpaController(emf);
        cvehiculo = new VehiculoJpaController(emf);
        Lista_Infracciones = cInfracciones.findInfraccionesEntities();
        Lista_vehiculos = cvehiculo.findVehiculoEntities();
        modeloPago = new TModeloPagoInfracciones(Lista_Infracciones);
        modeloPago.fireTableDataChanged();
        tablaPagos.setModel(modeloPago);
        cargarVehiculo();

    }

    private void cargarVehiculo() {
        Lista_vehiculos = cvehiculo.findVehiculoEntities();
        combo_vehiculo.removeAllItems();
        combo_vehiculo.addItem(".");
        idVehiculo.add("0");
        for (Vehiculo vh : Lista_vehiculos) {
            combo_vehiculo.addItem(vh.getPlaca());
            idVehiculo.add(vh.getIdve());
        }
    }

    private void mostrarTabla() {
        modeloPago = new TModeloPagoInfracciones(Lista_Infracciones);
        modeloPago.setIdVehiculo((int) idVehiculo.get(combo_vehiculo.getSelectedIndex()));
        modeloPago.fireTableDataChanged();
        tablaPagos.setModel(modeloPago);
    }

    private void mostrarTotal() {
        double suma = 0;
        for (int i = 0; i < tablaPagos.getRowCount(); i++) {
            double monto = Double.parseDouble((String) tablaPagos.getValueAt(i, 2));
            suma += monto;
        }
        txt_montoTotal.setText("" + suma);
    }

    private void agregarPago() {
        try {
            
            int datos = tablaPagos.getSelectedRowCount();
            double total = 0;
            if (datos == 0) {
                for (int i = 0; i < tablaPagos.getRowCount(); i++) {
                    int folioInf = (int) tablaPagos.getValueAt(i, 0);
                    editarFechaPago(folioInf, fecha());
                }
            } else {
                int[] datoss = tablaPagos.getSelectedRows();
                for (int i = 0; i < datos; i++) {
                    int folioInf = (int) tablaPagos.getValueAt(datoss[i], 0);
                    editarFechaPago(folioInf, fecha());
                }
            }
        } catch (Exception e) {
            System.out.println("Error al agregar pago: " + e.getMessage());
        }
    }

    public Date fecha() {
        Date fecha = Choose_date.getDate();
        long d = fecha.getTime();
        java.sql.Date fec = new java.sql.Date(d);
        return fec;
    }

    private void editarFechaPago(int folioInf, Date fechaPago) {
        try {
            Infracciones infraccion = cInfracciones.findInfracciones(folioInf);
            if (infraccion != null) {
                infraccion.setFechapago(fechaPago);
                cInfracciones.edit(infraccion);
            }
        } catch (NonexistentEntityException ex) {
            System.out.println("Infraccion no encontrada: " + folioInf);
        } catch (Exception ex) {
            System.out.println("Error al editar infraccion: " + ex.getMessage());
        }
    }

    public static Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        combo_vehiculo = new Herramientas.Combobox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPagos = new javax.swing.JTable();
        txt_montoTotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Choose_date = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 40, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(248, 248, 248));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("PAGO DE INFRACCIONES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 300, -1));

        combo_vehiculo.setBackground(new java.awt.Color(34, 34, 34));
        combo_vehiculo.setForeground(new java.awt.Color(248, 248, 248));
        combo_vehiculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", " " }));
        combo_vehiculo.setSelectedIndex(-1);
        combo_vehiculo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        combo_vehiculo.setLabeText("Vehiculo");
        combo_vehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_vehiculoMouseClicked(evt);
            }
        });
        combo_vehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_vehiculoActionPerformed(evt);
            }
        });
        jPanel1.add(combo_vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 190, 50));

        tablaPagos.setBackground(new java.awt.Color(64, 64, 64));
        tablaPagos.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        tablaPagos.setForeground(new java.awt.Color(248, 248, 248));
        tablaPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPagosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPagos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 400, 250));

        txt_montoTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_montoTotal.setForeground(new java.awt.Color(248, 248, 248));
        txt_montoTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_montoTotal.setText("000.00");
        txt_montoTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_montoTotalMouseClicked(evt);
            }
        });
        jPanel1.add(txt_montoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 120, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(248, 248, 248));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Monto total:");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 120, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(248, 248, 248));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Fecha:");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 60, 40));

        jButton1.setText("Pagar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));
        jPanel1.add(Choose_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_montoTotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_montoTotalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_montoTotalMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void combo_vehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_vehiculoActionPerformed
        try {
            mostrarTabla();
            mostrarTotal();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_combo_vehiculoActionPerformed

    private void combo_vehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_vehiculoMouseClicked

    }//GEN-LAST:event_combo_vehiculoMouseClicked

    private void tablaPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPagosMouseClicked
        int datos = tablaPagos.getSelectedRowCount();
        int[] datoss = tablaPagos.getSelectedRows();
        double total = 0;
        for (int i = 0; i < datos; i++) {
            double monto = Double.parseDouble((String) tablaPagos.getValueAt(datoss[i], 2));
            total += monto;
        }
        txt_montoTotal.setText("" + total);
    }//GEN-LAST:event_tablaPagosMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            agregarPago();
            int[] rows = tablaPagos.getSelectedRows();
            for (int i = 0; i < rows.length; i++) {
                modeloPago.remove(rows[i] - i);
            }
            modeloPago.fireTableDataChanged();
            repaint();
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(UIPagoInfraccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIPagoInfraccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIPagoInfraccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIPagoInfraccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIPagoInfraccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Choose_date;
    private Herramientas.Combobox combo_vehiculo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPagos;
    private javax.swing.JLabel txt_montoTotal;
    // End of variables declaration//GEN-END:variables

    void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
