package com.gustosupremo.gustosupremo.dao;

import com.gustosupremo.gustosupremo.models.Sucursal;
import java.util.List;

public interface SucursalesDao {
    List<Sucursal> list();
    void addSucursal(Sucursal sucursal);
    void updateSucursal(Sucursal sucursal, int id);
    void deleteSucursal(int codigo_sucursales);
}
