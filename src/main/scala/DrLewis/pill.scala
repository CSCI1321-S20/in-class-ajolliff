package DrLewis

import scalafx.scene.canvas.GraphicsContext

class Pill(halves: Seq[PillHalf]) extends Element {
    def cells: Seq[GridCell] = halves
    def move(dx:Int, dy:Int, isClear: (Int,Int) => Boolean): Pill = {  //in my game, should be doubles not ints
        if(halves.forall(_.moveAllowed(dx,dy,isClear))){
            new Pill(halves.map(_.move(dx,dy)))
        } else this
        
    }

}