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
          val rtimeUniverse = scala.reflect.runtime.universe
          val rtimeMirror = rtimeUniverse.runtimeMirror(getClass.getClassLoader)
          val clSymbol = rtimeMirror.classSymbol(instructionClass)
          val clMirror = rtimeMirror.reflectClass(clSymbol)
          /* TODO: continue to use http://docs.scala-lang.org/overviews/reflection/overview.html */
          /* run through rest of relection */
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
