package backend.model.service;

import java.util.List;

import backend.dto.HouseInfo;
import backend.dto.SidoGuDong;

public interface LocationService {
	List<SidoGuDong> getSido() throws Exception;
	List<SidoGuDong> getGugunInSido(String sido) throws Exception;
	List<HouseInfo> getDongInGugun(String gugun) throws Exception;
	List<HouseInfo> getAptInDong(String dong) throws Exception;
}
