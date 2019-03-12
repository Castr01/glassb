package cGlassblower.node;

import cGlassblower.data.Data;
import cGlassblower.data.UserInterfaceData;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.Bank;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.script.task.Task;
import org.rspeer.ui.Log;


public class Banking extends Task {

    @Override
    public boolean validate() {
        return UserInterfaceData.ITEM_TO_BLOW_INDEX != -1 && !Inventory.contains("Molten glass") && Data.moltenGlassCount >= 1;
    }

    @Override
    public int execute() {

     if(!Bank.isOpen()){

         Bank.open();

         Time.sleepUntil(Bank::isOpen, 3000);

     }else{

         if(Bank.isOpen()){

             Time.sleep(250,500);

             if(!Inventory.contains("Molten glass") && Inventory.contains(item -> item.getName().equals("Empty fishbowl") || item.getName().equals("Lantern lens") || item.getName().contains("orb"))){

                 Log.info("Depositing all except Glassblowing pipe");
                 Bank.depositAllExcept("Glassblowing pipe");

                 Time.sleepUntil(()-> !Inventory.contains(item -> item.getName().equals("Empty fishbowl") || item.getName().equals("Lantern lens") || item.getName().contains("orb")), 3000);

             }else{

                 Data.moltenGlassCount = Bank.getCount("Molten glass");
                 Log.fine("Molten glass count: "+Data.moltenGlassCount);

                 if(!Inventory.contains("Molten glass") && !Inventory.contains(item -> item.getName().equals("Empty fishbowl") || item.getName().equals("Lantern lens") || item.getName().contains("orb")) && Data.moltenGlassCount > 0){

                     Time.sleep(250,500);

                     Log.info("Withdrawing Molten glass");
                     Bank.withdraw("Molten glass", 27);

                     Time.sleepUntil(()->Inventory.contains("Molten glass"), 3000);

                 }else{

                     if(Bank.isOpen() && Data.moltenGlassCount == 0){

                         Log.severe("Out of Molten glass");
                         return -1;

                     }

                 }

             }

         }

     }
        return 75;
    }
}
