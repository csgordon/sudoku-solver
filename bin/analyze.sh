#!/bin/bash
export PATH=$CHECKERFRAMEWORK/checker/bin:$PATH
$CHECKERFRAMEWORK/checker/bin/javac -Xmaxerrs 999 -processor org.checkerframework.checker.guieffect.GuiEffectChecker src/sudoku/*.java
