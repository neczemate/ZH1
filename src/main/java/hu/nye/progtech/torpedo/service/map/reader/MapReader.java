package hu.nye.progtech.torpedo.service.map.reader;

import hu.nye.progtech.torpedo.service.exception.MapReadException;

import java.util.List;

public interface MapReader {

    List<String> readMap() throws MapReadException;
}
