package MUD

import scala.io.StdIn._

object Main {
    def main(args: Array[String]): Unit = {

        println("Welcome!")
        Player = new Player //what do here

        var readLine = readLine.toLowerCase
            while (readLine != exit) {Player.processCommand}
    }
    
    
}