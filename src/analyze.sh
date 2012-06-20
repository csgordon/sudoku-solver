#!/bin/bash
export PATH=~/research/guitypes/checker/binary:$PATH
javac -Xmaxerrs 999 -cp /homes/gws/csgordon/research/guitypes/checker/dist/lib/guitypes-`date "+%Y%m%d"`.jar -processor guitypes.checkers.GUIEffectsChecker sudoku/*.java
