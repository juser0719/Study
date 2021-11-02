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
import com.ssafy.happyhouse.model.SidoGunCodeDto;
import com.ssafy.happyhouse.service.HappyHouseMapService;

@RestController
@RequestMapping("/map")
public class HappyHouseMapController {
	
	@Autowired
	private HappyHouseMapService happyHouseMapService;
	
	@GetMapping("/sido")
	public ResponseEntity<List<SidoGunCodeDto>> sido() throws Exception{
		return new ResponseEntity<List<SidoGunCodeDto>>(happyHouseMapService.getSido(),HttpStatus.OK);
	}
	
	@GetMapping("gugun")
	public ResponseEntity<List<SidoGunCodeDto>> gugun(@RequestParam("sido") String sido) throws Exception{
		return new ResponseEntity<List<SidoGunCodeDto>>(happyHouseMapService.getGugunInSido(sido),HttpStatus.OK);
	}
	
	@GetMapping("dong")
	public ResponseEntity<List<HouseInfoDto>> dong(@RequestParam("gugun") String gugun) throws Exception{
		return new ResponseEntity<List<HouseInfoDto>>(happyHouseMapService.getDongInGugun(gugun),HttpStatus.OK);
	}
	
	@GetMapping("apt")
	public ResponseEntity<List<HouseInfoDto>> apt(@RequestParam("dong") String dong) throws Exception{
		return new ResponseEntity<List<HouseInfoDto>>(happyHouseMapService.getAptInDong(dong),HttpStatus.OK);
	}
}
