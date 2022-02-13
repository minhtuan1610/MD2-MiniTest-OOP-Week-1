import java.util.Scanner;

public class Operation {
    public static Book[] listBook = new Book[5];

    public static void main(String[] args) {
        listBook[0] = new Book("Doraemon", "Fujiko", 10000, 1, 0.2);
        listBook[1] = new Book("Dragon Ball", "Toriyama", 11000, 2, 0.25);
        listBook[2] = new Book("Ngay xua co mot chuyen tinh", "Nguyen Nhat Anh", 12000, 3, 0.3);
        listBook[3] = new Book("De men phieu luu ky", "To Hoai", 13000, 4, 0.35);
        listBook[4] = new Book("Tat den", "Ngo Tat To", 14000, 5, 0.4);
        //  Tinh tong so tien cua 05 tua sach
        int totalPrice = getTotalPrice(listBook);
        System.out.println("Tong so tien 05 tua sach la: " + totalPrice + " VND");
        //  Tinh tong khoi luong cua 05 tua sach
        double totalWeight = getTotalWeight(listBook);
        System.out.println("Tong khoi luong cua 05 tua sach la: " + totalWeight + " kg");
        //  Tim kiem sach
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten sach muon tim (khong dau):");
        String nameBook = scanner.nextLine();
        //  Tim kiem va in ra thong tin sach neu tim thay
        searchBook(nameBook);

    }

    public static int getTotalPrice(Book[] books) {
        int totalPrice = 0;
        for (int i = 0; i < books.length; i++) {
            totalPrice += books[i].getTotalPrice();
        }
        return totalPrice;
    }

    public static double getTotalWeight(Book[] books) {
        double totalWeight = 0;
        for (int i = 0; i < books.length; i++) {
            totalWeight += books[i].getTotalWeight();
        }
        return totalWeight;
    }

    public static void searchBook(String nameOfBook) {
        int index = indexOfBook(nameOfBook);
        if (index == -1) {
            System.out.println("KHONG co sach can tim");
        } else {
            System.out.printf("Tim thay sach: %s, Tac gia: %s, Don gia: %d, So luong con lai: %d, Khoi luong: %.2f",
                    listBook[index].getName(), listBook[index].getAuthor(), listBook[index].getPrice(),
                    listBook[index].getQuantity(), listBook[index].getWeight());
        }
    }

    public static int indexOfBook(String nameOfBook) {
        int index = -1;
        for (int i = 0; i < listBook.length; i++) {
            if (nameOfBook.equals(listBook[i].getName())) {
                index = i;
                break;
            }
        }
        return index;
    }
}
