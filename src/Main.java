import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static String[] dataTodo = new String[5];

    public static void main(String[] args) {
       viewTodo();
    }

    /**
     * menampilkan todolist
     */
    public static void showTodo() {
        System.out.println("TODOLIST");
        for (int i = 0; i < dataTodo.length ; i++) {
            int no = i + 1;

            if (dataTodo[i] != null) {
                System.out.println(no + ". " + dataTodo[i]);
            }
        }
    }
    /**
     * method untuk melakukan testing : showTodo
     */
    public static void testShowTodo() {
        showTodo();
    }


    /**
     * menambah todolist
     */
    public static void addTodo(String todo) {

        // jika data penuh kapasitas diperbesar 2x
        boolean isFull = true;
        for (String data : dataTodo) {
            if (data == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            String[] tmp = dataTodo;

            dataTodo = new String[dataTodo.length * 2];

            // menambahkan data lama kedalam array yang baru
            for (int i = 0; i < tmp.length; i++) {
                dataTodo[i] = tmp[i];
            }
        }

        // menambahkan data jika ada yang null
        for (int i = 0; i < dataTodo.length; i++) {
            if (dataTodo[i] == null) {
                dataTodo[i] = todo;
                break;
            }
        }
    }

    /**
     * method untuk testing menambahkan todolist
     */
    public static void testAddTodo() {
        for (int i = 1; i <= 10 ; i++) {
            addTodo("ini data ke " + i);
        }
        showTodo();
    }


    /**
     * menghapus todolist
     */
    public static boolean removeTodo(Integer number) {
        if (number > dataTodo.length) {
            return false;
        } else if (dataTodo[number - 1] == null) {
            return false;
        } else {

            // jika data data berada di tengah,
            // data setelahnya menimpa data yang akan dihapus
            // dan akan dilooping hingga data terakhir
            for (int i = (number - 1); i < dataTodo.length; i++) {
                if ((i + 1) == dataTodo.length) {
                    dataTodo[i] = null;
                } else {
                    dataTodo[i] = dataTodo[i + 1];
                }
            }
            return true;
        }
    }

    /**
     * method untuk testing remove todolist
     */
    public static void testRemoveTodo() {
        addTodo("pertama");
        addTodo("kedua");
        addTodo("ketiga");
        addTodo("empat");
        addTodo("lima");

        boolean isSucces = removeTodo(3);
        System.out.println(isSucces);

        showTodo();
    }


    /**
     * mengedit todolist
     */
    public static boolean checkUpdateTodo(Integer number) {
        if (number > dataTodo.length) {
            return false;
        } else return dataTodo[number - 1] != null;
    }

    public static boolean checkAllTodo() {
        boolean check = false;

        for (String todo : dataTodo) {
            if (todo != null) {
                check = true;
                break;
            }
        }

        return check;
    }

    public static boolean updateTodo(Integer number, String update) {
        if (number > dataTodo.length) {
            return false;
        } else if (dataTodo[number - 1] == null) {
            return false;
        } else {
            dataTodo[number - 1] = update;
            return true;
        }
    }

    /**
     * method untuk testing update todolist
     */
    public static void testUpdateTodo() {
        addTodo("pertama");
        addTodo("kedua");
        addTodo("ketiga");
        showTodo();

        boolean test = updateTodo(2, "kedua di edit");
        System.out.println();

        showTodo();
        System.out.println(test);
    }


    /**
     * mengembalikan string yang user inputkan
     */
    public static String input(Scanner sc, String info) {
        System.out.print(info + " : ");
        return sc.nextLine();
    }

    /**
     * method untuk testing input
     */
    public static void testInput() {
        String inputUser = input(sc, "Nama");

        System.out.println(inputUser);
    }

    /**
     * menampilkan view todolist
     */
    public static void viewTodo() {
        label:
        while (true) {
            showTodo();
            System.out.println("Pilih Menu");
            System.out.println("1. Tambah");
            System.out.println("2. Edit");
            System.out.println("3. Hapus");
            System.out.println("x. Keluar");
            String inputMenu = menuTodo(sc);

            switch (inputMenu) {
                case "1":
                    viewAddTodo();
                    break;
                case "2":
                    viewUpdateTodo();
                    break;
                case "3":
                    viewRemoveTodo();
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
     * method untuk testing tampilan show todolist
     */
    public static void testViewShowTodo() {
        for (int i = 1; i <= 5 ; i++) {
            addTodo("ini data ke " + i);
        }
        viewTodo();
    }

    /**
     * mengembalikkan input user,
     * saat memilih menu berdasarkan nomro
     */
    public static String menuTodo(Scanner sc) {
        System.out.print("Masukkan menu : ");

        return sc.nextLine();
    }

    /**
     * menampilkan view menambah todolist
     */
    public static void viewAddTodo() {
        System.out.println("MENAMBAH TODOLIST");
        String todo = input(sc, "Masukkan todolist (\"x\" jika batal)");
        if (!todo.equals("x")) {
            addTodo(todo);
        }
    }

    /**
     * method untuk testing tampilan menambah todolist
     */
    public static void testViewAddTodo() {
        viewAddTodo();

        showTodo();
    }

    /**
     * menampilkan view menghapus todolist
     */
    public static void viewRemoveTodo() {
        System.out.println("MENGHAPUS TODOLIST");
        String inputRemove = input(sc, "Nomor yang akan dihapus (\"x\" jika batal)");

        if (!inputRemove.equals("x")) {
            boolean isSucces = removeTodo(Integer.parseInt(inputRemove));

            if (isSucces) {
                System.out.println("Berhasil, anda telah menghapus nomor " + inputRemove);
            } else {
                System.out.println("Gagal mengahpus nomor " + inputRemove);
            }
        }

    }

    /**
     * method untuk testing tampilan saat remove todolist
     */
    public static void testViewRemove() {
        addTodo("pertama");
        addTodo("kedua");
        addTodo("ketiga");
        addTodo("keempat");
        addTodo("kelima");

        viewRemoveTodo();

        showTodo();

    }


    /**
     * tampilan untuk memperbarui/mengedit todolist
     */
    public static void viewUpdateTodo() {
        boolean checkIndex = false;
        boolean updateSucces;
        if (checkAllTodo()) {
            System.out.println("MENGEDIT TODOLIST");
            String inputIndex = input(sc, "Nomor yang akan diedit (\"x\" jika batal)");

            if (!inputIndex.equals("x")) {
                checkIndex = checkUpdateTodo(Integer.valueOf(inputIndex));
            }

            if (!inputIndex.equals("x") && checkIndex) {
                String inputEdit = input(sc, "Edit (\"x\" jika batal)");

                if (!inputEdit.equals("x")) {
                    updateSucces = updateTodo(Integer.valueOf(inputIndex), inputEdit);

                    if (updateSucces) {
                        System.out.println("Berhasil mengedit todolist");
                    } else {
                        System.out.println("Gagal mengedit toddolist");
                    }
                }

            }
        }
    }

    /**
     * method untuk testing tampilan update todolist
     */
    public static void testViewUpdateTodo() {
        addTodo("pertama");
        addTodo("kedua");
        addTodo("ketiga");
        viewTodo();
    }



}
