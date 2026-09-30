#!/usr/bin/env bash
# Seed Grok into the persistent home when this container has none, then
# expose it on the default PATH. postStartCommand.sh runs this script.
# The image entrypoint is also this script, because Dev Containers
# replaces the image entrypoint.

set -euo pipefail

grok_home="${HOME}/.grok"

if [[ ! -x "${grok_home}/bin/grok" ]]; then
	if [[ -x /opt/grok-seed/bin/grok ]]; then
		mkdir -p "${grok_home}"
		cp -a /opt/grok-seed/. "${grok_home}/"
	else
		curl -fsSL https://x.ai/cli/install.sh | bash
	fi
fi

ln -sfn "${grok_home}/bin/grok" /usr/local/bin/grok
ln -sfn "${grok_home}/bin/agent" /usr/local/bin/agent

if [[ $# -gt 0 ]]; then
	exec "$@"
fi
