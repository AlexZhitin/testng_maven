package OOP;

public class Inheritence {


    static class Super{
        public void superMethod(){
            System.out.println("ddd");
        }
    }

    static class Child extends Super{
        public static void main(String[] args){
            Child obj = new Child();
            obj.superMethod();
        }
    }
}