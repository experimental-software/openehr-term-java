#!/bin/bash

set -e

SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )

NEW_VERSION=$1

NEW_VERSION_GRADLE="ext['openehrTermVersion'] = '$NEW_VERSION'"
NEW_VERSION_MAVEN="        <openehr.term.version>$NEW_VERSION<\/openehr.term.version>"

perl -pi -e "s/ext\[.*openehrTermVersion.*/$NEW_VERSION_GRADLE/g" $SCRIPT_DIR/../../README.md
perl -pi -e "s/.*<openehr\.term\.version>.*/$NEW_VERSION_MAVEN/g" $SCRIPT_DIR/../../README.md
