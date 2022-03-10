#!/bin/bash
if [ -f chess.pid ]; then
  kill -15 $(cat chess.pid)
  rm chess.pid
fi
