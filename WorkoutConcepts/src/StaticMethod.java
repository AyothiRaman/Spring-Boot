


class A{
    static int counter;
    static int h=8;
    static int a;




    public static void hello(){
        counter++;
        System.out.println(counter);

        a=h;
        h=9;
        h=0;
        a=h;
    }
}

public class StaticMethod {

    public static void main(String[] args) {

        A.hello();


    }


}
