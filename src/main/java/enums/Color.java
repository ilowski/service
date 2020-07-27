package enums;

public enum Color {
    BLACK("#000000","Black"), WHITE("#FFFFFF","White"), RED("#FF0000","Red"), GREEN("#008000","Green"), BLUE("#0000FF","Blue"), YELLOW("#FFFF00","Yellow");

    private String hex;
    private String name;

    Color(String hex, String name) {
        this.hex = hex;
        this.name = name;
    }

    public String getColor() {
        return name;
    }

    public String getHex() {
        return hex;
    }
}
