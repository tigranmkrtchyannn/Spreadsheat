import java.awt.*;

public class Cell {

    private Object value;
    private Color color;
    private Type type;

    public enum Color{
        WHITE,
        RED,
        YELLOW,
        GREEN
    }
    public enum Type{
        STRING,
        NUMBER,
        DATE

    }
    public Cell(){
        this.color=Color.WHITE;
        this.type=Type.DATE;

    }

    public void setValue(Object value){
    this.value=value;
    }

    public Object getValue() {
        return value;
    }

    public Cell.Type getType() {
        return type;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public Cell.Color getColor(){
        return color;
    }
    public void reset(){
        this.value = null;
        this.color = Color.WHITE;
    }

    public void setType(Cell.Type type) {
       this.type = type;
    }
}
