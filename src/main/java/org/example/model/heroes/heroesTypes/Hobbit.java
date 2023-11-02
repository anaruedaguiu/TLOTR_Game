package org.example.model.heroes.heroesTypes;

import org.example.model.Character;
import org.example.model.beasts.beastsTypes.Goblin;
import org.example.model.heroes.Hero;
import org.example.view.GameView;

public class Hobbit extends Hero {

    public Hobbit(String name, int life, int armor) {
        super(name, life, armor);
    }

    GameView gameView = new GameView();

    @Override
    public int toAttack(Character enemy) {

        int damage = 0;
        int offensivePower = 5;
        int finalDamage = 0;

        if(enemy instanceof Goblin) {

            damage = super.toAttack(enemy);

            gameView.printSlowly("¡La potencia ofensiva del ataque se ha visto perjudicada debido al miedo que sienten los Hobbits por los Trasgos!", 50);
            finalDamage = damage - offensivePower;
            gameView.printSlowly("Ahora el ataque es de: \n" + damage + " + ¡¡ -5 puntos !! = " + finalDamage, 50);

            enemy.toBeAttacked(finalDamage);

        } else {
            damage = super.toAttack(enemy);
            enemy.toBeAttacked(damage);
        }

        return 0;
    }
}
