package ru.gb.springhwl3.services;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.springhwl3.controllers.BookRequest;
import ru.gb.springhwl3.controllers.NameRequest;
import ru.gb.springhwl3.entity.Book;
import ru.gb.springhwl3.repository.BookRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;

    public Book getBook(BookRequest request){
        if (bookRepository.findById(request.getId()) == null){
            log.info("Не удалось найти книгу с id " + request.getId());
            throw new NoSuchElementException("Не удалось найти книгу с id " + request.getId());
        }

        return bookRepository.findById(request.getId());

    }

    public Book createBook(NameRequest request){
        Book book = new Book(request.getName());
        bookRepository.addBook(book);
        return book;
    }

    public Book delBook(BookRequest request){
        if (bookRepository.findById(request.getId()) == null){
            log.info("Не удалось найти книгу с id " + request.getId());
            throw new NoSuchElementException("Не удалось найти книгу с id " + request.getId());
        }

        bookRepository.deleteBook(Integer.parseInt(String.valueOf(request.getId())));
        return bookRepository.findById(request.getId());
    }

    public List<Book> booksList(){
        return bookRepository.getList();
    }
}
