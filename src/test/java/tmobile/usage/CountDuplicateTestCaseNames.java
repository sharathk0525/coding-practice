package tmobile.usage;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.joshka.junit.json.params.JsonFileSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;

import javax.json.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountDuplicateTestCaseNames {
    private static List<String> testCaseNames = new ArrayList<>();



    @AfterAll
    public static void testPrintDuplicates(){
        /*testCaseNames.stream()
              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
              .entrySet()
              .forEach(System.out::println);*/

        Map<String, Long> testCaseNameCountMap = testCaseNames.stream()
                                                 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        testCaseNameCountMap.forEach((s, aLong) -> {
            if(aLong > 1){
                System.out.println(s +" appeared "+aLong+" times");
            }
        });
    }
}
