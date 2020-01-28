package MUD

class Player() {

    def processCommand(command: String): Unit = {
        val readLine = readLine() //does this go here or in main?
        
        if (readLine == help) {println(""" 
            can make a multiline string
            """)}
        else if (readLine == look) {println(Room.description())}
        else if (readLine == (inv || inventory)) {Player.inventoryListing}
        else if (readLine == get_) {Player.addToInventory}
        else if (readLine == drop_) {Player.getFromInventory}
        else if (readLine == n || e || s || w || u || d || north || east || south || west || up || down) { 
            x match {
                case (n || north) => north
                case (s || south) => south
                case (e || east) => east
                case (w || west) => west
                case (u || up) => up
                case (d || down) => down
                case(_) => "That is an invalid input."
                Player.move(x)
                println(Room.description)
            }
            
        }  
    }                //Parse and act on a command
    
    
    def getFromInventory(itemName: String): Option[Item] = {???}   //Pull an item out of the inventory (if it exists) and return it.
    def addToInventory(item: Item): Unit = {???}                   //Add the given item to inventory.
    def inventoryListing(): String = {???}                         //Build a String with the contents of the inventory for printing.
    def move(dir: String): Unit = {???}                            //Move the player in a particular direction if possible.

    
}