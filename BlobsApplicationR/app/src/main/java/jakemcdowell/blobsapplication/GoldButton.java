package jakemcdowell.blobsapplication;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.ScheduledFuture;

import jakemcdowell.blobsapplication.bugs.MovingBug;
import jakemcdowell.blobsapplication.bugs.TeleportingBug;

import static jakemcdowell.blobsapplication.bugs.Bug.scheduler;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by kevin on 8/9/17.
 */

public class GoldButton {

    private View button;
    private int goldValue;
    private int goldEarnedInLevel;
    private ScheduledFuture beeperHandle = null;


    public GoldButton(View view) {
        button = view;
        setNewGoldValueForButton();
        getButton().setText("" + goldValue);
    }

    public void startRandomGoldMove() {
        if (beeperHandle == null) {
            final Runnable beeper = new Beeper();
            this.beeperHandle = scheduler.scheduleAtFixedRate(beeper, 0, Constants.MOVING_BUG_SPEED, MILLISECONDS);
        }
    }

    private class Beeper implements Runnable {
        public void run() {
            if (Math.random() * 100 + 1 <= Constants.chanceOfSeeingGold) {
                setNewGoldValueForButton();
                moveOnScreen();
            } else {
                moveOffScreen();
            }
            try {
                Thread.sleep(3000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void stopRandomGoldMove() {
        beeperHandle.cancel(true);
        beeperHandle = null;
    }

    public int getMinNum() {
        return PlayerData.currentLevel / 2 + 1;
    }

    public int getMaxNum() {
        return (int) (PlayerData.currentLevel * 1.5);
    }

    public void setNewGoldValueForButton() {
        goldValue = (int) ((Math.random() * (getMaxNum() - getMinNum())) + getMinNum());
    }

    public void moveOnScreen() {
        button.setX((int)(Math.random() * 575) + 50);
        button.setY((int)(Math.random() * 1200) + 220);
    }

    public void moveOffScreen() {
        button.setY(10000);
    }

    public void click() {
        moveOffScreen();
        goldEarnedInLevel += goldValue;
        setNewGoldValueForButton();
        getButton().setText("" + goldValue);
    }

    public Button getButton() {
        return (Button) button;
    }

    public String getGoldEarnedInLevelString() {
        if (goldEarnedInLevel > 0) {
            return " + " + goldEarnedInLevel;
        } else {
            return "";
        }
    }

    public int getGoldEarnedInLevel() {
        return goldEarnedInLevel;
    }

    public void resetButton() {
        setNewGoldValueForButton();
        goldEarnedInLevel = 0;
    }
}
