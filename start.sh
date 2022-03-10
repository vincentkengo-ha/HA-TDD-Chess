#!/bin/bash
cd /webapps/chess
java -jar chess-0.0.1-SNAPSHOT.jar > chess.log &

echo $! > chess.pid
