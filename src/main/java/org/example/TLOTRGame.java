package org.example;

import org.example.controller.GameController;
import org.example.model.beasts.Beast;
import org.example.model.heroes.Hero;
import org.example.model.beasts.beastsTypes.Goblin;
import org.example.model.beasts.beastsTypes.Orc;
import org.example.model.heroes.heroesTypes.Elf;
import org.example.model.heroes.heroesTypes.Hobbit;
import org.example.model.heroes.heroesTypes.Human;
import org.example.view.GameView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TLOTRGame {

    public static void main(String[] args) {

        List<Hero> heroesArmy = new ArrayList<>();
        List<Beast> beastsArmy = new ArrayList<>();
        GameView gameView = new GameView();
        Scanner scanner = new Scanner(System.in);

        gameView.printStartingGameMessage();
        boolean validAnswer = false;
        String answer = "";

        while (!validAnswer) {
            answer = scanner.next();
            if (answer.equalsIgnoreCase("Si") || answer.equalsIgnoreCase("No")) {
                validAnswer = true;
            } else if (answer.equalsIgnoreCase("-1")) {
                gameView.printGameOverMessage();
                break;
            } else {
                gameView.printInvalidAnswerMessage();
            }
        }

        if (answer.equalsIgnoreCase("Si")) {
            gameView.printChooseHeroesOrBeastsSideMessage();
            validAnswer = false;
            String side = "";

            while (!validAnswer) {
                side = scanner.next();
                if (side.equalsIgnoreCase("heroes") || side.equalsIgnoreCase("bestias")) {
                    validAnswer = true;
                } else if (side.equals("-1")) {
                    gameView.printGameOverMessage();
                    break;
                } else {
                    gameView.printInvalidAnswerMessage();
                }
            }

            if (side.equalsIgnoreCase("heroes")) {

                heroesArmy = chooseHeroes(true);

                boolean continuar = true;
                while (continuar) {

                    gameView.printChooseOppositeSideOrRandomMessage();
                    String chooseOppositeSide = scanner.next();

                    if (chooseOppositeSide.equalsIgnoreCase("Elegir")) {

                        beastsArmy = chooseBeasts(false);
                        continuar = false;

                    } else if (chooseOppositeSide.equalsIgnoreCase("Azar")) {

                        ArrayList<Beast> beastsOptions = new ArrayList<>();
                        beastsOptions.add(new Orc("Lurtz", 200, 60));
                        beastsOptions.add(new Orc("Shagrat", 220, 50));
                        beastsOptions.add(new Goblin("Uglúk", 120, 30));
                        beastsOptions.add(new Goblin("Mauhúr", 100, 30));

                        for (int i = 0; i < 3; i++) {
                            int random = new Random().nextInt(beastsOptions.toArray().length);
                            beastsArmy.add(beastsOptions.get(random));
                            beastsOptions.remove(random);
                        }
                        continuar = false;

                    } else {
                        gameView.printInvalidAnswerMessage();
                    }
                }

            } else if (side.equalsIgnoreCase("bestias")) {

                beastsArmy = chooseBeasts(true);

                boolean continuar = true;
                while (continuar) {

                    gameView.printChooseOppositeSideOrRandomMessage();
                    String chooseOppositeSide = scanner.next();

                    if (chooseOppositeSide.equalsIgnoreCase("Elegir")) {

                        heroesArmy = chooseHeroes(false);
                        continuar = false;

                    } else if (chooseOppositeSide.equalsIgnoreCase("Azar")) {

                        ArrayList<Hero> heroesOptions = new ArrayList<>();
                        heroesOptions.add(new Elf("Légolas", 150, 30));
                        heroesOptions.add(new Human("Aragorn", 150, 50));
                        heroesOptions.add(new Human("Boromir", 100, 60));
                        heroesOptions.add(new Human("Gandalf", 300, 30));
                        heroesOptions.add(new Hobbit("Frodo", 20, 10));

                        for (int i = 0; i < 3; i++) {
                            int random = new Random().nextInt(heroesOptions.toArray().length);
                            heroesArmy.add(heroesOptions.get(random));
                            heroesOptions.remove(random);
                        }
                        continuar = false;

                    } else {
                        gameView.printInvalidAnswerMessage();
                    }
                }

            }

            GameController gameController = new GameController(heroesArmy, beastsArmy, gameView);

            gameView.printStartingGameNotice();

            gameController.play();

        } else if (answer.equalsIgnoreCase("No")) {
            gameView.printGameOverMessage();
        }
        scanner.close();
    }

    private static List<Hero> chooseHeroes(boolean isMain) {

        List<Hero> heroesArmy = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        GameView gameView = new GameView();

        ArrayList<Hero> heroesOptions = new ArrayList<>();
        heroesOptions.add(new Elf("Légolas", 150, 30));
        heroesOptions.add(new Human("Aragorn", 150, 50));
        heroesOptions.add(new Human("Boromir", 100, 60));
        heroesOptions.add(new Human("Gandalf", 300, 30));
        heroesOptions.add(new Hobbit("Frodo", 20, 10));

        if (isMain) {
            gameView.printChooseYourFighterMessage();

            for (int i = 0; i < heroesOptions.size(); i++) {
                System.out.println(i + ": " + heroesOptions.get(i));
            }

            int chosenHeroe = scanner.nextInt();
            gameView.printChosenMainCharacter(heroesOptions.get(chosenHeroe).getName());

            heroesArmy.add(heroesOptions.get(chosenHeroe));
            heroesOptions.remove(chosenHeroe);
        }

        gameView.printCompleteTheArmyOrFinishMessage();

        List<Hero> alliedHeroes = new ArrayList<>();
        while (true) {
            for (int i = 0; i < heroesOptions.size(); i++) {
                System.out.println(i + ": " + heroesOptions.get(i));
            }
            int alliedHeroesOption = scanner.nextInt();

            if (alliedHeroesOption == -1) {
                gameView.printEndOfAllySelection();
                break;
            } else if (alliedHeroesOption >= 0 && alliedHeroesOption <= heroesOptions.size()) {
                heroesArmy.add(heroesOptions.get(alliedHeroesOption));
                heroesOptions.remove(alliedHeroesOption);

                gameView.printChosenAlly(heroesArmy.get(heroesArmy.size() - 1).getName());
            } else {
                gameView.printInvalidOptionMessage();
            }
        }

        return heroesArmy;
    }

    private static List<Beast> chooseBeasts(boolean isMain) {

        List<Beast> beastsArmy = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        GameView gameView = new GameView();

        ArrayList<Beast> beastsOptions = new ArrayList<>();
        beastsOptions.add(new Orc("Lurtz", 200, 60));
        beastsOptions.add(new Orc("Shagrat", 220, 50));
        beastsOptions.add(new Goblin("Uglúk", 120, 30));
        beastsOptions.add(new Goblin("Mauhúr", 100, 30));

        gameView.printChooseYourFighterMessage();

        for (int i = 0; i < beastsOptions.size(); i++) {
            System.out.println(i + ": " + beastsOptions.get(i));
        }

        int chosenBeast = scanner.nextInt();
        gameView.printChosenMainCharacter(beastsOptions.get(chosenBeast).getName());

        beastsArmy.add(beastsOptions.get(chosenBeast));

        beastsOptions.remove(chosenBeast);

        gameView.printCompleteTheArmyOrFinishMessage();


        List<Beast> alliedBeasts = new ArrayList<>();
        while (true) {
            for (int i = 0; i < beastsOptions.size(); i++) {
                System.out.println(i + ": " + beastsOptions.get(i));
            }
            int alliedBeastsOption = scanner.nextInt();

            if (alliedBeastsOption == -1) {
                gameView.printEndOfAllySelection();
                break;
            } else if (alliedBeastsOption >= 0 && alliedBeastsOption <= beastsOptions.size()) {
                beastsArmy.add(beastsOptions.get(alliedBeastsOption));
                beastsOptions.remove(alliedBeastsOption);
                gameView.printChosenAlly(beastsArmy.get(beastsArmy.size() - 1).getName());
            } else {
                gameView.printInvalidOptionMessage();
            }
        }

        return beastsArmy;
    }
}