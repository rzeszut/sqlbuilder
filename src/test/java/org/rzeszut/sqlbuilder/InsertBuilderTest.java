package org.rzeszut.sqlbuilder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.rzeszut.sqlbuilder.InsertBuilder.insertInto;

public class InsertBuilderTest {

    @Test
    public void testSimpleInsert() {
        // when
        final String insert = insertInto("users")
                .values("1", ":name")
                .build();

        // then
        assertEquals("INSERT INTO users VALUES (1, :name)", insert);
    }

    @Test
    public void testInsertWithColumns() {
        // when
        final String insert = insertInto("users")
                .columns("id", "name")
                .values("1", ":name")
                .build();

        // then
        assertEquals("INSERT INTO users (id, name) VALUES (1, :name)", insert);
    }

    @Test
    public void testInsertWithMultipleValues() {
        // when
        final String insert = insertInto("users")
                .columns("id", "name")
                .values("1", ":name")
                .values("2", ":name2")
                .build();

        // then
        assertEquals("INSERT INTO users (id, name) VALUES (1, :name), (2, :name2)", insert);
    }
}