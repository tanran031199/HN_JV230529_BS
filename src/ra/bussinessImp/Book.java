package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Scanner;

public class Book implements IBook, Comparable<Book> {
    int bookId, numberOfPages;
    String bookName, title;
    float importPrice, exportPrice, interest;
    boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, int numberOfPages, String bookName, String title, float importPrice, float exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.numberOfPages = numberOfPages;
        this.bookName = bookName;
        this.title = title;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.bookStatus = bookStatus;
        this.interest = exportPrice - importPrice;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("Nhập vào mã sách:");
        setBookId(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhập vào tên sách: ");
        setBookName(sc.nextLine());
        System.out.println("Nhập vào tiêu đề sách: ");
        setTitle(sc.nextLine());
        System.out.println("Nhập vào số trang sách: ");
        setNumberOfPages(Integer.parseInt(sc.nextLine()));

        do {
            System.out.println("Nhập vào giá mua sách: ");
            float importPrice = Float.parseFloat(sc.nextLine());

            if (importPrice < 0) {
                System.err.println("Giá mua sách cần > 0");
            } else {
                setImportPrice(importPrice);
                break;
            }
        } while (true);

        do {
            System.out.println("Nhập vào giá bán sách: ");
            float exportPrice = Float.parseFloat(sc.nextLine());

            if (exportPrice < importPrice) {
                System.err.println("Giá bán sách cần lớn hơn giá mua sách!");
            } else {
                setExportPrice(exportPrice);
                break;
            }
        } while (true);

        do {
            System.out.println("Nhập vào trạng thái sách: ");
            System.out.println("1. true");
            System.out.println("2. false");
            System.out.println();
            System.out.println("Nhập vào lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                setBookStatus(true);
                break;
            } else if (choice == 2) {
                setBookStatus(false);
                break;
            } else {
                System.err.println("Không có lựa chọn " + choice + ", vui lòng chọn lại!");
            }
        } while (true);

        interest = exportPrice - importPrice;
    }

    @Override
    public void displayData() {
        System.out.println();
        System.out.println("Mã sách: " + getBookId());
        System.out.println("Tên sách: " + getBookName());
        System.out.println("Tiêu đề sách: " + getTitle());
        System.out.println("Số trang sách: " + getNumberOfPages());
        System.out.println("Giá mua vào: " + getImportPrice());
        System.out.println("Giá bán ra: " + getExportPrice());
        System.out.println("Lợi nhuận: " + getInterest());
        System.out.println("Trạng thái: " + isBookStatus());
        System.out.println();
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public int compareTo(Book o) {
        return - ((int) (this.interest - o.getInterest()));
    }
}
