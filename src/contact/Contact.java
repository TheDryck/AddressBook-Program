package contact;

import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Contact extends Person {
    private static int count = 0;
    private int entryNum;
    private Address address;
    private ArrayList<String> emailList;
    private ArrayList<Phone> phoneList;
    private String alias;
    private static ArrayList<String> aliasList = new ArrayList<String>();
    
    
    public Contact(String fname,String lname, String gender,long DOB){
        super(fname, lname, gender, DOB);
        count++;
        entryNum = count;
        this.emailList = new ArrayList<String>();
        this.phoneList = new ArrayList<Phone>();
    }
    public int getEntryNo(){
        return this.entryNum;
    }
    public int getAge(){
        // Calendar cal = Calendar.getInstance();
        // int year = cal.get(Calendar.YEAR);
        // int age = year - Integer.parseInt(Long.toString(DOB).substring(0, 4)) ;
        // return age;
        LocalDate today = LocalDate.now();                          //Today's date
        int year = Integer.parseInt(Long.toString(DOB).substring(0, 4));
        int month = Integer.parseInt(Long.toString(DOB).substring(4, 6));
        int day = Integer.parseInt(Long.toString(DOB).substring(6, 8));
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        LocalDate birthday = LocalDate.of(year, month, day);  //Birth date
         
        Period p = Period.between(birthday, today);
        return p.getYears();
    }
    public void updateName(String name){
        this.name.changeLastName(name);
    }
    public void setAddress(String address){
        this.address = new Address(address);
    }
    public String[] getAddress(){
        return this.address.getAddress();
    }
    public String getAlias(){
        return this.alias;
    }
    public void setAlias(String name){
        if (!aliasList.contains(name)){
            this.alias =  name;
            this.aliasList.add(name);
        }
    }
    public String getName(){
        return name.getLastName()+","+name.getFirstName();
    }

    public void addEmail(String email){
        this.emailList.add(email);
    }
    public void deleteEmail(String email){
        this.emailList.remove(email);
    }
    public String[] getEmailList(){
        String[] temp = new String[emailList.size()];

        for (int i = 0; i < emailList.size(); i++) {
            temp[i] = emailList.get(i);
        }
        return temp;
    }
    public void addPhone(char type,long number){
        
        Phone phone = new Phone(number, type);
        if (phoneList.size() < 5){
            phoneList.add(phone);
        }

    }
    public void deletePhone(long number){
        for (int i = 0; i < phoneList.size(); i++) {
            if (phoneList.get(i).getNumber()== number){
                phoneList.remove(i);
            }
        }
    }
    public String[] getPhoneList(){
        String[] temp = new String[phoneList.size()];
        for (int i = 0; i < phoneList.size(); i++) {

            temp[i] = phoneList.get(i).toString();
            
        }
        return temp;
    }
    
    public static void main(String[] args) {
        Contact contact = new Contact("John", "Brown", "male", 20110708);
        System.out.println("dcsd");
        System.out.println(contact.getAge());
        System.out.println(contact.getName());
        contact.updateName("james");
        System.out.println(contact.getName());
        System.out.println(contact.getEntryNo());
        contact.addEmail("email@email.com");
        contact.addEmail("jordan@email.com");
        System.out.println(Arrays.asList(contact.getEmailList()));
        contact.deleteEmail("email@email.com");
        System.out.println(Arrays.asList(contact.getEmailList()));
        contact.setAddress("1 Any Street;Any Town;;;Jamaica");
        System.out.println(Arrays.asList(contact.getAddress()));
        contact.addPhone('H', 8765245788l);
        contact.addPhone('H', 8766908731l);
        System.out.println(Arrays.asList(contact.getPhoneList()));
        Contact contact2 = new Contact("Peter", "Pan", "male", 20110708l);
        System.out.println(contact2.getEntryNo());
        LocalDate today = LocalDate.now();                          //Today's date

        LocalDate birthday = LocalDate.of(1995, 12, 16);  //Birth date
         
        Period p = Period.between(birthday, today);
        System.out.println(p.getYears());
        long a = 19951010;
    }
}