package javaapplication2.VIEW.EmpladoEspecialidades;

import java.util.List;
import javaapplication2.MODEL.EmpleadoEspecialidad;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class DlgAsignacionesInactivas extends javax.swing.JDialog {
    
    private javaapplication2.SERVICE.EmpleadoEspecialidadService service = new javaapplication2.SERVICE.EmpleadoEspecialidadService();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DlgAsignacionesInactivas.class.getName());

    public DlgAsignacionesInactivas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.getContentPane().setBackground(new java.awt.Color(255, 240, 245));
        btnReactivar.setBackground(java.awt.Color.WHITE);
        
        listarInactivos();
    }
    
    //LISTAR INACTIVOS
    private void listarInactivos() {
        DefaultTableModel modelo = (DefaultTableModel) tblAnterior.getModel();
        modelo.setRowCount(0); // Limpia la tabla antes de cargar

        // Llamamos al service que creamos antes
        List<EmpleadoEspecialidad> lista = service.listarInactivos(); 

        for (EmpleadoEspecialidad ee : lista) {
            Object[] fila = {
                ee.getIdEmpleadoEspecialidad(),
                ee.getIdEmpleado(), 
                ee.getIdEspecialidad(),
                ee.getEstado()};
            modelo.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTittle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAnterior = new javax.swing.JTable();
        btnReactivar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTittle.setFont(new java.awt.Font("Garamond", 1, 16)); // NOI18N
        lblTittle.setText("Antiguas asignaciones");

        tblAnterior.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblAnterior);

        btnReactivar.setFont(new java.awt.Font("Garamond", 1, 13)); // NOI18N
        btnReactivar.setText("Reactivar");
        btnReactivar.addActionListener(this::btnReactivarActionPerformed);

        btnRegresar.setFont(new java.awt.Font("Garamond", 1, 13)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(this::btnRegresarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTittle)
                .addGap(183, 183, 183))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReactivar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTittle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReactivar)
                    .addComponent(btnRegresar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //REGRESAR
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    //REACTIVAR
    private void btnReactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReactivarActionPerformed
        // TODO add your handling code here:
        int fila = tblAnterior.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para reactivar");
            return;
        }

        // Mensaje de confirmación
        int respuesta = JOptionPane.showConfirmDialog(this,
            "¿Está seguro que desea reactivar esta fila?",
            "Confirmación", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
                String id = tblAnterior.getValueAt(fila, 0).toString();

            // Llamamos al service para que cambie el estado a 'ACTIVA'
            if (service.reactivar(id)) {
                JOptionPane.showMessageDialog(this, "¡Fila reactivada con éxito!");
                listarInactivos(); // Refrescamos esta tabla (ahora la fila desaparecerá de aquí)
            } else {
                JOptionPane.showMessageDialog(this, "Error al reactivar");
            }
        }
    }//GEN-LAST:event_btnReactivarActionPerformed

    //USAR FLATLAF
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
    private javax.swing.JButton btnReactivar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTittle;
    private javax.swing.JTable tblAnterior;
    // End of variables declaration//GEN-END:variables
}
