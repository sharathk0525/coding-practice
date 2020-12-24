package MiscJavaSolutions;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'deviceNamesSystem' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY devicenames as parameter.
     */

    public static List<String> deviceNamesSystem(List<String> devicenames) {
        List<String> uniqueDeviceNames = new ArrayList<>();

        Map<String, Integer> deviceNameToCountMap = new HashMap<>();
        for (int i = 0; i < devicenames.size(); i++) {
            if(deviceNameToCountMap.containsKey(devicenames.get(i))){
                deviceNameToCountMap.put(devicenames.get(i), deviceNameToCountMap.get(devicenames.get(i))+1);
            }else{
                deviceNameToCountMap.put(devicenames.get(i), 1);
            }

        }
        // Write your code here
        for (Map.Entry<String,Integer> entry : deviceNameToCountMap.entrySet()){
            int counter = entry.getValue();
            for(int k=0; k<counter; k++){
                if(k==0){
                    uniqueDeviceNames.add(entry.getKey());

                }else{
                    uniqueDeviceNames.add(entry.getKey()+k);
                }

            }

        }
        System.out.println(uniqueDeviceNames);
return uniqueDeviceNames;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int devicenamesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> devicenames = IntStream.range(0, devicenamesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                                            .collect(toList());*/

        List<String> devicenames1 = Arrays.asList("switch", "tv","switch", "tv","switch", "tv");
        List<String> devicenames2 = Arrays.asList("4", "lamp","lamp", "tv", "lamp");
        List<String> result = Result.deviceNamesSystem(devicenames2);



       /* bufferedWriter.write(
                result.stream()
                      .collect(joining("\n"))
                + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
