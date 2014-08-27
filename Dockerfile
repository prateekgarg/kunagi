FROM consol/tomcat-8.0

MAINTAINER Friedrich Große <friedrich.grosse@gmail.com>
ENV DEPLOY_DIR /kunagi

RUN apt-get update

# Install build dependencies
RUN apt-get install -y ant git unzip bzip2 && apt-get clean

# Build ilarkesto
WORKDIR /build/ilarkesto
RUN git clone https://github.com/Kunagi/ilarkesto.git .
RUN ./update-libs.bsh
RUN ant package

# Build kunagi
WORKDIR /build/kunagi
ADD . /build/kunagi 
RUN ant webapp

