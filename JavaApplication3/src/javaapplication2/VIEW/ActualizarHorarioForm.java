
package javaapplication2.VIEW;

import javaapplication2.SERVICE.HorarioService;
import javaapplication2.MODEL.Horarios;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.Time;

public class ActualizarHorarioForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ActualizarHorarioForm.class.getName());

    private String idHorario;
    private final HorarioService service = new HorarioService();

    public ActualizarHorarioForm(String idHorario) {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        getContentPane().setBackground(new java.awt.Color(245, 248, 250));
        jButton1.setBackground(new java.awt.Color(144, 238, 144));
        jButton1.setForeground(java.awt.Color.BLACK);
        jButton1.setFocusPainted(false);
        jButton2.setBackground(new java.awt.Color(255, 182, 193));
        jButton2.setForeground(java.awt.Color.BLACK);
        jButton2.setFocusPainted(false);

        jComboBox1.setBackground(java.awt.Color.WHITE);
        jSpinner1.setBackground(java.awt.Color.WHITE);
        jSpinner2.setBackground(java.awt.Color.WHITE);

        jSpinner1.setModel(new javax.swing.SpinnerDateModel());
        jSpinner1.setEditor(new javax.swing.JSpinner.DateEditor(jSpinner1, "HH:mm"));
        jSpinner2.setModel(new javax.swing.SpinnerDateModel());
        jSpinner2.setEditor(new javax.swing.JSpinner.DateEditor(jSpinner2, "HH:mm"));

        this.idHorario = idHorario;
        cargarDatos();
    }

    public ActualizarHorarioForm() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jSpinner1.setModel(new javax.swing.SpinnerDateModel());
        jSpinner1.setEditor(new javax.swing.JSpinner.DateEditor(jSpinner1, "HH:mm"));
        jSpinner2.setModel(new javax.swing.SpinnerDateModel());
        jSpinner2.setEditor(new javax.swing.JSpinner.DateEditor(jSpinner2, "HH:mm"));
    }

    private void cargarDatos() {
        List<Horarios> lista = service.listar();
        boolean encontrado = false;
        for (Horarios h : lista) {
            if (h.getidHorario().equals(idHorario)) {
                String dia = h.getDiaSemana() != null ? h.getDiaSemana().trim() : "";
                jComboBox1.setSelectedItem(dia);
                jSpinner1.setValue(new java.util.Date(h.getHoraInicio().getTime()));
                jSpinner2.setValue(new java.util.Date(h.getHoraFin().getTime()));
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(this,
                    "No se encontró el horario con ID: " + idHorario,
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void guardarCambios() {
        Object diaObj = jComboBox1.getSelectedItem();
        if (diaObj == null) {
            throw new IllegalStateException("Selecciona un día de la semana.");
        }
        String dia = diaObj.toString().trim();
        Time horaInicio = new Time(((java.util.Date) jSpinner1.getValue()).getTime());
        Time horaFin = new Time(((java.util.Date) jSpinner2.getValue()).getTime());
        if (horaFin.getTime() <= horaInicio.getTime()) {
            throw new IllegalStateException("La hora de salida debe ser posterior a la de entrada.");
        }

        service.actualizarDiaSemana(idHorario, dia);
        service.actualizarHoraInicio(idHorario, horaInicio);
        service.actualizarHoraFin(idHorario, horaFin);

        JOptionPane.showMessageDialog(this, "Horario actualizado correctamente.");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("QUE DESEA ACTUALIZAR");

        jLabel2.setText("DIA DE LA SEMANA");

        jLabel3.setText("HORA DE ENTRADA");

        jLabel4.setText("HORA DE SALIDA");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO" }));

        jButton1.setText("Actualizar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Salir");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            guardarCambios();
        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "Error al actualizar horario", e);
            JOptionPane.showMessageDialog(this, "Error al actualizar el horario.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ActualizarHorarioForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    // End of variables declaration//GEN-END:variables
}
