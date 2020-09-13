package com.ui.todolist.services;

import com.ui.todolist.entities.ListItem;

import java.util.List;

public interface IListItemService {

    List<ListItem> getAllListItems();

    ListItem getListItemById(long id);

    void saveOrUpdate(ListItem article);

    void deleteListItem(long id);
}
