package com.ui.todolist.services;

import com.ui.todolist.entities.ListItem;
import com.ui.todolist.repositories.ListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ListItemService implements IListItemService
{
    @Autowired
    ListItemRepository listItemRepository;

    @Override
    public List<ListItem> getAllListItems() {
        return (List<ListItem>) listItemRepository.findAll();
    }

    @Override
    public ListItem getListItemById(long id) {
        return listItemRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(ListItem item) {
        listItemRepository.save(item);
    }

    @Override
    public void deleteListItem(long id) {
        listItemRepository.deleteById(id);
    }
}
