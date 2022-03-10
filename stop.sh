#!/bin/bash
cd /webapps/chess
kill -15 $(cat chess.pid)
rm chess.pid
