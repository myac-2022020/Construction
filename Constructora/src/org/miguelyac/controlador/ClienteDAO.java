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
import org.miguelyac.db.Conexion;
import org.miguelyac.modelo.Cliente;

/**
 *
 * @author santiago
 */
public class ClienteDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public boolean RegistrarCliente(Cliente cl){
        String sql = "INSERT INTO tbl_cliente(NIT,DPI,nombre,telefono,direccion) VALUES (?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getNIT());
            ps.setString(2, cl.getDPI());
            ps.setString(3, cl.getNombre());
            ps.setInt(4, cl.getTelefono());
            ps.setString(5, cl.getDireccion());
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
    
    public List ListarCliente(){
        List<Cliente> ListaCL = new ArrayList();
        String sql = "SELECT * FROM tbl_cliente";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setId_cliente(rs.getInt("id_cliente"));
                cl.setNIT(rs.getInt("NIT"));
                cl.setDPI(rs.getString("DPI"));
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getInt("telefono"));
                cl.setDireccion(rs.getString("direccion"));
                ListaCL.add(cl);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaCL;
    }
    public boolean EliminarCliente(int id_cliente){
        String sql = "DELETE FROM tbl_cliente WHERE id_cliente = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_cliente);
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
       public boolean ModificarCliente(Cliente cl){
       String sql = "UPDATE tbl_cliente SET NIT=?, DPI=?, nombre=?, telefono=?, direccion=? WHERE id_cliente=?";
       try {
           ps = con.prepareStatement(sql);   
           ps.setInt(1, cl.getNIT());
           ps.setString(2, cl.getDPI());
           ps.setString(3, cl.getNombre());
           ps.setInt(4, cl.getTelefono());
           ps.setString(5, cl.getDireccion());
           ps.setInt(6, cl.getId_cliente());
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
       public Cliente buscarCliente(int NIT){
           Cliente cl = new Cliente();
           String sql = "SELECT * FROM tbl_cliente  WHERE NIT=?";
           try{
               con = cn.getConnection();
               ps = con.prepareStatement(sql);
               ps.setInt(1, NIT);
               rs = ps.executeQuery();
               if(rs.next()){
                   cl.setNombre(rs.getString("nombre"));
                   cl.setDPI(rs.getString("DPI"));
                   cl.setTelefono(rs.getInt("telefono"));
                   cl.setDireccion(rs.getString("direccion"));
               }
           }catch(SQLException e){
               System.out.println(e.toString());
           }
           return cl;
       }
}
