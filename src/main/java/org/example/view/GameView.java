package org.example.view;

import org.example.model.beasts.Beast;
import org.example.model.Character;
import org.example.model.heroes.Hero;

import java.util.List;

public class GameView {

    public void printSlowly(String message, int delay) {
        for (char c : message.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }
    public void printTurn(int turn) {
        printSlowly("   ♦♦♦♦♦ TURNO " + turn + " ♦♦♦♦♦", 20);
    }

    public void printArmyState(int turn, List<Hero> heroesArmy, List<Beast> beastsArmy) {
        System.out.println("··· Estado de los Ejércitos en el turno: " + turn + " ···");
        printSlowly("◇ Ejército de Héroes:", 20);
        printDataArmy(heroesArmy);
        printSlowly("◇ Ejército de Bestias:", 20);
        printDataArmy(beastsArmy);
        System.out.println("···············································");
    }

    public void printFight(Hero hero, Beast beast) {
        printSlowly(" ▷▷ Lucha entre " + hero.getName().toUpperCase()
                + " (Vida=" + hero.getLife()
                + " Armadura=" + hero.getArmor()
                + ") y " + beast.getName().toUpperCase()
                + " (Vida=" + beast.getLife()
                + " Armadura=" + beast.getArmor() + ") ◁◁", 50);
    }

    public void printDefeated(String characterName) {
        printSlowly("¡" + characterName + " ha sido derrotado!", 50);
    }

    public void printWinner(String winner) {
        printSlowly("     ¡¡VICTORIA DE " + winner.toUpperCase() + "!!", 50);
    }

    public void printCharacterStatus(String heroName, int heroLife, String beastName, int beastLife) {
        System.out.println("\n" + "········· Estado de los personajes tras el ataque:");
        printSlowly("Vida de " + heroName + " tras el ataque: " + heroLife, 20);
        printSlowly("Vida de " + beastName + " tras el ataque: " + beastLife + "\n", 20);
    }

    public void printArmyStatus(int heroArmySize, int beastArmySize) {
        System.out.println("········· Estado de los ejércitos tras el ataque:");
        printSlowly("Ejército de Héroes: " + heroArmySize + " guerreros vivos", 20);
        printSlowly("Ejército de Bestias: " + beastArmySize + " guerreros vivos \n", 20);
        System.out.println("------------------------------------------------" + "\n");
    }

    private void printDataArmy(List<? extends Character> army) {
        for (Character character : army) {
            printSlowly(" " + character.getName()
                    + " (Vida = " + character.getLife()
                    + " Armadura = " + character.getArmor() + ")", 50);
        }
    }

    public void printCharacterUnderAttack(Character character, int realDamage) {
        System.out.println(character.getName() + " está siendo atacado y recibe " + realDamage + " puntos de daño.");
        System.out.println("La vida de " + character.getName() + " es ahora de " + character.getLife() + " puntos en total.");
    }

    public void printArmorBlockedAttack(Character character) {
        System.out.println("La armadura de " + character.getName() + " ha protegido su vida del ataque.");
    }

    public void printHeroAttacking(Character hero, Character enemy) {
        System.out.println("➤ " + hero.getName() + " está atacando a " + enemy.getName());
    }

    public void printDiceRoll(int dice1, int dice2) {
        System.out.println(" Primer dado: " + dice1);
        System.out.println(" Segundo dado: " + dice2);
    }

    public void printDamageDealt(String name, int damage) {
        System.out.println(name + " saca " + damage + " puntos");
    }

    public void printStartingGameMessage() {
        printSlowly("➤ ¿Quieres empezar una partida? (Si/No): ", 20);
    }

    public void printChooseHeroesOrBeastsSideMessage() {
        printSlowly("➤ ¿Quieres pertenecer al bando de los heroes o de las bestias? (heroes/bestias): ", 20);
    }

    public void printChooseOppositeSideOrRandomMessage() {
        printSlowly("➤ ¿Quieres elegir el bando contrario o quieres que se genere al azar? (Elegir/Azar): ", 20);
    }

    public void printInvalidAnswerMessage() {
        System.out.println("Opción inválida. Por favor, elige una de las opciones propuestas o ingresa -1 si deseas finalizar la partida:");
    }

    public void printGameOverMessage() {
        printSlowly("Ha elegido finalizar la partida.", 20);
    }

    public void printInvalidOptionMessage() {
        System.out.println("Opción inválida. Por favor, elige un número válido o ingresa -1 para finalizar la selección.");
    }

    public void printChooseYourFighterMessage() {
        printSlowly("➤ Elige a uno de los personajes ingresando el número:", 20);
    }

    public void printChosenMainCharacter(String name) {
        printSlowly("Has elegido como protagonista a: " + name + "\n", 50);
    }

    public void printChosenAlly(String name) {
        printSlowly("Has elegido a " + name + " como aliado." + "\n", 50);
    }

    public void printEndOfAllySelection() {
        System.out.println("--- Fin de la selección de aliados en el bando ---" + "\n");
    }

    public void printCompleteTheArmyOrFinishMessage() {
        printSlowly("➤ Completa el ejército o escribe -1 para terminar la selección: ", 20);
    }

    public void printStartingGameNotice() {
        System.out.println("_________________________________________");
        printSlowly("     ¡¡¡ COMIENZA LA BATALLA !!!", 50);
        System.out.println("_________________________________________" + "\n");
    }
}
