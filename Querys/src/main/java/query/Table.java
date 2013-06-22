package query;


import com.sun.istack.internal.NotNull;
import query.visitor.QueryVisitor;
import query.visitor.Visitable;

import java.util.List;


public class Table implements Visitable {

    private final String name;


    public Table(@NotNull String name){
        this.name = name;
    }

    @NotNull
    public StrColumn str(@NotNull String columnName) {
        return new StrColumn(columnName);
    }

    @NotNull
    public IntColumn number(@NotNull String columnName) {
        return new IntColumn(columnName);
    }

    @NotNull
    public String getName() {
        return name;
    }

    @Override
    public void accept(@NotNull QueryVisitor visitor) {
        visitor.visit(this);
    }
}
