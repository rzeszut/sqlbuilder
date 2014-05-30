package org.rzeszut.querybuilder.mixins;

import org.rzeszut.querybuilder.Condition;

/**
 * Created by mateusz on 30.05.14.
 */
public interface HavingBuilderSupport extends BaseMixin {
    default void addHaving(Condition cond) {
        getBuilder().append(" HAVING ");
        cond.appendTo(getBuilder());
    }
}
