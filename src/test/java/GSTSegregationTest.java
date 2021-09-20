import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;

public class GSTSegregationTest {

    Shopkeeper products;

    @Test
    public void verifyAllProducts() {
//Arrange
        products = new Shopkeeper();
        Products television = new Television("TV001", "Sony", "Grey", 42000);
        Products fridge = new Fridge("FR001", "Samsung", "Red", 69000);
        Products earphones = new Earphones("ear101", "Boat", "Blue", 560.0);
//Act
        products.addProduct(television);
        products.addProduct(fridge);
        products.addProduct(earphones);

        //Assert
        List<Products> product = products.getAllProduct();
        for (Products product1 : product) {

            Assert.assertTrue(product1 instanceof Television || product1 instanceof Fridge ||
                    product1 instanceof Earphones); //VerifyingAllProducts

        }
    }

    @Test
    public void verifyNumberOfProductsApplicableForGST() {
        //Arrange
        products = new Shopkeeper();
        Products Television = new Television("TV001", "Sony", "Grey", 42000);
        Products Fridge = new Fridge("FR001", "Samsung", "Red", 69000);
        Products Earphone = new Earphones("ear101", "Boat", "Blue", 560);
//Act
        products.addProduct(Television);
        products.addProduct(Fridge);
        products.addProduct(Earphone);
//Assert
        Assert.assertEquals(products.getGSTProduct().size(), 2); //CheckingNumberOfGSTProducts
    }

    @Test
    public void verifyNameOfProductsApplicableForGST() {
        //Arrange
        products = new Shopkeeper();
        Products Television = new Television("TV001", "Sony", "Grey", 42000);
        Products Fridge = new Fridge("FR001", "Samsung", "Red", 69000);
        Products Earphone = new Earphones("ear101", "Boat", "Blue", 560);
//Act
        products.addProduct(Television);
        products.addProduct(Fridge);
        products.addProduct(Earphone);
//Assert
        for (Products products : products.getGSTProduct())
            Assert.assertTrue(products.productID.equals("TV001") || products.productID.equals("FR001")); //CheckingtheProductIDforGSTProducts

    }

    @Test
    public void GetTotalPriceIncludingGST() {
        //Arrange
        products = new Shopkeeper();
        Products television = new Television("TV001", "Sony", "Grey", 42000);
        Products fridge = new Fridge("FR001", "Samsung", "Red", 69000);
        Products earphone = new Earphones("ear101", "Boat", "Blue", 560);
        //Act
        products.addProduct(television);
        products.addProduct(fridge);
        products.addProduct(earphone);

        //Assert

        Assert.assertEquals(products.getTotalPrice(television), 49560); //ProductWithGST
        Assert.assertEquals(products.getTotalPrice(fridge), 81420); //ProductWithGST
        Assert.assertEquals(products.getTotalPrice(earphone), 560); //ProductWithoutGST

    }
}

