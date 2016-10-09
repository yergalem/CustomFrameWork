package di.lib;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.google.inject.Inject;
import di.library.*;

import di.library.LoanItem;
import di.library.Member;

/**
 *
 */
final public class Book implements LoanItem,   Serializable {

	private static final long serialVersionUID = 6110690276685962829L;
	private BookCopy[] copies;
	private String authors;
	private String isbn;
	private String publisher;
	private String genre;
	private double price;
	private LocalDate borrowedDate;
	private LocalDate publishedDate;
	
	@Inject
	public Book(){}
	
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	public LocalDate getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(LocalDate borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setCopies(BookCopy[] copies) {
		this.copies = copies;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setMaxCheckoutLength(int maxCheckoutLength) {
		this.maxCheckoutLength = maxCheckoutLength;
	}

	private String title;
	private int maxCheckoutLength;

	public Book(String isbn, String title, int maxCheckoutLength, String authors) {
		this.isbn = isbn;
		this.title = title;
		this.maxCheckoutLength = maxCheckoutLength;
		this.authors = authors;
		copies = new BookCopy[]{new BookCopy(this, 1, true)};

	}

	public void updateCopies(BookCopy copy) {
		for(int i = 0; i < copies.length; ++i) {
			BookCopy c = copies[i];
			if(c.equals(copy)) {
				copies[i] = copy;
			}
		}
	}


	public List<Integer> getCopyNums() {
		List<Integer> retVal = new ArrayList<>();
		for(BookCopy c : copies) {
			retVal.add(c.getCopyNum());
		}
		return retVal;

	}

	public void addCopy() {
		BookCopy[] newArr = new BookCopy[copies.length + 1];
		System.arraycopy(copies, 0, newArr, 0, copies.length);
		newArr[copies.length] = new BookCopy(this, copies.length +1, true);
		copies = newArr;
	}

	public void addCopy(int numOfcopies) {
		while(numOfcopies != 0){
			addCopy();
			numOfcopies--;
		}
	}


	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(ob.getClass() != getClass()) return false;
		Book b = (Book)ob;
		return b.isbn.equals(isbn);
	}


	public boolean isAvailable() {
		if(copies == null) {
			return false;
		}
		return Arrays.stream(copies)
				     .map(l -> l.isAvailable())
				     .reduce(false, (x,y) -> x || y);
	}
	
	public int getNumCopies() {
		return copies.length;
	}

	public String getTitle() {
		return title;
	}
	public BookCopy[] getCopies() {
		return copies;
	}

	public String getAuthors() {
		return authors;
	}

	public String getIsbn() {
		return isbn;
	}

	public BookCopy getNextAvailableCopy() {
		Optional<BookCopy> optional
			= Arrays.stream(copies)
			        .filter(x -> x.isAvailable()).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public BookCopy getCopy(int copyNum) {
		for(BookCopy c : copies) {
			if(copyNum == c.getCopyNum()) {
				return c;
			}
		}
		return null;
	}
	public int getMaxCheckoutLength() {
		return maxCheckoutLength;
	}

	@Override
	public String toString() {
		return "Book [copies=" + copies.length + ", authors=" + authors + ", isbn=" + isbn + ", title="
				+ title + ", maxCheckoutLength=" + maxCheckoutLength + "]";
	}

	public void addPrice() {
		
		price+=price * 0.2;
	}

        
        

    double fine;
    Member mem;

   @Override
    public void accept(FineCal fn) {
        fn.visit(this);
    }

    public Member getMem() {
        return mem;
    }

    public double getFine() {
        //  if(returnDate-borrowedDate>=21)
        return mem.getMaturity() == "A" ? 0.10 : 0.05;
    }

    public Book(Member mem) {
        this.mem = mem;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public void setMem(Member mem) {
        this.mem = mem;
    }

    

   

   
      


}
