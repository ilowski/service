package tools;

import enums.Material;
import org.junit.Assert;
import org.junit.Test;

public class MaterialParserTest {

    @Test
    public void parseMaterialLeatherTest() {
        //is
        String materialStr = "LEatHER";
        //then
        Material material = MaterialParser.parseStringToMaterial(materialStr);
        //excepted
        Assert.assertEquals(Material.LEATHER, material);
    }

    @Test
    public void parseMaterialFurTest() {
        //is
        String materialStr = "FuR";
        //then
        Material material = MaterialParser.parseStringToMaterial(materialStr);
        //excepted
        Assert.assertEquals(Material.FUR, material);
    }

    @Test
    public void parseMaterialWoolTest() {
        //is
        String materialStr = "WoOl";
        //then
        Material material = MaterialParser.parseStringToMaterial(materialStr);
        //excepted
        Assert.assertEquals(Material.WOOL, material);
    }

    @Test
    public void parseMaterialCottonTest() {
        //is
        String materialStr = "CoTTon";
        //then
        Material material = MaterialParser.parseStringToMaterial(materialStr);
        //excepted
        Assert.assertEquals(Material.COTTON,material);
    }

    @Test
    public void parseMaterialPolyesterTest() {
        //is
        String materialStr = "PolyESTER";
        //then
        Material material = MaterialParser.parseStringToMaterial(materialStr);
        //excepted
        Assert.assertEquals(Material.POLYESTER,material);
    }

    @Test
    public void parseMaterialOtherTest() {
        //is
        String materialStr = "OtherMATERIAL";
        //then
        Material material = MaterialParser.parseStringToMaterial(materialStr);
        //excepted
        Assert.assertEquals(Material.POLYESTER,material);
    }
}
