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
    public void add(int bookID, String author, String title, int year, int copies) {
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

    public void search (int bookID) {
        BookNode current = root;

        while (current != null) {
            if (bookID == current.bookID) {
                System.out.println("Found " + current.title + ", ID: " + current.bookID + ", author: " + current.author + ", year published: " + current.year + ", copies: " + current.copies);
                return;
            } else {
                if (bookID < current.bookID) {
                    current = current.left;
                }
                if (bookID > current.bookID) {
                    current = current.right;
                }
            }
        } System.out.println("Book not found.");
    }
    
    public void count() {
        int[] counts = new int[2];
        travserseCount(root, counts);
        System.out.println("Total distinct titles: " + counts[0] + ", Total copies: " + counts[1]);
    }

    private void travserseCount(BookNode book, int[] counts) {
        if (book == null) {
            return;
        } else {
            travserseCount(book.left, counts);
            counts[0]++;
            counts[1] += book.copies;
            travserseCount(book.right, counts);
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

