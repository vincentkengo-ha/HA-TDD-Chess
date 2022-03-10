#!/bin/bash
kill -15 $(cat chess.pid)
rm chess.pid
