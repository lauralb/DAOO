package query;

import com.sun.istack.internal.NotNull;
import query.visitor.QueryVisitor;
import query.visitor.Visitable;


public class Column<T extends Comparable<T>> extends Value<T> implements Visitable {
    private final String columnName;

    public Column(@NotNull String columnName){
        this.columnName = columnName;
    }

    @NotNull
    public UnitCondition isNull() {
        return new UnitCondition(Operator.NULL, this);
    }

    @NotNull
    public UnitCondition isNotNull() {
        return new UnitCondition(Operator.NOT_NULL, this);
    }

    @NotNull
    public BinaryCondition greaterThan(@NotNull Value<Integer> value) {
        return new BinaryCondition(Operator.GREAT, this, value);
    }

    @NotNull
    public BinaryCondition greaterEqualThan(@NotNull Value<Integer> value) {
        return new BinaryCondition(Operator.GREAT, this, value);
    }

    @NotNull
    public BinaryCondition lessThan(@NotNull Value<Integer> value) {
        return new BinaryCondition(Operator.LESS, this, value);
    }

    @NotNull
    public BinaryCondition equalTo(@NotNull Value<Integer> value) {
        return new BinaryCondition(Operator.EQ, this, value);
    }

    @NotNull
    public BinaryCondition notEqual(@NotNull Value<Integer> value) {
        return new BinaryCondition(Operator.NE, this, value);
    }

    public String getName(){
        return columnName;
    }

    public void accept(QueryVisitor visitor){
        visitor.visit(this);
    }
}
