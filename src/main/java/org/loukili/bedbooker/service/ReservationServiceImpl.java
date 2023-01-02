package org.loukili.bedbooker.service;


import org.loukili.bedbooker.entity.Reservation;
import org.loukili.bedbooker.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

  private final ReservationRepository reservationRepository;

  @Autowired
  public ReservationServiceImpl(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  @Override
  public List<Reservation> getReservations() {
    return reservationRepository.findAll();
  }

  @Override
  public Reservation reserve(Reservation reservation) {
    return reservationRepository.save(reservation);
  }
}
