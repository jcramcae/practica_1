public class ClothingItem {
    private String name;
    private double price;
    private char size;
//Constructor
    public ClothingItem(String name, double price, char size){
        this.name= name;
        this. price= price;
        this.size= size;
    }
//Getters and Setters
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name= name;
    }
    public double getPrice(){
        return this.price;
    }
    public void setPrice(Double price){
        this.price= price;
    }
    public char getSize(){
        switch(size){
            case 'S':
                return 'S';
            case 'M':
                return 'M';
            case 'L':
                return 'L';
            default:
                return 'S';
        }
    }
    public void setSize(){
        this. size= size;
    }
    @Override
    public String toString(){
        return " Prenda " + name + " Precio " + price + " Tamaño " + size + ".";
    }



}
