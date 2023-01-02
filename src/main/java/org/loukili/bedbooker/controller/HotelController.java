package org.loukili.bedbooker.controller;


import org.loukili.bedbooker.entity.Hotel;
import org.loukili.bedbooker.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.endpoint}/hotels")
public class HotelController {
  private final HotelService hotelService;

  @Autowired
  public HotelController(HotelService hotelService) {
    this.hotelService = hotelService;
  }


  @GetMapping("")
  public ResponseEntity<List<Hotel>> getAll(){
    return new ResponseEntity<>(hotelService.getAll(), HttpStatus.OK);
  }

}
