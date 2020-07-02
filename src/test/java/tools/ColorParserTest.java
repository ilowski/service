package tools;

import enums.Color;
import org.junit.Assert;
import org.junit.Test;

public class ColorParserTest {

@Test
    public void parseColorRedTest() {

    //is
    String colorStr = "rEd";

    //then
    Color color = ColorParser.parseStringToColor(colorStr);

    //excepted
    Assert.assertEquals(Color.RED,color);
    }
@Test
    public void parseColorBlueTest() {
    //is
    String colorStr="BlUe";
    //then
    Color color =  ColorParser.parseStringToColor(colorStr);
    //excepted
    Assert.assertEquals(Color.BLUE,color);
    }

    @Test
    public void parseColorBlackTest() {
        //is
        String colorStr="BLAck";
        //then
        Color color =  ColorParser.parseStringToColor(colorStr);
        //excepted
        Assert.assertEquals(Color.BLACK,color);
    }

    @Test
    public void parseColorWhiteTest() {
        //is
        String colorStr="WhiTE";
        //then
        Color color =  ColorParser.parseStringToColor(colorStr);
        //excepted
        Assert.assertEquals(Color.WHITE,color);
    }

    @Test
    public void parseColorYellowTest() {
        //is
        String colorStr="YELLoW";
        //then
        Color color =  ColorParser.parseStringToColor(colorStr);
        //excepted
        Assert.assertEquals(Color.YELLOW,color);
    }

    @Test
    public void parseColorOtherTest() {
        //is
        String colorStr="TestColor";
        //then
        Color color =  ColorParser.parseStringToColor(colorStr);
        //excepted
        Assert.assertEquals(Color.WHITE,color);
    }
}
