package org.rzeszut.querybuilder.mixins;

public interface QueryBuilderSupport extends BaseMixin {
    default String build() {
        return getBuilder().toString();
    }
}
