import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang.StringUtils.countMatches;

/**
 * Created by georgipavlov on 16.11.15.
 */
public class One {
    boolean isOdd(int n) {
        n=Math.abs(n);
        int odd = n % 2;
        if (odd == 0) {
            return false;
        }
        return true;
    }


    boolean isPrime(int n) {
        n=Math.abs(n);
        if (n % 2 == 0) return false;
        for (int i = 3; i * i < n; i += 2)
            if (n % i == 0) return false;
        return true;
    }

    int min(int[] arr) {
        int j=0;
        try {
            j = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (j > arr[i]) {
                    j = arr[i];
                }
            }
            return j;
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return j;

    }


    int getAverage(int[] arr) {
        long n = 0;
        for (int i = 0; i < arr.length; i++) {
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
        i= Math.abs(i);
        String num = Long.toString(i);
        int size = num.length();
        int frond = 0;
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


    int[] histogram(short[][] image) {

        Map<Short, Integer> map = new HashMap<>();
        int[] result = new int[255];

        for (short j = 0; j < image[0].length; j++) {
            for (short k = 0; k < image.length; k++) {
                 if(image[j][k] >= 0){
                Integer count = map.get(image[j][k]);
                if (count == null) {
                    count = 0;
                }
                map.put(image[j][k], count + 1);
                 }else{
                     System.out.println("only + numbers!");
                     int[] arrErr = new int[0];
                     return arrErr;
                 }

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
        BigInteger big = BigInteger.valueOf(temp);
        if (b % 2 == 0) {
            if(big.multiply(BigInteger.valueOf(temp)).compareTo
                    (BigInteger.valueOf(Integer.MAX_VALUE)) == 1){
                System.out.println("too big number");
                return 0;
            }
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
        boolean small =false;
        if(original.length > newHeight && original[0].length > newWidth){
            small=true;
        }
        int[][] newImage = new int[newHeight][newWidth];
        int count = 0;
        int sum = 0;
        int x = 0, y = 0;
        if(small) {
            int x_radio = original.length / newWidth;
            int y_radio = original[0].length / newHeight;
            int[][] temp = new int[original[0].length][newWidth];

            for (int i = 0; i < original[0].length; i++) {
                for (int j = 0; j < original.length; j++) {
                    sum += original[i][j];
                    if (count == x_radio) {
                        temp[y][x] = sum / count;
                        x++;
                        count = 0;
                        sum = 0;
                    }
                    count++;
                }
                y++;
            }

            count = 0;
            sum = 0;
            x = 0;
            y = 0;

            BigInteger big = BigInteger.valueOf(sum);
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    if(big.add(BigInteger.valueOf(temp[i][j])).compareTo
                            (BigInteger.valueOf(Integer.MAX_VALUE)) == 1){
                        System.out.println("to big sum err Integer");
                        int[][] err = new int[0][0];
                        return err;
                    }
                    sum += temp[i][j];
                    if (count == y_radio) {
                        newImage[y][x] = sum / count;
                        y++;
                        count = 0;
                        sum = 0;
                    }
                   count++;
                }
                x++;
            }
        }else {
            int x_radio = newWidth /original.length ;
            int y_radio = newHeight /original[0].length ;
            int[][] temp2 = new int[original[0].length][newWidth];

            for (int i = 0; i < original[0].length; i++ , y++) {
                for (int j = 0; j < original.length; j++ ,x++) {
                    temp2[y][x]= original[i][j];
                    if (count == x_radio) {
                        for (int k = 0; k < count; k++) {
                            temp2[y][x] = 0;
                            x++;
                        }
                        count = 0;
                    }
                }
            }

            count = 0;
            x = 0;
            y = 0;


            for (int i = 0; i < temp2.length; i++,x++) {
                for (int j = 0; j < temp2[0].length; j++ , y++) {
                    newImage[y][x]= temp2[i][j];
                    if (count == y_radio) {
                        for (int k = 0; k < count; k++) {
                            newImage[y][x] = 0;
                            y++;
                        }
                        count = 0;
                        sum = 0;
                    }
                    count++;
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

    private Matcher matcher2;
    private Pattern pattern2;
    public boolean march2(String number){
        final String USERNAME_PATTERN = "^[0-9]$";
        pattern2 = Pattern.compile(USERNAME_PATTERN);
        matcher2 = pattern2.matcher(number);

        return matcher2.matches();

    }
    boolean isPalindrome(String argument) {
        if(!march2(argument)){
            System.out.println("argument error");
           return false;
        }
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
        String temp = Integer.toString(Math.abs(argument));
        if (isPalindrome(temp)) {
            return true;
        }
        return false;
    }


    String copyEveryChar(String input, int k) {
        k=Math.abs(k);
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
        long count =0;
        while(true){
            k=haystack.indexOf(needle,k);
            if(k != -1){
                if(count >= Integer.MAX_VALUE){
                    System.out.println("to many Ocurrences");
                    return 0;
                }
                count++;
                k += needle.length();
            }else {
                break;
            }
        }
        return (int)count;
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
            if (arr[i].charAt(0) != ' ') {
                sum += Integer.parseInt(arr[i]);
            }
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

        long sum=0;
        BigInteger bigInteger1 = BigInteger.valueOf(0);
        BigInteger bigInteger2 = BigInteger.valueOf(1);
        for (int i = 0; i <a.length ; i++) {
            bigInteger2.multiply(BigInteger.valueOf(a[i]));
            bigInteger2.multiply(BigInteger.valueOf(b[i]));
            if(bigInteger2.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) == 1){
                System.out.println("to big value");
                return 0;
            }
            if(bigInteger1.add(bigInteger2).compareTo(BigInteger.valueOf(Long.MAX_VALUE)) == 1){
                System.out.println("to big value");
                return 0;
            }
            bigInteger2 = BigInteger.valueOf(1);
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
        long res=0;
        BigInteger bigInteger = BigInteger.valueOf(1);
        for (long i = 1; i < n; i++) {
            bigInteger.multiply(BigInteger.valueOf(i));
            if(bigInteger.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) == 1){
                System.out.println("Too big fac");
                return 0;
            }
            res*=i;
            k--;
            if(k == 0){
                break;
            }
        }
        return res;
    }
























}
