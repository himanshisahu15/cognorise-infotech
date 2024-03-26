import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private boolean checkedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}

class LibraryCatalog {
    private ArrayList<Book> books;

    public LibraryCatalog() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public boolean checkOutBook(String title) {
        Book book = searchByTitle(title);
        if (book != null && !book.isCheckedOut()) {
            book.setCheckedOut(true);
            return true;
        }
        return false;
    }

    public boolean returnBook(String title) {
        Book book = searchByTitle(title);
        if (book != null && book.isCheckedOut()) {
            book.setCheckedOut(false);
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        LibraryCatalog library = new LibraryCatalog();

        // Adding books to the library
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook("To Kill a Mockingbird", "Harper Lee");
        library.addBook("1984", "George Orwell");

        // Checking out a book
        library.checkOutBook("To Kill a Mockingbird");

        // Returning a book
        library.returnBook("To Kill a Mockingbird");

        // Searching for books by title
        Book book = library.searchByTitle("1984");
        if (book != null) {
            System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());
        } else {
            System.out.println("Book not found.");
        }

        // Searching for books by author
        ArrayList<Book> booksByAuthor = library.searchByAuthor("F. Scott Fitzgerald");
        if (!booksByAuthor.isEmpty()) {
            System.out.println("Books by F. Scott Fitzgerald:");
            for (Book b : booksByAuthor) {
                System.out.println(b.getTitle());
            }
        } else {
            System.out.println("No books found by F. Scott Fitzgerald.");
        }
    }
}