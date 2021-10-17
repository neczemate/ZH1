package hu.nye.progtech.torpedo;

import hu.nye.progtech.torpedo.model.MapVO;
import hu.nye.progtech.torpedo.service.exception.MapParseException;
import hu.nye.progtech.torpedo.service.exception.MapReadException;
import hu.nye.progtech.torpedo.service.map.parser.MapParser;
import hu.nye.progtech.torpedo.service.map.reader.MapReader;
import hu.nye.progtech.torpedo.service.map.reader.impl.BufferedReaderMapReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        int[][] map = {
                {0,1},
                {2,3}
        };
        boolean[][] fixed = {
                {false,true},
                {true,true}
        };
        MapVO mapVo = new MapVO(2,2,map,fixed);


        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("map/beginner.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        MapReader mapReader = new BufferedReaderMapReader(bufferedReader);
        try {
            List<String> strings = mapReader.readMap();
            if(LOGGER.isInfoEnabled()){
                LOGGER.info("MapReader readMap output: " + strings);
            }

            MapParser mapParser = new MapParser(9,9);
            MapVO mapVO1 = mapParser.parseMap(strings);
            if(LOGGER.isWarnEnabled()){
                LOGGER.warn("MapParser parseMap output: " + mapVO1);
            }
        } catch (MapReadException e) {
            LOGGER.error("MapReadException error: ",e);
        } catch (MapParseException e) {
            LOGGER.error("MapParseException error: ",e);
        }
    }

}
