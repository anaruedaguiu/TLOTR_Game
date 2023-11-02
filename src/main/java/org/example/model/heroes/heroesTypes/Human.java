package org.example.model.heroes.heroesTypes;

import org.example.model.Character;
import org.example.model.heroes.Hero;

public class Human extends Hero {

    public Human(String name, int life, int armor) {

        super(name, life, armor);

    }

    @Override
    public int toAttack(Character enemy) {

        int damage = super.toAttack(enemy);

        enemy.toBeAttacked(damage);

        return 0;
    }
}
