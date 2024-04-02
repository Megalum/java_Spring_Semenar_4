package ru.gb.springhwl3.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import ru.gb.springhwl3.entity.Issue;
import ru.gb.springhwl3.entity.Reader;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReaderRepository {
    @Getter
    private List<Reader> list = new ArrayList<>();

    public ReaderRepository() {
        list.add(new Reader("Костя"));
        list.add(new Reader("Василий"));
        list.add(new Reader("Семен"));
        list.add(new Reader("Сергей"));
        list.add(new Reader("Николай"));
    }

    public void createReader(Reader reader){
        list.add(reader);
    }

    public void deleteReader(int id){
        list.remove(id);
    }

    public Reader findById(long id){
        return list.stream().filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
