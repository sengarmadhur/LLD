import java.util.*;
import javafx.*;
interface IStoreFunctions {

    public String get(String key);
    public String search(String attributeKey, String attributeValue);
    public void put(String key, List<Pair<String, String>> listOfAttributePairs);
    public void delete(String key);
    public String keys();
}

class KeyValueStore implements IStoreFunctions {

    Map<String, Object> keyValueMap;

    Map<String, Class> attributeValueTypeMap;

    @Override
    public String get(String key) {
       Map<String, Object> attributeMap = (Map<String, Object>) keyValueMap.get(key);

       if (attributeMap == null) {
           return "No entry found for " + key;
       }
        List<String> attributes = new ArrayList<>();
       for (Map.Entry<String, Object> e : attributeMap.entrySet()) {
           attributes.add(e.getKey() + ": " + e.getValue());
       }

       return String.join(", ", attributes);
    }

    @Override
    public String search(String attributeKey, String attributeValue) {
       List<String> keys = new ArrayList<>();

       for (Map.Entry<String, Object> e : keyValueMap.entrySet()) {
           Map<String, Object> attributes = (Map<String, Object>) e.getValue();

           if (attributes.containsKey(attributeKey) && attributes.get(attributeKey).toString().equals(attributeValue)) {
               keys.add(e.getKey());
           }
       }
       Collections.sort(keys);
       return String.join(",", keys);
    }

    @Override
    public void put(String key, List<Pair<String, String>> listOfAttributePairs) {
        if (keyValueMap.containsKey(key)) {
            Map<String, Object> attributes = (Map<String, Object>)keyValueMap.get(key);

            for (Pair<String, String> pair: listOfAttributePairs) {
                String pairKey = pair.getKey();
                String pairValue = pair.getValue();

               if (attributeValueTypeMap.containsKey(pairKey)) {
                   if (!TypeHelper.getType(pairValue).equals(attributeValueTypeMap.get(pairKey))) {
                       System.out.println("Data Type Error");
                       return;
                   }
               } else {
                   attributeValueTypeMap.put(key, TypeHelper.getType(pairValue));
               }
               attributes.put(pairKey, pairValue);
            }
        } else {

        }
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public String keys() {
        return null;
    }
}

class TypeHelper {

    static String booleanRegex = "^(true|false)$";
    static String integerRegex = "^-?\\d+$\n";
    static String doubleRegex = "^-?\\d*\\.\\d+$|^-?\\d+\\.\\d*$\n";
    public static Class getType(String value) {
        Class type = String.class;

        if (value.matches(booleanRegex)) {
            type =  Boolean.class;
        } else if (value.matches(integerRegex)) {
            type = Integer.class;
        } else if (value.matches(doubleRegex)) {
            type = Double.class;
        }
        return type;
    }
}
public class KeyValueStoreDriver {
    public static void main(String[] args) {

    }
}
