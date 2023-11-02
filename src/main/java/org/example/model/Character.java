package org.example.model;

import org.example.view.GameView;

public class Character implements toAttack {
    private String name;
    private int life;
    private int armor;

    public Character(String name, int life, int armor) {
        this.name = name;
        this.life = life;
        this.armor = armor;
    }

    GameView gameView = new GameView();

    public boolean isDead() {
        return life <= 0;
    }

    public void toBeAttacked(int attack) {
        if(attack > armor) {
            int realDamage = Math.abs(attack - armor);
            life = Math.max(life - realDamage, 0);
            gameView.printSlowly("Y le quita " + realDamage + " puntos de vida a " + this.getName() + ".", 50);
            gameView.printSlowly("Ahora la vida de " + this.getName() + " es de " + life + " puntos en total.", 50);
        } else {
            gameView.printSlowly("La armadura ha soportado el ataque y ha protegido la vida de " + this.getName() + ".", 50);
        }
    }

    public int toAttack(Character enemy) {
        return 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        return name + " (" + getClass().getSimpleName() + ") - Vida: " + life + ", Ataque: " + armor;
    }
}
