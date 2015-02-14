package sml

class Translator(fileName: String) {
  /* private final val ADD = "add" */
  /* private final val LIN = "lin" */
  /* private final val DIV = "div" */
  /* private final val MUL = "mul" */
  /* private final val SUB = "sub" */
  /* private final val OUT = "out" */
  import scala.collection.mutable.ListBuffer

  def readAndTranslate(m: Machine): Machine = {
    var labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      var fields = line.split(" ")
      if (fields.length > 0) {
        try {
          val instructionClass = Class.forName("sml." + fields(1).capitalize + "Instruction")
          val runtimeUniverse = scala.reflect.runtime.universe
          val runtimeMirror = runtimeUniverse.runtimeMirror(getClass.getClassLoader)
          val classSymbol = runtimeMirror.classSymbol(instructionClass)
          val classMirror = runtimeMirror.reflectClass(classSymbol)
          }
        }
      }
    }
    new Machine(labels, program)
  }
}

object Translator {
  private val directory: String = "src/"

  def apply(file: String) =
    new Translator(directory + file)
}
