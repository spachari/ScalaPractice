case class idAddress (customeraccountid : Long,
                      old_primaryemailaddress : String)

val sampleAddress = new idAddress(35973, "srinivaspach@gmail.com")


idAddress(35973, "srinivaspach@gmail.com") :: Nil