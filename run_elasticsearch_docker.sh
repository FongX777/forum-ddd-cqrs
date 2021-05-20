#!/usr/bin/env bash

# https://www.elastic.co/guide/en/elasticsearch/reference/7.4/docker.html
docker run -d --name elasticsearch \
  -p 9200:9200 \
  -p 9300:9300 \
  -e "discovery.type=single-node" \
  docker.elastic.co/elasticsearch/elasticsearch:7.4.2

# Then open http://localhost:9200