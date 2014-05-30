package org.rzeszut.querybuilder.mixins;

import org.rzeszut.querybuilder.Condition;

public interface WhereBuilderSupport extends BaseMixin {
    default void addWhere(Condition cond) {
        getBuilder().append(" WHERE ");
        cond.appendTo(getBuilder());
    }
}
