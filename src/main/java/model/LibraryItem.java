package model;

public abstract class LibraryItem {

    private String id;
    private String title;
    private boolean isAvailable;

    public LibraryItem(String id, String title, boolean isAvailable){
        this.id = id;
        this.title= title;
        this.isAvailable=isAvailable;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public abstract void displayInfo();
}
