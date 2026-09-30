FROM eclipse-temurin:25-jdk

RUN apt-get update \
	&& apt-get install -y --no-install-recommends \
		ca-certificates \
		curl \
		git \
		maven \
		postgresql-client \
		zsh \
		zstd \
	&& rm -rf /var/lib/apt/lists/* \
	&& curl -fsSL https://x.ai/cli/install.sh | bash \
	&& mkdir -p /opt/grok-seed \
	&& cp -a /root/.grok/. /opt/grok-seed/ \
	&& rm -rf /root/.grok \
	&& rm -f /usr/local/bin/grok /usr/local/bin/agent

ENV PATH="/root/.grok/bin:${PATH}"

WORKDIR /workspaces

ENTRYPOINT ["/workspaces/.devcontainer/ensure-grok.sh"]
CMD ["sleep", "infinity"]