package graphics


//example code
class Entity(val x: Double, val y: Double) {
    //x and y describe middle of the rectangle

    def width: Double = 1 //can change to ask user input for how big
    def height: Double = 1 

    def Intersects(other: Entity): Boolean = {
        val overlapX = (x - other.x).abs < (width + other.width)/2 
        val overlapY = (y - other.y).abs < (height + other.height)/2
        
        overlapX && overlapY
    }

}

