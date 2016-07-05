package test;
import java.util.Iterator;
import java.util.List;


import bean.Guitar;
import bean.GuitarSpec;
import model.InventoryModel;

public class FindGuitarTester {

  public static void main(String[] args) {
    // Set up Rick's guitar inventory
    InventoryModel inventory = new InventoryModel();
    initializeInventory(inventory);

    GuitarSpec whatErinLikes = 
      new GuitarSpec("1", "1", 
                     "1", "1", "1");
    List matchingGuitars = inventory.search(whatErinLikes);
    if (!matchingGuitars.isEmpty()) {
      System.out.println("Erin, you might like these guitars:");
      for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
        Guitar guitar = (Guitar)i.next();
        GuitarSpec spec = guitar.getSpec();
        System.out.println("  We have a " +
          spec.getBuilder() + " " + spec.getModel() + " " +
          spec.getType() + " guitar:\n     " +
          spec.getBackWood() + " back and sides,\n     " +
          spec.getTopWood() + " top.\n  You can have it for only $" +
          guitar.getPrice() + "!\n  ----");
      }
    } else {
      System.out.println("Sorry, Erin, we have nothing for you.");
    }
  }

  private static void initializeInventory(InventoryModel inventory) {

    inventory.addGuitar("1", 1, "1", 
                        "1", "1",
                        "1", "1");

  }
}
