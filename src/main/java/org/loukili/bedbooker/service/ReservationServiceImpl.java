package org.loukili.bedbooker.service;


import org.loukili.bedbooker.entity.Reservation;
import org.loukili.bedbooker.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

  private final ReservationRepository reservationRepository;
  private final RoomService roomService;
  private final UserService userService;

  @Autowired
  public ReservationServiceImpl(ReservationRepository reservationRepository, RoomService roomService, UserService userService) {
    this.reservationRepository = reservationRepository;
    this.roomService = roomService;
    this.userService = userService;
  }

  @Override
  public List<Reservation> getReservations() {
    return reservationRepository.findAll();
  }

  @Override
  public Reservation reserve(Reservation reservation) {
    reservation.setPrice(1300.0);
    reservation.setUser(userService.getUserById(reservation.getUser().getId()).orElseThrow());
    reservation.setRoom(roomService.getRoomById(reservation.getRoom().getId()).orElseThrow());
    return reservationRepository.save(reservation);
  }
}
