package service;

import entity.Todolist;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    /**
     * Field todoListRepository
     * Untuk mengkases data TodoListRepository
     */
    private TodoListRepository todoListRepository;

    /**
     * Constructor
     * Param TodoListRepository
     */
    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    /**
     * Method showTodoList()
     * Menampilkan semua todolist
     * Data didapat melalui repository
     */
    @Override
    public void showTodoList() {
        Todolist[] model = todoListRepository.getAll();

        System.out.println("TODOLIST");
        for (int i = 0; i < model.length ; i++) {
            Todolist todolist = model[i];
            int no = i + 1;

            if (todolist != null) {
                System.out.println(no + ". " + todolist.getTodo());
            }
        }
    }

    /**
     * Method addTodoList(String todo)
     * Menambahkan todolist
     */
    @Override
    public void addTodoList(String todo) {
        Todolist todolist = new Todolist(todo);
        todoListRepository.add(todolist);
        System.out.println("SUKSES MENAMBAH TODOLIST : " + todo);
    }

    /**
     * Method removeTodoList(Integer number)
     * Menghapus todolist
     */
    @Override
    public void removeTodoList(Integer number) {
        boolean isSucces = todoListRepository.remove(number);

        if (isSucces) {
            System.out.println("SUKSES MENGHAPUS TODOLIST : " + number);
        } else {
            System.out.println("GAGAL MENGHAPUS TODOLIST : " + number);
        }
    }

    /**
     * Method checkAllTodoList()
     * Mengembalikan nilai boolean dari method checkAll() di repository
     */
    @Override
    public boolean checkAllTodoList() {
        return todoListRepository.checkAll();
    }


    /**
     * Method checkAllTodoList()
     * Mengembalikan nilai boolean dari method check() di repository
     */
    @Override
    public boolean checkTodoList(Integer number) {
        return todoListRepository.check(number);
    }

    /**
     * Method updateTodoList(Integer number, String todo)
     * Mengubah todolist
     */
    @Override
    public void updateTodoList(Integer number, String todo) {
        Todolist todolist = new Todolist(todo);

        boolean isSucces = todoListRepository.update(number, todolist);

        if (isSucces) {
            System.out.println("SUKSES MENGUBAH TODOLIST : " + number);
        } else {
            System.out.println("GAGAL MENGUBAH TODOLIST : " + number);
        }
    }
}
