package repository;

import entity.Todolist;

public interface TodoListRepository {

    Todolist[] getAll();

    void add(Todolist todolist);

    boolean remove(Integer number);

    boolean checkAll();

    boolean check(Integer number);

    boolean update(Integer number, Todolist todolist);
}
