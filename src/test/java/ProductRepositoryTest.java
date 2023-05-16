import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    @Test
    public void testRemoveWhenIdExist() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "It", 100, "King");
        Book book2 = new Book(2, "War and Piece", 200, "Tolstoy");
        Book book3 = new Book(3, "Harry Potter ", 150, "Rowlling");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(1);
        Product[] actual = repo.findAll();
        Product[] expected = {book2, book3};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testRemoveWhenIdExist2() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "It", 100, "King");
        Book book2 = new Book(2, "War and Piece", 200, "Tolstoy");
        Book book3 = new Book(3, "Harry Potter ", 150, "Rowlling");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(4)
                );
    }
    @Test
    public void testRemoveWhenIdExistSM() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Smartphone Smartphone1 = new Smartphone(1, "Nokia", 100, "Japan");
        Smartphone Smartphone2 = new Smartphone(2, "Iphone", 200, "USA");
        Smartphone Smartphone3 = new Smartphone(3, "Samsung", 150, "South Korea");

        repo.add(Smartphone1);
        repo.add(Smartphone2);
        repo.add(Smartphone3);
        repo.removeById(2);
        Product[] actual = repo.findAll();
        Product[] expected = {Smartphone1, Smartphone3};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testRemoveWhenIdExistSM2() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Smartphone Smartphone1 = new Smartphone(1, "Nokia", 100, "Japan");
        Smartphone Smartphone2 = new Smartphone(2, "Iphone", 200, "USA");
        Smartphone Smartphone3 = new Smartphone(3, "Samsung", 150, "South Korea");

        repo.add(Smartphone1);
        repo.add(Smartphone2);
        repo.add(Smartphone3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(6)
        );
    }
}