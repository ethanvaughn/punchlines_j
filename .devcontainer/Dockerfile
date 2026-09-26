FROM eclipse-temurin:25-jdk

RUN apt-get update \
	&& apt-get install -y --no-install-recommends git maven postgresql-client zsh \
	&& rm -rf /var/lib/apt/lists/*

WORKDIR /workspaces