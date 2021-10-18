package backend.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import backend.dto.HouseInfo;
import backend.dto.SidoGuDong;
import backend.util.DBUtil;

public class LocationDaoImpl implements LocationDao {
	
	private static LocationDao locationDao = new LocationDaoImpl();
	
	private DBUtil dbUtil;
	
	private LocationDaoImpl() {
		dbUtil = DBUtil.getUtil();
	}
	
	public static LocationDao getLocationDao() {
		return locationDao;
	}
	
	@Override
	public List<SidoGuDong> getSido() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SidoGuDong> list = new ArrayList<SidoGuDong>();
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select left(sidoCode,2) sidoCode, sidoName \n");
			sql.append("from sidocode \n");
			sql.append("order by sidoCode");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SidoGuDong dto = new SidoGuDong();
				dto.setSidoCode(rs.getString("sidoCode"));
				dto.setSidoName(rs.getString("sidoName"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public List<SidoGuDong> getGugun(String sido) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SidoGuDong> list = new ArrayList<SidoGuDong>();
		System.out.println(sido);
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select left(gugunCode,5) gugunCode, gugunName \n");
			sql.append("from guguncode \n");
			sql.append("where left(gugunCode,2) = ?");
			sql.append("order by gugunCode");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, sido.substring(0,2));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SidoGuDong dto = new SidoGuDong();
				dto.setGugunCode(rs.getString("gugunCode"));
				dto.setGugunName(rs.getString("gugunName"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public List<HouseInfo> getDong(String gugun) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HouseInfo> list = new ArrayList<HouseInfo>();
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select distinct dongName, dongCode \n");
			sql.append("from houseinfo \n");
			sql.append("where left(dongCode, 5) = ? \n");
			sql.append("order by dongName");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, gugun);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HouseInfo dto = new HouseInfo();
				dto.setDongCode(rs.getString("dongCode"));
				dto.setDongName(rs.getString("dongName"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

}
