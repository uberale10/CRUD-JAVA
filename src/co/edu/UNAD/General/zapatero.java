
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

public class zapatero extends javax.swing.JFrame {
    
    Connection util = Conexion.getConexion(); // llamamos la conexion
    
    public zapatero() {
        initComponents();
        this.setLocationRelativeTo(null);// codigo para que inicien en el centro
        llenarTabla();
        jcRol.removeAllItems();
        jcZapatos.removeAllItems();
        jcUsuario.removeAllItems();
        llenarItemCliente();
        llenarItemZapatos();
        llenarempleado();
    }
    
    private void llenarItemCliente() {
        try {
            String sqlSelect = "SELECT * FROM usuarios";
            PreparedStatement pstm = util.prepareStatement(sqlSelect);
            ResultSet datos = pstm.executeQuery();
            
            while (datos.next()) {      
             jcUsuario.addItem(datos.getString("id") + " - " + datos.getString("nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error " + e.getMessage(), "Informacion del Error", 0);
        }
    }

    
    // trae los datos de los empleados (SE DEBE REVISAR DUPLICA A UN SOLO USUARIO)
    private void llenarempleado() {
        try {
          // String sqlSelect = "select rep.codigo, rep.fecha_reparacion , u.nombre ,e.nombre ,zap.tipo , rep.arreglo, rep.precio,rep.pago from empleado e inner join roles r on r.id = e.idrol inner join reparaciones rep on r.id = rep.idRol inner join usuarios u on u.id = rep.idUsuarios inner join zapatos zap on zap.codigo = rep.codZapatos ";

         // String sqlSelect = "SELECT r.id, nombre FROM empleado e inner join roles r on r.id = e.idrol inner join reparaciones rep on r.id = rep.codigo  ";
          
          
         String sqlSelect = "SELECT DISTINCT idempleado, nombre FROM empleado e inner join roles r on r.id = e.idrol inner join reparaciones rep on r.id = rep.idRol ";
         
          
           
         //String sqlSelect = "SELECT distinct r.id, nombre FROM empleado e inner join roles r on r.id = e.idrol inner join reparaciones rep on r.id = rep.idRol ";

            PreparedStatement pstm = util.prepareStatement(sqlSelect);
            ResultSet datos = pstm.executeQuery();
            while (datos.next()) {
                
                jcRol.addItem(datos.getString("idempleado") + " - " + datos.getString("nombre"));
               //jcRol.addItem(datos.getString("r.id") + " - " + datos.getString("nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error " + e.getMessage(), "Informacion del Error", 0);
        }
    }

    private void llenarItemZapatos() {
        try {
            String sqlSelect = "SELECT * FROM zapatos";
            PreparedStatement pstm = util.prepareStatement(sqlSelect);
            ResultSet datos = pstm.executeQuery();
            while (datos.next()) {
                jcZapatos.addItem(datos.getString("codigo") + " - " + datos.getString("tipo"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error " + e.getMessage(), "Informacion del Error", 0);
        }
    }

    // metodo para limpiar las cajas de texto
    private void LimpiarCaja() {
        texcodigo.setText("");
        textprecio.setText("");
        textipo.setText("");
        textpago.setText("");
    }

    // metodo para llenar tabla de los con los datos que estan en la base de datos
    private void llenarTabla() {
        String[] TituloTabla = {"Num-Factura", "Fecha Reparacion", "Cliente","Empleado", "Zapato", "Reparacion", "Precio","Pago / abono"}; //titulo de cada columna
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(TituloTabla);
        try {
            String sqlSelect = "SELECT * FROM reparaciones";
            //String sqlSelect = "select rep.codigo, rep.fecha_reparacion , u.nombre ,e.nombre ,zap.tipo , rep.arreglo, rep.precio,rep.pago from empleado e inner join roles r on r.id = e.idrol inner join reparaciones rep on r.id = rep.idRol inner join usuarios u on u.id = rep.idUsuarios inner join zapatos zap on zap.codigo = rep.codZapatos ";
            PreparedStatement pstm = util.prepareStatement(sqlSelect);
            ResultSet datos = pstm.executeQuery();
            Object[] registro = new Object[8];
            while (datos.next()) {
                registro[0] = datos.getString("codigo");
                registro[1] = datos.getString("fecha_reparacion");
                registro[2] = datos.getString("idUsuarios");
                registro[3] = datos.getString("idRol");
                registro[4] = datos.getString("codZapatos");
                registro[5] = datos.getString("arreglo");
                registro[6] = datos.getString("precio");
                registro[7] = datos.getString("pago");
                
                
                /*registro[0] = datos.getString("rep.codigo");
                registro[1] = datos.getString("rep.fecha_reparacion");
                registro[2] = datos.getString("e.nombre");
                registro[3] = datos.getString("u.nombre");
                registro[4] = datos.getString("zap.tipo");
                registro[5] = datos.getString("rep.arreglo");
                registro[6] = datos.getString("rep.precio");*/
                modelo.addRow(registro);
            }
            jTable1.setModel(modelo);
        } catch (SQLException e) {
            System.out.println(e.getMessage());   
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcRol = new javax.swing.JComboBox<>();
        jcZapatos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        texcodigo = new javax.swing.JTextField();
        textprecio = new javax.swing.JTextField();
        textipo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jcUsuario = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textpago = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jcRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcZapatos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Empleado");

        jLabel2.setText("zapato");

        jLabel8.setText("Fecha Reparacion");

        jLabel3.setText("Precio Reparacion");

        jLabel4.setText("tipo de reparacion");

        jLabel5.setText("codigo de reparacion");

        jLabel6.setText("Cliente");

        jcUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Agregar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Reparaciones de calzados");

        jLabel9.setText("Pago / Abono (Cliente)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcZapatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jButton1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(texcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textipo, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(textpago, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnRegistrar)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(texcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcZapatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnActualizar)
                    .addComponent(jButton2))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // carga la informacion de las tablas a las cajas de texto
    private void jTable1Seleccionar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1Seleccionar
        try {
            int fila = jTable1.getSelectedRow();
            texcodigo.setText(String.valueOf(jTable1.getValueAt(fila, 0).toString()));
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) jTable1.getValueAt(fila, 1));
            jDateChooser1.setDate(date);
            //jcEmpleados.setSelectedItem(String.valueOf(jTable1.getValueAt(fila, 3).toString()));
            //jcCliente.setSelectedItem(String.valueOf(jTable1.getValueAt(fila, 3).toString()));
            //jcZapatos.setSelectedItem(String.valueOf(jTable1.getValueAt(fila, 4).toString()));
            textipo.setText(String.valueOf(jTable1.getValueAt(fila, 5).toString()));
            textprecio.setText(String.valueOf(jTable1.getValueAt(fila, 6).toString()));
            textpago.setText(String.valueOf(jTable1.getValueAt(fila, 7).toString()));
            texcodigo.setEnabled(false);
        } catch (ParseException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1Seleccionar

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new menu().setVisible(true); // este codigo es para mostar el formulario del menu
        this.setVisible(false);    // este codigo desaparece el formulario actual
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = dcn.format(jDateChooser1.getDate());
        
        String separador = (String) jcUsuario.getSelectedItem().toString();
        String[] SepararCadena = separador.split(" - ");
        int informacionUsuario = Integer.parseInt(SepararCadena[0]);

        String separador2 = (String) jcRol.getSelectedItem().toString();
        String[] SepararCadena2 = separador2.split(" - ");
        int informacionRol = Integer.parseInt(SepararCadena2[0]);

        String separador3 = (String) jcZapatos.getSelectedItem().toString();
        String[] SepararCadena3 = separador3.split(" - ");
        int informacionzapatos = Integer.parseInt(SepararCadena3[0]);
       
        try {
            String sqlInsert = "INSERT INTO reparaciones  VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = util.prepareStatement(sqlInsert);
            pstm.setString(1, texcodigo.getText());
            pstm.setString(2, fechaActual);
            pstm.setInt(3, informacionUsuario);
            pstm.setInt(4, informacionRol);
            pstm.setInt(5, informacionzapatos);
            pstm.setString(6, textipo.getText());
            pstm.setString(7, textprecio.getText());
            pstm.setString(8, textpago.getText());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Agregado Satisfactoriamente");
            LimpiarCaja();
            llenarTabla();
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error " + ex.getMessage(), "Informacion del Error", 0);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String sqlUpdate = "UPDATE reparaciones set fecha_reparacion=?, idUsuarios=?,  idRol=?, codZapatos=?, arreglo=?, precio=?, pago=? WHERE codigo = ?";
        
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = dcn.format(jDateChooser1.getDate());

        String separador = (String) jcUsuario.getSelectedItem().toString();
        String[] SepararCadena = separador.split(" - ");
        int informacionempleado = Integer.parseInt(SepararCadena[0]);

        String separador2 = (String) jcRol.getSelectedItem().toString();
        String[] SepararCadena2 = separador2.split(" - ");
        int informacioncliente = Integer.parseInt(SepararCadena2[0]);

        String separador3 = (String) jcZapatos.getSelectedItem().toString();
        String[] SepararCadena3 = separador3.split(" - ");
        int informacionzapatos = Integer.parseInt(SepararCadena3[0]);

        try {
            PreparedStatement pstmUpdate = util.prepareStatement(sqlUpdate);
            pstmUpdate.setString(1, fechaActual);
            pstmUpdate.setInt(2, informacionempleado);
            pstmUpdate.setInt(3, informacioncliente);
            pstmUpdate.setInt(4, informacionzapatos);
            pstmUpdate.setString(5, textipo.getText());
            pstmUpdate.setString(6, textprecio.getText());
            pstmUpdate.setString(7, textpago.getText());
            pstmUpdate.setString(8, texcodigo.getText());
            
            pstmUpdate.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registro Actualizado Correctamente", "Informacion", 1);
            llenarTabla();
            LimpiarCaja();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        boolean hayResultado = false;
        int resulCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de factura", "Informacion Unica", 3));
        String sqlSelect = "SELECT * FROM reparaciones WHERE codigo = ?";
        String sqlDelete = "DELETE FROM reparaciones WHERE codigo = ?";
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
                    JOptionPane.showMessageDialog(null, "Registro Eliminado satisfactoriamente", "Informe", 1);
                    llenarTabla();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro", "Informe", 0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(zapatero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(zapatero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(zapatero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(zapatero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new zapatero().setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcRol;
    private javax.swing.JComboBox<String> jcUsuario;
    private javax.swing.JComboBox<String> jcZapatos;
    private javax.swing.JTextField texcodigo;
    private javax.swing.JTextField textipo;
    private javax.swing.JTextField textpago;
    private javax.swing.JTextField textprecio;
    // End of variables declaration//GEN-END:variables
}
