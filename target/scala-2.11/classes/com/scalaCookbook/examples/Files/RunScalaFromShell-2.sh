#!/bin/sh
exec scala "$0" "$@"
!#

import sys.process._

val stdOut = new StringBuilder
val stdErr = new StringBuilder

val status = "ls -al FRED" ! ProcessLogger(stdOut append _, stdErr append _)
println(status)

println("stdOut :" + stdOut)
println("stdErr :" + stdErr)
