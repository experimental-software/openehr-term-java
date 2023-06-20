#!/bin/bash

set -e

GH_PAGES_DIR=$(mktemp -d)

git clone -b gh-pages --single-branch https://github.com/openehr-java-api/openehr-term-4j.git ${GH_PAGES_DIR}

# Remove old javadocs
if [[ -d $GH_PAGES_DIR/javadocs ]]; then
  rm -r $GH_PAGES_DIR/javadocs
fi
mkdir $GH_PAGES_DIR/javadocs

# Copy new javadocs
find . -name "*javadoc.jar" | while read FILE
do
  SPECIFICATION=$(echo "${FILE}" | perl -pe 's/.\/(.*?)\/.*/$1/')
  unzip "${FILE}" -d "${GH_PAGES_DIR}/javadocs/${SPECIFICATION}"
done

# Commit
git checkout gh-pages
if [[ -d "javadocs" ]]; then
  rm -r javadocs
fi
cp -r $GH_PAGES_DIR/javadocs* .
git add .
git commit -m "Update javadocs"

git push
