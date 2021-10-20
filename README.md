# Kafka_Quarkus_simple
This is a very simple docker environment focused on first steps on kafka.

The docker file will deploy on your host machine all necessary assets to start with kafka and it features. Those assets are:

|Name                                      |Vendor       |Target                               |
|------------------------------------------|-------------|-------------------------------------|
|[Zookeeper](https://zookeeper.apache.org) |Confluent    |Distributed coordination service     |
|[kafka](https://kafka.apache.org)         |Confluent    |Distributed event streaming platform |
|[Kowl](https://cloudhut.dev)              |Cloudhut     |Apache Kafka Client Web UI           |
|[Prometheus](https://prometheus.io)       |Prometheus   |Monitoring system                    |
|[Grafana](https://grafana.com)            |Grafana Labs |Operational dashboard for monitoring |

In addition an extra maven distribution image with a very simple project (`kafka-simple`) based on [Quarkus-JVM](https://quarkus.io) with a producer & consumer services for a dummy iteration of messages.

# Pre-requisites
You must have installed [Docker](https://docs.docker.com/) in your host. Please check [here for installation instructions](https://docs.docker.com/get-docker)

A recommendation for Docker is to have a client like [Docker Desktop](https://www.docker.com/products/docker-desktop) or [Portainer](https://www.portainer.io) installed.

# Deploy environment
Once you have all git content in your host, execute the following commands (Docker based) where you placed *docker-compose.yaml* file in a terminal window:

`docker-compose -f "docker-compose.yaml" up -d`

> It is not necessary to set -f parameter but to ensure the file is executed.

Chek the output of the command. All container has been deployed properly (all of them `Running` and `Started`):

![Container Deployment images](./_images/container_deployment.png)

You can check all deployements using the following command (check the status is *Up*):

`docker ps`

Ok, all software has been deployed succcesfully, now lets play....

# Accessing portals
These are the available web portals for all software images deployed:

|Application      |Endpoint                           |Comments                                  |
|-----------------|-----------------------------------|------------------------------------------|
|Kowl             |http://localhost:4040              |No login is necessary                     |
|Prometheus       |http://localhost:9090/targets      |Check *state* is `UP`                     |
|Grafana          |http://localhost:3000/             |User & password is "admin" for first time |
|Simple Project   |http://localhost:8888/q/swagger-ui |Play with API Rest endpoint               |

# Tips
- You can find a complete Grafana dashboard into the content. Go to folder `resources/grafana/dashboard-template` and check for file *kafka-metrics.json* to import
- In Grafana, configure a new Data source for Prometheus. Set the following into `URL` field: `http://host.docker.internal:9090`
