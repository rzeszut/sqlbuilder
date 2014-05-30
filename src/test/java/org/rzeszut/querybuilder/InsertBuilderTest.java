package org.rzeszut.querybuilder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.rzeszut.querybuilder.InsertBuilder.insert;

public class InsertBuilderTest {

    @Test
    public void testSimpleInsert() {
        // when
        final String insert = insert()
                .into("users")
                .values("1", ":name")
                .build();

        // then
        assertEquals("INSERT INTO users VALUES (1, :name)", insert);
    }

    @Test
    public void testInsertWithColumns() {
        // when
        final String insert = insert()
                .into("users")
                .columns("id", "name")
                .values("1", ":name")
                .build();

        // then
        assertEquals("INSERT INTO users (id, name) VALUES (1, :name)", insert);
    }

    @Test
    public void testInsertWithMultipleValues() {
        // when
        final String insert = insert()
                .into("users")
                .columns("id", "name")
                .values("1", ":name")
                .values("2", ":name2")
                .build();

        // then
        assertEquals("INSERT INTO users (id, name) VALUES (1, :name), (2, :name2)", insert);
    }
}