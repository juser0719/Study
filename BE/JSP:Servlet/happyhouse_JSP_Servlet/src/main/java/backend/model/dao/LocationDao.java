package backend.model.dao;

import java.util.List;

import backend.dto.HouseInfo;
import backend.dto.SidoGuDong;

public interface LocationDao {
	List<SidoGuDong> getSido() throws Exception;
	List<SidoGuDong> getGugun(String sido) throws Exception;
	List<HouseInfo> getDong(String gugun) throws Exception;
}
