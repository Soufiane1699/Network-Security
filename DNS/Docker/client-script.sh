#!/bin/bash
apt-get update
apt-get install -y dnsutils
while true; do
    for i in {1..9}; do
        dig @172.20.0.2 example.com >> logs/dns-queries.log
        sleep 30
    done
    dig @172.20.0.2 badrequest.com >> logs/dns-queries.log
    sleep 30
done
