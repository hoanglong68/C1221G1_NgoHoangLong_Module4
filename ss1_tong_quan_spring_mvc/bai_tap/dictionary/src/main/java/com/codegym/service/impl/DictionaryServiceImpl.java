package com.codegym.service.impl;

import com.codegym.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
    static Map<String, String> dictionaryMap = new HashMap<>();

    static {
        dictionaryMap.put("animal", "giảng");
        dictionaryMap.put("book", "sách");
        dictionaryMap.put("pencil", "bút chì");
        dictionaryMap.put("phenomenon", "hiện tượng");
        dictionaryMap.put("law", "luật");
        dictionaryMap.put("visible", "hữu");
    }

    @Override
    public String translate(String word) {
        if (dictionaryMap.get(word) == null) {
            return "Not Found !";
        } else {
            return dictionaryMap.get(word);
        }
    }
}
