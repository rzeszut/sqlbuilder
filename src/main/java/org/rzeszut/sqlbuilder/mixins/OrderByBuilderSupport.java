package org.rzeszut.sqlbuilder.mixins;

import org.rzeszut.sqlbuilder.Order;

public interface OrderByBuilderSupport extends BaseMixin {
    default void addOrderBy(String column) {
        getBuilder().append(" ORDER BY ").append(column);
    }

    default void addOrderBy(String column, Order order) {
        getBuilder().append(" ORDER BY ").append(column).append(" ").append(order);
    }

    default void addNextOrderBy(String column) {
        getBuilder().append(", ").append(column);
    }

    default void addNextOrderBy(String column, Order order) {
        getBuilder().append(", ").append(column).append(" ").append(order);
    }
}
