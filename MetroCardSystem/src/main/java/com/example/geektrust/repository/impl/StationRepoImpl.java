package com.example.geektrust.repository.impl;

import java.util.HashMap;
import java.util.Map;

import com.example.geektrust.entity.Station;
import com.example.geektrust.repository.IStationRepository;

public class StationRepoImpl implements IStationRepository {

    private Map<String,Station> savedStations = new HashMap<>();

    @Override
    public Station findStationByName(String fromStation) {
        return savedStations.get(fromStation);
    }

    @Override
    public void updateStation(String fromStation,Station station) {
        savedStations.put(fromStation, station);
    }

    @Override
    public Map<String, Station> findAll() {
        return savedStations;
    }

    
    
}

