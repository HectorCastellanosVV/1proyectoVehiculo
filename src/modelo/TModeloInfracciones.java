/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TModeloInfracciones extends AbstractTableModel {

    private List<Infracciones> datos;
    private int nc;
    final private String columnas[] = {"ID Folio Infraccion", "Vehiculo", "IDInfraccion", "Fecha", "Fecha Pago"};

    public TModeloInfracciones(List<Infracciones> d) {
        datos = d;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return datos.get(r).getIdfolioinf();
            case 1:
                return datos.get(r).getVehiculo().getIdve();
            case 2:
                return datos.get(r).getInfraccion().getIdinfraccion();
            case 3:
                return datos.get(r).getFecha();
            case 4:
                return datos.get(r).getFechapago();
            default:
                return null;
        }
    }

}
