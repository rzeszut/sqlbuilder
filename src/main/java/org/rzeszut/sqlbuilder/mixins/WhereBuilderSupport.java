package org.rzeszut.sqlbuilder.mixins;

import org.rzeszut.sqlbuilder.Condition;

public interface WhereBuilderSupport extends BaseMixin {
    default void addWhere(Condition cond) {
        getBuilder().append(" WHERE ");
        cond.appendTo(getBuilder());
    }
}
