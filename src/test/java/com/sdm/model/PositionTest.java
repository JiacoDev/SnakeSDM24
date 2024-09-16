package com.sdm.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void testEquals() {
        Position p1 = new Position(1,2);
        Position p2 = new Position(1,2);
        boolean result = p1.equals(p2);
        Assertions.assertTrue(result);
    }

    @Test
    void testNotEquals() {
        Position p1 = new Position(1,2);
        Position p2 = new Position(1,1);
        boolean result = p1.equals(p2);
        Assertions.assertFalse(result);
    }
}