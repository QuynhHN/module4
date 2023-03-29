package com.example.dictionary.repository.impl;

import com.example.dictionary.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class DictionaryRepository implements IDictionaryRepository {
    static Map<String, String> stringMap = new HashMap<>();
    static {
        stringMap.put("Dog","Chó");
        stringMap.put("Cat","Mèo");
        stringMap.put("House","Ngôi nhà");
        stringMap.put("Love","Tình yêu");
        stringMap.put("School","Trường học");
        stringMap.put("Class","Lớp học");
    }
    @Override
    public String list(String dictionary) {
String str ="";
        for (Map.Entry<String, String> entry : stringMap.entrySet()) {
            if ((entry.getKey()).contains(dictionary)) {
                str += entry.getValue();
            }
        }
        return str;
    }
}
//cach2
//@Override
//public String list(String dictionary) {
//    for (Map.Entry<String, String> entry : stringMap.entrySet()) {
////            if (dictionary.equalsIgnoreCase(entry.getKey())) {
////                return entry.getValue();
////            }
//    }
//    return null;
//}
//}