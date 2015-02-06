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
  def apply(label: String, result: Int, op1: Int, op2: Int) =
    new OutInstruction(label, "out", result, op1, op2)
}
