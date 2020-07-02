package tools;

import enums.Material;

public class MaterialParser {
    public static Material parseStringToMaterial(String materialStr) {
        String material = materialStr.toUpperCase();
        if (materialStr.equals("LEATHER")) {
            return Material.LEATHER;
        } else if (materialStr.equals("FUR")) {
            return Material.FUR;
        } else if (materialStr.equals("WOOL")) {
            return Material.WOOL;
        } else if (materialStr.equals("COTTON")) {
            return Material.COTTON;
        } else if (materialStr.equals("POLYESTERS")) {
            return Material.POLYESTERS;
        }
        return Material.POLYESTERS;
    }
}
