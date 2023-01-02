package org.loukili.bedbooker.controller;


import org.loukili.bedbooker.entity.Reservation;
import org.loukili.bedbooker.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.endpoint}/reservations")
public class ReservationController {
  private final ReservationService reservationService;

  public ReservationController(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @GetMapping("")
  public ResponseEntity<List<Reservation>> getReservations(){
    return new ResponseEntity<>(reservationService.getReservations(), HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<Reservation> reserve(@RequestBody Reservation reservation){
    return new ResponseEntity<>(reservationService.reserve(reservation), HttpStatus.OK);
  }

}
