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
import org.miguelyac.modelo.Productos;

/**
 *
 * @author santiago
 */
public class ProductosDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public boolean RegistrarPorducto(Productos prod){
        String sql = "INSERT INTO tbl_producto(codigo,descripcion,nombre,stock,precio) VALUES (?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getCodigo());
            ps.setString(2, prod.getDescripcion());
            ps.setString(3, prod.getNombre());
            ps.setInt(4, prod.getStock());
            ps.setDouble(5, prod.getPrecio());
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
    public List ListarProductos(){
        List<Productos> ListaPD = new ArrayList();
        String sql = "SELECT * FROM tbl_producto";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Productos pd = new Productos();
                pd.setId_producto(rs.getInt("id_producto"));
                pd.setCodigo(rs.getString("codigo"));
                pd.setDescripcion(rs.getString("descripcion"));
                pd.setNombre(rs.getString("nombre"));
                pd.setStock(rs.getInt("stock"));
                pd.setPrecio(rs.getDouble("precio"));
                ListaPD.add(pd);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaPD;
    }
    public boolean EliminarProducto(int id_producto){
        String sql = "DELETE FROM tbl_producto WHERE id_producto = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_producto);
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
    public boolean ActualizarProductos(Productos pd){
        String sql = "UPDATE tbl_producto SET codigo=?, descripcion=?, nombre=?, stock=?,precio=? WHERE id_producto=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, pd.getCodigo());
            ps.setString(2, pd.getDescripcion());
            ps.setString(3, pd.getNombre());
            ps.setInt(4, pd.getStock());
            ps.setDouble(5, pd.getPrecio());
            ps.setInt(6, pd.getId_producto());
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
    public Productos buscarProductos(String cod){
        Productos producto = new Productos();
        String sql = "SELECT * FROM tbl_producto WHERE codigo = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if(rs.next()){
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return producto;
    }
}
