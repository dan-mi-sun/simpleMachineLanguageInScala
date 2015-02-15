package sml

class BnzInstruction(label: String, op: String, val opreg: Int, val destination: String) extends Instruction(label, op) {

  override def execute(m: Machine) {
    val value = m.regs(opreg)
    val nextStatement = m.labels.labels.indexOf(destination)
    if ( value != 0 ) m.execute(nextStatement)
      /* need to input methods to find the next labelled statement so that it can execute */
      /* found a note in the coursework forums from keith regarding this: */
      /* "So m.execute(0) starts execution of the machine with the pc set to zero. */
      /*  */
      /* m.execute(10) starts execution of the machine with the pc set to zero. Provided that you can find the location of the label, and hence the pc value…." */
  }

  override def toString(): String = {
    super.toString + "if " + opreg + " is not equal to 0 go to " + destination 
  }
}

object OutInstruction {
  def apply(label: String, opreg: Int, destination: String) =
    new Instruction(label, "bnz", opreg, dest)
}
