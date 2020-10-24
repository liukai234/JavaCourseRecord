#!/bin/bash
printf "Shell Script running...\n" && 
# && 指令执行成功执行下一条 || 执行成功则不执行下一条，直到成功后则不执行后续指令
# printf "$0\n" && # $0 脚本本身名字
# printf "$1\n" && # $1, 2, 3 第n个参数
javac -d out/ src/*.java &&
java -classpath out/ $1
printf "Shell Script end\n"