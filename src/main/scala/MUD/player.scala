package MUD

class Player() {

    def processCommand(readLine: String): Unit = {
        if (readLine == help) {println(""" 
            Possible commands:
            look - reprint the room description, exits, and items
            inv/inventory - open your inventory
            get item - pick up an item in the room you are in
            drop item - remove an item from your inventory
            n/north - move north (or s/south, e/east, w/west, u/up, d/down)
            exit - leave the game
            """)}
        else if (readLine == look) {println(Room.description())}
        else if (readLine == (inv || inventory)) {Player.inventoryListing}
        else if (readLine == get _) {Player.addToInventory} //syntax?
        else if (readLine == drop _) {Player.getFromInventory}
        else if (readLine == n || e || s || w || u || d || north || east || south || west || up || down) { 
            dir match {
                case (n || north) => north
                case (s || south) => south
                case (e || east) => east
                case (w || west) => west
                case (u || up) => up
                case (d || down) => down
                case(_) => println("That is an invalid input.")
                Player.move(dir) //how to make a player move in the specified direction?
            }
            
        }
        else {println("Sorry, I don't know what you're asking me to do. If you need help, type 'help'")}  
    }
    
    private var Inv = List(0)(0)

    def getFromInventory(itemName: String): Option[Item] = {
        Inv.filter(itemName) 
        Room.dropItem   //how will it reappear in the room?
    }
    def addToInventory(item: Item): Unit = {
        Room.getItem
        item ::= Inv    //does this work? do I need something else?
    }
    def inventoryListing(): String = {
        println("Inventory:")
        if (Inv._0 == _) {println(" " + Inv._0.Item.name + " - " + Inv._0.Item.desc)} //syntax? how to do more than one item?
        else println("You have no items in your inventory.")
    }
    def move(dir: String): Unit = {
        dir match {
            case (north) => Room.getExit._0
            case (south) => Room.getExit._1
            case (east) => Room.getExit._2
            case (west) => Room.getExit._3
            case (up) => Room.getExit._4
            case (down) => Room.getExit._5
        }

        if (Room.getExit == wall) println("You cannot move that direction.")
        else if (Room.getExit == move) 

        println(Room.description) //do I want the class Room desc or object Room desc?
    }                            //don't know whats going on here

    
}