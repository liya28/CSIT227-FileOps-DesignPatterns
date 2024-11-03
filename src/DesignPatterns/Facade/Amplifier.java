package DesignPatterns.Facade;

public class Amplifier {
    public void on() {
        System.out.println("Amplifier is on");
    }

    public void off() {
        System.out.println("Amplifier is off");
    }
}

class DVDPlayer {
    public void play() {
        System.out.println("DVD Player is playing");
    }

    public void stop() {
        System.out.println("DVD Player stopped");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is on");
    }

    public void off() {
        System.out.println("Projector is off");
    }
}

// Facade class
class HomeTheaterFacade {
    private Amplifier amplifier;
    private DVDPlayer dvdPlayer;
    private Projector projector;

    public HomeTheaterFacade(Amplifier amplifier, DVDPlayer dvdPlayer, Projector projector) {
        this.amplifier = amplifier;
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
    }

    public void watchMovie() {
        amplifier.on();
        projector.on();
        dvdPlayer.play();
    }

    public void endMovie() {
        amplifier.off();
        projector.off();
        dvdPlayer.stop();
    }
}

class HomeTheater {
    public static void main(String[] args) {
        Amplifier a = new Amplifier();
        DVDPlayer d = new DVDPlayer();
        Projector p = new Projector();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(a, d, p);

        homeTheater.watchMovie();
        homeTheater.endMovie();
    }
}
