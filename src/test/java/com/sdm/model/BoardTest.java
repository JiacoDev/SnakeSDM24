package com.sdm.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;
    @BeforeEach
    void setUp() {
        board = new Board(10,10);
    }

    @Test
    void testGetHeight() {
        Assertions.assertEquals(10, board.width());
    }

    @Test
    void testGetWidth() {
        Assertions.assertEquals(10, board.height());
    }
}