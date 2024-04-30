package app;
import sales.SalesRegister;
import shop.ClothingItem;
import shop.Inventory;

import java.util.Scanner;

public class Main {
    private static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {

        Inventory inventario = new Inventory(10);

        inventario.addClothingitem(new ClothingItem("T-shirt", 34.5f, 'S'));
        inventario.addClothingitem(new ClothingItem("T-shirt", 34.5f, 'M'));
        inventario.countClothing("T-shirt", 'S');
        inventario.delateClothingItem("T-shirt", 'S');
        System.out.println(inventario);

        do {
            int opcion = menu();
            switch (opcion){
                case 1:
                    anyadirPrenda(inventario);
                    break;
                case 2:
                    mostrarInventario(inventario);
                    break;
                case 3:
                    venderPrenda(inventario);
                    break;
                case 4:
                    mostrarVentasProcesadas();
                    break;
                case 5:
                    System.out.println("Finalizado");
                    return;
            }
        } while (true);
    }
    public static int menu(){
        int opcion= -1;
        System.out.println("*** Welcome to Strafalarius ***");
        do {
            System.out.println("Select your option:\n" +
                    "1º Add item to inventory\n" +
                    "2º Show inventory\n" +
                    "3º Sell item\n" +
                    "4º Sales processed\n" +
                    "5º Exit");
            if (teclado.hasNextInt()){
                opcion = Integer.parseInt(teclado.next());
                if (opcion >= 1 && opcion <= 5){
                    break;
                } else{
                    System.out.println("Opción no valida.");
                }
            } else {
                System.out.println("Opción no valida.");
            }

        }while (true);

        return opcion;
    }
    public static void anyadirPrenda(Inventory inventario){
        System.out.println("Dime el nombre de la prenda: ");
        String nombre = teclado.next();
        System.out.println("Dime el precio de la prenda: ");
        float precio = teclado.nextFloat();
        System.out.println("Dime la talla de la prenda: ");
        char talla = teclado.next().charAt(0);

        ClothingItem prenda = new ClothingItem(nombre, precio, talla);
        inventario.addClothingitem(prenda);
        System.out.println("Registrada con éxito");
    }
    public static void mostrarInventario(Inventory inventario){
        System.out.println(inventario);
    }
    public static void venderPrenda(Inventory inventario){
        System.out.println("Dime el nombre de la prenda: ");
        String nombre = teclado.next();
        System.out.println("Dime la talla de la prenda: ");
        char talla = teclado.next().charAt(0);


        SalesRegister.processSale(inventario, nombre, talla);

    }
    public static void mostrarVentasProcesadas(){
        System.out.println("Se han procesado: "+SalesRegister.getTotalSales());
    }


}
