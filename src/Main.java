public class Main {
    public static void main(String[] args) {
        SpreadSheet sp = new SpreadSheet(4,5);
        sp.setValueAt(1,5,12);
        sp.setValueAt(4,5,42);
        sp.setValueAt(5,2,22);
        sp.setValueAt(7,5,32);
        sp.setValueAt(5,5,68);

        System.out.println(sp.getColumnSum(0));
        System.out.println(sp.getRowSum(0));
        System.out.println(sp.getAreaSum(1,2,5,7));
        System.out.println(sp.getColumnSum(0));


        sp.reset();

        System.out.println(sp.getValuAt(0,0));
        System.out.println(sp.getColorAt(0,0));

        sp.setColorAt(0,0, Cell.Color.GREEN);
        System.out.println(sp.getColorAt(0,0));





    }
}