/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eduar
 */
public class GestorEstudiantes extends javax.swing.JFrame {
    DefaultTableModel modelo = new DefaultTableModel();
    
    /**
     * Creates new form Estudiantes
     */
    Integer  fila;

    /**
     * Creates new form GestorEstudiantes
     */
    public GestorEstudiantes() {
        initComponents();
        CargarTextosdeTabla();
        cargarTablaEstudiantes();
        bloquearTextos();
        bloquearBotones();
    }
    public void LimpiarTextos(){
    jTxtCedula.setText("");
    jTxtNombre.setText("");
    jTxtApellido.setText("");
    jTxtCorreo.setText("");
    jTxtContraseña.setText("");
    jTxtNota.setText("");
    }
    public void bloquearTextos(){
        jTxtCedula.setEnabled(false);
        jTxtNombre.setEnabled(false);
        jTxtApellido.setEnabled(false);
        jTxtCorreo.setEnabled(false);
        jTxtContraseña.setEnabled(false);
        jTxtNota.setEnabled(false);
    }
    public void bloquearBotones(){
        BtnNuevo.setEnabled(true);
        BtnGuardar.setEnabled(false);
        BtnActualizar.setEnabled(false);
        BtnEliminar.setEnabled(false);
        BtnCancelar.setEnabled(false);
        BtnEnviar.setEnabled(false);
        BtnCalificar.setEnabled(false);
    }
    public void DesbloquearBotonesNuevo(){
        BtnNuevo.setEnabled(false);
        BtnGuardar.setEnabled(true);
        BtnActualizar.setEnabled(false);
        BtnEliminar.setEnabled(false);
        BtnCancelar.setEnabled(true);
        BtnEnviar.setEnabled(false);
        BtnCalificar.setEnabled(false);
        
    }
    public void DesbloquearBotonesEditar(){
        BtnNuevo.setEnabled(false);
        BtnGuardar.setEnabled(false);
        BtnActualizar.setEnabled(true);
        BtnEliminar.setEnabled(true);
        BtnCancelar.setEnabled(true);
        BtnCalificar.setEnabled(true);
        BtnNuevo.setEnabled(false);
    }
    public void DesbloquearBotonesCalificar(){
        BtnNuevo.setEnabled(false);
        BtnGuardar.setEnabled(false);
        BtnActualizar.setEnabled(false);
        BtnEliminar.setEnabled(false);
        BtnCancelar.setEnabled(true);
        BtnEnviar.setEnabled(true);
    }
     public void DesbloquearTextos(){
        jTxtCedula.setEnabled(true);
        jTxtNombre.setEnabled(true);
        jTxtApellido.setEnabled(true);
        jTxtCorreo.setEnabled(true);
        jTxtContraseña.setEnabled(true);
        jTxtNota.setEnabled(false);
        
        
     }
     public void DesbloquearTextosEditar(){
        jTxtCedula.setEnabled(false);
        jTxtNombre.setEnabled(true);
        jTxtApellido.setEnabled(true);
         jTxtCorreo.setEnabled(true);
        jTxtContraseña.setEnabled(true);
        jTxtNota.setEnabled(false);
     }
      public void DesbloquearTextosCalificar(){
        jTxtCedula.setEnabled(false);
        jTxtNombre.setEnabled(false);
        jTxtApellido.setEnabled(false);
         jTxtCorreo.setEnabled(false);
        jTxtContraseña.setEnabled(false);
        jTxtNota.setEnabled(true);
     }
      
public void Calificar(){
        
          try {  
            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            String sql = "";
            switch (jTxtNota.getText()) {
                 case "":
                      sql="Update tablaestudiantes set nota='S/N' "
                              + "where cedula='" + jTxtCedula.getText() + "';";
                      cargarTablaEstudiantes();
                      break;
                  case "Aprobado":
                      sql="Update tablaestudiantes set nota='" + jTxtNota.getText() + "' "
                              + "where cedula='" + jTxtCedula.getText() + "';";
                      cargarTablaEstudiantes();
                      break;
                  case "Reprobado":
                      sql="Update tablaestudiantes set nota='" + jTxtNota.getText() + "' "
                              + "where cedula='" + jTxtCedula.getText() + "';";
                      cargarTablaEstudiantes();
                      break;
                  case "Supletorio":
                      sql="Update tablaestudiantes set nota='" + jTxtNota.getText() + "' "
                              + "where cedula='" + jTxtCedula.getText() + "';";
                      cargarTablaEstudiantes();
                      break;
                  default:
                      JOptionPane.showMessageDialog(rootPane, "Se debe ingresar: Aprobado,Reprobado o Supletorio");
                      LimpiarTextos();
                      break;
              }
            
            PreparedStatement psd = cn.prepareStatement(sql);
            
            int n = psd.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null,"Se ingreso correctamente el resultado final del curso");
                cargarTablaEstudiantes();
                LimpiarTextos();
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dato mal ingresado");
        }
         
        
      }
    
     public void CargarTextosdeTabla(){
      jTblEstudiantes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jTblEstudiantes.getSelectedRow() != -1) {
		int fila = jTblEstudiantes.getSelectedRow();
                jTxtCedula.setText(jTblEstudiantes.getValueAt(fila, 0).toString().trim());
                jTxtNombre.setText(jTblEstudiantes.getValueAt(fila, 1).toString().trim());
                jTxtApellido.setText(jTblEstudiantes.getValueAt(fila,2).toString().trim());
                jTxtCorreo.setText(jTblEstudiantes.getValueAt(fila,3).toString().trim());
                jTxtContraseña.setText(jTblEstudiantes.getValueAt(fila,4).toString().trim());
                jTxtNota.setText(jTblEstudiantes.getValueAt(fila,5).toString().trim());
                DesbloquearBotonesEditar();
                DesbloquearTextosEditar();
                }
            }
        });
 }
    public void InsertarDato(){
    String valorNota ="S/N";
    if(jTxtCedula.getText().isEmpty() || jTxtCedula.getText()=="")
    {
        JOptionPane.showMessageDialog(null,"Debe ingresar una cedula");
        jTxtCedula.requestFocus();
    }
    else if(jTxtNombre.getText().isEmpty() || jTxtNombre.getText()=="")
    {
        
        jTxtNombre.requestFocus();JOptionPane.showMessageDialog(null,"Debe ingresar un nombre");
    }
    else if(jTxtApellido.getText().isEmpty() || jTxtApellido.getText()=="")
    {
        JOptionPane.showMessageDialog(null,"Debe ingresar un correo");
        jTxtApellido.requestFocus();
    }
      else if(jTxtCorreo.getText().isEmpty() || jTxtCorreo.getText()=="")
    {
        JOptionPane.showMessageDialog(null,"Debe ingresar una cedula");
        jTxtCorreo.requestFocus();
    } else if(jTxtContraseña.getText().isEmpty() || jTxtContraseña.getText()=="")
    {
        JOptionPane.showMessageDialog(null,"Debe ingresar una contraseña");
        jTxtContraseña.requestFocus();
    }
      else {
        
                
        try {
            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            String sql="";
            sql="insert into tablaestudiantes(cedula,nombre,apellido,correo,contraseña,nota)values(?,?,?,?,?,?)";
            PreparedStatement psd = cn.prepareStatement(sql); 
            psd.setString(1, jTxtCedula.getText());
            psd.setString(2, jTxtNombre.getText());
            psd.setString(3, jTxtApellido.getText());
            psd.setString(4, jTxtCorreo.getText());
             psd.setString(5, jTxtContraseña.getText());
            if(jTxtNota.getText().isEmpty() || jTxtNota.getText()==" "){
                psd.setString(6,valorNota);
            }else{
            psd.setString(6, jTxtNota.getText());
            }
           
            
            int n =  psd.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null, "SE GUARDO CORRECTAMENTE");
                    bloquearBotones();
                    bloquearTextos();
                    LimpiarTextos();
                    cargarTablaEstudiantes();
            }
                    
                    } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);}
       
    
    }
    
}
    
    
    public void cargarTablaEstudiantes()    {
        try {
            String[] titulos = { "Cedula","Apellido","Nombre","Correo","Contraseña","Nota"};
            String [] registros = new String[6];
            modelo = new DefaultTableModel(null,titulos);
            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            String sql="";
            sql="select * from tablaestudiantes";
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while(rs.next()){
                registros[0]=rs.getString("cedula");
                registros[1]=rs.getString("nombre");
                registros[2]=rs.getString("apellido");
                registros[3]=rs.getString("correo");
                registros[4]=rs.getString("contraseña");
                registros[5]=rs.getString("nota");
                modelo.addRow(registros);
            }
            jTblEstudiantes.setModel(modelo);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            
             }
        
}
public void Eliminar(){
      if(JOptionPane.showConfirmDialog(new JInternalFrame(),"Estas seguro de borrar el registro?","Borrar registros",JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION)
        {
        try {
            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            String sql = "";
            sql="delete from tablaestudiantes where cedula='"+jTxtCedula.getText()+"'";
            PreparedStatement psd =cn.prepareStatement(sql);
            int n = psd.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null, "Se elimino correctamente");
                LimpiarTextos();
                cargarTablaEstudiantes();
                
                
            }
            
            // TODO add your handli33ng code here:
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
}

    public void ActualizarEstudiante(){
        String valorTelefono ="S/N";
     if(jTxtNombre.getText().isEmpty() || "".equals(jTxtNombre.getText()))
    {
        
        jTxtNombre.requestFocus();JOptionPane.showMessageDialog(null,"Debe ingresar un nombre");
    }
    else if(jTxtApellido.getText().isEmpty() || "".equals(jTxtApellido.getText()))
    {
        JOptionPane.showMessageDialog(null,"Debe ingresar una cedula");
        jTxtApellido.requestFocus();
    }
      else if(jTxtCorreo.getText().isEmpty() || "".equals(jTxtCorreo.getText()))
    {
        JOptionPane.showMessageDialog(null,"Debe ingresar una cedula");
        jTxtCorreo.requestFocus();
    }
        else if(jTxtContraseña.getText().isEmpty() || "".equals(jTxtContraseña.getText()))
    {
        JOptionPane.showMessageDialog(null,"Debe ingresar una cedula");
        jTxtContraseña.requestFocus();
    }
      else {
        
          try {  
            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            String sql = "";
            sql="Update tablaestudiantes set nombre='" + jTxtNombre.getText() + "', "
				+ "apellido ='" + jTxtApellido.getText() + "', "
				+ "correo='" + jTxtCorreo.getText() + "', "
                                + "contraseña='" + jTxtContraseña.getText() + "', "
				+ "nota='" + jTxtNota.getText() + "' "
				+ "where cedula='" + jTxtCedula.getText() + "';";
            PreparedStatement psd = cn.prepareStatement(sql);
            
            int n = psd.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null,"Se actualizo correctamemte");
                cargarTablaEstudiantes();
                LimpiarTextos();
                
            }
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,ex);
        }
         
        
      }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTxtCedula = new javax.swing.JTextField();
        jTxtNombre = new javax.swing.JTextField();
        jTxtApellido = new javax.swing.JTextField();
        jTxtCorreo = new javax.swing.JTextField();
        jTxtContraseña = new javax.swing.JTextField();
        jTxtNota = new javax.swing.JTextField();
        BtnEnviar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BtnNuevo = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        BtnActualizar = new javax.swing.JButton();
        BtnCalificar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblEstudiantes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Cedula:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido");

        jLabel4.setText("Correo");

        jLabel5.setText("Contraseña");

        jLabel6.setText("Ressultado");

        jTxtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCedulaActionPerformed(evt);
            }
        });

        jTxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNombreActionPerformed(evt);
            }
        });

        BtnEnviar.setText("ENVIAR");
        BtnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnviarActionPerformed(evt);
            }
        });

        jLabel7.setText("del curso;");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(jTxtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(35, 35, 35)
                        .addComponent(jTxtApellido))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(41, 41, 41)
                        .addComponent(jTxtCorreo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addComponent(jTxtCedula))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtContraseña)
                            .addComponent(jTxtNota))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnEnviar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTxtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnEnviar))
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        BtnNuevo.setText("NUEVO");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });

        BtnGuardar.setText("GUARDAR");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        BtnActualizar.setText("EDITAR");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });

        BtnCalificar.setText("CALIFICAR");
        BtnCalificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCalificarActionPerformed(evt);
            }
        });

        BtnCancelar.setText("CANCELAR");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        BtnEliminar.setText("ELIMINAR");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BtnCalificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnCalificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnCancelar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );

        jTblEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTblEstudiantes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCedulaActionPerformed

    private void jTxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtNombreActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
    InsertarDato();
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        Eliminar();
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        ActualizarEstudiante();
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnActualizarActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
      DesbloquearTextos();
      DesbloquearBotonesNuevo();
      
      
      
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnCalificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCalificarActionPerformed
DesbloquearBotonesCalificar();     
DesbloquearTextosCalificar();
    }//GEN-LAST:event_BtnCalificarActionPerformed

    private void BtnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnviarActionPerformed
    Calificar();
    bloquearTextos();
    bloquearBotones();
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnEnviarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
bloquearTextos();
        bloquearBotones();
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(GestorEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestorEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestorEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestorEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestorEstudiantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnCalificar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnEnviar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblEstudiantes;
    private javax.swing.JTextField jTxtApellido;
    private javax.swing.JTextField jTxtCedula;
    private javax.swing.JTextField jTxtContraseña;
    private javax.swing.JTextField jTxtCorreo;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JTextField jTxtNota;
    // End of variables declaration//GEN-END:variables
}
