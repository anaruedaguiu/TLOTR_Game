package org.example.controller;

import org.example.model.beasts.Beast;
import org.example.model.heroes.Hero;
import org.example.view.GameView;

import java.util.List;
import java.util.function.Predicate;

public class GameController {

    private List<Hero> heroesArmy;
    private List<Beast> beastsArmy;
    private int turn;
    private String winner;
    private GameView gameView;

    public GameController(List<Hero> heroesArmy, List<Beast> beastsArmy, GameView gameView) {
        this.heroesArmy = heroesArmy;
        this.beastsArmy = beastsArmy;
        this.turn = 1;
        this.winner = null;
        this.gameView = gameView;
    }

    public void play() {
        do {
            gameView.printTurn(turn);
            gameView.printArmyState(turn, heroesArmy, beastsArmy);

            fight();

            if (heroesArmy.isEmpty()) {
                winner = "Bestias";
            } else if (beastsArmy.isEmpty()) {
                winner = "Héroes";
            }

            turn++;

        } while (!heroesArmy.isEmpty() && !beastsArmy.isEmpty());

        gameView.printWinner(winner);
    }

    private void fight() {
        for (int i = 0; i < Math.min(heroesArmy.size(), beastsArmy.size()); i++) {
            Hero hero = heroesArmy.get(i);
            Beast beast = beastsArmy.get(i);

            gameView.printFight(hero, beast);

            hero.toAttack(beast);
            if (beast.isDead()) {
                gameView.printDefeated(beast.getName());
            } else {
                beast.toAttack(hero);
                if (hero.isDead()) {
                    gameView.printDefeated(hero.getName());
                }
            }

            gameView.printCharacterStatus(hero.getName(), hero.getLife(), beast.getName(), beast.getLife());
        }

        Predicate<Hero> heroPredicate = hero -> hero.isDead();
        heroesArmy.removeIf(heroPredicate);
        beastsArmy.removeIf(beast -> beast.isDead());

        gameView.printArmyStatus(heroesArmy.size(), beastsArmy.size());
    }
}
