package com.sdm;

import com.sdm.model.Fruit;
import com.sdm.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FruitTest {

    Fruit fruit;
    @BeforeEach
    void setUp() {
        fruit = new Fruit(new Position(100,100));
    }

    @Test
    void testGetXPosition() {
        Assertions.assertEquals(100,fruit.getPosition().getX());
    }

    @Test
    void testSetPosX() {
        fruit.setPosition(new Position(50,100));
        Assertions.assertEquals(50,fruit.getPosition().getX());
    }

    @Test
    void testGetYPosition() {
        Assertions.assertEquals(100,fruit.getPosition().getY());
    }

    @Test
    void testSetPosY() {
        fruit.setPosition(new Position(100,50));
        Assertions.assertEquals(50,fruit.getPosition().getY());
    }
}