package javaapplication2.VIEW;

import javaapplication2.SERVICE.ContratoService;
import javaapplication2.MODEL.Contratos;
import java.util.List;
import javax.swing.JOptionPane;
public class ActualizarContratoForm extends javax.swing.JFrame {
    
    private String idContrato; // el contrato que vas a actualizar
    private ContratoService service = new ContratoService();

   
    public ActualizarContratoForm(String idContrato) {
        initComponents();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        this.idContrato = idContrato;

        jSpinner1.setModel(new javax.swing.SpinnerDateModel());
        jSpinner1.setEditor(new javax.swing.JSpinner.DateEditor(jSpinner1, "yyyy-MM-dd"));
        jSpinner2.setModel(new javax.swing.SpinnerDateModel());
        jSpinner2.setEditor(new javax.swing.JSpinner.DateEditor(jSpinner2, "yyyy-MM-dd"));

        cargarDatos();

        getContentPane().setBackground(new java.awt.Color(245, 248, 250));
        jButton1.setBackground(new java.awt.Color(144, 238, 144));
        jButton1.setForeground(java.awt.Color.BLACK);
        jButton1.setFocusPainted(false);
        jButton2.setBackground(new java.awt.Color(255, 182, 193));
        jButton2.setForeground(java.awt.Color.BLACK);
        jButton2.setFocusPainted(false);
        jSpinner1.setBackground(java.awt.Color.WHITE);
        jSpinner1.setForeground(java.awt.Color.BLACK);
        jSpinner1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        jSpinner2.setBackground(java.awt.Color.WHITE);
        jComboBox1.setBackground(java.awt.Color.WHITE);
        jComboBox2.setBackground(java.awt.Color.WHITE);
    }

   

    // Método para cargar datos en los componentes (JSpinner, JComboBox, etc.)
    private void cargarDatos() {
        List<Contratos> lista = service.listar();
        boolean encontrado = false;
        for (Contratos c : lista) {
            if (c.getidContrato().equals(idContrato)) {
                jSpinner1.setValue(new java.util.Date(c.getFechaInicio().getTime()));
                jSpinner2.setValue(new java.util.Date(c.getFechaFin().getTime()));
                jComboBox1.setSelectedItem(c.getRol());
                jComboBox2.setSelectedItem(c.getEstado());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(this,
                    "No se encontró el contrato con ID: " + idContrato,
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    // Método para guardar cambios
    private void guardarCambios() {
        java.util.Date fi = (java.util.Date) jSpinner1.getValue();
        java.util.Date ff = (java.util.Date) jSpinner2.getValue();
        String rol = jComboBox1.getSelectedItem().toString();
        String estado = jComboBox2.getSelectedItem().toString();

        service.actualizarFechaInicio(idContrato, new java.sql.Date(fi.getTime()));
        service.actualizarFechaFin(idContrato, new java.sql.Date(ff.getTime()));
        service.actualizarRol(idContrato, rol);
        service.actualizarEstado(idContrato, estado);

        JOptionPane.showMessageDialog(this, "Contrato actualizado correctamente");
        
    }
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ActualizarContratoForm.class.getName());
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EMPLEADA", "ADMINISTRADORA", "SECRETARIA", "GERENTA" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO", "ANULADO" }));

        jButton1.setText("Actualizar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Nueva Fecha de Inicio");

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Nueva Fecha de Cese");

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Rol");

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Estado");

        jLabel5.setBackground(new java.awt.Color(255, 204, 204));
        jLabel5.setText("¿QUE DESEAS ACTUALIZAR?");

        jButton2.setText("Salir");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSpinner2)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            guardarCambios();
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "Error al actualizar contrato", e);
            JOptionPane.showMessageDialog(this, "Error al actualizar el contrato.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      this.dispose();   // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    // End of variables declaration//GEN-END:variables
}
