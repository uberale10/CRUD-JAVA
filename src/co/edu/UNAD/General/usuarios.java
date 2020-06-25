/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.UNAD.General;

import java.awt.HeadlessException;
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
public class usuarios extends javax.swing.JFrame {
    
    Connection util = Conexion.getConexion();  // llamamos la conexion

    public usuarios() {
        initComponents();
        
        this.setLocationRelativeTo(null);// codigo para que inicien en el centro
        jComboSelect.removeAllItems(); //borra el listado de Item que trae el combobox por defecto (para dejar solo los de la base de datos)
        setResizable(false); // evita el cambio de tamaño del formulario (Desactivar botón maximizar)
        llenarItem(); // llamado de metodo de llenar roles
        llenarTabla(); // llamado de metodo de llenar tabla
    }

    // metodo para limpiar las cajas de texto
    private void LimpiarCaja() {
        txtIdentificacion.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");    
    }
    
    // metodo para llenar tabla con datos de la base de datos
     private void llenarTabla() {
        String[] TituloTabla = {"Identificacion", "Nombre", "Fecha Nacimiento ", "Telefono", "Direccion", "Rol"};
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(TituloTabla);

        try {
            String sqlSelect = "SELECT e.idempleado,e.nombre,e.fechaNacimiento,e.telefono,e.direccion,r.rol FROM empleado e INNER JOIN roles r on r.id = e.idrol";
            PreparedStatement pstm = util.prepareStatement(sqlSelect);
            ResultSet datos = pstm.executeQuery();
            Object[] registro = new Object[6];
            while (datos.next()) {
                registro[0] = datos.getString("idempleado");
                registro[1] = datos.getString("nombre");
                registro[2] = datos.getString("fechaNacimiento");
                registro[3] = datos.getString("telefono");
                registro[4] = datos.getString("direccion");
                registro[5] = datos.getString("r.rol");
                modelo.addRow(registro);
            }
            jTable1.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Informacion Error", 0);
        }

    }
         // codigo para seleccionar los roles y cargarlos en combo box
    private void llenarItem() {
        try {
            String sqlSelect = "SELECT * FROM roles";
            PreparedStatement pstm = util.prepareStatement(sqlSelect);
            ResultSet datos = pstm.executeQuery();
            while (datos.next()) {
                jComboSelect.addItem(datos.getString("id")+" - "+datos.getString("rol"));
            }
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Informacion Error", 0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jComboSelect = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Nombre Completo ");

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

        jLabel5.setText("Telefono");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Direccion");

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
                jTable1Seleccionar(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setText("Rol");

        jComboSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Fecha Nacimiento");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("REGISTRO DE EMPLEADOS");

        jLabel2.setText("Identificacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(btnRegistrar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btnActualizar)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
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
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jComboSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnActualizar)
                            .addComponent(jButton2)))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // codigo del boton de registar usuarios
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = dcn.format(jDateChooser1.getDate());
        
        String separador = (String) jComboSelect.getSelectedItem().toString();
        String[] SepararCadena = separador.split(" - ");
        int informacionRol = Integer.parseInt(SepararCadena[0]);
        
        try {
            String sqlInsert = "INSERT INTO empleado  VALUES (?,?,?,?,?,?)";
            PreparedStatement pstm = util.prepareStatement(sqlInsert);
            pstm.setString(1, txtIdentificacion.getText());
            pstm.setString(2, txtNombre.getText());
            pstm.setString(3, fechaActual);
            pstm.setString(4, txtTelefono.getText());
            pstm.setString(5, txtDireccion.getText());
            pstm.setInt(6, informacionRol);
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Agregado Satisfactoriamente");
            LimpiarCaja();
            llenarTabla();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Error " + e.getMessage(), "Informacion del Error", 0);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed
    // codigo del boton de eliminar usuarios
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        boolean hayResultado = false;
        int resulCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su identificacion", "Informacion Unica", 3));
        String sqlSelect = "SELECT * FROM empleado WHERE idempleado = ?";
        String sqlDelete = "DELETE FROM empleado WHERE idempleado = ?";
        try {
            PreparedStatement pstm = util.prepareStatement(sqlSelect);
            PreparedStatement pstmDelete = util.prepareStatement(sqlDelete);
            pstm.setInt(1, resulCliente);
            ResultSet datos = pstm.executeQuery();

            while (datos.next()) {
                hayResultado = true;
                break;
            }

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

     // codigo del boton de actualizar usuarios
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String sqlUpdate = "UPDATE empleado set nombre=?, fechaNacimiento=?,  telefono=?, direccion=?, idrol=? WHERE idempleado = ?";
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = dcn.format(jDateChooser1.getDate());
        
        String separador = (String) jComboSelect.getSelectedItem().toString();
        String[] SepararCadena = separador.split(" - ");
        int informacionRol = Integer.parseInt(SepararCadena[0]);
        
        try {
            PreparedStatement pstmUpdate = util.prepareStatement(sqlUpdate);
            pstmUpdate.setString(1, txtNombre.getText());
            pstmUpdate.setString(2, fechaActual);
            pstmUpdate.setString(3, txtTelefono.getText());
            pstmUpdate.setString(4, txtDireccion.getText());
            pstmUpdate.setInt(5, informacionRol);
            pstmUpdate.setString(6, txtIdentificacion.getText());
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

    private void jTable1Seleccionar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1Seleccionar
        try {
            int fila = jTable1.getSelectedRow();
            txtIdentificacion.setText(String.valueOf(jTable1.getValueAt(fila, 0).toString()));
            txtNombre.setText(String.valueOf(jTable1.getValueAt(fila, 1).toString()));
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)jTable1.getValueAt(fila, 2));
            jDateChooser1.setDate(date);
            txtTelefono.setText(String.valueOf(jTable1.getValueAt(fila, 3).toString()));
            txtDireccion.setText(String.valueOf(jTable1.getValueAt(fila, 4).toString()));
            jComboSelect.setSelectedItem(String.valueOf(jTable1.getValueAt(fila, 5).toString()));
            txtIdentificacion.setEnabled(false);

        } catch (ParseException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1Seleccionar

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
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboSelect;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
