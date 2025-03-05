
public class Main {

    public static void main(String[] args) {
        DynamicArray list = new DynamicArray();
        for(int i = 1 ; i <=5 ; i++)
            list.add(new Integer(i*10));
        list.printContent();
    }
}
