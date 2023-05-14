/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Hector
 */
public class TModeloTipoV extends AbstractTableModel {

    private List<Tipovehiculo> datos;
    private int nc;
    final private String columnas[]={"ID TIPO", "Nombre", "Caracteristicas"};

    public TModeloTipoV(List<Tipovehiculo> d) {
        datos = d;
    }
   // getColumnNames(int c);

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch(c){
          case 0 :return datos.get(r).getIdtipo();
          case 1 :return datos.get(r).getNombre();
          case 2 :return datos.get(r).getCaracteristicas();
         default : return null;
        }
    }
}
