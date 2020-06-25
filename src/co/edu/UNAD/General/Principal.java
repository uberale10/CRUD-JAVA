/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.UNAD.General;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author uber
 */
public class Principal extends javax.swing.JFrame {

    Connection util = Conexion.getConexion();  

    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);// codigo para que inicien en el centro
        setResizable(false);
        llenarTabla();
    }
                     // metodo para llenar la tablas que guardaran los datos de los usuarios
    private void llenarTabla() {
        String[] TituloTabla = {"Identificacion", "Nombre", "Fecha Nacimiento ", "Telefono", "Direccion"};
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(TituloTabla);
        try {
            String sqlSelect = "SELECT * FROM usuarios";
            PreparedStatement pstm = util.prepareStatement(sqlSelect);
            ResultSet datos = pstm.executeQuery();
            Object[] registro = new Object[5]; 
            while (datos.next()) {
                registro[0] = datos.getString("id");
                registro[1] = datos.getString("nombre");
                registro[2] = datos.getString("fechaNacimiento");
                registro[3] = datos.getString("telefono");
                registro[4] = datos.getString("direccion");
                modelo.addRow(registro);
            }
            jTable1.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Informacion Error", 0);
        }

    }

   // metodo para limpiar las cajas de texto
    private void LimpiarCaja() {
        txtIdentificacion.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("REGISTRO DE CLIENTES");

        jLabel2.setText("Identificacion");

        jLabel3.setText("Nombre Completo ");

        jLabel5.setText("Telefono");

        jLabel6.setText("Direccion");

        btnRegistrar.setText("Agregar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Seleccionar(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel8.setText("Fecha Nacimiento");

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnRegistrar)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnActualizar)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnRegistrar)
                                    .addComponent(btnActualizar)
                                    .addComponent(jButton2)))
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = dcn.format(jDateChooser1.getDate());
        try {
            String sqlInsert = "INSERT INTO usuarios  VALUES (?,?,?,?,?,?)";
            PreparedStatement pstm = util.prepareStatement(sqlInsert);
            pstm.setString(1, txtIdentificacion.getText());
            pstm.setString(2, txtNombre.getText());
            pstm.setString(3, fechaActual);
            pstm.setString(4, txtTelefono.getText());
            pstm.setString(5, txtDireccion.getText());
            pstm.setString(6, "4");
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Agregado Satisfactoriamente");
            LimpiarCaja();
            llenarTabla();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error " + ex.getMessage(), "Informacion del Error", 0);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    // BOTON DE ELIMINAR REGISTRO
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        boolean hayResultado = false;
        int resulCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su identificacion", "Informacion Unica", 3));
        String sqlSelect = "SELECT * FROM usuarios WHERE id = ?";
        String sqlDelete = "DELETE FROM usuarios WHERE id = ?";
        try {
            PreparedStatement pstm = util.prepareStatement(sqlSelect);
            PreparedStatement pstmDelete = util.prepareStatement(sqlDelete);           
            pstm.setInt(1, resulCliente);
            ResultSet datos = pstm.executeQuery();
            while (datos.next()) {
                hayResultado = true;
                break;
            }
            // CONFIRMACION DE ELIMINACION DE REGISTRO
            if (hayResultado) {
                int confirmacion = JOptionPane.showConfirmDialog(null,
                        "Desea Eliminarlo?", "Seleccione", JOptionPane.YES_NO_OPTION);
                if (confirmacion == 0) {
                    pstmDelete.setInt(1, resulCliente);
                    pstmDelete.executeUpdate();
                     JOptionPane.showMessageDialog(null, "Registro Eliminado satisfactoriamente","Informe",1);
                     llenarTabla();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro", "Informe", 0);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
    // EVENTO AL PRECIONAR UN REGISTRO EN LA TABLA PARA GARGARLO EN LAS CAJAS DE TEXTO
    private void Seleccionar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Seleccionar
        try {
            int fila = jTable1.getSelectedRow();
            txtIdentificacion.setText(String.valueOf(jTable1.getValueAt(fila, 0).toString()));
            txtNombre.setText(String.valueOf(jTable1.getValueAt(fila, 1).toString()));
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)jTable1.getValueAt(fila, 2));
            jDateChooser1.setDate(date);
            txtTelefono.setText(String.valueOf(jTable1.getValueAt(fila, 3).toString()));
            txtDireccion.setText(String.valueOf(jTable1.getValueAt(fila, 4).toString()));
            txtIdentificacion.setEnabled(false);
            
        } catch (ParseException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Seleccionar

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String sqlUpdate = "UPDATE usuarios set nombre=?, fechaNacimiento=?, telefono=?, direccion=?, idRol=4 WHERE id = ?";
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = dcn.format(jDateChooser1.getDate());
        try {
            PreparedStatement pstmUpdate = util.prepareStatement(sqlUpdate);
            pstmUpdate.setString(1, txtNombre.getText());
            pstmUpdate.setString(2, fechaActual);
            pstmUpdate.setString(3, txtTelefono.getText());
            pstmUpdate.setString(4, txtDireccion.getText());
            pstmUpdate.setString(5, txtIdentificacion.getText());
            pstmUpdate.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registro Actualizado Correctamente","Informacion",1);
            llenarTabla();
            LimpiarCaja();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         new menu().setVisible(true); // este codigo es para mostar el formulario de usuarios
         this.setVisible(false);    // este codigo desaparece el formulario actual        
    }//GEN-LAST:event_jButton1ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
