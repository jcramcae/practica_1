public class Inventory {
    private ClothingItem[] obj;
    private int itemLength;
    private  int MAX_SIZE;

    public Inventory(int MAX_SIZE){
        this.itemLength = 0;
        this.MAX_SIZE = MAX_SIZE;
        this.obj = new ClothingItem[this.MAX_SIZE];
    }
    public int getItemLength(){
        return itemLength;
    }
    public void addClothingitem(ClothingItem clothingItem){
        if(MAX_SIZE > itemLength){
            obj[itemLength] = clothingItem;
            this.itemLength ++;
        }
        else
            System.out.println("No se puede añadir nada más" );
    }
    public int countClothing(String name, char size){
        int count= 0;
        for(int i=0; i<this.itemLength; i++){
            if(obj[i].getName().equals(name) && obj[i].getSize()== size)
                count ++;
        }
        return count;
    }
    public int delateClothingItem(String name, char size ){

        for(int i=0; i<this.itemLength; i++){
            if(obj[i].getName().equals(name) && obj[i].getSize() == size){
                for(int j=0; j<itemLength; j++){
                    obj [j]=obj[j+1];
                }
                obj[itemLength-1]= null;
                itemLength --;
            }
        }
        return 0;
    }
    public ClothingItem getClothingItem(String name, char size){
        ClothingItem obj= null;
        if(this.countClothing(name, size)>0){
            int i= 0;
            boolean find= false;
            while(!find && i <this.itemLength){
                if(this.obj[i].getName().equals(name) && this.obj[i].getSize() == size){
                    obj= this.obj[i];
                    find= true;
                }
                i++;

            }
        }
        return obj;
    }
    @Override
    public String toString (){
        StringBuilder cadena= new StringBuilder();
        cadena.append("Name\t\tPrice\t\tSize\n");
        cadena.append("----------------\n");
        for(int i=0; i<this.obj.length;i++){
            cadena.append(obj[i].getName()+"\t\t"+ obj[i].getPrice()+"\t\t"+ obj[i].getSize()+"\n");
        }
        return String.valueOf(cadena);

    }
}










