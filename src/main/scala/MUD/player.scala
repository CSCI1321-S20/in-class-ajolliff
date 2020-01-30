package MUD

class Player(private var position:Room) {

    def processCommand(comm: String): Unit = {          //help, look, and inv commands work
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
        else if (comm.startsWith("get")) {addToInventory(item)}         //val item not found
        else if (comm.startsWith("drop")) {getFromInventory(itemName)}  //val itemName not found
        else if (comm == "n" || comm == "e" || comm == "s" || comm == "w" || comm == "u" || comm == "d" || comm == "north" || comm == "east" || comm == "south" || comm == "west" || comm == "up" || comm == "down") { 
            var dir:Int = -1            //added this line to remove an error saying "val dir not found" but I think it's wrong
            comm match {
                case ("n") => dir = 0
                case ("north") => dir = 0
                case ("s") => dir = 1
                case ("south") => dir = 1
                case ("e") => dir = 2
                case ("east") => dir = 2
                case ("w") => dir = 3
                case ("west") => dir = 3
                case ("u") => dir = 4
                case ("up") => dir = 4
                case ("d") => dir = 5
                case ("down") => dir = 5
                case(_) => println("You should probably never see this statement.")
                move(dir)
            }
            
        }
        else {println("Sorry, I don't know what you're asking me to do. If you need help, type 'help'.")}  
     }
    
    private var Inv = List[Item]()

    def getFromInventory(itemName: String): Option[Item] = {
        Inv.filter(itemName)            //requires a boolean
        position.dropItem(item)         //val item not found?
    }
    def addToInventory(item: Item): Unit = {
        position.getItem(item.name)
        item :: Inv
    }
    def inventoryListing(): Unit = {                //this works!
        println("Inventory:")
        if (Inv.isEmpty == false) {
            for (i <- 0 until Inv.length) {
                println(" " + Inv(i).name + " - " + Inv(i).desc)
            }
        }
        else println("You have no items in your inventory.")
    }
    def move(dir: Int): Unit = {
            position.getExit(dir) match {               //val position not found? needs a parameter?
                case None => println("That direction is blocked.")
                case Some(position(dir)) => {
                    position = dir                      //this doesn't do what I think it will do
                    println(position.description)
                }
            }
        }

    
}