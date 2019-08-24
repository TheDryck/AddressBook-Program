package contact;

public class Name{
    private String fname,lname;

    public Name(String fname,String lname){
        this.fname=fname;
        this.lname=lname;
    }

    public String getFirstName(){
        return this.fname;
    }
    public String getLastName(){
        return this.lname;
    }
    public void changeLastName(String newName){
        this.lname = newName;

    }
}