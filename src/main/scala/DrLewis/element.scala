package DrLewis

import scalafx.scene.canvas.GraphicsContext

trait Element {
    def cells: Seq[GridCell]

}