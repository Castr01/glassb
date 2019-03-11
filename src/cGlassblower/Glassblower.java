package cGlassblower;


import cGlassblower.data.Data;
import cGlassblower.gui.UserInterface;
import cGlassblower.node.Banking;
import cGlassblower.node.BlowItem;
import cGlassblower.node.ResetAnim;
import cGlassblower.tracker.Experience;
import org.rspeer.runetek.api.component.tab.Skill;
import org.rspeer.runetek.api.component.tab.Skills;
import org.rspeer.runetek.event.listeners.RenderListener;
import org.rspeer.runetek.event.types.RenderEvent;
import org.rspeer.script.ScriptCategory;
import org.rspeer.script.ScriptMeta;
import org.rspeer.script.task.Task;
import org.rspeer.script.task.TaskScript;

import java.awt.*;

@ScriptMeta(developer = "Cas",name = "cGlassblower",category = ScriptCategory.CRAFTING,version = 0.1,desc = "Blows molten glass")
public class Glassblower extends TaskScript implements RenderListener {

    private static final Task[] TASKS = {new ResetAnim(), new BlowItem(), new Banking()};

    Experience tracker = new Experience();

    @Override
    public void onStart() {

        UserInterface userInterface = new UserInterface();
        userInterface.frmc.setVisible(true);

        Data.startTime = System.currentTimeMillis();
        Data.start_level = Skills.getLevel(Skill.CRAFTING);
        Data.start_xp = Skills.getExperience(Skill.CRAFTING);

        submit(TASKS);

    }

    @Override
    public void notify(RenderEvent renderEvent) {

        final long runTime = System.currentTimeMillis() - Data.startTime;
        int xp_now = Skills.getExperience(Skill.CRAFTING);
        int xp_gained = xp_now - Data.start_xp;

        Graphics g = renderEvent.getSource();

        Font font = new Font("Consolas",0,15);
        Font titleFont = new Font("Consolas",1,12);

        g.setFont(titleFont);
        g.drawString("Cas - Glass blower", 15,57);

        g.setFont(font);
        g.drawString("Runtime: "+ Data.formatTime(runTime),15,77);
        g.drawString("Levels gained: "+tracker.gainedLvl(Skill.CRAFTING,Data.start_level), 15, 97);
        g.drawString("XP Gained: "+xp_gained + " ("+tracker.xpHour(Skill.CRAFTING, Data.start_xp, runTime)+" P/H)",15,117);

    }
}
