package org.loukili.bedbooker.service;


import org.loukili.bedbooker.entity.Room;
import org.loukili.bedbooker.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
  private final RoomRepository roomRepository;

  @Autowired
  public RoomServiceImpl(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  @Override
  public List<Room> getAll() {
    return roomRepository.findAll();
  }

  @Override
  public Room save(Room room) {
    return roomRepository.save(room);
  }
}
