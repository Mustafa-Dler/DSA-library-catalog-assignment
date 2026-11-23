class BookNode {
    int bookID;
    String title;
    String author;
    int year;
    int copies;
    BookNode left;
    BookNode right;

    public BookNode (int bookID, String title, String author, int year, int copies) {
        this.bookID = bookID;
        this.author = author;
        this.title = title;
        this.author = author;
        this.year = year;
        this.copies = copies;
        this.left = null;
        this.right = null;
    }
}

class LibraryBST {
    BookNode root = null;

    //Mustafa Dler (Add, Search, Count)

    //Person 2 (Display, Range)

    //Person 3 (Remove, Next)
}

public class LibraryCatalog {
    public static void main(String[] args) {
        LibraryBST catalog = new LibraryBST();

        //Person 3 (The command parser)
    }
}

