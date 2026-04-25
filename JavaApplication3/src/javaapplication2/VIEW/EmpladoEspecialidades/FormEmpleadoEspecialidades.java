package javaapplication2.VIEW.EmpladoEspecialidades;

import java.util.List;
import javaapplication2.MODEL.EmpleadoEspecialidad;
import javaapplication2.MODEL.Especialidad;
import javaapplication2.MODEL.Empleado;
import javax.swing.table.DefaultTableModel;
import javaapplication2.SERVICE.EmpleadoEspecialidadService;
import javaapplication2.SERVICE.EmpleadoService;
import javaapplication2.SERVICE.EspecialidadService;
import javaapplication2.CONFIG.Item;
import javax.swing.JOptionPane;

public class FormEmpleadoEspecialidades extends javax.swing.JFrame {
    
    EmpleadoService sEmp = new EmpleadoService();
    EspecialidadService sEsp = new EspecialidadService();
    EmpleadoEspecialidadService sRelacion = new EmpleadoEspecialidadService();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormEmpleadoEspecialidades.class.getName());
    
    private EmpleadoEspecialidadService service = new EmpleadoEspecialidadService();

    public FormEmpleadoEspecialidades() {
        initComponents();
        cargarCombos();
        
        this.getContentPane().setBackground(new java.awt.Color(255, 240, 245));
        java.awt.Color blanco = new java.awt.Color(255, 255, 255);
        btnAsignar.setBackground(blanco);
        btnListar.setBackground(blanco);
        btnEliminar.setBackground(blanco);
        btnPapelera.setBackground(blanco);
        
        btnAsignar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPapelera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        listar();
    }
    
    void listar() {
        try {
            List<EmpleadoEspecialidad> lista = service.listar();

            DefaultTableModel modelo = (DefaultTableModel) tblAsignaciones.getModel();
            modelo.setRowCount(0);

            for (EmpleadoEspecialidad ee : lista) {
                modelo.addRow(new Object[]{
                    ee.getIdEmpleadoEspecialidad(),
                    ee.getIdEmpleado(),
                    ee.getIdEspecialidad(),
                    ee.getEstado()
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAsignar = new javax.swing.JLabel();
        lblEmpleado = new javax.swing.JLabel();
        lblEspecialidad = new javax.swing.JLabel();
        cmbEmpleado = new javax.swing.JComboBox();
        cmbEspecialidad = new javax.swing.JComboBox();
        btnAsignar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsignaciones = new javax.swing.JTable();
        btnListar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnPapelera = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAsignar.setFont(new java.awt.Font("Garamond", 1, 16)); // NOI18N
        lblAsignar.setText("Asignar especialidades a los empleados");

        lblEmpleado.setFont(new java.awt.Font("Garamond", 1, 13)); // NOI18N
        lblEmpleado.setText("Empleado:");

        lblEspecialidad.setFont(new java.awt.Font("Garamond", 1, 13)); // NOI18N
        lblEspecialidad.setText("Especialidad:");

        btnAsignar.setFont(new java.awt.Font("Garamond", 1, 13)); // NOI18N
        btnAsignar.setText("Asignar");
        btnAsignar.addActionListener(this::btnAsignarActionPerformed);

        tblAsignaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "IDEMPLEADOESPECIALIDAD", "IDEMPLEADO", "IDESPECIALIDAD", "ESTADO"
            }
        ));
        tblAsignaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAsignacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAsignaciones);

        jScrollPane2.setViewportView(jScrollPane1);

        btnListar.setFont(new java.awt.Font("Garamond", 1, 13)); // NOI18N
        btnListar.setText("Listar");
        btnListar.addActionListener(this::btnListarActionPerformed);

        btnEliminar.setFont(new java.awt.Font("Garamond", 1, 13)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnPapelera.setFont(new java.awt.Font("Garamond", 1, 13)); // NOI18N
        btnPapelera.setText("Asignaciones anteriores");
        btnPapelera.addActionListener(this::btnPapeleraActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAsignar)
                .addGap(135, 135, 135))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblEmpleado)
                                    .addGap(49, 49, 49)
                                    .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblEspecialidad)
                                    .addGap(35, 35, 35)
                                    .addComponent(cmbEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPapelera)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblAsignar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpleado)
                    .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEspecialidad)
                    .addComponent(cmbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsignar)
                    .addComponent(btnListar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPapelera)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //REGISTRAR
    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        // TODO add your handling code here:
        try {
            Item emp = (Item) cmbEmpleado.getSelectedItem();
            Item esp = (Item) cmbEspecialidad.getSelectedItem();

            if (emp == null || esp == null) return;

            EmpleadoEspecialidad nuevo = new EmpleadoEspecialidad();

            nuevo.setIdEmpleado(emp.getId());
            nuevo.setIdEspecialidad(esp.getId());

            if (sRelacion.insertar(nuevo)) {
                JOptionPane.showMessageDialog(this, "¡Asignado con éxito!");
                listar(); 
                cmbEmpleado.setSelectedIndex(0);
                cmbEspecialidad.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(this, "Error al asignar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAsignarActionPerformed

    //LISTAR ACTIVOS
    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
        listar();
    }//GEN-LAST:event_btnListarActionPerformed

    //ELIMINAR
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = tblAsignaciones.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar");
                return;
            }

            int confirmar = JOptionPane.showConfirmDialog(this, 
                    "¿Está seguro de eliminar esta fila?", 
                    "Confirmar", JOptionPane.YES_NO_OPTION);

            if (confirmar != JOptionPane.YES_OPTION) {
                return;
            }

            String id = tblAsignaciones.getValueAt(fila, 0).toString();

            // El service llamará al DAO que ahora hace el UPDATE a 'NO_EJERCE'
            boolean ok = service.eliminar(id); 

            if (ok) {
                JOptionPane.showMessageDialog(this, "Fila eliminada correctamente");
                listar(); // Esto recargará la tabla
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo cambiar el estado");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnPapeleraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPapeleraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPapeleraActionPerformed

    //MOUSE EN ROJO
    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        // TODO add your handling code here:
        btnEliminar.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminar.setForeground(java.awt.Color.WHITE);
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        // TODO add your handling code here:
        btnEliminar.setBackground(java.awt.Color.WHITE);
        btnEliminar.setForeground(java.awt.Color.BLACK);
    }//GEN-LAST:event_btnEliminarMouseExited

    private void tblAsignacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAsignacionesMouseClicked
        // TODO add your handling code here:
        int fila = tblAsignaciones.getSelectedRow();

        if (fila != -1) {
            // Guardamos el ID de la primera columna (columna 0)
            String id = tblAsignaciones.getValueAt(fila, 0).toString();

            // Opcional: Imprime en consola para estar seguro de que lo capturó
            System.out.println("ID capturado para eliminar: " + id);
        }
    }//GEN-LAST:event_tblAsignacionesMouseClicked
    
    //COMBOS PARA QUE LOS COMBOX TENGAN LA LISTA DE EMPLEADOS Y ESPECIALIDADES
    private void cargarCombos() {
        try {
            //COMBO DE EMPLADOS
            List<Empleado> listaEmp = sEmp.listarParaCombo();
            System.out.println("DEBUG: Cantidad de empleados encontrados: " + listaEmp.size());

            cmbEmpleado.removeAllItems();
            for (Empleado e : listaEmp) {
                cmbEmpleado.addItem(new Item(e.getIdEmpleado(), e.getNombres()));
            }
            
            //COMBO DE ESPECIALIDADES
            List<Especialidad> listaEsp = sEsp.listarParaCombo();
            System.out.println("DEBUG: Cantidad de especialidades: " + listaEsp.size());

            cmbEspecialidad.removeAllItems();
            for (Especialidad esp : listaEsp) {
                cmbEspecialidad.addItem(new Item(esp.getIdEspecialidad(), esp.getNombre()));
            }
            
        } catch (Exception ex) {
            System.err.println("ERROR CRÍTICO: " + ex.getMessage());
        }
    }
    
    //USAT FLATLAF
    public static void main(String args[]) {
        try {
            com.formdev.flatlaf.FlatLightLaf.setup();
        } catch( Exception ex ) {
            System.err.println( "Error al iniciar FlatLaf" );
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FormEmpleadoEspecialidades().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnPapelera;
    private javax.swing.JComboBox cmbEmpleado;
    private javax.swing.JComboBox cmbEspecialidad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAsignar;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JTable tblAsignaciones;
    // End of variables declaration//GEN-END:variables
}
