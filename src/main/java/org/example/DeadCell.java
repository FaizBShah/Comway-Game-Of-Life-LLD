package org.example;

public class DeadCell extends Cell {
    @Override
    public boolean isAlive() {
        return false;
    }
}
