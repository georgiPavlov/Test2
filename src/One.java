import com.sun.deploy.util.StringUtils;
import org.apache.commons.lang.StringUtils

import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import static org.apache.commons.lang.StringUtils.contains;
import static org.apache.commons.lang.StringUtils.countMatches;

/**
 * Created by georgipavlov on 16.11.15.
 */
public class One {
    boolean isOdd(int n) {
        if(n<-2147483648 || n> 2147483647){
            System.out.println("It is not Integer");
            return false;
        }
        int odd = n % 2;
        if (odd == 0) {
            return false;
        }
        return true;
    }


    boolean isPrime(int n) {
        if(n<-2147483648 || n> 2147483647){
            System.out.println("It is not Integer");
            return false;
        }
        if (n % 2 == 0) return false;
        for (int i = 3; i * i < n; i += 2)
            if (n % i == 0) return false;
        return true;
    }

    int findMin(int[] arr) {
        try {
            int j = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (j > arr[i]) {
                    j = arr[i];
                }
            }
            return j;
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }

    }


    int getAverage(int[] arr) {
        long n = 0;
        for (int i = 0; i < arr.length; i++) {
            if(n<-2147483648 || n> 2147483647){
                System.out.println("It is not Integer");
                return 0;
            }
            n += arr[i];

        }
        int nn= (int) n;
        return nn / arr.length;
    }


    long doubleFac(int n) {
        long fac = 0;
        BigInteger bigFac = BigInteger.valueOf(1);
        for (int i = 0; i <= n; i++) {
            bigFac.multiply(BigInteger.valueOf(i));
            if (bigFac.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) == 1 ||
                    bigFac.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) == -1) {
                System.out.println("To big value");
                return 0;
            }
            fac *= i;

        }

             bigFac = BigInteger.valueOf(1);
        for (int i = 0; i <= n; i++) {
            bigFac.multiply(BigInteger.valueOf(i));
            if(bigFac.compareTo(BigInteger.valueOf(Long.MAX_VALUE))==1 ||
                    bigFac.compareTo(BigInteger.valueOf(Long.MIN_VALUE))==-1){
                System.out.println("To big value");
                return 0;
            }
            fac *= i;
        }

        return fac;
    }

    long getSmallestMultiple(int upperBound) {

        if(upperBound<0){
            System.out.println("Need to be positive");
            return -1;
        }
        long n = upperBound;
        p:
        for (int i = 1; i < upperBound; i++) {
            for (int j = 0; j < upperBound; j++) {
                if (j % i == 0 && n > i) {
                    n = i;
                } else if (j % i != 0) {
                    continue p;
                }
            }

        }
        return n;
    }


    long getLargestPalindrome(long N) {
        if(N==0){
            return 0;
        }
        if(N<0){
            System.out.println("Need to be positive");
            return -1;
        }
        long temp = 0;
        for (long i = 0; i < N; i++) {
            if (i < 9 && temp < i) {
                temp = i;
            } else if ((itIsPalindrome(i)) && temp < i) {
                temp = i;
            }
        }
        return temp;
    }

    boolean itIsPalindrome(long i) {
        int temp=0;
        if(i<0){
           temp=1;
        }
        String num = Long.toString(i);
        int size = num.length();
        int frond = temp;
        int back = size;


        while (frond <= back) {
            char start = num.charAt(frond);
            char end = num.charAt(back);

            if (!(start == end)) {
                return false;
            }
            frond++;
            back--;


        }
        return true;
    }


    int[] matrix(short[][] image) {

        Map<Short, Integer> map = new HashMap<>();
        int[] result = new int[255];

        for (short j = 0; j < image[0].length; j++) {
            for (short k = 0; k < image.length; k++) {

                Integer count = map.get(image[j][k]);
                if (count == null) {
                    count = 0;
                }
                map.put(image[j][k], count + 1);
            }
        }


        for (Map.Entry<Short, Integer> mapE : map.entrySet()) {
            result[mapE.getKey()] = mapE.getValue();
        }

        return result;


    }

    int pow(int a, int b) {
        if (b == 0) return 1;
        int temp = pow(a, b / 2);
        if (b % 2 == 0) {
            return temp * temp;
        } else {
            return (a * temp * temp);
        }
    }

    int getOddOccurrence(int... array) {

        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }
        return result;
    }

    int maxSpan(int[] numbers) {
        Hashtable<Integer, Integer> map = new Hashtable<>();
        int num;

        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            num = numbers[i];

            if (map.containsKey(num)) {
                int span = i - map.get(num) + 1;
                if (span > max) {
                    max = span;
                }
            } else {
                map.put(num, i);
            }
        }
        return max;
    }

    boolean canBalance(int[] numbers) {
        int c;
        int size = numbers.length;
        if (size % 2 == 0) {
            c = 0;
        } else {
            c = 1;
        }
        Map<Integer, Integer> a = new HashMap<>();
        for (short k = 0; k < numbers.length; k++) {

            Integer count = a.get(numbers[k]);
            if (count == null) {
                count = 0;
            }
            a.put(numbers[k], count + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> mapE : a.entrySet()) {
            if (mapE.getValue() % 2 != 0) {
                count++;
            }
        }
        if (count > c) {
            return false;
        } else {
            return true;
        }
    }

    int[][] rescale(int[][] original, int newWidth, int newHeight) {
        int x_radio = original.length / newWidth;
        int y_radio = original[0].length / newHeight;
        int count = 0;
        int sum = 0;
        int x = 0, y = 0;
        int[][] temp = new int[original[0].length][newWidth];
        int[][] newImage = new int[newHeight][newWidth];
        for (int i = 0; i < original[0].length; i++) {
            for (int j = 0; j < original.length; j++) {
                sum += original[i][j];
                if (count == x_radio) {
                    temp[y][x] = sum / count;
                    x++;
                    count = 0;
                    sum = 0;
                }
                y++;
            }
        }

        count = 0;
        sum = 0;
        x = 0;
        y = 0;


        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                sum += temp[i][j];
                if (count == y_radio) {
                    newImage[y][x] = sum / count;
                    y++;
                    count = 0;
                    sum = 0;
                }
                x++;
            }
        }

        return newImage;
    }


    String reverseMe(String argument) {
        StringBuilder b = new StringBuilder();
        String[] arr = argument.split("[ ]");
        for (int j = 0; j < arr.length; j++) {


            for (int i = arr[j].length(); i <= 0; i++) {
                b.append(arr[j].charAt(i));
            }
            b.append(" ");
        }
        argument = b.toString();
        return argument;
    }


    boolean isPalindrome(String argument) {
        int size = argument.length();
        int frond = 0;
        int back = size;


        while (frond <= back) {
            char start = argument.charAt(frond);
            char end = argument.charAt(back);

            if (!(start == end)) {
                return false;
            }
            frond++;
            back--;


        }
        return true;
    }


    boolean isPalindrome(int argument) {
        String temp = Integer.toString(argument);
        if (isPalindrome(temp)) {
            return true;
        }
        return false;
    }


    String copyEveryChar(String input, int k) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                for (int j = 0; j < k; j++) {
                    b.append(input.charAt(i));
                }
            } else {
                b.append(input.charAt(i));
            }

        }
        return b.toString();
    }


    int getPalindromeLength(String input) {
        String[] arr = input.split("[//*]");
        arr[1] = reverseMe(arr[1]);
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        int len = 0;
        int k = 0;


        p: for (int size = 2; size < arr[0].length(); size++) {
            int temp = size;

            while (true) {
                if(temp > arr[0].length()){
                    k=0;
                    continue p;
                 }
                for (int j = k; j < temp; j++) {
                    a.append(arr[0].charAt(j));
                    b.append(arr[1].charAt(j));
                }
                if (a.equals(b) && a.length() > len) {
                    len = a.length();
                }
                temp++;
                k++;
            }
        }


        return len;
    }


    int countOcurrences1(String needle, String haystack){
        int k=0;
        int count =0;
        while(true){
            k=haystack.indexOf(needle,k);
            if(k != -1){
             count++;
                k += needle.length();
            }else {
                break;
            }
        }
        return count;
    }

    int countOcurrences(String needle, String haystack){
        return countMatches(needle, haystack);
    }

    String decodeUrl(String input) throws UnsupportedEncodingException {
        return java.net.URLDecoder.decode(input, "UTF-8");
    }

    int sumOfNumbers(String input){
        String[] arr = input.split("[^0-9]+");
        int sum=0;
        for (int i = 0; i <arr.length ; i++) {
           sum +=Integer.parseInt(arr[i]);
        }
        return sum;
    }


    boolean anagram(String A, String B){

        char[] a=A.toCharArray();
        char[] b=B.toCharArray();
        for (int i = 0; i <A.length() ; i++) {
            for (int j = 0; j <b.length ; j++) {
                if(a[i] == b[j]){
                    b[j]='1';
                }
            }
        }

        for (int i = 0; i < b.length; i++) {
           if(b[i] != '1'){
               return false;
           }
        }
        return true;
    }

    boolean hasAnagramOf(String A,String B){
       int count=0;

        char[] a=A.toCharArray();
        char[] b=B.toCharArray();

        for (int i = 0; i <A.length() ; i++) {
            for (int j = 0; j <b.length ; j++) {
                if(a[i] == b[j]){
                    b[j]='1';
                    count++;
                }
            }
        }

        if (count == A.length()){
            return true;
        }
        return false;

    }


    public static void makeGray(BufferedImage img)
    {
        for (int x = 0; x < img.getWidth(); ++x)
            for (int y = 0; y < img.getHeight(); ++y)
            {
                int rgb = img.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = (rgb & 0xFF);

                int grayLevel = (r + g + b) / 3;
                int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel;
                img.setRGB(x, y, gray);
            }
    }


    long maximalScalarSum(int[] a, int[] b){
       int c=0;
        int n=a.length;
        int swap=0;
        int d=0;

        for (c = 0; c < ( n - 1 ); c++) {
            for (d = 0; d < n - c - 1; d++) {
                if (a[d] > a[d+1]) /* For descending order use < */
                {
                    swap       = a[d];
                    a[d]   =   a[d+1];
                    a[d+1] =   swap;
                }
            }
        }


         n=b.length;
         swap=0;
         d=0;


        for (c = 0; c < ( n - 1 ); c++) {
            for (d = 0; d < n - c - 1; d++) {
                if (a[d] > a[d+1]) /* For descending order use < */
                {
                    swap       = a[d];
                    a[d]   =   a[d+1];
                    a[d+1] =   swap;
                }
            }
        }

        int sum=0;
        for (int i = 0; i <a.length ; i++) {
            sum +=a[i]*b[i];
        }
        return sum;

    }

    int kthMin(int k, int[] array){

        int c=0;
        int n=array.length;
        int swap=0;
        int d=0;

        for (c = 0; c < ( n - 1 ); c++) {
            for (d = 0; d < n - c - 1; d++) {
                if (array[d] > array[d+1]) /* For descending order use < */
                {
                    swap       = array[d];
                    array[d]   =   array[d+1];
                    array[d+1] =   swap;
                }
            }
        }

        int t=array[k-1];
       return t;
    }


    long kthFac(int k, int n){
        int res=0;
        for (int i = 1; i < n; i++) {
            res*=i;
            k--;
            if(k == 0){
                break;
            }
        }
        return res;
    }
























}
