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
import org.miguelyac.modelo.Login;

/**
 *
 * @author santiago
 */
public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public Login log(String correo, String pass){
        Login l = new Login();
        String sql = "SELECT * FROM tbl_usuario WHERE correo = ? AND pass = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if(rs.next()){
                l.setId_usuario(rs.getInt("id_usuario"));
                l.setNombre(rs.getString("nombre"));
                l.setCorreo(rs.getString("correo"));
                l.setPass(rs.getString("pass"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return l;
    }
    public boolean RegistrarUsuario(Login log){
        String sql = "INSERT INTO tbl_usuario(nombre, correo, pass) values (?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, log.getNombre());
            ps.setString(2, log.getCorreo());
            ps.setString(3, log.getPass());
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
    public List ListarUsuarios(){
        List<Login> ListaUS = new ArrayList();
        String sql = "SELECT * FROM tbl_usuario";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Login lg = new Login();
                lg.setId_usuario(rs.getInt("id_usuario"));
                lg.setNombre(rs.getString("nombre"));
                lg.setCorreo(rs.getString("correo"));
                lg.setPass(rs.getString("pass"));
                ListaUS.add(lg);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaUS;
    }
    public boolean EliminarUsuario(int id_usuario){
        String sql = "DELETE FROM tbl_usuario WHERE id_usuario = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_usuario);
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

    public boolean ModificarUsuario(Login lg) {
       String sql = "UPDATE tbl_usuario SET nombre=?,correo=?,pass=? WHERE id_usuario=?";
       try {
           ps = con.prepareStatement(sql);   
           ps.setString(1, lg.getNombre());
           ps.setString(2, lg.getCorreo());
           ps.setString(3, lg.getPass());
           ps.setInt(4, lg.getId_usuario());
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
    public Login buscarUsuario(String correo){
        Login log = new Login();
        String sql = "SELECT * FROM tbl_usuario WHERE correo= ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            if(rs.next()){
                log.setId_usuario(rs.getInt("id_usuario"));
                log.setNombre(rs.getString("nombre"));
                log.setPass(rs.getString("pass"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return log;
    }
}
