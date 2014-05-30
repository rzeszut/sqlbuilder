package org.rzeszut.querybuilder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConditionTest {

    @Test
    public void isNull_test() {
        // given
        final StringBuilder builder = new StringBuilder();
        final Condition cond = Condition.isNull("column");

        // when
        cond.appendTo(builder);
        final String out = builder.toString();

        // then
        assertEquals("column IS NULL", out);
    }

    @Test
    public void isNotNull_test() {
        // given
        final StringBuilder builder = new StringBuilder();
        final Condition cond = Condition.isNotNull("column");

        // when
        cond.appendTo(builder);
        final String out = builder.toString();

        // then
        assertEquals("column IS NOT NULL", out);
    }

    @Test
    public void eq_test() {
        // given
        final StringBuilder builder = new StringBuilder();
        final Condition cond = Condition.eq("col", ":val");

        // when
        cond.appendTo(builder);
        final String out = builder.toString();

        // then
        assertEquals("col = :val", out);
    }

    @Test
    public void neq_test() {
        // given
        final StringBuilder builder = new StringBuilder();
        final Condition cond = Condition.neq("col", ":val");

        // when
        cond.appendTo(builder);
        final String out = builder.toString();

        // then
        assertEquals("col != :val", out);
    }

    @Test
    public void lt_test() {
        // given
        final StringBuilder builder = new StringBuilder();
        final Condition cond = Condition.lt("col", ":val");

        // when
        cond.appendTo(builder);
        final String out = builder.toString();

        // then
        assertEquals("col < :val", out);
    }

    @Test
    public void gt_test() {
        // given
        final StringBuilder builder = new StringBuilder();
        final Condition cond = Condition.gt("col", ":val");

        // when
        cond.appendTo(builder);
        final String out = builder.toString();

        // then
        assertEquals("col > :val", out);
    }

    @Test
    public void le_test() {
        // given
        final StringBuilder builder = new StringBuilder();
        final Condition cond = Condition.le("col", ":val");

        // when
        cond.appendTo(builder);
        final String out = builder.toString();

        // then
        assertEquals("col <= :val", out);
    }

    @Test
    public void ge_test() {
        // given
        final StringBuilder builder = new StringBuilder();
        final Condition cond = Condition.ge("col", ":val");

        // when
        cond.appendTo(builder);
        final String out = builder.toString();

        // then
        assertEquals("col >= :val", out);
    }

    @Test
    public void or_testTwoConditions() {
        // given
        final StringBuilder builder = new StringBuilder();
        final Condition cond1 = Condition.eq("col1", ":val1");
        final Condition cond2 = Condition.neq("col2", ":val2");
        final Condition cond = Condition.or(cond1, cond2);

        // when
        cond.appendTo(builder);
        final String out = builder.toString();

        // then
        assertEquals("(col1 = :val1 OR col2 != :val2)", out);
    }

    @Test
    public void or_testMoreConditions() {
        // given
        final StringBuilder builder = new StringBuilder();
        final Condition cond1 = Condition.eq("col1", ":val1");
        final Condition cond2 = Condition.neq("col2", ":val2");
        final Condition cond3 = Condition.lt("col3", ":val3");
        final Condition cond = Condition.or(cond1, cond2, cond3);

        // when
        cond.appendTo(builder);
        final String out = builder.toString();

        // then
        assertEquals("(col1 = :val1 OR col2 != :val2 OR col3 < :val3)", out);
    }

    @Test
    public void and_testTwoConditions() {
        // given
        final StringBuilder builder = new StringBuilder();
        final Condition cond1 = Condition.eq("col1", ":val1");
        final Condition cond2 = Condition.neq("col2", ":val2");
        final Condition cond = Condition.and(cond1, cond2);

        // when
        cond.appendTo(builder);
        final String out = builder.toString();

        // then
        assertEquals("(col1 = :val1 AND col2 != :val2)", out);
    }

    @Test
    public void and_testMoreConditions() {
        // given
        final StringBuilder builder = new StringBuilder();
        final Condition cond1 = Condition.eq("col1", ":val1");
        final Condition cond2 = Condition.neq("col2", ":val2");
        final Condition cond3 = Condition.lt("col3", ":val3");
        final Condition cond = Condition.and(cond1, cond2, cond3);

        // when
        cond.appendTo(builder);
        final String out = builder.toString();

        // then
        assertEquals("(col1 = :val1 AND col2 != :val2 AND col3 < :val3)", out);
    }
}