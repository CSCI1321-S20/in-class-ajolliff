package DrLewis

import scalafx.scene.canvas.GraphicsContext

class PillHalf(val x:Int, val y:Int, val color:ColorOption.Value) extends GridCell {
    def move(dx:Int, dy:Int): PillHalf = {  //in my game, should be doubles not ints
        new PillHalf(x+dx, y+dy, color)
    }
    def moveAllowed(dx:Int, dy:Int, isClear: (Int,Int) => Boolean): Boolean = {
        isClear()
    }
}