package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book one = new Book(1,"Унесенные ветром",350,"Маргарет Митчелл");
    private Book two = new Book(2,"Анна Каренина",150,"Лев Толстой");
    private Book three = new Book(3,"Преступление и наказание",200,"Федор Достоевский");
    private Smartphone four = new Smartphone(4,"Honor",4500,"Китай");
    private  Smartphone five = new Smartphone(5,"Samsung",15000,"Вьетнам");
    private Smartphone six = new Smartphone(6,"Apple",25000,"США");
    private Smartphone seven = new Smartphone(7,"Samsung",28000,"Вьетнам");

    @BeforeEach
    public void setUp(){
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
    }

    @Test
    public void shouldIdNotFind (){
        int idToFind=65;
        repository.findById(idToFind);

        Product expected = null;
        Product actual = repository.findById(idToFind);
        assertEquals(expected,actual);
    }
    @Test
    public void shouldIdToRemoveNotFind (){
        int idToRemove=10;

        assertThrows(NotFoundException.class, () -> {repository.removeById(idToRemove);
        });

    }
    @Test
    public void shouldFindById (){
        int idToFinde = 3;

        Product expected = three;
        Product actual = repository.findById(idToFinde);

        assertEquals(expected,actual);
    }

@Test
    public void shouldRemoveById(){

        int idToRemove= 4;
        repository.removeById(idToRemove);

        Product [] expected =  new Product[]{one,two,three,five,six,seven};
        Product [] actual = repository.findAll();

        assertArrayEquals(expected,actual);
}
}