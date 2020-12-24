package MiscJavaSolutions;

import com.fasterxml.jackson.databind.ObjectMapper;
import sun.misc.IOUtils;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.nio.file.Files.lines;

public class GetMaxDate {

private static String result = "[\n" +
                        "\n" +
                        "\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"status\",\n" +
                        "        \"oldValue\": \"Published\",\n" +
                        "        \"newValue\": \"Draft\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.003Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"name\",\n" +
                        "        \"oldValue\": \"Temp 21/12/2020\",\n" +
                        "        \"newValue\": \"test temp on prod 2606\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.042Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"description\",\n" +
                        "        \"oldValue\": \"Temp 21/12/2020 Desc\",\n" +
                        "        \"newValue\": \"ttest desc\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.042Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"owner\",\n" +
                        "        \"oldValue\": \"VKotadi1\",\n" +
                        "        \"newValue\": \"vkotadi1\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.042Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"status\",\n" +
                        "        \"oldValue\": \"Draft\",\n" +
                        "        \"newValue\": \"Unpublished\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.042Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"name\",\n" +
                        "        \"oldValue\": \"test temp on prod 2606\",\n" +
                        "        \"newValue\": \"Test Vip Template 6aaaaaa\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.073Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"description\",\n" +
                        "        \"oldValue\": \"ttest desc\",\n" +
                        "        \"newValue\": \"aaaaaaaaa\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.073Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"owner\",\n" +
                        "        \"oldValue\": \"vkotadi1\",\n" +
                        "        \"newValue\": \"VKotadi1\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.073Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"status\",\n" +
                        "        \"oldValue\": \"Unpublished\",\n" +
                        "        \"newValue\": \"Draft\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.073Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"status\",\n" +
                        "        \"oldValue\": \"Draft\",\n" +
                        "        \"newValue\": \"Unpublished\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.085Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"name\",\n" +
                        "        \"oldValue\": \"Test Vip Template 6aaaaaa\",\n" +
                        "        \"newValue\": \"test1 template Dec 18 2020 test1 DAST testing\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.117Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"description\",\n" +
                        "        \"oldValue\": \"aaaaaaaaa\",\n" +
                        "        \"newValue\": \"test template Dec 09 2020 test1\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.117Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"category\",\n" +
                        "        \"oldValue\": \"BSS\",\n" +
                        "        \"newValue\": \"ACCOUNT MAINTENANCE\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.117Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"owner\",\n" +
                        "        \"oldValue\": \"VKotadi1\",\n" +
                        "        \"newValue\": \"SMallam1\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.117Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"status\",\n" +
                        "        \"oldValue\": \"Unpublished\",\n" +
                        "        \"newValue\": \"Draft\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.117Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"name\",\n" +
                        "        \"oldValue\": \"test1 template Dec 18 2020 test1 DAST testing\",\n" +
                        "        \"newValue\": \"test one dec18 2020 test5\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.133Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"description\",\n" +
                        "        \"oldValue\": \"test template Dec 09 2020 test1\",\n" +
                        "        \"newValue\": \"<script>alert('hello')</script>\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.133Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"name\",\n" +
                        "        \"oldValue\": \"test one dec18 2020 test5\",\n" +
                        "        \"newValue\": \"Temp 21/12/2020\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.146Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"description\",\n" +
                        "        \"oldValue\": \"<script>alert('hello')</script>\",\n" +
                        "        \"newValue\": \"Temp 21/12/2020 Desc\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.146Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"category\",\n" +
                        "        \"oldValue\": \"ACCOUNT MAINTENANCE\",\n" +
                        "        \"newValue\": \"BSS\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.146Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"owner\",\n" +
                        "        \"oldValue\": \"SMallam1\",\n" +
                        "        \"newValue\": \"VKotadi1\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.146Z\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"recordKey\": \"1601\",\n" +
                        "        \"fieldName\": \"status\",\n" +
                        "        \"oldValue\": \"Draft\",\n" +
                        "        \"newValue\": \"Unpublished\",\n" +
                        "        \"changeBy\": \"VKotadi1\",\n" +
                        "        \"auditDate\": \"2020-12-21T15:05:00.146Z\"\n" +
                        "    }\n" +
                        "\n" +
                        "]";

    public static void main(String[] args) {

        try {
            InputStream fis      = new FileInputStream("src/main/resources/auditData.json");
            JsonReader  reader   = Json.createReader(fis);

            String text = new BufferedReader(
                    new InputStreamReader(fis, StandardCharsets.UTF_8)).lines()
                    .collect(Collectors.joining(""));
            final ObjectMapper objectMapper = new ObjectMapper();
            AuditData[] auditDataList = objectMapper.readValue(result, AuditData[].class);

          //  JsonArray   testData = reader.readArray();
          //  AuditData[] langs1 = objectMapper.readValue(fis, AuditData[].class);
            reader.close();
            List<Date> collect = Arrays.asList(auditDataList).stream().map(auditData -> auditData.getAuditDate())
                                       .collect(Collectors.toList());
            Optional<Date> max = collect.stream().max(Comparator.reverseOrder());
            max.ifPresent(date -> System.out.println(date));
        } catch (Exception e) {
            e.printStackTrace();
        }

       // Map map = new ObjectMapper().readValue(result, AuditData.class);
    }
}
