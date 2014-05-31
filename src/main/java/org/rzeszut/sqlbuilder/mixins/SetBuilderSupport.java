package org.rzeszut.sqlbuilder.mixins;

public interface SetBuilderSupport extends BaseMixin {
    default void addSet(String column, String value) {
        getBuilder().append(" SET ").append(column).append(" = ").append(value);
    }

    default void addNextSet(String column, String value) {
        getBuilder().append(", ").append(column).append(" = ").append(value);
    }
}
