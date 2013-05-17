package tp1;

import tp1.visitor.QueryVisitor;
import tp1.visitor.Visitable;

import javax.management.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 4/19/13
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */

public class Table implements Visitable{

    private List<Column> columns;
    private final String name;


    public Table(String name){
        this.name = name;
    }

    public StrColumn str(String columnName) {
        /*for (Column column : columns) {
            if(column.getName().equals(columnName)){
                return column;
            }
        } */
        return new StrColumn(columnName);

    }

    public IntColumn number(String columnName) {
        return new IntColumn(columnName);
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(QueryVisitor visitor) {
        visitor.visit(this);
    }
}
