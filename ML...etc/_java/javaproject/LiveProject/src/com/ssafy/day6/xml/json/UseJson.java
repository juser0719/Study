package com.ssafy.day6.xml.json;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.day6.xml.BoxOffice;

/**
 * @since 2021. 7. 9.
 */
public class UseJson {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        
        File json = new File("./src/com/ssafy/day6/xml/boxoffice.json");

        // 기본적으로는 Map의 구조를 가짐
        Map<String, Map<String, Object>> result = mapper.readValue(json, Map.class);
        // 배열은 List
        List<Map<String, Object>> list = (List)result.get("boxOfficeResult").get("dailyBoxOfficeList");
        
        for(Map<String, Object> info: list) {
            // 필요한 객체 형으로 변환
            BoxOffice boxOffice = mapper.convertValue(info,  BoxOffice.class);
            System.out.println(boxOffice);
        }
    }
}
