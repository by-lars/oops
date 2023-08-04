package de.lars.oop;

import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class SpriteSheetAnimation extends Transition {
    private final ImageView view;
    private final int count;
    private final int coloums;
    private final int width;
    private final int height;


    public SpriteSheetAnimation(ImageView view, Duration duration, int count, int coloums, int width, int height) {
        this.view = view;
        this.count = count;
        this.coloums = coloums;
        this.width = width;
        this.height = height;

        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
    }

    @Override
    protected void interpolate(double frac) {
        final int index = Math.min((int)Math.floor(frac * count), count - 1);

        int x = (index  % coloums) * width;
        int y = (index / coloums) * height;

        view.setViewport(new Rectangle2D(x,y,width,height));

    }
}
