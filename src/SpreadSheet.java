public class SpreadSheet {
    private Cell[][] cells;
    private int column;
    private int row;

    public SpreadSheet(int row , int column){
        this.row = row;
        this.column = column;
        this.cells = new Cell[row][column];
        createCells();
    }

    private void createCells(){
        for(int i= 0 ; i< row; i++){
            for(int j = 0 ; j<column;j++){
                cells[i][j] = new Cell();
            }
        }
    }


    public void addColumn(int index){
        if(index >=0 && index < column){
        Cell[][] newCell = new Cell[row][column+1];
        for (int i = 0 ; i< row; i++ ) {
            for (int j = 0; j < index; j++){
                newCell[i][j]=cells[i][j];
            }
            newCell[i][index]= new Cell();
            for (int k = index+1;k<=column;k++){
                newCell[i][k]=cells[i][k-1];
            }
        }
        cells = newCell;
        column++;
        }else {
            System.out.println("Invalid positions....");
        }
    }

    public void addRow(int index){
        if(index >= 0 && index < row){
            Cell[][] newCell =  new Cell[row+1][column];
            for(int i = 0 ; i < index;i++){
              for( int j = 0; j < column ; j++) {
                  newCell[i][j] = cells[i][j];
              }

            }
            for ( int j = 0 ; j < column ; j ++ ){
                newCell[index][j]=new Cell();

            }
            for( int i = index + 1 ;i<= row;i++){
                for ( int j = 0 ; j < column; j++){
                    newCell[i][j] = cells [ i - 1][j];
                }
            }
            cells = newCell;
            row ++ ;

        }else {
            System.out.println("Invealid position .... ");
        }
    }
     public boolean  validCell(int row, int column){
        return row >= 0 && row < this.row && column >= 0 && column < this.column;
     }

    public Object getValuAt(int row, int column){
        if(validCell(row,column)){
            return cells[row][column].getValue();

        }else{
            System.out.println("Invalid position in cell");
            return null;
        }
    }
    public void setValueAt( int row, int column, Object value){
        if(validCell(row,column)){
            cells[row][column].setValue(value);
        }else{
            System.out.print("Invalid cell position....");
        }
    }
    public void setColorAt(int row , int column, Cell.Color color){
        if(validCell(row,column)){
             cells[row][column].setColor(color);
        }else {
            System.out.println("Invalid position in cell");
        }
    }

    public Cell.Color getColorAt(int row, int column){
        if (validCell(row,column)){
            return cells[row][column].getColor();
        }
        else {
            System.out.println("Invalid position in cell");
          return null;
        }

    }
    public  void reset(){
        for(int i = 0 ; i< row;i++){
            for (int j = 0 ; j < column ; j++){
                cells[i][j].reset();
            }
        }
    }

    public void resetCellAt( int row , int column){
        if(validCell(row,column)){
            cells[row][column].reset();
        }else {
            System.out.println("Invalid position in cell...");
        }

    }

    public int getColumnSum(int column){
        int count = 0;
        if(column >= 0  && column < this.column){
            for(int i = 0; i< row; i++){
                Object value = cells[i][column].getValue();
                if(value instanceof  Integer) {
                    count += (int) value;
                }else if( value instanceof Double){
                     count+=(double)value;
                }

            }
            return count;
        }else {
            System.out.print("Invalid column positions....");
            return 0;
        }
    }
    public int getRowSum(int row){
        int count = 0;
        if( row >= 0 && row < this.row){
            for( int i = 0 ; i< column ; i++){
                Object value =  cells[row][i].getValue();
                if(value instanceof  Integer){
                    count+=(int)value;

                }else if(value instanceof Double){
                    count+=(double)value;
                }
            }
            return count;
        }
        else {
            System.out.println("invalid row positions");
            return 0;
        }
    }


    public double getAreaSum(int startRow, int startColumn, int endRow,int endColumn){
        double count = 0;
        if(validCell(startRow,startColumn) && validCell(endRow,endColumn)){
            for(int i = startRow; i <= endRow; i++){
                for ( int j = startColumn; j <= endColumn; j++){
                    Object value = cells[i][j].getValue();
                    if ( value instanceof  Integer){
                        count += (int) value;
                    }else if ( value instanceof  Double){
                        count += (double) value;
                    }
                }
            }
            return count;
        } else {
            System.out.println("Invalid are ....");
            return 0;
        }
    }

    public double getColumnAverage(int column){
        double sum = getColumnSum(column);
         if(column >= 0 && column<this.column){
             return sum / row;
         }else {
             System.out.println("Invalid column position ... ");
             return 0.0;
         }
    }

    public double getRowAverage(int row){
        double count = 0;
        if (row >= 0 && row < this.row){
            count=getRowSum(row);
            return count/column;
        }else {
            System.out.println("Invalid row Positon");
            return 0.0;
        }
    }
    public double getAreAverage(int startRow,int startColumn,int endRow, int endColumn){
        double count = 0;
        int numberOfCell=0;
        if(validCell(startRow,endRow) && validCell(startColumn,endColumn)){
            count+=getAreaSum(startRow,startColumn,endRow,endColumn);
            numberOfCell =  (endRow-startRow)*(endColumn-startColumn);
            return count / numberOfCell;
        }else {
            System.out.println("Invalid are position");
            return  0.0;
        }

    }


}
