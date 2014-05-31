package org.rzeszut.sqlbuilder.mixins;

import org.rzeszut.sqlbuilder.Condition;

public interface HavingBuilderSupport extends BaseMixin {
    default void addHaving(Condition cond) {
        getBuilder().append(" HAVING ");
        cond.appendTo(getBuilder());
    }
}
