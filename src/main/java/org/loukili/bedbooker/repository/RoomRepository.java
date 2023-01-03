package org.loukili.bedbooker.repository;


import org.loukili.bedbooker.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
  Optional<Room> findRoomById(Long id);
}
