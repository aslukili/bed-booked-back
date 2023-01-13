package org.loukili.bedbooker.service;


import org.loukili.bedbooker.entity.Room;
import org.loukili.bedbooker.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService{
  private final RoomRepository roomRepository;
  private final HotelService hotelService;

  @Autowired
  public RoomServiceImpl(RoomRepository roomRepository, HotelService hotelService) {
    this.roomRepository = roomRepository;
    this.hotelService = hotelService;
  }

  @Override
  public List<Room> getAll() {
    return roomRepository.findAll();
  }

  @Override
  public List<Room> getPaginated(int pageNo, int pageSize) {
    Pageable paging = PageRequest.of(pageNo, pageSize);
    Page<Room> pagedResult = roomRepository.findAll(paging);

    return pagedResult.toList();
  }

  @Override
  public Room save(Room room) {
    room.setHotel(hotelService.getHotelById(room.getHotel().getId()).orElseThrow());
    return roomRepository.save(room);
  }

  @Override
  public Optional<Room> getRoomById(Long id) {
    return roomRepository.findRoomById(id);
  }
}
