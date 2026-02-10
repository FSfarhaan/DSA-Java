import java.util.ArrayList;
import java.util.Arrays;

public class BooksAllocation {

    static int getPagesDistribution(ArrayList<Integer> books, int pages) {
        int students = 1;
        int sumPages = 0;
        for(int i : books) {
            if(i + sumPages <= pages) {
                sumPages += i;
            } else {
                students++;
                sumPages = i;
            }
        }
        return students;
    }

    static int getBooksAllocation(ArrayList<Integer> books, int students) {
        int min = books.stream().mapToInt(Integer::intValue).max().getAsInt();
        int max = books.stream().mapToInt(Integer::intValue).sum();

        for(int i = min; i <= max; i++) {
            if(getPagesDistribution(books, i) == students) {
                return i;
            }
        }
        return -1;
    }

    static int OptGetBooksAllocation(ArrayList<Integer> books, int n, int students) {
        if(n < students) return -1;
        int low = books.stream().mapToInt(Integer::intValue).max().getAsInt();
        int high = books.stream().mapToInt(Integer::intValue).sum();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(getPagesDistribution(books, mid) <= students) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
    public static void main(String[] args) {
        ArrayList<Integer> books = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        int students = 4;
        // System.out.println("The answer is: " + getBooksAllocation(books, students));
        System.out.println("The answer is: " + OptGetBooksAllocation(books, books.size(), students));

    }   
}
