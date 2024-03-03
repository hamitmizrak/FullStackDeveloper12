#! /bin/bash
# bash (tercihiniz olsun) ancak bh eskidi

mvn clean verify sonar:sonar \
  -Dsonar.projectKey=spring_boot_sonar \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=sqp_22f1bab250f7a132f4f39d93f4d92e19c0c5b57a