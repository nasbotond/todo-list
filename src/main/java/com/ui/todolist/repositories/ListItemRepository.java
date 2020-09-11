package com.ui.todolist.repositories;

import com.ui.todolist.entities.ListItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListItemRepository extends CrudRepository<ListItem, Long> {
}
