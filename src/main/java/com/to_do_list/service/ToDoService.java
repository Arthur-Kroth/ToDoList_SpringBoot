package com.to_do_list.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.to_do_list.entity.ToDo;
import com.to_do_list.repository.ToDoRepository;

@Service
public class ToDoService {

    private ToDoRepository toDoRepository;
    
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> create(ToDo toDo) {
        toDoRepository.save(toDo);
        return list();
    }

    public List<ToDo> list(){
        Sort sort = Sort.by("priority").descending().and(Sort.by("name").ascending());
        return toDoRepository.findAll(sort);
    }

    public List<ToDo> update(ToDo toDo){
        toDoRepository.save(toDo);
        return list();
    }

    public List<ToDo> delete(Long id){
        toDoRepository.deleteById(id);
        return list();
    }
}