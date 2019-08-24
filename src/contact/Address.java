package contact;

import java.util.Arrays;

public class Address{
    private String country,address;

    public Address(String address){

        this.address = address;
        String[] temp = address.split(";");
        this.country = temp[temp.length-1];
        
    }
    public String getCountry(){
        
        return this.country;
    }
    public String[] getAddress(){
        String[] temp = this.address.split(";");
        
        String[] done = new String[emptyStr(this.address)];
        int count = 0;
        for (int i = 0; i < temp.length; i++) {

            if (temp[i].length() != 0){
                 done[count] = temp[i];
                 count++;
            }
            
        }
        return done;
    }
    private int emptyStr(String add){
        String[] temp = add.split(";");
        int count = 0;
        for (String i: temp){
            if (i.length() !=0 ){
                count++;
            }
        }
        return count;
    }
    public String toString(){
        String[] address = getAddress();
        String i = "";
        for (String j: address){
            i+= j + "\n";
        }
        return i;
    }
    public static void main(String[] args) {
        Address address = new Address("1 Any Street;Any Town;;;Jamaica");
        
        System.out.println(address.getCountry());
        System.out.println(Arrays.asList(address.getAddress()));
        System.out.println(address);
    }
}