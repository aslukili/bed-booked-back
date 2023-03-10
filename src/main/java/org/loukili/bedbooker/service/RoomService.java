package org.loukili.bedbooker.service;

import org.loukili.bedbooker.entity.Room;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public interface RoomService {
  List<Room> getAll();
  List<Room> getPaginated(int pageNo, int pageSize);

  Room save(Room room);

  Optional<Room> getRoomById(Long id);

  List<Room> getRoomsByHotelId(Long id);
}
