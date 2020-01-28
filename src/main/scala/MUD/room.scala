package MUD

class Room(val rmName: String, val desc: String, private var items: List[Item], private val exits: Array[Int]) { //this desc is artistic prose, DO NOT include what items are in it


    def description(): String = {
        println(Room.name)
        println(Room.desc)
        println(Room.items)
        println(Room.exits) //change to read a string from the ints given
    }
    def getExit(dir: Int): Option[Room] = {???}
    
    
    def getItem(itemName: String): Option[Item] = {
       items.find(_.name.toLowerCase == itemName.toLowerCase) match {
            case Some(item) =>                      //if item exists in room
                items = items.filter(_ != item)
                Some(item)
            case None => None                       //if item does not exist in room
       }
    }
    def dropItem(item: Item): Unit = item ::= items
    

}  

object Room {
    val world = readRooms()

    def readRooms(): Array[Room] = {
        val source = scala.io.Source.fromFile("world.txt")
        val lines = source.getLines()
        val r = Array.fill(lines.next.toInt)(readRoom(lines))
        source.close()
    }

    def readRoom(lines: Iterator[String]): Room = {
        val name = lines.next()
        val desc = lines.next()
        val items = List.fill(lines.next.toInt)(Item(lines.next(), lines.next()))
        val exits = lines.next.split(",").map(_.toInt)

        new Room(name, desc, items, exits)
    }
}