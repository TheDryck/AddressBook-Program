package contact;

public class Phone{
    private long num;
    private char type;
    public Phone(long num,char type){
        this.num = num;
        this.type = type;

    }
    public int getAreaCode(){
        String[] num = (Long.toString(this.num)).split("");
        String j = "";
        for (int i = 0; i < 3; i++) {
            j += num[i];
        }
        return Integer.parseInt(j);
    }

    public long getNumber(){
        return this.num;
    }

    public char getType(){
        return this.type;
    }
    public String toString(){

        String area = "("+ Integer.toString(getAreaCode()) + ") ";
        String[] num = (Long.toString(this.num)).split("");
        for (int i = 3; i < num.length; i++) {
            area += num[i];
            if (i == 5){
                area += "-";
            }
        }

        return area;

    }
    
    public static void main(String[] args) {
        Phone phone = new Phone(8765245788l, 'h');
        System.out.println(phone);
        System.out.println(phone.getAreaCode());
        System.out.println(phone.getNumber());

    }

}