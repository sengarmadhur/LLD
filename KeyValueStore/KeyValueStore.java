package org.example.keyvaluestorelld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import javafx.util.Pair;

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

    KeyValueStore() {
        keyValueMap = new ConcurrentHashMap<>();
        attributeValueTypeMap = new HashMap<>();
    }
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

        Map<String, Object> attributes = new HashMap<>();

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

        keyValueMap.put(key, attributes);
    }

    @Override
    public void delete(String key) {
        keyValueMap.remove(key);
    }

    @Override
    public String keys() {
        List<String> keys = new ArrayList<>(keyValueMap.keySet());
        Collections.sort(keys);
        return  String.join(",", keys);
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
    public static void main(String[] args) throws IOException {
        KeyValueStore store = new KeyValueStore();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();

        while (!input.equalsIgnoreCase("exit")) {
            String [] inputList = input.split(" ");

            switch (inputList[0]) {
                case "get":
                    System.out.println(store.get(inputList[1]));
                    break;
                case "delete":
                    System.out.println("Deleted " + inputList[1]);
                    break;
                case "keys":
                    System.out.println(store.keys());
                    break;
                case "search":
                    System.out.println(store.search(inputList[1], inputList[2]));
                    break;
                case "put":
                    String key = inputList[1];
                    List<Pair<String, String>> attributeList = new ArrayList<>();
                    for (int i=2; i<inputList.length; i+=2) {
                        attributeList.add(new Pair<>(inputList[i], inputList[i+1]));
                    }
                    store.put(key, attributeList);
                    break;
            }
            input = reader.readLine().trim();
        }
    }
}
