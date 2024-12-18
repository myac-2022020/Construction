/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.miguelyac.modelo;

/**
 *
 * @author santiago
 */
public class Productos {
    private int id_producto;
    private String codigo;
    private String descripcion;
    private String nombre;
    private int stock;
    private double precio;
    
    public Productos(){
    
    }
    public Productos(int id_producto, String codigo,String descripcion, String nombre, int stock, double precio){
        this.id_producto = id_producto;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.stock =  stock;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
