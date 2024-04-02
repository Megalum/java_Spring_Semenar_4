package ru.gb.springhwl3.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.springhwl3.controllers.BookRequest;
import ru.gb.springhwl3.controllers.IssueRequest;
import ru.gb.springhwl3.entity.Book;
import ru.gb.springhwl3.entity.Issue;
import ru.gb.springhwl3.repository.BookRepository;
import ru.gb.springhwl3.repository.IssueRepository;
import ru.gb.springhwl3.repository.ReaderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class IssueService {
    private final BookRepository bookRepository;
    private final IssueRepository issueRepository;
    private final ReaderRepository readerRepository;

    public Issue createIssue(IssueRequest request){
        if (bookRepository.findById(request.getBookId()) == null){
            log.info("Не удалось найти книгу с id " + request.getBookId());
            throw new NoSuchElementException("Не удалось найти книгу с id " + request.getBookId());
        }
        if (readerRepository.findById(request.getReaderId()) == null){
            log.info("Не удалось найти читателя с id " + request.getReaderId());
            throw new NoSuchElementException("Не удалось найти читателя с id " + request.getReaderId());
        }

        Issue issue = new Issue(request.getReaderId(), request.getBookId(), LocalDateTime.now());
        issueRepository.createIssue(issue);
        return issue;
    }

    public boolean searchReader(long id){
        return issueRepository.searchReader(id) != null;
    }

    public Issue getIssue(BookRequest request){
        if (issueRepository.findById(request.getId()) == null){
            log.info("Не удалось найти запись с id " + request.getId());
            throw new NoSuchElementException("Не удалось найти запись с id " + request.getId());
        }

        return issueRepository.findById(request.getId());
    }

    public List<Issue> getReader(BookRequest request){
        if (readerRepository.findById(request.getId()) == null){
            log.info("Не удалось найти читателя с id " + request);
            throw new NoSuchElementException("Не удалось найти читателя с id " + request);
        }

        return issueRepository.searchAllReader(request.getId());
    }

    public List<Issue> issuesList(){
        return issueRepository.getList();
    }
}
