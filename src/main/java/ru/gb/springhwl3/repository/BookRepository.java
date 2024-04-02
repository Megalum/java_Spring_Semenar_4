package ru.gb.springhwl3.repository;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.gb.springhwl3.entity.Book;
import ru.gb.springhwl3.entity.Issue;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    @Getter
    private List<Book> list = new ArrayList<>();
    @Getter
    private long lenght;

    public BookRepository() {
        list.add(new Book("Война и мир"));
        list.add(new Book("Мастер и Маргарита"));
        list.add(new Book("Приключения Буратино"));
        list.add(new Book("Красная шапочка"));
        list.add(new Book("Семеро козлят"));
        lenght = 5;
    }

    public void createBook(List<Book> book){
        list = book;
    }

    public void addBook(Book book){
        list.add(book);
    }

    public void deleteBook(int id){
        list.remove(id);
    }

    public Book findById(long id){
        return list.stream().filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
