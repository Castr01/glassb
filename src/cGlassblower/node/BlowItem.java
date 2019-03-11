package cGlassblower.node;

import cGlassblower.data.Data;
import cGlassblower.data.UserInterfaceData;
import org.rspeer.runetek.adapter.component.Item;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.Production;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.task.Task;
import org.rspeer.ui.Log;

public class BlowItem extends Task {

    @Override
    public boolean validate() {
        return UserInterfaceData.ITEM_TO_BLOW_INDEX != -1 && Inventory.contains("Molten glass") && Inventory.contains("Glassblowing pipe") && System.currentTimeMillis() > Data.lastAnimation + 3500;
    }

    @Override
    public int execute() {

        Item glassPipe = Inventory.getFirst("Glassblowing pipe");
        Item moltenGlass = Inventory.getFirst("Molten glass");

        if(glassPipe != null && glassPipe.interact("Use") && !Inventory.isItemSelected() && !Production.isOpen()){
            Log.info("Interacting with Glassblowing pipe");

            Time.sleepUntil(Inventory::isItemSelected, 1250);

        }else{

            if(Inventory.isItemSelected() && moltenGlass != null && moltenGlass.interact("Use") && !Production.isOpen()){
                Log.info("Interacting with Molten glass");

                Time.sleepUntil(Production::isOpen, 3000);

            }else{

                if(Production.isOpen()){

                    Log.info("Blowing item");
                    Production.initiate(UserInterfaceData.ITEM_TO_BLOW_INDEX);

                    Time.sleepUntil(Players.getLocal()::isAnimating, 3000);
                }

            }

        }

        return 50;
    }
}
