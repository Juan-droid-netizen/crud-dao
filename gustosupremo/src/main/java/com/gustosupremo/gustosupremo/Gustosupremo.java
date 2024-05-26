package com.gustosupremo.gustosupremo;

import com.gustosupremo.gustosupremo.dao.SucursalesDao;
import com.gustosupremo.gustosupremo.dao.SucursalesDaoImplement;
import com.gustosupremo.gustosupremo.models.Sucursal;
import com.gustosupremo.gustosupremo.visual.VisualPanel;
import java.util.List;
import java.util.Scanner;

public class Gustosupremo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VisualPanel visual = new VisualPanel();
        visual.setVisible(true);
        
        while (true) {
            System.out.println("Bienvenido al sistema de gestión de sucursales de Gusto Supremo 🍣 🍱.");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear sucursal");
            System.out.println("2. Listar sucursales");
            System.out.println("3. Actualizar sucursales");
            System.out.println("4. Eliminar sucursal");
            System.out.println("5. Salir");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    createSucursal();
                    break;
                case "2":
                    List<Sucursal> sucursales = listarSucursales();
                    for (Sucursal sucursal : sucursales) {
                        System.out.println(sucursal);
                    }
                    break;
                case "3":
                    updateSucursal();
                    break;
                case "4":
                    eliminarSucursal();
                    break;
                case "5":
                    System.out.println("Saliendo del sistema. ¡Adiós!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    public static void createSucursal() {
        SucursalesDao sucursalDao = new SucursalesDaoImplement();
        Sucursal sucursal = new Sucursal();

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese el código de la sucursal:");
        String codigo_sucursales = scan.nextLine();
        sucursal.setCodigo_sucursales(Integer.parseInt(codigo_sucursales));

        System.out.println("Ingrese el nombre de la sucursal:");
        String nombre = scan.nextLine();
        sucursal.setNombre(nombre);

        System.out.println("Ingrese la dirección de la sucursal:");
        String direccion = scan.nextLine();
        sucursal.setDireccion(direccion);

        System.out.println("Ingrese el nombre del gerente encargado:");
        String gerente_encargado = scan.nextLine();
        sucursal.setGerente_encargado(gerente_encargado);

        sucursalDao.addSucursal(sucursal);
        System.out.println("Sucursal creada con éxito.");
    }

    public static List<Sucursal> listarSucursales() {
        SucursalesDao sucursalDao = new SucursalesDaoImplement();
        return sucursalDao.list();
    }

    public static void updateSucursal() {
        SucursalesDao sucursalDao = new SucursalesDaoImplement();
        Sucursal sucursal = new Sucursal();

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingresa el Codigo de la Sucursal a Editar: ");
        String codigo_sucursales = scan.nextLine();

        var id = Integer.parseInt(codigo_sucursales);
        
        System.out.println("Ingrese el nuevo nombre de la sucursal:");
        String nombre = scan.nextLine();
        sucursal.setNombre(nombre);

        System.out.println("Ingrese la nueva dirección de la sucursal:");
        String direccion = scan.nextLine();
        sucursal.setDireccion(direccion);

        System.out.println("Ingrese el nombre del nuevo gerente encargado:");
        String gerente_encargado = scan.nextLine();
        sucursal.setGerente_encargado(gerente_encargado);

        sucursalDao.updateSucursal(sucursal, id);
    }

    public static void eliminarSucursal() {
        SucursalesDao sucursalDao = new SucursalesDaoImplement();
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese el código de la sucursal a eliminar:");
        String codigo_sucursales = scan.nextLine();

        sucursalDao.deleteSucursal(Integer.parseInt(codigo_sucursales));
        System.out.println("Sucursal eliminada con éxito.");
    }
}
