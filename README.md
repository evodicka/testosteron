Testosteron
======
A simple java app to test-check-debug your containerized environment.

Features:
* Website exposed on port 8080 showing you:
 * Memory: used, total, max
 * Environment: env vars, java system properties
 * Output of linux commands: df -h free
 * Network info: ip, hostname
 * Request headers: to check for load balancer forward headers, etc.
* Configurable Java Options: for mem/heap/... adjustment

Usage like:

    docker run --rm -d -p 8080:8080 -e JOPTS=-Xmx1g thomaskuh/testosteron
