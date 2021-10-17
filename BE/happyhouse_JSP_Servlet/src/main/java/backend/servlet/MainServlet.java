package backend.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import backend.dto.DongLocation;
import backend.dto.HouseDeal;
import backend.dto.HouseInfo;
import backend.dto.Shop;
import backend.dto.SidoGuDong;
import backend.dto.User;
import backend.model.dao.AptInfoDaoImpl;
import backend.model.service.AptInfoServiceImpl;

import backend.model.service.DongCollectionServiceImpl;
import backend.model.service.LocationServiceImpl;
import backend.model.service.ShopInfoService;
import backend.model.service.ShopInfoServiceImpl;
import backend.model.service.UserServiceImpl;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String root;

	// method = "post"
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	// method = "get"
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		root = request.getContextPath();
		String act = request.getParameter("act");
		try {
			if (act == null) {
				response.sendRedirect(root + "/index.jsp");
			} else if (act.equals("login")) { // 로그인
				login(request, response);
				searchAroundShop(request, response);
			} else if (act.equals("logout")) { // 로그아웃
				logout(request, response);
			} else if (act.equals("gotosignup")) { // 회원가입 페이지로 이동
				response.sendRedirect(root + "/signup.jsp");
			} else if (act.equals("signup")) { // 회원가입
				signup(request, response);
			} 
			////////////////////////////////////
			   else if (act.equals("sido")) { // 해당 행정구역의 "시/도" 불러오기
				callSido(request, response);
			}  else if (act.equals("gugun")) { // 해당 행정구역의 "구/군" 불러오기
				callGuGun(request, response);
			}  else if (act.equals("dong")) { // 해당 행정구역의 "동" 불러오기
				callDong(request, response);
			} 
			/////////////////////////////////////
			   else if (act.equals("gu")) { // 해당 행정구역의 "법정동" 불러오기
				callGu(request, response);
			} else if (act.equals("search")) { // 기본 검색
				search(request, response);
			} else if (act.equals("searchCategory")) { // 아파트 or 실거래별 검색
				searchCategory(request, response);
			} else if (act.equals("userinfo")) {
				userinfo(request, response);
			} else if (act.equals("editinfo")) {
				String button = request.getParameter("button");
				if (button.equals("update"))
					updateinfo(request, response);
				else
					deleteinfo(request, response);
			} else if (act.equals("detail")) { // 주택 시세 확인 페이지 (detail.jsp)
				response.sendRedirect(root + "/detail.jsp");
			} else if (act.equals("around")) { // 관심 지역 목록 페이지 (around.jsp)
				response.sendRedirect(root + "/around.jsp");
			} else if (act.equals("searchshop")) { // 기본 검색
				searchAroundShop(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void callDong(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String gugun = request.getParameter("gugun");
		PrintWriter out = response.getWriter();
		List<HouseInfo> list = null;
		JSONArray arr = new JSONArray();
		try {
			list = LocationServiceImpl.getLocationService().getDongInGugun(gugun);
			for(HouseInfo dto : list) {
				JSONObject obj = new JSONObject();
				obj.put("dong_code", dto.getDongCode());
				obj.put("dong_name", dto.getDongName());
				arr.add(obj);
			}
		} catch (Exception e) {
			arr = new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("message_code", "-1");
			arr.add(obj);
			e.printStackTrace();
		} finally {
			out.print(arr.toJSONString());
			out.close();
		}
		
	}

	@SuppressWarnings("unchecked")
	private void callGuGun(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sido = request.getParameter("sido");
		PrintWriter out = response.getWriter();
		List<SidoGuDong> list = null;
		List<JSONObject> arr = new JSONArray();
		try {
			System.out.println(sido);
			list = LocationServiceImpl.getLocationService().getGugunInSido(sido);
			for(SidoGuDong dto : list) {
				System.out.println(">>" + dto);
				JSONObject obj = new JSONObject();
				obj.put("gugun_code", dto.getGugunCode());
				obj.put("gugun_name", dto.getGugunName());
				arr.add(obj);
			}
		} catch (Exception e) {
			JSONObject obj = new JSONObject();
			obj.put("message_code", "-1");
			arr.add(obj);
			e.printStackTrace();
		} finally {
			out.print(arr);
			out.close();
		}
		
		System.out.println(arr);
		response.setContentType("text/json;charset=UTF-8");
		response.getWriter().append(arr.toString());
		System.out.println(arr.toString());
	}
	
	@SuppressWarnings("unchecked")
	private void callSido(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		List<SidoGuDong> list = null;
		JSONArray arr = new JSONArray();
		try {
			list = LocationServiceImpl.getLocationService().getSido();
			for(SidoGuDong dto : list) {
				System.out.println(dto);
				JSONObject obj = new JSONObject();
				obj.put("sido_code", dto.getSidoCode());
				obj.put("sido_name", dto.getSidoName());
				arr.add(obj);
			}
		} catch (Exception e) {
			arr = new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("message_code", "-1");
			arr.add(obj);
			e.printStackTrace();
		} finally {
			out.print(arr.toJSONString());
			out.close();
		}
	}
	
	private void searchAroundShop(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// 1. 파라미터 확인
		String gu = request.getParameter("gu");
		String dong = request.getParameter("dong");
		String[] values = request.getParameterValues("category"); // category 값

		// 2. 비즈니스 로직
		ShopInfoService service = new ShopInfoServiceImpl(gu, dong, values);

		// 참고!!. Json 문자열 <--> 자바 객체 (Gson 은 google에서 제공하는 jar 파일을 첨부해야함)
		Gson gson = new Gson();
		String json = gson.toJson(service);
		// System.out.println(json);

		// 3. View 출력
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().append(json);
	}

	// 기본 검색 (행정구역 기준)
	protected void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// 1. 파라미터 확인
		String city = request.getParameter("city");
		String gugun = request.getParameter("gu");
		String dong = request.getParameter("dong");

		// 2. 비즈니스 로직
		List<HouseDeal> list = AptInfoServiceImpl.getAptInfoServiceImpl().getSearchList(dong);
		// 참고!!. Json 문자열 <--> 자바 객체 (Gson 은 google에서 제공하는 jar 파일을 첨부해야함)
		Gson gson = new Gson();
		String json = gson.toJson(list);

		// 3. View 출력
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().append(json);
	}

	// 기본 검색 (아파트, 실거래가 기준)
	protected void searchCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		// 1. 파라미터 확인
		String searchTitle = request.getParameter("searchTitle");
		String searchText = request.getParameter("searchText");

		// 2. 비즈니스 로직
		List<HouseDeal> list = AptInfoServiceImpl.getAptInfoServiceImpl().getSearchTitleList(searchTitle, searchText);
		// 참고!!. Json 문자열 <--> 자바 객체 (Gson 은 google에서 제공하는 jar 파일을 첨부해야함)
		Gson gson = new Gson();
		String json = gson.toJson(list);

		// 3. View 출력
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().append(json);
	}

	private void deleteinfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");

		UserServiceImpl.getUserService().delete(id);

		logout(request, response);
	}

	private void updateinfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");

		User user = new User(id, password, name, address, tel);
		UserServiceImpl.getUserService().update(user);

		HttpSession session = request.getSession();
		session.setAttribute("userinfo", user);

		userinfo(request, response);
	}

	private void userinfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userinfo");

		request.setAttribute("id", user.getId());
		request.setAttribute("password", user.getPassword());
		request.setAttribute("name", user.getName());
		request.setAttribute("address", user.getAddress());
		request.setAttribute("tel", user.getTel());

		RequestDispatcher disp = request.getRequestDispatcher("/userInfo.jsp");
		disp.forward(request, response);
	}

	private void signup(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		System.out.println(id + password + name + address);
		User user = new User(id, password, name, address, tel);
		UserServiceImpl.getUserService().siguUp(user);

		String path = "/index.jsp";
		response.sendRedirect(root + path);
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		User user = UserServiceImpl.getUserService().login(id, password);

		// String nowPath = request.getRequestURL().toString();
		String path = "/index.jsp";
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", user);
			response.sendRedirect(root + path);
		} else {
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요.");
			RequestDispatcher disp = request.getRequestDispatcher(path);
			disp.forward(request, response);
		}
	}

	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		session.invalidate();

		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	// index, detail 페이지에서 "구"를 선택 시, 해당 구의 법정동을 보여줌
	protected void callGu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		// 1. 파라미터 확인
		String guName = request.getParameter("gu");

		// 2. 비즈니스 로직
		List<String> list = DongCollectionServiceImpl.getDongCollectionServiceImpl().getDongList(guName);
		
		for (String s: list)
		{
			System.out.println(s);
		}
		// 참고!!. Json 문자열 <--> 자바 객체 (Gson 은 google에서 제공하는 jar 파일을 첨부해야함)
		Gson gson = new Gson();
		String json = gson.toJson(list);

		// 3. View 연결
		// Data만 보낼 때 아래와 같이 작성하면 된다.
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().append(json);
	}
}
