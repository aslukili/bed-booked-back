package org.loukili.bedbooker.service;

import org.loukili.bedbooker.entity.Room;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface RoomService {
  List<Room> getAll();

  Room save(Room room);
}
