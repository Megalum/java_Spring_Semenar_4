package ru.gb.springhwl3.services;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.springhwl3.controllers.BookRequest;
import ru.gb.springhwl3.controllers.NameRequest;
import ru.gb.springhwl3.entity.Book;
import ru.gb.springhwl3.entity.Reader;
import ru.gb.springhwl3.repository.ReaderRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReaderService {
    private final ReaderRepository readerRepository;

    public Reader getReader(BookRequest request){
        if (readerRepository.findById(request.getId()) == null){
            log.info("Не удалось найти книгу с id " + request.getId());
            throw new NoSuchElementException("Не удалось найти книгу с id " + request.getId());
        }

        return readerRepository.findById(request.getId());
    }

    public Reader createReader(NameRequest request){
        Reader reader = new Reader(request.getName());
        readerRepository.createReader(reader);
        return reader;
    }

    public Reader delReader(BookRequest request){
        if (readerRepository.findById(request.getId()) == null){
            log.info("Не удалось найти книгу с id " + request.getId());
            throw new NoSuchElementException("Не удалось найти книгу с id " + request.getId());
        }

        readerRepository.deleteReader(Integer.parseInt(String.valueOf(request.getId())));
        return readerRepository.findById(request.getId());
    }

    public List<Reader> readersList(){
        return readerRepository.getList();
    }

}
