package OOP;

public class Encapsul {


    public static class Person {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String newName) {
            this.name = newName;
        }
    }



    public static void main(String[]args){
        Person person = new Person();
        person.setName("John");
        System.out.println(person.getName());
    }

}
