package com.sdm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FruitTest {

    @Test
    void testGetPosX() {
        Fruit fruit = new Fruit(100,100);
        Assertions.assertEquals(100,fruit.getPosX());
    }

    @Test
    void testSetPosX() {
        Fruit fruit = new Fruit(100,100);
        fruit.setPosX(50);
        Assertions.assertEquals(50,fruit.getPosX());
    }

    @Test
    void testGetPosY() {
        Fruit fruit = new Fruit(100,100);
        Assertions.assertEquals(100,fruit.getPosY());
    }

    @Test
    void testSetPosY() {
        Fruit fruit = new Fruit(100,100);
        fruit.setPosY(50);
        Assertions.assertEquals(50,fruit.getPosY());

    }
}