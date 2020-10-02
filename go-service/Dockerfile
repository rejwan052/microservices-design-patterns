FROM golang:1.15.2-alpine3.12
ARG PORT
ARG ENV
RUN mkdir /app
ADD . /app
WORKDIR /app
## Add this go mod download command to pull in any dependencies
RUN go mod download
## Our project will now successfully build with the necessary go libraries included.
RUN go build -o main .
ENV ENVIRONMENT=$ENV
EXPOSE $PORT
ENV JAVA_CMD="/app/main"
## Our start command which kicks off
## our newly created binary executable
CMD ["/app/main"]