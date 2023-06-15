package de.uulm.sp.pvs.util;

public class Sokoban {

    private static class ELEMENT {
        private static final char PLAYER = '@';
        private static final char WALL = '#';
        private static final char CHEST = '$';
        private static final char EMPTY_SPACE = '.';
    }

    public enum DIRECTION {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    public static Point findPlayer(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == ELEMENT.PLAYER) {
                    return new Point(i,j);
                }
            }
        }

        return new Point(-1,-1);
    }

    private static char safeGet(char[][] map, int x, int y) {
        if(x < 0 || x > map.length)
            return ELEMENT.WALL;

        if(y < 0 || y > map[0].length)
            return ELEMENT.WALL;

        return map[x][y];
    }

    public static boolean moveNorth(char[][] map) {
        var playerPos = findPlayer(map);

        switch (safeGet(map, playerPos.getX(), playerPos.getY() - 1)) {
            case ELEMENT.EMPTY_SPACE:
                map[playerPos.getX()][playerPos.getY()] = ELEMENT.EMPTY_SPACE;
                map[playerPos.getX()][playerPos.getY() - 1] = ELEMENT.PLAYER;
                return true;

            case ELEMENT.CHEST:
                if(map[playerPos.getX()][playerPos.getY() - 2] != ELEMENT.EMPTY_SPACE) {
                    return false;
                }

                map[playerPos.getX()][playerPos.getY()] = ELEMENT.EMPTY_SPACE;
                map[playerPos.getX()][playerPos.getY() - 1] = ELEMENT.PLAYER;
                map[playerPos.getX()][playerPos.getY() - 2] = ELEMENT.CHEST;
                return true;

            default: return false;
        }
    }

    public static boolean move(char[][] map, DIRECTION dir) {
        var playerPos = findPlayer(map);

        var direction = switch (dir) {
            case NORTH -> new Point(-1, 0);
            case EAST -> new Point(0, 1);
            case SOUTH -> new Point(1, 0);
            case WEST -> new Point(0, -1);
        };

        var nextSpot = new Point(playerPos.getX() + direction.getX(), playerPos.getY() + direction.getY());
        var nextNextSpot = new Point(playerPos.getX() + direction.getX() * 2, playerPos.getY() + direction.getY() * 2);

        switch (safeGet(map, nextSpot.getX(), nextSpot.getY())) {
            case ELEMENT.EMPTY_SPACE:
                map[playerPos.getX()][playerPos.getY()] = ELEMENT.EMPTY_SPACE;
                map[nextSpot.getX()][nextSpot.getY()] = ELEMENT.PLAYER;
                return true;

            case ELEMENT.CHEST:
                if(map[nextNextSpot.getX()][nextNextSpot.getY()] != ELEMENT.EMPTY_SPACE) {
                    return false;
                }

                map[playerPos.getX()][playerPos.getY()] = ELEMENT.EMPTY_SPACE;
                map[nextSpot.getX()][nextSpot.getY()] = ELEMENT.PLAYER;
                map[nextNextSpot.getX()][nextNextSpot.getY()] = ELEMENT.CHEST;
                return true;

            default: return false;
        }
    }

    public static String sokobanToString(char[][] map) {
        StringBuilder result = new StringBuilder();
        for(char[] line : map) {
            result.append(new String(line));
            result.append("\n");
        }

        return result.toString();
    }

}
