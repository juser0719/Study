package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.service.HappyHouseMapService;

@RestController
@RequestMapping("/map")
public class HappyHouseMapController {

	@Autowired
	private HappyHouseMapService happyHouseService;

	@GetMapping("/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> sido() throws Exception {
		List<SidoGugunCodeDto> list = happyHouseService.getSido();
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<SidoGugunCodeDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<SidoGugunCodeDto>>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/gugun")
	public ResponseEntity<List<SidoGugunCodeDto>> gugun(@RequestParam("sido") String sido) throws Exception {
		List<SidoGugunCodeDto> list = happyHouseService.getGugunInSido(sido);
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<SidoGugunCodeDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<SidoGugunCodeDto>>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/dong")
	public ResponseEntity<List<HouseInfoDto>> dong(@RequestParam("gugun") String gugun) throws Exception {
		List<HouseInfoDto> list = happyHouseService.getDongInGugun(gugun);
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<HouseInfoDto>>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/apt")
	public ResponseEntity<List<HouseInfoDto>> apt(@RequestParam("dong") String dong) throws Exception {
		List<HouseInfoDto> list = happyHouseService.getAptInDong(dong);
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<HouseInfoDto>>(HttpStatus.NO_CONTENT);
		}
	}

}
