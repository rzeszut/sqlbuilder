package org.rzeszut.sqlbuilder.mixins;

import org.rzeszut.sqlbuilder.Condition;

public interface JoinConditionBuilderSupport extends BaseMixin {
    default void addOn(Condition cond) {
        getBuilder().append(" ON ");
        cond.appendTo(getBuilder());
    }

    default void addUsing(String column) {
        getBuilder().append(" USING (").append(column).append(")");
    }
}
