package org.loukili.bedbooker.repository;


import org.loukili.bedbooker.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>, PagingAndSortingRepository<Room, Long> {
  Optional<Room> findRoomById(Long id);
  List<Room> findRoomsByHotelId(Long id);
}
