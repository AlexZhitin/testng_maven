public class test {
    static int power(int exp, int base, int r) {
        while (exp != 0) {
            exp--;
           r =r*base;
        }
        return r;
    }



    public static void main(String[] args) {
        System.out.println(power(3, 2, 1));
            }
        }


       /* for (int i=0; i<5; i++){
            System.out.println(i);
        }*/

        /*int i = 0;
        while(i <5){
            System.out.println(i);
            i++;
        }*/



       /* int basenumber = 2, exponent = 3;
        int temp = 1;

        for (;exponent != 0; --exponent) {
           *//* temp *= basenumber;*//* //same as temp = temp * basenumber
            temp = temp * basenumber;
        }

        System.out.println("Result: " + temp);*/


      /*  int basenumber = 2, exponent = 3;
        int result = 1;

       while(exponent !=0){
           result = result*basenumber;
           exponent--;
       }

        System.out.println("Result: " + result);*/

