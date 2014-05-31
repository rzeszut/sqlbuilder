package org.rzeszut.sqlbuilder;

public enum JoinType {
    INNER("INNER JOIN"),
    LEFT_OUTER("LEFT OUTER JOIN"),
    RIGHT_OUTER("RIGHT OUTER JOIN"),
    FULL_OUTER("FULL OUTER JOIN");

    private String sql;

    private JoinType(String sql) {
        this.sql = sql;
    }

    @Override
    public String toString() {
        return sql;
    }
}
