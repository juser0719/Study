package com.ssafy.vue.model.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ssafy.vue.model.DongDto;
import com.ssafy.vue.model.HouseInfoDto;
import com.ssafy.vue.model.RequestDto;
import com.ssafy.vue.model.SidoGugunCodeDto;
import com.ssafy.vue.model.mapper.DongMapper;
import com.ssafy.vue.model.mapper.HouseMapMapper;

@Service
public class HouseMapServiceImpl implements HouseMapService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return sqlSession.getMapper(HouseMapMapper.class).getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		return sqlSession.getMapper(HouseMapMapper.class).getGugunInSido(sido);
	}

	@Override
	public List<SidoGugunCodeDto> getDongInGugun(String gugun) throws Exception {
		return sqlSession.getMapper(HouseMapMapper.class).getDongInGugun(gugun);
	}

	@Override
	public List<HouseInfoDto> getAptInDong(String dong) throws Exception {
		return sqlSession.getMapper(HouseMapMapper.class).getAptInDong(dong);
	}

	private static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if (nValue == null) {
			return null;
		}
		return nValue.getNodeValue();
	}

	@Override
	public List<HouseInfoDto> getAptByAPI(RequestDto requestDto) throws Exception {
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev"); /*
																															 * URL
																															 */
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
				+ "=5N6DG8ycmqNJJ%2FWMTmS0amKZ081n1%2Fj%2Fgwo54VAuAvGh7ceK%2BY1pUWWA6H5DnvoRoAXwFaS88u7djOw1IU9TWQ%3D%3D"); /*
																															 * Service
																															 * Key
																															 */
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "="
				+ URLEncoder.encode(requestDto.getPageNo(), "UTF-8")); /* 페이지번호 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode(requestDto.getNumOfRows(), "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append("&" + URLEncoder.encode("LAWD_CD", "UTF-8") + "="
				+ URLEncoder.encode(requestDto.getLawdcd(), "UTF-8")); /* 지역코드 */
		urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "="
				+ URLEncoder.encode(requestDto.getDealymd(), "UTF-8")); /* 계약월 */

		Document documentInfo = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(urlBuilder.toString());

		System.out.println(urlBuilder.toString());
		// root tag
		documentInfo.getDocumentElement().normalize();

		// 파싱할 tag
		NodeList nList = documentInfo.getElementsByTagName("item");
		System.out.println("파싱할 리스트 수 : " + nList.getLength());
		List<HouseInfoDto> list = new LinkedList<HouseInfoDto>();
		for (int tmp = 0; tmp < nList.getLength(); tmp++) {
			Node nNode = nList.item(tmp);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				HouseInfoDto house = new HouseInfoDto();
				Element eElement = (Element) nNode;

				house.setAptCode(tmp + 1);
				house.setAptName(getTagValue("아파트", eElement));
				house.setDongCode(getTagValue("법정동시군구코드", eElement) + getTagValue("법정동읍면동코드", eElement));
				house.setDongName(getTagValue("법정동", eElement));
				house.setSidoName(requestDto.getSidoName());
				house.setGugunName(requestDto.getGugunName());
				house.setBuildYear(Integer.parseInt(getTagValue("건축년도", eElement)));
				house.setJibun(getTagValue("지번", eElement));
				house.setRecentPrice(getTagValue("거래금액", eElement));
				house.setRoadName(getTagValue("도로명", eElement));
				house.setBuildingCode(getTagValue("도로명건물본번호코드", eElement));
				house.setLat("123.123123123");
				house.setLng("456.456456456");
				list.add(house);
			}
		}

		return list;
	}

	@Override
	public Map<String, String> registerDong() throws Exception {

		Map<String, String> hmap = new HashMap<String, String>();
//		DongDto dto = new DongDto();
//		dto.setDongCode("11111111");
//		dto.setDongName("테스트동");
//		sqlSession.getMapper(DongMapper.class).registerDong(dto);
		System.out.println("@@@@@@");
		File outputFile = new File("./src/main/resources/static/output.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
		File inputFile = new File("./src/main/resources/static/input.txt");
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		String line = null;
		int [] arr= new int[10];
		
		while ((line = br.readLine()) != null) {
			String [] li=line.split(" |\t");
			DongDto dto = new DongDto();
			dto.setDongCode(li[0]);
			dto.setDongName(li[li.length-2]);
			sqlSession.getMapper(DongMapper.class).registerDong(dto);
			bw.write(li[0]+" "+li[li.length-2]);
			bw.newLine();
		}

		bw.close();
		br.close();
		System.out.println("finish");

		return hmap;
	}

}
