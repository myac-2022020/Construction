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
import org.miguelyac.modelo.DatosDeEmpresa;
import org.miguelyac.modelo.Detalle;
import org.miguelyac.modelo.Venta;

/**
 *
 * @author santiago
 */
public class VentaDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;
    
    public int IdVenta(){
        int id = 0;
        String sql = "SELECT MAX(id_venta) FROM tbl_venta";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id;
    }
    public int GuardarVenta(Venta vt){
        String sql = "INSERT INTO tbl_venta(cliente, vendedor, total,fecha) VALUES (?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, vt.getCliente());
            ps.setString(2,vt.getVendedor());
            ps.setDouble(3, vt.getTotal());
            ps.setString(4, vt.getFecha());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return r;
    }
    public int RegistrarDetalle(Detalle dt){
        String sql = "INSERT INTO tbl_detalle(cod_pro,cantidad,precio,id_de_venta) VALUES (?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dt.getCod_pro());
            ps.setInt(2, dt.getCantidad());
            ps.setDouble(3, dt.getPrecio());
            ps.setInt(4, dt.getId__de_venta());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        return r;
    }
    public List ListarVenta(){
        List<Venta> ListaVT = new ArrayList();
        String sql = "SELECT * FROM tbl_venta";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Venta vt = new Venta();
                vt.setId_venta(rs.getInt("id_venta"));
                vt.setCliente(rs.getString("cliente"));
                vt.setVendedor(rs.getString("vendedor"));
                vt.setTotal(rs.getDouble("total"));
                vt.setFecha(rs.getString("fecha"));
                ListaVT.add(vt);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaVT;
    }
    public boolean actualizarStock(int cant, String cod){
        String sql = "UPDATE tbl_producto SET stock = ? WHERE codigo = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    public DatosDeEmpresa buscarDatos(){
        DatosDeEmpresa date = new DatosDeEmpresa();
        String sql = "SELECT * FROM tbl_empresa";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                date.setId_config(rs.getInt("id_empresa"));
                date.setNombre(rs.getString("nombre"));
                date.setTelefono(rs.getInt("telefono"));
                date.setCorreo(rs.getString("correo"));
                date.setDireccion(rs.getString("direccion"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return date;
    }
    public boolean ModificarEmpresa(DatosDeEmpresa dato) {
       String sql = "UPDATE tbl_empresa SET nombre=?,telefono=?,correo=?,direccion=? WHERE id_empresa=?";
       try {
           ps = con.prepareStatement(sql);   
           ps.setString(1, dato.getNombre());
           ps.setInt(2, dato.getTelefono());
           ps.setString(3, dato.getCorreo());
           ps.setString(4, dato.getDireccion());
           ps.setInt(5, dato.getId_config());
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
   
    public DatosDeEmpresa NombreEmpresa(){
        DatosDeEmpresa date = new DatosDeEmpresa();
        String sql = "SELECT nombre FROM tbl_empresa";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                date.setNombre(rs.getString("nombre"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return date;
    }
}
