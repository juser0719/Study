package backend.model.service;

import java.util.List;

import backend.dto.HouseInfo;
import backend.dto.SidoGuDong;
import backend.model.dao.LocationDaoImpl;

public class LocationServiceImpl implements LocationService {
	
	private static LocationService locationService;
	
	private LocationServiceImpl() {}
	
	public static LocationService getLocationService() {
		if(locationService == null)
			locationService = new LocationServiceImpl();
		return locationService;
	}

	@Override
	public List<SidoGuDong> getSido() throws Exception {
		return LocationDaoImpl.getLocationDao().getSido();
	}

	@Override
	public List<SidoGuDong> getGugunInSido(String sido) throws Exception {
		return LocationDaoImpl.getLocationDao().getGugun(sido);
	}

	@Override
	public List<HouseInfo> getDongInGugun(String gugun) throws Exception {
		return LocationDaoImpl.getLocationDao().getDong(gugun);
	}

	@Override
	public List<HouseInfo> getAptInDong(String dong) throws Exception {
		return null;
	}

}
