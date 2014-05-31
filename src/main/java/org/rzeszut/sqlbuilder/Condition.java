package org.rzeszut.sqlbuilder;

public abstract class Condition {
    private Condition() {}

    public abstract void appendTo(StringBuilder builder);

    public static Condition isNull(String column) {
        return new ColumnCondition(column, " IS NULL");
    }

    public static Condition isNotNull(String column) {
        return new ColumnCondition(column, " IS NOT NULL");
    }

    public static Condition eq(String lhs, String rhs) {
        return new OperatorCondition(" = ", lhs, rhs);
    }

    public static Condition neq(String lhs, String rhs) {
        return new OperatorCondition(" != ", lhs, rhs);
    }

    public static Condition lt(String lhs, String rhs) {
        return new OperatorCondition(" < ", lhs, rhs);
    }

    public static Condition gt(String lhs, String rhs) {
        return new OperatorCondition(" > ", lhs, rhs);
    }

    public static Condition le(String lhs, String rhs) {
        return new OperatorCondition(" <= ", lhs, rhs);
    }

    public static Condition ge(String lhs, String rhs) {
        return new OperatorCondition(" >= ", lhs, rhs);
    }

    public static Condition and(Condition lhs, Condition rhs, Condition... rest) {
        return new ComplexCondition(" AND ", lhs, rhs, rest);
    }

    public static Condition or(Condition lhs, Condition rhs, Condition... rest) {
        return new ComplexCondition(" OR ", lhs, rhs, rest);
    }

    private static final class ColumnCondition extends Condition {
        private String column;
        private String condition;

        private ColumnCondition(String column, String condition) {
            this.column = column;
            this.condition = condition;
        }

        @Override
        public void appendTo(StringBuilder builder) {
            builder.append(column).append(condition);
        }
    }

    private static final class OperatorCondition extends Condition {
        private String operator;
        private String lhs;
        private String rhs;

        private OperatorCondition(String operator, String lhs, String rhs) {
            this.operator = operator;
            this.lhs = lhs;
            this.rhs = rhs;
        }

        @Override
        public void appendTo(StringBuilder builder) {
            builder.append(lhs).append(operator).append(rhs);
        }
    }

    private static final class ComplexCondition extends Condition {
        private String operator;
        private Condition lhs;
        private Condition rhs;
        private Condition[] rest;

        private ComplexCondition(String operator, Condition lhs, Condition rhs, Condition[] rest) {
            this.operator = operator;
            this.lhs = lhs;
            this.rhs = rhs;
            this.rest = rest;
        }

        @Override
        public void appendTo(StringBuilder builder) {
            builder.append("(");

            lhs.appendTo(builder);
            builder.append(operator);
            rhs.appendTo(builder);

            for (Condition cond : rest) {
                builder.append(operator);
                cond.appendTo(builder);
            }

            builder.append(")");
        }
    }
}
