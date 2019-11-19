#!/bin/bash
docker run --rm -it -p 8080:8080 -e JOPTS=-Xmx1g  thomaskuh/testosteron
