package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {

    /**
     * Field TodolistService
     * Untuk mengakses data TodoListService
     */
    private TodoListService todoListService;

    /**
     * Contryctor
     * param TodoListService
     */
    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    /**
     * Method showTodoList()
     * Tampilan Todolist
     */
    public void showTodoList() {
        label:
        while (true) {
            todoListService.showTodoList();
            System.out.println("Pilih Menu");
            System.out.println("1. Tambah");
            System.out.println("2. Ubah");
            System.out.println("3. Hapus");
            System.out.println("x. Keluar");
            String inputMenu = InputUtil.input("Pilih Menu");

            switch (inputMenu) {
                case "1":
                    this.addTodoList();
                    break;
                case "2":
                    this.updateTodoList();
                    break;
                case "3":
                    this.removeTodoList();
                    break;
                case "x":
                    break label;
                default:
                    System.out.println("Menu yang anda pilih tidak sesuai");
                    break;
            }
        }
    }

    /**
     * Method addTodoList()
     * Tampilan manambahkan todolist
     */
    public void addTodoList() {
        System.out.println("MENAMBAH TODOLIST");
        String todo = InputUtil.input("TODOLIST");
        if (!todo.equals("x")) {
            todoListService.addTodoList(todo);
        }
    }

    /**
     * Method addTodoList()
     * Tampilan mengubah todolist
     */
    public void updateTodoList() {
        boolean checkIndex = false;
        if (todoListService.checkAllTodoList()) {
            System.out.println("MENGEDIT TODOLIST");
            String inputIndex = InputUtil.input("Nomor TODOLIST (\"x\" jika batal)");

            if (!inputIndex.equals("x")) {
                checkIndex = todoListService.checkTodoList(Integer.valueOf(inputIndex));

            }

            if (!(inputIndex.equals("x")) && checkIndex) {
                String inputEdit = InputUtil.input("TODOLIST (\"x\" jika batal)");

                if (!inputEdit.equals("x")) {
                    todoListService.updateTodoList(Integer.valueOf(inputIndex), inputEdit);
                }
            }

            if (!checkIndex && !(inputIndex.equals("x"))) {
                System.out.println("NOMOR TODOLIST TIDAK SESUAI");
            }

        } else {
            System.out.println("TIDAK ADA DATA TODOLIST");
        }
    }

    /**
     * Method addTodoList()
     * Tampilan menghpaus todolist
     */
    public void removeTodoList() {
        String inputIndex = InputUtil.input("Nomor TODOLIST (\"x\" jika batal)");

        if (!inputIndex.equals("x")) {
            todoListService.removeTodoList(Integer.valueOf(inputIndex));
        }
    }


}
