package com.to_do_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.to_do_list.entity.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

}
