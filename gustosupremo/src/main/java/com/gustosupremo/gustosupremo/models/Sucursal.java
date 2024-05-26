package com.gustosupremo.gustosupremo.models;

public class Sucursal {
    private int codigo_sucursales;
    private String nombre;
    private String direccion;
    private String gerente_encargado;

    public Sucursal() {
    }

    public Sucursal(int codigo_sucursales, String nombre, String direccion, String gerente_encargado) {
        this.codigo_sucursales = codigo_sucursales;
        this.nombre = nombre;
        this.direccion = direccion;
        this.gerente_encargado = gerente_encargado;
    }

    public int getCodigo_sucursales() {
        return codigo_sucursales;
    }

    public void setCodigo_sucursales(int codigo_sucursales) {
        this.codigo_sucursales = codigo_sucursales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGerente_encargado() {
        return gerente_encargado;
    }

    public void setGerente_encargado(String gerente_encargado) {
        this.gerente_encargado = gerente_encargado;
    }

    @Override
    public String toString() {
        return "\nSucursales{ \n" + "codigo_sucursales=" + codigo_sucursales + ", nombre=" + nombre + ", direccion=" + direccion + ", gerente_encargado=" + gerente_encargado + '}';
    }
}
