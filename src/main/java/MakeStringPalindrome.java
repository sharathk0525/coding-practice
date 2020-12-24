import java.util.Arrays;

public class MakeStringPalindrome {

    public static void main(String[] args) {
        String input = "aebcbda";
        String[] result = input.split("");
        //System.out.println(result);
        char[] resultArray = input.toCharArray();

        int length = resultArray.length;
        char[] resultArray1 = new char[length/2];
        int resultArray1Index =0;
        for (int i=0; i<length/2; i++){
            if(resultArray[i] == resultArray[length-1-i]){

            }else{
                resultArray1[resultArray1Index] = resultArray[i];
                resultArray1Index++;
                resultArray1[resultArray1Index] = resultArray[length-1-i];
                resultArray1Index++;
            }

        }
        System.out.println("output -->"+resultArray1);
        int[] asciiValueArray = new int[length/2];
        int asciiValueArrayIndex = 0;
        for (char c : resultArray1) {
            asciiValueArray[asciiValueArrayIndex] = c;
            asciiValueArrayIndex++;
        }


        System.out.println(Arrays.toString(resultArray1));
        System.out.println(asciiValueArray);
        //System.out.println(asciiValueArray.s);

    }
}
