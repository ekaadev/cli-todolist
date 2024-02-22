package service;

public interface TodoListService {

    void showTodoList();

    void addTodoList(String todo);

    void removeTodoList(Integer number);

    boolean checkAllTodoList();

    boolean checkTodoList(Integer number);

    void updateTodoList(Integer number, String todo);


}
