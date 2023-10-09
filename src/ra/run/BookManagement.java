package ra.run;

import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    public static List<Book> books = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean inMenu = true;

        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số sách và nhập thông tin sách");
            System.out.println("2. Hiển thị thông tin các sách");
            System.out.println("3. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm sách theo tên sách");
            System.out.println("6. Thay đổi trạng thái của sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.println();
            System.out.println("Nhập vào lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    sortByInterest();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    searchByName();
                    break;
                case 6:
                    changeStatusById();
                    break;
                case 7:
                    System.out.println("Bạn đã thoát khỏi chương trình!");
                    inMenu = false;
                    break;
                default:
                    System.err.println("Không có lựa chọn " + choice + ", vui lòng chọn lại!");
                    break;
            }
        } while (inMenu);
    }

    private static void changeStatusById() {
        do {
            System.out.println("Nhập vào mã sách muốn thay đổi trạng thái: ");
            int id = Integer.parseInt(sc.nextLine());
            int index = -1;

            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getBookId() == id) {
                    index = i;
                }
            }

            if(index != -1) {
                books.get(index).setBookStatus(!books.get(index).isBookStatus());
                break;
            } else {
                System.err.println("Mã sách không tồn tại, vui lòng nhập lại!");
            }
        } while (true);
    }

    private static void searchByName() {
        System.out.println("Nhập vào tên sách muốn tìm kiếm:");
        String name = sc.nextLine().trim().toLowerCase();
        List<Integer> indexs = new ArrayList<>();

        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getBookName().trim().toLowerCase().contains(name)) {
                indexs.add(i);
            }
        }

        if(indexs.isEmpty()) {
            System.err.println("Không tìm thấy kết quả nào!");
        } else {
            System.out.println("Những sách phù hợp với kết quả tìm kiếm là:");
            for (Integer index : indexs) {
                books.get(index).displayData();
            }
        }
    }

    private static void deleteBook() {
        do {
            System.out.println("Nhập vào mã sách muốn xóa: ");
            int id = Integer.parseInt(sc.nextLine());
            int index = -1;

            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getBookId() == id) {
                    index = i;
                }
            }

            if(index != -1) {
                books.remove(index);
                break;
            } else {
                System.err.println("Mã sách không tồn tại, vui lòng nhập lại!");
            }
        } while (true);
    }

    private static void sortByInterest() {
        Collections.sort(books);
        System.out.println("Danh sách sau khi sắp xếp là:");
        System.out.println();
        books.forEach(Book::displayData);
        System.out.println();
    }

    private static void show() {
        System.out.println("-------------------Thông tin tủ sách-------------------");
        books.forEach(Book::displayData);
    }

    private static void addBook() {
        System.out.println("Nhập vào số lượng sách muốn thêm:");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            Book newBook = new Book();
            newBook.inputData(sc);
            books.add(newBook);
        }
    }
}
