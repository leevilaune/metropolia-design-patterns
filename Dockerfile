FROM ubuntu:latest
LABEL authors="leevilaune"

ENTRYPOINT ["top", "-b"]