package sml

class OutInstruction(label: String, op: String, val regout: Int) extends Instruction(label, op) {

  override def execute(m: Machine) {
    println(m.regs(regout))
  }

  override def toString(): String = {
    super.toString + " print value of " + regout
  }
}

object OutInstruction {
  def apply(label: String, regout: Int) =
    new OutInstruction(label, "out", regout)
}
