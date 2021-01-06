package ua.model.service.Impl;

import ua.model.dto.RoomDTO;
import ua.model.entity.Room;
import ua.model.service.RoomService;

import java.util.List;
import java.util.Optional;


public class RoomServiceImpl extends RoomService {

    @Override
    public void addRoom(RoomDTO roomDTO) {
        roomDAO.add(buildRoomDtoToRoom(roomDTO));
    }

    @Override
    public Optional<Room> getById(Long id) {
        return roomDAO.getById(id);
    }

    @Override
    public void update(RoomDTO roomDTO) {
        roomDAO.update(buildRoomDtoToRoom(roomDTO));
    }

    @Override
    public void remove(RoomDTO roomDTO) {
        roomDAO.remove(buildRoomDtoToRoom(roomDTO));
    }

    @Override
    public List<Room> getAll() {
        return roomDAO.geAll();
    }

    public Room buildRoomDtoToRoom(RoomDTO roomDTO)
    {
        return Room.RoomBuilder()
                .apartmentClass(roomDTO.getApartmentClass())
                .apartmentName(roomDTO.getApartmentName())
                .seatsNumber(roomDTO.getSeatsNumber())
                .statusRoom(roomDTO.getStatusRoom())
                .price(roomDTO.getPrice())
                .build();
    }
}
