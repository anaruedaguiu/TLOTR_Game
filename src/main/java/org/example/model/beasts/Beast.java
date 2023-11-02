package org.example.model.beasts;

import org.example.model.Character;
import org.example.view.GameView;

public class Beast extends Character {
    int damage;

    public Beast(String name, int life, int armor) {
        super(name, life, armor);
    }

    GameView gameView = new GameView();

    @Override
    public int toAttack(Character enemy) {
        gameView.printSlowly("➤ " + super.getName() + " está atacando a " + enemy.getName(), 50);

        damage = (int) (Math.random() * 91);
        gameView.printSlowly(" Primer dado: " + damage, 50);
        gameView.printSlowly(super.getName() + " saca " + damage + " puntos", 50);

        return damage;
    }
}
