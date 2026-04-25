package javaapplication2.VIEW.Empleados;

import javaapplication2.VIEW.Empleados.DlgEmpleadosInactivos;

import java.util.List;
import javaapplication2.MODEL.Empleado;
import javax.swing.table.DefaultTableModel;
import javaapplication2.SERVICE.EmpleadoService;
import javax.swing.JOptionPane;

public class FormEmpleado extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormEmpleado.class.getName());
    
    private final EmpleadoService service = new EmpleadoService();
    
    private String idSeleccionado = null;

    public FormEmpleado() {
        initComponents(); /*Llama al método que construye la interfaz gráfica*/
        txtTele.setText("9");
        txtTeEm.setText("");
        
        this.getContentPane().setBackground(new java.awt.Color(255, 240, 245));
        txtApeM.setOpaque(true);
        txtApeP.setOpaque(true);
        txtEmail.setOpaque(true);
        txtTeEm.setOpaque(true);
        txtTipo.setOpaque(true);
        txtTele.setOpaque(true);
        txtName.setOpaque(true);
        
        java.awt.Color blanco = new java.awt.Color(255, 255, 255);
        btnRegistrar.setBackground(blanco);
        btnListar.setBackground(blanco);
        btnEliminar.setBackground(blanco);
        btnActualizar.setBackground(blanco);
        
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        listar();
    }
    
    void listar() {
        try {
            List<Empleado> lista = service.listar();

            DefaultTableModel modelo = (DefaultTableModel) tblEmpleados.getModel();
            modelo.setRowCount(0);

            for (Empleado e : lista) {
                modelo.addRow(new Object[]{
                    e.getIdEmpleado(),
                    e.getTipoDOI(),
                    e.getNumDOI(),
                    e.getApePaterno(),
                    e.getApeMaterno(),
                    e.getNombres(),
                    e.getEmail(),
                    e.getTelefono(),
                    e.getTelefonoEmergencia(),
                    e.getEstado()
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    /*Hhdldhkjfjs*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTipo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        lblTipo = new javax.swing.JLabel();
        lblNumb = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblTele = new javax.swing.JLabel();
        lblTeEM = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtTele = new javax.swing.JTextField();
        txtTeEm = new javax.swing.JTextField();
        cmbTipo = new javax.swing.JComboBox<>();
        lblApeP = new javax.swing.JLabel();
        lbApeM = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtApeP = new javax.swing.JTextField();
        txtApeM = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAntes = new javax.swing.JButton();
        txtNumb = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IDEMPLEADO", "TIPO DOI", "NUM DOI", "APE PATERNO", "APE MATERNO", "NOMBRES", "EMAIL", "TELEFONO", "TELEFONO EMERG", "ESTADO"
            }
        ));
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        lblTipo.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        lblTipo.setText("Tipo DOI:");

        lblNumb.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        lblNumb.setText("Número DOI:");

        lblEmail.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        lblEmail.setText("Email:");

        lblTele.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        lblTele.setText("Teléfono:");

        lblTeEM.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        lblTeEM.setText("Teléfono Emergencia:");

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        txtTele.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTeleKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTeleKeyTyped(evt);
            }
        });

        txtTeEm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTeEmKeyPressed(evt);
            }
        });

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "PASAPORTE", "CARNET_DE_EXTRANJERIA", "CPP/PTP" }));
        cmbTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbTipoMouseClicked(evt);
            }
        });
        cmbTipo.addActionListener(this::cmbTipoActionPerformed);

        lblApeP.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        lblApeP.setText("Apellido paterno:");

        lbApeM.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        lbApeM.setText("Apellido materno:");

        lblName.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        lblName.setText("Nombres:");

        txtApeP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApePKeyPressed(evt);
            }
        });

        txtApeM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApeMKeyPressed(evt);
            }
        });

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameKeyPressed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(this::btnRegistrarActionPerformed);

        btnListar.setText("Listar");
        btnListar.addActionListener(this::btnListarActionPerformed);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

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

        btnAntes.setText("Antiguos empleados");
        btnAntes.addActionListener(this::btnAntesActionPerformed);

        txtNumb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumbKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAntes)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblTele, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblNumb, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblTipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblTeEM)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(27, 27, 27)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtTele, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cmbTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtTeEm)
                                                .addComponent(txtNumb, javax.swing.GroupLayout.Alignment.LEADING)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblApeP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbApeM, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtApeP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtApeM, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(lblApeP)
                    .addComponent(txtApeP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumb)
                    .addComponent(lbApeM)
                    .addComponent(txtApeM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTele)
                    .addComponent(txtTele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTeEM)
                    .addComponent(txtTeEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnListar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAntes)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //INSERT
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        try {
            String tipoDOI = cmbTipo.getSelectedItem().toString();
            String numDOI = txtNumb.getText().trim();
            String apePaterno = txtApeP.getText().trim();
            String apeMaterno = txtApeM.getText().trim();
            String nombres = txtName.getText().trim();
            String email = txtEmail.getText().trim();
            String telefono = txtTele.getText().trim();
            String telefonoEmergencia = txtTeEm.getText().trim();

            //ID null porque se generará luego y se define el estado como 1 porque así es y será
            //Como solo es un objeto es más fácil de pasarlo
            Empleado nuevo = new Empleado(null, tipoDOI, numDOI, apePaterno, apeMaterno, nombres, email, telefono, telefonoEmergencia, 1);
            boolean ok = service.registrar(nuevo);

            if (ok) {
                JOptionPane.showMessageDialog(this, "Empleado registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                listar();
            } 

        } catch (Exception e) {
            String msg = e.getMessage();

            if (msg.startsWith("REAC-001")) {
                
                String idRecuperado = msg.split("\\|")[1];

                int rpta = JOptionPane.showConfirmDialog(this, 
                    "Este empleado ya estuvo registrado anteriormente y está INACTIVO.\n" +
                    "¿Desea reactivarlo ahora?", 
                    "Aviso de Reactivación", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);

                if (rpta == JOptionPane.YES_OPTION) {
                    try {
                        service.reactivar(idRecuperado);
                        JOptionPane.showMessageDialog(this, "Empleado reactivado con éxito.");
                        limpiarCampos();
                        listar();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, msg, "Error de Registro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed
    
    //SELECT (1)
    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
        listar();
    }//GEN-LAST:event_btnListarActionPerformed
    
    //DELETE
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = tblEmpleados.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un empleado de la tabla primero", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String id = tblEmpleados.getValueAt(fila, 0).toString();
            String nombre = tblEmpleados.getValueAt(fila, 3).toString();

            int confirmar = JOptionPane.showConfirmDialog(this, 
                    "¿Está seguro de eliminar (desactivar) al empleado: " + nombre + "?", 
                    "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (confirmar == JOptionPane.YES_OPTION) {
                boolean ok = service.eliminar(id); 

                if (ok) {
                    JOptionPane.showMessageDialog(this, "Empleado desactivado correctamente");
                    listar();
                    limpiarCampos(); 
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo realizar la operación en la base de datos");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    
    //UPDATE
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = tblEmpleados.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un empleado de la tabla para editar", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String id = tblEmpleados.getValueAt(fila, 0).toString();

            String email = txtEmail.getText().trim(); 
            String telefono = txtTele.getText().trim();
            String telefonoEmergencia = txtTeEm.getText().trim();

            if (email.isEmpty() || telefono.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El Email y el Teléfono principal no pueden quedar vacíos");
                return;
            }

            boolean ok = service.actualizar(id, email, telefono, telefonoEmergencia);

            if (ok) {
                JOptionPane.showMessageDialog(this, "Datos actualizados correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                listar();
                limpiarCampos();
            } 

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Error de validación: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed
    
    //DELETE BUTTON TURNS RED
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
    
    //SELECT (0)
    private void btnAntesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAntesActionPerformed
        // TODO add your handling code here:
        DlgEmpleadosInactivos papelera = new DlgEmpleadosInactivos(this, true);
        papelera.setLocationRelativeTo(null);
        papelera.setVisible(true);

        listar();
    }//GEN-LAST:event_btnAntesActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        // TODO add your handling code here:
        int fila = tblEmpleados.getSelectedRow();

    if (fila != -1) {
        try {
            idSeleccionado = tblEmpleados.getValueAt(fila, 0).toString();

            cmbTipo.setSelectedItem(tblEmpleados.getValueAt(fila, 1).toString());
            txtNumb.setText(tblEmpleados.getValueAt(fila, 2).toString());
            txtApeP.setText(tblEmpleados.getValueAt(fila, 3).toString());
            txtApeM.setText(tblEmpleados.getValueAt(fila, 4).toString());
            txtName.setText(tblEmpleados.getValueAt(fila, 5).toString());
            txtEmail.setText(tblEmpleados.getValueAt(fila, 6).toString());
            txtTele.setText(tblEmpleados.getValueAt(fila, 7).toString());
            
            Object telEm = tblEmpleados.getValueAt(fila, 8);
            txtTeEm.setText(telEm != null ? telEm.toString() : "");

            txtNumb.setEditable(false);
            txtName.setEditable(false);
            txtApeP.setEditable(false);
            txtApeM.setEditable(false);
            cmbTipo.setEnabled(false);

        } catch (Exception e) {
            System.err.println("Error al recuperar datos: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    //SALTAR A SIGUIENTE CUADRO DE TEXTO
    private void txtNumbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumbKeyPressed
        // TODO add your handling code here:
        saltarConEnter(evt, txtApeP);
    }//GEN-LAST:event_txtNumbKeyPressed

    private void txtApePKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApePKeyPressed
        // TODO add your handling code here:
        saltarConEnter(evt, txtApeM);
    }//GEN-LAST:event_txtApePKeyPressed

    private void txtApeMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApeMKeyPressed
        // TODO add your handling code here:
        saltarConEnter(evt, txtName);
    }//GEN-LAST:event_txtApeMKeyPressed

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
        // TODO add your handling code here:
        saltarConEnter(evt, txtEmail);
    }//GEN-LAST:event_txtNameKeyPressed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        // TODO add your handling code here:
        saltarConEnter(evt, txtTele);
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtTeleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTeleKeyPressed
        // TODO add your handling code here:
        saltarConEnter(evt, txtTeEm);
        
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
            if (txtTele.getText().length() <= 1) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtTeleKeyPressed

    private void cmbTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbTipoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoMouseClicked

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        // TODO add your handling code here:
        txtNumb.requestFocus();
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void txtTeEmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTeEmKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
            btnRegistrarActionPerformed(null); 
        }
    }//GEN-LAST:event_txtTeEmKeyPressed

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        // TODO add your handling code here:
        if (txtEmail.getText().length() >= 75) {
            evt.consume(); //Ignora la tecla si llegí a 75;
            getToolkit().beep(); //Sonido: ya no cabe más;
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtTeleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTeleKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
            return;
        }

        if (txtTele.getText().length() >= 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTeleKeyTyped

    
    //LIMPIAR CAMPOS
    private void limpiarCampos() {
        txtNumb.setText("");
        txtApeP.setText("");
        txtApeM.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtTele.setText("9");
        txtTeEm.setText("");

        cmbTipo.setSelectedIndex(0); 

        txtNumb.setEditable(true);
        txtApeP.setEditable(true);
        txtApeM.setEditable(true);
        txtName.setEditable(true);
        cmbTipo.setEnabled(true);

        tblEmpleados.clearSelection();

        txtNumb.requestFocus();
    }

    //USAR FLATLAF
    public static void main(String args[]) {
        try {
            com.formdev.flatlaf.FlatLightLaf.setup();
        } catch( Exception ex ) {
            System.err.println( "Error al iniciar FlatLaf" );
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FormEmpleado().setVisible(true);
        });
    }
    
    //CLICK PARA SALTAR
    private void saltarConEnter(java.awt.event.KeyEvent evt, javax.swing.JComponent siguienteCampo) {
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            siguienteCampo.requestFocus();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAntes;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbApeM;
    private javax.swing.JLabel lblApeP;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNumb;
    private javax.swing.JLabel lblTeEM;
    private javax.swing.JLabel lblTele;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtApeM;
    private javax.swing.JTextField txtApeP;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumb;
    private javax.swing.JTextField txtTeEm;
    private javax.swing.JTextField txtTele;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
