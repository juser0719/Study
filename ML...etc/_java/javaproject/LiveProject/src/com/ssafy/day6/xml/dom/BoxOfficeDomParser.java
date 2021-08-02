package com.ssafy.day6.xml.dom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import com.ssafy.day6.xml.BoxOffice;


/**
 * @since 2021. 7. 9.
 */
public class BoxOfficeDomParser {
    private final File xml = new File("../boxoffice.xml");
    private List<BoxOffice> list = new ArrayList<>();
    
    public List<BoxOffice> getBoxOffice() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 문서 로딩 완료 --> 원하는 요소들 골라내기
            Document doc = builder.parse(xml);
            // 최 상위 element
            Element root = doc.getDocumentElement();
            parse(root);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void parse(Element root) {
        // TODO: root에서 dailyBoxOffice를 추출한 후 BoxOffice를 생성해 list에 저장하시오.
        NodeList boxOffices = root.getElementsByTagName("dailyBoxOffice");
        for (int i = 0; i < boxOffices.getLength(); i++) {
            Node child = boxOffices.item(i);
            list.add(getBoxOffice(child));
        }
        // END:
    }

    private static BoxOffice getBoxOffice(Node node) {
        BoxOffice boxOffice = new BoxOffice();
        // TODO: node 정보를 이용해서 BoxOffice를 구성하고 반환하시오.

        NodeList subNodes = node.getChildNodes();
        for (int j = 0; j < subNodes.getLength(); j++) {
            Node sub = subNodes.item(j);
            if (sub.getNodeName().equals("rank")) {
                boxOffice.setRank(Integer.parseInt(sub.getTextContent()));
            } else if (sub.getNodeName().equals("movieNm")) {
                boxOffice.setMovieNm(sub.getTextContent());
            } else if (sub.getNodeName().equals("openDt")) {
                boxOffice.setOpenDt(boxOffice.toDate(sub.getTextContent()));
            } else if (sub.getNodeName().equals("audiAcc")) {
                boxOffice.setAudiAcc(Integer.parseInt(sub.getTextContent()));
            }
        }
        // END:
        return boxOffice;
    }
}
