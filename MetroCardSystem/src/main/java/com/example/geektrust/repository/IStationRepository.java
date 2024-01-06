package com.example.geektrust.repository;

import java.util.Map;

import com.example.geektrust.entity.Station;

public interface IStationRepository {

    Station findStationByName(String fromStation);

    void updateStation(String fromStation,Station station);

    Map<String, Station> findAll();

    
    
}
