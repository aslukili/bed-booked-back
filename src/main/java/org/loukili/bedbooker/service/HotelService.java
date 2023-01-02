package org.loukili.bedbooker.service;

import org.loukili.bedbooker.entity.Hotel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HotelService {
    List<Hotel> getAll();
}
