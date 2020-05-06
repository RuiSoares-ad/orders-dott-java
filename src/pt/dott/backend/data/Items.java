package pt.dott.backend.data;

import pt.dott.backend.entity.Item;
import pt.dott.backend.entity.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Items {

    private List<Item> dummyItems;

    public static List<Item> generateRandomList(){
        List<Item> dummyItems = new ArrayList<>();
        int listSize = new Random().nextInt(5);
        List<Product> productList = Products.getProductList();

        for(int i = 0; i != listSize; i++){
            Product productToAdd = productList.get(new Random().nextInt(productList.size()-1));
            dummyItems.add(new Item(productToAdd.getPrice(), BigDecimal.valueOf(2.00), BigDecimal.valueOf(4.00), productToAdd));
        }

        return dummyItems;
    }

}
