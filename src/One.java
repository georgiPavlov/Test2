import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by georgipavlov on 16.11.15.
 */
public class One {
    boolean  isOdd(int n){
        int odd =n%2;
        if (odd == 0){
            return false;
        }
        return true;
    }


    boolean isPrime(int n){
        if (n % 2 == 0) return false;
        for (int i = 3; i * i < n; i += 2)
            if (n % i == 0) return false;
        return true;
    }

    int findMin(int[] arr){
        int j=arr[0];
        for (int i = 1; i <arr.length; i++) {
           if (j> arr[i]){
               j=arr[i];
           }
        }
        return j;
    }


    int getAverage(int[] arr){
        int n=0;
        for (int i = 0; i <arr.length ; i++) {
            n+=arr[i];
        }
        return n/arr.length;
    }


    long doubleFac(int n){
        int fac=0;
        for (int i = 0; i <= n; i++) {
            fac *=i;
        }

        for (int i = 0; i <= n; i++) {
            fac *=i;
        }

        return fac;
    }

    long getSmallestMultiple(int upperBound){
        int n=upperBound;
        p: for (int i = 1; i <upperBound ; i++) {
            for (int j = 0; j < upperBound; j++) {
                if(j%i == 0 && n> i){
                    n=i;
                }else if(j%i != 0){
                    continue p;
                }
            }

        }
        return n;
    }


    long getLargestPalindrome(long N){
        long temp=0;
        for (long i = 0; i < N; i++) {
           if(i<9 && temp<i){
               temp=i;
           }else if (itIsPalindrome(i) && temp<i){
               temp=i;
           }
        }
        return temp;
    }

    boolean itIsPalindrome(int i){
       String num= Integer.toString(i);
        int size=num.length();
        int frond=0;
        int back=size;
        char start=num.charAt(frond);
        char end=num.charAt(back);

        while (frond <= back){


                if(!(frond == back){
                    return false;
                }
                frond++;
                 back--;

            return true;
        }
    }


    int[] matrix(short[][] image){
        Map<Short,Integer> map= new HashMap<>();
        int[] result = new int[255];

            for (short j = 0; j < image[0].length ; j++) {
                for (short k = 0; k < image.length; k++) {

                    Integer count = map.get(image[j][k]);
                    if(count == null){
                        count = 0;
                    }
                    map.put(image[j][k],count+1);
                }
            }


        for(Map.Entry<Short,Integer> mapE: map.entrySet()){
          result[mapE.getKey()]=mapE.getValue();
        }
      return result;


    }

    int pow( int a, int b) {
        if (b == 0) return 1;
        int temp = pow(a, b/2);
        if (b % 2 == 0){
            return temp * temp;
        }
        else{
            return (a * temp * temp);
        }
    }

    int getOddOccurrence(int... array){

        int result=0;
        for (int i = 0; i < array.length; i++) {
          result ^=array[i];
        }
        return result;
    }

    int maxSpan(int[] numbers){
        Hashtable<Integer,Integer> map=new Hashtable<>();
        int num;
        int max=0;
        for (int i = 0; i < numbers.length; i++) {
            num=numbers[i];
            if (map.containsKey(num)){
                int span=i-map.get(num) +1;
                if (span>max){
                    max=span;
                }
            }else {
                map.put(num,i);
            }
        }
        return max;
    }

    boolean canBalance(int[] numbers){
        int c;
        int size=numbers.length;
        if (size%2 == 0){
            c=0;
        }else {
            c=1;
        }
        Map<Integer,Integer> a=new HashMap<>();
        for (short k = 0; k < numbers.length; k++) {

            Integer count = a.get(numbers[k]);
            if(count == null){
                count = 0;
            }
            a.put(numbers[k],count+1);
        }
        int count=0;
        for(Map.Entry<Integer,Integer> mapE: a.entrySet()){
            if(mapE.getValue()%2 !=0 ){
                count++;
            }
        }
        if (count > c){
            return false;
        }else {
            return true;
        }
    }

    int[][] rescale(int[][] original, int newWidth, int newHeight){
        int xSum=0;
        int ySum=0;

        for (int i = 0; i <original[0].length ; i++) {
            ySum += original[i][0];
        }

        for (int j = 0; j < original.length; j++) {
            xSum += original[j][0];
        }
        int arr[][] = new int[2][2];
        newHeight=ySum/original[0].length;
        newWidth=xSum/original.length;
        arr[0][0]=newWidth;
        arr[1][0]=newHeight;

        return arr;
    }


    String reverseMe(String argument){
        return argument.
    }




































}
