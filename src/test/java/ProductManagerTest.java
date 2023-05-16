import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    public void testAdd() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "It", 100, "King");
        Book book2 = new Book(2, "War and Piece", 200, "Tolstoy");
        Book book3 = new Book(3, "Harry Potter ", 150, "Rowlling");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByWhenFewProductsFound() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "It", 100, "King");
        Book book2 = new Book(2, "War and Piece", 200, "Tolstoy");
        Book book3 = new Book(3, "Harry Potter ", 150, "Rowlling");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Potter");
        Product[] expected = { book3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddSM() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Smartphone Smartphone1 = new Smartphone(1, "Nokia", 100, "Japan");
        Smartphone Smartphone2 = new Smartphone(2, "Iphone", 200, "USA");
        Smartphone Smartphone3 = new Smartphone(3, "Samsung", 150, "South Korea");
        manager.add(Smartphone1);
        manager.add(Smartphone2);
        manager.add(Smartphone3);
        Product[] actual = repo.findAll();
        Product[] expected = {Smartphone1, Smartphone2, Smartphone3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByWhenFewProductsFoundSM() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Smartphone Smartphone1 = new Smartphone(1, "Nokia", 100, "Japan");
        Smartphone Smartphone2 = new Smartphone(2, "Iphone", 200, "USA");
        Smartphone Smartphone3 = new Smartphone(3, "Samsung", 150, "South Korea");

        manager.add(Smartphone1);
        manager.add(Smartphone2);
        manager.add(Smartphone3);
        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = {Smartphone2};
        Assertions.assertArrayEquals(expected, actual);


    }
}