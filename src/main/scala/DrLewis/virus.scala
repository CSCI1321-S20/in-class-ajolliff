package DrLewis

import scalafx.scene.canvas.GraphicsContext

class Virus(val x:Int, val y:Int, val color:ColorOption.Value) extends GridCell with Element {
    def cells: Seq[GridCell] = Seq(this)

}