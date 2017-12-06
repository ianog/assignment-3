
/**
 * Describes a bookstore
 *
 * @author Aaron 
 * @version Dec 2
 */

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class BookStore
{
    // instance variables - replace the example below with your own
    private String  storeName;
    private Book[]  inventory;
    private File    bookList;

    public static final int ZERO  = 0;
    public static final int ONE   = 1;
    public static final int TWO   = 2;
    public static final int THREE = 3;
    public static final int FOUR  = 4;
    public static final Date DEFAULT_DATE = new Date(2013,1,1);

    /**
     * Default BookStore Constructor
     * storeName is null
     * Sets the inventory
     */
    public BookStore()
    {

        inventoryCreator();

    }

    /**
     * @param storeName the name of the BookStore
     * cannot be "Taylor's Used Books", will default to "Jason's Used Books"
     */
    public BookStore(String storeName)
    {
        storeNameValidator(storeName);
        inventoryCreator();
    }

    /*
     * this validates the storeName parameter
     * storeName cannot be "Taylor's Used Books", defaults to "Jason's Used books"
     */
    private void storeNameValidator(String storeName){
        if (storeName != null){
            if (storeName.equalsIgnoreCase("Taylor's Used Books")){
                this.storeName = "Jason's Used Books";       
            }else
                this.storeName = storeName;
        }
    }

    /*
     * this creates the inventory array of Book Objects.
     * it scans text file BookList.txt located in the same folder as this class and imports the information
     * for each row of the BookList file, the book infomation is listed: BOOK NAME (tab) Author first Name (tab) author last name(tab) author middle name (if no middle name, enter null)
     * this sets the published date for each book and for the birth and death date of the author to DEFAULT_DATE
     */
    private void inventoryCreator(){
        ArrayList<String> books = new ArrayList<String>(); // temporary list to hold books from scanner
        bookList                = new File("BOOKLIST.txt");
        if (bookList.exists()){
            try{//create scanner
                Scanner fileScanner = new Scanner(bookList);
                while (fileScanner.hasNextLine()){
                    books.add(fileScanner.nextLine());
                }
                fileScanner.close();
            }catch(FileNotFoundException e){
                System.out.println("ERROR");
            }

        }

        int size = books.size();// get size of books array list for creating arrays
        String[] arr1 = new String[size]; // title
        String[] arr2 = new String[size]; // first name
        String[] arr3 = new String[size]; // last name
        String[] arr4 = new String[size]; // middle

        for (int i = ZERO; i<size; i++){ // separate lines int columns and store in arrays

            String[] temporary = books.get(i).split("\\t", 4);
            arr1[i] = temporary[ZERO];
            arr2[i] = temporary[ONE];
            arr3[i] = temporary[TWO];
            arr4[i] = temporary[THREE];
        }

        for (int i = ZERO; i<size; i++){
            if (arr4[i].equals("null")||(arr4[i].equals(""))){
                arr4[i] = null;
            }
        }

        inventory = new Book[size];

        for (int i = ZERO; i<size; i++){
            inventory[i] = new Book(new Author(new Name(arr2[i], arr3[i], arr4[i]),DEFAULT_DATE,DEFAULT_DATE),DEFAULT_DATE,arr1[i]);
        }
    }

    /**
     * get method for String storeName
     * @return storeName
     */
    public String getStoreName(){
        return storeName;
    }

    /**
     * get method for Book[] inventory
     * @return inventory
     */
    public Book[] getInventory(){
        return inventory;
    }

    /**
     * get method for File booklist
     * @return the bookList object
     */
    public File getBooklist(){
        return bookList;
    }

    /**
     * set method for String storeName
     * @param newStoreName the new name
     */
    public void setStoreName(String newStoreName){
        storeNameValidator(newStoreName);
    }

    /**
     * set method for Book[] inventory
     * @param newInventory the new inventory
     */
    public void setInventory(Book[] newInventory){
        inventory = newInventory;
    }

    /**
     * set method for File bookList. updates bookList File object and initializes the new booklist into inventory
     * @param newBookList the new BookList file
     */
    public void setBookList(File newBookList){
        bookList = newBookList;
        inventoryCreator();
    }

    /**
     * returns the number of books written by an author with the given last Name
     * @param authorLastName the author's last name
     * @return the number of books written by the author, returns ZERO for no results 
     */
    public int howManyBooksDidThisAuthorWrite(String authorLastName){
        int count = ZERO;

        if(inventory != null){
            for(Book book: inventory){
                if(book != null){
                    if(book.getAuthor().getName().getLastName() != null){
                        if (book.getAuthor().getName().getLastName().equalsIgnoreCase(authorLastName)){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * returns the full author name of a title
     * @param title the title of the book
     * @return the author's full name using the book.getAuthorName() method.
     */
    public String getAuthorFullName(String title){
        String authorName = null;
        if(inventory != null){
            for (Book book : inventory){
                if (book!= null){
                    if (book.getTitle().equalsIgnoreCase(title)){
                        authorName = book.getAuthorName();

                    }                    
                }
            }
        }
        return authorName;
    }

    /**
     * returns an array of books that were written by the author
     * @param authorLastName the author's last name
     * @return an array of Books that were written by the author
     */
    public Book[] getBooksWrittenBy(String authorLastName){
        int numberOfMatches = ZERO;
        int y               = ZERO;
        if (inventory != null){
            for (Book book: inventory){
                if (book != null){
                    if (book.getAuthor().getName().getLastName().equalsIgnoreCase(authorLastName)){
                        numberOfMatches ++;                        
                    } 
                }
            }
        }

        Book[] matches = new Book[numberOfMatches];
        
        if(numberOfMatches > ZERO){ 
            if (inventory != null){
                for (Book book: inventory){
                    if (book != null){
                        if (book.getAuthor().getName().getLastName().equalsIgnoreCase(authorLastName)){
                            matches[y] = book;
                            y++;

                        }
                    }
                }
            }

        }else{
        matches = null;
        }
        return matches;
    }

    /**
     * returns the first book in the inventory written by the author
     * @param firstName the first name of the author
     * @return the first book in the inventory written by the author
     */
    public Book getBookWrittenBy(String firstName){
        Book firstResult = null;
        if(inventory != null){
            for (Book book : inventory){
                if (book!= null){
                    if (book.getAuthor().getName().getFirstName().equalsIgnoreCase(firstName)){
                        firstResult = book;
                        return firstResult;
                    }
                }
            }
        }
        return firstResult;
    }

    /**
     * returns an array of books who's titles contain the given string
     * @param wordInTitle the string to search
     * @return the array of titles that contain the wordInTitle string
     */
    public String[] getBookTitlesContaining(String wordInTitle){
        int numberOfMatches = ZERO;
        int i               = ZERO;
        int y               = ZERO;
        if (inventory != null){
            for (Book book: inventory){
                if (book != null){
                    if (book.getTitle().toLowerCase().contains(wordInTitle.toLowerCase())){
                        numberOfMatches ++;
                        i++;
                    } 
                }
            }
        }

        String[] matches = new String[numberOfMatches];

        if (inventory != null){
            for (Book book: inventory){
                if (book != null){
                    if (book.getTitle().toLowerCase().contains(wordInTitle.toLowerCase())){
                        matches[y] = book.getTitle();
                        y++;

                    }
                }
            }
        }
        return matches;
    }
}

