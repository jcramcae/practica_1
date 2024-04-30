package sales;
import shop.ClothingItem;
import shop.Inventory;

public class SalesRegister{
    private static long totalSales= 0;

    public static ClothingItem processSale(Inventory inventory, String name, char size){
        ClothingItem item = inventory.getClothingItem(name,size);
        if (item == null){
            System.out.println("El producto " + name + " de tamaño " + size + " no se encuentra en el inventario " );
            return item;
        }
        inventory.delateClothingItem(name, size);
        totalSales++;
        return item;

    }
    public static long getTotalSales(){
        return totalSales;
    }


}

