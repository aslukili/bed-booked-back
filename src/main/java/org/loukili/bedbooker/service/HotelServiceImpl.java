package org.loukili.bedbooker.service;


import org.loukili.bedbooker.entity.Hotel;
import org.loukili.bedbooker.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{

  private final HotelRepository hotelRepository;

  public HotelServiceImpl(HotelRepository hotelRepository) {
    this.hotelRepository = hotelRepository;
  }

  @Override
  public List<Hotel> getAll() {
    return hotelRepository.findAll();
  }
}
