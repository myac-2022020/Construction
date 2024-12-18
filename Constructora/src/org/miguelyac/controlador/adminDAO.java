/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.miguelyac.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.miguelyac.db.Conexion;
import org.miguelyac.modelo.LoginAdmin;

/**
 *
 * @author santiago
 */
public class adminDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public LoginAdmin log(String correo_admin, String pass_admin){
        LoginAdmin l = new LoginAdmin();
        String sql = "SELECT * FROM tbl_usuarioAdmin WHERE correo_admin = ? AND pass_admin = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo_admin);
            ps.setString(2, pass_admin);
            rs = ps.executeQuery();
            if(rs.next()){
                l.setId_admin(rs.getInt("id_admin"));
                l.setNombre_admin(rs.getString("nombre_admin"));
                l.setCorreo_admin(rs.getString("correo_admin"));
                l.setPass_admin(rs.getString("pass_admin"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return l;
    }
    public boolean RegistrarUsuarioAdmin(LoginAdmin log){
        String sql = "INSERT INTO tbl_usuarioAdmin(nombre_admin, correo_admin, pass_admin) values (?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, log.getNombre_admin());
            ps.setString(2, log.getCorreo_admin());
            ps.setString(3, log.getPass_admin());
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        } 
    }
    public List ListarAdmin(){
        List<LoginAdmin> ListarAdmin = new ArrayList();
        String sql = "SELECT * FROM tbl_usuarioAdmin";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                LoginAdmin log = new LoginAdmin();
                log.setId_admin(rs.getInt("id_admin"));
                log.setNombre_admin(rs.getString("nombre_admin"));
                log.setCorreo_admin(rs.getString("correo_admin"));
                log.setPass_admin(rs.getString("pass_admin"));
                ListarAdmin.add(log);
            }
        }catch(SQLException error){
            System.out.println(error.toString());
        }
        return ListarAdmin;
    }
    public boolean EliminarAdmin(int id_admin){
        String sql = "DELETE FROM tbl_usuarioAdmin WHERE id_admin = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_admin);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
               con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    public boolean ModificarUsuario(LoginAdmin ad) {
       String sql = "UPDATE tbl_usuarioAdmin SET nombre_admin=?,correo_admin=?,pass_admin=? WHERE id_admin=?";
       try {
           ps = con.prepareStatement(sql);   
           ps.setString(1, ad.getNombre_admin());
           ps.setString(2, ad.getCorreo_admin());
           ps.setString(3, ad.getPass_admin());
           ps.setInt(4, ad.getId_admin());
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }finally{
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e.toString());
           }
       }
    }
}
