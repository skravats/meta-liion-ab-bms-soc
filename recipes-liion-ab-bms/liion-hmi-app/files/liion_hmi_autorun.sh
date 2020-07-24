#!/bin/bash
# just direct debug output from within the code to a debug log file for now
date > /tmp/liion_hmi_debug.txt
./home/liion/liion_hmi >> /tmp/liion_hmi_debug.txt

