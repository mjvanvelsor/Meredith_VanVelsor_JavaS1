import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TelevisionReader {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> teleList;
            teleList = mapper.readValue(
                    new File("televisions.json"),
                    new TypeReference<List<Television>>() {
                    });

            teleList
                    .stream()
                    .filter(t -> t.getScreenSize() > 60)
                    .forEach(tv -> {
                        System.out.println("==================");
                        System.out.println(tv.getBrand());
                        System.out.println(tv.getModel());
                        System.out.println(tv.getPrice());
                        System.out.println(tv.getScreenSize());
                    });

            System.out.println("\nList of Manufacturers:");

            Map<String, List<Television>> groupedBrand =
                    teleList
                        .stream()
                        .collect(Collectors.groupingBy(t -> t.getBrand()));

            Set<String> keys = groupedBrand.keySet();
            for(String key : keys){
                System.out.println(key);
            }

            double avgScreensize =
                    teleList
                        .stream()
                        .mapToInt(b -> b.getScreenSize())
                        .average()
                        .getAsDouble();

            System.out.println("\nAverage screensize is: " + avgScreensize);

            int maxScreensize =
                    teleList
                        .stream()
                        .mapToInt(b -> b.getScreenSize())
                        .max()
                        .getAsInt();

            System.out.println("\nMax Screensize is: " + maxScreensize);

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file -- " + e.getMessage());
        }
    }
}

