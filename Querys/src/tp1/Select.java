package tp1;


import tp1.visitor.QueryVisitor;
import tp1.visitor.Visitable;

import java.util.List;

public class Select implements Visitable {

    private final List<Column> columns;

    public Select(List<Column> columns) {
        this.columns = columns;
    }

    @Override
    public void accept(QueryVisitor visitor) {
        visitor.visit(this);
    }

    public List<Column> getColumns() {
        return columns;
    }
}
