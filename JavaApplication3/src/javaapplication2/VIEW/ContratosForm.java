
package javaapplication2.VIEW;

import javaapplication2.CONFIG.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

import java.util.Date;
import javax.swing.JOptionPane;


import java.util.List;
import javaapplication2.MODEL.Contratos;
import javaapplication2.SERVICE.ContratoService;
import javaapplication2.SERVICE.EmpleadoService;
import javaapplication2.MODEL.Empleado;

public class ContratosForm extends javax.swing.JFrame {
    
    EmpleadoService empService = new EmpleadoService();
    List<Empleado> listaEmpleados;
    
    
    
    
    private String obtenerNombreEmpleado(String id) {
        for (Empleado e : listaEmpleados) {
            if (e.getIdEmpleado().equals(id)) {
                return e.getNombres() + " " 
                    + e.getApePaterno() + " " 
                    + e.getApeMaterno();
                }
            }
            return id;
    }
    
    private void cargarEmpleadosCombo() {
        listaEmpleados = empService.listar();
        jComboBox3.removeAllItems();
    for (Empleado e : listaEmpleados) {
        String nombre = e.getNombres() + " " 
                      + e.getApePaterno() + " " 
                      + e.getApeMaterno();

        jComboBox3.addItem(nombre);
        }
    }
    
    private void generarIdContrato() {
        ContratoService service = new ContratoService();
        String id = service.generarId();
    }
          
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ContratosForm.class.getName());

    
    public ContratosForm() {
        initComponents();
        cargarEmpleadosCombo(); 
        cargarTabla();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            cargarDesdeTabla();
        }
        });
        
        
        
        jTable1.getTableHeader().setBackground(new java.awt.Color(100, 149, 237)); // azul
        jTable1.getTableHeader().setForeground(java.awt.Color.WHITE); // letras blancas
        jTable1.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));

        jTable1.setSelectionBackground(new java.awt.Color(0, 153, 153)); // turquesa
        jTable1.setSelectionForeground(java.awt.Color.WHITE);

        jTable1.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
    @Override
    public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (!isSelected) {
            if (row % 2 == 0) {
                c.setBackground(new java.awt.Color(245, 245, 245)); // gris claro
            } else {
                c.setBackground(java.awt.Color.WHITE);
            }
        }

        return c;
    }
});
        this.getContentPane().setBackground(new java.awt.Color(255, 240, 245));
        jComboBox3.setOpaque(true);
        jSpinner1.setOpaque(true);
        jSpinner2.setOpaque(true);
        jComboBox1.setOpaque(true);
        jComboBox2.setOpaque(true);
        
        java.awt.Color blanco = new java.awt.Color(255, 255, 255);
        jButton1.setBackground(blanco);
        jButton2.setBackground(blanco);
        jButton3.setBackground(blanco);
        jButton4.setBackground(blanco);
        
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jSpinner1.setModel(new javax.swing.SpinnerDateModel());
        jSpinner1.setEditor(new javax.swing.JSpinner.DateEditor(jSpinner1, "yyyy-MM-dd"));
        
        javax.swing.JSpinner.DateEditor editor1 = (javax.swing.JSpinner.DateEditor) jSpinner1.getEditor();
        javax.swing.JTextField txt1 = editor1.getTextField();
        txt1.setText("Agregar fecha inicio...");
        txt1.setForeground(java.awt.Color.GRAY);
        
        jSpinner2.setModel(new javax.swing.SpinnerDateModel());
        jSpinner2.setEditor(new javax.swing.JSpinner.DateEditor(jSpinner2, "yyyy-MM-dd"));
        javax.swing.JSpinner.DateEditor editor2 = (javax.swing.JSpinner.DateEditor) jSpinner2.getEditor();
        javax.swing.JTextField txt2 = editor2.getTextField();
        txt2.setText("Agregar fecha fin...");
        txt2.setForeground(java.awt.Color.GRAY);
        generarIdContrato();
    }
    
    
    private void cargarDesdeTabla() {

    int fila = jTable1.getSelectedRow();
    if (fila == -1) return;

    // 🔥 OBTENER DATOS DE LA TABLA
    String nombreTabla = jTable1.getValueAt(fila, 1).toString(); // nombres
String fechaInicio = jTable1.getValueAt(fila, 3).toString(); // ✔ correcto
String fechaFin = jTable1.getValueAt(fila, 4).toString();    // ✔ correcto
String rol = jTable1.getValueAt(fila, 5).toString();         // ✔ correcto
String estado = jTable1.getValueAt(fila, 6).toString();      // ✔ correcto

    // 🔥 BUSCAR EN LISTA DE EMPLEADOS
    for (int i = 0; i < listaEmpleados.size(); i++) {

        Empleado e = listaEmpleados.get(i);

        String nombreCompleto = e.getNombres() + " " 
                              + e.getApePaterno() + " " 
                              + e.getApeMaterno();

        if (nombreCompleto.equals(nombreTabla)) {

            // 🔥 SELECCIONAR COMBO EMPLEADO
            jComboBox3.setSelectedIndex(i);

            // 🔥 LLENAR TEXTFIELDS
            TipoDOI.setText(e.getTipoDOI());
            NumDOI.setText(e.getNumDOI());
            Telefono.setText(e.getTelefono());
            Email.setText(e.getEmail());
            Estado.setText(String.valueOf(e.getEstado()));

            break;
        }
    }

        try {
            // 🔥 FECHAS A SPINNER
            java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("yyyy-MM-dd");

            java.util.Date fInicio = formato.parse(fechaInicio);
            java.util.Date fFin = formato.parse(fechaFin);

            jSpinner1.setValue(fInicio);
            jSpinner2.setValue(fFin);

        } catch (Exception e) {
            System.out.println("Error fechas: " + e);
        }

        // 🔥 COMBO ROL
        jComboBox1.setSelectedItem(rol);

        // 🔥 COMBO ESTADO
        jComboBox2.setSelectedItem(estado);
    }
     
    private void llenarDatosEmpleado(String nombreCompleto) {

    Empleado emp = empService.buscarPorNombreCompleto(nombreCompleto);

    if (emp != null) {
        TipoDOI.setText(emp.getTipoDOI());
        NumDOI.setText(emp.getNumDOI());
        Telefono.setText(emp.getTelefono());
        Email.setText(emp.getEmail());
        Estado.setText(String.valueOf(emp.getEstado()));
    }
    
    
}  
    private void cargarTabla() {
       try {
        ContratoService service = new ContratoService();
        List<Object[]> lista = service.listarConEmpleado();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID Contrato");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Fecha de Inicio");
        modelo.addColumn("Fecha de Cese");
        modelo.addColumn("Rol");
        modelo.addColumn("Estado");

        for (Object[] fila : lista) {
            modelo.addRow(new Object[]{
                fila[0],
                fila[1],
                fila[2],
                fila[3],
                fila[4],
                fila[5],
                fila[6]
            });
        }

        jTable1.setModel(modelo);

    } catch (Exception e) {
        System.out.println("Error: " + e);
    }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TipoDOI = new javax.swing.JTextField();
        NumDOI = new javax.swing.JTextField();
        Telefono = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        Estado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("EMPLEADO");

        jLabel2.setText("Fecha de Inicio");

        jLabel3.setText("Fecha de Cese");

        jLabel4.setText("Rol");

        jLabel5.setText("Estado");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Contrato", "Nombres", "Apellidos", "Fecha de Inicio", "Fecha de Cese", "Rol", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Insertar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Listar");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setText("Actualizar");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setText("Eliminar");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EMPLEADA", "ADMINISTRADORA", "SECRETARIA", "GERENTA" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO", "ANULADO" }));

        jComboBox3.addActionListener(this::jComboBox3ActionPerformed);

        jLabel6.setText("TIPO DOI");

        jLabel7.setText("NUM DOI");

        jLabel8.setText("TELEFONO");

        jLabel9.setText("EMAIL");

        jLabel10.setText("ESTADO");

        Email.addActionListener(this::EmailActionPerformed);

        Estado.addActionListener(this::EstadoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(12, 12, 12)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jLabel1)
                                                    .addGap(52, 52, 52))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addGap(44, 44, 44)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(102, 102, 102)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(84, 84, 84)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(40, 40, 40)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSpinner2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 202, Short.MAX_VALUE)))
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Telefono)
                                            .addComponent(NumDOI)
                                            .addComponent(TipoDOI, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(1, 1, 1)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                            .addComponent(Estado)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(TipoDOI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(NumDOI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2)
                                .addComponent(jButton3)
                                .addComponent(jButton4)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    int fila = jTable1.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(null, "Selecciona un contrato");
            return;
        }
        String idContrato = jTable1.getValueAt(fila, 0).toString();

        ActualizarContratoForm form = new ActualizarContratoForm(idContrato);
        form.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTabla();
            }
        });
        form.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
          try {
        int fila = jTable1.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un contrato");
            return;
        }

        String idContrato = jTable1.getValueAt(fila, 0).toString();

        int confirm = JOptionPane.showConfirmDialog(null, 
                "¿Seguro que deseas ANULAR este contrato?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            ContratoService service = new ContratoService();
            service.eliminar(idContrato);

            JOptionPane.showMessageDialog(null, "Contrato anulado correctamente");

            cargarTabla();
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar");
        System.out.println("Error: " + e);
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    cargarTabla();   
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       

    int index = jComboBox3.getSelectedIndex();
    String idEmp = listaEmpleados.get(index).getIdEmpleado();

    // 🔥 VALIDACIÓN FORMATO
    if (!idEmp.matches("^EMP\\d{7}$")) {
        JOptionPane.showMessageDialog(null, "ID inválido ❌\nEjemplo: EMP0000001");
        return;
    }

    try {
        Contratos c = new Contratos();
        ContratoService service = new ContratoService();

        String idGenerado = service.generarId();
        c.setidContrato(idGenerado);

        c.setidEmpleado(idEmp);

        java.util.Date fechaIni = (java.util.Date) jSpinner1.getValue();
        java.util.Date fechaFin = (java.util.Date) jSpinner2.getValue();

        c.setFechaInicio(new java.sql.Date(fechaIni.getTime()));
        c.setFechaFin(new java.sql.Date(fechaFin.getTime()));

        c.setRol(jComboBox1.getSelectedItem().toString());
        c.setEstado("ACTIVO");

        // 🔥 VALIDAR RESULTADO
        boolean resultado = service.insertar(c);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Contrato insertado con ID: " + idGenerado);
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo insertar ❌");
        }

    } catch (Exception e) {
        System.out.println("Error: " + e);
        JOptionPane.showMessageDialog(null, "Error al insertar contrato");
    }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void EstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstadoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    int fila = jTable1.getSelectedRow();

    if (fila == -1) return;

    // FECHAS
    jSpinner1.setValue(jTable1.getValueAt(fila, 3));
    jSpinner2.setValue(jTable1.getValueAt(fila, 4));

    // COMBOBOX
    jComboBox1.setSelectedItem(jTable1.getValueAt(fila, 5).toString()); // ROL
    jComboBox2.setSelectedItem(jTable1.getValueAt(fila, 6).toString()); // ESTADO

        // NOMBRE COMPLETO
    String nombres = jTable1.getValueAt(fila, 1).toString();
    String apellidos = jTable1.getValueAt(fila, 2).toString();
    String nombreCompleto = nombres + " " + apellidos;

    // SELECCIONAR EN COMBO EMPLEADO
    jComboBox3.setSelectedItem(nombreCompleto);  
    
    // BUSCAR EMPLEADO REAL
        Empleado emp = empService.buscarPorNombreCompleto(nombreCompleto);

        if (emp != null) {
            TipoDOI.setText(emp.getTipoDOI());
            NumDOI.setText(emp.getNumDOI());
            Telefono.setText(emp.getTelefono());
            Email.setText(emp.getEmail());
            Estado.setText(emp.getEstado() == 1 ? "ACTIVO" : "INACTIVO");
        }
    
    }//GEN-LAST:event_jTable1MouseClicked

  
    public static void main(String args[]) {
       try {
            com.formdev.flatlaf.FlatLightLaf.setup();
        } catch( Exception ex ) {
            System.err.println( "Error al iniciar FlatLaf" );
        }

        java.awt.EventQueue.invokeLater(() -> {
            new ContratosForm().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Estado;
    private javax.swing.JTextField NumDOI;
    private javax.swing.JTextField Telefono;
    private javax.swing.JTextField TipoDOI;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
