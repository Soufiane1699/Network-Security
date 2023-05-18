#!/bin/bash
apt-get update
apt-get install -y dnsmasq
echo "address=/example.com/172.20.0.2" >> /etc/dnsmasq.conf
dnsmasq --no-daemon --log-queries