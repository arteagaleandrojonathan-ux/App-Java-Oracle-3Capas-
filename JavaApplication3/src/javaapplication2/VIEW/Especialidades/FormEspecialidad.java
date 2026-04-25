package javaapplication2.VIEW.Especialidades;

import java.util.List;
import javaapplication2.MODEL.Especialidad;
import javax.swing.table.DefaultTableModel;
import javaapplication2.SERVICE.EspecialidadService;
import javax.swing.JOptionPane;

public class FormEspecialidad extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormEspecialidad.class.getName());
    
    private EspecialidadService service = new EspecialidadService();
    
    public FormEspecialidad() {
        initComponents(); /*Llama al método que construye la interfaz gráfica*/
        
        this.getContentPane().setBackground(new java.awt.Color(255, 240, 245));
        txtNombre.setOpaque(true);
        
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
        String[] titulos = {"ID", "NOMBRE", "ESTADO"};

        DefaultTableModel modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try {
            modelo.setRowCount(0);

            List<Especialidad> lista = service.listar();

            for (Especialidad esp : lista) {
                Object[] fila = {
                    esp.getIdEspecialidad(),
                    esp.getNombre(),
                    esp.getEstado()
                };
                modelo.addRow(fila);
            }

            tblEspecialidades.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar: " + e.getMessage());
        }
    }
    
    /*Hhdldhkjfjs*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEspecialidades = new javax.swing.JTable();
        btnListar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnPapelera = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 240, 245));

        lblNombre.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        lblNombre.setText("Nombre de especialidad:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        tblEspecialidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Estado"
            }
        ));
        tblEspecialidades.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tblEspecialidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEspecialidadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEspecialidades);

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnPapelera.setText("Papelera");
        btnPapelera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPapeleraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addGap(35, 35, 35)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPapelera)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(21, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnListar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnPapelera)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        try {
            String nombre = txtNombre.getText().trim();

            service.registrar(nombre);

            JOptionPane.showMessageDialog(this, "Especialidad registrada con éxito.");
            listar(); 
            txtNombre.setText("");

        } catch (Exception e) {
            String mensaje = e.getMessage();

            if (mensaje != null && mensaje.startsWith("REAC-001")) {

                String idParaReactivar = mensaje.split("\\|")[1];

                int respuesta = JOptionPane.showConfirmDialog(this, 
                    "Esta especialidad ya existe en la PAPELERA.\n¿Desea restaurarla ahora mismo?", 
                    "Aviso de Seguridad", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);

                if (respuesta == JOptionPane.YES_OPTION) {
                    try {
                        service.reactivar(idParaReactivar);
                        JOptionPane.showMessageDialog(this, "¡Restaurada con éxito!");
                        listar();
                        txtNombre.setText("");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Error al restaurar: " + ex.getMessage());
                    }
                }else{
                    txtNombre.setText("");
                    txtNombre.requestFocus(); //Ahorra hacer un click para registrar otra especialidad;
                }
            } else {
                JOptionPane.showMessageDialog(this, mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
        listar();
    }//GEN-LAST:event_btnListarActionPerformed

    private void tblEspecialidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEspecialidadesMouseClicked
        // TODO add your handling code here:
        int fila = tblEspecialidades.getSelectedRow();

        if (fila != -1) { //Si hace click fuera de la fila dentro de la tabla;
            try {
                Object valor = tblEspecialidades.getValueAt(fila, 1);

                if (valor != null) {
                    txtNombre.setText(valor.toString());
                }
            } catch (Exception e) {
                System.err.println("Error al capturar datos de la tabla: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_tblEspecialidadesMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = tblEspecialidades.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una especialidad para desactivar");
                return;
            }

            int confirmar = JOptionPane.showConfirmDialog(this, 
                    "¿Está seguro de desactivar esta especialidad?", 
                    "Confirmar", JOptionPane.YES_NO_OPTION);

            if (confirmar != JOptionPane.YES_OPTION) {
                return; // Si dice que no, no hace nada
            }

            String id = tblEspecialidades.getValueAt(fila, 0).toString();

            boolean ok = service.eliminar(id); 

            if (ok) {
                JOptionPane.showMessageDialog(this, "Especialidad desactivada correctamente");
                txtNombre.setText("");
                listar(); // Esto recargará la tabla;
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo cambiar el estado");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        try {
            String nombre = txtNombre.getText().trim();
            if (nombre.isEmpty()) return;

            service.registrar(nombre);
            JOptionPane.showMessageDialog(this, "Especialidad registrada con éxito.");
            listar();

        } catch (Exception e) {
            if (e.getMessage().startsWith("REAC-001")) {
                String idParaReactivar = e.getMessage().split("\\|")[1];

                int respuesta = JOptionPane.showConfirmDialog(this, 
                    "Esta especialidad está INACTIVA en la papelera.\n¿Desea restaurarla ahora?", 
                    "Especialidad detectada", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);

                if (respuesta == JOptionPane.YES_OPTION) {
                    try {
                        service.reactivar(idParaReactivar);
                        JOptionPane.showMessageDialog(this, "¡Especialidad restaurada con éxito!");
                        listar();
                        txtNombre.setText("");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        // TODO add your handling code here:
        btnEliminar.setBackground(new java.awt.Color(255, 102, 102)); // Rojo suave
        btnEliminar.setForeground(java.awt.Color.WHITE); // Texto blanco para que resalte
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        // TODO add your handling code here:
        btnEliminar.setBackground(java.awt.Color.WHITE); // Vuelve a blanco
        btnEliminar.setForeground(java.awt.Color.BLACK);
    }//GEN-LAST:event_btnEliminarMouseExited

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
        btnRegistrarActionPerformed(evt);
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnPapeleraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPapeleraActionPerformed
        // TODO add your handling code here:
        DlgEspecialiadesInactivas papelera = new DlgEspecialiadesInactivas(this, true);
        papelera.setLocationRelativeTo(null); // Para que salga al centro
        papelera.setVisible(true);

        // Al cerrar la papelera, refrescamos la tabla principal
        // para que la especialidad reactivada vuelva a aparecer
        listar();
    }//GEN-LAST:event_btnPapeleraActionPerformed

    /*USAR FLATLAF*/
    public static void main(String args[]) {
        try {
            com.formdev.flatlaf.FlatLightLaf.setup();
        } catch( Exception ex ) {
            System.err.println( "Error al iniciar FlatLaf" );
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FormEspecialidad().setVisible(true);
        });
    }
    
    /*Declaración de variables - No debe modificarse (hice que no se pueda)*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnPapelera;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblEspecialidades;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
