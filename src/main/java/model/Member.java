package model;

import java.util.ArrayList;

public class Member {

    private String memberId;
    private String name;

    private ArrayList<LibraryItem> borrowedItems;

    public Member(String memberId, String name){
        this.memberId=memberId;
        this.name=name;
        this.borrowedItems = new ArrayList<>();
    }

    public void borrowItem(LibraryItem item){
        if(item.isAvailable()){
            borrowedItems.add(item);
            item.setAvailable(false);
        }else{
            System.out.println("Item is not available");
        }
    }

    public void returnItem(LibraryItem item){
        if(borrowedItems.contains(item)){
            borrowedItems.remove(item);
            item.setAvailable(true);
        }else{
            System.out.println("Item wa snot borrowed by the member");
        }

    }

    public void displayBorrowedItems(String[] args) {

        if (borrowedItems.isEmpty()){
            System.out.println("No Items borrowed");
        }else{
            System.out.println("======Borrowed Items=====");
            for(LibraryItem item: borrowedItems){
                System.out.println(item);
            }
        }
    }

}
