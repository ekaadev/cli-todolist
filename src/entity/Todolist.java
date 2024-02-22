package entity;

public class Todolist {

    /**
     * Field todo
     * Menyimpan data todolist
     */
    private String todo;



    public Todolist() {
        this(null);
    }

    public Todolist(String todo) {
        this.todo = todo;
    }

    /**
     * Method getter
     * @return todo
     */
    public String getTodo() {
        return todo;
    }

    /**
     * Method setter
     * @param todo
     */
    public void setTodo(String todo) {
        this.todo = todo;
    }
}
