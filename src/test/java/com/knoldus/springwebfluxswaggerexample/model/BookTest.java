package com.knoldus.springwebfluxswaggerexample.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BookTest {
    /**
     * Method under test: {@link Book#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Book("42", "Name", "Isbn")).canEqual("Other"));
    }

    /**
     * Method under test: {@link Book#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Book book = new Book("42", "Name", "Isbn");
        assertTrue(book.canEqual(new Book("42", "Name", "Isbn")));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Book#Book()}
     *   <li>{@link Book#setId(String)}
     *   <li>{@link Book#getId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Book actualBook = new Book();
        actualBook.setId("42");
        assertEquals("42", actualBook.getId());
    }

    /**
     * Method under test: {@link Book#Book(String, String, String)}
     */
    @Test
    void testConstructor2() {
        Book actualBook = new Book("42", "Name", "Isbn");

        assertEquals("42", actualBook.getId());
        assertEquals("Name", actualBook.getName());
        assertEquals("Isbn", actualBook.getIsbn());
    }

    /**
     * Method under test: {@link Book#Book(String, String, String)}
     */
    @Test
    void testConstructor3() {
        assertThrows(IllegalArgumentException.class, () -> new Book("foo", null, null));

    }

    /**
     * Method under test: {@link Book#Book(String, String, String)}
     */
    @Test
    void testConstructor4() {
        assertThrows(IllegalArgumentException.class, () -> new Book("42", "Name", null));

    }

    /**
     * Method under test: {@link Book#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new Book("49", "Geeta", "Dx4564RP56"), null);
        assertNotEquals(new Book("42", "Upanishads", "UP34D657"), "Different type to Book");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Book#equals(Object)}
     *   <li>{@link Book#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        Book book = new Book("46", "Geeta", "Ax4564RP56");
        assertEquals(book, book);
        int expectedHashCodeResult = book.hashCode();
        assertEquals(expectedHashCodeResult, book.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Book#equals(Object)}
     *   <li>{@link Book#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Book book = new Book("47", "BhagwatKatha", "D454RP56");
        Book book1 = new Book("47", "BhagwatKatha", "D454RP56");

        assertEquals(book, book1);
        int expectedHashCodeResult = book.hashCode();
        assertEquals(expectedHashCodeResult, book1.hashCode());
    }

    /**
     * Method under test: {@link Book#equals(Object)}
     */
    @Test
    void testEquals4() {
        Book book = new Book("Name", "Name", "Isbn");
        assertNotEquals(book, new Book("49", "Geeta", "Dx4564RP56"));
    }

    /**
     * Method under test: {@link Book#equals(Object)}
     */
    @Test
    void testEquals5() {
        Book book = new Book(null, "Name", "Isbn");
        assertNotEquals(book, new Book("42", "Name", "Isbn"));
    }

    /**
     * Method under test: {@link Book#equals(Object)}
     */
    @Test
    void testEquals6() {
        Book book = new Book("42", "42", "Isbn");
        assertNotEquals(book, new Book("42", "Name", "Isbn"));
    }

    /**
     * Method under test: {@link Book#equals(Object)}
     */
    @Test
    void testEquals7() {
        Book book = new Book("42", "Name", "42");
        assertNotEquals(book, new Book("42", "Name", "Isbn"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Book#equals(Object)}
     *   <li>{@link Book#hashCode()}
     * </ul>
     */
    @Test
    void testEquals8() {
        Book book = new Book(null, "Name", "Isbn");
        Book book1 = new Book(null, "Name", "Isbn");

        assertEquals(book, book1);
        int expectedHashCodeResult = book.hashCode();
        assertEquals(expectedHashCodeResult, book1.hashCode());
    }

    /**
     * Method under test: {@link Book#equals(Object)}
     */
    @Test
    void testEquals9() {
        Book book = new Book(null, "Name", "Isbn");
        assertThrows(IllegalStateException.class, () -> book.equals(new Book()));
    }

    /**
     * Method under test: {@link Book#equals(Object)}
     */
    @Test
    void testEquals10() {
        Book book = new Book();
        assertThrows(IllegalStateException.class, () -> book.equals(new Book(null, "Name", "Isbn")));
    }

    /**
     * Method under test: {@link Book#getIsbn()}
     */
    @Test
    void testGetIsbn() {
        assertEquals("Isbn", (new Book("42", "Name", "Isbn")).getIsbn());
        assertThrows(IllegalStateException.class, () -> (new Book()).getIsbn());
    }

    /**
     * Method under test: {@link Book#getName()}
     */
    @Test
    void testGetName() {
        assertEquals("Name", (new Book("42", "Name", "Isbn")).getName());
        assertThrows(IllegalStateException.class, () -> (new Book()).getName());
    }

    /**
     * Method under test: {@link Book#setIsbn(String)}
     */
    @Test
    void testSetIsbn() {
        Book book = new Book("42", "Name", "Isbn");
        book.setIsbn("Isbn");
        assertEquals("Isbn", book.getIsbn());
    }

    /**
     * Method under test: {@link Book#setIsbn(String)}
     */
    @Test
    void testSetIsbn2() {
        assertThrows(IllegalArgumentException.class, () -> (new Book("42", "Name", "Isbn")).setIsbn(null));
    }

    /**
     * Method under test: {@link Book#setName(String)}
     */
    @Test
    void testSetName() {
        Book book = new Book("42", "Name", "Isbn");
        book.setName("Name");
        assertEquals("Name", book.getName());
    }

    /**
     * Method under test: {@link Book#setName(String)}
     */
    @Test
    void testSetName2() {
        assertThrows(IllegalArgumentException.class, () -> (new Book("42", "Name", "Isbn")).setName(null));
    }
}

