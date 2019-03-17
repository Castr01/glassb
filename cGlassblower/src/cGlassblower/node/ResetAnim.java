package cGlassblower.node;

import cGlassblower.data.Data;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.task.Task;

public class ResetAnim extends Task {

    @Override
    public int execute() {

        Data.lastAnimation = System.currentTimeMillis();

        return 50;
    }

    @Override
    public boolean validate() {
        return Players.getLocal().getAnimation() != -1;
    }
}
