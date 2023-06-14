package de.uulm.sp.oop.Bookstore;

import java.time.Duration;

public class AudioBook extends Book{

    public AudioBook(String title, int pageCount, String content, Duration duration, String voiceActor) {
        super(title, pageCount, content);

        this.duration = duration;
        this.voiceActor = voiceActor;
    }

    public final Duration duration;
    public final String voiceActor;
}
