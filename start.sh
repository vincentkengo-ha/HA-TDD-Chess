#!/bin/bash
cd /webapps/chess
if [ ! -f chess.pid ]; then
  java -jar target/chess-0.0.1-SNAPSHOT.jar > chess.log &
  echo $! > chess.pid
fi

