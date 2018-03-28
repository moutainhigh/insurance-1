#!/usr/bin/env bash
if [ "$YUNDIAN_HOME" = "" ]; then
    YUNDIAN_HOME=/yundian
    export YUNDIAN_HOME
fi

if [ "$YUNDIAN_PRODUCT_HOME" = "" ]; then
    YUNDIAN_PRODUCT_HOME=$YUNDIAN_HOME/product
    export YUNDIAN_PRODUCT_HOME
fi

if [ "$YUNDIAN_PLATFORM_HOME" = "" ]; then
    YUNDIAN_PLATFORM_HOME=$YUNDIAN_HOME/platform
    export YUNDIAN_PLATFORM_HOME
fi

ulimit -c unlimited