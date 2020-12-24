package tmobile.usage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IdentifyUnusedNetworkPolicies {

    public static void main(String[] args) throws IOException {


        String manifestYml = "manifest.yml";

        ClassLoader classLoader =IdentifyUnusedNetworkPolicies.class.getClassLoader();
        File file = new File(classLoader.getResource(manifestYml).getFile());




        // Instantiating a new ObjectMapper as a YAMLFactory
        ObjectMapper om = new ObjectMapper(new YAMLFactory());

        // Mapping the employee from the YAML file to the Employee class
        Object yamlObject = om.readValue(file, Object.class);

      // System.out.println(yamlObject);



        Map<String, Object> manifestMap = om.convertValue(yamlObject, Map.class);
       // System.out.println(manifestMap);

        List<Object> applications = (List<Object>) manifestMap.get("applications");
        //System.out.println(applications);
        Map<String, Object> innerMap = (Map<String, Object>) applications.get(0);

        Map<String, Object> env = (Map<String, Object>) innerMap.get("env");
        List<String> namesFromManifest = new ArrayList<>();
        env.forEach((key, value) -> {
            if(value instanceof  String && (((String) value).contains("http") || ((String) value).contains("https") )){
                String value1 = value.toString();

                //System.out.println(value1.substring(value1.indexOf("http://")+7 , value1.indexOf("$")-1));

                    if(value1.contains("$")){
                        if(value1.contains("https")){
                        namesFromManifest.add(value1.substring(value1.indexOf("https://")+8 , value1.indexOf("$")-1));
                        }else{
                            namesFromManifest.add(value1.substring(value1.indexOf("http://")+7 , value1.indexOf("$")-1));
                        }
                    }else{
                        String value2="";
                        if(value1.contains("https")){
                             value2 = value1.substring(value1.indexOf("https://") + 8 , value1.indexOf("."));
                        }else{
                            value2 = value1.substring(value1.indexOf("http://") + 7 , value1.indexOf("."));
                        }

                        StringBuffer sb1 = new StringBuffer(value2);
                        String value3 = new StringBuffer(sb1.reverse().substring(sb1.indexOf("-") + 1, sb1.length())).reverse()
                                                                                                                     .toString();
                        namesFromManifest.add(value3);
                    }



            }


        });
        System.out.println("urls from manifest-->"+namesFromManifest);

        String networkPolicyYml = "network-policy.yml";

        file = new File(classLoader.getResource(networkPolicyYml).getFile());






        // Mapping the employee from the YAML file to the Employee class
        Object networkPolicyYamlObject = om.readValue(file, Object.class);

        // System.out.println(yamlObject);



        Map<String, Object>networkPolicyYmlMap = om.convertValue(networkPolicyYamlObject, Map.class);
       // System.out.println(networkPolicyYmlMap);
        Map<String, Object> networkPoliciesMap = (Map<String, Object>) networkPolicyYmlMap.get("network-policies");
        List<Map<String, String>> outboundNetworkPoliciesList = (List<Map<String, String>>) networkPoliciesMap.get("outbound");
       // outboundNetworkPoliciesList.stream().forEach(map -> System.out.println(map.get("name")));

        List<String> outboundNames =
                outboundNetworkPoliciesList.stream().map(map -> map.get("name")).collect(Collectors.toList());
        System.out.println("network policy names--->"+outboundNames);
        List<String> difference2 = outboundNames.stream()
                                                .map(s -> {
                                                    if(s.contains("$"))
                                                    s=s.substring(0, s.indexOf("$"))   ;
                                                    return s;
                                                }).filter(aObject -> ! namesFromManifest.contains(aObject))
                                        .collect(Collectors.toList());
        System.out.println(difference2);
    }

}
