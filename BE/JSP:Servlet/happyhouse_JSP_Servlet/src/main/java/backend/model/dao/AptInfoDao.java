package backend.model.dao;

import java.sql.SQLException;
import java.util.List;

import backend.dto.HouseDeal;

public interface AptInfoDao {
	// 1. 기본 검색(행정구역) - 법정동 추출
	public List<HouseDeal> getSearchList(String dong) throws SQLException;

	// 2. 아파트별, 실거래가별 검색
	public List<HouseDeal> getSearchTitleList(String searchTitle, String searchText) throws SQLException;
}
