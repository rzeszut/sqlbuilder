package org.rzeszut.sqlbuilder.mixins;

public interface GroupByBuilderSupport extends BaseMixin {
    default void addGroupBy(String column) {
        getBuilder().append(" GROUP BY ").append(column);
    }
}
