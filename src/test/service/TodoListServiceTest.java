package test.service;


import entity.Todolist;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
        testUpdateTodoList();
    }

    public static void testShowTodoList() {

        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0] = new Todolist("Belajar Java");
        todoListRepository.data[1] = new Todolist("Belajar JavaScript");
        todoListRepository.data[2] = new Todolist("Belajar PHP");

        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.showTodoList();
    }

    public static void testAddTodoList() {

        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java");
        todoListService.addTodoList("Belajar Basis Data");
        todoListService.addTodoList("Belajar Java OOP");

        todoListService.showTodoList();

        todoListService.addTodoList("Belajar PHP");

        todoListService.showTodoList();

        todoListService.addTodoList("Belajar Java MySql");
        todoListService.addTodoList("Belajar Java JavaScript");

        todoListService.showTodoList();


    }

    public static void testRemoveTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java");
        todoListService.addTodoList("Belajar Basis Data");
        todoListService.addTodoList("Belajar Java OOP");

        todoListService.showTodoList();

        todoListService.removeTodoList(3);
        todoListService.showTodoList();

        todoListService.removeTodoList(1);
        todoListService.showTodoList();

        todoListService.removeTodoList(1);
        todoListService.showTodoList();

        todoListService.addTodoList("Belajar Java");
        todoListService.addTodoList("Belajar Basis Data");
        todoListService.addTodoList("Belajar Java OOP");

        todoListService.showTodoList();

        todoListService.removeTodoList(4);
        todoListService.showTodoList();


    }

    public static void testUpdateTodoList() {

        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java");
        todoListService.addTodoList("Belajar Basis Data");
        todoListService.addTodoList("Belajar Java OOP");

        todoListService.showTodoList();

        todoListService.updateTodoList(4, "Update Todo");

        todoListService.showTodoList();

        todoListService.updateTodoList(3, "Belajar Java Standar Classes");

        todoListService.showTodoList();

        todoListService.updateTodoList(1, "Belajar Java Dasar");

        todoListService.showTodoList();
    }

}
