package org.rzeszut.querybuilder;

import org.rzeszut.querybuilder.mixins.*;

public final class InsertBuilder implements IntoBuilderSupport {
    private StringBuilder builder = new StringBuilder("INSERT");

    private InsertBuilder() {}

    public static InsertBuilder insert() {
        return new InsertBuilder();
    }

    public IntoBuilder into(String table) {
        addInto(table);
        return new IntoBuilder();
    }

    @Override
    public StringBuilder getBuilder() {
        return builder;
    }

    public final class IntoBuilder extends ColumnsBuilder implements ColumnsBuilderSupport {
        private IntoBuilder() {}

        public ColumnsBuilder columns(String... values) {
            addColumns(values);
            return new ColumnsBuilder();
        }
    }

    public class ColumnsBuilder extends BaseBuilder implements ValuesBuilderSupport {
        private ColumnsBuilder() {}

        public ValuesBuilder values(String... values) {
            addValues(values);
            return new ValuesBuilder();
        }
    }

    public final class ValuesBuilder extends BaseBuilder implements QueryBuilderSupport, ValuesBuilderSupport {
        private ValuesBuilder() {}

        public ValuesBuilder values(String... values) {
            addNextValues(values);
            return new ValuesBuilder();
        }
    }

    private class BaseBuilder implements BaseMixin {

        @Override
        public StringBuilder getBuilder() {
            return builder;
        }
    }
}
