/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.miguelyac.modelo;

/**
 *
 * @author santiago
 */
public class Detalle {
   private int id_detalle;
   private String cod_pro;
   private int cantidad;
   private double precio;
   private int id__de_venta;
   
   public Detalle(){
   
   }
   public Detalle(int id_detalle, String cod_pro, int cantidad, double precio, int id_de_venta){
       this.id_detalle = id_detalle;
       this.cod_pro = cod_pro;
       this.cantidad = cantidad;
       this.precio = precio;
       this.id__de_venta = id_de_venta;
   }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public String getCod_pro() {
        return cod_pro;
    }

    public void setCod_pro(String cod_pro){
        this.cod_pro = cod_pro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId__de_venta() {
        return id__de_venta;
    }

    public void setId__de_venta(int id__de_venta) {
        this.id__de_venta = id__de_venta;
    }
    
}