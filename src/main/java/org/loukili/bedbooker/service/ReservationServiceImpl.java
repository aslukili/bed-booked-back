package org.loukili.bedbooker.service;


import org.loukili.bedbooker.entity.Reservation;
import org.loukili.bedbooker.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    reservation.setUser(userService.getUserById(reservation.getUser().getId()).orElseThrow());
    reservation.setRoom(roomService.getRoomById(reservation.getRoom().getId()).orElseThrow());

    // calculate the total price:
    reservation.setPrice(getDifferenceDays(reservation.getStartDate(), reservation.getEndDate()) * reservation.getRoom().getPrice());
    return reservationRepository.save(reservation);
  }


  // calculate the days between checkin and checkout days
  public static long getDifferenceDays(Date d1, Date d2) {
    long diff = d2.getTime() - d1.getTime();
    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
  }
}
