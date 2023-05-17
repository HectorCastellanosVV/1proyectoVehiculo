/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TModeloPagoInfracciones extends AbstractTableModel {

    private List<Infracciones> datos;
    private int idVehiculo = 0;
    private final String columnas[] = {"No. Infraccion", "Descripción", "Monto"};

    public TModeloPagoInfracciones(List<Infracciones> d) {
        datos = d;
    }

    public void setIdVehiculo(int idV) {
        this.idVehiculo = idV;

        // Filtrar infracciones por vehículo
        List<Infracciones> infraccionesFiltradas = new ArrayList<>();
        for (Infracciones i : datos) {
            if (i.getVehiculo().getIdve() == idV && i.getFechapago() == null) {
                infraccionesFiltradas.add(i);
            }
        }
        datos = infraccionesFiltradas;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    public Infracciones remove(int index) {
        return datos.remove(index);
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    public Object getValueAt(int r, int c) {
        Infracciones infraccion = datos.get(r);

        switch (c) {
            case 0:

                return infraccion.getIdfolioinf();

            case 1:

                return infraccion.getInfraccion().getDescripcion();

            case 2:

                return infraccion.getInfraccion().getMulta();

            default:
                return null;
        }

    }
}
