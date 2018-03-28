#!/usr/bin/env bash
CURRENT_DIR=`pwd`
source=$CURRENT_DIR/source
service=$CURRENT_DIR/service
mkdir -p $source
mkdir -p $service/lib
mkdir -p $service/var/log
mkdir -p $service/conf
mkdir -p $service/sbin
mkdir -p $service/web