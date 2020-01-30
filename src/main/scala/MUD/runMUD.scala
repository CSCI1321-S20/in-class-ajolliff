package MUD

import scala.io.StdIn._

object Main {
    def main(args: Array[String]): Unit = {

        println("Welcome!")
        val character = new Player(Room.world(0))

        println(Room.world(0).description())

        var comm = ""
        while (comm != "exit") {
            comm = readLine.toLowerCase
            character.processCommand(comm)
        }
    }
    
    
}