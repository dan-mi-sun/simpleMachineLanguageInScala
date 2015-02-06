package sml

class Translator(fileName: String) {
  private final val ADD = "add"
  private final val LIN = "lin"
  private final val DIV = "div"
  private final val MUL = "mul"
  private final val SUB = "sub"
  private final val OUT = "out"

  def readAndTranslate(m: Machine): Machine = {
    var labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      var fields = line.split(" ")
      if (fields.length > 0) {
        labels.add(fields(0))
        fields(1) match {
          case ADD =>
            program = program :+ AddInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case LIN =>
            program = program :+ LinInstruction(fields(0), fields(2).toInt, fields(3).toInt)
          case DIV =>
            program = program :+ DivInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case MUL =>
            program = program :+ MulInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case SUB =>
            program = program :+ SubInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case OUT =>
            program = program :+ OutInstruction(fields(0), fields(2).toInt)
          case x =>
            println(s"Unknown instruction $x")
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
