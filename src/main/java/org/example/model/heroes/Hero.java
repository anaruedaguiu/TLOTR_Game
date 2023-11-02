package org.example.model.heroes;

import org.example.model.Character;
import org.example.view.GameView;

public class Hero extends Character {
    int dice1;
    int dice2;

    public Hero(String name, int life, int armor) {
        super(name, life, armor);
    }

    GameView gameView = new GameView();

    @Override
    public int toAttack(Character enemy) {
        gameView.printSlowly("➤ " + super.getName() + " está atacando a " + enemy.getName(), 50);

        dice1 = (int) (Math.random() * 101);
        gameView.printSlowly(" Primer dado: " + dice1, 50);
        dice2 = (int) (Math.random() * 101);
        gameView.printSlowly(" Segundo dado: " +dice2, 50);

        int damage = Math.max(dice1, dice2);
        gameView.printSlowly(super.getName() + " saca " + damage + " puntos", 50);

        return damage;
    }
}
