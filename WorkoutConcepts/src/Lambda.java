import java.util.function.Predicate;

interface MyFunction{
    int add(int a,int b);
}

public class Lambda {

    public static void main(String[] args) {

        MyFunction function = (a,b)->a+b;

        int result = function.add(3,8);
        System.out.println(result);


        Predicate<Integer> hello = Lambda::predicateExample;
      Boolean res=  hello.test(40);
      System.out.println(res);

      reverseString();;

    }


    static Boolean predicateExample(int age){
        return age > 79;
    }

    public static void reverseString(){
        String str ="Programming";

        StringBuilder sb = new StringBuilder();

        for(int i=str.length()-1;i>=0;i--){
            sb.append(str.charAt(i));

        }
        System.out.println(sb);
    }
}
