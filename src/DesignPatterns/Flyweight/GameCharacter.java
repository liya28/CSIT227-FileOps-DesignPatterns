package DesignPatterns.Flyweight;

public class GameCharacter {
    private String type;

    public GameCharacter(String type) {
        this.type = type;
    }

    public void display(String playerName) {
        System.out.println("Player: " + playerName + ", Type: " + type);
    }
}

class CharacterFactory {
    private GameCharacter knight;
    private GameCharacter mage;

    public GameCharacter getCharacter(String type) {
        if (type.equals("Knight")) {
            if (knight == null) {
                knight = new GameCharacter("Knight");
            }
            return knight;
        }
        else if (type.equals("Mage")) {
            if (mage == null) {
                mage = new GameCharacter("Mage");
            }
            return mage;
        }
        return null;
    }
}

class Game {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();
        GameCharacter knight = factory.getCharacter("Knight");
        knight.display("Player1");
        GameCharacter mage = factory.getCharacter("Mage");
        mage.display("Player2");

        GameCharacter knight2 = factory.getCharacter("Knight");
        knight2.display("Player3");

        GameCharacter mage2 = factory.getCharacter("Mage");
        mage2.display("Player4");
    }
}
