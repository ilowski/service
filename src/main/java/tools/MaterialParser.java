package tools;

import enums.Material;

public class MaterialParser {
    public static Material parseStringToMaterial(String materialStr) {
        String material = materialStr.toUpperCase();
        if (material.equals("LEATHER")) {
            return Material.LEATHER;
        } else if (material.equals("FUR")) {
            return Material.FUR;
        } else if (material.equals("WOOL")) {
            return Material.WOOL;
        } else if (material.equals("COTTON")) {
            return Material.COTTON;
        } else if (material.equals("POLYESTER")) {
            return Material.POLYESTER;
        }
        return Material.POLYESTER;
    }
}
