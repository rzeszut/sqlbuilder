package org.rzeszut.sqlbuilder.mixins;

public interface QueryBuilderSupport extends BaseMixin {
    default String build() {
        return getBuilder().toString();
    }
}
