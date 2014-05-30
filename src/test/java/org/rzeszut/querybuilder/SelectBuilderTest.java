package org.rzeszut.querybuilder;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.rzeszut.querybuilder.Condition.*;
import static org.rzeszut.querybuilder.SelectBuilder.select;

public class SelectBuilderTest {
    @Test
    public void testQuery() {
        // when
        final String query = select()
                .from("users")
                .build();

        // then
        assertEquals("SELECT * FROM users", query);
    }

    @Test
    public void testQuery2() {
        // when
        final String query = select()
                .from("users")
                .where(and(eq("id", ":id"), neq("name", ":name")))
                .build();

        // then
        assertEquals("SELECT * FROM users WHERE (id = :id AND name != :name)", query);
    }

    @Test
    public void testQuery3() {
        // when
        final String query = select()
                .from("users")
                .where(and(eq("id", ":id"), neq("name", ":name"), gt("id", "3")))
                .build();

        // then
        assertEquals("SELECT * FROM users WHERE (id = :id AND name != :name AND id > 3)", query);
    }

    @Test
    public void testQuery4() {
        // when
        final String query = select("u.id", "a.street")
                .from("users", "u")
                .from("addresses", "a")
                .where(and(eq("u.id", ":id"), neq("u.name", ":name"), gt("u.id", "3")))
                .build();

        // then
        assertEquals("SELECT u.id, a.street FROM users u, addresses a WHERE (u.id = :id AND u.name != :name AND u.id > 3)", query);
    }

    @Test
    public void testQuery5() {
        // when
        final String query = select()
                .from("users", "u")
                .innerJoin("addresses", "a")
                .using("id")
                .where(eq("u.name", "'fgsfds'"))
                .groupBy("u.id")
                .orderBy("u.id")
                .build();

        // then
        assertEquals("SELECT * FROM users u INNER JOIN addresses a USING (id) WHERE u.name = 'fgsfds' GROUP BY u.id ORDER BY u.id", query);
    }
}