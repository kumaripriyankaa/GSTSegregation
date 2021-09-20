import java.util.ArrayList;
import java.util.List;

public class Shopkeeper {


    private List<Products> allProduct;

    public Shopkeeper() {
        allProduct = new ArrayList<Products>();
    }

    public void addProduct(Products product) {
        allProduct.add(product);

    }

    public List<Products> getAllProduct() {
        return allProduct;
    }

    public List<Products> getGSTProduct() {
        List<Products> gstProductWithGST = new ArrayList<Products>();
        for (Products gstProduct1 : getAllProduct()) {
            if (gstProduct1.isGSTapplicable()) {
                gstProductWithGST.add(gstProduct1);
            }
        }

        return gstProductWithGST;
    }

    public double getTotalPrice(Products product) {

        if (product.isGSTapplicable()) {
            return product.price + product.getGstCharge();
        } else {
            return product.price;
        }

    }
}