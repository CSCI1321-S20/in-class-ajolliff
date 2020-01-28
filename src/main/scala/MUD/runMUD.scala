package MUD

object Main {
    def main(args: Array[String]): Unit = {

        //setup

        val readLine = readLine() //does this go here or in player?
            while (readLine != exit) {Player.processCommand}
    }
    
    
}