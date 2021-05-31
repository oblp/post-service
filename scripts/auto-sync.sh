#!/usr/bin/env bash

remote='company:desktop/personal/oblp/eastack-article-service/'

if [ $(hostnamectl --static) = 'x1' ]; then
  while true; do
    {
      git ls-files; git ls-files . --exclude-standard --others;
    } | entr -d rsync -avzP --delete --filter=':- .gitignore' ./ $remote
    sleep 1
  done
fi
