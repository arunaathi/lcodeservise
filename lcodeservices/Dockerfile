# Using UBI 8 base image


FROM artifactory.global.standardchartered.com/ubi8/ubi-minimal:8.4-208
WORKDIR /var/tmp
ENV JAVA_MAJOR_VERSION=8 \
JAVA_HOME=/usr/lib/jvm/jre-8
RUN microdnf --nodocs install java-11-openjdk-headless \
&& microdnf clean all

USER 19901
VOLUME /tmp

WORKDIR /credapp/
COPY ./target /credapp/ 
EXPOSE 9002
ENTRYPOINT ["/usr/bin/java","-Xmx1024m","-jar","/credapp/lcodeservice.jar"]