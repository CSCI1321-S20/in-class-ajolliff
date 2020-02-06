package DrLewis

import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color
import scalafx.scene.input.KeyEvent
import scalafx.includes._

object main extends JFXApp {
    val grid = new Grid
    val canvas = new Canvas(800,800) 
    val gc = canvas.graphicsContext2D
    val renderer = new Renderer(gc)

    stage = new JFXApp.PrimaryStage {
        title = "Dr. Lewis"
        scene = new Scene(800,800) {
            content = canvas
            renderer.render(grid)
        
            onKeyPressed = (ke: KeyEvent) => {
                ke.code match {
                    case KeyCode.Left => grid.leftPressed()
                    case KeyCode.Right => grid.rightPressed()
                    case KeyCode.Up => grid.upPressed()
                    case _ => 
                }
            }
            onKeyReleased = (ke: KeyEvent) => {
                ke.code match {
                    case KeyCode.Left => grid.leftReleased()
                    case KeyCode.Right => grid.rightReleased()
                    case KeyCode.Up => grid.upReleased()
                    case _ => 
                }
            }

            // var lastTime = -1L
            // val timer = AnimationTimer(time => {
        //         if (lastTime >= 0) {
        //             val delay = (time - lastTime)/1e9
        //             grid.update(delay)
        //         }
        //         lastTime = time
        //     })
        // timer.start()
        
        }
            

    }

}