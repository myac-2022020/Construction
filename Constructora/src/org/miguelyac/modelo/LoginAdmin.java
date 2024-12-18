/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.miguelyac.modelo;

/**
 *
 * @author santiago
 */
public class LoginAdmin {
    private int id_admin;
    private String nombre_admin;
    private String correo_admin;
    private String pass_admin;
    
    public LoginAdmin(){
    
    }
    public LoginAdmin(int id_admin,  String nombre_admin,String correo_admin, String pass_admin){
        this.id_admin = id_admin;
        this.nombre_admin = nombre_admin;
        this.correo_admin  = correo_admin;
        this.pass_admin = pass_admin;
    }
    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getNombre_admin() {
        return nombre_admin;
    }

    public void setNombre_admin(String nombre_admin) {
        this.nombre_admin = nombre_admin;
    }

    public String getCorreo_admin() {
        return correo_admin;
    }

    public void setCorreo_admin(String correo_admin) {
        this.correo_admin = correo_admin;
    }

    public String getPass_admin() {
        return pass_admin;
    }

    public void setPass_admin(String pass_admin) {
        this.pass_admin = pass_admin;
    }
}
