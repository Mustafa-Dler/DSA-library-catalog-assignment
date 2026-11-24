//Names & SIDs: Mustafa Dler (24053), Mustafa Ranj (24035), Alhamza saif (24010)

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
        this.year = year;
        this.copies = copies;
        this.left = null;
        this.right = null;
    }
}

class LibraryBST {
    BookNode root = null;

    //Mustafa Dler (Add, Search, Count)
    void add(int bookID, String author, String title, int year, int copies) {
        BookNode book = new BookNode(bookID, author, title, year, copies);
        BookNode current = root;

        if (root == null) {
            root = book;
            System.out.println("Added the book: " + "<" + book.bookID + ">" + ", " + "<"+ book.title + ">" + ", " + "<" + book.author + ">" + ", " + "<" + book.year + ">" + ", " + "<" + book.copies + ">");
            return;
        } else {
            while (root != null) {
                if (book.bookID == current.bookID){
                    current.copies += copies;
                    return;
                } else {
                    if (book.bookID < current.bookID) {
                        if (current.left == null) {
                            current.left = book;
                            System.out.println("Added the book: " + "<" + book.bookID + ">" + ", " + "<"+ book.title + ">" + ", " + "<" + book.author + ">" + ", " + "<" + book.year + ">" + ", " + "<" + book.copies + ">");
                            return;
                        } else {
                            current = current.left;
                        }
                    } else if(book.bookID > current.bookID) {
                        if (current.right == null) {
                            current.right = book;
                            System.out.println("Added the book: " + "<" + book.bookID + ">" + ", " + "<"+ book.title + ">" + ", " + "<" + book.author + ">" + ", " + "<" + book.year + ">" + ", " + "<" + book.copies + ">");
                            return;
                        } else {
                            current = current.right;
                        }
                    }
                }  
            }
        }
    }
    //Person 2 (Display, Range)

    //Person 3 (Remove, Next)
}

public class LibraryCatalog {
    public static void main(String[] args) {
        LibraryBST catalog = new LibraryBST();

        //Person 3 (The command parser)
    }
}

