package repository;

import entity.Todolist;

public class TodoListRepositoryImpl implements  TodoListRepository{

    public Todolist[] data = new Todolist[5];

    /**
     * Method getAll()
     * untuk mendapatkan Todolist(array)
     * @return data
     */
    @Override
    public Todolist[] getAll() {
        return data;
    }

    /**
     * Method isFull()
     * Melakukan pengecekan pada setiap data di dalam Todolist(array)
     * Jika terdapat data null kembalikan nilai null
     * @return boolean
     */
    public boolean isFull() {
        boolean isFull = true;
        for (Todolist todolist : data) {
            if (todolist == null) {
                isFull = false;
                break;
            }
        }

        return isFull;
    }

    /**
     * Method resizeIfFull()
     * Memperbesar size dari Todolist(array)
     * jika isFull bernilai true
     */
    public void resizeIfFull() {
        if (this.isFull()) {
            Todolist[] tmp = data;

            data = new Todolist[data.length * 2];

            // menambahkan data lama kedalam array yang baru
            for (int i = 0; i < tmp.length; i++) {
                data[i] = tmp[i];
            }
        }
    }

    /**
     * Method add(Todolist todolist)
     * Menambahkan todolist ke dalam data
     */
    @Override
    public void add(Todolist todolist) {

        this.resizeIfFull();

        // menambahkan data jika ada yang null
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todolist;
                break;
            }
        }
    }

    /**
     * Method remove(Integer number)
     * Menghapus todolist dari data(array)
     * @return boolean
     */
    @Override
    public boolean remove(Integer number) {
        if (number > data.length) {
            return false;
        } else if (data[number - 1] == null) {
            return false;
        } else {

            // jika data data berada di tengah,
            // data setelahnya menimpa data yang akan dihapus
            // dan akan dilooping hingga data terakhir
            for (int i = (number - 1); i < data.length; i++) {
                if ((i + 1) == data.length) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }

    /**
     * Method checkAll()
     * Melakukan pengecekan pada Todolist(array)
     * Jika tidak ada yang null return true
     * @return boolean
     */
    public boolean checkAll() {
        boolean check = false;

        for (Todolist todolist : data) {
            if (todolist != null) {
                check = true;
                break;
            }
        }

        return check;
    }

    /**
     * Method check(Integer number)
     * Melakukan pengecekan pada todolist
     * sesuai parameter
     * @return boolean
     */
    public boolean check(Integer number) {
        if (number > data.length) {
            return false;
        } else return data[number - 1] != null;
    }

    /**
     * Method update(Integer number, Todolist)
     * Mengubah data pada Todolist(array) sesuai parameter
     */
    @Override
    public boolean update(Integer number, Todolist todolist) {
        if (number > data.length) {
            return false;
        } else if (data[number - 1] == null) {
            return false;
        } else {
            data[number - 1] = todolist;
            return true;
        }
    }
}
