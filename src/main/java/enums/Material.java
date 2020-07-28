package enums;

public enum Material {

    LEATHER("LEATHER"), FUR("FUR"), COTTON("COTTON"), WOOL("WOOL"), POLYESTER("POLYESTER");

    private String name;

    private Material(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return name;
    }
}
