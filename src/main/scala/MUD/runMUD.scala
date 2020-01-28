package MUD

object Main {
    def main(args: Array[String]): Unit = {

        //setup

        val readLine = readLine() //does this go here or in player?
            while (readLine != exit) {Player.processCommand}
    }
            //north, south, east, west, up, down - for movement (it is nice if you allow single letter abbreviations), then print room description
            //look - reprints the description of the current room
            //inv/inventory - list the contents of your inventory
            //get item - to get an item from the room and add it to your inventory
            //drop item - to drop an item from your inventory into the room.
            //help - print the available commands and what they do
    
    
}