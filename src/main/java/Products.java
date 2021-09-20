public class Products {
    String productID;
    String brand;
    String colour;
    double price;
    double gstCharge;
    Boolean isGSTapplicable;
    private int gstPercentage = 18;

    public Products(String productID, String brand, String colour, double price) {
        this.productID = productID;
        this.brand = brand;
        this.price = price;
        this.colour = colour;
    }
    //Calculation : if (Price>2000)
    //Total price = Gst + Price


    public String getProductID() {
        return productID;
    }

    public String getBrand() {
        return brand;
    }

    public String getColour() {
        return colour;
    }

    public double getPrice() {
        return price;
    }

    public double getGstCharge() {
        return (price * gstPercentage) / 100;
    }

    public Boolean isGSTapplicable() {
        if (price > 2000) {
            gstCharge = getGstCharge();
            return true;
        } else {
            gstCharge = 0;
            return false;
        }
    }

    public double getTotalPrice() {
        return price + gstCharge;
    }

}
