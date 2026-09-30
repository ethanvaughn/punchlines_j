#!/usr/bin/env bash

set -euo pipefail

git -C "$HOME/.oh-my-zsh" pull --ff-only

install -m 0644 .devcontainer/.zshrc ~/.zshrc
install -m 0644 .devcontainer/.psqlrc ~/.psqlrc
bash .devcontainer/configure-git.sh

mvn -q -DskipTests package

# Print versions of important tools
echo

echo -n "Java version: "
java -version
echo

echo -n "Maven version: "
mvn -version
echo

echo -n "PostgreSQL version: "
psql -V
echo

if command -v grok >/dev/null 2>&1; then
	echo -n "Grok version: "
	grok --version
	echo
fi
