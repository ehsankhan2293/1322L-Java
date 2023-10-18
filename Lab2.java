import java.util.Scanner;
class StockItem{
    private String description;
    private int id;
    private double price;
    private int quantity;

    public StockItem(String description,int id,double price,int quantity){
        this.description=description;
        this.id=id;
        setPrice(price);
        this.quantity=quantity;
    }

    public StockItem(){
    }

    public String toString() {
        String toString="Item number: "+id+" is "+description+" has" +
                " price $"+price+" we currently have "+quantity+" in stock";
        return toString;
    }




        public String getDescription () {
            return description;
        }

        public  int getId () {
            return id;
        }

        public double getPrice () {
            return price;
        }

        public int getQuantity () {
            return quantity;
        }

        public int lowerQuantity() {
            this.quantity = quantity - 1;
            if (this.quantity < 0) {
                System.out.println("Error");
            } return this.quantity;
        }


        public int raiseQuantity(){
        this.quantity=quantity+1;
        return this.quantity;
        }

        public void setPrice(double price){
        this.price=price;
        }



}


public class Lab2 {
    public static void main(String[] args) {

         int id= 0;

        StockItem milk = new StockItem("1 Gallon of Milk", id++,3.6,15);
        StockItem bread = new StockItem("1 Loaf of Bread", id++, 1.98, 30);


        int choice = 1;

        while (choice >0 && choice < 8) {

            do {
                Scanner input = new Scanner(System.in);
                System.out.print("1. Sold One Milk\n" +
                        "2. Sold One Bread\n" +
                        "3. Change price of Milk\n" +
                        "4. Change price of Bread\n" +
                        "5. Add Milk to Inventory\n" +
                        "6. Add Bread to Inventory\n" +
                        "7. See Inventory\n" +
                        "8. Quit\n");
                choice = input.nextInt();
                double newPrice;
                double price;

                switch (choice) {
                    case 1:
                            milk.lowerQuantity();
                        break;

                    case 2:
                            bread.lowerQuantity();
                            break;

                    case 3:
                        input = new Scanner(System.in);
                        System.out.print("What is the new price for Milk\n");
                        newPrice = input.nextDouble();
                        if(newPrice<0){
                            System.out.println("Error");
                        }else{
                            milk.setPrice(newPrice);
                        }
                        break;

                    case 4:
                        input = new Scanner(System.in);
                        System.out.print("What is the new price for Bread\n");
                        newPrice = input.nextDouble();
                        if(newPrice<0){
                            System.out.println("Error");
                        }else{
                            bread.setPrice(newPrice);
                        }
                        break;

                    case 5:
                        milk.raiseQuantity();
                        break;

                    case 6:
                        bread.raiseQuantity();
                        break;

                    case 7:
                        System.out.println("Milk:"+milk.toString());
                        System.out.println("Bread:"+bread.toString());
                        break;
                }
            } while (choice != 8);
        }
    }

}
