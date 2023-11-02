package org.example.model.beasts.beastsTypes;

import org.example.model.Character;
import org.example.model.beasts.Beast;

public class Goblin extends Beast {
    public Goblin(String name, int life, int armor) {

        super(name, life, armor);

    }

    @Override
    public int toAttack(Character enemy) {

        int damage = super.toAttack(enemy);

        enemy.toBeAttacked(damage);

        return 0;
    }
}
