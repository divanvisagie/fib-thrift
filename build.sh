#!/bin/sh
cd $CI_HOME/project
sbt ++$TRAVIS_SCALA_VERSION package
