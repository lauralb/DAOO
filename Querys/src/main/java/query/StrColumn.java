package query;

import java.math.BigInteger;


public class StrColumn extends Column<String>{

    public StrColumn(String name){
        super(name);
    }

    public BinaryCondition equals(Value<String> value) {
        return new BinaryCondition(Operator.EQ, this, value);
    }

    public BinaryCondition startsWith(Value<String> value) {
        return new BinaryCondition(Operator.STARTS, this, value);
    }

    public Condition contains(Value<String> value) {
        return new BinaryCondition(Operator.CONTAINS, this, value);
    }

}
