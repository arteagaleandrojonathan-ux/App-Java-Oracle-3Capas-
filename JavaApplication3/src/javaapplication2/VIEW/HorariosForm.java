
package javaapplication2.VIEW;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.sql.Time;
import java.util.List;

import javaapplication2.MODEL.Empleado;
import javaapplication2.MODEL.Horarios;
import javaapplication2.SERVICE.EmpleadoService;
import javaapplication2.SERVICE.HorarioService;

import javax.swing.table.DefaultTableModel;

import javax.swing.*;

public class HorariosForm extends javax.swing.JFrame {

    private final HorarioService hs = new HorarioService();
    private final EmpleadoService empService = new EmpleadoService();
    private List<Empleado> listaEmpleados;

   private void aplicarEstilos() {
  
    getContentPane().setBackground(new java.awt.Color(245, 248, 250));
    
    // ===== BOTONES =====
    // Insertar (verde suave)
    insertar.setBackground(new java.awt.Color(144, 238, 144));
    insertar.setForeground(java.awt.Color.BLACK);
    insertar.setFocusPainted(false);
    insertar.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 15, 8, 15));
    //listar 
    listar.setBackground(new java.awt.Color(200, 220, 230));
listar.setForeground(java.awt.Color.BLACK);
listar.setFocusPainted(false);
listar.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 15, 8, 15));
listar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    // Actualizar (azul suave)
    actualizar.setBackground(new java.awt.Color(173, 216, 230));
    actualizar.setForeground(java.awt.Color.BLACK);
    actualizar.setFocusPainted(false);

    // Eliminar (rojo suave)
    eliminar.setBackground(new java.awt.Color(255, 182, 193));
    eliminar.setForeground(java.awt.Color.BLACK);
    eliminar.setFocusPainted(false);

    // ===== COMBOBOX =====
    jComboBox2.setBackground(java.awt.Color.WHITE);
    jComboBox3.setBackground(java.awt.Color.WHITE);
    ComboBoxEstado.setBackground(java.awt.Color.WHITE);

    // ===== SPINNER =====
    jSpinner1.setBackground(java.awt.Color.WHITE);
    jSpinner2.setBackground(java.awt.Color.WHITE);

    // ===== TABLA =====
    jTable1.setRowHeight(25);
    jTable1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));

    // Encabezado tabla
    jTable1.getTableHeader().setBackground(new java.awt.Color(100, 149, 237));
    jTable1.getTableHeader().setForeground(java.awt.Color.WHITE);
    jTable1.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));

    // Filas alternadas (efecto moderno)
    jTable1.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
        @Override
        public java.awt.Component getTableCellRendererComponent(
                javax.swing.JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {

            java.awt.Component c = super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);

            if (!isSelected) {
                if (row % 2 == 0) {
                    c.setBackground(new java.awt.Color(245, 245, 245));
                } else {
                    c.setBackground(java.awt.Color.WHITE);
                }
            }

            return c;
        }
    });

}
  
    public HorariosForm() {
        initComponents();
        // NetBeans a veces deja el combo con "Item 1, Item 2..."; esto lo fuerza siempre al ejecutar
        configurarComboBoxEstado();
        configurarTablaConIdEmpleadoOculto();
        aplicarEstilos();

        getContentPane().setBackground(new java.awt.Color(232, 245, 233));
        jSpinner1.setModel(new SpinnerDateModel());
        jSpinner1.setEditor(new JSpinner.DateEditor(jSpinner1, "HH:mm"));

        jSpinner2.setModel(new SpinnerDateModel());
        jSpinner2.setEditor(new JSpinner.DateEditor(jSpinner2, "HH:mm"));

        cargarEmpleadosCombo();
        cargarHorarios();
    }

    /** Valores del CHECK en Oracle; se llama tras initComponents para no depender del código generado. */
    private void configurarComboBoxEstado() {
        ComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO", "ANULADO" }));
        ComboBoxEstado.setSelectedItem("ACTIVO");
    }

    /**
     * Columnas 0–6 visibles (incluye ESTADO del horario); columna 7 = idEmpleado (oculta).
     */
    private void configurarTablaConIdEmpleadoOculto() {
        DefaultTableModel modelo = new DefaultTableModel(
                new String[]{
                    "ID HORARIO", "NOMBRES", "APELLIDOS", "DIA SEMANA",
                    "HORA DE ENTRADA", "HORA DE SALIDA", "ESTADO", "ID_EMP"
                }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable1.setModel(modelo);
        jTable1.getColumnModel().removeColumn(jTable1.getColumnModel().getColumn(7));
    }

    private void cargarEmpleadosCombo() {
        listaEmpleados = empService.listar();
        jComboBox2.removeAllItems();
        for (Empleado e : listaEmpleados) {
            jComboBox2.addItem(e.getNombres() + " " + e.getApePaterno() + " " + e.getApeMaterno());
        }
    }

    private void llenarCamposEmpleado(Empleado e) {
        jTextField1.setText(e.getTipoDOI());
        NumDOI.setText(e.getNumDOI());
        Telefono.setText(e.getTelefono());
        Email.setText(e.getEmail());
    }

    private void cargarHorarios() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        try {
            List<Object[]> lista = hs.listarConNombres();

            for (Object[] fila : lista) {
                modelo.addRow(new Object[]{
                    fila[0],
                    fila[1],
                    fila[2],
                    fila[3],
                    fila[4],
                    fila[5],
                    fila[6],
                    fila[7]
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage());
        }
    }
 
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        insertar = new javax.swing.JButton();
        listar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        NumDOI = new javax.swing.JTextField();
        Telefono = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ComboBoxEstado = new javax.swing.JComboBox<>();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID EMPLEADO");

        jLabel3.setText("Dia de la Semana");

        jLabel4.setText("Hora de Ingreso");

        jLabel5.setText("Hora de Salida");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO" }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID HORARIO", "NOMBRES", "APELLIDOS", "DIA SEMANA", "HORA DE ENTRADA", "HORA DE SALIDA"
            }
        ));
        jTable1.setToolTipText("");
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        insertar.setText("Insertar");
        insertar.addActionListener(this::insertarActionPerformed);

        listar.setText("Listar");
        listar.addActionListener(this::listarActionPerformed);

        actualizar.setText("Actualizar");
        actualizar.addActionListener(this::actualizarActionPerformed);

        eliminar.setText("Eliminar");
        eliminar.addActionListener(this::eliminarActionPerformed);

        jLabel7.setText("TIPODOI");

        jLabel8.setText("NUMDOI");

        jLabel9.setText("TELEFONO");

        jLabel10.setText("EMAIL");

        jLabel11.setText("ESTADO");

        ComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO", "ANULADO" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSpinner1)
                                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(insertar)
                                .addGap(18, 18, 18)
                                .addComponent(listar)
                                .addGap(32, 32, 32)
                                .addComponent(actualizar)))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(eliminar)
                            .addComponent(jLabel11))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(Telefono)
                            .addComponent(ComboBoxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(NumDOI)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumDOI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(ComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizar)
                    .addComponent(eliminar)
                    .addComponent(listar)
                    .addComponent(insertar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarActionPerformed
        if (listaEmpleados == null || listaEmpleados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay empleados cargados.");
            return;
        }
        int idx = jComboBox2.getSelectedIndex();
        if (idx < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un empleado.");
            return;
        }
        String idEmp = listaEmpleados.get(idx).getIdEmpleado();
        if (!idEmp.matches("^EMP\\d{7}$")) {
            JOptionPane.showMessageDialog(this, "ID de empleado no válido.");
            return;
        }
        Object diaObj = jComboBox3.getSelectedItem();
        if (diaObj == null) {
            JOptionPane.showMessageDialog(this, "Selecciona el día de la semana.");
            return;
        }
        String dia = diaObj.toString().trim();

        java.util.Date dIni = (java.util.Date) jSpinner1.getValue();
        java.util.Date dFin = (java.util.Date) jSpinner2.getValue();
        Time horaInicio = new Time(dIni.getTime());
        Time horaFin = new Time(dFin.getTime());
        if (horaFin.getTime() <= horaInicio.getTime()) {
            JOptionPane.showMessageDialog(this, "La hora de salida debe ser posterior a la de entrada.");
            return;
        }

        Object estObj = ComboBoxEstado.getSelectedItem();
        if (estObj == null) {
            JOptionPane.showMessageDialog(this, "Selecciona el estado del horario.");
            return;
        }
        String est = estObj.toString().trim();
        if (!est.equals("ACTIVO") && !est.equals("INACTIVO") && !est.equals("ANULADO")) {
            JOptionPane.showMessageDialog(this, "Estado no válido (use ACTIVO, INACTIVO o ANULADO).");
            return;
        }

        try {
            Horarios h = new Horarios();
            h.setidHorario(hs.generarId());
            h.setidEmpleado(idEmp);
            h.setDiaSemana(dia);
            h.setHoraInicio(horaInicio);
            h.setHoraFin(horaFin);
            h.setEstado(est);

            if (hs.insertar(h)) {
                JOptionPane.showMessageDialog(this, "Horario registrado: " + h.getidHorario());
                cargarHorarios();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo insertar el horario.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al insertar: " + ex.getMessage());
        }
    }//GEN-LAST:event_insertarActionPerformed

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        cargarEmpleadosCombo();
        cargarHorarios();
    }//GEN-LAST:event_listarActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        int fila = jTable1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un horario en la tabla.");
            return;
        }
        String idHorario = jTable1.getModel().getValueAt(fila, 0).toString();

        ActualizarHorarioForm form = new ActualizarHorarioForm(idHorario);
        form.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarHorarios();
            }
        });
        form.setVisible(true);
    }//GEN-LAST:event_actualizarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
int fila = jTable1.getSelectedRow();
    if (fila >= 0) {
        String id = jTable1.getModel().getValueAt(fila, 0).toString();
        int confirm = JOptionPane.showConfirmDialog(this, "¿Dar de baja el horario " + id + "?");
        if (confirm == JOptionPane.YES_OPTION) {
            hs.eliminar(id);
            cargarHorarios(); // Refrescar
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecciona una fila primero");
    }
    }//GEN-LAST:event_eliminarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila = jTable1.getSelectedRow();
        if (fila < 0 || listaEmpleados == null) {
            return;
        }
        Object idEmpObj = jTable1.getModel().getValueAt(fila, 7);
        if (idEmpObj == null) {
            return;
        }
        String idEmp = idEmpObj.toString();
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (listaEmpleados.get(i).getIdEmpleado().equals(idEmp)) {
                jComboBox2.setSelectedIndex(i);
                llenarCamposEmpleado(listaEmpleados.get(i));
                break;
            }
        }
        Object dia = jTable1.getModel().getValueAt(fila, 3);
        if (dia != null) {
            jComboBox3.setSelectedItem(dia.toString().trim());
        }
        Object hEnt = jTable1.getModel().getValueAt(fila, 4);
        Object hSal = jTable1.getModel().getValueAt(fila, 5);
        if (hEnt instanceof Time) {
            jSpinner1.setValue(new java.util.Date(((Time) hEnt).getTime()));
        }
        if (hSal instanceof Time) {
            jSpinner2.setValue(new java.util.Date(((Time) hSal).getTime()));
        }
        Object estHor = jTable1.getModel().getValueAt(fila, 6);
        if (estHor != null) {
            String es = estHor.toString().trim();
            if (es.equals("ACTIVO") || es.equals("INACTIVO") || es.equals("ANULADO")) {
                ComboBoxEstado.setSelectedItem(es);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new HorariosForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Email;
    private javax.swing.JComboBox<String> ComboBoxEstado;
    private javax.swing.JTextField NumDOI;
    private javax.swing.JTextField Telefono;
    private javax.swing.JButton actualizar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton insertar;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton listar;
    // End of variables declaration//GEN-END:variables


}
