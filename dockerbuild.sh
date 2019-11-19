#!/bin/bash
# delete existing images
docker rmi -f thomaskuh/testosteron

# rebuild image
docker build -t thomaskuh/testosteron .
