package MUD

class Player(private var position:Room) {

    def processCommand(comm: String): Unit = {
        if (comm == "help") {println(""" 
            Possible commands:
            look - reprint the room description, exits, and items
            inv/inventory - open your inventory
            get item - pick up an item in the room you are in
            drop item - remove an item from your inventory
            n/north - move north (or s/south, e/east, w/west, u/up, d/down)
            exit - leave the game
            """)}
        else if (comm == "look") {println(position.description)}
        else if (comm == "inv" || comm == "inventory") {inventoryListing}
        // else if (comm.startsWith("get")) {addToInventory(item)} 
        // else if (comm.startsWith("drop")) {getFromInventory(itemName)}  
    //     else if (comm == "n" || comm == "e" || comm == "s" || comm == "w" || comm == "u" || comm == "d" || comm == "north" || comm == "east" || comm == "south" || comm == "west" || comm == "up" || comm == "down") { 
    //         comm match {
    //             case ("n") => var dir = 0
    //             case ("north") => var dir = 0
    //             case ("s") => var dir = 1
    //             case ("south") => var dir = 1
    //             case ("e") => var dir = 2
    //             case ("east") => var dir = 2
    //             case ("w") => var dir = 3
    //             case ("west") => var dir = 3
    //             case ("u") => var dir = 4
    //             case ("up") => var dir = 4
    //             case ("d") => var dir = 5
    //             case ("down") => var dir = 5
    //             case(_) => println("You should probably never see this statement.")
    //             move(dir)
    //         }
            
    //     }
    //     else {println("Sorry, I don't know what you're asking me to do. If you need help, type 'help'.")}  
     }
    
    private var Inv = List[Item]()

    // def getFromInventory(itemName: String): Option[Item] = {
    //     Inv.filter(itemName) 
    //     position.dropItem(item)
    // }
    def addToInventory(item: Item): Unit = {
        position.getItem(item.name)
        item :: Inv
    }
    def inventoryListing(): Unit = {
        println("Inventory:")
        if (Inv.isEmpty == false) {
            for (i <- 0 until Inv.length) {
                println(" " + Inv(i).name + " - " + Inv(i).desc)
            }
        }
        else println("You have no items in your inventory.")
    }
    // def move(dir: Int): Unit = {
    //         position.getExit(dir) match {
    //             case None => println("That direction is blocked.")
    //             case Some(position(dir)) => {
    //                 position = dir  
    //                 println(position.description)
    //             }
    //         }
    //     }

    
}