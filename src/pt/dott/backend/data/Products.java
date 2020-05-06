package pt.dott.backend.data;

import pt.dott.backend.entity.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Products {

    public static List<Product> getProductList() {
        List <Product> productList = new ArrayList<>();
        //create products 1-3 months old
        Product p1 = new Product("salt", "food", 1.0, BigDecimal.valueOf(0.55), LocalDateTime.of(
                LocalDate.of(2020, Month.APRIL, 2),
                LocalTime.of(0, 0, 0)
        ) );

        Product p2 = new Product("rice", "food", 1.0, BigDecimal.valueOf(0.75), LocalDateTime.of(
                LocalDate.of(2020, Month.APRIL, 1),
                LocalTime.of(0, 0, 0)
        ) );
        Product p3 = new Product("milk", "food", 1.0, BigDecimal.valueOf(0.5), LocalDateTime.of(
                LocalDate.of(2020, Month.MARCH, 15),
                LocalTime.of(0, 0, 0)
        ) );
        Product p4 = new Product("spaghetti", "food", 2.0, BigDecimal.valueOf(1.55), LocalDateTime.of(
                LocalDate.of(2020, Month.FEBRUARY, 21),
                LocalTime.of(0, 0, 0)
        ) );
        Product p5 = new Product("sugar", "food", 1.0, BigDecimal.valueOf(0.80), LocalDateTime.of(
                LocalDate.of(2020, Month.MARCH, 1),
                LocalTime.of(0, 0, 0)
        ) );

        //create products 4-7 months old
        Product p6 = new Product("book", "library", 0.75, BigDecimal.valueOf(16.5), LocalDateTime.of(
                LocalDate.of(2020, Month.JANUARY, 4),
                LocalTime.of(0, 0, 0)
        ) );
        Product p7 = new Product("chair", "furniture", 2.2, BigDecimal.valueOf(20.00), LocalDateTime.of(
                LocalDate.of(2019, Month.DECEMBER, 25),
                LocalTime.of(0, 0, 0)
        ) );
        Product p8 = new Product("mobile charger", "techonology", 0.2, BigDecimal.valueOf(10.90), LocalDateTime.of(
                LocalDate.of(2020, Month.JANUARY, 20),
                LocalTime.of(0, 0, 0)
        ) );
        Product p9 = new Product("pillow", "home", 0.150, BigDecimal.valueOf(5.90), LocalDateTime.of(
                LocalDate.of(2020, Month.FEBRUARY, 1),
                LocalTime.of(0, 0, 0)
        ) );
        Product p10 = new Product("mousepad", "technology", 0.265, BigDecimal.valueOf(0.55), LocalDateTime.of(
                LocalDate.of(2019, Month.NOVEMBER, 10),
                LocalTime.of(0, 0, 0)
        ) );

        //create products 7-12 months old
        Product p11 = new Product("laptop charger", "technology", 0.340, BigDecimal.valueOf(30.90), LocalDateTime.of(
                LocalDate.of(2019, Month.SEPTEMBER, 5),
                LocalTime.of(0, 0, 0)
        ) );
        Product p12 = new Product("usb cable", "technology", 0.08, BigDecimal.valueOf(4.50), LocalDateTime.of(
                LocalDate.of(2019, Month.OCTOBER, 1),
                LocalTime.of(0, 0, 0)
        ) );
        Product p13 = new Product("plate", "home", 0.200, BigDecimal.valueOf(3.5), LocalDateTime.of(
                LocalDate.of(2019, Month.AUGUST, 20),
                LocalTime.of(0, 0, 0)
        ) );
        Product p14 = new Product("headphones", "technology", 0.06, BigDecimal.valueOf(8.50), LocalDateTime.of(
                LocalDate.of(2019, Month.JULY, 14),
                LocalTime.of(0, 0, 0)
        ) );
        Product p15 = new Product("coat", "clothes", 0.400, BigDecimal.valueOf(25.99), LocalDateTime.of(
                LocalDate.of(2019, Month.JUNE, 2),
                LocalTime.of(0, 0, 0)
        ) );

        //Create products > 12 months old
        Product p16 = new Product("remote", "technology", 0.1, BigDecimal.valueOf(9.90), LocalDateTime.of(
                LocalDate.of(2019, Month.APRIL, 5),
                LocalTime.of(0, 0, 0)
        ) );
        Product p17 = new Product("LG TV", "technology", 8.0, BigDecimal.valueOf(229.00), LocalDateTime.of(
                LocalDate.of(2019, Month.MARCH, 25),
                LocalTime.of(0, 0, 0)
        ) );
        Product p18 = new Product("notepad", "office", 0.09, BigDecimal.valueOf(6.90), LocalDateTime.of(
                LocalDate.of(2018, Month.DECEMBER, 11),
                LocalTime.of(0, 0, 0)
        ) );
        Product p19 = new Product("pen", "office", 0.01, BigDecimal.valueOf(1.00), LocalDateTime.of(
                LocalDate.of(2018, Month.SEPTEMBER, 1),
                LocalTime.of(0, 0, 0)
        ) );
        Product p20 = new Product("mug", "home", 0.150, BigDecimal.valueOf(10.00), LocalDateTime.of(
                LocalDate.of(2018, Month.MAY, 28),
                LocalTime.of(0, 0, 0)
        ) );

        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
        productList.add(p6);
        productList.add(p7);
        productList.add(p8);
        productList.add(p9);
        productList.add(p10);
        productList.add(p11);
        productList.add(p12);
        productList.add(p13);
        productList.add(p14);
        productList.add(p15);
        productList.add(p16);
        productList.add(p17);
        productList.add(p18);
        productList.add(p19);
        productList.add(p20);

        return productList;
    }


}
