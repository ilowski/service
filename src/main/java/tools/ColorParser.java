package tools;

import enums.Color;

public class ColorParser {

    public static Color parseStringToColor(String colorStr) {
        String color =  colorStr.toUpperCase();

        if (color.equals("RED")) {
            return Color.RED;
        }
        if (color.equals("BLACK")) {
            return Color.BLACK;
        }
        if (color.equals("WHITE")) {
            return Color.WHITE;
        }
        if (color.equals("YELLOW")) {
            return Color.YELLOW;
        }
        if (color.equals("BLUE")) {
            return Color.BLUE;
        }
    }

}
