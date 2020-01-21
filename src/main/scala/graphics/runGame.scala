package graphics

object Game {
    def main(args: Array[String]): Unit = {
        //println("Running game")

        val e1 = new Entity(0,0)
        val e2 = new Entity(5,3)

        println(e1.Intersects(e2))
    }
}