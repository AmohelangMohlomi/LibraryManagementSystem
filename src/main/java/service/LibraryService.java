package service;

import model.Book;
import model.LibraryItem;
import model.Member;

import java.util.ArrayList;

public class LibraryService {

    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public LibraryService(){
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book){
       books.add(book);
    }

    public void registerMember(Member member){
        members.add(member);
    }

    public void borrowBook(String memberId, String bookId){
        for(Member member : members){
            if (memberId.equals(member.getMemberId())){
                for (Book book:books){
                    if(bookId.equals(book.getId())){
                        if(book.isAvailable()){
                            member.borrowItem(book);
                            book.setAvailable(false);
                            System.out.println("Book borrowed successfully");
                        }
                        else{
                            System.out.println("Sorry the book is not available");
                        }
                    }
                }
            }
        }

    }

    public void returnBook(String memberId, String bookId){
        for (Member member: members){
            if(memberId.equals(member.getMemberId())){
                for(LibraryItem item:member.getBorrowedItems()){
                    if(bookId.equals(item.getId())){
                        member.returnItem(item);
                        item.setAvailable(true);
                        System.out.println("Book returned successfully");
                        return;
                    }

                }
                System.out.println("Failed to return item");
                return;
            }
        }
    }

    public void listAvailableBooks() {
        for (Book book : books) {
            if (book.isAvailable()) {
                book.displayInfo();
            }
        }
    }

    public void listBorrowedBooksByMember(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                member.displayBorrowedItems();
                return;
            }
        }
        System.out.println("Member not found");
    }
}
