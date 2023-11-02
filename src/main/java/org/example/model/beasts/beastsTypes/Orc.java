package org.example.model.beasts.beastsTypes;

import org.example.model.Character;
import org.example.model.beasts.Beast;
import org.example.view.GameView;

public class Orc extends Beast {
    public Orc(String name, int life, int armor) {

        super(name, life, armor);

    }

    GameView gameView = new GameView();

    @Override
    public int toAttack(Character enemy) {

        double weakening = 0.10;

        int damage = super.toAttack(enemy);

        gameView.printSlowly("¡La potencia ofensiva del ataque debilita un 10% la armadura de " + enemy.getName() + " debido a la fuerza desmesurada de " + this.getName() + "!", 50);
        int originalArmor = enemy.getArmor();
        int weakenedArmor = (int) Math.ceil(originalArmor - (originalArmor * weakening));
        enemy.setArmor(weakenedArmor);

        enemy.toBeAttacked(damage);

        enemy.setArmor(originalArmor);

        return 0;
    }
}
