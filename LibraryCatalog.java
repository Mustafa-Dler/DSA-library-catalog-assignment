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
    //Insert a new book into the BST, adds to a books existing copies if bookID already exists
    public void add(int bookID, String author, String title, int year, int copies) {
        BookNode book = new BookNode(bookID, author, title, year, copies);
        BookNode current = root;

        //Checks for empty tree
        if (root == null) {
            root = book;
            System.out.println("Added the book: " + "<" + book.bookID + ">" + ", " + "<"+ book.title + ">" + ", " + "<" + book.author + ">" + ", " + "<" + book.year + ">" + ", " + "<" + book.copies + ">");
            return;
        } else {
            while (root != null) {
                if (book.bookID == current.bookID){
                    //Duplicate ID found, increment copies instead of adding a new node to the tree
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

    //Searches the BST by the bookID and prints book details or a notfound message
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
        }
        //Reached a null branch without finding the ID
         System.out.println("Book not found.");
    }
    
    //Counts total distinct titles and total copies across all books in the catalog
    public void count() {
        int[] counts = new int[2]; //counts[0] = distinct titles, counts[1] = total copies
        travserseCount(root, counts);
        System.out.println("Total distinct titles: " + counts[0] + ", Total copies: " + counts[1]);
    }

    //Helper function that uses inorder traversal to tally nodes and sum copies
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

