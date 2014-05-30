package org.rzeszut.querybuilder.mixins;

import org.rzeszut.querybuilder.Condition;

public interface JoinConditionBuilderSupport extends BaseMixin {
    default void addOn(Condition cond) {
        getBuilder().append(" ON ");
        cond.appendTo(getBuilder());
    }

    default void addUsing(String column) {
        getBuilder().append(" USING (").append(column).append(")");
    }
}
