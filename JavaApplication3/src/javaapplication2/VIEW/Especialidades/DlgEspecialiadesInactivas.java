package javaapplication2.VIEW.Especialidades;

import java.util.List;
import javaapplication2.MODEL.Especialidad;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class DlgEspecialiadesInactivas extends javax.swing.JDialog {
    
    private javaapplication2.SERVICE.EspecialidadService service = new javaapplication2.SERVICE.EspecialidadService();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DlgEspecialiadesInactivas.class.getName());

    public DlgEspecialiadesInactivas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listarInactivos();
        
        this.getContentPane().setBackground(new java.awt.Color(255, 240, 245));
        btnReactivar.setBackground(java.awt.Color.WHITE);
    }
    
    
    private void listarInactivos() {
        DefaultTableModel modelo = (DefaultTableModel) tblInactivas.getModel();
        modelo.setRowCount(0); // Limpia la tabla antes de cargar

        // Llamamos al service que creamos antes
        List<Especialidad> lista = service.listarInactivos(); 

        for (Especialidad e : lista) {
            Object[] fila = {e.getIdEspecialidad(), e.getNombre(), e.getEstado()};
            modelo.addRow(fila);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblInactivas = new javax.swing.JTable();
        btnReactivar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Especialidades Inactivas:");

        tblInactivas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "IDESPECIALIDAD", "NOMBRE", "ESTADO"
            }
        ));
        jScrollPane3.setViewportView(tblInactivas);

        btnReactivar.setText("Reactivar");
        btnReactivar.addActionListener(this::btnReactivarActionPerformed);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(this::btnRegresarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnReactivar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegresar))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReactivar)
                    .addComponent(btnRegresar))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReactivarActionPerformed
        // TODO add your handling code here:
        int fila = tblInactivas.getSelectedRow();
    
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una especialidad de la tabla para reactivar", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro que desea reactivar esta especialidad?", 
                "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {
            try {
                String id = tblInactivas.getValueAt(fila, 0).toString();

                service.reactivar(id); 

                JOptionPane.showMessageDialog(this, "¡Especialidad reactivada con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                listarInactivos(); 

            } catch (Exception e) {

                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error de Sistema", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnReactivarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DlgEspecialiadesInactivas dialog = new DlgEspecialiadesInactivas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReactivar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblInactivas;
    // End of variables declaration//GEN-END:variables
}
