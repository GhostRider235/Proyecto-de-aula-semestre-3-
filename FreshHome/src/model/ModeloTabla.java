
package model;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla {
    private DefaultTableModel TablaEmpleados;
    private DefaultTableModel Notificaciones;

    public DefaultTableModel getTablaEmpleados() {
        return TablaEmpleados;
    }

    public void setTablaEmpleados(DefaultTableModel TablaEmpleados) {
        this.TablaEmpleados = TablaEmpleados;
    }

    public DefaultTableModel getNotificaciones() {
        return Notificaciones;
    }

    public void setNotificaciones(DefaultTableModel Notificaciones) {
        this.Notificaciones = Notificaciones;
    }
    
}
