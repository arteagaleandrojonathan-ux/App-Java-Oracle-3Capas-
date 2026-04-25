package javaapplication2.VIEW.Empleados;

import java.util.List;
import javaapplication2.MODEL.Empleado;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class DlgEmpleadosInactivos extends javax.swing.JDialog {
    
    private javaapplication2.SERVICE.EmpleadoService service = new javaapplication2.SERVICE.EmpleadoService();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DlgEmpleadosInactivos.class.getName());

    public DlgEmpleadosInactivos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listarInactivos();
        
        this.getContentPane().setBackground(new java.awt.Color(255, 240, 245));
        btnReactivar.setBackground(java.awt.Color.WHITE);
    }
    
    private void listarInactivos() {
        DefaultTableModel modelo = (DefaultTableModel) tblListarInac.getModel();
        modelo.setRowCount(0); // Limpia la tabla antes de cargar

        // Llamamos al service que creamos antes
        List<Empleado> lista = service.listarInactivos(); 

        for (Empleado e : lista) {
            Object[] fila = {
                e.getIdEmpleado(), 
                e.getTipoDOI(),
                e.getNumDOI(),
                e.getApePaterno(),
                e.getApeMaterno(),
                e.getNombres(),
                e.getEmail(),
                e.getTelefono(),
                e.getTelefonoEmergencia(),
                e.getEstado()};
            modelo.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnReactivar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListarInac = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        jLabel1.setText("Empleados Inactivos:");

        btnReactivar.setText("Reactivar");
        btnReactivar.addActionListener(this::btnReactivarActionPerformed);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(this::btnRegresarActionPerformed);

        tblListarInac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IDEMPLEADO", "TIPO DOI", "NÚMERO DOI", "APE PATERNO", "APE MATERNO", "NOMBRES", "EMAIL", "TELEFONO", "TELEFONO EMER", "ESTADO"
            }
        ));
        jScrollPane2.setViewportView(tblListarInac);

        jScrollPane3.setViewportView(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnReactivar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegresar)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnReactivar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnRegresar)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReactivarActionPerformed
       int fila = tblListarInac.getSelectedRow();

    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un empleado para reactivar");
        return;
    }

    int respuesta = JOptionPane.showConfirmDialog(this,
        "¿Está seguro que desea reactivar a este empleado?",
        "Confirmación", JOptionPane.YES_NO_OPTION);

    if (respuesta == JOptionPane.YES_OPTION) {
        String id = tblListarInac.getValueAt(fila, 0).toString();

        try {
            if (service.reactivar(id)) {
                JOptionPane.showMessageDialog(this, "¡Empleado reactivado con éxito!");
                listarInactivos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    }//GEN-LAST:event_btnReactivarActionPerformed
    
    /*REGRESAR*/
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
                DlgEmpleadosInactivos dialog = new DlgEmpleadosInactivos(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblListarInac;
    // End of variables declaration//GEN-END:variables
}
