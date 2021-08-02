package com.ssafy.day6.xml.sax;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import com.ssafy.day6.xml.BoxOffice;
import com.ssafy.day6.xml.Student;

/**
 * @since 2021. 7. 9.
 */
public class SaxParserTest {

    public static void main(String[] args) {
        BoxOfficeSaxParser handler = new BoxOfficeSaxParser();

        List<BoxOffice> list = handler.getBoxOffice();
        for (BoxOffice boxOffice : list) {
            System.out.println(boxOffice);
        }

    }
}
