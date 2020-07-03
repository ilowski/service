package tools;

import enums.Color;

public class ColorParser {

    public static Color parseStringToColor(String colorStr) {
        String color = colorStr.toUpperCase();

        if (color.equals("RED")) {
            return Color.RED;
        } else if (color.equals("BLACK")) {
            return Color.BLACK;
        } else if (color.equals("WHITE")) {
            return Color.WHITE;
        } else if (color.equals("YELLOW")) {
            return Color.YELLOW;
        } else if (color.equals("BLUE")) {
            return Color.BLUE;
        }
        return Color.WHITE;
    }

}
