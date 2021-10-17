package hu.nye.progtech.torpedo.model;

import java.util.Arrays;
import java.util.Objects;

public final class MapVO {

    private final int numberOfRows;
    private final int NumberOfColumns;
    private final int[][] map;
    private final boolean[][] fixed;

    public MapVO(int numberOfRows, int numberOfColumns, int[][] map, boolean[][] fixed) {
        this.numberOfRows = numberOfRows;
        NumberOfColumns = numberOfColumns;
        this.map = deepCopy(map);
        this.fixed = deepCopy(fixed);
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return NumberOfColumns;
    }

    public int[][] getMap() {
        return deepCopy(this.map);
    }

    public boolean[][] getFixed() {
        return deepCopy(this.fixed);
    }

    private int[][] deepCopy(int map[][]){
        int[][] result = new int[map.length][];

        for(int i = 0; i < map.length;i++)
        {
            result[i] = new int[map[i].length];
            for (int j = 0; j < map.length;j++)
            {
                result[i][j] = map[i][j];
            }
        }

        return result;
    }

    private boolean[][] deepCopy(boolean map[][]){
        boolean[][] result = new boolean[map.length][];

        for(int i = 0; i < map.length;i++)
        {
            result[i] = new boolean[map[i].length];
            for (int j = 0; j < map.length;j++)
            {
                result[i][j] = map[i][j];
            }
        }

        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapVO mapVO = (MapVO) o;
        return numberOfRows == mapVO.numberOfRows && NumberOfColumns == mapVO.NumberOfColumns && Arrays.deepEquals(map, mapVO.map) && Arrays.deepEquals(fixed, mapVO.fixed);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfRows, NumberOfColumns);
        result = 31 * result + Arrays.deepHashCode(map);
        result = 31 * result + Arrays.deepHashCode(fixed);
        return result;
    }

    @Override
    public String toString() {
        return "MapVO{" +
                "numberOfRows=" + numberOfRows +
                ", NumberOfColumns=" + NumberOfColumns +
                ", map=" + Arrays.deepToString(map) +
                ", fixed=" + Arrays.deepToString(fixed) +
                '}';
    }
}
