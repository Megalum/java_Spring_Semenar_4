package ru.gb.springhwl3.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import ru.gb.springhwl3.entity.Issue;
import ru.gb.springhwl3.entity.Reader;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IssueRepository {
    @Getter
    private List<Issue> list = new ArrayList<>();

    public IssueRepository(){
        list.add(new Issue(0, 1, LocalDateTime.now()));
        list.add(new Issue(2, 0, LocalDateTime.now()));
        list.add(new Issue(2, 2, LocalDateTime.now()));
        list.add(new Issue(3, 4, LocalDateTime.now()));
        list.get(1).refundBook(LocalDateTime.now());
        list.get(3).refundBook(LocalDateTime.now());
    }

    public void createIssue(Issue issue){
        list.add(issue);
    }

    public Issue searchReader(long id){
        return list.stream().filter(e -> e.getIdReader() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Issue> searchAllReader(long id){
        return list.stream().filter(e -> e.getIdReader() == id)
                .toList();
    }

    public Issue findById(long id){
        return list.stream().filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /*public List<String> getNameReader(){
        List<String> sList = new ArrayList<>();
        for (Issue out: this.list){
            sList.add()
        }
    }*/
}
