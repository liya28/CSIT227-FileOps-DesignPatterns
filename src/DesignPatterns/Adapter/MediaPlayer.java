package DesignPatterns.Adapter;

import javax.print.attribute.standard.Media;

public interface MediaPlayer {
    void play(String audioType, String fileName);
}

class MP3Player implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        System.out.println("Playing MP3 file. Name: " + fileName);
    }
}

class VLCPlayer {
    public void playVLC(String fileName) {
        System.out.println("Playing VLC file. Name: " + fileName);
    }
}

class VLCAdapter implements MediaPlayer {
    private VLCPlayer player;

    public VLCAdapter(VLCPlayer player) {
        this.player = player;
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            player.playVLC(fileName);
        }
    }
}

class AdapterPatternDemo {
    public static void main(String[] args) {
        MediaPlayer mp3Player = new MP3Player();
        mp3Player.play("mp3", "song.mp3");

        VLCPlayer vlcPlayer = new VLCPlayer();
        MediaPlayer vlcAdapter = new VLCAdapter(vlcPlayer);
        vlcAdapter.play("vlc", "movie.vlc");
    }
}
